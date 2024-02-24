package com.cmrdev.newsletter.service;

import com.cmrdev.newsletter.exception.ValidationException;
import com.cmrdev.newsletter.model.User;
import com.cmrdev.newsletter.repository.UserRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsletterService {

  private final UserRepository userRepository;
  public List<User> getUsers(){
    return userRepository.findAll();
  }

  public ResponseEntity<String> createUser(User user){
    if(Objects.nonNull(userRepository.findByEmail(user.getEmail()))){
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Already Created");
    }
    user.setUserId(generateUniqueId(user.getEmail()));
    userRepository.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Created");
  }

  public User unsubscribeUser(String email){
    Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(email));

    if (optionalUser.isEmpty()) {
      throw new ValidationException("The email doesn't exists");
    } else if (!optionalUser.get().isSubscribed()) {
      throw new ValidationException("The email is already unsubscribed");
    }
    User user = optionalUser.get();
    user.setSubscribed(false);

    userRepository.save(user);
    return user;
  }

  public User subscribeUser(String email){
    Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(email));

    if (optionalUser.isEmpty()) {
      throw new ValidationException("The email dont exists");
    } else if (optionalUser.get().isSubscribed()) {
      throw new ValidationException("The email is already subscribed");
    }
    User user = optionalUser.get();
    user.setSubscribed(true);

    userRepository.save(user);
    return user;
  }

  public static String generateUniqueId(String email) {
    UUID id = UUID.nameUUIDFromBytes(email.getBytes());
    String str=""+id;
    int uid=str.hashCode();
    String filterStr=""+uid;
    str=filterStr.replaceAll("-", "");
    return str;
  }

}

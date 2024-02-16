package com.cmrdev.newsletter.service;

import com.cmrdev.newsletter.model.User;
import com.cmrdev.newsletter.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsletterService {

  private final UserRepository userRepository;
  public List<User> getUsers(){
    return userRepository.findAll();
  }

}

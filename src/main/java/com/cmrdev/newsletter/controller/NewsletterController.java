package com.cmrdev.newsletter.controller;

import com.cmrdev.newsletter.dto.SendEmailRequest;
import com.cmrdev.newsletter.model.User;
import com.cmrdev.newsletter.service.EmailService;
import com.cmrdev.newsletter.service.NewsletterService;
import jakarta.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NewsletterController {

  private final NewsletterService service;
  private final EmailService emailService;

  @GetMapping(path = "/get-users")
  private List<User> getUsers(){
    return service.getUsers();
  }

  @PostMapping(path = "/user")
  private ResponseEntity<String> createUser(@RequestBody User user){
    return service.createUser(user);
  }

  @PutMapping(path = "/unsubscribe/{userEmail}")
  private User unsubscribeUser(@PathVariable String userEmail){
    return service.unsubscribeUser(userEmail);
  }

  @PutMapping(path = "/subscribe/{userEmail}")
  private User subscribeUser(@PathVariable String userEmail){
    return service.subscribeUser(userEmail);
  }

  @PostMapping(path = "/sendEmail/{userId}")
  private void sendEmail(@RequestBody SendEmailRequest sendEmailRequest, @PathVariable String userId)
      throws MessagingException, IOException {
    emailService.sendEmail(sendEmailRequest, userId);
  }

  @PostMapping(path = "/form-contact")
  private ResponseEntity<Void> sendFormEmailToOwner(@RequestBody SendEmailRequest sendEmailRequest, @PathVariable String userId){
    //emailService.sendEmail(sendEmailRequest, userId);

    return ResponseEntity.ok().build();
  }

  @PatchMapping(path = "/form-contact")
  private ResponseEntity<User> updateUser(@RequestBody SendEmailRequest sendEmailRequest, @PathVariable String userId){
    //emailService.sendEmail(sendEmailRequest, userId);

    return ResponseEntity.ok().build();
  }


}

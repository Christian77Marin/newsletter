package com.cmrdev.newsletter.controller;

import com.cmrdev.newsletter.model.User;
import com.cmrdev.newsletter.service.NewsletterService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NewsletterController {

  private final NewsletterService service;

  @GetMapping(path = "/get-users")
  private List<User> getUsers(){
    return service.getUsers();
  }

  @PostMapping(path = "/user")
  private ResponseEntity<String> createUser(@RequestBody User user){
    return service.createUser(user);
  }


}

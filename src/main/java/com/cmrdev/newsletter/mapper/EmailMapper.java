package com.cmrdev.newsletter.mapper;

import com.cmrdev.newsletter.dto.SendEmailToOwnerRequest;
import com.cmrdev.newsletter.model.User;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

  public User mapToUser(SendEmailToOwnerRequest request){

    List<String> fullnameList = Arrays.stream(request.getName().split(" ")).toList();

    String firstname = fullnameList.get(0);
    String surname = fullnameList.size() > 1 ? fullnameList.get(1) : null;

    return User.builder()
        .email(request.getEmail())
        .name(firstname)
        .surname(surname)
        .phoneNumber(Long.valueOf(request.getPhone()))
        .subscribed(request.isSubscribed())
        .build();
  }

}

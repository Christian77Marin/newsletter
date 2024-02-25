package com.cmrdev.newsletter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "`User`", schema = "newsletter")
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @Column(name = "user_id")
  private String userId;
  private String email;
  private String name;
  private String surname;
  private boolean subscribed;
  @Column(name = "phone_number")
  private Long phoneNumber;
}

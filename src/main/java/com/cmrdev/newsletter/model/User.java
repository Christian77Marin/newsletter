package com.cmrdev.newsletter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "`User`", schema = "newsletter")
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

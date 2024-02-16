package com.cmrdev.newsletter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "User", schema = "newsletter")
public class User {

  @Id
  private String userId;
  private String email;
  private boolean subscribed;
}

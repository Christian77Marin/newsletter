package com.cmrdev.newsletter.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigInteger;
import lombok.Data;
import org.springframework.data.mapping.model.SnakeCaseFieldNamingStrategy;

@Entity
@Data
@Table(name = "`User`", schema = "newsletter")
public class User {

  @Id
  @Column(name = "user_id")
  private String userId;
  private String email;
  private boolean subscribed;
}

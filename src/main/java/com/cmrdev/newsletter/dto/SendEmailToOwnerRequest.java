package com.cmrdev.newsletter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SendEmailToOwnerRequest {
  private String subject;
  private String email;
  private String name;
  private String phone;
  private String message;
  private boolean subscribed;
}

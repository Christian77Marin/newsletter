package com.cmrdev.newsletter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SendEmailRequest {
  private String subject;
  private String bodyContent;
}

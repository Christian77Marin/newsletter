package com.cmrdev.newsletter.service;

import com.cmrdev.newsletter.dto.SendEmailRequest;
import com.cmrdev.newsletter.model.User;
import com.cmrdev.newsletter.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

  private final JavaMailSender mailSender;
  private final UserRepository userRepository;

  public void sendEmail(SendEmailRequest sendEmailRequest, String userId)
      throws MessagingException, IOException {
    MimeMessage message = mailSender.createMimeMessage();

    User user = userRepository.findById(userId).orElseThrow();

    message.setRecipients(MimeMessage.RecipientType.TO, user.getEmail());
    message.setSubject(sendEmailRequest.getSubject());

    String htmlTemplate = Files.readString(Paths.get("src/main/resources/templates/EmailTemplate.html"));


    String fullName = user.getName() + (user.getSurname().isEmpty() ? "" : " " + user.getSurname());

    htmlTemplate = htmlTemplate.replace("${name}", fullName);
    htmlTemplate = htmlTemplate.replace("${body}", sendEmailRequest.getBodyContent());
    htmlTemplate = htmlTemplate.replace("${subject}", sendEmailRequest.getSubject());


    message.setContent(htmlTemplate, "text/html; charset=utf-8");

    mailSender.send(message);
  }
}

package com.cmrdev.newsletter.service;

import com.cmrdev.newsletter.dto.SendEmailRequest;
import com.cmrdev.newsletter.model.User;
import com.cmrdev.newsletter.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

  private final JavaMailSender mailSender;
  private final UserRepository userRepository;

  private static final String SPACE = " ";

  public void sendEmail(SendEmailRequest sendEmailRequest, String userId)
      throws MessagingException, IOException {
    MimeMessage message = mailSender.createMimeMessage();

    User user = userRepository.findById(userId).orElseThrow();

    message.setRecipients(MimeMessage.RecipientType.TO, user.getEmail());
    message.setSubject(sendEmailRequest.getSubject());

    String htmlTemplate = Files.readString(Paths.get("src/main/resources/templates/EmailTemplate.html"));
    String cssTemplate = Files.readString(Paths.get("src/main/resources/templates/styles/styles.css"));


    String fullName = Stream.of(user.getName(), user.getSurname())
        .filter(StringUtils::isNotEmpty)
        .map(String::trim)
        .collect(Collectors.joining(SPACE));

    htmlTemplate = htmlTemplate.replace("${name}", fullName);
    htmlTemplate = htmlTemplate.replace("${body}", sendEmailRequest.getBodyContent());
    htmlTemplate = htmlTemplate.replace("${subject}", sendEmailRequest.getSubject());
    htmlTemplate = htmlTemplate.replace("${styles}", cssTemplate);


    message.setContent(htmlTemplate, "text/html; charset=utf-8");

    mailSender.send(message);
  }
}

package com.cmrdev.newsletter.utils;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class Utils {

  public static String generateUniqueId(String email) {
    UUID id = UUID.nameUUIDFromBytes(email.getBytes());
    String str= "" + id;
    int uid = str.hashCode();
    String filterStr = "" + uid;
    str = filterStr.replaceAll("-", "");
    return str;
  }
}

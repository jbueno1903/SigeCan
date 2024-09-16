package com.seek.SigeCan.security.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * SecurityUtil.
 * Description.
 *
 * @author : VUCE (Ventanilla Única de Comercio Electrónico)
 * @version : 2.0 , 5/06/24
 * @since : 2.0
 */
@Slf4j
public class SecurityUtil {

  private SecurityUtil() {
    throw new IllegalStateException("Utility class");
  }

  public static Authentication getAuthentication() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null) {
      log.error("Authentication credentials not found on this thread");
      throw new AuthenticationServiceException("no user logged!");
    }
    return auth;
  }
}

package com.seek.SigeCan.security.jwt.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;

/**
 * VuceUnauthorizedEntryPoint.
 * Description.
 *
 * @author : VUCE (Ventanilla Única de Comercio Electrónico)
 * @version : 2.0 , 5/06/24
 * @since : 2.0
 */
@Component
public class SigecanUnauthorizedEntryPoint implements AuthenticationEntryPoint, Serializable {
  private static final long serialVersionUID = -8970718410437077606L;

  @Override
  public void commence(HttpServletRequest request,
                       HttpServletResponse response,
                       AuthenticationException authException) throws IOException {
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
  }
}

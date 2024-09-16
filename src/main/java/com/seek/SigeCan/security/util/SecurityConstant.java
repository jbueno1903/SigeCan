package com.seek.SigeCan.security.util;

/**
 * SecurityConstant
 * Description.
 *
 * @author : VUCE (Ventanilla Única de Comercio Electrónico)
 * @version : 2.0 , 14/08/2024
 * @since : 2.0
 */
public class SecurityConstant {
  public static final String[] AUTH_WHITELIST = {
      // -- swagger ui
      "/v2/api-docs",
      "/v3/api-docs",
      "/swagger-resources",
      "/swagger-resources/**",
      "/swagger-ui",
      "/swagger-ui/**",
      "/swagger-ui.html",
  };
}

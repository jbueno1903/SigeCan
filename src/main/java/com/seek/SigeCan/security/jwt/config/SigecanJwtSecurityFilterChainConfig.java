package com.seek.SigeCan.security.jwt.config;

import com.seek.SigeCan.security.jwt.filter.SigecanJwtAuthenticationFilter;
import com.seek.SigeCan.security.jwt.properties.SigecanJwtProperties;
import com.seek.SigeCan.security.util.SecurityConstant;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SigecanJwtSecurityFilterChainConfig.
 * Description.
 *
 * @author : Julio Bueno
 * @version : 1.0 , 15/09/2024
 * @since : 1.0
 */
@Configuration
public class SigecanJwtSecurityFilterChainConfig {
  private final SigecanUnauthorizedEntryPoint sigecanUnauthorizedEntryPoint;
  private final SigecanJwtAuthenticationFilter sigecanJwtAuthenticationFilter;
  private final SigecanJwtProperties sigecanJwtProperties;

  public SigecanJwtSecurityFilterChainConfig(SigecanUnauthorizedEntryPoint sigecanUnauthorizedEntryPoint,
                                             SigecanJwtAuthenticationFilter sigecanJwtAuthenticationFilter,
                                             SigecanJwtProperties sigecanJwtProperties) {
    this.sigecanUnauthorizedEntryPoint = sigecanUnauthorizedEntryPoint;
    this.sigecanJwtAuthenticationFilter = sigecanJwtAuthenticationFilter;
    this.sigecanJwtProperties = sigecanJwtProperties;
  }

  @Bean("jwtSecurityFilterChain")
  @ConditionalOnProperty(
      prefix = "app.web.security.jwt",
      name = "enable",
      havingValue = "true")
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(authorizeRequests -> {
          authorizeRequests
              .requestMatchers(SecurityConstant.AUTH_WHITELIST).permitAll()
              .requestMatchers("/api/excluded/**").permitAll()
              .requestMatchers("/management/**").permitAll()
              .requestMatchers("/actuator/**").permitAll();
          for (String path : sigecanJwtProperties.getDynamicPathsExcluded()) {
            authorizeRequests.requestMatchers(path).permitAll();
          }
          authorizeRequests.anyRequest().authenticated();
        })
        .exceptionHandling(exceptionHandling ->
            exceptionHandling.authenticationEntryPoint(this.sigecanUnauthorizedEntryPoint))
        .sessionManagement(sessionManagement ->
            sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(this.sigecanJwtAuthenticationFilter,
            UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}

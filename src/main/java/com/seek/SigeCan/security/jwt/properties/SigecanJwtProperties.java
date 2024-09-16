package com.seek.SigeCan.security.jwt.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "app.web.security.jwt", ignoreInvalidFields = true)
public class SigecanJwtProperties {
  private String base64Secret;
  private long tokenValidityInSeconds;
  private long refreshTokenValidityInSeconds;
  private byte[] propagationDataKey;
  private String enable;
  private List<String> dynamicPathsExcluded;
}

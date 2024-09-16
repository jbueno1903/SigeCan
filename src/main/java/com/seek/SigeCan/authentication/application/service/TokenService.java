package com.seek.SigeCan.authentication.application.service;

import com.seek.SigeCan.authentication.application.usecase.GenerateTokenUseCase;
import com.seek.SigeCan.authentication.infrastructure.out.persistence.entity.UserEntityJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Clase JwtAuthenticationService Description.
 *
 * @author : Julio Bueno (jbueno1903@gmail.com)
 * @version : 1.0 , 9/08/24
 * @since : 1.0
 */
@Service
@RequiredArgsConstructor
public class TokenService {
  private final GenerateTokenUseCase generateTokenUseCase;

  public String getToken(UserEntityJpa userEntityJpa) {
    return generateTokenUseCase.getToken(userEntityJpa);
  }
}

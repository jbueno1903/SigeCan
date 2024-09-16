package com.seek.SigeCan.authentication.application.service;

import com.seek.SigeCan.authentication.application.usecase.RetrieveSessionUseCase;
import com.seek.SigeCan.authentication.domain.bean.SessionBody;
import com.seek.SigeCan.authentication.infrastructure.out.persistence.entity.UserEntityJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Clase JwtSessionService Description.
 *
 * @author : Julio Bueno (jbueno1903@gmail.com)
 * @version : 1.0 , 9/08/24
 * @since : 1.0
 */
@Service
public class SessionUserService {
  private final RetrieveSessionUseCase retrieveSessionUseCase;

  public SessionUserService(RetrieveSessionUseCase retrieveSessionUseCase){
    this.retrieveSessionUseCase = retrieveSessionUseCase;
  }

  public UserEntityJpa getUserInfo(SessionBody sessionBody) {
    return retrieveSessionUseCase.getUserSession(sessionBody);
  }
}

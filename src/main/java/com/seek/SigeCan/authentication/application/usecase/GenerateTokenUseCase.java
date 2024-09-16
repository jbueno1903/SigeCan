package com.seek.SigeCan.authentication.application.usecase;

import com.seek.SigeCan.authentication.infrastructure.out.persistence.entity.UserEntityJpa;

public interface GenerateTokenUseCase {
    String getToken(UserEntityJpa userEntityJpa);
}

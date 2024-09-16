package com.seek.SigeCan.authentication.application.usecase;

import com.seek.SigeCan.authentication.domain.bean.SessionBody;
import com.seek.SigeCan.authentication.infrastructure.out.persistence.entity.UserEntityJpa;

public interface RetrieveSessionUseCase {
    UserEntityJpa getUserSession(SessionBody sessionBody);
}

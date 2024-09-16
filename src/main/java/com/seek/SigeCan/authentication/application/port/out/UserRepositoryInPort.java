package com.seek.SigeCan.authentication.application.port.out;

import com.seek.SigeCan.authentication.domain.bean.SessionBody;
import com.seek.SigeCan.authentication.infrastructure.out.persistence.entity.UserEntityJpa;

public interface UserRepositoryInPort {
    UserEntityJpa getUserSessionInfo(SessionBody sessionBody);
}

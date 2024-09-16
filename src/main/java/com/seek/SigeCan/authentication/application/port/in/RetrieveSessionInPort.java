package com.seek.SigeCan.authentication.application.port.in;

import com.seek.SigeCan.authentication.application.port.out.UserRepositoryInPort;
import com.seek.SigeCan.authentication.application.usecase.RetrieveSessionUseCase;
import com.seek.SigeCan.authentication.domain.bean.SessionBody;
import com.seek.SigeCan.authentication.infrastructure.out.persistence.entity.UserEntityJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RetrieveSessionInPort implements RetrieveSessionUseCase {

    private final UserRepositoryInPort userRepositoryInPort;

    public RetrieveSessionInPort(UserRepositoryInPort userRepositoryInPort){
        this.userRepositoryInPort = userRepositoryInPort;
    }

    @Override
    public UserEntityJpa getUserSession(SessionBody sessionBody) {
        return userRepositoryInPort.getUserSessionInfo(sessionBody);
    }
}

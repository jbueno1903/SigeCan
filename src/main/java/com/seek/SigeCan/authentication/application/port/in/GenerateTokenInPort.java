package com.seek.SigeCan.authentication.application.port.in;

import com.seek.SigeCan.authentication.application.usecase.GenerateTokenUseCase;
import com.seek.SigeCan.authentication.infrastructure.out.persistence.entity.UserEntityJpa;
import com.seek.SigeCan.security.jwt.provider.SigecanJwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenerateTokenInPort implements GenerateTokenUseCase {
    private final SigecanJwtTokenProvider sigecanJwtTokenProvider;

    public GenerateTokenInPort(SigecanJwtTokenProvider sigecanJwtTokenProvider){
        this.sigecanJwtTokenProvider = sigecanJwtTokenProvider;
    }

    @Override
    public String getToken(UserEntityJpa userEntityJpa) {
        return sigecanJwtTokenProvider.generateToken(userEntityJpa);
    }
}

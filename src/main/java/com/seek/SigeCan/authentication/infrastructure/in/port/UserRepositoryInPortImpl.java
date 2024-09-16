package com.seek.SigeCan.authentication.infrastructure.in.port;

import com.seek.SigeCan.authentication.application.port.out.UserRepositoryInPort;
import com.seek.SigeCan.authentication.domain.bean.SessionBody;
import com.seek.SigeCan.authentication.infrastructure.out.persistence.entity.UserEntityJpa;
import com.seek.SigeCan.authentication.infrastructure.out.persistence.repository.UserRepository;
import com.seek.SigeCan.shared.util.Constants;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryInPortImpl implements UserRepositoryInPort {
    private final UserRepository userRepository;
    public UserRepositoryInPortImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserEntityJpa getUserSessionInfo(SessionBody sessionBody){
        return userRepository.findByUserNameAndSessionIdAndState(sessionBody.getUserName(),sessionBody.getSessionId(), Constants.ACTIVE_STATE);
    }
}

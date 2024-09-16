package com.seek.SigeCan.authentication.infrastructure.out.persistence.repository;

import com.seek.SigeCan.authentication.infrastructure.out.persistence.entity.UserEntityJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntityJpa,Long> {
    UserEntityJpa findByUserNameAndSessionIdAndState(String userName, String sessionId, Long state);
}

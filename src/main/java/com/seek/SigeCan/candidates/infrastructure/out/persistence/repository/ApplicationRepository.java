package com.seek.SigeCan.candidates.infrastructure.out.persistence.repository;

import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationEntityJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<ApplicationEntityJpa,Long> {
}

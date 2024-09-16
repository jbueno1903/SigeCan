package com.seek.SigeCan.candidates.infrastructure.out.persistence.repository;

import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationStatusEvoEntityJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationStatusEvoRepository extends JpaRepository<ApplicationStatusEvoEntityJpa, Long> {
}

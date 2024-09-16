package com.seek.SigeCan.candidates.infrastructure.out.persistence.repository;

import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationEvaluationEntityJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationEvaluationRepository extends JpaRepository<ApplicationEvaluationEntityJpa,Long> {
}

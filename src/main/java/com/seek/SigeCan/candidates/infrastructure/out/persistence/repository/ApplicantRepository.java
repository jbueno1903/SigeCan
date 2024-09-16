package com.seek.SigeCan.candidates.infrastructure.out.persistence.repository;

import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicantEntityJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<ApplicantEntityJpa, Long> {
}

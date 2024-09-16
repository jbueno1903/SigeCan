package com.seek.SigeCan.candidates.infrastructure.out.persistence.repository;

import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.JobEntityJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntityJpa,Long> {
}

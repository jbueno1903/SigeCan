package com.seek.SigeCan.candidates.application.usecase;

import com.seek.SigeCan.candidates.domain.dto.ApplicantDto;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicantEntityJpa;

import java.util.List;

public interface CandidateReadUseCase {
    List<ApplicantDto> getAllCandidates();
    ApplicantEntityJpa getCandidateById(Long id);
}

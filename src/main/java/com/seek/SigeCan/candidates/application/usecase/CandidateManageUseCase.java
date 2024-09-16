package com.seek.SigeCan.candidates.application.usecase;

import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicantEntityJpa;

public interface CandidateManageUseCase {
    ApplicantEntityJpa updateApplicantState(ApplicantEntityJpa applicantEntityJpa);
}

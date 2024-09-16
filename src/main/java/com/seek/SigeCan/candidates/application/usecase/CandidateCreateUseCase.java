package com.seek.SigeCan.candidates.application.usecase;

import com.seek.SigeCan.candidates.domain.bean.ApplicantBodyPost;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicantEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationStatusEvoEntityJpa;

import java.util.Date;

public interface CandidateCreateUseCase {
    ApplicantEntityJpa registerCandidate(ApplicantBodyPost applicantBodyPost, Date regDate, Long createUsu);
    ApplicationEntityJpa registerApplicationForNewCandidate(Long jobId, Long applicantId, Date dateApplication, Long createUser);
    ApplicationStatusEvoEntityJpa registerStatusEvoForNewApplication(Long applicantId, Long statusId, Date dateApplication);

}

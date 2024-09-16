package com.seek.SigeCan.candidates.application.port.out;

import com.seek.SigeCan.candidates.domain.bean.ApplicantBodyPost;
import com.seek.SigeCan.candidates.domain.dto.ApplicantDto;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicantEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationStatusEvoEntityJpa;

import java.util.Date;
import java.util.List;

public interface CandidateRepositoryOutPort {
    List<ApplicantEntityJpa> getAllCandidates();
    ApplicantEntityJpa registerCandidate(ApplicantBodyPost applicantBody, Date regDate, Long usuCreate);
    ApplicationEntityJpa registerApplication(Long jobId, Long applicantId, Date dateApplication, Long createUser);
    ApplicationStatusEvoEntityJpa registerApplicationStatusEvo(Long applicantId, Long statusId, Date dateApplication);
    ApplicantEntityJpa getApplicantById(Long id);
    ApplicantEntityJpa updateApplicantState(ApplicantEntityJpa applicantEntityJpa);
}

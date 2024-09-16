package com.seek.SigeCan.candidates.application.port.in;

import com.seek.SigeCan.candidates.application.port.out.CandidateRepositoryOutPort;
import com.seek.SigeCan.candidates.application.usecase.CandidateCreateUseCase;
import com.seek.SigeCan.candidates.domain.bean.ApplicantBodyPost;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicantEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationStatusEvoEntityJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class CreateCandidateInformationInPort implements CandidateCreateUseCase {
    private final CandidateRepositoryOutPort candidateRepositoryOutPort;

    public CreateCandidateInformationInPort(CandidateRepositoryOutPort candidateRepositoryOutPort){
        this.candidateRepositoryOutPort = candidateRepositoryOutPort;
    }
    @Override
    public ApplicantEntityJpa registerCandidate(ApplicantBodyPost applicantBodyPost, Date regDate, Long createUsu) {
        return candidateRepositoryOutPort.registerCandidate(applicantBodyPost, regDate, createUsu);
    }
    @Override
    public ApplicationEntityJpa registerApplicationForNewCandidate(Long jobId, Long applicantId, Date dateApplication, Long createUser){
        return candidateRepositoryOutPort.registerApplication(jobId,applicantId,dateApplication,createUser);
    }
    @Override
    public ApplicationStatusEvoEntityJpa registerStatusEvoForNewApplication(Long applicantId, Long statusId, Date dateApplication){
        return candidateRepositoryOutPort.registerApplicationStatusEvo(applicantId,statusId,dateApplication);
    }
}

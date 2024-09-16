package com.seek.SigeCan.candidates.application.port.in;

import com.seek.SigeCan.candidates.application.port.out.CandidateRepositoryOutPort;
import com.seek.SigeCan.candidates.application.usecase.CandidateManageUseCase;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicantEntityJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ManageCandidateInformationInPort implements CandidateManageUseCase {

    private final CandidateRepositoryOutPort candidateRepositoryOutPort;

    public ManageCandidateInformationInPort(CandidateRepositoryOutPort candidateRepositoryOutPort){
        this.candidateRepositoryOutPort = candidateRepositoryOutPort;
    }

    @Override
    public ApplicantEntityJpa updateApplicantState(ApplicantEntityJpa applicantEntityJpa) {
        return candidateRepositoryOutPort.updateApplicantState(applicantEntityJpa);
    }
}

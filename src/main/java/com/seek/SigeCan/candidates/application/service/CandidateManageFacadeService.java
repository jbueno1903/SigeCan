package com.seek.SigeCan.candidates.application.service;

import com.seek.SigeCan.candidates.application.usecase.CandidateCreateUseCase;
import com.seek.SigeCan.candidates.application.usecase.CandidateManageUseCase;
import com.seek.SigeCan.candidates.application.usecase.CandidateReadUseCase;
import com.seek.SigeCan.candidates.domain.bean.ApplicantBodyPost;
import com.seek.SigeCan.candidates.domain.dto.ApplicantDto;
import com.seek.SigeCan.candidates.domain.model.CandidateResponseModel;
import com.seek.SigeCan.candidates.infrastructure.in.mappers.CandidateResponseMapper;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicantEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationStatusEvoEntityJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CandidateManageFacadeService {
    private final CandidateReadUseCase candidateReadUseCase;
    private final CandidateCreateUseCase candidateCreateUseCase;
    private final CandidateManageUseCase candidateManageUseCase;
    public CandidateManageFacadeService(CandidateReadUseCase candidateReadUseCase,
                                        CandidateCreateUseCase candidateCreateUseCase,
                                        CandidateManageUseCase candidateManageUseCase){
        this.candidateReadUseCase = candidateReadUseCase;
        this.candidateCreateUseCase = candidateCreateUseCase;
        this.candidateManageUseCase = candidateManageUseCase;
    }

    public List<CandidateResponseModel> getAllCandidates(){
        return candidateReadUseCase.getAllCandidates().stream()
                .map(CandidateResponseMapper.INSTANCE::mapDtoToModel)
                .collect(Collectors.toList());
    }

    public ApplicantEntityJpa registerApplicant(ApplicantBodyPost applicantBodyPost, Date regDate, Long createUsu){
        return candidateCreateUseCase.registerCandidate(applicantBodyPost, regDate, createUsu);
    }

    public ApplicationEntityJpa registerApplication(Long jobId, Long applicantId, Date dateApplication, Long createUsu){
        return candidateCreateUseCase.registerApplicationForNewCandidate(jobId,applicantId,dateApplication, createUsu);
    }

    public ApplicationStatusEvoEntityJpa registerStatusEvo(Long applicantId, Long statusId, Date dateApplication){
        return candidateCreateUseCase.registerStatusEvoForNewApplication(applicantId,statusId,dateApplication);
    }

    public ApplicantEntityJpa getCandidateById(Long id){
        return candidateReadUseCase.getCandidateById(id);
    }

    public ApplicantEntityJpa updateCandidateState(ApplicantEntityJpa applicantEntityJpa){
        return candidateManageUseCase.updateApplicantState(applicantEntityJpa);
    }
}

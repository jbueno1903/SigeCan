package com.seek.SigeCan.candidates.application.port.in;

import com.seek.SigeCan.candidates.application.port.out.CandidateRepositoryOutPort;
import com.seek.SigeCan.candidates.application.usecase.CandidateReadUseCase;
import com.seek.SigeCan.candidates.domain.dto.ApplicantDto;
import com.seek.SigeCan.candidates.infrastructure.in.mappers.CandidateResponseMapper;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicantEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.mappers.ApplicantEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class RetrieveCandidateInformationInPort implements CandidateReadUseCase {

    private final CandidateRepositoryOutPort candidateRepositoryOutPort;

    public RetrieveCandidateInformationInPort(CandidateRepositoryOutPort candidateRepositoryOutPort){
        this.candidateRepositoryOutPort = candidateRepositoryOutPort;
    }

    @Override
    public List<ApplicantDto> getAllCandidates() {
        return candidateRepositoryOutPort.getAllCandidates().stream()
                .map(ApplicantEntityMapper.INSTANCE::mapEntityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicantEntityJpa getCandidateById(Long id){
        return candidateRepositoryOutPort.getApplicantById(id);
    }
}

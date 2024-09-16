package com.seek.SigeCan.candidates.infrastructure.in.mappers;

import com.seek.SigeCan.candidates.domain.dto.ApplicantDto;
import com.seek.SigeCan.candidates.domain.model.CandidateResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CandidateResponseMapper {
    CandidateResponseMapper INSTANCE = Mappers.getMapper(CandidateResponseMapper.class);
    CandidateResponseModel mapDtoToModel(ApplicantDto candidate);
}

package com.seek.SigeCan.candidates.infrastructure.out.persistence.mappers;

import com.seek.SigeCan.candidates.domain.dto.ApplicantDto;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicantEntityJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicantEntityMapper {
    ApplicantEntityMapper INSTANCE = Mappers.getMapper(ApplicantEntityMapper.class);
    ApplicantDto mapEntityToDomain(ApplicantEntityJpa applicantEntityJpa);
}

package com.seek.SigeCan.candidates.infrastructure.in.port;

import com.seek.SigeCan.candidates.application.port.out.CandidateRepositoryOutPort;
import com.seek.SigeCan.candidates.domain.bean.ApplicantBodyPost;
import com.seek.SigeCan.candidates.domain.dto.ApplicantDto;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicantEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationStatusEvoEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.repository.ApplicantRepository;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.repository.ApplicationRepository;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.repository.ApplicationStatusEvoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Slf4j
public class CandidateRepositoryOutPortImpl implements CandidateRepositoryOutPort {

    private final ApplicantRepository applicantRepository;
    private final ApplicationRepository applicationRepository;
    private final ApplicationStatusEvoRepository applicationStatusEvoRepository;

    public CandidateRepositoryOutPortImpl(ApplicantRepository applicantRepository,
                                          ApplicationRepository applicationRepository,
                                          ApplicationStatusEvoRepository applicationStatusEvoRepository){
        this.applicantRepository = applicantRepository;
        this.applicationRepository = applicationRepository;
        this.applicationStatusEvoRepository = applicationStatusEvoRepository;
    }
    @Override
    public List<ApplicantEntityJpa> getAllCandidates() {
        return applicantRepository.findAll();
    }

    @Override
    public ApplicantEntityJpa registerCandidate(ApplicantBodyPost applicantBody, Date regDate, Long usuCreate){
        ApplicantEntityJpa applicantEntityJpa = new ApplicantEntityJpa();
        applicantEntityJpa.setFirstName(applicantBody.getFirstName());
        applicantEntityJpa.setLastName(applicantBody.getLastName());
        applicantEntityJpa.setEmail(applicantBody.getEmail());
        applicantEntityJpa.setPhoneNumber(applicantBody.getPhoneNumber());
        applicantEntityJpa.setProfileUrl1(applicantBody.getProfileUrl1());
        applicantEntityJpa.setProfileUrl2(applicantBody.getProfileUrl2());
        applicantEntityJpa.setSummary(applicantBody.getSummary());
        applicantEntityJpa.setGender(applicantBody.getGender());
        applicantEntityJpa.setSalaryExpected(Double.parseDouble(applicantBody.getSalaryExpected()));
        applicantEntityJpa.setState(1L);
        applicantEntityJpa.setDateCreate(regDate);
        applicantEntityJpa.setUserCreate(usuCreate);
        return applicantRepository.save(applicantEntityJpa);
    }

    @Override
    public ApplicationEntityJpa registerApplication(Long jobId, Long applicantId, Date dateApplication, Long createUser){
        ApplicationEntityJpa applicationEntityJpa = new ApplicationEntityJpa();
        applicationEntityJpa.setApplicantId(applicantId);
        applicationEntityJpa.setDateApplication(dateApplication);
        applicationEntityJpa.setJobId(jobId);
        applicationEntityJpa.setDateCreate(new Date());
        applicationEntityJpa.setUserCreate(createUser);
        applicationEntityJpa.setState(1L);
        return applicationRepository.save(applicationEntityJpa);
    }

    @Override
    public ApplicationStatusEvoEntityJpa registerApplicationStatusEvo(Long applicantId, Long statusId, Date dateApplication){
        ApplicationStatusEvoEntityJpa applicationStatusEvoEntityJpa = new ApplicationStatusEvoEntityJpa();
        applicationStatusEvoEntityJpa.setApplicationId(applicantId);
        applicationStatusEvoEntityJpa.setApplicationStatusId(statusId);
        applicationStatusEvoEntityJpa.setDateRegistered(dateApplication);
        return applicationStatusEvoRepository.save(applicationStatusEvoEntityJpa);
    }

    @Override
    public ApplicantEntityJpa getApplicantById(Long id){
        return applicantRepository.getById(id);
    }

    @Override
    public ApplicantEntityJpa updateApplicantState(ApplicantEntityJpa applicantEntityJpa) {
        return applicantRepository.save(applicantEntityJpa);
    }
}

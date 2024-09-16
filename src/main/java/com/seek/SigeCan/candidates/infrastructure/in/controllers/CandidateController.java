package com.seek.SigeCan.candidates.infrastructure.in.controllers;

import com.seek.SigeCan.candidates.application.service.CandidateManageFacadeService;
import com.seek.SigeCan.candidates.domain.bean.ApplicantBodyPost;
import com.seek.SigeCan.candidates.domain.model.CandidateResponseModel;
import com.seek.SigeCan.candidates.domain.model.ResponseModel;
import com.seek.SigeCan.candidates.domain.wrapper.CandidateResponseModelWrapper;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicantEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationEntityJpa;
import com.seek.SigeCan.candidates.infrastructure.out.persistence.entity.ApplicationStatusEvoEntityJpa;
import com.seek.SigeCan.shared.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * CandidateController. Manage candidate information.
 *
 * @author : Julio Bueno
 * @version : 1.0 , 14/09/2024
 * @since : 1.0
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {
    private final CandidateManageFacadeService candidateManageFacadeService;

    public CandidateController(CandidateManageFacadeService candidateManageFacadeService){
        this.candidateManageFacadeService = candidateManageFacadeService;
    }
    @GetMapping("/findAll")
    public ResponseEntity<ResponseModel> getAllCandidates(){
        List<CandidateResponseModel> listaCandidatos =  candidateManageFacadeService.getAllCandidates();
        ResponseModel responseModel = new ResponseModel();
        if( listaCandidatos != null && !listaCandidatos.isEmpty() ){
            responseModel.setCode(HttpStatus.OK.value());
            responseModel.setMessage(HttpStatus.OK.getReasonPhrase());
            responseModel.setDescription(Constants.MSG_DATA_FOUND);
            CandidateResponseModelWrapper wrapper = new CandidateResponseModelWrapper();
            wrapper.addAll(listaCandidatos);
            responseModel.setData(wrapper);
        } else {
            responseModel.setCode(HttpStatus.NOT_FOUND.value());
            responseModel.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
            responseModel.setDescription(Constants.MSG_DATA_NOT_FOUND);
        }
        return new ResponseEntity<ResponseModel>(
                responseModel, HttpStatus.valueOf(responseModel.getCode()));

    }

    @PostMapping("/registerApplicant")
    public ResponseEntity<ResponseModel> registerApplicant(
            @RequestBody ApplicantBodyPost body
    ){
        Date nDate = new Date();
        Long usuCreate = 1L;
        try{
            ApplicantEntityJpa applicantEntityJpa = candidateManageFacadeService.registerApplicant(
                    body, nDate, usuCreate
            );
            ApplicationEntityJpa applicationEntityJpa = candidateManageFacadeService.registerApplication(
                    Long.parseLong(body.getJobId()), applicantEntityJpa.getId(), nDate, usuCreate
            );
            ApplicationStatusEvoEntityJpa applicationStatusEvoEntityJpa = candidateManageFacadeService.registerStatusEvo(
                    applicationEntityJpa.getId(), 1L, nDate
            );

            ResponseModel responseModel = new ResponseModel();
            responseModel.setCode(HttpStatus.OK.value());
            responseModel.setMessage(HttpStatus.OK.getReasonPhrase());
            responseModel.setDescription(Constants.MSG_SUCCESFUL_REGISTER);
            return new ResponseEntity<ResponseModel>(
                    responseModel, HttpStatus.valueOf(responseModel.getCode()));
        }catch(Exception ex){
            ResponseModel responseModel = new ResponseModel();
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseModel.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            responseModel.setDescription(Constants.MSG_UNSUCCESFUL_REGISTER);
            return new ResponseEntity<ResponseModel>(
                    responseModel, HttpStatus.valueOf(responseModel.getCode()));
        }
    }

    @PutMapping("/dropApplicant/{id}")
    public ResponseEntity<ResponseModel> dropApplicant(
            @PathVariable Long id
    ){
        ApplicantEntityJpa applicantEntityJpa = candidateManageFacadeService.getCandidateById(id);
        applicantEntityJpa.setState(0L);
        applicantEntityJpa.setDateUpdate(new Date());
        applicantEntityJpa.setUserUpdate(1L);
        ApplicantEntityJpa updateDataApplicant = candidateManageFacadeService.updateCandidateState(applicantEntityJpa);
        ResponseModel responseModel = new ResponseModel();
        if( updateDataApplicant != null ){

            responseModel.setCode(HttpStatus.OK.value());
            responseModel.setMessage(HttpStatus.OK.getReasonPhrase());
            responseModel.setDescription(Constants.MSG_SUCCESFUL_UPDATE);

        } else {
            responseModel.setCode(HttpStatus.OK.value());
            responseModel.setMessage(HttpStatus.OK.getReasonPhrase());
            responseModel.setDescription(Constants.MSG_UNSUCCESFUL_UPDATE);

        }
        return new ResponseEntity<ResponseModel>(
                responseModel, HttpStatus.valueOf(responseModel.getCode()));
    }
}

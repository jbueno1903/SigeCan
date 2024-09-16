package com.seek.SigeCan.candidates.infrastructure.in.api.controllers;

import com.seek.SigeCan.authentication.infrastructure.out.persistence.entity.UserEntityJpa;
import com.seek.SigeCan.candidates.application.service.CandidateManageFacadeService;
import com.seek.SigeCan.candidates.domain.model.CandidateResponseModel;
import com.seek.SigeCan.candidates.infrastructure.in.controllers.CandidateController;
import com.seek.SigeCan.security.jwt.dto.SigecanUserJwt;
import com.seek.SigeCan.security.jwt.provider.SigecanJwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = CandidateController.class)
@ExtendWith(MockitoExtension.class)
public class CandidateControllerTest {
    @Autowired
    SigecanJwtTokenProvider sigecanJwtTokenProvider;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CandidateManageFacadeService candidateManageFacadeService;

    private String token;
    private List<CandidateResponseModel> listCandidates;


    @BeforeEach
    void init() {
        UserEntityJpa userEntityJpa = new UserEntityJpa();
        userEntityJpa.setId(3L);
        userEntityJpa.setUserName("SECURITY");
        userEntityJpa.setSessionId("abc123456780$2024$===");
        this.token = sigecanJwtTokenProvider.generateToken(userEntityJpa);

        this.listCandidates = new ArrayList<CandidateResponseModel>();
        CandidateResponseModel candidateResponseModel = new CandidateResponseModel();
        candidateResponseModel.setId(1L);
        candidateResponseModel.setEmail("prueba@correo.com");
        this.listCandidates.add(candidateResponseModel);
    }

    @Test
    @DisplayName("Test searching all the applicants")
    public void findAllApplicants_when_receive_OK_response_test() throws Exception {
        given(candidateManageFacadeService.getAllCandidates())
                .willReturn(this.listCandidates);

        ResultActions response =
                mockMvc.perform(
                        get("/candidate/findAll")
                                .accept(MediaType.APPLICATION_JSON)
                                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token));
        response.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Test searching all the applicants - Error")
    public void findAllApplicants_when_receive_ERROR_response_test() throws Exception {
        given(candidateManageFacadeService.getAllCandidates())
                .willReturn(null);

        ResultActions response =
                mockMvc.perform(
                        get("/candidate/findAll")
                                .accept(MediaType.APPLICATION_JSON)
                                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token));
        response.andExpect(MockMvcResultMatchers.status().isInternalServerError()).andDo(MockMvcResultHandlers.print());
    }

}

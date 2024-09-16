package com.seek.SigeCan.authentication.infrastructure.in.controllers;

import com.seek.SigeCan.authentication.application.service.SessionUserService;
import com.seek.SigeCan.authentication.application.service.TokenService;
import com.seek.SigeCan.authentication.domain.bean.SessionBody;
import com.seek.SigeCan.authentication.domain.model.TokenModelResponse;
import com.seek.SigeCan.authentication.infrastructure.out.persistence.entity.UserEntityJpa;
import com.seek.SigeCan.candidates.domain.bean.ApplicantBodyPost;
import com.seek.SigeCan.candidates.domain.model.ResponseModel;
import com.seek.SigeCan.shared.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Class AuthenticationController Description.
 *
 * @author : Julio Bueno
 * @version : 1.0 , 14/09/2024
 * @since : 1.0
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {

  private final TokenService tokenService;
  private final SessionUserService sessionUserService;

  public AuthenticationController(SessionUserService sessionUserService,
                                  TokenService tokenService){
    this.sessionUserService = sessionUserService;
    this.tokenService = tokenService;
  }

  @PostMapping("/token")
  public ResponseEntity<TokenModelResponse> getToken(
      @RequestBody SessionBody body) {

    UserEntityJpa userEntityJpa = sessionUserService.getUserInfo(body);
    TokenModelResponse tokenModelResponse = new TokenModelResponse();
    if ( userEntityJpa != null ) {
      String token = tokenService.getToken(userEntityJpa);
      tokenModelResponse.setCode(HttpStatus.OK.value());
      tokenModelResponse.setMessage(HttpStatus.OK.getReasonPhrase());
      tokenModelResponse.setDescription(Constants.MSG_TOKEN_FOUND);
      tokenModelResponse.setToken(token);
    } else {
      tokenModelResponse.setCode(HttpStatus.NOT_FOUND.value());
      tokenModelResponse.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
      tokenModelResponse.setDescription(Constants.MSG_TOKEN_NOT_FOUND);
    }

    return new ResponseEntity<TokenModelResponse>(
            tokenModelResponse, HttpStatus.valueOf(tokenModelResponse.getCode()));
  }
}

package com.seek.SigeCan.authentication.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenModelResponse {
    private String message;
    private Integer code;
    private String description;
    private String token;
}

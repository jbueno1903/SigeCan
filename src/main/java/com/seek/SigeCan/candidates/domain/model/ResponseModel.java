package com.seek.SigeCan.candidates.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModel {
    private String message;
    private Integer code;
    private String description;
    private IData data;

}

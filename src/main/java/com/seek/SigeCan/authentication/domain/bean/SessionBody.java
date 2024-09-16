package com.seek.SigeCan.authentication.domain.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionBody {
    private String userName;
    private String sessionId;
}

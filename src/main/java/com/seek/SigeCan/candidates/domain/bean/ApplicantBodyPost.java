package com.seek.SigeCan.candidates.domain.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicantBodyPost {
    private String jobId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String profileUrl1;
    private String profileUrl2;
    private String summary;
    private String gender;
    private String salaryExpected;
}

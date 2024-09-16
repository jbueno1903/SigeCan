package com.seek.SigeCan.candidates.domain.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ApplicantDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String profileUrl1;
    private String profileUrl2;
    private String summary;
    private String gender;
    private Double salaryExpected;
    private Long state;
    private Date dateCreate;
    private Long userCreate;
    private Date dateUpdate;
    private Long userUpdate;
}

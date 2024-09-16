package com.seek.SigeCan.candidates.infrastructure.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@Table(name = "applicant")
public class ApplicantEntityJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="profile_url1")
    private String profileUrl1;
    @Column(name="profile_url2")
    private String profileUrl2;
    @Column(name="summary")
    private String summary;
    @Column(name="gender")
    private String gender;
    @Column(name="salary_expected")
    private Double salaryExpected;
    @Column(name="state")
    private Long state;
    @Column(name="date_create")
    private Date dateCreate;
    @Column(name="user_create")
    private Long userCreate;
    @Column(name="date_updt")
    private Date dateUpdate;
    @Column(name="user_updt")
    private Long userUpdate;
}

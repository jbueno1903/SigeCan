package com.seek.SigeCan.candidates.infrastructure.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@Data
@Table(name = "job")
public class JobEntityJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="code")
    private String code;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="requirements")
    private String requirements;
    @Column(name="knowledges")
    private String knowledges;
    @Column(name="seniority")
    private String seniority;
    @Column(name="date_published")
    private Date datePublished;
    @Column(name="start_applications")
    private Date startApplications;
    @Column(name="end_applications")
    private Date endApplications;
    @Column(name="start_job")
    private Date startJob;
    @Column(name="number_vacancies")
    private Long numberVacancies;
    @Column(name="job_position")
    private String jobPosition;
    @Column(name="job_category")
    private String jobCategory;
    @Column(name="organization_id")
    private Long organizationId;
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

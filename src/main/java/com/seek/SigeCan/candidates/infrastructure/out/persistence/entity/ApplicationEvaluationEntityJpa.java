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
@Table(name = "applicant_evaluation")
public class ApplicationEvaluationEntityJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="results")
    private String results;
    @Column(name="observations")
    private String observations;
    @Column(name="phase")
    private String phase;
    @Column(name="recruiter_id")
    private Long recruiterId;
    @Column(name="application_id")
    private Long applicationId;
    @Column(name="evaluation_date")
    private Date evaluationDate;
}

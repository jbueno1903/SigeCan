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
@Table(name = "application_status_evo")
public class ApplicationStatusEvoEntityJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="date_registered")
    private Date dateRegistered;
    @Column(name="application_status_id")
    private Long applicationStatusId;
    @Column(name="application_id")
    private Long applicationId;
}

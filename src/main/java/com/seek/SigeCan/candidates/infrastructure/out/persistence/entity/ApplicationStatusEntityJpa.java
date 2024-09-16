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
@Table(name = "application_status")
public class ApplicationStatusEntityJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="description")
    private String description;
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

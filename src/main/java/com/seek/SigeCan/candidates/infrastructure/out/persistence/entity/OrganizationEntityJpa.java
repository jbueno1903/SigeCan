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
@Table(name = "organization")
public class OrganizationEntityJpa {
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
    @Column(name="document_number")
    private String documentNumber;
    @Column(name="name_contact1")
    private String nameContact1;
    @Column(name="email1")
    private String email1;
    @Column(name="phone_contact1")
    private String phoneContact1;
    @Column(name="name_contact2")
    private String nameContact2;
    @Column(name="email2")
    private String email2;
    @Column(name="phone_contact2")
    private String phonCcontact2;
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

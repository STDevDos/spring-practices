package com.froyo.service.model.entity.postgres;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@SuppressWarnings("unused")
@Entity
@Table(name = "phone")
@EntityListeners(AuditingEntityListener.class)
public class PhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; // Each phone will be given an auto-generated unique identifier when stored

    @Column(name = "phone_contact", nullable = false)
    private String phoneContact;

    @Column(name = "phone_number", nullable = false)
    private long phoneNumber;

}


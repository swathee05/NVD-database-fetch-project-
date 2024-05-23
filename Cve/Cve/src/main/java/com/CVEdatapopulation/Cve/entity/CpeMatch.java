package com.CVEdatapopulation.Cve.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class CpeMatch implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private boolean vulnerable;
    private String criteria;
    private String matchCriteriaId;
}

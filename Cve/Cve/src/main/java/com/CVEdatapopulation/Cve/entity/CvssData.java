package com.CVEdatapopulation.Cve.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class CvssData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String version;
    private String vectorString;
    private String accessVector;
    private String accessComplexity;
    private String authentication;
    private String confidentialityImpact;
    private String integrityImpact;
    private String availabilityImpact;
    private double baseScore;
}

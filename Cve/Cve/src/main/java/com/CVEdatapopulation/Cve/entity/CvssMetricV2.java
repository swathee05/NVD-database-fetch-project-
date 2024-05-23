package com.CVEdatapopulation.Cve.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class CvssMetricV2 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    private String type;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cvss_data_id") // Add this line
    private CvssData cvssData;

    private String baseSeverity;
    private double exploitabilityScore;
    private double impactScore;
    private boolean acInsufInfo;
    private boolean obtainAllPrivilege;
    private boolean obtainUserPrivilege;
    private boolean obtainOtherPrivilege;
    private boolean userInteractionRequired;

    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }
}

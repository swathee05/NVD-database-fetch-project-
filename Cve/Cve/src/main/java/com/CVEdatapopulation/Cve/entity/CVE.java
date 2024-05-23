package com.CVEdatapopulation.Cve.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityScan
public class CVE implements Serializable {
    @Id
    private String id;
    private String sourceIdentifier;
    private LocalDateTime published;
    private LocalDateTime lastModified;
    private String vulnStatus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "description") // Add this line
    private List<Description> descriptions;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Adjust this line
    private Metrics metrics;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "weaknesses") // Add this line
    private List<Weakness> weaknesses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "configurations") // Add this line
    private List<Configuration> configurations;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "references") // Add this line
    private List<Reference> references;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and setter for sourceIdentifier
    public String getSourceIdentifier() {
        return sourceIdentifier;
    }

    public void setSourceIdentifier(String sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
    }

    // Getter and setter for published
    public LocalDateTime getPublished() {
        return published;
    }

    public void setPublished(LocalDateTime published) {
        this.published = published;
    }

    // Getter and setter for lastModified
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    // Getter and setter for vulnStatus
    public String getVulnStatus() {
        return vulnStatus;
    }

    public void setVulnStatus(String vulnStatus) {
        this.vulnStatus = vulnStatus;
    }
    public List<Description> getDescriptions() {
        return descriptions;
    }

    // Setter for descriptions
    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

}

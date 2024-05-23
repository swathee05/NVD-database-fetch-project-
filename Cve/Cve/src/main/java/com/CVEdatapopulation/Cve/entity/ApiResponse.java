package com.CVEdatapopulation.Cve.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@EntityScan
public class ApiResponse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String version;
    private int resultsPerPage;
    private int startIndex;
    private int totalResults;
    private String format;
    private String timestamp;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "apiResponse")
    private List<VulnerabilityItem> vulnerabilities;

    public Long getId() {
        return id;
    }

    public String getVersion() {
        return version;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public String getFormat() {
        return format;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public List<VulnerabilityItem> getVulnerabilities() {
        return vulnerabilities;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setVulnerabilities(List<VulnerabilityItem> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }
    public List<CVE> getCves() {
        return vulnerabilities.stream()
                .map(VulnerabilityItem::getCve)
                .collect(Collectors.toList());
    }


}

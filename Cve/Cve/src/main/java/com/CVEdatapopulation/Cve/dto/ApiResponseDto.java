package com.CVEdatapopulation.Cve.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ApiResponseDto implements Serializable {
    private Long id;
    private String version;
    private int resultsPerPage;
    private int startIndex;
    private int totalResults;
    private String format;
    private String timestamp;
    // Assuming you want to include a list of vulnerability IDs or some summary information
    private List<Long> vulnerabilityIds;

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

    // Getter and setter for vulnerabilityIds
    public List<Long> getVulnerabilityIds() {
        return vulnerabilityIds;
    }

    public void setVulnerabilityIds(List<Long> vulnerabilityIds) {
        this.vulnerabilityIds = vulnerabilityIds;
    }

    public void setCveIds(List<String> cveIds) {
        this.vulnerabilityIds = cveIds.stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());

    }
}
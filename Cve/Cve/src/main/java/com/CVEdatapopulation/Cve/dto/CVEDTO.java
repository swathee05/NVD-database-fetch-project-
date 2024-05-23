package com.CVEdatapopulation.Cve.dto;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class CVEDTO implements Serializable {
    private String id;
    private String sourceIdentifier;
    private LocalDateTime published;
    private LocalDateTime lastModified;
    private String vulnStatus;
    private List<DescriptionDto> descriptions;
    private MetricsDto metrics;
    private List<WeaknessDto> weaknesses;
    private List<ConfigurationDto> configurations;
    private List<ReferenceDto> references;
}

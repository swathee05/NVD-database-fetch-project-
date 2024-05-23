package com.CVEdatapopulation.Cve.dto;

public class CvssMetricV2Dto {
    private String source;
    private String type;
    private CvssDataDto cvssData;
    private String baseSeverity;
    private double exploitabilityScore;
    private double impactScore;
    private boolean acInsufInfo;
    private boolean obtainAllPrivilege;
    private boolean obtainUserPrivilege;
    private boolean obtainOtherPrivilege;
    private boolean userInteractionRequired;
}

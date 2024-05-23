package com.CVEdatapopulation.Cve;


import com.CVEdatapopulation.Cve.dto.ApiResponseDto;
import com.CVEdatapopulation.Cve.entity.*;
import com.CVEdatapopulation.Cve.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiResponseService {
    @Autowired
    private final ApiResponseRepository apiResponseRepository;
    private final CVERepository cveRepository;
    private final DescriptionRepository descriptionRepository;
    private final CvssMetricV2Repository cvssMetricV2Repository;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;



    @Autowired
    public ApiResponseService(ApiResponseRepository apiResponseRepository, CVERepository cveRepository, DescriptionRepository descriptionRepository, CvssMetricV2Repository cvssMetricV2Repository, ObjectMapper objectMapper) {
        this.apiResponseRepository = apiResponseRepository;
        this.cveRepository = cveRepository;
        this.descriptionRepository = descriptionRepository;
        this.cvssMetricV2Repository = cvssMetricV2Repository;
        this.restTemplate = new RestTemplate();
        this.objectMapper = objectMapper;
    }

    @Transactional
    public ApiResponseDto fetchAndSaveApiResponse(String url) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            ApiResponse apiResponse = objectMapper.readValue(response.getBody(), ApiResponse.class);
            // Save CVEs first to avoid 'persist()' error
            for (VulnerabilityItem vulnerabilityItem : apiResponse.getVulnerabilities()) {
                CVE cve = vulnerabilityItem.getCve();
                if (cve.getId() == null) {
                    cveRepository.save(cve);
                }
                for (Description description : cve.getDescriptions()) {
                    if (description.getId() == null) {
                        descriptionRepository.save(description);
                    }
                }

                CvssMetricV2 cvssMetricV2 = vulnerabilityItem.getCvssMetricV2();
                if (cvssMetricV2 != null && cvssMetricV2.getId() == null) {
                    cvssMetricV2Repository.save(cvssMetricV2);
                }

            }
            ApiResponse savedEntity = apiResponseRepository.save(apiResponse);
            return convertToDTO(savedEntity);
        } else {
            throw new RuntimeException("Failed to fetch data from the API");
        }
    }

    private ApiResponseDto convertToDTO(ApiResponse apiResponse) {
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setId(apiResponse.getId());
        apiResponseDto.setVersion(apiResponse.getVersion());
        apiResponseDto.setResultsPerPage(apiResponse.getResultsPerPage());
        apiResponseDto.setStartIndex(apiResponse.getStartIndex());
        apiResponseDto.setTotalResults(apiResponse.getTotalResults());
        apiResponseDto.setFormat(apiResponse.getFormat());
        apiResponseDto.setTimestamp(apiResponse.getTimestamp());
        // Extracting vulnerability IDs and setting them in the DTO
        List<Long> vulnerabilityIds = apiResponse.getVulnerabilities().stream()
                .map(VulnerabilityItem::getId)
                .collect(Collectors.toList());
        apiResponseDto.setVulnerabilityIds(vulnerabilityIds);
        return apiResponseDto;
    }
}
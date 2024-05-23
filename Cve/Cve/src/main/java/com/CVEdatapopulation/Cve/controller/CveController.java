package com.CVEdatapopulation.Cve.controller;

import com.CVEdatapopulation.Cve.ApiResponseService;
import com.CVEdatapopulation.Cve.entity.ApiResponse;

import com.CVEdatapopulation.Cve.entity.CVE;
import com.CVEdatapopulation.Cve.service.CVEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CveController {


    @Autowired
    private final ApiResponseService apiResponseService;

    @Autowired
    public CveController(ApiResponseService apiResponseService) {
        this.apiResponseService = apiResponseService;
    }


    @GetMapping("/fetch-and-store")
    public ResponseEntity<String> fetchAndStore() {
        try {
            //ApiResponse apiResponse = apiResponseService.fetchAndSaveApiResponse("https://services.nvd.nist.gov/rest/json/cves/2.0");
            String apiResponse = String.valueOf(apiResponseService.fetchAndSaveApiResponse("https://services.nvd.nist.gov/rest/json/cves/2.0"));
            if (apiResponse != null) {
                return ResponseEntity.ok("Data fetched and stored successfully!");
            } else {
                return ResponseEntity.badRequest().body("Failed to fetch data: Response body was null.");
            }
        } catch (Exception e) {
            // Log the exception details here
            return ResponseEntity.internalServerError().body("An error occurred while fetching and storing data: " + e.getMessage());
        }
    }
}


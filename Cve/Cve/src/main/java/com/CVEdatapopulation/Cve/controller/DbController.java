package com.CVEdatapopulation.Cve.controller;

import com.CVEdatapopulation.Cve.entity.CVE;
import com.CVEdatapopulation.Cve.service.CVEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cves")
public class DbController {
    private final CVEService cveService;

    @Autowired
    public DbController(CVEService cveService) {
        this.cveService = cveService;
    }

    @GetMapping("/details")
    public List<CVE> getCVEsWithDescriptions() {
        return cveService.getAllCVEsWithDescriptions();
    }
}


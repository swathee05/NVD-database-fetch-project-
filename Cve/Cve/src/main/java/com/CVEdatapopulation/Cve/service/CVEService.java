package com.CVEdatapopulation.Cve.service;

import com.CVEdatapopulation.Cve.entity.CVE;
import com.CVEdatapopulation.Cve.repository.CVERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CVEService {
    private final CVERepository cveRepository;

    @Autowired
    public CVEService(CVERepository cveRepository) {
        this.cveRepository = cveRepository;
    }

    public List<CVE> getAllCVEsWithDescriptions() {
        return cveRepository.findAllWithDescriptions();
    }
}

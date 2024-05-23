package com.CVEdatapopulation.Cve.repository;
import com.CVEdatapopulation.Cve.entity.CvssMetricV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface CvssMetricV2Repository extends JpaRepository<CvssMetricV2, Long> {
}
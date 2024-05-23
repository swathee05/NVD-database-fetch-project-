package com.CVEdatapopulation.Cve.repository;

import com.CVEdatapopulation.Cve.entity.CvssData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CvssDataRepository extends JpaRepository<CvssData, Long> {
}

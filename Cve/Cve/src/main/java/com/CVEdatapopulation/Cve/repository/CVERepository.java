package com.CVEdatapopulation.Cve.repository;

import com.CVEdatapopulation.Cve.entity.CVE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CVERepository extends JpaRepository<CVE, String> {
    @Query("SELECT cve FROM CVE cve JOIN FETCH cve.descriptions")
    List<CVE> findAllWithDescriptions();
}

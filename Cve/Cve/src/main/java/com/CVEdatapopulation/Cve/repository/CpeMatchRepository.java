package com.CVEdatapopulation.Cve.repository;

import com.CVEdatapopulation.Cve.entity.CpeMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpeMatchRepository extends JpaRepository<CpeMatch, Long> {
}

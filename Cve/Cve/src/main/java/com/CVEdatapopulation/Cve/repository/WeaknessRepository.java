package com.CVEdatapopulation.Cve.repository;

import com.CVEdatapopulation.Cve.entity.Weakness;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WeaknessRepository extends JpaRepository<Weakness, String> {
}

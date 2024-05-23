package com.CVEdatapopulation.Cve.repository;
import com.CVEdatapopulation.Cve.entity.Metrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MetricsRepository extends JpaRepository<Metrics, Long> {
}

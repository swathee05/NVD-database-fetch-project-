package com.CVEdatapopulation.Cve.repository;

import com.CVEdatapopulation.Cve.entity.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiResponseRepository extends JpaRepository<ApiResponse, Long> {
}
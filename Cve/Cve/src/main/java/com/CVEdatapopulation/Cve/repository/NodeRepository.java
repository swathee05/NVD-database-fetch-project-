package com.CVEdatapopulation.Cve.repository;
import com.CVEdatapopulation.Cve.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {
}

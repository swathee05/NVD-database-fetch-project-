package com.CVEdatapopulation.Cve.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "metric_col")
public class Metrics implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<CvssMetricV2> cvssMetricV2;
}

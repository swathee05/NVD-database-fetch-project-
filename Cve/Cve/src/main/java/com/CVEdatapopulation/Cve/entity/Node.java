package com.CVEdatapopulation.Cve.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "node_col")
public class Node implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String operator;
    private boolean negate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CpeMatch> cpeMatch;
}

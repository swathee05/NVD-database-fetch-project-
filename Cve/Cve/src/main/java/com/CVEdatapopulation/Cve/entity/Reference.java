package com.CVEdatapopulation.Cve.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "refer")
public class Reference implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String source;
}

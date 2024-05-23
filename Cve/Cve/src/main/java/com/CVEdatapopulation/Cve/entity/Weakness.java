package com.CVEdatapopulation.Cve.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@Table(name = "weakness_col")
public class Weakness implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String source;
    private String type;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Description> description;
}

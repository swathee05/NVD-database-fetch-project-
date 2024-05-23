package com.CVEdatapopulation.Cve.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import java.io.Serializable;

@Entity
@EntityScan
@Table(name = "descr")
public class Description implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lang;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter for lang
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    // Getter and setter for value
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

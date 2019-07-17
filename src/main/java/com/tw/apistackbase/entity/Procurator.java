package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class Procurator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255,nullable = false)
    private String name;

    public Procurator() {
    }

    public Procurator(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

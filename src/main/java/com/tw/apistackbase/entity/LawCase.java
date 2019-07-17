package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class LawCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255,nullable = false)
    private String name;

    @Column(nullable = false)
    private Long time;

    public LawCase() {
    }

    public LawCase(String name, Long time) {
        this.name = name;
        this.time = time;
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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}



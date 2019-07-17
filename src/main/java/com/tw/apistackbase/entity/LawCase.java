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

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "caseInfo")
    private CaseInfo caseInfo;

    @Column(nullable = true)
    private String description;

    public LawCase() {
    }

    public LawCase(String name, Long time) {
        this.name = name;
        this.time = time;
    }

    public LawCase(String name, Long time, CaseInfo caseInfo) {
        this.name = name;
        this.time = time;
        this.caseInfo = caseInfo;
    }

    public LawCase(String name, Long time, CaseInfo caseInfo, String description) {
        this.name = name;
        this.time = time;
        this.caseInfo = caseInfo;
        this.description = description;
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

    public CaseInfo getCaseInfo() {
        return caseInfo;
    }

    public void setCaseInfo(CaseInfo caseInfo) {
        this.caseInfo = caseInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "LawCase{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", caseInfo=" + caseInfo +
                ", description='" + description + '\'' +
                '}';
    }
}



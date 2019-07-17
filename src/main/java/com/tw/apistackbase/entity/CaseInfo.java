package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class CaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255)
    private String objectiveDescription;

    @Column(length = 255,nullable = false)
    private String subjectiveDescription;

    public CaseInfo() {
    }

    public CaseInfo(String objectiveDescription, String subjectiveDescription) {
        this.objectiveDescription = objectiveDescription;
        this.subjectiveDescription = subjectiveDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    public void setObjectiveDescription(String objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
    }

    public String getSubjectiveDescription() {
        return subjectiveDescription;
    }

    public void setSubjectiveDescription(String subjectiveDescription) {
        this.subjectiveDescription = subjectiveDescription;
    }
}

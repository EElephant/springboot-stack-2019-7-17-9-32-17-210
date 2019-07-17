package com.tw.apistackbase.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50,nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "procurator")
    private List<Procurator> procurators;

    public Procuratorate() {
    }

    public Procuratorate(String name) {
        this.name = name;
    }

    public Procuratorate(String name, List<Procurator> procurators) {
        this.name = name;
        this.procurators = procurators;
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

    @Override
    public String toString() {
        return "Procuratorate{" +
                "name='" + name + '\'' +
                ", procurators=" + procurators +
                '}';
    }
}

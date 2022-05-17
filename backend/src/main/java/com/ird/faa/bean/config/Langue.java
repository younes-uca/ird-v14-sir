package com.ird.faa.bean.config;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "langue")
public class Langue {

    @Id
    @SequenceGenerator(name = "langue_seq", sequenceName = "langue_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "langue_seq")
    private Long id;

    private String libelle;
    private String code;


    public Langue() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Langue langue = (Langue) o;
        return id != null && id.equals(langue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


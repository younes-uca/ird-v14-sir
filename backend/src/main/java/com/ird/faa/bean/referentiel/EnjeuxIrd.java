package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "enjeux_ird")
public class EnjeuxIrd {

    @Id
    @SequenceGenerator(name = "enjeux_ird_seq", sequenceName = "enjeux_ird_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enjeux_ird_seq")
    private Long id;

    private String libelle;
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;


    public EnjeuxIrd() {
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnjeuxIrd enjeuxIrd = (EnjeuxIrd) o;
        return id != null && id.equals(enjeuxIrd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


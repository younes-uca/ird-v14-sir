package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "caracterisation")
public class Caracterisation {


    @Id
    @SequenceGenerator(name = "caracterisation_seq", sequenceName = "caracterisation_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caracterisation_seq")
    private Long id;

    private String libelle;
    private String code;


    public Caracterisation() {
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
        Caracterisation caracterisation = (Caracterisation) o;
        return id != null && id.equals(caracterisation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


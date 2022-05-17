package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "domaine_scientifique")
public class DomaineScientifique {

    @Id
    @SequenceGenerator(name = "domaine_scientifique_seq", sequenceName = "domaine_scientifique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domaine_scientifique_seq")
    private Long id;

    private String libelle;
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;


    public DomaineScientifique() {
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
        DomaineScientifique domaineScientifique = (DomaineScientifique) o;
        return id != null && id.equals(domaineScientifique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


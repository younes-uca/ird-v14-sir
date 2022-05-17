package com.ird.faa.bean.config;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "etat_campagne_chercheur")
public class EtatCampagneChercheur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String libelle;
    private String code;

    public EtatCampagneChercheur() {
        super();
    }

    public EtatCampagneChercheur(String libelle, String code) {
        this.libelle = libelle;
        this.code = code;
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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EtatCampagneChercheur etatCampagneChercheur = (EtatCampagneChercheur) o;
        return id != null && id.equals(etatCampagneChercheur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

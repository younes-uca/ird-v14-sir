package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.referentiel.Sexe;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "doctorant")
public class Doctorant {

    @Id
    @SequenceGenerator(name = "doctorant_seq", sequenceName = "doctorant_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctorant_seq")
    private Long id;
    private String civilite;
    private String nom;
    private String prenom;
    private Integer anneeNaissance;

    @ManyToOne
    private Sexe sexe;
    @ManyToOne
    private Pays pays;


    public Doctorant() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Sexe getSexe() {
        return this.sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Integer getAnneeNaissance() {
        return this.anneeNaissance;
    }

    public void setAnneeNaissance(Integer anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public Pays getPays() {
        return this.pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctorant doctorant = (Doctorant) o;
        return id != null && id.equals(doctorant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public String getCivilite() {
        return civilite;
    }


    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }


}


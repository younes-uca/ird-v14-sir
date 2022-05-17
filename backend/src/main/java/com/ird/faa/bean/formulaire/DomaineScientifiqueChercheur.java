package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "domaine_scientifique_chercheur")
public class DomaineScientifiqueChercheur {

    @Id
    @SequenceGenerator(name = "domaine_scientifique_chercheur_seq", sequenceName = "domaine_scientifique_chercheur_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domaine_scientifique_chercheur_seq")
    private Long id;


    @ManyToOne
    private DomaineScientifique domaineScientifique;
    @ManyToOne
    private Chercheur chercheur;


    public DomaineScientifiqueChercheur() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DomaineScientifique getDomaineScientifique() {
        return this.domaineScientifique;
    }

    public void setDomaineScientifique(DomaineScientifique domaineScientifique) {
        this.domaineScientifique = domaineScientifique;
    }

    public Chercheur getChercheur() {
        return this.chercheur;
    }

    public void setChercheur(Chercheur chercheur) {
        this.chercheur = chercheur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomaineScientifiqueChercheur domaineScientifiqueChercheur = (DomaineScientifiqueChercheur) o;
        return id != null && id.equals(domaineScientifiqueChercheur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


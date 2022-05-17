package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "communaute_savoir_chercheur")
public class CommunauteSavoirChercheur {

    @Id
    @SequenceGenerator(name = "communaute_savoir_chercheur_seq", sequenceName = "communaute_savoir_chercheur_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "communaute_savoir_chercheur_seq")
    private Long id;
    @ManyToOne
    private CommunauteSavoir communauteSavoir;
    @ManyToOne
    private Chercheur chercheur;


    public CommunauteSavoirChercheur() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommunauteSavoir getCommunauteSavoir() {
        return this.communauteSavoir;
    }

    public void setCommunauteSavoir(CommunauteSavoir communauteSavoir) {
        this.communauteSavoir = communauteSavoir;
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
        CommunauteSavoirChercheur communauteSavoirChercheur = (CommunauteSavoirChercheur) o;
        return id != null && id.equals(communauteSavoirChercheur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


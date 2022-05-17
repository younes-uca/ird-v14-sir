package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "identifiant_auteur_expert")
public class IdentifiantAuteurExpert {

    @Id
    @SequenceGenerator(name = "identifiant_auteur_expert_seq", sequenceName = "identifiant_auteur_expert_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identifiant_auteur_expert_seq")
    private Long id;

    private String valeur;

    @ManyToOne
    private IdentifiantRecherche identifiantRecherche;
    @ManyToOne
    private Chercheur chercheur;


    public IdentifiantAuteurExpert() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IdentifiantRecherche getIdentifiantRecherche() {
        return this.identifiantRecherche;
    }

    public void setIdentifiantRecherche(IdentifiantRecherche identifiantRecherche) {
        this.identifiantRecherche = identifiantRecherche;
    }

    public Chercheur getChercheur() {
        return this.chercheur;
    }

    public void setChercheur(Chercheur chercheur) {
        this.chercheur = chercheur;
    }

    public String getValeur() {
        return this.valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentifiantAuteurExpert identifiantAuteurExpert = (IdentifiantAuteurExpert) o;
        return id != null && id.equals(identifiantAuteurExpert.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


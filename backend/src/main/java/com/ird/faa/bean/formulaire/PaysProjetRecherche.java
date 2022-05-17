package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pays_projet_recherche")
public class PaysProjetRecherche {

    @Id
    @SequenceGenerator(name = "pays_projet_recherche_seq", sequenceName = "pays_projet_recherche_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pays_projet_recherche_seq")
    private Long id;


    @ManyToOne
    private Pays pays;
    @ManyToOne
    private ProjetActiviteRecherche projetActiviteRecherche;


    public PaysProjetRecherche() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pays getPays() {
        return this.pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public ProjetActiviteRecherche getProjetActiviteRecherche() {
        return this.projetActiviteRecherche;
    }

    public void setProjetActiviteRecherche(ProjetActiviteRecherche projetActiviteRecherche) {
        this.projetActiviteRecherche = projetActiviteRecherche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaysProjetRecherche paysProjetRecherche = (PaysProjetRecherche) o;
        return id != null && id.equals(paysProjetRecherche.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


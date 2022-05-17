package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fournisseur_appel_projet_recherche")
public class FournisseurAppelProjetRecherche {

    @Id
    @SequenceGenerator(name = "fournisseur_appel_projet_recherche_seq", sequenceName = "fournisseur_appel_projet_recherche_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fournisseur_appel_projet_recherche_seq")
    private Long id;

    private String libelle;
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Pays pays;


    public FournisseurAppelProjetRecherche() {
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
        FournisseurAppelProjetRecherche fournisseurAppelProjetRecherche = (FournisseurAppelProjetRecherche) o;
        return id != null && id.equals(fournisseurAppelProjetRecherche.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


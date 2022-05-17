package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Etablissement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "etablissement_rencontre_grand_publique_jeune_publique")
public class EtablissementRencontreGrandPubliqueJeunePublique {

    @Id
    @SequenceGenerator(name = "etablissement_rencontre_grand_publique_jeune_publique_seq", sequenceName = "etablissement_rencontre_grand_publique_jeune_publique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etablissement_rencontre_grand_publique_jeune_publique_seq")
    private Long id;


    @ManyToOne
    private RencontreGrandPubliqueJeunePublique rencontreGrandPubliqueJeunePublique;
    @ManyToOne
    private Etablissement etablissement;


    public EtablissementRencontreGrandPubliqueJeunePublique() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RencontreGrandPubliqueJeunePublique getRencontreGrandPubliqueJeunePublique() {
        return this.rencontreGrandPubliqueJeunePublique;
    }

    public void setRencontreGrandPubliqueJeunePublique(RencontreGrandPubliqueJeunePublique rencontreGrandPubliqueJeunePublique) {
        this.rencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePublique;
    }

    public Etablissement getEtablissement() {
        return this.etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtablissementRencontreGrandPubliqueJeunePublique etablissementRencontreGrandPubliqueJeunePublique = (EtablissementRencontreGrandPubliqueJeunePublique) o;
        return id != null && id.equals(etablissementRencontreGrandPubliqueJeunePublique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


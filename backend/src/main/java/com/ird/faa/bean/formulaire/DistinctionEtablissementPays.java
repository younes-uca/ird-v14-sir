package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Etablissement;
import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "distinction_etablissement_pays")
public class DistinctionEtablissementPays {

    @Id
    @SequenceGenerator(name = "distinction_etablissement_pays_seq", sequenceName = "distinction_etablissement_pays_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "distinction_etablissement_pays_seq")
    private Long id;

    @ManyToOne
    private Pays pays;
    @ManyToOne
    private Etablissement etablissement;
    @ManyToOne
    private Distinction distinction;

    public DistinctionEtablissementPays() {
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

    public Etablissement getEtablissement() {
        return this.etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public Distinction getDistinction() {
        return this.distinction;
    }

    public void setDistinction(Distinction distinction) {
        this.distinction = distinction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DistinctionEtablissementPays distinctionEtablissementPays = (DistinctionEtablissementPays) o;
        return id != null && id.equals(distinctionEtablissementPays.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

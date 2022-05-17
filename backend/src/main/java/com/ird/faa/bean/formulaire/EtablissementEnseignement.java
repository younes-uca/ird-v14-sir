package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Etablissement;
import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "etablissement_enseignement")
public class EtablissementEnseignement {

    @Id
    @SequenceGenerator(name = "etablissement_enseignement_seq", sequenceName = "etablissement_enseignement_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etablissement_enseignement_seq")
    private Long id;


    @ManyToOne
    private Etablissement etablissement;
    @ManyToOne
    private Enseignement enseignement;
    @ManyToOne
    private Pays pays;


    public EtablissementEnseignement() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etablissement getEtablissement() {
        return this.etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public Enseignement getEnseignement() {
        return this.enseignement;
    }

    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
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
        EtablissementEnseignement etablissementEnseignement = (EtablissementEnseignement) o;
        return id != null && id.equals(etablissementEnseignement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


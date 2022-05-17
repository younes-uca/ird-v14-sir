package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "enseignement_pays")
public class EnseignementPays {

    @Id
    @SequenceGenerator(name = "enseignement_pays_seq", sequenceName = "enseignement_pays_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enseignement_pays_seq")
    private Long id;


    @ManyToOne
    private Pays pays;
    @ManyToOne
    private Enseignement enseignement;


    public EnseignementPays() {
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

    public Enseignement getEnseignement() {
        return this.enseignement;
    }

    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnseignementPays enseignementPays = (EnseignementPays) o;
        return id != null && id.equals(enseignementPays.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


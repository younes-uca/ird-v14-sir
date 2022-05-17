package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.NatureEnseignement;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "enseignement_nature")
public class EnseignementNature {

    @Id
    @SequenceGenerator(name = "enseignement_nature_seq", sequenceName = "enseignement_nature_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enseignement_nature_seq")
    private Long id;


    @ManyToOne
    private NatureEnseignement natureEnseignement;
    @ManyToOne
    private Enseignement enseignement;


    public EnseignementNature() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NatureEnseignement getNatureEnseignement() {
        return this.natureEnseignement;
    }

    public void setNatureEnseignement(NatureEnseignement natureEnseignement) {
        this.natureEnseignement = natureEnseignement;
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
        EnseignementNature enseignementNature = (EnseignementNature) o;
        return id != null && id.equals(enseignementNature.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pays_formation_continue")
public class PaysFormationContinue {

    @Id
    @SequenceGenerator(name = "pays_formation_continue_seq", sequenceName = "pays_formation_continue_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pays_formation_continue_seq")
    private Long id;


    @ManyToOne
    private Pays pays;
    @ManyToOne
    private FormationContinue formationContinue;


    public PaysFormationContinue() {
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

    public FormationContinue getFormationContinue() {
        return this.formationContinue;
    }

    public void setFormationContinue(FormationContinue formationContinue) {
        this.formationContinue = formationContinue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaysFormationContinue paysFormationContinue = (PaysFormationContinue) o;
        return id != null && id.equals(paysFormationContinue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


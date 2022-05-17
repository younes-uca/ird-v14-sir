package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.ObjetGlobal;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "objet_global_formation_continue")
public class ObjetGlobalFormationContinue {

    @Id
    @SequenceGenerator(name = "objet_global_formation_continue_seq", sequenceName = "objet_global_formation_continue_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objet_global_formation_continue_seq")
    private Long id;


    @ManyToOne
    private ObjetGlobal objetGlobal;
    @ManyToOne
    private FormationContinue formationContinue;


    public ObjetGlobalFormationContinue() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ObjetGlobal getObjetGlobal() {
        return this.objetGlobal;
    }

    public void setObjetGlobal(ObjetGlobal objetGlobal) {
        this.objetGlobal = objetGlobal;
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
        ObjetGlobalFormationContinue objetGlobalFormationContinue = (ObjetGlobalFormationContinue) o;
        return id != null && id.equals(objetGlobalFormationContinue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


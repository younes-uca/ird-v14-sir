package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.PubliqueProfessionel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "formation_continue_publique_professionel")
public class FormationContinuePubliqueProfessionel {

    @Id
    @SequenceGenerator(name = "formation_continue_publique_professionel_seq", sequenceName = "formation_continue_publique_professionel_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "formation_continue_publique_professionel_seq")
    private Long id;


    @ManyToOne
    private FormationContinue formationContinue;
    @ManyToOne
    private PubliqueProfessionel publiqueProfessionel;


    public FormationContinuePubliqueProfessionel() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FormationContinue getFormationContinue() {
        return this.formationContinue;
    }

    public void setFormationContinue(FormationContinue formationContinue) {
        this.formationContinue = formationContinue;
    }

    public PubliqueProfessionel getPubliqueProfessionel() {
        return this.publiqueProfessionel;
    }

    public void setPubliqueProfessionel(PubliqueProfessionel publiqueProfessionel) {
        this.publiqueProfessionel = publiqueProfessionel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormationContinuePubliqueProfessionel formationContinuePubliqueProfessionel = (FormationContinuePubliqueProfessionel) o;
        return id != null && id.equals(formationContinuePubliqueProfessionel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


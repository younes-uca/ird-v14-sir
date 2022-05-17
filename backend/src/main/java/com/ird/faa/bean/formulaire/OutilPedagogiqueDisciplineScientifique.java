package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.OutilPedagogique;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "outil_pedagogique_discipline_scientifique")
public class OutilPedagogiqueDisciplineScientifique {

    @Id
    @SequenceGenerator(name = "outil_pedagogique_discipline_scientifique_seq", sequenceName = "outil_pedagogique_discipline_scientifique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outil_pedagogique_discipline_scientifique_seq")
    private Long id;


    @ManyToOne
    private OutilPedagogique outilPedagogique;
    @ManyToOne
    private DisciplineScientifique disciplineScientifique;


    public OutilPedagogiqueDisciplineScientifique() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OutilPedagogique getOutilPedagogique() {
        return this.outilPedagogique;
    }

    public void setOutilPedagogique(OutilPedagogique outilPedagogique) {
        this.outilPedagogique = outilPedagogique;
    }

    public DisciplineScientifique getDisciplineScientifique() {
        return this.disciplineScientifique;
    }

    public void setDisciplineScientifique(DisciplineScientifique disciplineScientifique) {
        this.disciplineScientifique = disciplineScientifique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutilPedagogiqueDisciplineScientifique outilPedagogiqueDisciplineScientifique = (OutilPedagogiqueDisciplineScientifique) o;
        return id != null && id.equals(outilPedagogiqueDisciplineScientifique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


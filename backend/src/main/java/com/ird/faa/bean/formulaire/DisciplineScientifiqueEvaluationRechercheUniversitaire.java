package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "discipline_scientifique_evaluation_recherche_universitaire")
public class DisciplineScientifiqueEvaluationRechercheUniversitaire {

    @Id
    @SequenceGenerator(name = "discipline_scientifique_evaluation_recherche_universitaire_seq", sequenceName = "discipline_scientifique_evaluation_recherche_universitaire_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discipline_scientifique_evaluation_recherche_universitaire_seq")
    private Long id;


    @ManyToOne
    private DisciplineScientifique disciplineScientifique;
    @ManyToOne
    private EvaluationRechercheUniversitaire evaluationRechercheUniversitaire;


    public DisciplineScientifiqueEvaluationRechercheUniversitaire() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DisciplineScientifique getDisciplineScientifique() {
        return this.disciplineScientifique;
    }

    public void setDisciplineScientifique(DisciplineScientifique disciplineScientifique) {
        this.disciplineScientifique = disciplineScientifique;
    }

    public EvaluationRechercheUniversitaire getEvaluationRechercheUniversitaire() {
        return this.evaluationRechercheUniversitaire;
    }

    public void setEvaluationRechercheUniversitaire(EvaluationRechercheUniversitaire evaluationRechercheUniversitaire) {
        this.evaluationRechercheUniversitaire = evaluationRechercheUniversitaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplineScientifiqueEvaluationRechercheUniversitaire disciplineScientifiqueEvaluationRechercheUniversitaire = (DisciplineScientifiqueEvaluationRechercheUniversitaire) o;
        return id != null && id.equals(disciplineScientifiqueEvaluationRechercheUniversitaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


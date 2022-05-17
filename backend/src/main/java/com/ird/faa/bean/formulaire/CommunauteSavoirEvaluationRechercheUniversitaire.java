package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "communaute_savoir_evaluation_recherche_universitaire")
public class CommunauteSavoirEvaluationRechercheUniversitaire {

    @Id
    @SequenceGenerator(name = "communaute_savoir_evaluation_recherche_universitaire_seq", sequenceName = "communaute_savoir_evaluation_recherche_universitaire_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "communaute_savoir_evaluation_recherche_universitaire_seq")
    private Long id;


    @ManyToOne
    private EvaluationRechercheUniversitaire evaluationRechercheUniversitaire;
    @ManyToOne
    private CommunauteSavoir communauteSavoir;


    public CommunauteSavoirEvaluationRechercheUniversitaire() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EvaluationRechercheUniversitaire getEvaluationRechercheUniversitaire() {
        return this.evaluationRechercheUniversitaire;
    }

    public void setEvaluationRechercheUniversitaire(EvaluationRechercheUniversitaire evaluationRechercheUniversitaire) {
        this.evaluationRechercheUniversitaire = evaluationRechercheUniversitaire;
    }

    public CommunauteSavoir getCommunauteSavoir() {
        return this.communauteSavoir;
    }

    public void setCommunauteSavoir(CommunauteSavoir communauteSavoir) {
        this.communauteSavoir = communauteSavoir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommunauteSavoirEvaluationRechercheUniversitaire communauteSavoirEvaluationRechercheUniversitaire = (CommunauteSavoirEvaluationRechercheUniversitaire) o;
        return id != null && id.equals(communauteSavoirEvaluationRechercheUniversitaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dev_savoir_innov_scientifique_discipline_scientifique")
public class DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique {

    @Id
    @SequenceGenerator(name = "dev_savoir_innov_scientifique_discipline_scientifique_seq", sequenceName = "dev_savoir_innov_scientifique_discipline_scientifique_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dev_savoir_innov_scientifique_discipline_scientifique_seq")
    private Long id;

    @ManyToOne
    private DisciplineScientifique disciplineScientifique;
    @ManyToOne
    private DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique;

    public DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public DisciplineScientifique getDisciplineScientifique() {
        return disciplineScientifique;
    }

    public void setDisciplineScientifique(DisciplineScientifique disciplineScientifique) {
        this.disciplineScientifique = disciplineScientifique;
    }

    public DeveloppementDeSavoirEtInnovationScientifique getDeveloppementDeSavoirEtInnovationScientifique() {
        return this.developpementDeSavoirEtInnovationScientifique;
    }

    public void setDeveloppementDeSavoirEtInnovationScientifique(
            DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique) {
        this.developpementDeSavoirEtInnovationScientifique = developpementDeSavoirEtInnovationScientifique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique = (DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique) o;
        return id != null && id.equals(developpementDeSavoirEtInnovationScientifiqueDisciplineScientifique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

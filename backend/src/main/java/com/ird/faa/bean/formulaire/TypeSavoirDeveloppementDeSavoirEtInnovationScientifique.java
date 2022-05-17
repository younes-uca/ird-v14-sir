package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.TypeSavoir;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "developpement_de_savoir_et_innovation_scientifique_type_savoir")
public class TypeSavoirDeveloppementDeSavoirEtInnovationScientifique {

    @Id
    @SequenceGenerator(name = "developpement_de_savoir_et_innovation_scientifique_type_savoir_seq", sequenceName = "developpement_de_savoir_et_innovation_scientifique_type_savoir_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "developpement_de_savoir_et_innovation_scientifique_type_savoir_seq")
    private Long id;


    @ManyToOne
    private DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique;
    @ManyToOne
    private TypeSavoir typeSavoir;


    public TypeSavoirDeveloppementDeSavoirEtInnovationScientifique() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeveloppementDeSavoirEtInnovationScientifique getDeveloppementDeSavoirEtInnovationScientifique() {
        return this.developpementDeSavoirEtInnovationScientifique;
    }

    public void setDeveloppementDeSavoirEtInnovationScientifique(DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique) {
        this.developpementDeSavoirEtInnovationScientifique = developpementDeSavoirEtInnovationScientifique;
    }

    public TypeSavoir getTypeSavoir() {
        return this.typeSavoir;
    }

    public void setTypeSavoir(TypeSavoir typeSavoir) {
        this.typeSavoir = typeSavoir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeSavoirDeveloppementDeSavoirEtInnovationScientifique typeSavoirDeveloppementDeSavoirEtInnovationScientifique = (TypeSavoirDeveloppementDeSavoirEtInnovationScientifique) o;
        return id != null && id.equals(typeSavoirDeveloppementDeSavoirEtInnovationScientifique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


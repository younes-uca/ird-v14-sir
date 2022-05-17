package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "caracterisation_developpement_de_savoir_et_innovation_scientifique")
public class CaracterisationDeveloppementDeSavoirEtInnovationScientifique {

    @Id
    @SequenceGenerator(name = "caracterisation_dev_de_savoir_et_innov_seq", sequenceName = "caracterisation_dev_de_savoir_et_innov_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caracterisation_dev_de_savoir_et_innov_seq")
    private Long id;
    @ManyToOne
    private Caracterisation caracterisation;
    @ManyToOne
    private DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique;


    public CaracterisationDeveloppementDeSavoirEtInnovationScientifique() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Caracterisation getCaracterisation() {
        return this.caracterisation;
    }

    public void setCaracterisation(Caracterisation caracterisation) {
        this.caracterisation = caracterisation;
    }

    public DeveloppementDeSavoirEtInnovationScientifique getDeveloppementDeSavoirEtInnovationScientifique() {
        return this.developpementDeSavoirEtInnovationScientifique;
    }

    public void setDeveloppementDeSavoirEtInnovationScientifique(DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique) {
        this.developpementDeSavoirEtInnovationScientifique = developpementDeSavoirEtInnovationScientifique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaracterisationDeveloppementDeSavoirEtInnovationScientifique caracterisationDeveloppementDeSavoirEtInnovationScientifique = (CaracterisationDeveloppementDeSavoirEtInnovationScientifique) o;
        return id != null && id.equals(caracterisationDeveloppementDeSavoirEtInnovationScientifique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


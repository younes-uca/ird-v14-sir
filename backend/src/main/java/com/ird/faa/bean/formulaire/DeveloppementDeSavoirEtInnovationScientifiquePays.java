package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dev_savoir_innov_scientifique_pays")
public class DeveloppementDeSavoirEtInnovationScientifiquePays {

    @Id
    @SequenceGenerator(name = "dev_savoir_innov_scientifique_pays_seq", sequenceName = "dev_savoir_innov_scientifique_pays_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dev_savoir_innov_scientifique_pays_seq")
    private Long id;


    @ManyToOne
    private Pays pays;
    @ManyToOne
    private DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique;


    public DeveloppementDeSavoirEtInnovationScientifiquePays() {
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
        DeveloppementDeSavoirEtInnovationScientifiquePays developpementDeSavoirEtInnovationScientifiquePays = (DeveloppementDeSavoirEtInnovationScientifiquePays) o;
        return id != null && id.equals(developpementDeSavoirEtInnovationScientifiquePays.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


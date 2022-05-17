package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.EnjeuxIrd;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dev_savoir_innov_scientifique_enjeux_ird")
public class DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd {

    @Id
    @SequenceGenerator(name = "dev_savoir_innov_scientifique_enjeux_ird_seq", sequenceName = "dev_savoir_innov_scientifique_enjeux_ird_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dev_savoir_innov_scientifique_enjeux_ird_seq")
    private Long id;


    @ManyToOne
    private EnjeuxIrd enjeuxIrd;
    @ManyToOne
    private DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique;


    public DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnjeuxIrd getEnjeuxIrd() {
        return this.enjeuxIrd;
    }

    public void setEnjeuxIrd(EnjeuxIrd enjeuxIrd) {
        this.enjeuxIrd = enjeuxIrd;
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
        DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd developpementDeSavoirEtInnovationScientifiqueEnjeuxIrd = (DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd) o;
        return id != null && id.equals(developpementDeSavoirEtInnovationScientifiqueEnjeuxIrd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


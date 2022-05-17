package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.ModeDiffusion;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mode_diffusion_developpement_de_savoir_et_innovation_scientifique")
public class ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique {

    @Id
    @SequenceGenerator(name = "mode_diffusion_developpement_de_savoir_et_innovation_scientifique_seq", sequenceName = "mode_diffusion_developpement_de_savoir_et_innovation_scientifique_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mode_diffusion_developpement_de_savoir_et_innovation_scientifique_seq")
    private Long id;


    @ManyToOne
    private ModeDiffusion modeDiffusion;
    @ManyToOne
    private DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique;


    public ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModeDiffusion getModeDiffusion() {
        return this.modeDiffusion;
    }

    public void setModeDiffusion(ModeDiffusion modeDiffusion) {
        this.modeDiffusion = modeDiffusion;
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
        ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique modeDiffusionDeveloppementDeSavoirEtInnovationScientifique = (ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique) o;
        return id != null && id.equals(modeDiffusionDeveloppementDeSavoirEtInnovationScientifique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


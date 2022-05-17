package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.config.RoleDeveloppementDeSavoir;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dev_savoir_innov_scientifique_role")
public class DeveloppementDeSavoirEtInnovationScientifiqueRole {

    @Id
    @SequenceGenerator(name = "dev_savoir_innov_scientifique_role_seq", sequenceName = "dev_savoir_innov_scientifique_role_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dev_savoir_innov_scientifique_role_seq")
    private Long id;

    @ManyToOne
    private RoleDeveloppementDeSavoir roleDeveloppementDeSavoir;
    @ManyToOne
    private DeveloppementDeSavoirEtInnovationScientifique developpementDeSavoirEtInnovationScientifique;

    public DeveloppementDeSavoirEtInnovationScientifiqueRole() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleDeveloppementDeSavoir getRoleDeveloppementDeSavoir() {
        return roleDeveloppementDeSavoir;
    }

    public void setRoleDeveloppementDeSavoir(RoleDeveloppementDeSavoir roleDeveloppementDeSavoir) {
        this.roleDeveloppementDeSavoir = roleDeveloppementDeSavoir;
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
        DeveloppementDeSavoirEtInnovationScientifiqueRole developpementDeSavoirEtInnovationScientifiqueEtablissement = (DeveloppementDeSavoirEtInnovationScientifiqueRole) o;
        return id != null && id.equals(developpementDeSavoirEtInnovationScientifiqueEtablissement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

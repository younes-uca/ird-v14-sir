package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.config.EtatEtapeCampagne;
import com.ird.faa.bean.referentiel.Etablissement;
import com.ird.faa.bean.referentiel.Master;
import com.ird.faa.bean.referentiel.StatutMaster;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "responsabilite_pedagogique_master")
public class ResponsabilitePedagogiqueMaster {

    @Id
    @SequenceGenerator(name = "responsabilite_pedagogique_master_seq", sequenceName = "responsabilite_pedagogique_master_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "responsabilite_pedagogique_master_seq")
    private Long id;

    private Integer annee;
    private BigDecimal tempsEstimePourCetteAnnne;
    private Boolean appelServiceRenforcementCapaciteSud;
    private Boolean masterInternational;

    @ManyToOne
    private StatutMaster statutMaster;
    @ManyToOne
    private Master master;
    @ManyToOne
    private Etablissement etablissement;
    @ManyToOne
    private EtatEtapeCampagne etatEtapeCampagne;
    @ManyToOne
    private Chercheur chercheur;
    @ManyToOne
    private Campagne campagne;


    public ResponsabilitePedagogiqueMaster() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnnee() {
        return this.annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public BigDecimal getTempsEstimePourCetteAnnne() {
        return this.tempsEstimePourCetteAnnne;
    }

    public void setTempsEstimePourCetteAnnne(BigDecimal tempsEstimePourCetteAnnne) {
        this.tempsEstimePourCetteAnnne = tempsEstimePourCetteAnnne;
    }

    public StatutMaster getStatutMaster() {
        return this.statutMaster;
    }

    public void setStatutMaster(StatutMaster statutMaster) {
        this.statutMaster = statutMaster;
    }

    public Boolean getAppelServiceRenforcementCapaciteSud() {
        return this.appelServiceRenforcementCapaciteSud;
    }

    public void setAppelServiceRenforcementCapaciteSud(Boolean appelServiceRenforcementCapaciteSud) {
        this.appelServiceRenforcementCapaciteSud = appelServiceRenforcementCapaciteSud;
    }

    public Boolean getMasterInternational() {
        return this.masterInternational;
    }

    public void setMasterInternational(Boolean masterInternational) {
        this.masterInternational = masterInternational;
    }

    public Master getMaster() {
        return this.master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Etablissement getEtablissement() {
        return this.etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public EtatEtapeCampagne getEtatEtapeCampagne() {
        return this.etatEtapeCampagne;
    }

    public void setEtatEtapeCampagne(EtatEtapeCampagne etatEtapeCampagne) {
        this.etatEtapeCampagne = etatEtapeCampagne;
    }

    public Chercheur getChercheur() {
        return this.chercheur;
    }

    public void setChercheur(Chercheur chercheur) {
        this.chercheur = chercheur;
    }

    public Campagne getCampagne() {
        return this.campagne;
    }

    public void setCampagne(Campagne campagne) {
        this.campagne = campagne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsabilitePedagogiqueMaster responsabilitePedagogiqueMaster = (ResponsabilitePedagogiqueMaster) o;
        return id != null && id.equals(responsabilitePedagogiqueMaster.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


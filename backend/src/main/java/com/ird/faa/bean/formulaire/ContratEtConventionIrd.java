package com.ird.faa.bean.formulaire;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.faa.bean.config.EtatEtapeCampagne;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contrat_et_convention_ird")
public class ContratEtConventionIrd {

    @Id
    @SequenceGenerator(name = "contrat_et_convention_ird_seq", sequenceName = "contrat_et_convention_ird_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contrat_et_convention_ird_seq")
    private Long id;
    @Column(length = 500)
    private String numero;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateCreationContrat;
    @Temporal(TemporalType.DATE)
    private Date dateEntreeEnVigueur;
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Column(columnDefinition = "TEXT", length = 10485760)
    private String intitule;

    @Column(columnDefinition = "TEXT", length = 10485760)
    private String description;
    private String programmeFinancement;
    private String numMatriculePorteur;
    private int dureeEnMois;
    @ManyToOne
    private StatusContratEtConvention statusContratEtConvention;
    @ManyToOne
    private SavoirEtInnovation savoirEtInnovation;
    @ManyToOne
    private EtatEtapeCampagne etatEtapeCampagne;

    @OneToMany(mappedBy = "contratEtConventionIrd")
    private List<ContratEtConventionIrdPartenaire> contratEtConventionIrdPartenaires;

    public ContratEtConventionIrd() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public StatusContratEtConvention getStatusContratEtConvention() {
        return this.statusContratEtConvention;
    }

    public void setStatusContratEtConvention(StatusContratEtConvention statusContratEtConvention) {
        this.statusContratEtConvention = statusContratEtConvention;
    }

    public String getIntitule() {
        return this.intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreationContrat() {
        return dateCreationContrat;
    }

    public void setDateCreationContrat(Date dateCreationContrat) {
        this.dateCreationContrat = dateCreationContrat;
    }

    public Date getDateEntreeEnVigueur() {
        return dateEntreeEnVigueur;
    }

    public void setDateEntreeEnVigueur(Date dateEntreeEnVigueur) {
        this.dateEntreeEnVigueur = dateEntreeEnVigueur;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getDureeEnMois() {
        return dureeEnMois;
    }

    public void setDureeEnMois(int dureeEnMois) {
        this.dureeEnMois = dureeEnMois;
    }

    public String getProgrammeFinancement() {
        return programmeFinancement;
    }

    public void setProgrammeFinancement(String programmeFinancement) {
        this.programmeFinancement = programmeFinancement;
    }

    public String getNumMatriculePorteur() {
        return numMatriculePorteur;
    }

    public void setNumMatriculePorteur(String numMatriculePorteur) {
        this.numMatriculePorteur = numMatriculePorteur;
    }

    public List<ContratEtConventionIrdPartenaire> getContratEtConventionIrdPartenaires() {
        return contratEtConventionIrdPartenaires;
    }

    public void setContratEtConventionIrdPartenaires(
            List<ContratEtConventionIrdPartenaire> contratEtConventionIrdPartenaires) {
        this.contratEtConventionIrdPartenaires = contratEtConventionIrdPartenaires;
    }

    public SavoirEtInnovation getSavoirEtInnovation() {
        return this.savoirEtInnovation;
    }

    public void setSavoirEtInnovation(SavoirEtInnovation savoirEtInnovation) {
        this.savoirEtInnovation = savoirEtInnovation;
    }

    public EtatEtapeCampagne getEtatEtapeCampagne() {
        return this.etatEtapeCampagne;
    }

    public void setEtatEtapeCampagne(EtatEtapeCampagne etatEtapeCampagne) {
        this.etatEtapeCampagne = etatEtapeCampagne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ContratEtConventionIrd contratEtConventionIrd = (ContratEtConventionIrd) o;
        return id != null && id.equals(contratEtConventionIrd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

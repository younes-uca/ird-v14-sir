package com.ird.faa.bean.formulaire;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bourse")
public class Bourse {

    @Id
    @SequenceGenerator(name = "communaute_savoir_encadrement_etudiant_seq", sequenceName = "communaute_savoir_encadrement_etudiant_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "communaute_savoir_encadrement_etudiant_seq")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateObtention;
    private String intitule;
    private Boolean participationIndividuelle;
    private BigDecimal montant;
    private Integer dureeEnMois;

    @ManyToOne
    private ProjetActiviteRecherche projetActiviteRecherche;
    @ManyToOne
    private Campagne campagne;
    @ManyToOne
    private Chercheur chercheur;


    public Bourse() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateObtention() {
        return this.dateObtention;
    }

    public void setDateObtention(Date dateObtention) {
        this.dateObtention = dateObtention;
    }

    public String getIntitule() {
        return this.intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Boolean getParticipationIndividuelle() {
        return this.participationIndividuelle;
    }

    public void setParticipationIndividuelle(Boolean participationIndividuelle) {
        this.participationIndividuelle = participationIndividuelle;
    }

    public BigDecimal getMontant() {
        return this.montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Integer getDureeEnMois() {
        return this.dureeEnMois;
    }

    public void setDureeEnMois(Integer dureeEnMois) {
        this.dureeEnMois = dureeEnMois;
    }

    public ProjetActiviteRecherche getProjetActiviteRecherche() {
        return this.projetActiviteRecherche;
    }

    public void setProjetActiviteRecherche(ProjetActiviteRecherche projetActiviteRecherche) {
        this.projetActiviteRecherche = projetActiviteRecherche;
    }

    public Campagne getCampagne() {
        return this.campagne;
    }

    public void setCampagne(Campagne campagne) {
        this.campagne = campagne;
    }

    public Chercheur getChercheur() {
        return this.chercheur;
    }

    public void setChercheur(Chercheur chercheur) {
        this.chercheur = chercheur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bourse bourse = (Bourse) o;
        return id != null && id.equals(bourse.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


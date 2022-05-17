package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.config.EtatCampagneChercheur;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "campagne_chercheur")
public class CampagneChercheur {

    @Id
    @SequenceGenerator(name = "campagne_chercheur_seq", sequenceName = "campagne_chercheur_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campagne_chercheur_seq")
    private Long id;

    private BigDecimal avancement;

    @ManyToOne
    private Chercheur chercheur;
    @ManyToOne
    private Campagne campagne;
    @ManyToOne
    private EtatCampagneChercheur etatCampagneChercheur;


    private String objetOuverture;
    private String messageOuverture;

    private String objetFermeture;
    private String messageFermeture;


    public CampagneChercheur() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getAvancement() {
        return this.avancement;
    }

    public void setAvancement(BigDecimal avancement) {
        this.avancement = avancement;
    }

    public EtatCampagneChercheur getEtatCampagneChercheur() {
        return this.etatCampagneChercheur;
    }

    public void setEtatCampagneChercheur(EtatCampagneChercheur etatCampagneChercheur) {
        this.etatCampagneChercheur = etatCampagneChercheur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampagneChercheur campagneChercheur = (CampagneChercheur) o;
        return id != null && id.equals(campagneChercheur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public String getObjetOuverture() {
        return objetOuverture;
    }


    public void setObjetOuverture(String objetOuverture) {
        this.objetOuverture = objetOuverture;
    }


    public String getMessageOuverture() {
        return messageOuverture;
    }


    public void setMessageOuverture(String messageOuverture) {
        this.messageOuverture = messageOuverture;
    }


    public String getObjetFermeture() {
        return objetFermeture;
    }


    public void setObjetFermeture(String objetFermeture) {
        this.objetFermeture = objetFermeture;
    }


    public String getMessageFermeture() {
        return messageFermeture;
    }


    public void setMessageFermeture(String messageFermeture) {
        this.messageFermeture = messageFermeture;
    }


}


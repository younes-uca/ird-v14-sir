package com.ird.faa.bean.formulaire;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.faa.bean.config.EtatEtapeCampagne;
import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.referentiel.TypeParticipation;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "distinction")
public class Distinction {

    @Id
    @SequenceGenerator(name = "distinction_seq", sequenceName = "distinction_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "distinction_seq")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateObtention;
    @Column(length = 500)
    private String intitule;

    @ManyToOne
    private TypeParticipation typeParticipation;
    @ManyToOne
    private Pays pays;
    @ManyToOne
    private EtatEtapeCampagne etatEtapeCampagne;
    @ManyToOne
    private Chercheur chercheur;
    @ManyToOne
    private Campagne campagne;

    @OneToMany(mappedBy = "distinction")
    private List<DistinctionEtablissementPays> distinctionEtablissementPayss;

    public Distinction() {
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

    public TypeParticipation getTypeParticipation() {
        return this.typeParticipation;
    }

    public void setTypeParticipation(TypeParticipation typeParticipation) {
        this.typeParticipation = typeParticipation;
    }

    public Pays getPays() {
        return this.pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
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

    public List<DistinctionEtablissementPays> getDistinctionEtablissementPayss() {
        return this.distinctionEtablissementPayss;
    }

    public void setDistinctionEtablissementPayss(List<DistinctionEtablissementPays> distinctionEtablissementPayss) {
        this.distinctionEtablissementPayss = distinctionEtablissementPayss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distinction distinction = (Distinction) o;
        return id != null && id.equals(distinction.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


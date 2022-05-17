package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.config.EtatEtapeCampagne;
import com.ird.faa.bean.referentiel.Etablissement;
import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.referentiel.RoleEvaluationRechercheUniversitaire;
import com.ird.faa.bean.referentiel.TypeExpert;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "evaluation_recherche_universitaire")
public class EvaluationRechercheUniversitaire {

    @Id
    @SequenceGenerator(name = "evaluation_recherche_universitaire_seq", sequenceName = "evaluation_recherche_universitaire_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluation_recherche_universitaire_seq")
    private Long id;

    private Integer annee;
    private BigDecimal nombreJourConsacrePourCetteAnnee;
    private String commentaire;

    @ManyToOne
    private TypeExpert typeExpert;
    @ManyToOne
    private RoleEvaluationRechercheUniversitaire roleEvaluationRechercheUniversitaire;
    @ManyToOne
    private Pays pays;
    @ManyToOne
    private Etablissement etablissement;
    @ManyToOne
    private Chercheur chercheur;
    @ManyToOne
    private Campagne campagne;
    @ManyToOne
    private EtatEtapeCampagne etatEtapeCampagne;

    @OneToMany(mappedBy = "evaluationRechercheUniversitaire")
    private List<CommunauteSavoirEvaluationRechercheUniversitaire> communauteSavoirEvaluationRechercheUniversitaires;
    @OneToMany(mappedBy = "evaluationRechercheUniversitaire")
    private List<DisciplineScientifiqueEvaluationRechercheUniversitaire> disciplineScientifiqueEvaluationRechercheUniversitaires;

    public EvaluationRechercheUniversitaire() {
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

    public TypeExpert getTypeExpert() {
        return this.typeExpert;
    }

    public void setTypeExpert(TypeExpert typeExpert) {
        this.typeExpert = typeExpert;
    }

    public RoleEvaluationRechercheUniversitaire getRoleEvaluationRechercheUniversitaire() {
        return this.roleEvaluationRechercheUniversitaire;
    }

    public void setRoleEvaluationRechercheUniversitaire(RoleEvaluationRechercheUniversitaire roleEvaluationRechercheUniversitaire) {
        this.roleEvaluationRechercheUniversitaire = roleEvaluationRechercheUniversitaire;
    }

    public Pays getPays() {
        return this.pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Etablissement getEtablissement() {
        return this.etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public BigDecimal getNombreJourConsacrePourCetteAnnee() {
        return this.nombreJourConsacrePourCetteAnnee;
    }

    public void setNombreJourConsacrePourCetteAnnee(BigDecimal nombreJourConsacrePourCetteAnnee) {
        this.nombreJourConsacrePourCetteAnnee = nombreJourConsacrePourCetteAnnee;
    }

    public List<CommunauteSavoirEvaluationRechercheUniversitaire> getCommunauteSavoirEvaluationRechercheUniversitaires() {
        return this.communauteSavoirEvaluationRechercheUniversitaires;
    }

    public void setCommunauteSavoirEvaluationRechercheUniversitaires(List<CommunauteSavoirEvaluationRechercheUniversitaire> communauteSavoirEvaluationRechercheUniversitaires) {
        this.communauteSavoirEvaluationRechercheUniversitaires = communauteSavoirEvaluationRechercheUniversitaires;
    }

    public List<DisciplineScientifiqueEvaluationRechercheUniversitaire> getDisciplineScientifiqueEvaluationRechercheUniversitaires() {
        return this.disciplineScientifiqueEvaluationRechercheUniversitaires;
    }

    public void setDisciplineScientifiqueEvaluationRechercheUniversitaires(List<DisciplineScientifiqueEvaluationRechercheUniversitaire> disciplineScientifiqueEvaluationRechercheUniversitaires) {
        this.disciplineScientifiqueEvaluationRechercheUniversitaires = disciplineScientifiqueEvaluationRechercheUniversitaires;
    }

    public String getCommentaire() {
        return this.commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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

    public EtatEtapeCampagne getEtatEtapeCampagne() {
        return this.etatEtapeCampagne;
    }

    public void setEtatEtapeCampagne(EtatEtapeCampagne etatEtapeCampagne) {
        this.etatEtapeCampagne = etatEtapeCampagne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvaluationRechercheUniversitaire evaluationRechercheUniversitaire = (EvaluationRechercheUniversitaire) o;
        return id != null && id.equals(evaluationRechercheUniversitaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


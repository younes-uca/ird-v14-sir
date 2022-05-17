package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.*;
import com.ird.faa.security.bean.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "chercheur")
public class Chercheur extends User {

    private String numeroMatricule;
    private String email;
    private String natureImplication;
    private String resume;
    private Boolean formationEnManagement;
    /* debut Added fields */
    private String idGraph;
    private String civilite;
    private String intitulePoste;
    private Boolean sorgho;
    private Boolean valide;
    private String typeEffectif;
    private String domaineActivite;
    private String nomNaissance;
    private Date dateDeNaissance;
    private String lieuDeNaissance;
    private String telephone;
    private String identifiantCas;
    private String commentaireDesactivation;
    private Date dateCreation;
    private Date dateModification;
    /* fin Added fields */
    private String role;

    @ManyToOne
    private TypeEntiteAdministrative typeEntiteAdministrative;
    @ManyToOne
    private EntiteAdministrative entiteAdministrative;
    @ManyToOne
    private Pays pays;
    @ManyToOne
    private Ville ville;
    @ManyToOne
    private DepartementScientifique departementScientifique;
    @ManyToOne
    private CommissionScientifique commissionScientifique;
    @ManyToOne
    private Grade grade;
    @ManyToOne
    private Corps corps;
    @ManyToOne
    private Sexe sexe;


    @OneToMany(mappedBy = "chercheur")
    private List<DomaineScientifiqueChercheur> domaineScientifiqueChercheurs;
    @OneToMany(mappedBy = "chercheur")
    private List<ZoneActiviteInteractionRecherche> zoneActiviteInteractionRecherches;
    @OneToMany(mappedBy = "chercheur")
    private List<CommunauteSavoirChercheur> communauteSavoirChercheurs;
    @OneToMany(mappedBy = "chercheur")
    private List<InstrumentsEtDispositifsIrdChercheur> instrumentsEtDispositifsIrdChercheurs;
    @OneToMany(mappedBy = "chercheur")
    private List<IdentifiantAuteurExpert> identifiantAuteurExperts;

    public Chercheur() {
        super();
    }


    public Chercheur(String username) {
        super(username);
        this.numeroMatricule = username;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroMatricule() {
        return this.numeroMatricule;
    }

    public void setNumeroMatricule(String numeroMatricule) {
        this.numeroMatricule = numeroMatricule;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TypeEntiteAdministrative getTypeEntiteAdministrative() {
        return this.typeEntiteAdministrative;
    }

    public void setTypeEntiteAdministrative(TypeEntiteAdministrative typeEntiteAdministrative) {
        this.typeEntiteAdministrative = typeEntiteAdministrative;
    }

    public EntiteAdministrative getEntiteAdministrative() {
        return this.entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrative entiteAdministrative) {
        this.entiteAdministrative = entiteAdministrative;
    }

    public Pays getPays() {
        return this.pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Ville getVille() {
        return this.ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public DepartementScientifique getDepartementScientifique() {
        return this.departementScientifique;
    }

    public void setDepartementScientifique(DepartementScientifique departementScientifique) {
        this.departementScientifique = departementScientifique;
    }

    public CommissionScientifique getCommissionScientifique() {
        return this.commissionScientifique;
    }

    public void setCommissionScientifique(CommissionScientifique commissionScientifique) {
        this.commissionScientifique = commissionScientifique;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Corps getCorps() {
        return this.corps;
    }

    public void setCorps(Corps corps) {
        this.corps = corps;
    }

    public Sexe getSexe() {
        return this.sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public List<DomaineScientifiqueChercheur> getDomaineScientifiqueChercheurs() {
        return this.domaineScientifiqueChercheurs;
    }

    public void setDomaineScientifiqueChercheurs(List<DomaineScientifiqueChercheur> domaineScientifiqueChercheurs) {
        this.domaineScientifiqueChercheurs = domaineScientifiqueChercheurs;
    }

    public List<ZoneActiviteInteractionRecherche> getZoneActiviteInteractionRecherches() {
        return this.zoneActiviteInteractionRecherches;
    }

    public void setZoneActiviteInteractionRecherches(List<ZoneActiviteInteractionRecherche> zoneActiviteInteractionRecherches) {
        this.zoneActiviteInteractionRecherches = zoneActiviteInteractionRecherches;
    }

    public List<CommunauteSavoirChercheur> getCommunauteSavoirChercheurs() {
        return this.communauteSavoirChercheurs;
    }

    public void setCommunauteSavoirChercheurs(List<CommunauteSavoirChercheur> communauteSavoirChercheurs) {
        this.communauteSavoirChercheurs = communauteSavoirChercheurs;
    }

    public List<InstrumentsEtDispositifsIrdChercheur> getInstrumentsEtDispositifsIrdChercheurs() {
        return this.instrumentsEtDispositifsIrdChercheurs;
    }

    public void setInstrumentsEtDispositifsIrdChercheurs(List<InstrumentsEtDispositifsIrdChercheur> instrumentsEtDispositifsIrdChercheurs) {
        this.instrumentsEtDispositifsIrdChercheurs = instrumentsEtDispositifsIrdChercheurs;
    }

    public String getNatureImplication() {
        return this.natureImplication;
    }

    public void setNatureImplication(String natureImplication) {
        this.natureImplication = natureImplication;
    }

    public List<IdentifiantAuteurExpert> getIdentifiantAuteurExperts() {
        return this.identifiantAuteurExperts;
    }

    public void setIdentifiantAuteurExperts(List<IdentifiantAuteurExpert> identifiantAuteurExperts) {
        this.identifiantAuteurExperts = identifiantAuteurExperts;
    }

    public String getResume() {
        return this.resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Boolean getFormationEnManagement() {
        return this.formationEnManagement;
    }

    public void setFormationEnManagement(Boolean formationEnManagement) {
        this.formationEnManagement = formationEnManagement;
    }


    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chercheur chercheur = (Chercheur) o;
        return id != null && id.equals(chercheur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public String getIdGraph() {
        return idGraph;
    }


    public void setIdGraph(String idGraph) {
        this.idGraph = idGraph;
    }


    public String getCivilite() {
        return civilite;
    }


    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }


    public String getIntitulePoste() {
        return intitulePoste;
    }


    public void setIntitulePoste(String intitulePoste) {
        this.intitulePoste = intitulePoste;
    }


    public Boolean getSorgho() {
        return sorgho;
    }


    public void setSorgho(Boolean sorgho) {
        this.sorgho = sorgho;
    }


    public Boolean getValide() {
        return valide;
    }


    public void setValide(Boolean valide) {
        this.valide = valide;
    }


    public String getTypeEffectif() {
        return typeEffectif;
    }


    public void setTypeEffectif(String typeEffectif) {
        this.typeEffectif = typeEffectif;
    }


    public String getDomaineActivite() {
        return domaineActivite;
    }


    public void setDomaineActivite(String domaineActivite) {
        this.domaineActivite = domaineActivite;
    }


    public String getNomNaissance() {
        return nomNaissance;
    }


    public void setNomNaissance(String nomNaissance) {
        this.nomNaissance = nomNaissance;
    }


    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }


    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }


    public String getLieuDeNaissance() {
        return lieuDeNaissance;
    }


    public void setLieuDeNaissance(String lieuDeNaissance) {
        this.lieuDeNaissance = lieuDeNaissance;
    }


    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getIdentifiantCas() {
        return identifiantCas;
    }


    public void setIdentifiantCas(String identifiantCas) {
        this.identifiantCas = identifiantCas;
    }


    public String getCommentaireDesactivation() {
        return commentaireDesactivation;
    }


    public void setCommentaireDesactivation(String commentaireDesactivation) {
        this.commentaireDesactivation = commentaireDesactivation;
    }


    public Date getDateCreation() {
        return dateCreation;
    }


    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }


    public Date getDateModification() {
        return dateModification;
    }


    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

}


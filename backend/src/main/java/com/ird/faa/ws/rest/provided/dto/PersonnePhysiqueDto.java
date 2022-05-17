package com.ird.faa.ws.rest.provided.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonnePhysiqueDto {
	private String id;
	private String civilite;
	private String usage;
	private String prenom;
	private String matricule;
	private String intitulePoste;
	private CorpsDto corps;
	private GradeDto grade;
	private CommissionDto commission;
	private PositionStatutaireDto positionStatutaire;
	private Boolean sorgho;
	private Boolean valide;
	private PartenaireEmployeurDto partenaireEmployeur;
	private BrancheActiviteProfessionnelleDto brancheActiviteProfessionnelle;
	private FamilleProfessionnelleDto familleProfessionnelle;
	private EmploiType emploiType;
	private CategorieSalarieDto categorieSalarie;
	private StatutSalarieDto statutSalarie;
	private String typeEffectif;
	private String domaineActivite;
	private TypePersonnelDto typePersonnel;
	private String nomNaissance;
	private Date dateDeNaissance;
	private String lieuDeNaissance;
	private PaysDto paysNationalite;
	private String telephone;
	private String identifiantCas;
	private String courriel;
	private List<AffectationLegaleDto> affectationsLegales;
	private List<AffectationSousStructureDto> affectationsSousStructures;
	private AffectationGeographiqueDto affectationGeographique;
	private String commentaireDesactivation;
	private Boolean anonyme;
	private Date dateCreation;
	private Date dateModification;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getIntitulePoste() {
		return intitulePoste;
	}

	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}

	public CorpsDto getCorps() {
		return corps;
	}

	public void setCorps(CorpsDto corps) {
		this.corps = corps;
	}

	public GradeDto getGrade() {
		return grade;
	}

	public void setGrade(GradeDto grade) {
		this.grade = grade;
	}

	public CommissionDto getCommission() {
		return commission;
	}

	public void setCommission(CommissionDto commission) {
		this.commission = commission;
	}

	public PositionStatutaireDto getPositionStatutaire() {
		return positionStatutaire;
	}

	public void setPositionStatutaire(PositionStatutaireDto positionStatutaire) {
		this.positionStatutaire = positionStatutaire;
	}

	public Boolean isSorgho() {
		return sorgho;
	}

	public void setSorgho(Boolean sorgho) {
		this.sorgho = sorgho;
	}

	public Boolean isValide() {
		return valide;
	}

	public void setValide(Boolean valide) {
		this.valide = valide;
	}

	public PartenaireEmployeurDto getPartenaireEmployeur() {
		return partenaireEmployeur;
	}

	public void setPartenaireEmployeur(PartenaireEmployeurDto partenaireEmployeur) {
		this.partenaireEmployeur = partenaireEmployeur;
	}

	public BrancheActiviteProfessionnelleDto getBrancheActiviteProfessionnelle() {
		return brancheActiviteProfessionnelle;
	}

	public void setBrancheActiviteProfessionnelle(BrancheActiviteProfessionnelleDto brancheActiviteProfessionnelle) {
		this.brancheActiviteProfessionnelle = brancheActiviteProfessionnelle;
	}

	public FamilleProfessionnelleDto getFamilleProfessionnelle() {
		return familleProfessionnelle;
	}

	public void setFamilleProfessionnelle(FamilleProfessionnelleDto familleProfessionnelle) {
		this.familleProfessionnelle = familleProfessionnelle;
	}

	public EmploiType getEmploiType() {
		return emploiType;
	}

	public void setEmploiType(EmploiType emploiType) {
		this.emploiType = emploiType;
	}

	public CategorieSalarieDto getCategorieSalarie() {
		return categorieSalarie;
	}

	public void setCategorieSalarie(CategorieSalarieDto categorieSalarie) {
		this.categorieSalarie = categorieSalarie;
	}

	public StatutSalarieDto getStatutSalarie() {
		return statutSalarie;
	}

	public void setStatutSalarie(StatutSalarieDto statutSalarie) {
		this.statutSalarie = statutSalarie;
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

	public TypePersonnelDto getTypePersonnel() {
		return typePersonnel;
	}

	public void setTypePersonnel(TypePersonnelDto typePersonnel) {
		this.typePersonnel = typePersonnel;
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

	public PaysDto getPaysNationalite() {
		return paysNationalite;
	}

	public void setPaysNationalite(PaysDto paysNationalite) {
		this.paysNationalite = paysNationalite;
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

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public List<AffectationLegaleDto> getAffectationsLegales() {
		return affectationsLegales;
	}

	public void setAffectationsLegales(List<AffectationLegaleDto> affectationsLegales) {
		this.affectationsLegales = affectationsLegales;
	}

	public List<AffectationSousStructureDto> getAffectationsSousStructures() {
		return affectationsSousStructures;
	}

	public void setAffectationsSousStructures(List<AffectationSousStructureDto> affectationsSousStructures) {
		this.affectationsSousStructures = affectationsSousStructures;
	}

	public AffectationGeographiqueDto getAffectationGeographique() {
		return affectationGeographique;
	}

	public void setAffectationGeographique(AffectationGeographiqueDto affectationGeographique) {
		this.affectationGeographique = affectationGeographique;
	}

	public String getCommentaireDesactivation() {
		return commentaireDesactivation;
	}

	public void setCommentaireDesactivation(String commentaireDesactivation) {
		this.commentaireDesactivation = commentaireDesactivation;
	}

	public Boolean isAnonyme() {
		return anonyme;
	}

	public void setAnonyme(Boolean anonyme) {
		this.anonyme = anonyme;
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

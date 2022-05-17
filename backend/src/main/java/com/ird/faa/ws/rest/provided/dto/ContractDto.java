package com.ird.faa.ws.rest.provided.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContractDto {
	private String id;   
	private String numeroContrat;	
	private String intitule;
	private String description;
	private ProgrammeFinancementDto programmeFinancement;
	private List<PartenaireContratDto> partenairesLies;
	private String statut;
	private Date dateCreationContrat;
	private Date dateEntreeEnVigueur;
	private int dureeEnMois;
	private Date dateFin;
	private String thematique;
	
	private PersonnePhysiqueDto personnePhysiquePorteurDeProjet;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(String numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProgrammeFinancementDto getProgrammeFinancement() {
		return programmeFinancement;
	}

	public void setProgrammeFinancement(ProgrammeFinancementDto programmeFinancement) {
		this.programmeFinancement = programmeFinancement;
	}

	public List<PartenaireContratDto> getPartenairesLies() {
		return partenairesLies;
	}

	public void setPartenairesLies(List<PartenaireContratDto> partenairesLies) {
		this.partenairesLies = partenairesLies;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
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

	public int getDureeEnMois() {
		return dureeEnMois;
	}

	public void setDureeEnMois(int dureeEnMois) {
		this.dureeEnMois = dureeEnMois;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getThematique() {
		return thematique;
	}

	public void setThematique(String thematique) {
		this.thematique = thematique;
	}

	public PersonnePhysiqueDto getPersonnePhysiquePorteurDeProjet() {
		return personnePhysiquePorteurDeProjet;
	}

	public void setPersonnePhysiquePorteurDeProjet(PersonnePhysiqueDto personnePhysiquePorteurDeProjet) {
		this.personnePhysiquePorteurDeProjet = personnePhysiquePorteurDeProjet;
	}
	
}

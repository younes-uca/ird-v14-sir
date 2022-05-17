package com.ird.faa.ws.rest.provided.vo;

import java.util.Date;
import java.util.List;

public class ContratEtConventionIrdVo {

	private String id;
	private String numero;
	private Date dateCreationContrat;
	private Date dateFinContrat;
	private Date dateEntreeEnVigueurContrat;
	private int dureeEnMois;
	private String programmeFinancement;
	private String numMatriculePorteur;
	private String intitule;
	private String description;
	private Date dateCreationContratMin;
	private Date dateCreationContratMax;
	private StatusContratEtConventionVo statusContratEtConventionVo;
	private List<PartenaireVo> partenairesVo;

	private SavoirEtInnovationVo savoirEtInnovationVo;
	private EtatEtapeCampagneVo etatEtapeCampagneVo;

	public ContratEtConventionIrdVo() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public Date getDateCreationContrat() {
		return dateCreationContrat;
	}

	public void setDateCreationContrat(Date dateCreationContrat) {
		this.dateCreationContrat = dateCreationContrat;
	}

	public Date getDateFinContrat() {
		return dateFinContrat;
	}

	public void setDateFinContrat(Date dateFinContrat) {
		this.dateFinContrat = dateFinContrat;
	}


	public Date getDateEntreeEnVigueurContrat() {
		return dateEntreeEnVigueurContrat;
	}

	public void setDateEntreeEnVigueurContrat(Date dateEntreeEnVigueurContrat) {
		this.dateEntreeEnVigueurContrat = dateEntreeEnVigueurContrat;
	}

	public int getDureeEnMois() {
		return dureeEnMois;
	}

	public void setDureeEnMois(int dureeEnMois) {
		this.dureeEnMois = dureeEnMois;
	}

	public Date getDateCreationContratMin() {
		return dateCreationContratMin;
	}

	public void setDateCreationContratMin(Date dateCreationContratMin) {
		this.dateCreationContratMin = dateCreationContratMin;
	}

	public Date getDateCreationContratMax() {
		return dateCreationContratMax;
	}

	public void setDateCreationContratMax(Date dateCreationContratMax) {
		this.dateCreationContratMax = dateCreationContratMax;
	}

	public StatusContratEtConventionVo getStatusContratEtConventionVo() {
		return this.statusContratEtConventionVo;
	}

	public void setStatusContratEtConventionVo(StatusContratEtConventionVo statusContratEtConventionVo) {
		this.statusContratEtConventionVo = statusContratEtConventionVo;
	}

	public SavoirEtInnovationVo getSavoirEtInnovationVo() {
		return this.savoirEtInnovationVo;
	}

	public void setSavoirEtInnovationVo(SavoirEtInnovationVo savoirEtInnovationVo) {
		this.savoirEtInnovationVo = savoirEtInnovationVo;
	}

	public EtatEtapeCampagneVo getEtatEtapeCampagneVo() {
		return this.etatEtapeCampagneVo;
	}

	public void setEtatEtapeCampagneVo(EtatEtapeCampagneVo etatEtapeCampagneVo) {
		this.etatEtapeCampagneVo = etatEtapeCampagneVo;
	}

	public List<PartenaireVo> getPartenairesVo() {
		return partenairesVo;
	}

	public void setPartenairesVo(List<PartenaireVo> partenairesVo) {
		this.partenairesVo = partenairesVo;
	}

}

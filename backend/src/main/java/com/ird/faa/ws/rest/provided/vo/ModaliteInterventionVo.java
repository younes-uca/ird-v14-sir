package com.ird.faa.ws.rest.provided.vo;

public class ModaliteInterventionVo {

	private String id;
	private String libelle;
	private String code;
	private String description;
	private Boolean archive;
	private String dateArchivage;

	private String dateArchivageMax;
	private String dateArchivageMin;

	public ModaliteInterventionVo() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getArchive() {
		return this.archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public String getDateArchivage() {
		return this.dateArchivage;
	}

	public void setDateArchivage(String dateArchivage) {
		this.dateArchivage = dateArchivage;
	}

	public String getDateArchivageMax() {
		return this.dateArchivageMax;
	}

	public String getDateArchivageMin() {
		return this.dateArchivageMin;
	}

	public void setDateArchivageMax(String dateArchivageMax) {
		this.dateArchivageMax = dateArchivageMax;
	}

	public void setDateArchivageMin(String dateArchivageMin) {
		this.dateArchivageMin = dateArchivageMin;
	}

}

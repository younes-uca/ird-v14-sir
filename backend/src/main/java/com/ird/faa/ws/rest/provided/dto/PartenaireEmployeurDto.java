package com.ird.faa.ws.rest.provided.dto;

public class PartenaireEmployeurDto {
	private String id;
	private TypePartenaireDto typePartenaire;
	private String nomOfficiel;
	private String secteur;
	private String sigleOfficiel;
	private String sigle;
	private String adresse;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TypePartenaireDto getTypePartenaire() {
		return typePartenaire;
	}
	public void setTypePartenaire(TypePartenaireDto typePartenaire) {
		this.typePartenaire = typePartenaire;
	}
	public String getNomOfficiel() {
		return nomOfficiel;
	}
	public void setNomOfficiel(String nomOfficiel) {
		this.nomOfficiel = nomOfficiel;
	}
	public String getSecteur() {
		return secteur;
	}
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
	public String getSigleOfficiel() {
		return sigleOfficiel;
	}
	public void setSigleOfficiel(String sigleOfficiel) {
		this.sigleOfficiel = sigleOfficiel;
	}
	public String getSigle() {
		return sigle;
	}
	public void setSigle(String sigle) {
		this.sigle = sigle;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}

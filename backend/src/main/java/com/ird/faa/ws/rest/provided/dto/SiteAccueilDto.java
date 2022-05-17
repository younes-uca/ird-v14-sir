package com.ird.faa.ws.rest.provided.dto;

public class SiteAccueilDto {
	private String id;
	private PaysDto pays;
	private String code;
	private String acronyme;
	private String libelle;
	private String adresse;
	private CoordonneesDto coordonnees;
	private boolean valide;
	private boolean sorgho;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PaysDto getPays() {
		return pays;
	}
	public void setPays(PaysDto pays) {
		this.pays = pays;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAcronyme() {
		return acronyme;
	}
	public void setAcronyme(String acronyme) {
		this.acronyme = acronyme;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public CoordonneesDto getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(CoordonneesDto coordonnees) {
		this.coordonnees = coordonnees;
	}
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public boolean isSorgho() {
		return sorgho;
	}
	public void setSorgho(boolean sorgho) {
		this.sorgho = sorgho;
	}

}

package com.ird.faa.ws.rest.provided.vo;

import com.ird.faa.ws.rest.provided.dto.TypePartenaireDto;

public class PartenaireVo {
	private String id;
	private String idGraphQl;
	private TypePartenaireDto typePartenaire;
	private String nomOfficiel;
	private String secteur;
	private String sigleOfficiel;
	private String sigle;
	private String adresse;
	private PaysVo pays;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getIdGraphQl() {
		return idGraphQl;
	}
	public void setIdGraphQl(String idGraphQl) {
		this.idGraphQl = idGraphQl;
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
	public PaysVo getPays() {
		return pays;
	}
	public void setPays(PaysVo pays) {
		this.pays = pays;
	}
	
	
}

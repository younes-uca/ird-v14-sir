package com.ird.faa.ws.rest.provided.dto;

public class ContactDto {
	private String id;
	private PersonnePhysiqueDto personnePhysique;
	private String telephone;
	private String mail;
	private String fonction;
	private int ordre;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PersonnePhysiqueDto getPersonnePhysique() {
		return personnePhysique;
	}
	public void setPersonnePhysique(PersonnePhysiqueDto personnePhysique) {
		this.personnePhysique = personnePhysique;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	
}

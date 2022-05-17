package com.ird.faa.ws.rest.provided.vo;

public class DeveloppementDeSavoirEtInnovationScientifiqueTypeUtilisateurVo {

	private String id;

	private TypeUtilisateurVo typeUtilisateurVo;
	private DeveloppementDeSavoirEtInnovationScientifiqueVo developpementDeSavoirEtInnovationScientifiqueVo;

	public DeveloppementDeSavoirEtInnovationScientifiqueTypeUtilisateurVo() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TypeUtilisateurVo getTypeUtilisateurVo() {
		return this.typeUtilisateurVo;
	}

	public void setTypeUtilisateurVo(TypeUtilisateurVo typeUtilisateurVo) {
		this.typeUtilisateurVo = typeUtilisateurVo;
	}

	public DeveloppementDeSavoirEtInnovationScientifiqueVo getDeveloppementDeSavoirEtInnovationScientifiqueVo() {
		return this.developpementDeSavoirEtInnovationScientifiqueVo;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiqueVo(
			DeveloppementDeSavoirEtInnovationScientifiqueVo developpementDeSavoirEtInnovationScientifiqueVo) {
		this.developpementDeSavoirEtInnovationScientifiqueVo = developpementDeSavoirEtInnovationScientifiqueVo;
	}

}

package com.ird.faa.ws.rest.provided.vo;

public class DeveloppementDeSavoirEtInnovationScientifiqueRoleVo {

	private String id;

	private RoleDeveloppementDeSavoirVo roleDeveloppementDeSavoirVo;
	private DeveloppementDeSavoirEtInnovationScientifiqueVo developpementDeSavoirEtInnovationScientifiqueVo;

	public DeveloppementDeSavoirEtInnovationScientifiqueRoleVo() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RoleDeveloppementDeSavoirVo getRoleDeveloppementDeSavoirVo() {
		return roleDeveloppementDeSavoirVo;
	}

	public void setRoleDeveloppementDeSavoirVo(RoleDeveloppementDeSavoirVo roleDeveloppementDeSavoirVo) {
		this.roleDeveloppementDeSavoirVo = roleDeveloppementDeSavoirVo;
	}

	public DeveloppementDeSavoirEtInnovationScientifiqueVo getDeveloppementDeSavoirEtInnovationScientifiqueVo() {
		return this.developpementDeSavoirEtInnovationScientifiqueVo;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiqueVo(
			DeveloppementDeSavoirEtInnovationScientifiqueVo developpementDeSavoirEtInnovationScientifiqueVo) {
		this.developpementDeSavoirEtInnovationScientifiqueVo = developpementDeSavoirEtInnovationScientifiqueVo;
	}

}

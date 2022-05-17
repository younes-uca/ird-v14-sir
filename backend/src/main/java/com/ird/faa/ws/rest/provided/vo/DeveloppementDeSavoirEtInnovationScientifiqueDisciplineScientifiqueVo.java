package com.ird.faa.ws.rest.provided.vo;

public class DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo {

	private String id;

	private DisciplineScientifiqueVo disciplineScientifiqueVo;
	private DeveloppementDeSavoirEtInnovationScientifiqueVo developpementDeSavoirEtInnovationScientifiqueVo;

	public DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public DisciplineScientifiqueVo getDisciplineScientifiqueVo() {
		return disciplineScientifiqueVo;
	}

	public void setDisciplineScientifiqueVo(DisciplineScientifiqueVo disciplineScientifiqueVo) {
		this.disciplineScientifiqueVo = disciplineScientifiqueVo;
	}

	public DeveloppementDeSavoirEtInnovationScientifiqueVo getDeveloppementDeSavoirEtInnovationScientifiqueVo() {
		return this.developpementDeSavoirEtInnovationScientifiqueVo;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiqueVo(
			DeveloppementDeSavoirEtInnovationScientifiqueVo developpementDeSavoirEtInnovationScientifiqueVo) {
		this.developpementDeSavoirEtInnovationScientifiqueVo = developpementDeSavoirEtInnovationScientifiqueVo;
	}

}

package com.ird.faa.ws.rest.provided.vo;

public class DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo {

	private String id;

	private InstrumentIrdVo instrumentIrdVo;
	private DeveloppementDeSavoirEtInnovationScientifiqueVo developpementDeSavoirEtInnovationScientifiqueVo;

	public DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public InstrumentIrdVo getInstrumentIrdVo() {
		return this.instrumentIrdVo;
	}

	public void setInstrumentIrdVo(InstrumentIrdVo instrumentIrdVo) {
		this.instrumentIrdVo = instrumentIrdVo;
	}

	public DeveloppementDeSavoirEtInnovationScientifiqueVo getDeveloppementDeSavoirEtInnovationScientifiqueVo() {
		return this.developpementDeSavoirEtInnovationScientifiqueVo;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiqueVo(
			DeveloppementDeSavoirEtInnovationScientifiqueVo developpementDeSavoirEtInnovationScientifiqueVo) {
		this.developpementDeSavoirEtInnovationScientifiqueVo = developpementDeSavoirEtInnovationScientifiqueVo;
	}

}

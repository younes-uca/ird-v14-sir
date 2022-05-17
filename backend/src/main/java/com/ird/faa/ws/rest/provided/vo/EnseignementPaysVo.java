package com.ird.faa.ws.rest.provided.vo;

public class EnseignementPaysVo {

	private String id;

	private PaysVo paysVo;
	private EnseignementVo enseignementVo;

	public EnseignementPaysVo() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PaysVo getPaysVo() {
		return this.paysVo;
	}

	public void setPaysVo(PaysVo paysVo) {
		this.paysVo = paysVo;
	}

	public EnseignementVo getEnseignementVo() {
		return this.enseignementVo;
	}

	public void setEnseignementVo(EnseignementVo enseignementVo) {
		this.enseignementVo = enseignementVo;
	}

}

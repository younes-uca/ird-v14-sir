package com.ird.faa.ws.rest.provided.vo;

public class ProgrammeFinancementVo {
	private String id;
	private String code;
	private String libelleCourt;
	private String libelleLong;
	private int ordre;
	private boolean valide;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelleCourt() {
		return libelleCourt;
	}

	public void setLibelleCourt(String libelleCourt) {
		this.libelleCourt = libelleCourt;
	}

	public String getLibelleLong() {
		return libelleLong;
	}

	public void setLibelleLong(String libelleLong) {
		this.libelleLong = libelleLong;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

}

package com.ird.faa.ws.rest.provided.dto;

public class AffectationSousStructureDto {
	private String id;
	private RoleStructureDto role;
	private String quotite;
	private PeriodeDto periode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public RoleStructureDto getRole() {
		return role;
	}
	public void setRole(RoleStructureDto role) {
		this.role = role;
	}
	public String getQuotite() {
		return quotite;
	}
	public void setQuotite(String quotite) {
		this.quotite = quotite;
	}
	public PeriodeDto getPeriode() {
		return periode;
	}
	public void setPeriode(PeriodeDto periode) {
		this.periode = periode;
	}
	
}

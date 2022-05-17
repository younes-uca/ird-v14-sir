package com.ird.faa.ws.rest.provided.dto;

public class StructureDto {
	private String id;
	private String code;
	private String codeSinaps;
	private String identifiantNational;
	private String siteWeb;
	private boolean visible;
	private boolean sorgho;
	private String libelleCourt;
	private String libelleLong;
	private String description;
	private String objectif;
	
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
	public String getCodeSinaps() {
		return codeSinaps;
	}
	public void setCodeSinaps(String codeSinaps) {
		this.codeSinaps = codeSinaps;
	}
	public String getIdentifiantNational() {
		return identifiantNational;
	}
	public void setIdentifiantNational(String identifiantNational) {
		this.identifiantNational = identifiantNational;
	}
	public String getSiteWeb() {
		return siteWeb;
	}
	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean isSorgho() {
		return sorgho;
	}
	public void setSorgho(boolean sorgho) {
		this.sorgho = sorgho;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	
}

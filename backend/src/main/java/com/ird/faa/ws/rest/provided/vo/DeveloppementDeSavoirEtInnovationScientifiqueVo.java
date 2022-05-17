package com.ird.faa.ws.rest.provided.vo;

import java.util.Date;
import java.util.List;

public class DeveloppementDeSavoirEtInnovationScientifiqueVo {

	private String id;
	private String titreInstrument;
	private Date anneeMiseEnOeuvre;
	private String lienWeb;

	private String anneeMiseEnOeuvreMax;
	private String anneeMiseEnOeuvreMin;

	private RoleDeveloppementDeSavoirVo roleDeveloppementDeSavoirVo;
	private SavoirEtInnovationVo savoirEtInnovationVo;
	private EtatEtapeCampagneVo etatEtapeCampagneVo;

	private List<TypeSavoirDeveloppementDeSavoirEtInnovationScientifiqueVo> typeSavoirDeveloppementDeSavoirEtInnovationScientifiquesVo;
	private List<TypeUtilisateurSavoirConcuVo> typeUtilisateurSavoirConcusVo;
	private List<DeveloppementDeSavoirEtInnovationScientifiqueModeDiffusionVo> developpementDeSavoirEtInnovationScientifiqueModeDiffusionsVo;
	private List<DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrdVo> developpementDeSavoirEtInnovationScientifiqueEnjeuxIrdsVo;
	private List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo> developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiquesVo;
	private List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo> developpementDeSavoirEtInnovationScientifiqueInstrumentIrdsVo;
	private List<DeveloppementDeSavoirEtInnovationScientifiquePaysVo> developpementDeSavoirEtInnovationScientifiquePayssVo;
	private List<DeveloppementDeSavoirEtInnovationScientifiqueRoleVo> developpementDeSavoirEtInnovationScientifiqueRolesVo;

	public DeveloppementDeSavoirEtInnovationScientifiqueVo() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitreInstrument() {
		return this.titreInstrument;
	}

	public void setTitreInstrument(String titreInstrument) {
		this.titreInstrument = titreInstrument;
	}

	public Date getAnneeMiseEnOeuvre() {
		return this.anneeMiseEnOeuvre;
	}

	public void setAnneeMiseEnOeuvre(Date anneeMiseEnOeuvre) {
		this.anneeMiseEnOeuvre = anneeMiseEnOeuvre;
	}

	public String getLienWeb() {
		return this.lienWeb;
	}

	public void setLienWeb(String lienWeb) {
		this.lienWeb = lienWeb;
	}

	public String getAnneeMiseEnOeuvreMax() {
		return this.anneeMiseEnOeuvreMax;
	}

	public String getAnneeMiseEnOeuvreMin() {
		return this.anneeMiseEnOeuvreMin;
	}

	public void setAnneeMiseEnOeuvreMax(String anneeMiseEnOeuvreMax) {
		this.anneeMiseEnOeuvreMax = anneeMiseEnOeuvreMax;
	}

	public void setAnneeMiseEnOeuvreMin(String anneeMiseEnOeuvreMin) {
		this.anneeMiseEnOeuvreMin = anneeMiseEnOeuvreMin;
	}

	public RoleDeveloppementDeSavoirVo getRoleDeveloppementDeSavoirVo() {
		return this.roleDeveloppementDeSavoirVo;
	}

	public void setRoleDeveloppementDeSavoirVo(RoleDeveloppementDeSavoirVo roleDeveloppementDeSavoirVo) {
		this.roleDeveloppementDeSavoirVo = roleDeveloppementDeSavoirVo;
	}

	public SavoirEtInnovationVo getSavoirEtInnovationVo() {
		return this.savoirEtInnovationVo;
	}

	public void setSavoirEtInnovationVo(SavoirEtInnovationVo savoirEtInnovationVo) {
		this.savoirEtInnovationVo = savoirEtInnovationVo;
	}

	public EtatEtapeCampagneVo getEtatEtapeCampagneVo() {
		return this.etatEtapeCampagneVo;
	}

	public void setEtatEtapeCampagneVo(EtatEtapeCampagneVo etatEtapeCampagneVo) {
		this.etatEtapeCampagneVo = etatEtapeCampagneVo;
	}

	public List<TypeSavoirDeveloppementDeSavoirEtInnovationScientifiqueVo> getTypeSavoirDeveloppementDeSavoirEtInnovationScientifiquesVo() {
		return this.typeSavoirDeveloppementDeSavoirEtInnovationScientifiquesVo;
	}

	public void setTypeSavoirDeveloppementDeSavoirEtInnovationScientifiquesVo(
			List<TypeSavoirDeveloppementDeSavoirEtInnovationScientifiqueVo> typeSavoirDeveloppementDeSavoirEtInnovationScientifiquesVo) {
		this.typeSavoirDeveloppementDeSavoirEtInnovationScientifiquesVo = typeSavoirDeveloppementDeSavoirEtInnovationScientifiquesVo;
	}

	public List<TypeUtilisateurSavoirConcuVo> getTypeUtilisateurSavoirConcusVo() {
		return this.typeUtilisateurSavoirConcusVo;
	}

	public void setTypeUtilisateurSavoirConcusVo(List<TypeUtilisateurSavoirConcuVo> typeUtilisateurSavoirConcusVo) {
		this.typeUtilisateurSavoirConcusVo = typeUtilisateurSavoirConcusVo;
	}

	public List<DeveloppementDeSavoirEtInnovationScientifiqueModeDiffusionVo> getDeveloppementDeSavoirEtInnovationScientifiqueModeDiffusionsVo() {
		return this.developpementDeSavoirEtInnovationScientifiqueModeDiffusionsVo;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiqueModeDiffusionsVo(
			List<DeveloppementDeSavoirEtInnovationScientifiqueModeDiffusionVo> developpementDeSavoirEtInnovationScientifiqueModeDiffusionsVo) {
		this.developpementDeSavoirEtInnovationScientifiqueModeDiffusionsVo = developpementDeSavoirEtInnovationScientifiqueModeDiffusionsVo;
	}

	public List<DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrdVo> getDeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrdsVo() {
		return this.developpementDeSavoirEtInnovationScientifiqueEnjeuxIrdsVo;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrdsVo(
			List<DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrdVo> developpementDeSavoirEtInnovationScientifiqueEnjeuxIrdsVo) {
		this.developpementDeSavoirEtInnovationScientifiqueEnjeuxIrdsVo = developpementDeSavoirEtInnovationScientifiqueEnjeuxIrdsVo;
	}

	public List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo> getDeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiquesVo() {
		return this.developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiquesVo;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiquesVo(
			List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo> developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiquesVo) {
		this.developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiquesVo = developpementDeSavoirEtInnovationScientifiqueDisciplineScientifiquesVo;
	}

	public List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo> getDeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdsVo() {
		return this.developpementDeSavoirEtInnovationScientifiqueInstrumentIrdsVo;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdsVo(
			List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo> developpementDeSavoirEtInnovationScientifiqueInstrumentIrdsVo) {
		this.developpementDeSavoirEtInnovationScientifiqueInstrumentIrdsVo = developpementDeSavoirEtInnovationScientifiqueInstrumentIrdsVo;
	}

	public List<DeveloppementDeSavoirEtInnovationScientifiquePaysVo> getDeveloppementDeSavoirEtInnovationScientifiquePayssVo() {
		return this.developpementDeSavoirEtInnovationScientifiquePayssVo;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiquePayssVo(
			List<DeveloppementDeSavoirEtInnovationScientifiquePaysVo> developpementDeSavoirEtInnovationScientifiquePayssVo) {
		this.developpementDeSavoirEtInnovationScientifiquePayssVo = developpementDeSavoirEtInnovationScientifiquePayssVo;
	}

	public List<DeveloppementDeSavoirEtInnovationScientifiqueRoleVo> getDeveloppementDeSavoirEtInnovationScientifiqueRolesVo() {
		return this.developpementDeSavoirEtInnovationScientifiqueRolesVo;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiqueRolesVo(
			List<DeveloppementDeSavoirEtInnovationScientifiqueRoleVo> developpementDeSavoirEtInnovationScientifiqueRolesVo) {
		this.developpementDeSavoirEtInnovationScientifiqueRolesVo = developpementDeSavoirEtInnovationScientifiqueRolesVo;
	}

}

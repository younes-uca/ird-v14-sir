package com.ird.faa.ws.rest.provided.dto;

import java.util.List;

public class AffectationLegaleDto {
	private String id;
	private PersonnePhysiqueDto personnePhysique;
	private StructureDto structure;
	private boolean principale;
	private RoleStructureDto roleStructure;
	private String quotite;
	private boolean canDelete;
	private PeriodeDto periode;
	private List<ContactDto> contacts;
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
	public StructureDto getStructure() {
		return structure;
	}
	public void setStructure(StructureDto structure) {
		this.structure = structure;
	}
	public boolean isPrincipale() {
		return principale;
	}
	public void setPrincipale(boolean principale) {
		this.principale = principale;
	}
	public RoleStructureDto getRoleStructure() {
		return roleStructure;
	}
	public void setRoleStructure(RoleStructureDto roleStructure) {
		this.roleStructure = roleStructure;
	}
	public String getQuotite() {
		return quotite;
	}
	public void setQuotite(String quotite) {
		this.quotite = quotite;
	}
	public boolean isCanDelete() {
		return canDelete;
	}
	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}
	public PeriodeDto getPeriode() {
		return periode;
	}
	public void setPeriode(PeriodeDto periode) {
		this.periode = periode;
	}
	public List<ContactDto> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactDto> contacts) {
		this.contacts = contacts;
	}
	
}

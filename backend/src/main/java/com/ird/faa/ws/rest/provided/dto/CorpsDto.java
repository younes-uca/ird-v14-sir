package com.ird.faa.ws.rest.provided.dto;

import java.util.List;

public class CorpsDto extends GenericDto{
	private TypePersonnelDto typePersonnel;
    private List<EmploiType> emploisTypes;
	public TypePersonnelDto getTypePersonnel() {
		return typePersonnel;
	}

	public void setTypePersonnel(TypePersonnelDto typePersonnel) {
		this.typePersonnel = typePersonnel;
	}

	public List<EmploiType> getEmploiTypes() {
		return emploisTypes;
	}

	public void setEmploisTypes(List<EmploiType> emploisTypes) {
		this.emploisTypes = emploisTypes;
	}	
	
}

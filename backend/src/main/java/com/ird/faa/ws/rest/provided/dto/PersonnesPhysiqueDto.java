package com.ird.faa.ws.rest.provided.dto;

import java.util.List;

public class PersonnesPhysiqueDto {
	private List<PersonnePhysiqueDto> personnesPhysiques;

	public List<PersonnePhysiqueDto> getPersonnesPhysiques() {
		return personnesPhysiques;
	}

	public void setPersonnesPhysiques(List<PersonnePhysiqueDto> personnesPhysiques) {
		this.personnesPhysiques = personnesPhysiques;
	}
	
}

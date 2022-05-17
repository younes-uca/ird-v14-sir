package com.ird.faa.service.admin.facade.formulaire;

import java.util.Map;

import com.ird.faa.ws.rest.provided.dto.PersonnesPhysiqueDto;

public interface ChercheursImportService {
  public PersonnesPhysiqueDto getChercheurs();
  public Map<String,Object> updateOrAddChercheur();
}

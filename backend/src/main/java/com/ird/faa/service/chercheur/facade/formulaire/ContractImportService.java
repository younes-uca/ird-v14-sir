package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.Map;

import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.ws.rest.provided.dto.ContractsDto;

public interface ContractImportService {

	public ContractsDto getContracts(Chercheur chercheur);

	public Map<String, Object> updateOrAddContract(String username);
}

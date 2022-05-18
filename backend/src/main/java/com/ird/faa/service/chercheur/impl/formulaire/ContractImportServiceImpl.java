package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.bean.formulaire.ContratEtConventionIrd;
import com.ird.faa.service.admin.facade.formulaire.GraphqlService;
import com.ird.faa.service.chercheur.facade.formulaire.ChercheurChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.ContractImportService;
import com.ird.faa.service.chercheur.facade.formulaire.ContratEtConventionIrdChercheurService;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.ContractDtoToVoConverter;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.ContratEtConventionIrdConverter;
import com.ird.faa.ws.rest.provided.dto.ContractDto;
import com.ird.faa.ws.rest.provided.dto.ContractsDto;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ContratEtConventionIrdVo;

@Service
public class ContractImportServiceImpl implements ContractImportService {

	@Autowired
	private GraphqlService graphqlService;

	@Autowired
	private ChercheurChercheurService chercheurService;

	@Autowired
	private ContratEtConventionIrdChercheurService contratEtConventionIrdChercheurService;

	@Autowired
	private ContratEtConventionIrdConverter contratEtConventionIrdConverter;

	@Autowired
	private ContractDtoToVoConverter contratDtoToVoConverter;

	@Value("${url.graphql}")
	private String url;

	@Value("${query.contract}")
	private String queryContracts;

	@Override
	public ContractsDto getContracts(Chercheur chercheur) {
		try {
			String query = queryContracts.replace("$matricule", chercheur.getNumeroMatricule());
			ResponseEntity<String> chercheurs = graphqlService.executeQuery(url, query);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(chercheurs.getBody());
			JsonNode data = rootNode.path("data");
			ContractsDto contractsDto = mapper.treeToValue(data, ContractsDto.class);
			return contractsDto;
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		 catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public Map<String, Object> updateOrAddContract(String username) {
		Map<String, Object> result = new HashMap<>();
		Chercheur chercheur = chercheurService.findByUsername(username);
		if (chercheur != null) {
			ContractsDto contractsDto = this.getContracts(chercheur);
			if (contractsDto != null) {
				List<ContratEtConventionIrd> existingContratsDeclarant = contratEtConventionIrdChercheurService
						.findByChercheur(chercheur);
				contratEtConventionIrdChercheurService.delete(existingContratsDeclarant);
				List<ContractDto> contracts = contractsDto.getContrats();
				AtomicInteger countAdded = new AtomicInteger(0);
				contracts.forEach(contract -> {
					ContratEtConventionIrdVo contratVo = contratDtoToVoConverter.toVo(contract);
					ContratEtConventionIrd contratEtConventionIrd = contratEtConventionIrdConverter.toItem(contratVo);
					ContratEtConventionIrd savedContract = contratEtConventionIrdChercheurService
							.saveFromGraphQl(contratEtConventionIrd);
					if (savedContract != null) {
						countAdded.getAndIncrement();
					}
				});
				result.put("success", true);
				result.put("nbAdded", countAdded);
				return result;
			}
		}
		return null;
	}

}

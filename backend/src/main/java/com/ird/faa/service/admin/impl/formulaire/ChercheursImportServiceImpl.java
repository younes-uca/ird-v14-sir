package com.ird.faa.service.admin.impl.formulaire;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.service.admin.facade.formulaire.ChercheurAdminService;
import com.ird.faa.service.admin.facade.formulaire.ChercheursImportService;
import com.ird.faa.service.admin.facade.formulaire.GraphqlService;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.ChercheurConverter;
import main.java.com.ird.faa.ws.rest.provided.converter.formulaire.ChercheurDtoToVoConverter;
import com.ird.faa.ws.rest.provided.dto.PersonnePhysiqueDto;
import com.ird.faa.ws.rest.provided.dto.PersonnesPhysiqueDto;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ChercheurVo;

@Service
public class ChercheursImportServiceImpl implements ChercheursImportService{
	@Autowired
	private GraphqlService graphqlService;
	
	@Value("${url.graphql}")
	private String url;
	
	@Value("${query.chercheur}")
	private String queryChercheurs;
	
	@Autowired
	private ChercheurDtoToVoConverter chercheurDtoToVoConverter;
	
	@Autowired
	private ChercheurConverter chercheurConverter;
	
	@Autowired
	private ChercheurAdminService chercheurService;
	
	@Override
	public PersonnesPhysiqueDto getChercheurs() {
		ResponseEntity<String> chercheurs=graphqlService.executeQuery(url, queryChercheurs);
		ObjectMapper mapper=new ObjectMapper();
		try {
			JsonNode rootNode=mapper.readTree(chercheurs.getBody());
			JsonNode data=rootNode.path("data");
			PersonnesPhysiqueDto personnesPhysiqueDto = mapper.treeToValue(data,PersonnesPhysiqueDto.class);
			return personnesPhysiqueDto;
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Map<String,Object> updateOrAddChercheur(){
		PersonnesPhysiqueDto personnesPhysiqueDto=getChercheurs();
		Map<String,Object> result=new HashMap<>();
		if(personnesPhysiqueDto==null) {
			result.put("success", false);
		}else {
			List<PersonnePhysiqueDto> personnesPhysiques=personnesPhysiqueDto.getPersonnesPhysiques();
		    AtomicInteger countAdded = new AtomicInteger(0);
		    AtomicInteger countModified= new AtomicInteger(0);
			personnesPhysiques.forEach(personne -> {
				ChercheurVo chercheurVo=chercheurDtoToVoConverter.toVo(personne);
				Chercheur chercheur=chercheurConverter.toItem(chercheurVo);
				Chercheur searchedChercheur=chercheurService.findByIdGraph(chercheurVo.getIdGraph());
				if(searchedChercheur==null) {
					Chercheur savedChercheur=chercheurService.saveFromGraphQl(chercheur);
					if(savedChercheur!=null) {
						countAdded.getAndIncrement();
					}
				}else {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					if(
							(searchedChercheur.getDateModification()!=null  
								&& chercheurVo.getDateModification()!=null 
								&& !formatter.format(searchedChercheur.getDateModification()).equals(formatter.format(chercheurVo.getDateModification()))
								) || (searchedChercheur.getDateModification()==null && chercheurVo.getDateModification()!=null)
							) {
						ChercheurVo searchedChercheurVo=chercheurConverter.toVo(searchedChercheur);
						ChercheurVo populatedChercheurVo=chercheurDtoToVoConverter.populateVoFromAnotherVo(searchedChercheurVo, chercheurVo);
						Chercheur chercheurItem=chercheurConverter.toItem(populatedChercheurVo);
						Chercheur updatedChercheur=chercheurService.updateFromGraphQl(chercheurItem);
						if(updatedChercheur!=null) {
							countModified.getAndIncrement();
						}
					}
				}
			});
			result.put("success", true);
			result.put("nbAdded", countAdded);
			result.put("nbmodified", countModified);
		}
		return result;
	}

}

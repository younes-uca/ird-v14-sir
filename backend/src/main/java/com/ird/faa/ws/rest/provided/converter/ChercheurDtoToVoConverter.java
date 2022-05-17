package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ird.faa.ws.rest.provided.dto.PersonnePhysiqueDto;
import com.ird.faa.ws.rest.provided.vo.ChercheurVo;
import com.ird.faa.ws.rest.provided.vo.CorpsVo;
import com.ird.faa.ws.rest.provided.vo.GradeVo;
import com.ird.faa.ws.rest.provided.vo.PaysVo;
import com.ird.faa.ws.rest.provided.vo.SexeVo;

@Component
public class ChercheurDtoToVoConverter {
	
	@Autowired
	private PaysDtoToVoConverter paysDtoToVoConverter;
	@Autowired
	private GradeDtoToVoConverter gradeDtoToVoConverter;
	@Autowired
	private CorpsDtoToVoConverter corpsDtoToVoConverter;
	
	public ChercheurVo toVo(PersonnePhysiqueDto personnePhysiqueDto) {
		if (personnePhysiqueDto == null) {
			return null;
		} else {
			ChercheurVo chercheurVo=new ChercheurVo();
			if(personnePhysiqueDto.getId()!=null) {
				chercheurVo.setIdGraph(personnePhysiqueDto.getId());
			}
			if(personnePhysiqueDto.getCivilite()!=null) {
				SexeVo sexeVo=new SexeVo();
				sexeVo.setCode(personnePhysiqueDto.getCivilite());
				sexeVo.setLibelle(personnePhysiqueDto.getCivilite());
				chercheurVo.setSexeVo(sexeVo);
			}
			if(personnePhysiqueDto.getUsage()!=null) {
				chercheurVo.setNom(personnePhysiqueDto.getUsage());
			}
			if(personnePhysiqueDto.getPrenom()!=null) {
				chercheurVo.setPrenom(personnePhysiqueDto.getPrenom());
			}
			if(personnePhysiqueDto.getMatricule()!=null) {
				chercheurVo.setNumeroMatricule(personnePhysiqueDto.getMatricule());
			}
			if(personnePhysiqueDto.getIntitulePoste()!=null) {
				chercheurVo.setIntitulePoste(personnePhysiqueDto.getIntitulePoste());
			}
			if(personnePhysiqueDto.isSorgho()!=null) {
				chercheurVo.setSorgho(personnePhysiqueDto.isSorgho());
			}
			if(personnePhysiqueDto.isValide()!=null) {
				chercheurVo.setValide(personnePhysiqueDto.isValide());
			}
			if(personnePhysiqueDto.getTypeEffectif()!=null) {
				chercheurVo.setTypeEffectif(personnePhysiqueDto.getTypeEffectif());
			}
			if(personnePhysiqueDto.getDomaineActivite()!=null) {
				chercheurVo.setDomaineActivite(personnePhysiqueDto.getDomaineActivite());
			}
			if(personnePhysiqueDto.getNomNaissance()!=null) {
				chercheurVo.setNomNaissance(personnePhysiqueDto.getNomNaissance());
			}
			if(personnePhysiqueDto.getDateDeNaissance()!=null) {
				chercheurVo.setDateDeNaissance(personnePhysiqueDto.getDateDeNaissance());
			}
			if(personnePhysiqueDto.getLieuDeNaissance()!=null) {
				chercheurVo.setLieuDeNaissance(personnePhysiqueDto.getLieuDeNaissance());
			}
			if(personnePhysiqueDto.getTelephone()!=null) {
				chercheurVo.setTelephone(personnePhysiqueDto.getTelephone());
			}
			if(personnePhysiqueDto.getIdentifiantCas()!=null) {
				chercheurVo.setIdentifiantCas(personnePhysiqueDto.getIdentifiantCas());
			}
			if(personnePhysiqueDto.getCourriel()!=null) {
				chercheurVo.setEmail(personnePhysiqueDto.getCourriel());
			}
			if(personnePhysiqueDto.getCommentaireDesactivation()!=null) {
				chercheurVo.setCommentaireDesactivation(personnePhysiqueDto.getCommentaireDesactivation());
			}
			if(personnePhysiqueDto.isAnonyme()!=null) {
				chercheurVo.setAnonyme(personnePhysiqueDto.isAnonyme());
			}
			if(personnePhysiqueDto.getDateCreation()!=null) {
				chercheurVo.setDateCreation(personnePhysiqueDto.getDateCreation());
			}
			if(personnePhysiqueDto.getDateModification()!=null) {
				chercheurVo.setDateModification(personnePhysiqueDto.getDateModification());
			}
			if(personnePhysiqueDto.getPaysNationalite()!=null) {
				PaysVo paysVo=paysDtoToVoConverter.toVo(personnePhysiqueDto.getPaysNationalite());
				chercheurVo.setPaysVo(paysVo);
			}
			if(personnePhysiqueDto.getGrade()!=null) {
				GradeVo gradeVo=gradeDtoToVoConverter.toVo(personnePhysiqueDto.getGrade());
				chercheurVo.setGradeVo(gradeVo);
			}
			if(personnePhysiqueDto.getCorps()!=null) {
				CorpsVo corpsVo=corpsDtoToVoConverter.toVo(personnePhysiqueDto.getCorps());
				chercheurVo.setCorpsVo(corpsVo);
			}
			
			return chercheurVo;
		}
	}
	public ChercheurVo populateVoFromAnotherVo(ChercheurVo fetchedVoFromDb,ChercheurVo fetchedVoFromGraphQl) {
		
		if(fetchedVoFromGraphQl.getIdGraph()!=null) {
			fetchedVoFromDb.setIdGraph(fetchedVoFromGraphQl.getIdGraph());
		}
		if(fetchedVoFromGraphQl.getCivilite()!=null) {
			fetchedVoFromDb.setCivilite(fetchedVoFromGraphQl.getCivilite());
		}
		if(fetchedVoFromGraphQl.getNom()!=null) {
			fetchedVoFromDb.setNom(fetchedVoFromGraphQl.getNom());
		}
		if(fetchedVoFromGraphQl.getPrenom()!=null) {
			fetchedVoFromDb.setPrenom(fetchedVoFromGraphQl.getPrenom());
		}
		if(fetchedVoFromGraphQl.getNumeroMatricule()!=null) {
			fetchedVoFromDb.setNumeroMatricule(fetchedVoFromGraphQl.getNumeroMatricule());
		}
		if(fetchedVoFromGraphQl.getIntitulePoste()!=null) {
			fetchedVoFromDb.setIntitulePoste(fetchedVoFromGraphQl.getIntitulePoste());
		}
		if(fetchedVoFromGraphQl.getSorgho()!=null) {
			fetchedVoFromDb.setSorgho(fetchedVoFromGraphQl.getSorgho());
		}
		if(fetchedVoFromGraphQl.getValide()!=null) {
			fetchedVoFromDb.setValide(fetchedVoFromGraphQl.getValide());
		}
		if(fetchedVoFromGraphQl.getTypeEffectif()!=null) {
			fetchedVoFromDb.setTypeEffectif(fetchedVoFromGraphQl.getTypeEffectif());
		}
		if(fetchedVoFromGraphQl.getDomaineActivite()!=null) {
			fetchedVoFromDb.setDomaineActivite(fetchedVoFromGraphQl.getDomaineActivite());
		}
		if(fetchedVoFromGraphQl.getNomNaissance()!=null) {
			fetchedVoFromDb.setNomNaissance(fetchedVoFromGraphQl.getNomNaissance());
		}
		if(fetchedVoFromGraphQl.getDateDeNaissance()!=null) {
			fetchedVoFromDb.setDateDeNaissance(fetchedVoFromGraphQl.getDateDeNaissance());
		}
		if(fetchedVoFromGraphQl.getLieuDeNaissance()!=null) {
			fetchedVoFromDb.setLieuDeNaissance(fetchedVoFromGraphQl.getLieuDeNaissance());
		}
		if(fetchedVoFromGraphQl.getTelephone()!=null) {
			fetchedVoFromDb.setTelephone(fetchedVoFromGraphQl.getTelephone());
		}
		if(fetchedVoFromGraphQl.getIdentifiantCas()!=null) {
			fetchedVoFromDb.setIdentifiantCas(fetchedVoFromGraphQl.getIdentifiantCas());
		}
		if(fetchedVoFromGraphQl.getEmail()!=null) {
			fetchedVoFromDb.setEmail(fetchedVoFromGraphQl.getEmail());
		}
		if(fetchedVoFromGraphQl.getCommentaireDesactivation()!=null) {
			fetchedVoFromDb.setCommentaireDesactivation(fetchedVoFromGraphQl.getCommentaireDesactivation());
		}
		if(fetchedVoFromGraphQl.getAnonyme()!=null) {
			fetchedVoFromDb.setAnonyme(fetchedVoFromGraphQl.getAnonyme());
		}
		if(fetchedVoFromGraphQl.getDateCreation()!=null) {
			fetchedVoFromDb.setDateCreation(fetchedVoFromGraphQl.getDateCreation());
		}
		if(fetchedVoFromGraphQl.getDateModification()!=null) {
			fetchedVoFromDb.setDateModification(fetchedVoFromGraphQl.getDateModification());
		}
		if(fetchedVoFromGraphQl.getPaysVo()!=null) {
			fetchedVoFromDb.setPaysVo(fetchedVoFromGraphQl.getPaysVo());
		}
		if(fetchedVoFromGraphQl.getGradeVo()!=null) {
			fetchedVoFromDb.setGradeVo(fetchedVoFromGraphQl.getGradeVo());
		}
		if(fetchedVoFromGraphQl.getCorpsVo()!=null) {
			fetchedVoFromDb.setCorpsVo(fetchedVoFromGraphQl.getCorpsVo());
		}
		if(fetchedVoFromGraphQl.getSexeVo()!=null) {
			fetchedVoFromDb.setSexeVo(fetchedVoFromGraphQl.getSexeVo());
		}
		
		return fetchedVoFromDb;
	}
}

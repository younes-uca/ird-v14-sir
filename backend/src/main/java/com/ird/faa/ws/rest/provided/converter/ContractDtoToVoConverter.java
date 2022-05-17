package com.ird.faa.ws.rest.provided.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ird.faa.ws.rest.provided.dto.ContractDto;
import com.ird.faa.ws.rest.provided.vo.ContratEtConventionIrdVo;
import com.ird.faa.ws.rest.provided.vo.PartenaireContratVo;
import com.ird.faa.ws.rest.provided.vo.PartenaireVo;
import com.ird.faa.ws.rest.provided.vo.PaysVo;
import com.ird.faa.ws.rest.provided.vo.StatusContratEtConventionVo;
@Component
public class ContractDtoToVoConverter {
	@Autowired
	private PaysDtoToVoConverter paysDtoToVoConverter;

	public ContratEtConventionIrdVo toVo(ContractDto contractDto) {
		if (contractDto == null) {
			return null;
		} else {
			ContratEtConventionIrdVo contratEtConventionIrd = new ContratEtConventionIrdVo();

			if (contractDto.getNumeroContrat() != null) {
				contratEtConventionIrd.setNumero(contractDto.getNumeroContrat());
			}
			if (contractDto.getIntitule() != null) {
				contratEtConventionIrd.setIntitule(contractDto.getIntitule());
			}
			if (contractDto.getDescription() != null) {
				contratEtConventionIrd.setDescription(contractDto.getDescription());
			}

			if (contractDto.getDateCreationContrat() != null) {
				contratEtConventionIrd.setDateCreationContrat(contractDto.getDateCreationContrat());
			}
			if (contractDto.getDateEntreeEnVigueur() != null) {
				contratEtConventionIrd.setDateEntreeEnVigueurContrat(contractDto.getDateEntreeEnVigueur());
			}
			if (contractDto.getDateFin() != null) {
				contratEtConventionIrd.setDateFinContrat(contractDto.getDateFin());
			}
			if (contractDto.getStatut() != null) {
				StatusContratEtConventionVo statusContratEtConventionVo = new StatusContratEtConventionVo();
				statusContratEtConventionVo.setLibelle(contractDto.getStatut());
				statusContratEtConventionVo.setCode(contractDto.getStatut());
				contratEtConventionIrd.setStatusContratEtConventionVo(statusContratEtConventionVo);
			}
			
			if (contractDto.getProgrammeFinancement() != null) {
				contratEtConventionIrd.setProgrammeFinancement(contractDto.getProgrammeFinancement().getLibelleCourt());
			}
			if (contractDto.getPersonnePhysiquePorteurDeProjet() != null) {
				contratEtConventionIrd.setNumMatriculePorteur(contractDto.getPersonnePhysiquePorteurDeProjet().getMatricule());
			}
			if (contractDto.getPartenairesLies() != null) {
				List<PartenaireVo> partenairesVo = new ArrayList<PartenaireVo>();
				contractDto.getPartenairesLies().forEach(partenaireContrat->{
					if (partenaireContrat.getPartenaire() != null) {
					PartenaireVo partenaireVo  = new PartenaireVo();
					partenaireVo.setNomOfficiel(partenaireContrat.getPartenaire().getNomOfficiel());
					partenaireVo.setSigleOfficiel(partenaireContrat.getPartenaire().getSigleOfficiel());
					partenaireVo.setIdGraphQl(partenaireContrat.getPartenaire().getId());
					PaysVo paysVo = new PaysVo();
					paysVo.setLibelle(partenaireContrat.getPartenaire().getPays().getLibelleCourt());
					paysVo.setCode(partenaireContrat.getPartenaire().getPays().getCode());
					partenaireVo.setPays(paysVo);
					partenaireVo.setTypePartenaire(null);
					partenairesVo.add(partenaireVo);
					}
				});
				contratEtConventionIrd.setPartenairesVo(partenairesVo);
			}
			contratEtConventionIrd.setDureeEnMois(contractDto.getDureeEnMois());

			return contratEtConventionIrd;
		}
	}

}

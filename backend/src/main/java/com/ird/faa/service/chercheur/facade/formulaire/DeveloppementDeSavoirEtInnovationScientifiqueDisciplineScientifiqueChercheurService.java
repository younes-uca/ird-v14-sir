package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo;

public interface DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueChercheurService extends
		AbstractService<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique, Long, DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo> {

	/**
	 * delete DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique
	 * from database
	 * 
	 * @param id - id of
	 *           DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique
	 *           to be deleted
	 *
	 */
	int deleteById(Long id);

	List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique> findByDisciplineScientifiqueCode(String code);

	int deleteByDisciplineScientifiqueCode(String code);

	List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique> findByDisciplineScientifiqueId(Long id);

	int deleteByDisciplineScientifiqueId(Long id);

	List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique> findByDeveloppementDeSavoirEtInnovationScientifiqueId(
			Long id);

	int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);

}

package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrdVo;

public interface DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrdChercheurService extends
		AbstractService<DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd, Long, DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrdVo> {

	/**
	 * delete DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd from database
	 * 
	 * @param id - id of DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd to
	 *           be deleted
	 *
	 */
	int deleteById(Long id);

	List<DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd> findByEnjeuxIrdCode(String code);

	int deleteByEnjeuxIrdCode(String code);

	List<DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd> findByEnjeuxIrdId(Long id);

	int deleteByEnjeuxIrdId(Long id);

	List<DeveloppementDeSavoirEtInnovationScientifiqueEnjeuxIrd> findByDeveloppementDeSavoirEtInnovationScientifiqueId(
			Long id);

	int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);

}

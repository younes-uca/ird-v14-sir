package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifique;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.DeveloppementDeSavoirEtInnovationScientifiqueVo;

public interface DeveloppementDeSavoirEtInnovationScientifiqueChercheurService extends
		AbstractService<DeveloppementDeSavoirEtInnovationScientifique, Long, DeveloppementDeSavoirEtInnovationScientifiqueVo> {

	/**
	 * delete DeveloppementDeSavoirEtInnovationScientifique from database
	 * 
	 * @param id - id of DeveloppementDeSavoirEtInnovationScientifique to be deleted
	 *
	 */
	int deleteById(Long id);

	List<DeveloppementDeSavoirEtInnovationScientifique> findByRoleDeveloppementDeSavoirCode(String code);

	int deleteByRoleDeveloppementDeSavoirCode(String code);

	List<DeveloppementDeSavoirEtInnovationScientifique> findByRoleDeveloppementDeSavoirId(Long id);

	int deleteByRoleDeveloppementDeSavoirId(Long id);

	List<DeveloppementDeSavoirEtInnovationScientifique> findBySavoirEtInnovationId(Long id);

	int deleteBySavoirEtInnovationId(Long id);

	List<DeveloppementDeSavoirEtInnovationScientifique> findByEtatEtapeCampagneCode(String code);

	int deleteByEtatEtapeCampagneCode(String code);

	List<DeveloppementDeSavoirEtInnovationScientifique> findByEtatEtapeCampagneId(Long id);

	int deleteByEtatEtapeCampagneId(Long id);

}

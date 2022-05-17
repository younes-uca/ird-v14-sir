package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueRole;
import com.ird.faa.ws.rest.provided.vo.DeveloppementDeSavoirEtInnovationScientifiqueRoleVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DeveloppementDeSavoirEtInnovationScientifiqueRoleChercheurService extends
		AbstractService<DeveloppementDeSavoirEtInnovationScientifiqueRole, Long, DeveloppementDeSavoirEtInnovationScientifiqueRoleVo> {

	/**
	 * delete DeveloppementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir from
	 * database
	 * 
	 * @param id - id of DeveloppementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir
	 *           to be deleted
	 *
	 */
	int deleteById(Long id);

	List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByRoleDeveloppementDeSavoirCode(String code);

	int deleteByRoleDeveloppementDeSavoirCode(String code);

	List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByRoleDeveloppementDeSavoirId(Long id);

	int deleteByRoleDeveloppementDeSavoirId(Long id);

	List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByDeveloppementDeSavoirEtInnovationScientifiqueId(
			Long id);

	int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);

}

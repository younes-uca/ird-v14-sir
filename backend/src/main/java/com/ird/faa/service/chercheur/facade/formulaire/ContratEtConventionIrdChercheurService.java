package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.bean.formulaire.ContratEtConventionIrd;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.ContratEtConventionIrdVo;

public interface ContratEtConventionIrdChercheurService
		extends AbstractService<ContratEtConventionIrd, Long, ContratEtConventionIrdVo> {

	/**
	 * delete ContratEtConventionIrd from database
	 * 
	 * @param id - id of ContratEtConventionIrd to be deleted
	 *
	 */
	int deleteById(Long id);

	List<ContratEtConventionIrd> findByStatusContratEtConventionCode(String code);

	int deleteByStatusContratEtConventionCode(String code);

	List<ContratEtConventionIrd> findByStatusContratEtConventionId(Long id);

	int deleteByStatusContratEtConventionId(Long id);

	List<ContratEtConventionIrd> findBySavoirEtInnovationId(Long id);

	int deleteBySavoirEtInnovationId(Long id);

	List<ContratEtConventionIrd> findByEtatEtapeCampagneCode(String code);

	int deleteByEtatEtapeCampagneCode(String code);

	List<ContratEtConventionIrd> findByEtatEtapeCampagneId(Long id);

	int deleteByEtatEtapeCampagneId(Long id);

	ContratEtConventionIrd saveFromGraphQl(ContratEtConventionIrd contratEtConventionIrd);

	List<ContratEtConventionIrd> findByChercheur(Chercheur chercheur);

}

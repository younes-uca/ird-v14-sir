package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;

import com.ird.faa.bean.formulaire.GestionEquipeDetail;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.GestionEquipeDetailVo;

public interface GestionEquipeDetailChercheurService
		extends AbstractService<GestionEquipeDetail, Long, GestionEquipeDetailVo> {

	/**
	 * delete GestionEquipeDetail from database
	 * 
	 * @param id - id of GestionEquipeDetail to be deleted
	 *
	 */
	int deleteById(Long id);

	List<GestionEquipeDetail> findByGestionEquipeId(Long id);

	int deleteByGestionEquipeId(Long id);
	
	List<GestionEquipeDetail> findByChercheurUsernameAndCampagneId(String username, Long compagneId);

}

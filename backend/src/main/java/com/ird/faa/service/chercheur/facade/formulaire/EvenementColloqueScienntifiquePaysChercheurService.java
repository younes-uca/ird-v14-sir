package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;

import com.ird.faa.bean.formulaire.EvenementColloqueScienntifiquePays;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.EvenementColloqueScienntifiquePaysVo;

public interface EvenementColloqueScienntifiquePaysChercheurService
		extends AbstractService<EvenementColloqueScienntifiquePays, Long, EvenementColloqueScienntifiquePaysVo> {

	/**
	 * delete EvenementColloqueScienntifiquePays from database
	 * 
	 * @param id - id of EvenementColloqueScienntifiquePays to be deleted
	 *
	 */
	int deleteById(Long id);

	List<EvenementColloqueScienntifiquePays> findByEvenementColloqueScienntifiqueId(Long id);

	int deleteByEvenementColloqueScienntifiqueId(Long id);

	List<EvenementColloqueScienntifiquePays> findByPaysCode(String code);

	int deleteByPaysCode(String code);

	List<EvenementColloqueScienntifiquePays> findByPaysId(Long id);

	int deleteByPaysId(Long id);

}

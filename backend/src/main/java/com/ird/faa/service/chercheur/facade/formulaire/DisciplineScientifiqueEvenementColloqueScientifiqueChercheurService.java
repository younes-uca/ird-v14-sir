package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueEvenementColloqueScientifique;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueEvenementColloqueScientifiqueVo;

public interface DisciplineScientifiqueEvenementColloqueScientifiqueChercheurService extends
		AbstractService<DisciplineScientifiqueEvenementColloqueScientifique, Long, DisciplineScientifiqueEvenementColloqueScientifiqueVo> {

	/**
	 * delete DisciplineScientifiqueEvenementColloqueScientifique from database
	 * 
	 * @param id - id of DisciplineScientifiqueEvenementColloqueScientifique to be
	 *           deleted
	 *
	 */
	int deleteById(Long id);

	List<DisciplineScientifiqueEvenementColloqueScientifique> findByEvenementColloqueScienntifiqueId(Long id);

	int deleteByEvenementColloqueScienntifiqueId(Long id);

	List<DisciplineScientifiqueEvenementColloqueScientifique> findByDisciplineScientifiqueCode(String code);

	int deleteByDisciplineScientifiqueCode(String code);

	List<DisciplineScientifiqueEvenementColloqueScientifique> findByDisciplineScientifiqueId(Long id);

	int deleteByDisciplineScientifiqueId(Long id);

}

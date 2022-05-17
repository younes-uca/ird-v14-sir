package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;

import com.ird.faa.bean.formulaire.EvenementColloqueScientifiqueInstrumentIrd;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.EvenementColloqueScientifiqueInstrumentIrdVo;

public interface EvenementColloqueScientifiqueInstrumentIrdChercheurService extends
		AbstractService<EvenementColloqueScientifiqueInstrumentIrd, Long, EvenementColloqueScientifiqueInstrumentIrdVo> {

	/**
	 * delete InstrumentIrdEvenementColloqueScientifique from database
	 * 
	 * @param id - id of InstrumentIrdEvenementColloqueScientifique to be deleted
	 *
	 */
	int deleteById(Long id);

	List<EvenementColloqueScientifiqueInstrumentIrd> findByEvenementColloqueScienntifiqueId(Long id);

	int deleteByEvenementColloqueScienntifiqueId(Long id);

	List<EvenementColloqueScientifiqueInstrumentIrd> findByInstrumentIrdCode(String code);

	int deleteByInstrumentIrdCode(String code);

	List<EvenementColloqueScientifiqueInstrumentIrd> findByInstrumentIrdId(Long id);

	int deleteByInstrumentIrdId(Long id);

}

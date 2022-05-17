package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;

import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo;

public interface RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdChercheurService extends
		AbstractService<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd, Long, RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo> {

	/**
	 * delete RencontreGrandPubliqueJeunePubliqueInstrumentIrd from database
	 * 
	 * @param id - id of RencontreGrandPubliqueJeunePubliqueInstrumentIrd to be
	 *           deleted
	 *
	 */
	int deleteById(Long id);

	List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> findByTypeInstrumentIrdCode(String code);

	int deleteByTypeInstrumentIrdCode(String code);

	List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> findByTypeInstrumentIrdId(Long id);

	int deleteByTypeInstrumentIrdId(Long id);

	List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> findByRencontreGrandPubliqueJeunePubliqueId(Long id);

	int deleteByRencontreGrandPubliqueJeunePubliqueId(Long id);

}

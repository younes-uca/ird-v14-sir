package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;

import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePubliqueInstrumentIrd;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.RencontreGrandPubliqueJeunePubliqueInstrumentIrdVo;

public interface RencontreGrandPubliqueJeunePubliqueInstrumentIrdChercheurService extends AbstractService<RencontreGrandPubliqueJeunePubliqueInstrumentIrd,Long,RencontreGrandPubliqueJeunePubliqueInstrumentIrdVo>{




/**
    * delete RencontreGrandPubliqueJeunePubliqueInstrumentIrd from database
    * @param id - id of RencontreGrandPubliqueJeunePubliqueInstrumentIrd to be deleted
    *
    */
    int deleteById(Long id);


    List<RencontreGrandPubliqueJeunePubliqueInstrumentIrd> findByInstrumentIrdCode(String code);

    int deleteByInstrumentIrdCode(String code);

    List<RencontreGrandPubliqueJeunePubliqueInstrumentIrd> findByInstrumentIrdId(Long id);

    int deleteByInstrumentIrdId(Long id);

    List<RencontreGrandPubliqueJeunePubliqueInstrumentIrd> findByRencontreGrandPubliqueJeunePubliqueId(Long id);

    int deleteByRencontreGrandPubliqueJeunePubliqueId(Long id);







}

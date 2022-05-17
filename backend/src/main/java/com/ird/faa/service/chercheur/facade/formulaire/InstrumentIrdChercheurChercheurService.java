package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.InstrumentIrdChercheur;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.InstrumentIrdChercheurVo;

import java.util.List;

public interface InstrumentIrdChercheurChercheurService extends AbstractService<InstrumentIrdChercheur,Long,InstrumentIrdChercheurVo>{





/**
    * delete InstrumentIrdChercheur from database
    * @param id - id of InstrumentIrdChercheur to be deleted
    *
    */
    int deleteById(Long id);


    List<InstrumentIrdChercheur> findByInstrumentIrdCode(String code);

    int deleteByInstrumentIrdCode(String code);

    List<InstrumentIrdChercheur> findByInstrumentIrdId(Long id);

    int deleteByInstrumentIrdId(Long id);
    List<InstrumentIrdChercheur> findByChercheurNumeroMatricule(String numeroMatricule);

    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<InstrumentIrdChercheur> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);







}

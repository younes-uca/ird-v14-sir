package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrdChercheur;
import com.ird.faa.ws.rest.provided.vo.InstrumentsEtDispositifsIrdChercheurVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface InstrumentsEtDispositifsIrdChercheurChercheurService extends AbstractService<InstrumentsEtDispositifsIrdChercheur,Long,InstrumentsEtDispositifsIrdChercheurVo>{




/**
    * delete InstrumentsEtDispositifsIrdChercheur from database
    * @param id - id of InstrumentsEtDispositifsIrdChercheur to be deleted
    *
    */
    int deleteById(Long id);


    List<InstrumentsEtDispositifsIrdChercheur> findByTypeInstrumentsEtDispositifsIrdCode(String code);

    int deleteByTypeInstrumentsEtDispositifsIrdCode(String code);

    List<InstrumentsEtDispositifsIrdChercheur> findByTypeInstrumentsEtDispositifsIrdId(Long id);

    int deleteByTypeInstrumentsEtDispositifsIrdId(Long id);
    List<InstrumentsEtDispositifsIrdChercheur> findByChercheurNumeroMatricule(String numeroMatricule);

    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<InstrumentsEtDispositifsIrdChercheur> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);





}

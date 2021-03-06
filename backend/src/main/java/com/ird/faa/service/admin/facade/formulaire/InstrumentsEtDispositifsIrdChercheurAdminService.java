package com.ird.faa.service.admin.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrdChercheur;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.InstrumentsEtDispositifsIrdChercheurVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface InstrumentsEtDispositifsIrdChercheurAdminService extends AbstractService<InstrumentsEtDispositifsIrdChercheur,Long,InstrumentsEtDispositifsIrdChercheurVo>{




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

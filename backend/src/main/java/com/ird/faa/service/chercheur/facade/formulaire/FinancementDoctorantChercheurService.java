package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.FinancementDoctorant;
import com.ird.faa.ws.rest.provided.vo.FinancementDoctorantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface FinancementDoctorantChercheurService extends AbstractService<FinancementDoctorant,Long,FinancementDoctorantVo>{


    /**
    * find FinancementDoctorant from database by code (reference)
    * @param code - reference of FinancementDoctorant
    * @return the founded FinancementDoctorant , If no FinancementDoctorant were
    *         found in database return  null.
    */
    FinancementDoctorant findByCode(String code);

    /**
    * find FinancementDoctorant from database by id (PK) or code (reference)
    * @param id - id of FinancementDoctorant
    * @param code - reference of FinancementDoctorant
    * @return the founded FinancementDoctorant , If no FinancementDoctorant were
    *         found in database return  null.
    */
    FinancementDoctorant findByIdOrCode(FinancementDoctorant financementDoctorant);


/**
    * delete FinancementDoctorant from database
    * @param id - id of FinancementDoctorant to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete FinancementDoctorant from database by code (reference)
    *
    * @param code - reference of FinancementDoctorant to be deleted
    * @return 1 if FinancementDoctorant deleted successfully
    */
    int deleteByCode(String code);



}

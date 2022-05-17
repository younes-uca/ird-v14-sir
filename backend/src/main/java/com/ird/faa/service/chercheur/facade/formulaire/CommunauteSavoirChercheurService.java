package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.CommunauteSavoir;
import com.ird.faa.ws.rest.provided.vo.CommunauteSavoirVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CommunauteSavoirChercheurService extends AbstractService<CommunauteSavoir,Long,CommunauteSavoirVo>{


    /**
    * find CommunauteSavoir from database by code (reference)
    * @param code - reference of CommunauteSavoir
    * @return the founded CommunauteSavoir , If no CommunauteSavoir were
    *         found in database return  null.
    */
    CommunauteSavoir findByCode(String code);

    /**
    * find CommunauteSavoir from database by id (PK) or code (reference)
    * @param id - id of CommunauteSavoir
    * @param code - reference of CommunauteSavoir
    * @return the founded CommunauteSavoir , If no CommunauteSavoir were
    *         found in database return  null.
    */
    CommunauteSavoir findByIdOrCode(CommunauteSavoir communauteSavoir);


/**
    * delete CommunauteSavoir from database
    * @param id - id of CommunauteSavoir to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete CommunauteSavoir from database by code (reference)
    *
    * @param code - reference of CommunauteSavoir to be deleted
    * @return 1 if CommunauteSavoir deleted successfully
    */
    int deleteByCode(String code);



}

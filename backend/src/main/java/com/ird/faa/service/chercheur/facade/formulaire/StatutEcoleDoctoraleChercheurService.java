package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.referentiel.StatutEcoleDoctorale;
import com.ird.faa.ws.rest.provided.vo.StatutEcoleDoctoraleVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface StatutEcoleDoctoraleChercheurService extends AbstractService<StatutEcoleDoctorale,Long,StatutEcoleDoctoraleVo>{


    /**
    * find StatutEcoleDoctorale from database by code (reference)
    * @param code - reference of StatutEcoleDoctorale
    * @return the founded StatutEcoleDoctorale , If no StatutEcoleDoctorale were
    *         found in database return  null.
    */
    StatutEcoleDoctorale findByCode(String code);

    /**
    * find StatutEcoleDoctorale from database by id (PK) or code (reference)
    * @param id - id of StatutEcoleDoctorale
    * @param code - reference of StatutEcoleDoctorale
    * @return the founded StatutEcoleDoctorale , If no StatutEcoleDoctorale were
    *         found in database return  null.
    */
    StatutEcoleDoctorale findByIdOrCode(StatutEcoleDoctorale statutEcoleDoctorale);


/**
    * delete StatutEcoleDoctorale from database
    * @param id - id of StatutEcoleDoctorale to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete StatutEcoleDoctorale from database by code (reference)
    *
    * @param code - reference of StatutEcoleDoctorale to be deleted
    * @return 1 if StatutEcoleDoctorale deleted successfully
    */
    int deleteByCode(String code);



}

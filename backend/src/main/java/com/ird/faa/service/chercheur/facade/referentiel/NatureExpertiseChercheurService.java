package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.referentiel.NatureExpertise;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.NatureExpertiseVo;

public interface NatureExpertiseChercheurService extends AbstractService<NatureExpertise,Long,NatureExpertiseVo>{



    /**
    * find NatureExpertise from database by code (reference)
    * @param code - reference of NatureExpertise
    * @return the founded NatureExpertise , If no NatureExpertise were
    *         found in database return  null.
    */
    NatureExpertise findByCode(String code);

    /**
    * find NatureExpertise from database by id (PK) or code (reference)
    * @param id - id of NatureExpertise
    * @param code - reference of NatureExpertise
    * @return the founded NatureExpertise , If no NatureExpertise were
    *         found in database return  null.
    */
    NatureExpertise findByIdOrCode(NatureExpertise natureExpertise);


/**
    * delete NatureExpertise from database
    * @param id - id of NatureExpertise to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete NatureExpertise from database by code (reference)
    *
    * @param code - reference of NatureExpertise to be deleted
    * @return 1 if NatureExpertise deleted successfully
    */
    int deleteByCode(String code);





}

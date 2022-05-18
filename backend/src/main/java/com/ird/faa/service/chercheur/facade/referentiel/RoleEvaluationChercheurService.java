package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.referentiel.RoleEvaluation;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.RoleEvaluationVo;

public interface RoleEvaluationChercheurService extends AbstractService<RoleEvaluation,Long,RoleEvaluationVo>{



    /**
    * find RoleEvaluation from database by code (reference)
    * @param code - reference of RoleEvaluation
    * @return the founded RoleEvaluation , If no RoleEvaluation were
    *         found in database return  null.
    */
    RoleEvaluation findByCode(String code);

    /**
    * find RoleEvaluation from database by id (PK) or code (reference)
    * @param id - id of RoleEvaluation
    * @param code - reference of RoleEvaluation
    * @return the founded RoleEvaluation , If no RoleEvaluation were
    *         found in database return  null.
    */
    RoleEvaluation findByIdOrCode(RoleEvaluation roleEvaluation);


/**
    * delete RoleEvaluation from database
    * @param id - id of RoleEvaluation to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete RoleEvaluation from database by code (reference)
    *
    * @param code - reference of RoleEvaluation to be deleted
    * @return 1 if RoleEvaluation deleted successfully
    */
    int deleteByCode(String code);





}

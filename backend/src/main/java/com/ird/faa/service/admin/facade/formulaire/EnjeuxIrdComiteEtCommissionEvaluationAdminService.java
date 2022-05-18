package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.EnjeuxIrdComiteEtCommissionEvaluation;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.EnjeuxIrdComiteEtCommissionEvaluationVo;

import java.util.List;

public interface EnjeuxIrdComiteEtCommissionEvaluationAdminService extends AbstractService<EnjeuxIrdComiteEtCommissionEvaluation,Long,EnjeuxIrdComiteEtCommissionEvaluationVo>{





/**
    * delete EnjeuxIrdComiteEtCommissionEvaluation from database
    * @param id - id of EnjeuxIrdComiteEtCommissionEvaluation to be deleted
    *
    */
    int deleteById(Long id);


    List<EnjeuxIrdComiteEtCommissionEvaluation> findByEnjeuxIrdCode(String code);

    int deleteByEnjeuxIrdCode(String code);

    List<EnjeuxIrdComiteEtCommissionEvaluation> findByEnjeuxIrdId(Long id);

    int deleteByEnjeuxIrdId(Long id);

    List<EnjeuxIrdComiteEtCommissionEvaluation> findByComiteEtCommissionEvaluationId(Long id);

    int deleteByComiteEtCommissionEvaluationId(Long id);







}

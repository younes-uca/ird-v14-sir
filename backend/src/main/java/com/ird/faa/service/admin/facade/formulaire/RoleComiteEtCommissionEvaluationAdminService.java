package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.RoleComiteEtCommissionEvaluation;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.RoleComiteEtCommissionEvaluationVo;

import java.util.List;

public interface RoleComiteEtCommissionEvaluationAdminService extends AbstractService<RoleComiteEtCommissionEvaluation,Long,RoleComiteEtCommissionEvaluationVo>{





/**
    * delete RoleComiteEtCommissionEvaluation from database
    * @param id - id of RoleComiteEtCommissionEvaluation to be deleted
    *
    */
    int deleteById(Long id);


    List<RoleComiteEtCommissionEvaluation> findByRoleEvaluationCode(String code);

    int deleteByRoleEvaluationCode(String code);

    List<RoleComiteEtCommissionEvaluation> findByRoleEvaluationId(Long id);

    int deleteByRoleEvaluationId(Long id);

    List<RoleComiteEtCommissionEvaluation> findByComiteEtCommissionEvaluationId(Long id);

    int deleteByComiteEtCommissionEvaluationId(Long id);







}

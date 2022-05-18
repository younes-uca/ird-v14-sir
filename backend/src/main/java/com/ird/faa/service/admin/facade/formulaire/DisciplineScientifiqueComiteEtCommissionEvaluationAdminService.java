package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueComiteEtCommissionEvaluation;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DisciplineScientifiqueComiteEtCommissionEvaluationVo;

import java.util.List;

public interface DisciplineScientifiqueComiteEtCommissionEvaluationAdminService extends AbstractService<DisciplineScientifiqueComiteEtCommissionEvaluation,Long,DisciplineScientifiqueComiteEtCommissionEvaluationVo>{





/**
    * delete DisciplineScientifiqueComiteEtCommissionEvaluation from database
    * @param id - id of DisciplineScientifiqueComiteEtCommissionEvaluation to be deleted
    *
    */
    int deleteById(Long id);


    List<DisciplineScientifiqueComiteEtCommissionEvaluation> findByDisciplineScientifiqueCode(String code);

    int deleteByDisciplineScientifiqueCode(String code);

    List<DisciplineScientifiqueComiteEtCommissionEvaluation> findByDisciplineScientifiqueId(Long id);

    int deleteByDisciplineScientifiqueId(Long id);

    List<DisciplineScientifiqueComiteEtCommissionEvaluation> findByComiteEtCommissionEvaluationId(Long id);

    int deleteByComiteEtCommissionEvaluationId(Long id);







}

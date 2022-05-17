package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.InstrumentIrdComiteEtCommissionEvaluation;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.InstrumentIrdComiteEtCommissionEvaluationVo;

import java.util.List;

public interface InstrumentIrdComiteEtCommissionEvaluationAdminService extends AbstractService<InstrumentIrdComiteEtCommissionEvaluation,Long,InstrumentIrdComiteEtCommissionEvaluationVo>{





/**
    * delete InstrumentIrdComiteEtCommissionEvaluation from database
    * @param id - id of InstrumentIrdComiteEtCommissionEvaluation to be deleted
    *
    */
    int deleteById(Long id);


    List<InstrumentIrdComiteEtCommissionEvaluation> findByInstrumentIrdCode(String code);

    int deleteByInstrumentIrdCode(String code);

    List<InstrumentIrdComiteEtCommissionEvaluation> findByInstrumentIrdId(Long id);

    int deleteByInstrumentIrdId(Long id);
    List<InstrumentIrdComiteEtCommissionEvaluation> findByTypeInstrumentIrdCode(String code);

    int deleteByTypeInstrumentIrdCode(String code);

    List<InstrumentIrdComiteEtCommissionEvaluation> findByTypeInstrumentIrdId(Long id);

    int deleteByTypeInstrumentIrdId(Long id);

    List<InstrumentIrdComiteEtCommissionEvaluation> findByComiteEtCommissionEvaluationId(Long id);

    int deleteByComiteEtCommissionEvaluationId(Long id);







}

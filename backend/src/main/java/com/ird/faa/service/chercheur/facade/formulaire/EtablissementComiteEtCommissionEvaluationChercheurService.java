package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.EtablissementComiteEtCommissionEvaluation;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.EtablissementComiteEtCommissionEvaluationVo;

import java.util.List;

public interface EtablissementComiteEtCommissionEvaluationChercheurService extends AbstractService<EtablissementComiteEtCommissionEvaluation,Long,EtablissementComiteEtCommissionEvaluationVo>{





/**
    * delete EtablissementComiteEtCommissionEvaluation from database
    * @param id - id of EtablissementComiteEtCommissionEvaluation to be deleted
    *
    */
    int deleteById(Long id);


    List<EtablissementComiteEtCommissionEvaluation> findByEtablissementCode(String code);

    int deleteByEtablissementCode(String code);

    List<EtablissementComiteEtCommissionEvaluation> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);

    List<EtablissementComiteEtCommissionEvaluation> findByComiteEtCommissionEvaluationId(Long id);

    int deleteByComiteEtCommissionEvaluationId(Long id);







}

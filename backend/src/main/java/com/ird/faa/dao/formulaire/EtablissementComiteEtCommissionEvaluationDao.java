package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.EtablissementComiteEtCommissionEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EtablissementComiteEtCommissionEvaluationDao extends JpaRepository<EtablissementComiteEtCommissionEvaluation,Long> {





    List<EtablissementComiteEtCommissionEvaluation> findByEtablissementCode(String code);
    int deleteByEtablissementCode(String code);

    List<EtablissementComiteEtCommissionEvaluation> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);

    List<EtablissementComiteEtCommissionEvaluation> findByComiteEtCommissionEvaluationId(Long id);

    int deleteByComiteEtCommissionEvaluationId(Long id);


}

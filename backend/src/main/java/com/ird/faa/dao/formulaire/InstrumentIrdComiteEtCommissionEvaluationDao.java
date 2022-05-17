package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.InstrumentIrdComiteEtCommissionEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InstrumentIrdComiteEtCommissionEvaluationDao extends JpaRepository<InstrumentIrdComiteEtCommissionEvaluation,Long> {





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

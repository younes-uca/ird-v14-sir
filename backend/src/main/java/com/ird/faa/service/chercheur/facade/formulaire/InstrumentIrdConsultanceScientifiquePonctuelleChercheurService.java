package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.InstrumentIrdConsultanceScientifiquePonctuelle;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.InstrumentIrdConsultanceScientifiquePonctuelleVo;

import java.util.List;

public interface InstrumentIrdConsultanceScientifiquePonctuelleChercheurService extends AbstractService<InstrumentIrdConsultanceScientifiquePonctuelle,Long,InstrumentIrdConsultanceScientifiquePonctuelleVo>{





/**
    * delete InstrumentIrdConsultanceScientifiquePonctuelle from database
    * @param id - id of InstrumentIrdConsultanceScientifiquePonctuelle to be deleted
    *
    */
    int deleteById(Long id);



    List<InstrumentIrdConsultanceScientifiquePonctuelle> findByConsultanceScientifiquePonctuelleId(Long id);

    int deleteByConsultanceScientifiquePonctuelleId(Long id);
    List<InstrumentIrdConsultanceScientifiquePonctuelle> findByInstrumentIrdCode(String code);

    int deleteByInstrumentIrdCode(String code);

    List<InstrumentIrdConsultanceScientifiquePonctuelle> findByInstrumentIrdId(Long id);

    int deleteByInstrumentIrdId(Long id);







}

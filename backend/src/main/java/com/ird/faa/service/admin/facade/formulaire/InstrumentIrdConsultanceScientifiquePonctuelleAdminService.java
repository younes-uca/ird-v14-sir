package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.InstrumentIrdConsultanceScientifiquePonctuelle;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.InstrumentIrdConsultanceScientifiquePonctuelleVo;

import java.util.List;

public interface InstrumentIrdConsultanceScientifiquePonctuelleAdminService extends AbstractService<InstrumentIrdConsultanceScientifiquePonctuelle,Long,InstrumentIrdConsultanceScientifiquePonctuelleVo>{





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

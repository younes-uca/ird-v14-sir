package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.TypeInstrumentIrdConsultanceScientifiquePonctuelle;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.TypeInstrumentIrdConsultanceScientifiquePonctuelleVo;

import java.util.List;

public interface TypeInstrumentIrdConsultanceScientifiquePonctuelleChercheurService extends AbstractService<TypeInstrumentIrdConsultanceScientifiquePonctuelle,Long,TypeInstrumentIrdConsultanceScientifiquePonctuelleVo>{





/**
    * delete TypeInstrumentIrdConsultanceScientifiquePonctuelle from database
    * @param id - id of TypeInstrumentIrdConsultanceScientifiquePonctuelle to be deleted
    *
    */
    int deleteById(Long id);


    List<TypeInstrumentIrdConsultanceScientifiquePonctuelle> findByTypeInstrumentIrdCode(String code);

    int deleteByTypeInstrumentIrdCode(String code);

    List<TypeInstrumentIrdConsultanceScientifiquePonctuelle> findByTypeInstrumentIrdId(Long id);

    int deleteByTypeInstrumentIrdId(Long id);

    List<TypeInstrumentIrdConsultanceScientifiquePonctuelle> findByConsultanceScientifiquePonctuelleId(Long id);

    int deleteByConsultanceScientifiquePonctuelleId(Long id);







}

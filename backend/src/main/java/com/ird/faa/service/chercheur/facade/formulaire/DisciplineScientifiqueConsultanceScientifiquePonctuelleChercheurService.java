package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueConsultanceScientifiquePonctuelle;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueConsultanceScientifiquePonctuelleVo;

import java.util.List;

public interface DisciplineScientifiqueConsultanceScientifiquePonctuelleChercheurService extends AbstractService<DisciplineScientifiqueConsultanceScientifiquePonctuelle,Long,DisciplineScientifiqueConsultanceScientifiquePonctuelleVo>{





/**
    * delete DisciplineScientifiqueConsultanceScientifiquePonctuelle from database
    * @param id - id of DisciplineScientifiqueConsultanceScientifiquePonctuelle to be deleted
    *
    */
    int deleteById(Long id);



    List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> findByConsultanceScientifiquePonctuelleId(Long id);

    int deleteByConsultanceScientifiquePonctuelleId(Long id);
    List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> findByDisciplineScientifiqueCode(String code);

    int deleteByDisciplineScientifiqueCode(String code);

    List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> findByDisciplineScientifiqueId(Long id);

    int deleteByDisciplineScientifiqueId(Long id);







}

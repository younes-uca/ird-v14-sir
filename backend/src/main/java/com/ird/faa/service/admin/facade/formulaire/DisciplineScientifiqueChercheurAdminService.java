package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueChercheur;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DisciplineScientifiqueChercheurVo;

import java.util.List;

public interface DisciplineScientifiqueChercheurAdminService extends AbstractService<DisciplineScientifiqueChercheur,Long,DisciplineScientifiqueChercheurVo>{





/**
    * delete DisciplineScientifiqueChercheur from database
    * @param id - id of DisciplineScientifiqueChercheur to be deleted
    *
    */
    int deleteById(Long id);


    List<DisciplineScientifiqueChercheur> findByDisciplineScientifiqueCode(String code);

    int deleteByDisciplineScientifiqueCode(String code);

    List<DisciplineScientifiqueChercheur> findByDisciplineScientifiqueId(Long id);

    int deleteByDisciplineScientifiqueId(Long id);
    List<DisciplineScientifiqueChercheur> findByDisciplineScientifiqueErcCode(String code);

    int deleteByDisciplineScientifiqueErcCode(String code);

    List<DisciplineScientifiqueChercheur> findByDisciplineScientifiqueErcId(Long id);

    int deleteByDisciplineScientifiqueErcId(Long id);
    List<DisciplineScientifiqueChercheur> findByChercheurNumeroMatricule(String numeroMatricule);

    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<DisciplineScientifiqueChercheur> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);







}

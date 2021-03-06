package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.DisciplineScientifiqueConseilEtComiteScientifique;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DisciplineScientifiqueConseilEtComiteScientifiqueVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DisciplineScientifiqueConseilEtComiteScientifiqueChercheurService extends AbstractService<DisciplineScientifiqueConseilEtComiteScientifique,Long,DisciplineScientifiqueConseilEtComiteScientifiqueVo>{




/**
    * delete DisciplineScientifiqueConseilEtComiteScientifique from database
    * @param id - id of DisciplineScientifiqueConseilEtComiteScientifique to be deleted
    *
    */
    int deleteById(Long id);


    List<DisciplineScientifiqueConseilEtComiteScientifique> findByDisciplineScientifiqueCode(String code);

    int deleteByDisciplineScientifiqueCode(String code);

    List<DisciplineScientifiqueConseilEtComiteScientifique> findByDisciplineScientifiqueId(Long id);

    int deleteByDisciplineScientifiqueId(Long id);
    List<DisciplineScientifiqueConseilEtComiteScientifique> findByConseilEtComiteScientifiqueAnnee(Integer annee);

    int deleteByConseilEtComiteScientifiqueAnnee(Integer annee);

    List<DisciplineScientifiqueConseilEtComiteScientifique> findByConseilEtComiteScientifiqueId(Long id);

    int deleteByConseilEtComiteScientifiqueId(Long id);





}

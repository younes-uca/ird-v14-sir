package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.FormationContinueDisciplineScientifique;
import com.ird.faa.ws.rest.provided.vo.FormationContinueDisciplineScientifiqueVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface FormationContinueDisciplineScientifiqueChercheurService extends AbstractService<FormationContinueDisciplineScientifique,Long,FormationContinueDisciplineScientifiqueVo>{




/**
    * delete FormationContinueDisciplineScientifique from database
    * @param id - id of FormationContinueDisciplineScientifique to be deleted
    *
    */
    int deleteById(Long id);



    List<FormationContinueDisciplineScientifique> findByFormationContinueId(Long id);

    int deleteByFormationContinueId(Long id);
    List<FormationContinueDisciplineScientifique> findByDisciplineScientifiqueCode(String code);

    int deleteByDisciplineScientifiqueCode(String code);

    List<FormationContinueDisciplineScientifique> findByDisciplineScientifiqueId(Long id);

    int deleteByDisciplineScientifiqueId(Long id);







}

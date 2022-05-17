package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.DisciplineScientifiqueEvaluationRechercheUniversitaire;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueEvaluationRechercheUniversitaireVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DisciplineScientifiqueEvaluationRechercheUniversitaireChercheurService extends AbstractService<DisciplineScientifiqueEvaluationRechercheUniversitaire,Long,DisciplineScientifiqueEvaluationRechercheUniversitaireVo>{




/**
    * delete DisciplineScientifiqueEvaluationRechercheUniversitaire from database
    * @param id - id of DisciplineScientifiqueEvaluationRechercheUniversitaire to be deleted
    *
    */
    int deleteById(Long id);


    List<DisciplineScientifiqueEvaluationRechercheUniversitaire> findByDisciplineScientifiqueCode(String code);

    int deleteByDisciplineScientifiqueCode(String code);

    List<DisciplineScientifiqueEvaluationRechercheUniversitaire> findByDisciplineScientifiqueId(Long id);

    int deleteByDisciplineScientifiqueId(Long id);
    List<DisciplineScientifiqueEvaluationRechercheUniversitaire> findByEvaluationRechercheUniversitaireAnnee(Integer annee);

    int deleteByEvaluationRechercheUniversitaireAnnee(Integer annee);

    List<DisciplineScientifiqueEvaluationRechercheUniversitaire> findByEvaluationRechercheUniversitaireId(Long id);

    int deleteByEvaluationRechercheUniversitaireId(Long id);





}

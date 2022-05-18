package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueErcAssociation;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DisciplineScientifiqueErcAssociationVo;

import java.util.List;

public interface DisciplineScientifiqueErcAssociationChercheurService extends AbstractService<DisciplineScientifiqueErcAssociation,Long,DisciplineScientifiqueErcAssociationVo>{





/**
    * delete DisciplineScientifiqueErcAssociation from database
    * @param id - id of DisciplineScientifiqueErcAssociation to be deleted
    *
    */
    int deleteById(Long id);


    List<DisciplineScientifiqueErcAssociation> findByDisciplineScientifiqueErcCode(String code);

    int deleteByDisciplineScientifiqueErcCode(String code);

    List<DisciplineScientifiqueErcAssociation> findByDisciplineScientifiqueErcId(Long id);

    int deleteByDisciplineScientifiqueErcId(Long id);
    List<DisciplineScientifiqueErcAssociation> findByDisciplineScientifiqueCode(String code);

    int deleteByDisciplineScientifiqueCode(String code);

    List<DisciplineScientifiqueErcAssociation> findByDisciplineScientifiqueId(Long id);

    int deleteByDisciplineScientifiqueId(Long id);
    List<DisciplineScientifiqueErcAssociation> findBySemanticRelationshipCode(String code);

    int deleteBySemanticRelationshipCode(String code);

    List<DisciplineScientifiqueErcAssociation> findBySemanticRelationshipId(Long id);

    int deleteBySemanticRelationshipId(Long id);







}

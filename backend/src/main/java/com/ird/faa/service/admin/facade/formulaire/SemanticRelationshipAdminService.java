package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.SemanticRelationship;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.SemanticRelationshipVo;

public interface SemanticRelationshipAdminService extends AbstractService<SemanticRelationship,Long,SemanticRelationshipVo>{



    /**
    * find SemanticRelationship from database by code (reference)
    * @param code - reference of SemanticRelationship
    * @return the founded SemanticRelationship , If no SemanticRelationship were
    *         found in database return  null.
    */
    SemanticRelationship findByCode(String code);

    /**
    * find SemanticRelationship from database by id (PK) or code (reference)
    * @param id - id of SemanticRelationship
    * @param code - reference of SemanticRelationship
    * @return the founded SemanticRelationship , If no SemanticRelationship were
    *         found in database return  null.
    */
    SemanticRelationship findByIdOrCode(SemanticRelationship semanticRelationship);


/**
    * delete SemanticRelationship from database
    * @param id - id of SemanticRelationship to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete SemanticRelationship from database by code (reference)
    *
    * @param code - reference of SemanticRelationship to be deleted
    * @return 1 if SemanticRelationship deleted successfully
    */
    int deleteByCode(String code);




    SemanticRelationship archiver(SemanticRelationship semanticRelationship) ;
    SemanticRelationship desarchiver(SemanticRelationship semanticRelationship);

}

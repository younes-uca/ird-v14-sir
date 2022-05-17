package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.ResponsabiliteEncadrementEtudiant;
import com.ird.faa.ws.rest.provided.vo.ResponsabiliteEncadrementEtudiantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ResponsabiliteEncadrementEtudiantChercheurService extends AbstractService<ResponsabiliteEncadrementEtudiant,Long,ResponsabiliteEncadrementEtudiantVo>{


    /**
    * find ResponsabiliteEncadrementEtudiant from database by code (reference)
    * @param code - reference of ResponsabiliteEncadrementEtudiant
    * @return the founded ResponsabiliteEncadrementEtudiant , If no ResponsabiliteEncadrementEtudiant were
    *         found in database return  null.
    */
    ResponsabiliteEncadrementEtudiant findByCode(String code);

    /**
    * find ResponsabiliteEncadrementEtudiant from database by id (PK) or code (reference)
    * @param id - id of ResponsabiliteEncadrementEtudiant
    * @param code - reference of ResponsabiliteEncadrementEtudiant
    * @return the founded ResponsabiliteEncadrementEtudiant , If no ResponsabiliteEncadrementEtudiant were
    *         found in database return  null.
    */
    ResponsabiliteEncadrementEtudiant findByIdOrCode(ResponsabiliteEncadrementEtudiant responsabiliteEncadrementEtudiant);


/**
    * delete ResponsabiliteEncadrementEtudiant from database
    * @param id - id of ResponsabiliteEncadrementEtudiant to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete ResponsabiliteEncadrementEtudiant from database by code (reference)
    *
    * @param code - reference of ResponsabiliteEncadrementEtudiant to be deleted
    * @return 1 if ResponsabiliteEncadrementEtudiant deleted successfully
    */
    int deleteByCode(String code);



}

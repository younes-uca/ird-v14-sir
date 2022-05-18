package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueParent;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DisciplineScientifiqueParentVo;

public interface DisciplineScientifiqueParentChercheurService extends AbstractService<DisciplineScientifiqueParent,Long,DisciplineScientifiqueParentVo>{



    /**
    * find DisciplineScientifiqueParent from database by code (reference)
    * @param code - reference of DisciplineScientifiqueParent
    * @return the founded DisciplineScientifiqueParent , If no DisciplineScientifiqueParent were
    *         found in database return  null.
    */
    DisciplineScientifiqueParent findByCode(String code);

    /**
    * find DisciplineScientifiqueParent from database by id (PK) or code (reference)
    * @param id - id of DisciplineScientifiqueParent
    * @param code - reference of DisciplineScientifiqueParent
    * @return the founded DisciplineScientifiqueParent , If no DisciplineScientifiqueParent were
    *         found in database return  null.
    */
    DisciplineScientifiqueParent findByIdOrCode(DisciplineScientifiqueParent disciplineScientifiqueParent);


/**
    * delete DisciplineScientifiqueParent from database
    * @param id - id of DisciplineScientifiqueParent to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete DisciplineScientifiqueParent from database by code (reference)
    *
    * @param code - reference of DisciplineScientifiqueParent to be deleted
    * @return 1 if DisciplineScientifiqueParent deleted successfully
    */
    int deleteByCode(String code);





}

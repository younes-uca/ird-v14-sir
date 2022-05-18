package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueErc;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DisciplineScientifiqueErcVo;

import java.util.List;

public interface DisciplineScientifiqueErcChercheurService extends AbstractService<DisciplineScientifiqueErc,Long,DisciplineScientifiqueErcVo>{



    /**
    * find DisciplineScientifiqueErc from database by code (reference)
    * @param code - reference of DisciplineScientifiqueErc
    * @return the founded DisciplineScientifiqueErc , If no DisciplineScientifiqueErc were
    *         found in database return  null.
    */
    DisciplineScientifiqueErc findByCode(String code);

    /**
    * find DisciplineScientifiqueErc from database by id (PK) or code (reference)
    * @param id - id of DisciplineScientifiqueErc
    * @param code - reference of DisciplineScientifiqueErc
    * @return the founded DisciplineScientifiqueErc , If no DisciplineScientifiqueErc were
    *         found in database return  null.
    */
    DisciplineScientifiqueErc findByIdOrCode(DisciplineScientifiqueErc disciplineScientifiqueErc);


/**
    * delete DisciplineScientifiqueErc from database
    * @param id - id of DisciplineScientifiqueErc to be deleted
    *
    */
    int deleteById(Long id);


    List<DisciplineScientifiqueErc> findByDisciplineScientifiqueErcParentCode(String code);

    int deleteByDisciplineScientifiqueErcParentCode(String code);

    List<DisciplineScientifiqueErc> findByDisciplineScientifiqueErcParentId(Long id);

    int deleteByDisciplineScientifiqueErcParentId(Long id);


    /**
    * delete DisciplineScientifiqueErc from database by code (reference)
    *
    * @param code - reference of DisciplineScientifiqueErc to be deleted
    * @return 1 if DisciplineScientifiqueErc deleted successfully
    */
    int deleteByCode(String code);





}

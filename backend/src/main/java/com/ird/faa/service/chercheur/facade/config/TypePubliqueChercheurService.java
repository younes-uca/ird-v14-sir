package com.ird.faa.service.chercheur.facade.config;

import com.ird.faa.bean.config.TypePublique;
import com.ird.faa.ws.rest.provided.vo.TypePubliqueVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypePubliqueChercheurService extends AbstractService<TypePublique,Long,TypePubliqueVo>{


    /**
    * find TypePublique from database by code (reference)
    * @param code - reference of TypePublique
    * @return the founded TypePublique , If no TypePublique were
    *         found in database return  null.
    */
    TypePublique findByCode(String code);

    /**
    * find TypePublique from database by id (PK) or code (reference)
    * @param id - id of TypePublique
    * @param code - reference of TypePublique
    * @return the founded TypePublique , If no TypePublique were
    *         found in database return  null.
    */
    TypePublique findByIdOrCode(TypePublique typePublique);


/**
    * delete TypePublique from database
    * @param id - id of TypePublique to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TypePublique from database by code (reference)
    *
    * @param code - reference of TypePublique to be deleted
    * @return 1 if TypePublique deleted successfully
    */
    int deleteByCode(String code);





}

package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.TemplateCloture;
import com.ird.faa.ws.rest.provided.vo.TemplateClotureVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TemplateClotureChercheurService extends AbstractService<TemplateCloture,Long,TemplateClotureVo>{


    /**
    * find TemplateCloture from database by code (reference)
    * @param code - reference of TemplateCloture
    * @return the founded TemplateCloture , If no TemplateCloture were
    *         found in database return  null.
    */
    TemplateCloture findByCode(String code);

    /**
    * find TemplateCloture from database by id (PK) or code (reference)
    * @param id - id of TemplateCloture
    * @param code - reference of TemplateCloture
    * @return the founded TemplateCloture , If no TemplateCloture were
    *         found in database return  null.
    */
    TemplateCloture findByIdOrCode(TemplateCloture templateCloture);


/**
    * delete TemplateCloture from database
    * @param id - id of TemplateCloture to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TemplateCloture from database by code (reference)
    *
    * @param code - reference of TemplateCloture to be deleted
    * @return 1 if TemplateCloture deleted successfully
    */
    int deleteByCode(String code);



}

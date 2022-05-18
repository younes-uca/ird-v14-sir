package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.referentiel.PubliqueFormation;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.PubliqueFormationVo;

public interface PubliqueFormationAdminService extends AbstractService<PubliqueFormation,Long,PubliqueFormationVo>{



    /**
    * find PubliqueFormation from database by code (reference)
    * @param code - reference of PubliqueFormation
    * @return the founded PubliqueFormation , If no PubliqueFormation were
    *         found in database return  null.
    */
    PubliqueFormation findByCode(String code);

    /**
    * find PubliqueFormation from database by id (PK) or code (reference)
    * @param id - id of PubliqueFormation
    * @param code - reference of PubliqueFormation
    * @return the founded PubliqueFormation , If no PubliqueFormation were
    *         found in database return  null.
    */
    PubliqueFormation findByIdOrCode(PubliqueFormation publiqueFormation);


/**
    * delete PubliqueFormation from database
    * @param id - id of PubliqueFormation to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete PubliqueFormation from database by code (reference)
    *
    * @param code - reference of PubliqueFormation to be deleted
    * @return 1 if PubliqueFormation deleted successfully
    */
    int deleteByCode(String code);




    PubliqueFormation archiver(PubliqueFormation publiqueFormation) ;
    PubliqueFormation desarchiver(PubliqueFormation publiqueFormation);

}

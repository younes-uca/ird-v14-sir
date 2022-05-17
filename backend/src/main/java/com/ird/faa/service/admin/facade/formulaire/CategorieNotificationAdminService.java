package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.CategorieNotification;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.CategorieNotificationVo;

public interface CategorieNotificationAdminService extends AbstractService<CategorieNotification,Long,CategorieNotificationVo>{



    /**
    * find CategorieNotification from database by code (reference)
    * @param code - reference of CategorieNotification
    * @return the founded CategorieNotification , If no CategorieNotification were
    *         found in database return  null.
    */
    CategorieNotification findByCode(String code);

    /**
    * find CategorieNotification from database by id (PK) or code (reference)
    * @param id - id of CategorieNotification
    * @param code - reference of CategorieNotification
    * @return the founded CategorieNotification , If no CategorieNotification were
    *         found in database return  null.
    */
    CategorieNotification findByIdOrCode(CategorieNotification categorieNotification);


/**
    * delete CategorieNotification from database
    * @param id - id of CategorieNotification to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete CategorieNotification from database by code (reference)
    *
    * @param code - reference of CategorieNotification to be deleted
    * @return 1 if CategorieNotification deleted successfully
    */
    int deleteByCode(String code);





}

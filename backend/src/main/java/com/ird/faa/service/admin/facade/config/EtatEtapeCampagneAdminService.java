package com.ird.faa.service.admin.facade.config;

import com.ird.faa.bean.config.EtatEtapeCampagne;
import main.java.com.ird.faa.ws.rest.provided.vo.config.EtatEtapeCampagneVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatEtapeCampagneAdminService extends AbstractService<EtatEtapeCampagne,Long,EtatEtapeCampagneVo>{


    /**
    * find EtatEtapeCampagne from database by code (reference)
    * @param code - reference of EtatEtapeCampagne
    * @return the founded EtatEtapeCampagne , If no EtatEtapeCampagne were
    *         found in database return  null.
    */
    EtatEtapeCampagne findByCode(String code);

    /**
    * find EtatEtapeCampagne from database by id (PK) or code (reference)
    * @param id - id of EtatEtapeCampagne
    * @param code - reference of EtatEtapeCampagne
    * @return the founded EtatEtapeCampagne , If no EtatEtapeCampagne were
    *         found in database return  null.
    */
    EtatEtapeCampagne findByIdOrCode(EtatEtapeCampagne etatEtapeCampagne);


/**
    * delete EtatEtapeCampagne from database
    * @param id - id of EtatEtapeCampagne to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatEtapeCampagne from database by code (reference)
    *
    * @param code - reference of EtatEtapeCampagne to be deleted
    * @return 1 if EtatEtapeCampagne deleted successfully
    */
    int deleteByCode(String code);



}

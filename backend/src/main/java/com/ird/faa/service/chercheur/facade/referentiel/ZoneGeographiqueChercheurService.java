package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.referentiel.ZoneGeographique;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.ZoneGeographiqueVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ZoneGeographiqueChercheurService extends AbstractService<ZoneGeographique,Long,ZoneGeographiqueVo>{


    /**
    * find ZoneGeographique from database by code (reference)
    * @param code - reference of ZoneGeographique
    * @return the founded ZoneGeographique , If no ZoneGeographique were
    *         found in database return  null.
    */
    ZoneGeographique findByCode(String code);

    /**
    * find ZoneGeographique from database by id (PK) or code (reference)
    * @param id - id of ZoneGeographique
    * @param code - reference of ZoneGeographique
    * @return the founded ZoneGeographique , If no ZoneGeographique were
    *         found in database return  null.
    */
    ZoneGeographique findByIdOrCode(ZoneGeographique zoneGeographique);


/**
    * delete ZoneGeographique from database
    * @param id - id of ZoneGeographique to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete ZoneGeographique from database by code (reference)
    *
    * @param code - reference of ZoneGeographique to be deleted
    * @return 1 if ZoneGeographique deleted successfully
    */
    int deleteByCode(String code);


}

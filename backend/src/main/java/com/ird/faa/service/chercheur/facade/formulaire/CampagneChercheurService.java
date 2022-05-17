package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.Campagne;
import com.ird.faa.ws.rest.provided.vo.CampagneVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CampagneChercheurService extends AbstractService<Campagne,Long,CampagneVo>{


    /**
    * find Campagne from database by code (reference)
    * @param code - reference of Campagne
    * @return the founded Campagne , If no Campagne were
    *         found in database return  null.
    */
    Campagne findByCode(String code);

    /**
    * find Campagne from database by id (PK) or code (reference)
    * @param id - id of Campagne
    * @param code - reference of Campagne
    * @return the founded Campagne , If no Campagne were
    *         found in database return  null.
    */
    Campagne findByIdOrCode(Campagne campagne);


/**
    * delete Campagne from database
    * @param id - id of Campagne to be deleted
    *
    */
    int deleteById(Long id);


    List<Campagne> findByEtatCampagneCode(String code);

    int deleteByEtatCampagneCode(String code);

    List<Campagne> findByEtatCampagneId(Long id);

    int deleteByEtatCampagneId(Long id);
    List<Campagne> findByTemplateOuvertureCode(String code);

    int deleteByTemplateOuvertureCode(String code);

    List<Campagne> findByTemplateOuvertureId(Long id);

    int deleteByTemplateOuvertureId(Long id);
    List<Campagne> findByTemplateClotureCode(String code);

    int deleteByTemplateClotureCode(String code);

    List<Campagne> findByTemplateClotureId(Long id);

    int deleteByTemplateClotureId(Long id);


    /**
    * delete Campagne from database by code (reference)
    *
    * @param code - reference of Campagne to be deleted
    * @return 1 if Campagne deleted successfully
    */
    int deleteByCode(String code);

    Campagne findProgressCampagneByChercheurUsername(String username);


}

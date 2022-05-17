package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.EtablissementConseilsScientifique;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.EtablissementConseilsScientifiqueVo;

import java.util.List;

public interface EtablissementConseilsScientifiqueChercheurService extends AbstractService<EtablissementConseilsScientifique,Long,EtablissementConseilsScientifiqueVo>{





/**
    * delete EtablissementConseilsScientifique from database
    * @param id - id of EtablissementConseilsScientifique to be deleted
    *
    */
    int deleteById(Long id);



    List<EtablissementConseilsScientifique> findByConseilsScientifiqueId(Long id);

    int deleteByConseilsScientifiqueId(Long id);
    List<EtablissementConseilsScientifique> findByEtablissementCode(String code);

    int deleteByEtablissementCode(String code);

    List<EtablissementConseilsScientifique> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);







}

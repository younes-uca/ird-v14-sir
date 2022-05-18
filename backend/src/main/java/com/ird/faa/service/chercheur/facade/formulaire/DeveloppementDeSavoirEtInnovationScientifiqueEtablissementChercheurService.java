package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueEtablissement;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueEtablissementVo;

import java.util.List;

public interface DeveloppementDeSavoirEtInnovationScientifiqueEtablissementChercheurService extends AbstractService<DeveloppementDeSavoirEtInnovationScientifiqueEtablissement,Long,DeveloppementDeSavoirEtInnovationScientifiqueEtablissementVo>{





/**
    * delete DeveloppementDeSavoirEtInnovationScientifiqueEtablissement from database
    * @param id - id of DeveloppementDeSavoirEtInnovationScientifiqueEtablissement to be deleted
    *
    */
    int deleteById(Long id);


    List<DeveloppementDeSavoirEtInnovationScientifiqueEtablissement> findByEtablissementCode(String code);

    int deleteByEtablissementCode(String code);

    List<DeveloppementDeSavoirEtInnovationScientifiqueEtablissement> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);

    List<DeveloppementDeSavoirEtInnovationScientifiqueEtablissement> findByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);

    int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);







}

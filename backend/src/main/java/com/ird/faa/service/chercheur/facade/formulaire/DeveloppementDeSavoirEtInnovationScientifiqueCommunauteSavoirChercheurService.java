package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoirVo;

import java.util.List;

public interface DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoirChercheurService extends AbstractService<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir,Long,DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoirVo>{





/**
    * delete DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir from database
    * @param id - id of DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir to be deleted
    *
    */
    int deleteById(Long id);


    List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> findByCommunauteSavoirCode(String code);

    int deleteByCommunauteSavoirCode(String code);

    List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> findByCommunauteSavoirId(Long id);

    int deleteByCommunauteSavoirId(Long id);

    List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> findByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);

    int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);







}

package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.ZoneActiviteInteractionRecherche;
import com.ird.faa.ws.rest.provided.vo.ZoneActiviteInteractionRechercheVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ZoneActiviteInteractionRechercheChercheurService extends AbstractService<ZoneActiviteInteractionRecherche,Long,ZoneActiviteInteractionRechercheVo>{




/**
    * delete ZoneActiviteInteractionRecherche from database
    * @param id - id of ZoneActiviteInteractionRecherche to be deleted
    *
    */
    int deleteById(Long id);


    List<ZoneActiviteInteractionRecherche> findByPaysCode(String code);

    int deleteByPaysCode(String code);

    List<ZoneActiviteInteractionRecherche> findByPaysId(Long id);

    int deleteByPaysId(Long id);
    List<ZoneActiviteInteractionRecherche> findByChercheurNumeroMatricule(String numeroMatricule);

    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<ZoneActiviteInteractionRecherche> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);





}

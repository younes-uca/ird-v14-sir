package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.PaysProjetRecherche;
import com.ird.faa.ws.rest.provided.vo.PaysProjetRechercheVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PaysProjetRechercheChercheurService extends AbstractService<PaysProjetRecherche,Long,PaysProjetRechercheVo>{




/**
    * delete PaysProjetRecherche from database
    * @param id - id of PaysProjetRecherche to be deleted
    *
    */
    int deleteById(Long id);


    List<PaysProjetRecherche> findByPaysCode(String code);

    int deleteByPaysCode(String code);

    List<PaysProjetRecherche> findByPaysId(Long id);

    int deleteByPaysId(Long id);
    List<PaysProjetRecherche> findByProjetActiviteRechercheAnnee(Integer annee);

    int deleteByProjetActiviteRechercheAnnee(Integer annee);

    List<PaysProjetRecherche> findByProjetActiviteRechercheId(Long id);

    int deleteByProjetActiviteRechercheId(Long id);





}

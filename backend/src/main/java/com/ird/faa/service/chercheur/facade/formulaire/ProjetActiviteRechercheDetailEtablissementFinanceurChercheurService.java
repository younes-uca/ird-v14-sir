package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;

import com.ird.faa.bean.formulaire.ProjetActiviteRechercheDetailEtablissementFinanceur;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.ProjetActiviteRechercheDetailEtablissementFinanceurVo;

public interface ProjetActiviteRechercheDetailEtablissementFinanceurChercheurService extends AbstractService<ProjetActiviteRechercheDetailEtablissementFinanceur,Long,ProjetActiviteRechercheDetailEtablissementFinanceurVo>{

/**
    * delete ProjetActiviteRechercheDetailEtablissementLanceur from database
    * @param id - id of ProjetActiviteRechercheDetailEtablissementLanceur to be deleted
    *
    */
    int deleteById(Long id);


    List<ProjetActiviteRechercheDetailEtablissementFinanceur> findByEtablissementCode(String code);

    int deleteByEtablissementCode(String code);

    List<ProjetActiviteRechercheDetailEtablissementFinanceur> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);

    List<ProjetActiviteRechercheDetailEtablissementFinanceur> findByProjetActiviteRechercheDetailId(Long id);

    int deleteByProjetActiviteRechercheDetailId(Long id);


}

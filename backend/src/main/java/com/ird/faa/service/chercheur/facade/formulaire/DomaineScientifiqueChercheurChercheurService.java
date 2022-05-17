package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.DomaineScientifiqueChercheur;
import com.ird.faa.ws.rest.provided.vo.DomaineScientifiqueChercheurVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DomaineScientifiqueChercheurChercheurService extends AbstractService<DomaineScientifiqueChercheur,Long,DomaineScientifiqueChercheurVo>{




/**
    * delete DomaineScientifiqueChercheur from database
    * @param id - id of DomaineScientifiqueChercheur to be deleted
    *
    */
    int deleteById(Long id);


    List<DomaineScientifiqueChercheur> findByDomaineScientifiqueCode(String code);

    int deleteByDomaineScientifiqueCode(String code);

    List<DomaineScientifiqueChercheur> findByDomaineScientifiqueId(Long id);

    int deleteByDomaineScientifiqueId(Long id);
    List<DomaineScientifiqueChercheur> findByChercheurNumeroMatricule(String numeroMatricule);

    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<DomaineScientifiqueChercheur> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);





}

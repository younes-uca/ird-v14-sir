package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.Expertise;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.ExpertiseVo;

import java.util.List;

public interface ExpertiseChercheurService extends AbstractService<Expertise,Long,ExpertiseVo>{





/**
    * delete Expertise from database
    * @param id - id of Expertise to be deleted
    *
    */
    int deleteById(Long id);


    List<Expertise> findByEtatEtapeCampagneCode(String code);

    int deleteByEtatEtapeCampagneCode(String code);

    List<Expertise> findByEtatEtapeCampagneId(Long id);

    int deleteByEtatEtapeCampagneId(Long id);
    List<Expertise> findByChercheurNumeroMatricule(String numeroMatricule);

    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<Expertise> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);
    List<Expertise> findByCampagneCode(String code);

    int deleteByCampagneCode(String code);

    List<Expertise> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);




   public List<Expertise> findByChercheurUsernameAndCampagneId(String username, Long compagneId);



}

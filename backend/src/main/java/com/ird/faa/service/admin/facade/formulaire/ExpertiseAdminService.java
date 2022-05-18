package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.Expertise;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ExpertiseVo;

import java.util.List;

public interface ExpertiseAdminService extends AbstractService<Expertise,Long,ExpertiseVo>{





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







}

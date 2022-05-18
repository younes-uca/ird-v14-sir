package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.referentiel.VieInstitutionnelle;
import com.ird.faa.ws.rest.provided.vo.VieInstitutionnelleVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface VieInstitutionnelleChercheurService extends AbstractService<VieInstitutionnelle,Long,VieInstitutionnelleVo>{




/**
    * delete VieInstitutionnelle from database
    * @param id - id of VieInstitutionnelle to be deleted
    *
    */
    int deleteById(Long id);


    List<VieInstitutionnelle> findByCampagneCode(String code);

    int deleteByCampagneCode(String code);

    List<VieInstitutionnelle> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);
    List<VieInstitutionnelle> findByChercheurNumeroMatricule(String numeroMatricule);

    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<VieInstitutionnelle> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);
    List<VieInstitutionnelle> findByEtatEtapeCampagneCode(String code);

    int deleteByEtatEtapeCampagneCode(String code);

    List<VieInstitutionnelle> findByEtatEtapeCampagneId(Long id);

    int deleteByEtatEtapeCampagneId(Long id);




   public List<VieInstitutionnelle> findByChercheurUsernameAndCampagneId(String username, Long compagneId);

}

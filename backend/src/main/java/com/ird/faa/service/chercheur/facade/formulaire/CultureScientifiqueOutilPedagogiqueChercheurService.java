package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.CultureScientifiqueOutilPedagogique;
import com.ird.faa.ws.rest.provided.vo.CultureScientifiqueOutilPedagogiqueVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CultureScientifiqueOutilPedagogiqueChercheurService extends AbstractService<CultureScientifiqueOutilPedagogique,Long,CultureScientifiqueOutilPedagogiqueVo>{




/**
    * delete CultureScientifiqueOutilPedagogique from database
    * @param id - id of CultureScientifiqueOutilPedagogique to be deleted
    *
    */
    int deleteById(Long id);


    List<CultureScientifiqueOutilPedagogique> findByCampagneCode(String code);

    int deleteByCampagneCode(String code);

    List<CultureScientifiqueOutilPedagogique> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);
    List<CultureScientifiqueOutilPedagogique> findByChercheurNumeroMatricule(String numeroMatricule);

    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<CultureScientifiqueOutilPedagogique> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);
    List<CultureScientifiqueOutilPedagogique> findByEtatEtapeCampagneCode(String code);

    int deleteByEtatEtapeCampagneCode(String code);

    List<CultureScientifiqueOutilPedagogique> findByEtatEtapeCampagneId(Long id);

    int deleteByEtatEtapeCampagneId(Long id);




   public List<CultureScientifiqueOutilPedagogique> findByChercheurUsernameAndCampagneId(String username, Long compagneId);

}

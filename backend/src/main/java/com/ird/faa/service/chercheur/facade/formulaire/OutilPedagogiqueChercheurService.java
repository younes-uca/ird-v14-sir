package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.referentiel.OutilPedagogique;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.OutilPedagogiqueVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface OutilPedagogiqueChercheurService extends AbstractService<OutilPedagogique,Long,OutilPedagogiqueVo>{




/**
    * delete OutilPedagogique from database
    * @param id - id of OutilPedagogique to be deleted
    *
    */
    int deleteById(Long id);



    List<OutilPedagogique> findByCultureScientifiqueId(Long id);

    int deleteByCultureScientifiqueId(Long id);
    List<OutilPedagogique> findByEtatEtapeCampagneCode(String code);

    int deleteByEtatEtapeCampagneCode(String code);

    List<OutilPedagogique> findByEtatEtapeCampagneId(Long id);

    int deleteByEtatEtapeCampagneId(Long id);







}

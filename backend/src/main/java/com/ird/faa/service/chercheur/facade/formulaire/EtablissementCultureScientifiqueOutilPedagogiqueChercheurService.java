package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.EtablissementCultureScientifiqueOutilPedagogique;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.EtablissementCultureScientifiqueOutilPedagogiqueVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtablissementCultureScientifiqueOutilPedagogiqueChercheurService extends AbstractService<EtablissementCultureScientifiqueOutilPedagogique,Long,EtablissementCultureScientifiqueOutilPedagogiqueVo>{




/**
    * delete EtablissementCultureScientifiqueOutilPedagogique from database
    * @param id - id of EtablissementCultureScientifiqueOutilPedagogique to be deleted
    *
    */
    int deleteById(Long id);



    List<EtablissementCultureScientifiqueOutilPedagogique> findByCultureScientifiqueOutilPedagogiqueId(Long id);

    int deleteByCultureScientifiqueOutilPedagogiqueId(Long id);
    List<EtablissementCultureScientifiqueOutilPedagogique> findByEtablissementCode(String code);

    int deleteByEtablissementCode(String code);

    List<EtablissementCultureScientifiqueOutilPedagogique> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);





}

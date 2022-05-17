package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.EtablissementEncadrementDoctorant;
import com.ird.faa.ws.rest.provided.vo.EtablissementEncadrementDoctorantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtablissementEncadrementDoctorantChercheurService extends AbstractService<EtablissementEncadrementDoctorant,Long,EtablissementEncadrementDoctorantVo>{




/**
    * delete EtablissementEncadrementDoctorant from database
    * @param id - id of EtablissementEncadrementDoctorant to be deleted
    *
    */
    int deleteById(Long id);


    List<EtablissementEncadrementDoctorant> findByEtablissementCode(String code);

    int deleteByEtablissementCode(String code);

    List<EtablissementEncadrementDoctorant> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);

    List<EtablissementEncadrementDoctorant> findByEncadrementDoctorantId(Long id);

    int deleteByEncadrementDoctorantId(Long id);







}

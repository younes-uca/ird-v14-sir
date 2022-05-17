package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic;
import com.ird.faa.ws.rest.provided.vo.EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicChercheurService extends AbstractService<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic,Long,EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo>{




/**
    * delete EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic from database
    * @param id - id of EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic to be deleted
    *
    */
    int deleteById(Long id);



    List<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic> findByCultureScientifiqueRecontreGrandPublicJeunePublicId(Long id);

    int deleteByCultureScientifiqueRecontreGrandPublicJeunePublicId(Long id);
    List<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic> findByEtablissementCode(String code);

    int deleteByEtablissementCode(String code);

    List<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);





}

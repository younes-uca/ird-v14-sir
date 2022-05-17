package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.EtablissementEncadrementEtudiant;
import com.ird.faa.ws.rest.provided.vo.EtablissementEncadrementEtudiantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtablissementEncadrementEtudiantChercheurService extends AbstractService<EtablissementEncadrementEtudiant,Long,EtablissementEncadrementEtudiantVo>{




/**
    * delete EtablissementEncadrementEtudiant from database
    * @param id - id of EtablissementEncadrementEtudiant to be deleted
    *
    */
    int deleteById(Long id);


    List<EtablissementEncadrementEtudiant> findByEtablissementCode(String code);

    int deleteByEtablissementCode(String code);

    List<EtablissementEncadrementEtudiant> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);

    List<EtablissementEncadrementEtudiant> findByEncadrementEtudiantId(Long id);

    int deleteByEncadrementEtudiantId(Long id);







}

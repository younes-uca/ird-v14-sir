package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.PaysEncadrementEtudiant;
import com.ird.faa.ws.rest.provided.vo.PaysEncadrementEtudiantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PaysEncadrementEtudiantChercheurService extends AbstractService<PaysEncadrementEtudiant,Long,PaysEncadrementEtudiantVo>{




/**
    * delete PaysEncadrementEtudiant from database
    * @param id - id of PaysEncadrementEtudiant to be deleted
    *
    */
    int deleteById(Long id);


    List<PaysEncadrementEtudiant> findByPaysCode(String code);

    int deleteByPaysCode(String code);

    List<PaysEncadrementEtudiant> findByPaysId(Long id);

    int deleteByPaysId(Long id);

    List<PaysEncadrementEtudiant> findByEncadrementEtudiantId(Long id);

    int deleteByEncadrementEtudiantId(Long id);







}

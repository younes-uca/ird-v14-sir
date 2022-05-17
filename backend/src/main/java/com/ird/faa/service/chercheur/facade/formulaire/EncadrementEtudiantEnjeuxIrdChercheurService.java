package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.EncadrementEtudiantEnjeuxIrd;
import com.ird.faa.ws.rest.provided.vo.EncadrementEtudiantEnjeuxIrdVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EncadrementEtudiantEnjeuxIrdChercheurService extends AbstractService<EncadrementEtudiantEnjeuxIrd,Long,EncadrementEtudiantEnjeuxIrdVo>{




/**
    * delete EncadrementEtudiantEnjeuxIrd from database
    * @param id - id of EncadrementEtudiantEnjeuxIrd to be deleted
    *
    */
    int deleteById(Long id);



    List<EncadrementEtudiantEnjeuxIrd> findByEncadrementEtudiantId(Long id);

    int deleteByEncadrementEtudiantId(Long id);
    List<EncadrementEtudiantEnjeuxIrd> findByEnjeuxIrdCode(String code);

    int deleteByEnjeuxIrdCode(String code);

    List<EncadrementEtudiantEnjeuxIrd> findByEnjeuxIrdId(Long id);

    int deleteByEnjeuxIrdId(Long id);







}

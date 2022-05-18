package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.FormationContinueEnjeuxIrd;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.FormationContinueEnjeuxIrdVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface FormationContinueEnjeuxIrdChercheurService extends AbstractService<FormationContinueEnjeuxIrd,Long,FormationContinueEnjeuxIrdVo>{




/**
    * delete FormationContinueEnjeuxIrd from database
    * @param id - id of FormationContinueEnjeuxIrd to be deleted
    *
    */
    int deleteById(Long id);


    List<FormationContinueEnjeuxIrd> findByEnjeuxIrdCode(String code);

    int deleteByEnjeuxIrdCode(String code);

    List<FormationContinueEnjeuxIrd> findByEnjeuxIrdId(Long id);

    int deleteByEnjeuxIrdId(Long id);

    List<FormationContinueEnjeuxIrd> findByFormationContinueId(Long id);

    int deleteByFormationContinueId(Long id);







}

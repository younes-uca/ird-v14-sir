package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.ChercheurEmail;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ChercheurEmailVo;

import java.util.List;

public interface ChercheurEmailAdminService extends AbstractService<ChercheurEmail,Long,ChercheurEmailVo>{





/**
    * delete ChercheurEmail from database
    * @param id - id of ChercheurEmail to be deleted
    *
    */
    int deleteById(Long id);


    List<ChercheurEmail> findByChercheurNumeroMatricule(String numeroMatricule);

    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<ChercheurEmail> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);







}

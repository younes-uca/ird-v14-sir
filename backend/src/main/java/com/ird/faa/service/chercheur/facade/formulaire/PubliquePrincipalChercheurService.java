package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.PubliquePrincipal;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.PubliquePrincipalVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PubliquePrincipalChercheurService extends AbstractService<PubliquePrincipal,Long,PubliquePrincipalVo>{




/**
    * delete PubliquePrincipal from database
    * @param id - id of PubliquePrincipal to be deleted
    *
    */
    int deleteById(Long id);







}

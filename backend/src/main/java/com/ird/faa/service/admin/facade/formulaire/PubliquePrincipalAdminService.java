package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.PubliquePrincipal;
import com.ird.faa.ws.rest.provided.vo.PubliquePrincipalVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PubliquePrincipalAdminService extends AbstractService<PubliquePrincipal,Long,PubliquePrincipalVo>{




/**
    * delete PubliquePrincipal from database
    * @param id - id of PubliquePrincipal to be deleted
    *
    */
    int deleteById(Long id);







}

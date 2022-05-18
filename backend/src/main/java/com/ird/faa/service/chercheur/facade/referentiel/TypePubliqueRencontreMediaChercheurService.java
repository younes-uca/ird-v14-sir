package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.referentiel.TypePubliqueRencontreMedia;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.TypePubliqueRencontreMediaVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypePubliqueRencontreMediaChercheurService extends AbstractService<TypePubliqueRencontreMedia,Long,TypePubliqueRencontreMediaVo>{




/**
    * delete TypePubliqueRencontreMedia from database
    * @param id - id of TypePubliqueRencontreMedia to be deleted
    *
    */
    int deleteById(Long id);


    List<TypePubliqueRencontreMedia> findByTypePubliqueCode(String code);

    int deleteByTypePubliqueCode(String code);

    List<TypePubliqueRencontreMedia> findByTypePubliqueId(Long id);

    int deleteByTypePubliqueId(Long id);

    List<TypePubliqueRencontreMedia> findByRencontreMediaId(Long id);

    int deleteByRencontreMediaId(Long id);







}

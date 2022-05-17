package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.PaysEncadrementDoctorant;
import com.ird.faa.ws.rest.provided.vo.PaysEncadrementDoctorantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PaysEncadrementDoctorantChercheurService extends AbstractService<PaysEncadrementDoctorant,Long,PaysEncadrementDoctorantVo>{




/**
    * delete PaysEncadrementDoctorant from database
    * @param id - id of PaysEncadrementDoctorant to be deleted
    *
    */
    int deleteById(Long id);


    List<PaysEncadrementDoctorant> findByPaysCode(String code);

    int deleteByPaysCode(String code);

    List<PaysEncadrementDoctorant> findByPaysId(Long id);

    int deleteByPaysId(Long id);

    List<PaysEncadrementDoctorant> findByEncadrementDoctorantId(Long id);

    int deleteByEncadrementDoctorantId(Long id);







}

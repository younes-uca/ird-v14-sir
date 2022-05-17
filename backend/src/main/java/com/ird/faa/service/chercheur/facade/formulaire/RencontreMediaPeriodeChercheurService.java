package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.RencontreMediaPeriode;
import com.ird.faa.ws.rest.provided.vo.RencontreMediaPeriodeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface RencontreMediaPeriodeChercheurService extends AbstractService<RencontreMediaPeriode,Long,RencontreMediaPeriodeVo>{




/**
    * delete RencontreMediaPeriode from database
    * @param id - id of RencontreMediaPeriode to be deleted
    *
    */
    int deleteById(Long id);



    List<RencontreMediaPeriode> findByRencontreMediaId(Long id);

    int deleteByRencontreMediaId(Long id);







}

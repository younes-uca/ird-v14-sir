package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePubliquePeriode;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.RencontreGrandPubliqueJeunePubliquePeriodeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface RencontreGrandPubliqueJeunePubliquePeriodeChercheurService extends AbstractService<RencontreGrandPubliqueJeunePubliquePeriode,Long,RencontreGrandPubliqueJeunePubliquePeriodeVo>{




/**
    * delete RencontreGrandPubliqueJeunePubliquePeriode from database
    * @param id - id of RencontreGrandPubliqueJeunePubliquePeriode to be deleted
    *
    */
    int deleteById(Long id);



    List<RencontreGrandPubliqueJeunePubliquePeriode> findByRencontreGrandPubliqueJeunePubliqueId(Long id);

    int deleteByRencontreGrandPubliqueJeunePubliqueId(Long id);







}

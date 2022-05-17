package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;

import com.ird.faa.bean.formulaire.OutilPedagogiquePeriode;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.OutilPedagogiquePeriodeVo;

public interface OutilPedagogiquePeriodeChercheurService
		extends AbstractService<OutilPedagogiquePeriode, Long, OutilPedagogiquePeriodeVo> {

/**
    * delete OutilPedagogiquePeriode from database
    * @param id - id of OutilPedagogiquePeriode to be deleted
    *
    */
    int deleteById(Long id);

	List<OutilPedagogiquePeriode> findByOutilPedagogiqueId(Long id);

	int deleteByOutilPedagogiqueId(Long id);

}

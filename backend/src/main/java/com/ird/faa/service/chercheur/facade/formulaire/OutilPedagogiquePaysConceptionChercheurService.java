package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.OutilPedagogiquePaysConception;
import com.ird.faa.ws.rest.provided.vo.OutilPedagogiquePaysConceptionVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface OutilPedagogiquePaysConceptionChercheurService extends AbstractService<OutilPedagogiquePaysConception,Long,OutilPedagogiquePaysConceptionVo>{




/**
    * delete OutilPedagogiquePaysConception from database
    * @param id - id of OutilPedagogiquePaysConception to be deleted
    *
    */
    int deleteById(Long id);


    List<OutilPedagogiquePaysConception> findByPaysCode(String code);

    int deleteByPaysCode(String code);

    List<OutilPedagogiquePaysConception> findByPaysId(Long id);

    int deleteByPaysId(Long id);

    List<OutilPedagogiquePaysConception> findByOutilPedagogiqueId(Long id);

    int deleteByOutilPedagogiqueId(Long id);







}

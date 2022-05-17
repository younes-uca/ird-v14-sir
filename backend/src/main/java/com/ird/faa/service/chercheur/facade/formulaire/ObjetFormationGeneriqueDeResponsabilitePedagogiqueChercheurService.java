package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.ObjetFormationGeneriqueDeResponsabilitePedagogique;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.ObjetFormationGeneriqueDeResponsabilitePedagogiqueVo;

import java.util.List;

public interface ObjetFormationGeneriqueDeResponsabilitePedagogiqueChercheurService extends AbstractService<ObjetFormationGeneriqueDeResponsabilitePedagogique,Long,ObjetFormationGeneriqueDeResponsabilitePedagogiqueVo>{





/**
    * delete ObjetFormationGeneriqueDeResponsabilitePedagogique from database
    * @param id - id of ObjetFormationGeneriqueDeResponsabilitePedagogique to be deleted
    *
    */
    int deleteById(Long id);


    List<ObjetFormationGeneriqueDeResponsabilitePedagogique> findByObjetFormationGeneriqueCode(String code);

    int deleteByObjetFormationGeneriqueCode(String code);

    List<ObjetFormationGeneriqueDeResponsabilitePedagogique> findByObjetFormationGeneriqueId(Long id);

    int deleteByObjetFormationGeneriqueId(Long id);

    List<ObjetFormationGeneriqueDeResponsabilitePedagogique> findByResponsabilitePedagogiqueId(Long id);

    int deleteByResponsabilitePedagogiqueId(Long id);







}

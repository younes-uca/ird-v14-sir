package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.ZoneGeographiqueConseilsScientifique;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.ZoneGeographiqueConseilsScientifiqueVo;

import java.util.List;

public interface ZoneGeographiqueConseilsScientifiqueChercheurService extends AbstractService<ZoneGeographiqueConseilsScientifique,Long,ZoneGeographiqueConseilsScientifiqueVo>{





/**
    * delete ZoneGeographiqueConseilsScientifique from database
    * @param id - id of ZoneGeographiqueConseilsScientifique to be deleted
    *
    */
    int deleteById(Long id);



    List<ZoneGeographiqueConseilsScientifique> findByConseilsScientifiqueId(Long id);

    int deleteByConseilsScientifiqueId(Long id);
    List<ZoneGeographiqueConseilsScientifique> findByZoneGeographiqueCode(String code);

    int deleteByZoneGeographiqueCode(String code);

    List<ZoneGeographiqueConseilsScientifique> findByZoneGeographiqueId(Long id);

    int deleteByZoneGeographiqueId(Long id);
    List<ZoneGeographiqueConseilsScientifique> findByPaysCode(String code);

    int deleteByPaysCode(String code);

    List<ZoneGeographiqueConseilsScientifique> findByPaysId(Long id);

    int deleteByPaysId(Long id);







}

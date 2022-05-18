package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.ZoneGeographiqueConsultanceScientifiquePonctuelle;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ZoneGeographiqueConsultanceScientifiquePonctuelleVo;

import java.util.List;

public interface ZoneGeographiqueConsultanceScientifiquePonctuelleChercheurService extends AbstractService<ZoneGeographiqueConsultanceScientifiquePonctuelle,Long,ZoneGeographiqueConsultanceScientifiquePonctuelleVo>{





/**
    * delete ZoneGeographiqueConsultanceScientifiquePonctuelle from database
    * @param id - id of ZoneGeographiqueConsultanceScientifiquePonctuelle to be deleted
    *
    */
    int deleteById(Long id);



    List<ZoneGeographiqueConsultanceScientifiquePonctuelle> findByConsultanceScientifiquePonctuelleId(Long id);

    int deleteByConsultanceScientifiquePonctuelleId(Long id);
    List<ZoneGeographiqueConsultanceScientifiquePonctuelle> findByZoneGeographiqueCode(String code);

    int deleteByZoneGeographiqueCode(String code);

    List<ZoneGeographiqueConsultanceScientifiquePonctuelle> findByZoneGeographiqueId(Long id);

    int deleteByZoneGeographiqueId(Long id);
    List<ZoneGeographiqueConsultanceScientifiquePonctuelle> findByPaysCode(String code);

    int deleteByPaysCode(String code);

    List<ZoneGeographiqueConsultanceScientifiquePonctuelle> findByPaysId(Long id);

    int deleteByPaysId(Long id);







}

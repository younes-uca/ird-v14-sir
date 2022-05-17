package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.EnjeuxIrdConsultanceScientifiquePonctuelle;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.EnjeuxIrdConsultanceScientifiquePonctuelleVo;

import java.util.List;

public interface EnjeuxIrdConsultanceScientifiquePonctuelleChercheurService extends AbstractService<EnjeuxIrdConsultanceScientifiquePonctuelle,Long,EnjeuxIrdConsultanceScientifiquePonctuelleVo>{





/**
    * delete EnjeuxIrdConsultanceScientifiquePonctuelle from database
    * @param id - id of EnjeuxIrdConsultanceScientifiquePonctuelle to be deleted
    *
    */
    int deleteById(Long id);


    List<EnjeuxIrdConsultanceScientifiquePonctuelle> findByEnjeuxIrdCode(String code);

    int deleteByEnjeuxIrdCode(String code);

    List<EnjeuxIrdConsultanceScientifiquePonctuelle> findByEnjeuxIrdId(Long id);

    int deleteByEnjeuxIrdId(Long id);

    List<EnjeuxIrdConsultanceScientifiquePonctuelle> findByConsultanceScientifiquePonctuelleId(Long id);

    int deleteByConsultanceScientifiquePonctuelleId(Long id);







}

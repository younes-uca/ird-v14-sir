package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.formulaire.EnjeuxIrdConseilsScientifique;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.EnjeuxIrdConseilsScientifiqueVo;

import java.util.List;

public interface EnjeuxIrdConseilsScientifiqueChercheurService extends AbstractService<EnjeuxIrdConseilsScientifique,Long,EnjeuxIrdConseilsScientifiqueVo>{





/**
    * delete EnjeuxIrdConseilsScientifique from database
    * @param id - id of EnjeuxIrdConseilsScientifique to be deleted
    *
    */
    int deleteById(Long id);


    List<EnjeuxIrdConseilsScientifique> findByEnjeuxIrdCode(String code);

    int deleteByEnjeuxIrdCode(String code);

    List<EnjeuxIrdConseilsScientifique> findByEnjeuxIrdId(Long id);

    int deleteByEnjeuxIrdId(Long id);

    List<EnjeuxIrdConseilsScientifique> findByConseilsScientifiqueId(Long id);

    int deleteByConseilsScientifiqueId(Long id);







}

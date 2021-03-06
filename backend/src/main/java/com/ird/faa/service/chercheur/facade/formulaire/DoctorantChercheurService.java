package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.Doctorant;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DoctorantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DoctorantChercheurService extends AbstractService<Doctorant,Long,DoctorantVo>{




/**
    * delete Doctorant from database
    * @param id - id of Doctorant to be deleted
    *
    */
    int deleteById(Long id);


    List<Doctorant> findBySexeCode(String code);

    int deleteBySexeCode(String code);

    List<Doctorant> findBySexeId(Long id);

    int deleteBySexeId(Long id);
    List<Doctorant> findByPaysCode(String code);

    int deleteByPaysCode(String code);

    List<Doctorant> findByPaysId(Long id);

    int deleteByPaysId(Long id);





}

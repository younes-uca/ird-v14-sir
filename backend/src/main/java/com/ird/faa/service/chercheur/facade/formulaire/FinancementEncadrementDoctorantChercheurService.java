package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.FinancementEncadrementDoctorant;
import com.ird.faa.ws.rest.provided.vo.FinancementEncadrementDoctorantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface FinancementEncadrementDoctorantChercheurService extends AbstractService<FinancementEncadrementDoctorant,Long,FinancementEncadrementDoctorantVo>{




/**
    * delete FinancementEncadrementDoctorant from database
    * @param id - id of FinancementEncadrementDoctorant to be deleted
    *
    */
    int deleteById(Long id);


    List<FinancementEncadrementDoctorant> findByFinancementCode(String code);

    int deleteByFinancementCode(String code);

    List<FinancementEncadrementDoctorant> findByFinancementId(Long id);

    int deleteByFinancementId(Long id);

    List<FinancementEncadrementDoctorant> findByEncadrementDoctorantId(Long id);

    int deleteByEncadrementDoctorantId(Long id);







}

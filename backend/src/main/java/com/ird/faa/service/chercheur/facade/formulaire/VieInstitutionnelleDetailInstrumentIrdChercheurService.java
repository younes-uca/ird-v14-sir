package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.VieInstitutionnelleDetailInstrumentIrd;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.VieInstitutionnelleDetailInstrumentIrdVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface VieInstitutionnelleDetailInstrumentIrdChercheurService extends AbstractService<VieInstitutionnelleDetailInstrumentIrd,Long,VieInstitutionnelleDetailInstrumentIrdVo>{




/**
    * delete VieInstitutionnelleDetailInstrumentIrd from database
    * @param id - id of VieInstitutionnelleDetailInstrumentIrd to be deleted
    *
    */
    int deleteById(Long id);



    List<VieInstitutionnelleDetailInstrumentIrd> findByVieInstitutionnelleDetailId(Long id);

    int deleteByVieInstitutionnelleDetailId(Long id);
    List<VieInstitutionnelleDetailInstrumentIrd> findByInstrumentIrdCode(String code);

    int deleteByInstrumentIrdCode(String code);

    List<VieInstitutionnelleDetailInstrumentIrd> findByInstrumentIrdId(Long id);

    int deleteByInstrumentIrdId(Long id);





}

package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.ProjetActiviteRechercheDetailPays;
import com.ird.faa.ws.rest.provided.vo.ProjetActiviteRechercheDetailPaysVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ProjetActiviteRechercheDetailPaysChercheurService extends AbstractService<ProjetActiviteRechercheDetailPays,Long,ProjetActiviteRechercheDetailPaysVo>{




/**
    * delete ProjetActiviteRechercheDetailPays from database
    * @param id - id of ProjetActiviteRechercheDetailPays to be deleted
    *
    */
    int deleteById(Long id);


    List<ProjetActiviteRechercheDetailPays> findByPaysCode(String code);

    int deleteByPaysCode(String code);

    List<ProjetActiviteRechercheDetailPays> findByPaysId(Long id);

    int deleteByPaysId(Long id);

    List<ProjetActiviteRechercheDetailPays> findByProjetActiviteRechercheDetailId(Long id);

    int deleteByProjetActiviteRechercheDetailId(Long id);





}

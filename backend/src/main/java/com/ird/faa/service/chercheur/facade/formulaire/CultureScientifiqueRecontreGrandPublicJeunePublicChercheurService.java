package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.CultureScientifiqueRecontreGrandPublicJeunePublic;
import com.ird.faa.ws.rest.provided.vo.CultureScientifiqueRecontreGrandPublicJeunePublicVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CultureScientifiqueRecontreGrandPublicJeunePublicChercheurService extends AbstractService<CultureScientifiqueRecontreGrandPublicJeunePublic,Long,CultureScientifiqueRecontreGrandPublicJeunePublicVo>{




/**
    * delete CultureScientifiqueRecontreGrandPublicJeunePublic from database
    * @param id - id of CultureScientifiqueRecontreGrandPublicJeunePublic to be deleted
    *
    */
    int deleteById(Long id);


    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByFormatRencontreCode(String code);

    int deleteByFormatRencontreCode(String code);

    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByFormatRencontreId(Long id);

    int deleteByFormatRencontreId(Long id);
    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByCampagneCode(String code);

    int deleteByCampagneCode(String code);

    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);
    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByChercheurNumeroMatricule(String numeroMatricule);

    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);




   public List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByChercheurUsernameAndCampagneId(String username, Long compagneId);

}

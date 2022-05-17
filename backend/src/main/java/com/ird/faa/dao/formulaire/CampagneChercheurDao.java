package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.CampagneChercheur;


@Repository
public interface CampagneChercheurDao extends JpaRepository<CampagneChercheur,Long> {





    List<CampagneChercheur> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<CampagneChercheur> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);
    List<CampagneChercheur> findByCampagneCode(String code);
    int deleteByCampagneCode(String code);

    List<CampagneChercheur> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);
    List<CampagneChercheur> findByEtatCampagneChercheurCode(String code);
    int deleteByEtatCampagneChercheurCode(String code);

    List<CampagneChercheur> findByEtatCampagneChercheurId(Long id);

    int deleteByEtatCampagneChercheurId(Long id);


}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.CampagneChercheurOuverture;


@Repository
public interface CampagneChercheurOuvertureDao extends JpaRepository<CampagneChercheurOuverture,Long> {





    List<CampagneChercheurOuverture> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<CampagneChercheurOuverture> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);
    List<CampagneChercheurOuverture> findByCampagneCode(String code);
    int deleteByCampagneCode(String code);

    List<CampagneChercheurOuverture> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);


}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.DomaineScientifiqueChercheur;


@Repository
public interface DomaineScientifiqueChercheurDao extends JpaRepository<DomaineScientifiqueChercheur,Long> {





    List<DomaineScientifiqueChercheur> findByDomaineScientifiqueCode(String code);
    int deleteByDomaineScientifiqueCode(String code);

    List<DomaineScientifiqueChercheur> findByDomaineScientifiqueId(Long id);

    int deleteByDomaineScientifiqueId(Long id);
    List<DomaineScientifiqueChercheur> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<DomaineScientifiqueChercheur> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);


}

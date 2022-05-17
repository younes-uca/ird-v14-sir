package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.ZoneActiviteInteractionRecherche;


@Repository
public interface ZoneActiviteInteractionRechercheDao extends JpaRepository<ZoneActiviteInteractionRecherche,Long> {





    List<ZoneActiviteInteractionRecherche> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<ZoneActiviteInteractionRecherche> findByPaysId(Long id);

    int deleteByPaysId(Long id);
    List<ZoneActiviteInteractionRecherche> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<ZoneActiviteInteractionRecherche> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);


}

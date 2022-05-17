package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.PaysProjetRecherche;


@Repository
public interface PaysProjetRechercheDao extends JpaRepository<PaysProjetRecherche,Long> {





    List<PaysProjetRecherche> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<PaysProjetRecherche> findByPaysId(Long id);

    int deleteByPaysId(Long id);
    List<PaysProjetRecherche> findByProjetActiviteRechercheAnnee(Integer annee);
    int deleteByProjetActiviteRechercheAnnee(Integer annee);

    List<PaysProjetRecherche> findByProjetActiviteRechercheId(Long id);

    int deleteByProjetActiviteRechercheId(Long id);


}

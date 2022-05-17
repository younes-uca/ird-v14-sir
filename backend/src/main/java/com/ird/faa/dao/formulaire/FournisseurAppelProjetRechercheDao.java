package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.FournisseurAppelProjetRecherche;


@Repository
public interface FournisseurAppelProjetRechercheDao extends JpaRepository<FournisseurAppelProjetRecherche,Long> {




    FournisseurAppelProjetRecherche findByCode(String code);

    int deleteByCode(String code);

    List<FournisseurAppelProjetRecherche> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<FournisseurAppelProjetRecherche> findByPaysId(Long id);

    int deleteByPaysId(Long id);


}

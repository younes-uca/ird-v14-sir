package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.IdentifiantRecherche;


@Repository
public interface IdentifiantRechercheDao extends JpaRepository<IdentifiantRecherche,Long> {




    IdentifiantRecherche findByCode(String code);

    int deleteByCode(String code);



}

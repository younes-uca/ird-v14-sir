package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.NatureEnseignement;


@Repository
public interface NatureEnseignementDao extends JpaRepository<NatureEnseignement,Long> {




    NatureEnseignement findByCode(String code);

    int deleteByCode(String code);



}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.NiveauEtude;


@Repository
public interface NiveauEtudeDao extends JpaRepository<NiveauEtude,Long> {




    NiveauEtude findByCode(String code);

    int deleteByCode(String code);



}

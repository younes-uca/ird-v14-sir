package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.NiveauFormation;


@Repository
public interface NiveauFormationDao extends JpaRepository<NiveauFormation,Long> {




    NiveauFormation findByCode(String code);

    int deleteByCode(String code);



}

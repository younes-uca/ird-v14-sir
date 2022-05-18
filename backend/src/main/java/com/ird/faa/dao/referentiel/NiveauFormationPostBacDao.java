package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.NiveauFormationPostBac;


@Repository
public interface NiveauFormationPostBacDao extends JpaRepository<NiveauFormationPostBac,Long> {




    NiveauFormationPostBac findByCode(String code);

    int deleteByCode(String code);



}

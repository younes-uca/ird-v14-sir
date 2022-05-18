package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.Continent;


@Repository
public interface ContinentDao extends JpaRepository<Continent,Long> {




    Continent findByCode(String code);

    int deleteByCode(String code);



}

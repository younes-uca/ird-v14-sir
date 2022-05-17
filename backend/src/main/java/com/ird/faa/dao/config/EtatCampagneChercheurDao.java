package com.ird.faa.dao.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.config.EtatCampagneChercheur;


@Repository
public interface EtatCampagneChercheurDao extends JpaRepository<EtatCampagneChercheur,Long> {




    EtatCampagneChercheur findByCode(String code);

    int deleteByCode(String code);



}

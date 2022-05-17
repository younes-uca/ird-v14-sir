package com.ird.faa.dao.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.config.EtatCampagne;


@Repository
public interface EtatCampagneDao extends JpaRepository<EtatCampagne,Long> {




    EtatCampagne findByCode(String code);

    int deleteByCode(String code);



}

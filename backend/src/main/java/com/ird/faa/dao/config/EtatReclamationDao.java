package com.ird.faa.dao.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.config.EtatReclamation;


@Repository
public interface EtatReclamationDao extends JpaRepository<EtatReclamation,Long> {




    EtatReclamation findByCode(String code);

    int deleteByCode(String code);



}

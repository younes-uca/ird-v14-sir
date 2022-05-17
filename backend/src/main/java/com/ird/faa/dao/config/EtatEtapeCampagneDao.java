package com.ird.faa.dao.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.config.EtatEtapeCampagne;


@Repository
public interface EtatEtapeCampagneDao extends JpaRepository<EtatEtapeCampagne,Long> {




    EtatEtapeCampagne findByCode(String code);

    int deleteByCode(String code);



}

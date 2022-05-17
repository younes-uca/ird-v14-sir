package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.MasterInternational;


@Repository
public interface MasterInternationalDao extends JpaRepository<MasterInternational,Long> {




    MasterInternational findByCode(String code);

    int deleteByCode(String code);



}

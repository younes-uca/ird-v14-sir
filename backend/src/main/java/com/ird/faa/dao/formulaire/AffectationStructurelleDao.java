package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.referentiel.AffectationStructurelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AffectationStructurelleDao extends JpaRepository<AffectationStructurelle,Long> {




    AffectationStructurelle findByCode(String code);

    int deleteByCode(String code);



}

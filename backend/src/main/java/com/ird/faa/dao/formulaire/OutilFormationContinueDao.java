package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.OutilFormationContinue;


@Repository
public interface OutilFormationContinueDao extends JpaRepository<OutilFormationContinue,Long> {




    OutilFormationContinue findByCode(String code);

    int deleteByCode(String code);



}

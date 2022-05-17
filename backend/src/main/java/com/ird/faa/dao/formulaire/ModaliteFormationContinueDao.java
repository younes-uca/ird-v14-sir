package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.ModaliteFormationContinue;


@Repository
public interface ModaliteFormationContinueDao extends JpaRepository<ModaliteFormationContinue,Long> {




    ModaliteFormationContinue findByCode(String code);

    int deleteByCode(String code);



}

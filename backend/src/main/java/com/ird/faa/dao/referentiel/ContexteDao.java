package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.Contexte;


@Repository
public interface ContexteDao extends JpaRepository<Contexte,Long> {




    Contexte findByCode(String code);

    int deleteByCode(String code);



}

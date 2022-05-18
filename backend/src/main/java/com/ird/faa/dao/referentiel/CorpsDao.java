package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.Corps;


@Repository
public interface CorpsDao extends JpaRepository<Corps,Long> {




    Corps findByCode(String code);

    int deleteByCode(String code);



}

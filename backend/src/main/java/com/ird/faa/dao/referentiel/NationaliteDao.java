package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.Nationalite;


@Repository
public interface NationaliteDao extends JpaRepository<Nationalite,Long> {




    Nationalite findByCode(String code);

    int deleteByCode(String code);



}

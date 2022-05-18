package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.TypeOutil;


@Repository
public interface TypeOutilDao extends JpaRepository<TypeOutil,Long> {




    TypeOutil findByCode(String code);

    int deleteByCode(String code);



}

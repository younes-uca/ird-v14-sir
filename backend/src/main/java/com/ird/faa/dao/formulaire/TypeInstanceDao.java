package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.TypeInstance;


@Repository
public interface TypeInstanceDao extends JpaRepository<TypeInstance,Long> {




    TypeInstance findByCode(String code);

    int deleteByCode(String code);



}

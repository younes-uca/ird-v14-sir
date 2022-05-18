package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.TypeSavoir;


@Repository
public interface TypeSavoirDao extends JpaRepository<TypeSavoir,Long> {




    TypeSavoir findByCode(String code);

    int deleteByCode(String code);



}

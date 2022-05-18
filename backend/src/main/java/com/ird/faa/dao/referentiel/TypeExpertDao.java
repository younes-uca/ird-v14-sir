package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.TypeExpert;


@Repository
public interface TypeExpertDao extends JpaRepository<TypeExpert,Long> {




    TypeExpert findByCode(String code);

    int deleteByCode(String code);



}

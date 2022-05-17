package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.TypeExpertise;


@Repository
public interface TypeExpertiseDao extends JpaRepository<TypeExpertise,Long> {




    TypeExpertise findByCode(String code);

    int deleteByCode(String code);



}

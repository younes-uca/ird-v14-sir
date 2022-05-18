package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.Institution;


@Repository
public interface InstitutionDao extends JpaRepository<Institution,Long> {




    Institution findByCode(String code);

    int deleteByCode(String code);



}

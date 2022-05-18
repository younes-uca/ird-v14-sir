 package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.Grade;


@Repository
public interface GradeDao extends JpaRepository<Grade,Long> {




    Grade findByCode(String code);

    int deleteByCode(String code);



}

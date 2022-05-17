package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.EnjeuxIrd;


@Repository
public interface EnjeuxIrdDao extends JpaRepository<EnjeuxIrd,Long> {




    EnjeuxIrd findByCode(String code);

    int deleteByCode(String code);



}

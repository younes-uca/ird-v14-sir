package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.FinancementDoctorant;


@Repository
public interface FinancementDoctorantDao extends JpaRepository<FinancementDoctorant,Long> {




    FinancementDoctorant findByCode(String code);

    int deleteByCode(String code);



}

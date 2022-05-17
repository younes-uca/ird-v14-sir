package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.DisciplineScientifique;


@Repository
public interface DisciplineScientifiqueDao extends JpaRepository<DisciplineScientifique,Long> {




    DisciplineScientifique findByCode(String code);

    int deleteByCode(String code);



}

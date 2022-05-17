package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.DepartementScientifique;


@Repository
public interface DepartementScientifiqueDao extends JpaRepository<DepartementScientifique,Long> {




    DepartementScientifique findByCode(String code);

    int deleteByCode(String code);



}

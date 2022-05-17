package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.DomaineScientifique;


@Repository
public interface DomaineScientifiqueDao extends JpaRepository<DomaineScientifique,Long> {




    DomaineScientifique findByCode(String code);

    int deleteByCode(String code);



}

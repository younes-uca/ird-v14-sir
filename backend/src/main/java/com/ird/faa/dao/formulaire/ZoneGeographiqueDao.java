package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.ZoneGeographique;


@Repository
public interface ZoneGeographiqueDao extends JpaRepository<ZoneGeographique,Long> {




    ZoneGeographique findByCode(String code);

    int deleteByCode(String code);



}

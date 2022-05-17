package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.NatureActiviteGrandPublique;


@Repository
public interface NatureActiviteGrandPubliqueDao extends JpaRepository<NatureActiviteGrandPublique,Long> {




    NatureActiviteGrandPublique findByCode(String code);

    int deleteByCode(String code);



}

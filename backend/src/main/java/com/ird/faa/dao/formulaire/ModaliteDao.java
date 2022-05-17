package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.Modalite;


@Repository
public interface ModaliteDao extends JpaRepository<Modalite,Long> {




    Modalite findByCode(String code);

    int deleteByCode(String code);



}

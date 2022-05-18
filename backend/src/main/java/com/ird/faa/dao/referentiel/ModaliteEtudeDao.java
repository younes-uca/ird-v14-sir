package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.ModaliteEtude;


@Repository
public interface ModaliteEtudeDao extends JpaRepository<ModaliteEtude,Long> {




    ModaliteEtude findByCode(String code);

    int deleteByCode(String code);



}

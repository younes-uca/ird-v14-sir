package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.TypeEtude;


@Repository
public interface TypeEtudeDao extends JpaRepository<TypeEtude,Long> {




    TypeEtude findByCode(String code);

    int deleteByCode(String code);



}

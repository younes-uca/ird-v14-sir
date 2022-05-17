package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.Caracterisation;


@Repository
public interface CaracterisationDao extends JpaRepository<Caracterisation,Long> {




    Caracterisation findByCode(String code);

    int deleteByCode(String code);



}

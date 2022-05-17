package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.ResponsabiliteEncadrementEtudiant;


@Repository
public interface ResponsabiliteEncadrementEtudiantDao extends JpaRepository<ResponsabiliteEncadrementEtudiant,Long> {




    ResponsabiliteEncadrementEtudiant findByCode(String code);

    int deleteByCode(String code);



}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.TypeReclamation;


@Repository
public interface TypeReclamationDao extends JpaRepository<TypeReclamation,Long> {




    TypeReclamation findByCode(String code);

    int deleteByCode(String code);



}

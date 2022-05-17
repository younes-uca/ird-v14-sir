package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.ObjetFormationGenerique;


@Repository
public interface ObjetFormationGeneriqueDao extends JpaRepository<ObjetFormationGenerique,Long> {




    ObjetFormationGenerique findByCode(String code);

    int deleteByCode(String code);



}

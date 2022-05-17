package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.StatusProjet;


@Repository
public interface StatusProjetDao extends JpaRepository<StatusProjet,Long> {




    StatusProjet findByCode(String code);

    int deleteByCode(String code);



}

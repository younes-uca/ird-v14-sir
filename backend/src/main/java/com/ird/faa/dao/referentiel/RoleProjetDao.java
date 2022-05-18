package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.RoleProjet;


@Repository
public interface RoleProjetDao extends JpaRepository<RoleProjet,Long> {




    RoleProjet findByCode(String code);

    int deleteByCode(String code);



}

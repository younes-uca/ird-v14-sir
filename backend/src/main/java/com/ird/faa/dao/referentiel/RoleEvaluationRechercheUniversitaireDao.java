package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.RoleEvaluationRechercheUniversitaire;


@Repository
public interface RoleEvaluationRechercheUniversitaireDao extends JpaRepository<RoleEvaluationRechercheUniversitaire,Long> {




    RoleEvaluationRechercheUniversitaire findByCode(String code);

    int deleteByCode(String code);



}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.EvaluationEncadrement;


@Repository
public interface EvaluationEncadrementDao extends JpaRepository<EvaluationEncadrement,Long> {




    EvaluationEncadrement findByCode(String code);

    int deleteByCode(String code);



}

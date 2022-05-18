package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.referentiel.RoleEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleEvaluationDao extends JpaRepository<RoleEvaluation,Long> {



    @Query("SELECT item FROM RoleEvaluation item ORDER BY item.code ASC")
    List<RoleEvaluation> findAll();

    RoleEvaluation findByCode(String code);

    int deleteByCode(String code);



}

package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.TypeExpertiseEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeExpertiseEvaluationDao extends JpaRepository<TypeExpertiseEvaluation,Long> {



    @Query("SELECT item FROM TypeExpertiseEvaluation item ORDER BY item.code ASC")
    List<TypeExpertiseEvaluation> findAll();

    TypeExpertiseEvaluation findByCode(String code);

    int deleteByCode(String code);



}

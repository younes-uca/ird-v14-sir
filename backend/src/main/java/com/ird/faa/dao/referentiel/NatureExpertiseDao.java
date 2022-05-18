package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.referentiel.NatureExpertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NatureExpertiseDao extends JpaRepository<NatureExpertise,Long> {



    @Query("SELECT item FROM NatureExpertise item ORDER BY item.code ASC")
    List<NatureExpertise> findAll();

    NatureExpertise findByCode(String code);

    int deleteByCode(String code);



}

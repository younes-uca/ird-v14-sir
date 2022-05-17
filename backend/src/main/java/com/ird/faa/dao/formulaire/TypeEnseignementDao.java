package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.referentiel.TypeEnseignement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeEnseignementDao extends JpaRepository<TypeEnseignement,Long> {



    @Query("SELECT item FROM TypeEnseignement item ORDER BY item.code ASC")
    List<TypeEnseignement> findAll();

    TypeEnseignement findByCode(String code);

    int deleteByCode(String code);



}

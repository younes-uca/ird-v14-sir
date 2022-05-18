package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.referentiel.PubliqueFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PubliqueFormationDao extends JpaRepository<PubliqueFormation,Long> {



    @Query("SELECT item FROM PubliqueFormation item ORDER BY item.code ASC")
    List<PubliqueFormation> findAll();

    PubliqueFormation findByCode(String code);

    int deleteByCode(String code);



}

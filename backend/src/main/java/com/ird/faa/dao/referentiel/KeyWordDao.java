package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.referentiel.KeyWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyWordDao extends JpaRepository<KeyWord,Long> {



    @Query("SELECT item FROM KeyWord item ORDER BY item.code ASC")
    List<KeyWord> findAll();

    KeyWord findByCode(String code);

    int deleteByCode(String code);



}

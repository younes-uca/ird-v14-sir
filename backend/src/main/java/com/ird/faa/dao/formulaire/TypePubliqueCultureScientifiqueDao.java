package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.TypePubliqueCultureScientifique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypePubliqueCultureScientifiqueDao extends JpaRepository<TypePubliqueCultureScientifique,Long> {



    @Query("SELECT item FROM TypePubliqueCultureScientifique item ORDER BY item.code ASC")
    List<TypePubliqueCultureScientifique> findAll();

    TypePubliqueCultureScientifique findByCode(String code);

    int deleteByCode(String code);



}

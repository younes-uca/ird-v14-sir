package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueErcParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineScientifiqueErcParentDao extends JpaRepository<DisciplineScientifiqueErcParent,Long> {



    @Query("SELECT item FROM DisciplineScientifiqueErcParent item ORDER BY item.code ASC")
    List<DisciplineScientifiqueErcParent> findAll();

    DisciplineScientifiqueErcParent findByCode(String code);

    int deleteByCode(String code);



}

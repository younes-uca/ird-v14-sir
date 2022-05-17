package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineScientifiqueParentDao extends JpaRepository<DisciplineScientifiqueParent,Long> {



    @Query("SELECT item FROM DisciplineScientifiqueParent item ORDER BY item.code ASC")
    List<DisciplineScientifiqueParent> findAll();

    DisciplineScientifiqueParent findByCode(String code);

    int deleteByCode(String code);



}

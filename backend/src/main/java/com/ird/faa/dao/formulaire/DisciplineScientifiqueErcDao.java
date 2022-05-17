package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueErc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineScientifiqueErcDao extends JpaRepository<DisciplineScientifiqueErc,Long> {



    @Query("SELECT item FROM DisciplineScientifiqueErc item ORDER BY item.code ASC")
    List<DisciplineScientifiqueErc> findAll();

    DisciplineScientifiqueErc findByCode(String code);

    int deleteByCode(String code);

    List<DisciplineScientifiqueErc> findByDisciplineScientifiqueErcParentCode(String code);
    int deleteByDisciplineScientifiqueErcParentCode(String code);

    List<DisciplineScientifiqueErc> findByDisciplineScientifiqueErcParentId(Long id);

    int deleteByDisciplineScientifiqueErcParentId(Long id);


}

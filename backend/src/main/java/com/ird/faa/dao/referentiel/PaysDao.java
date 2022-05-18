package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.referentiel.Pays;


@Repository
public interface PaysDao extends JpaRepository<Pays,Long> {




    Pays findByCode(String code);

    int deleteByCode(String code);

    List<Pays> findByContinentCode(String code);
    int deleteByContinentCode(String code);

    List<Pays> findByContinentId(Long id);

    int deleteByContinentId(Long id);


}

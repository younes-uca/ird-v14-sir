package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.referentiel.Ville;


@Repository
public interface VilleDao extends JpaRepository<Ville,Long> {




    Ville findByCode(String code);

    int deleteByCode(String code);

    List<Ville> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<Ville> findByPaysId(Long id);

    int deleteByPaysId(Long id);


}

package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.PaysCommanditaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaysCommanditaireDao extends JpaRepository<PaysCommanditaire,Long> {






    List<PaysCommanditaire> findByConsultanceScientifiquePonctuelleId(Long id);

    int deleteByConsultanceScientifiquePonctuelleId(Long id);
    List<PaysCommanditaire> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<PaysCommanditaire> findByPaysId(Long id);

    int deleteByPaysId(Long id);


}

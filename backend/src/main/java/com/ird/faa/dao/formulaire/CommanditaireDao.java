package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.Commanditaire;


@Repository
public interface CommanditaireDao extends JpaRepository<Commanditaire,Long> {




    Commanditaire findByCode(String code);

    int deleteByCode(String code);

    List<Commanditaire> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<Commanditaire> findByPaysId(Long id);

    int deleteByPaysId(Long id);


}

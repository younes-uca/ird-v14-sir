package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.ChercheurEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChercheurEmailDao extends JpaRepository<ChercheurEmail,Long> {





    List<ChercheurEmail> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<ChercheurEmail> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);


}

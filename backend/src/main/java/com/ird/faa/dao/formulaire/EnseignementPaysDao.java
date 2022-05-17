package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.EnseignementPays;


@Repository
public interface EnseignementPaysDao extends JpaRepository<EnseignementPays,Long> {

    List<EnseignementPays> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<EnseignementPays> findByPaysId(Long id);

    int deleteByPaysId(Long id);

    List<EnseignementPays> findByEnseignementId(Long id);

    int deleteByEnseignementId(Long id);


}

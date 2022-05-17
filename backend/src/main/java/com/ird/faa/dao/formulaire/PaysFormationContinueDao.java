package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.PaysFormationContinue;


@Repository
public interface PaysFormationContinueDao extends JpaRepository<PaysFormationContinue,Long> {





    List<PaysFormationContinue> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<PaysFormationContinue> findByPaysId(Long id);

    int deleteByPaysId(Long id);

    List<PaysFormationContinue> findByFormationContinueId(Long id);

    int deleteByFormationContinueId(Long id);


}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.CommissionScientifique;


@Repository
public interface CommissionScientifiqueDao extends JpaRepository<CommissionScientifique,Long> {




    CommissionScientifique findByCode(String code);

    int deleteByCode(String code);



}

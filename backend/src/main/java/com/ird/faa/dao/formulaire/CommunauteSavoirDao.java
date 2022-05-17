package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.CommunauteSavoir;


@Repository
public interface CommunauteSavoirDao extends JpaRepository<CommunauteSavoir,Long> {




    CommunauteSavoir findByCode(String code);

    int deleteByCode(String code);



}

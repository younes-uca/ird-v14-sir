package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.PublicCible;


@Repository
public interface PublicCibleDao extends JpaRepository<PublicCible,Long> {




    PublicCible findByCode(String code);

    int deleteByCode(String code);



}

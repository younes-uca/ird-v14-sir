package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.Organisme;


@Repository
public interface OrganismeDao extends JpaRepository<Organisme,Long> {




    Organisme findByCode(String code);

    int deleteByCode(String code);



}

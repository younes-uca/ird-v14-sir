package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.TemplateOuverture;


@Repository
public interface TemplateOuvertureDao extends JpaRepository<TemplateOuverture,Long> {




    TemplateOuverture findByCode(String code);

    int deleteByCode(String code);



}

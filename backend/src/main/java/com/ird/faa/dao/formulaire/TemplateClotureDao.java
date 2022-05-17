package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.TemplateCloture;


@Repository
public interface TemplateClotureDao extends JpaRepository<TemplateCloture,Long> {




    TemplateCloture findByCode(String code);

    int deleteByCode(String code);



}

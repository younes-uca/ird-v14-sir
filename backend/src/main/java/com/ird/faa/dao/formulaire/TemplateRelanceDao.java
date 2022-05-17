package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.TemplateRelance;


@Repository
public interface TemplateRelanceDao extends JpaRepository<TemplateRelance,Long> {




    TemplateRelance findByCode(String code);

    int deleteByCode(String code);



}

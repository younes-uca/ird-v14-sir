package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.TemplateRappel;


@Repository
public interface TemplateRappelDao extends JpaRepository<TemplateRappel,Long> {




    TemplateRappel findByCode(String code);

    int deleteByCode(String code);



}

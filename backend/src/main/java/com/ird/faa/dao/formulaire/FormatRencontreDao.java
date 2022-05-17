package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.FormatRencontre;


@Repository
public interface FormatRencontreDao extends JpaRepository<FormatRencontre,Long> {




    FormatRencontre findByCode(String code);

    int deleteByCode(String code);



}

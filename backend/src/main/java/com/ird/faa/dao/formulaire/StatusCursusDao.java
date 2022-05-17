package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.StatusCursus;


@Repository
public interface StatusCursusDao extends JpaRepository<StatusCursus,Long> {




    StatusCursus findByCode(String code);

    int deleteByCode(String code);



}

package com.ird.faa.dao.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.config.Langue;


@Repository
public interface LangueDao extends JpaRepository<Langue,Long> {




    Langue findByCode(String code);

    int deleteByCode(String code);



}

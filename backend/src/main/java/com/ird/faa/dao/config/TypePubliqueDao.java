package com.ird.faa.dao.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.config.TypePublique;


@Repository
public interface TypePubliqueDao extends JpaRepository<TypePublique,Long> {




    TypePublique findByCode(String code);

    int deleteByCode(String code);



}

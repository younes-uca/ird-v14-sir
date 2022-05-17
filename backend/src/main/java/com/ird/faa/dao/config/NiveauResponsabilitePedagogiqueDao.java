package com.ird.faa.dao.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.config.NiveauResponsabilitePedagogique;


@Repository
public interface NiveauResponsabilitePedagogiqueDao extends JpaRepository<NiveauResponsabilitePedagogique,Long> {

    NiveauResponsabilitePedagogique findByCode(String code);

    int deleteByCode(String code);



}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.ResponsabiliteEncadrementDoctorant;


@Repository
public interface ResponsabiliteEncadrementDoctorantDao extends JpaRepository<ResponsabiliteEncadrementDoctorant,Long> {




    ResponsabiliteEncadrementDoctorant findByCode(String code);

    int deleteByCode(String code);



}

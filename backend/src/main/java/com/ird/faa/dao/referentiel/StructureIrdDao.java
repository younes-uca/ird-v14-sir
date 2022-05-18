package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.StructureIrd;


@Repository
public interface StructureIrdDao extends JpaRepository<StructureIrd,Long> {




    StructureIrd findByCode(String code);

    int deleteByCode(String code);



}

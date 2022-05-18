package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.TypeInstrumentIrd;


@Repository
public interface TypeInstrumentIrdDao extends JpaRepository<TypeInstrumentIrd,Long> {




    TypeInstrumentIrd findByCode(String code);

    int deleteByCode(String code);



}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.referentiel.InstrumentIrd;


@Repository
public interface InstrumentIrdDao extends JpaRepository<InstrumentIrd,Long> {




    InstrumentIrd findByCode(String code);

    int deleteByCode(String code);

    List<InstrumentIrd> findByTypeInstrumentIrdCode(String code);
    int deleteByTypeInstrumentIrdCode(String code);

    List<InstrumentIrd> findByTypeInstrumentIrdId(Long id);

    int deleteByTypeInstrumentIrdId(Long id);


}

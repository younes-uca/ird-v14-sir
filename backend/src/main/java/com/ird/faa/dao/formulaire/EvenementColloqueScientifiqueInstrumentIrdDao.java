package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.EvenementColloqueScientifiqueInstrumentIrd;


@Repository
public interface EvenementColloqueScientifiqueInstrumentIrdDao extends JpaRepository<EvenementColloqueScientifiqueInstrumentIrd,Long> {






    List<EvenementColloqueScientifiqueInstrumentIrd> findByEvenementColloqueScienntifiqueId(Long id);

    int deleteByEvenementColloqueScienntifiqueId(Long id);
    List<EvenementColloqueScientifiqueInstrumentIrd> findByInstrumentIrdCode(String code);
    int deleteByInstrumentIrdCode(String code);

    List<EvenementColloqueScientifiqueInstrumentIrd> findByInstrumentIrdId(Long id);

    int deleteByInstrumentIrdId(Long id);


}

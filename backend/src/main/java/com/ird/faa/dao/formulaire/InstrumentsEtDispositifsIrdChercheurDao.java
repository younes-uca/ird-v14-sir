package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrdChercheur;


@Repository
public interface InstrumentsEtDispositifsIrdChercheurDao extends JpaRepository<InstrumentsEtDispositifsIrdChercheur,Long> {





    List<InstrumentsEtDispositifsIrdChercheur> findByTypeInstrumentsEtDispositifsIrdCode(String code);
    int deleteByTypeInstrumentsEtDispositifsIrdCode(String code);

    List<InstrumentsEtDispositifsIrdChercheur> findByTypeInstrumentsEtDispositifsIrdId(Long id);

    int deleteByTypeInstrumentsEtDispositifsIrdId(Long id);
    List<InstrumentsEtDispositifsIrdChercheur> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<InstrumentsEtDispositifsIrdChercheur> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);


}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrd;


@Repository
public interface InstrumentsEtDispositifsIrdDao extends JpaRepository<InstrumentsEtDispositifsIrd,Long> {




    InstrumentsEtDispositifsIrd findByCode(String code);

    int deleteByCode(String code);

    List<InstrumentsEtDispositifsIrd> findByCampagneCode(String code);
    int deleteByCampagneCode(String code);

    List<InstrumentsEtDispositifsIrd> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);
    List<InstrumentsEtDispositifsIrd> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<InstrumentsEtDispositifsIrd> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);

    List<InstrumentsEtDispositifsIrd> findByChercheurUsernameAndCampagneId(String username, Long compagneId);
    List<InstrumentsEtDispositifsIrd> findByChercheurUsername(String username);

}

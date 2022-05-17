package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrdProjetActiviteRecherche;


@Repository
public interface InstrumentsEtDispositifsIrdProjetActiviteRechercheDao extends JpaRepository<InstrumentsEtDispositifsIrdProjetActiviteRecherche,Long> {





    List<InstrumentsEtDispositifsIrdProjetActiviteRecherche> findByProjetActiviteRechercheAnnee(Integer annee);
    int deleteByProjetActiviteRechercheAnnee(Integer annee);

    List<InstrumentsEtDispositifsIrdProjetActiviteRecherche> findByProjetActiviteRechercheId(Long id);

    int deleteByProjetActiviteRechercheId(Long id);
    List<InstrumentsEtDispositifsIrdProjetActiviteRecherche> findByInstrumentsEtDispositifsIrdCode(String code);
    int deleteByInstrumentsEtDispositifsIrdCode(String code);

    List<InstrumentsEtDispositifsIrdProjetActiviteRecherche> findByInstrumentsEtDispositifsIrdId(Long id);

    int deleteByInstrumentsEtDispositifsIrdId(Long id);


}

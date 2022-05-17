package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.CommunauteSavoirProjetActiviteRecherche;


@Repository
public interface CommunauteSavoirProjetActiviteRechercheDao extends JpaRepository<CommunauteSavoirProjetActiviteRecherche,Long> {





    List<CommunauteSavoirProjetActiviteRecherche> findByProjetActiviteRechercheAnnee(Integer annee);
    int deleteByProjetActiviteRechercheAnnee(Integer annee);

    List<CommunauteSavoirProjetActiviteRecherche> findByProjetActiviteRechercheId(Long id);

    int deleteByProjetActiviteRechercheId(Long id);
    List<CommunauteSavoirProjetActiviteRecherche> findByCommunauteSavoirCode(String code);
    int deleteByCommunauteSavoirCode(String code);

    List<CommunauteSavoirProjetActiviteRecherche> findByCommunauteSavoirId(Long id);

    int deleteByCommunauteSavoirId(Long id);


}

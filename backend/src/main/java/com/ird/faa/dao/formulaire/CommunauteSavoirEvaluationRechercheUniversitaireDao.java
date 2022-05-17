package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.CommunauteSavoirEvaluationRechercheUniversitaire;


@Repository
public interface CommunauteSavoirEvaluationRechercheUniversitaireDao extends JpaRepository<CommunauteSavoirEvaluationRechercheUniversitaire,Long> {





    List<CommunauteSavoirEvaluationRechercheUniversitaire> findByEvaluationRechercheUniversitaireAnnee(Integer annee);
    int deleteByEvaluationRechercheUniversitaireAnnee(Integer annee);

    List<CommunauteSavoirEvaluationRechercheUniversitaire> findByEvaluationRechercheUniversitaireId(Long id);

    int deleteByEvaluationRechercheUniversitaireId(Long id);
    List<CommunauteSavoirEvaluationRechercheUniversitaire> findByCommunauteSavoirCode(String code);
    int deleteByCommunauteSavoirCode(String code);

    List<CommunauteSavoirEvaluationRechercheUniversitaire> findByCommunauteSavoirId(Long id);

    int deleteByCommunauteSavoirId(Long id);


}

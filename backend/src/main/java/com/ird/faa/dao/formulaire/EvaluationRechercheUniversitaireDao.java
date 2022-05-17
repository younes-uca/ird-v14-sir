package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.EvaluationRechercheUniversitaire;


@Repository
public interface EvaluationRechercheUniversitaireDao extends JpaRepository<EvaluationRechercheUniversitaire,Long> {




    EvaluationRechercheUniversitaire findByAnnee(Integer annee);

    int deleteByAnnee(Integer annee);

    List<EvaluationRechercheUniversitaire> findByTypeExpertCode(String code);
    int deleteByTypeExpertCode(String code);

    List<EvaluationRechercheUniversitaire> findByTypeExpertId(Long id);

    int deleteByTypeExpertId(Long id);
    List<EvaluationRechercheUniversitaire> findByRoleEvaluationRechercheUniversitaireCode(String code);
    int deleteByRoleEvaluationRechercheUniversitaireCode(String code);

    List<EvaluationRechercheUniversitaire> findByRoleEvaluationRechercheUniversitaireId(Long id);

    int deleteByRoleEvaluationRechercheUniversitaireId(Long id);
    List<EvaluationRechercheUniversitaire> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<EvaluationRechercheUniversitaire> findByPaysId(Long id);

    int deleteByPaysId(Long id);
    List<EvaluationRechercheUniversitaire> findByEtablissementCode(String code);
    int deleteByEtablissementCode(String code);

    List<EvaluationRechercheUniversitaire> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);
    List<EvaluationRechercheUniversitaire> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<EvaluationRechercheUniversitaire> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);
    List<EvaluationRechercheUniversitaire> findByCampagneCode(String code);
    int deleteByCampagneCode(String code);

    List<EvaluationRechercheUniversitaire> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);
    List<EvaluationRechercheUniversitaire> findByEtatEtapeCampagneCode(String code);
    int deleteByEtatEtapeCampagneCode(String code);

    List<EvaluationRechercheUniversitaire> findByEtatEtapeCampagneId(Long id);

    int deleteByEtatEtapeCampagneId(Long id);


}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueEvaluationRechercheUniversitaire;


@Repository
public interface DisciplineScientifiqueEvaluationRechercheUniversitaireDao extends JpaRepository<DisciplineScientifiqueEvaluationRechercheUniversitaire,Long> {





    List<DisciplineScientifiqueEvaluationRechercheUniversitaire> findByDisciplineScientifiqueCode(String code);
    int deleteByDisciplineScientifiqueCode(String code);

    List<DisciplineScientifiqueEvaluationRechercheUniversitaire> findByDisciplineScientifiqueId(Long id);

    int deleteByDisciplineScientifiqueId(Long id);
    List<DisciplineScientifiqueEvaluationRechercheUniversitaire> findByEvaluationRechercheUniversitaireAnnee(Integer annee);
    int deleteByEvaluationRechercheUniversitaireAnnee(Integer annee);

    List<DisciplineScientifiqueEvaluationRechercheUniversitaire> findByEvaluationRechercheUniversitaireId(Long id);

    int deleteByEvaluationRechercheUniversitaireId(Long id);


}

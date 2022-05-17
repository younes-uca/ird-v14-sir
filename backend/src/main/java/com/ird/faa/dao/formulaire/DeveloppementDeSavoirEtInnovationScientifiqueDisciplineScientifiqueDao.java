package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique;

@Repository
public interface DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueDao
		extends JpaRepository<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique, Long> {

	List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique> findByDisciplineScientifiqueCode(String code);

	int deleteByDisciplineScientifiqueCode(String code);

	List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique> findByDisciplineScientifiqueId(Long id);

	int deleteByDisciplineScientifiqueId(Long id);

	List<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique> findByDeveloppementDeSavoirEtInnovationScientifiqueId(
			Long id);

	int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);

}

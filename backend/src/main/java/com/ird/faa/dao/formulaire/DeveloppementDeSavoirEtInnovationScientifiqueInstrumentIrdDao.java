package com.ird.faa.dao.formulaire;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd;

@Repository
public interface DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdDao
		extends JpaRepository<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd, Long> {

	List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd> findByInstrumentIrdCode(String code);

	int deleteByInstrumentIrdCode(String code);

	List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd> findByInstrumentIrdId(Long id);

	int deleteByInstrumentIrdId(Long id);

	List<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd> findByDeveloppementDeSavoirEtInnovationScientifiqueId(
			Long id);

	int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);

}

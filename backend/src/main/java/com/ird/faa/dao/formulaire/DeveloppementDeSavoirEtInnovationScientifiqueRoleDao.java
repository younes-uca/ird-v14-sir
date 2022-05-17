package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueRole;

@Repository
public interface DeveloppementDeSavoirEtInnovationScientifiqueRoleDao
		extends JpaRepository<DeveloppementDeSavoirEtInnovationScientifiqueRole, Long> {

	List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByRoleDeveloppementDeSavoirCode(String code);

	int deleteByRoleDeveloppementDeSavoirCode(String code);

	List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByRoleDeveloppementDeSavoirId(Long id);

	int deleteByRoleDeveloppementDeSavoirId(Long id);

	List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByDeveloppementDeSavoirEtInnovationScientifiqueId(
			Long id);

	int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);

}

package com.ird.faa.dao.formulaire;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.SavoirEtInnovation;

@Repository
public interface SavoirEtInnovationDao extends JpaRepository<SavoirEtInnovation, Long> {

	List<SavoirEtInnovation> findByCampagneCode(String code);

	int deleteByCampagneCode(String code);

	List<SavoirEtInnovation> findByCampagneId(Long id);

	int deleteByCampagneId(Long id);

	List<SavoirEtInnovation> findByChercheurNumeroMatricule(String numeroMatricule);

	int deleteByChercheurNumeroMatricule(String numeroMatricule);

	List<SavoirEtInnovation> findByChercheurId(Long id);

	int deleteByChercheurId(Long id);

	List<SavoirEtInnovation> findByEtatEtapeCampagneCode(String code);

	int deleteByEtatEtapeCampagneCode(String code);

	List<SavoirEtInnovation> findByEtatEtapeCampagneId(Long id);

	int deleteByEtatEtapeCampagneId(Long id);

	List<SavoirEtInnovation> findByChercheurUsernameAndCampagneId(String username, Long compagneId);

	List<SavoirEtInnovation> findByChercheurUsername(String username);

}

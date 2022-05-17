package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.EtablissementEnseignement;

@Repository
public interface EtablissementEnseignementDao
		extends JpaRepository<EtablissementEnseignement, Long> {
	List<EtablissementEnseignement> findByEtablissementCode(String code);

	int deleteByEtablissementCode(String code);

	List<EtablissementEnseignement> findByEtablissementId(Long id);

	int deleteByEtablissementId(Long id);

	List<EtablissementEnseignement> findByEnseignementId(Long id);

	int deleteByEnseignementId(Long id);

	List<EtablissementEnseignement> findByPaysCode(String code);

	int deleteByPaysCode(String code);

	List<EtablissementEnseignement> findByPaysId(Long id);

	int deleteByPaysId(Long id);

}

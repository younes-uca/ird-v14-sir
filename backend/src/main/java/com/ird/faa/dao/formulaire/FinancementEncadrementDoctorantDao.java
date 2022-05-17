package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.FinancementEncadrementDoctorant;

@Repository
public interface FinancementEncadrementDoctorantDao extends JpaRepository<FinancementEncadrementDoctorant, Long> {

	List<FinancementEncadrementDoctorant> findByFinancementCode(String code);

	int deleteByFinancementCode(String code);

	List<FinancementEncadrementDoctorant> findByFinancementId(Long id);

	int deleteByFinancementId(Long id);

	List<FinancementEncadrementDoctorant> findByEncadrementDoctorantId(Long id);

	int deleteByEncadrementDoctorantId(Long id);

}

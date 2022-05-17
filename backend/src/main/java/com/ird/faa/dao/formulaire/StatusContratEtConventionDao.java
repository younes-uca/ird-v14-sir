package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ird.faa.bean.formulaire.StatusContratEtConvention;

@Repository
public interface StatusContratEtConventionDao extends JpaRepository<StatusContratEtConvention, Long> {

	StatusContratEtConvention findByCode(String code);

	int deleteByCode(String code);

}

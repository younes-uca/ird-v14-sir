package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.ird.faa.bean.formulaire.EvenementColloqueScienntifiquePays;

@Repository
public interface EvenementColloqueScienntifiquePaysDao extends JpaRepository<EvenementColloqueScienntifiquePays, Long> {

	List<EvenementColloqueScienntifiquePays> findByEvenementColloqueScienntifiqueId(Long id);

	int deleteByEvenementColloqueScienntifiqueId(Long id);

	List<EvenementColloqueScienntifiquePays> findByPaysCode(String code);

	int deleteByPaysCode(String code);

	List<EvenementColloqueScienntifiquePays> findByPaysId(Long id);

	int deleteByPaysId(Long id);

}

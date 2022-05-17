package com.ird.faa.dao.formulaire;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.GestionEquipeDetail;

@Repository
public interface GestionEquipeDetailDao extends JpaRepository<GestionEquipeDetail, Long> {

	List<GestionEquipeDetail> findByGestionEquipeId(Long id);

	int deleteByGestionEquipeId(Long id);

}

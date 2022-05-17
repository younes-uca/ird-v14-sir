package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ird.faa.bean.formulaire.Partenaire;

public interface PartenaireDao extends JpaRepository<Partenaire, Long> {
	
	Partenaire findByIdGraphQl(String code);

    int deleteByIdGraphQl(String code);
}

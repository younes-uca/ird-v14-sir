package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ird.faa.bean.referentiel.TypeUtilisateur;

@Repository
public interface TypeUtilisateurDao extends JpaRepository<TypeUtilisateur, Long> {

	TypeUtilisateur findByCode(String code);

	int deleteByCode(String code);

}

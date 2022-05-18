package com.ird.faa.service.chercheur.facade.formulaire;

import com.ird.faa.bean.referentiel.TypeUtilisateur;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.TypeUtilisateurVo;

public interface TypeUtilisateurChercheurService extends AbstractService<TypeUtilisateur, Long, TypeUtilisateurVo> {

	/**
	 * find TypeUtilisateur from database by code (reference)
	 * 
	 * @param code - reference of TypeUtilisateur
	 * @return the founded TypeUtilisateur , If no TypeUtilisateur were found in
	 *         database return null.
	 */
	TypeUtilisateur findByCode(String code);

	/**
	 * find TypeUtilisateur from database by id (PK) or code (reference)
	 * 
	 * @param id   - id of TypeUtilisateur
	 * @param code - reference of TypeUtilisateur
	 * @return the founded TypeUtilisateur , If no TypeUtilisateur were found in
	 *         database return null.
	 */
	TypeUtilisateur findByIdOrCode(TypeUtilisateur typeUtilisateur);

	/**
	 * delete TypeUtilisateur from database
	 * 
	 * @param id - id of TypeUtilisateur to be deleted
	 *
	 */
	int deleteById(Long id);

	/**
	 * delete TypeUtilisateur from database by code (reference)
	 *
	 * @param code - reference of TypeUtilisateur to be deleted
	 * @return 1 if TypeUtilisateur deleted successfully
	 */
	int deleteByCode(String code);

}

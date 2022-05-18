package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.TypeEtude;
import com.ird.faa.dao.formulaire.TypeEtudeDao;
import com.ird.faa.service.chercheur.facade.formulaire.TypeEtudeChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.TypeEtudeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeEtudeChercheurServiceImpl extends AbstractServiceImpl<TypeEtude> implements TypeEtudeChercheurService {

	@Autowired
	private TypeEtudeDao typeEtudeDao;

	@Autowired
	private ArchivableService<TypeEtude> archivableService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<TypeEtude> findAll() {
		String query = "SELECT o FROM TypeEtude o where 1=1 ";
		query += " AND o.archive != true";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public TypeEtude findByCode(String code) {
		if (code == null)
			return null;
		return typeEtudeDao.findByCode(code);
	}

	@Override
	@Transactional
	public int deleteByCode(String code) {
		return typeEtudeDao.deleteByCode(code);
	}

	@Override
	public TypeEtude findByIdOrCode(TypeEtude typeEtude) {
		TypeEtude resultat = null;
		if (typeEtude != null) {
			if (StringUtil.isNotEmpty(typeEtude.getId())) {
				resultat = typeEtudeDao.getOne(typeEtude.getId());
			} else if (StringUtil.isNotEmpty(typeEtude.getCode())) {
				resultat = typeEtudeDao.findByCode(typeEtude.getCode());
			}
		}
		return resultat;
	}

	@Override
	public TypeEtude findById(Long id) {
		if (id == null)
			return null;
		return typeEtudeDao.getOne(id);
	}

	@Override
	public TypeEtude findByIdWithAssociatedList(Long id) {
		return findById(id);
	}

	@Transactional
	public int deleteById(Long id) {
		int res = 0;
		if (typeEtudeDao.findById(id).isPresent()) {
			typeEtudeDao.deleteById(id);
			res = 1;
		}
		return res;
	}

	@Override
	public TypeEtude update(TypeEtude typeEtude) {
		TypeEtude foundedTypeEtude = findById(typeEtude.getId());
		if (foundedTypeEtude == null)
			return null;
		else {
			archivableService.prepare(typeEtude);
			return typeEtudeDao.save(typeEtude);
		}
	}

	private void prepareSave(TypeEtude typeEtude) {
		typeEtude.setDateCreation(new Date());
		if (typeEtude.getArchive() == null)
			typeEtude.setArchive(false);

	}

	@Override
	public TypeEtude save(TypeEtude typeEtude) {
		prepareSave(typeEtude);

		TypeEtude result = null;
		TypeEtude foundedTypeEtude = findByCode(typeEtude.getCode());
		if (foundedTypeEtude == null) {

			TypeEtude savedTypeEtude = typeEtudeDao.save(typeEtude);

			result = savedTypeEtude;
		}

		return result;
	}

	@Override
	public List<TypeEtude> save(List<TypeEtude> typeEtudes) {
		List<TypeEtude> list = new ArrayList<>();
		for (TypeEtude typeEtude : typeEtudes) {
			list.add(save(typeEtude));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(TypeEtude typeEtude) {
		if (typeEtude.getCode() == null)
			return -1;

		TypeEtude foundedTypeEtude = findByCode(typeEtude.getCode());
		if (foundedTypeEtude == null)
			return -1;
		typeEtudeDao.delete(foundedTypeEtude);
		return 1;
	}

	public List<TypeEtude> findByCriteria(TypeEtudeVo typeEtudeVo) {

		String query = "SELECT o FROM TypeEtude o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", typeEtudeVo.getId());
		query += SearchUtil.addConstraint("o", "libelle", "LIKE", typeEtudeVo.getLibelle());
		query += SearchUtil.addConstraint("o", "code", "LIKE", typeEtudeVo.getCode());
		query += SearchUtil.addConstraint("o", "description", "LIKE", typeEtudeVo.getDescription());
		query += SearchUtil.addConstraint("o", "archive", "=", typeEtudeVo.getArchive());
		query += SearchUtil.addConstraintDate("o", "dateArchivage", "=", typeEtudeVo.getDateArchivage());
		query += SearchUtil.addConstraintDate("o", "dateCreation", "=", typeEtudeVo.getDateCreation());
		query += SearchUtil.addConstraintMinMaxDate("o", "dateArchivage", typeEtudeVo.getDateArchivageMin(),
				typeEtudeVo.getDateArchivageMax());
		query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", typeEtudeVo.getDateCreationMin(),
				typeEtudeVo.getDateCreationMax());
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	@Transactional
	public void delete(List<TypeEtude> typeEtudes) {
		if (ListUtil.isNotEmpty(typeEtudes)) {
			typeEtudes.forEach(e -> typeEtudeDao.delete(e));
		}
	}

	@Override
	public void update(List<TypeEtude> typeEtudes) {
		if (ListUtil.isNotEmpty(typeEtudes)) {
			typeEtudes.forEach(e -> typeEtudeDao.save(e));
		}
	}

}

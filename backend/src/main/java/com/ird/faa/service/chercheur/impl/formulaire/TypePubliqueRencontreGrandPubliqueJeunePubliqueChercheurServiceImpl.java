package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePublique;
import com.ird.faa.bean.config.TypePublique;
import com.ird.faa.bean.formulaire.TypePubliqueRencontreGrandPubliqueJeunePublique;
import com.ird.faa.dao.formulaire.TypePubliqueRencontreGrandPubliqueJeunePubliqueDao;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreGrandPubliqueJeunePubliqueChercheurService;
import com.ird.faa.service.chercheur.facade.config.TypePubliqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.TypePubliqueRencontreGrandPubliqueJeunePubliqueChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.TypePubliqueRencontreGrandPubliqueJeunePubliqueVo;

@Service
public class TypePubliqueRencontreGrandPubliqueJeunePubliqueChercheurServiceImpl
		extends AbstractServiceImpl<TypePubliqueRencontreGrandPubliqueJeunePublique>
		implements TypePubliqueRencontreGrandPubliqueJeunePubliqueChercheurService {

	@Autowired
	private TypePubliqueRencontreGrandPubliqueJeunePubliqueDao typePubliqueRencontreGrandPubliqueJeunePubliqueDao;

	@Autowired
	private RencontreGrandPubliqueJeunePubliqueChercheurService rencontreGrandPubliqueJeunePubliqueService;
	@Autowired
	private TypePubliqueChercheurService typePubliqueService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<TypePubliqueRencontreGrandPubliqueJeunePublique> findAll() {
		return typePubliqueRencontreGrandPubliqueJeunePubliqueDao.findAll();
	}

	@Override
	public List<TypePubliqueRencontreGrandPubliqueJeunePublique> findByRencontreGrandPubliqueJeunePubliqueId(Long id) {
		return typePubliqueRencontreGrandPubliqueJeunePubliqueDao.findByRencontreGrandPubliqueJeunePubliqueId(id);
	}

	@Override
	@Transactional
	public int deleteByRencontreGrandPubliqueJeunePubliqueId(Long id) {
		return typePubliqueRencontreGrandPubliqueJeunePubliqueDao.deleteByRencontreGrandPubliqueJeunePubliqueId(id);
	}

	@Override
	public List<TypePubliqueRencontreGrandPubliqueJeunePublique> findByTypePubliqueCode(String code) {
		return typePubliqueRencontreGrandPubliqueJeunePubliqueDao.findByTypePubliqueCode(code);
	}

	@Override
	@Transactional
	public int deleteByTypePubliqueCode(String code) {
		return typePubliqueRencontreGrandPubliqueJeunePubliqueDao.deleteByTypePubliqueCode(code);
	}

	@Override
	public List<TypePubliqueRencontreGrandPubliqueJeunePublique> findByTypePubliqueId(Long id) {
		return typePubliqueRencontreGrandPubliqueJeunePubliqueDao.findByTypePubliqueId(id);
	}

	@Override
	@Transactional
	public int deleteByTypePubliqueId(Long id) {
		return typePubliqueRencontreGrandPubliqueJeunePubliqueDao.deleteByTypePubliqueId(id);
	}

	@Override
	public TypePubliqueRencontreGrandPubliqueJeunePublique findById(Long id) {
		if (id == null)
			return null;
		return typePubliqueRencontreGrandPubliqueJeunePubliqueDao.getOne(id);
	}

	@Override
	public TypePubliqueRencontreGrandPubliqueJeunePublique findByIdWithAssociatedList(Long id) {
		TypePubliqueRencontreGrandPubliqueJeunePublique typePubliqueRencontreGrandPubliqueJeunePublique = findById(id);
		return typePubliqueRencontreGrandPubliqueJeunePublique;
	}

	@Transactional
	public int deleteById(Long id) {
		if (typePubliqueRencontreGrandPubliqueJeunePubliqueDao.findById(id) == null)
			return 0;
		else {
			typePubliqueRencontreGrandPubliqueJeunePubliqueDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public TypePubliqueRencontreGrandPubliqueJeunePublique update(
			TypePubliqueRencontreGrandPubliqueJeunePublique typePubliqueRencontreGrandPubliqueJeunePublique) {
		TypePubliqueRencontreGrandPubliqueJeunePublique foundedTypePubliqueRencontreGrandPubliqueJeunePublique = findById(
				typePubliqueRencontreGrandPubliqueJeunePublique.getId());
		if (foundedTypePubliqueRencontreGrandPubliqueJeunePublique == null)
			return null;
		else {
			return typePubliqueRencontreGrandPubliqueJeunePubliqueDao
					.save(typePubliqueRencontreGrandPubliqueJeunePublique);
		}
	}

	@Override
	public TypePubliqueRencontreGrandPubliqueJeunePublique save(
			TypePubliqueRencontreGrandPubliqueJeunePublique typePubliqueRencontreGrandPubliqueJeunePublique) {

		findRencontreGrandPubliqueJeunePublique(typePubliqueRencontreGrandPubliqueJeunePublique);
		findTypePublique(typePubliqueRencontreGrandPubliqueJeunePublique);

		TypePubliqueRencontreGrandPubliqueJeunePublique savedTypePubliqueRencontreGrandPubliqueJeunePublique = typePubliqueRencontreGrandPubliqueJeunePubliqueDao
				.save(typePubliqueRencontreGrandPubliqueJeunePublique);
		return savedTypePubliqueRencontreGrandPubliqueJeunePublique;
	}

	@Override
	public List<TypePubliqueRencontreGrandPubliqueJeunePublique> save(
			List<TypePubliqueRencontreGrandPubliqueJeunePublique> typePubliqueRencontreGrandPubliqueJeunePubliques) {
		List<TypePubliqueRencontreGrandPubliqueJeunePublique> list = new ArrayList<TypePubliqueRencontreGrandPubliqueJeunePublique>();
		for (TypePubliqueRencontreGrandPubliqueJeunePublique typePubliqueRencontreGrandPubliqueJeunePublique : typePubliqueRencontreGrandPubliqueJeunePubliques) {
			list.add(save(typePubliqueRencontreGrandPubliqueJeunePublique));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(TypePubliqueRencontreGrandPubliqueJeunePublique typePubliqueRencontreGrandPubliqueJeunePublique) {
		if (typePubliqueRencontreGrandPubliqueJeunePublique.getId() == null)
			return -1;
		TypePubliqueRencontreGrandPubliqueJeunePublique foundedTypePubliqueRencontreGrandPubliqueJeunePublique = findById(
				typePubliqueRencontreGrandPubliqueJeunePublique.getId());
		if (foundedTypePubliqueRencontreGrandPubliqueJeunePublique == null)
			return -1;
		typePubliqueRencontreGrandPubliqueJeunePubliqueDao
				.delete(foundedTypePubliqueRencontreGrandPubliqueJeunePublique);
		return 1;
	}

	public List<TypePubliqueRencontreGrandPubliqueJeunePublique> findByCriteria(
			TypePubliqueRencontreGrandPubliqueJeunePubliqueVo typePubliqueRencontreGrandPubliqueJeunePubliqueVo) {

		String query = "SELECT o FROM TypePubliqueRencontreGrandPubliqueJeunePublique o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", typePubliqueRencontreGrandPubliqueJeunePubliqueVo.getId());
		if (typePubliqueRencontreGrandPubliqueJeunePubliqueVo.getRencontreGrandPubliqueJeunePubliqueVo() != null) {
			query += SearchUtil.addConstraint("o", "rencontreGrandPubliqueJeunePublique.id", "=",
					typePubliqueRencontreGrandPubliqueJeunePubliqueVo.getRencontreGrandPubliqueJeunePubliqueVo()
							.getId());
		}

		if (typePubliqueRencontreGrandPubliqueJeunePubliqueVo.getTypePubliqueVo() != null) {
			query += SearchUtil.addConstraint("o", "typePublique.id", "=",
					typePubliqueRencontreGrandPubliqueJeunePubliqueVo.getTypePubliqueVo().getId());
			query += SearchUtil.addConstraint("o", "typePublique.code", "LIKE",
					typePubliqueRencontreGrandPubliqueJeunePubliqueVo.getTypePubliqueVo().getCode());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findRencontreGrandPubliqueJeunePublique(
			TypePubliqueRencontreGrandPubliqueJeunePublique typePubliqueRencontreGrandPubliqueJeunePublique) {
		RencontreGrandPubliqueJeunePublique loadedRencontreGrandPubliqueJeunePublique = null;
		if (typePubliqueRencontreGrandPubliqueJeunePublique.getRencontreGrandPubliqueJeunePublique() != null
				&& typePubliqueRencontreGrandPubliqueJeunePublique.getRencontreGrandPubliqueJeunePublique()
						.getId() != null)
			loadedRencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePubliqueService.findById(
					typePubliqueRencontreGrandPubliqueJeunePublique.getRencontreGrandPubliqueJeunePublique().getId());

		if (loadedRencontreGrandPubliqueJeunePublique == null) {
			return;
		}
		typePubliqueRencontreGrandPubliqueJeunePublique
				.setRencontreGrandPubliqueJeunePublique(loadedRencontreGrandPubliqueJeunePublique);
	}

	private void findTypePublique(
			TypePubliqueRencontreGrandPubliqueJeunePublique typePubliqueRencontreGrandPubliqueJeunePublique) {
		TypePublique loadedTypePublique = typePubliqueService
				.findByIdOrCode(typePubliqueRencontreGrandPubliqueJeunePublique.getTypePublique());

		if (loadedTypePublique == null) {
			return;
		}
		typePubliqueRencontreGrandPubliqueJeunePublique.setTypePublique(loadedTypePublique);
	}

	@Override
	@Transactional
	public void delete(
			List<TypePubliqueRencontreGrandPubliqueJeunePublique> typePubliqueRencontreGrandPubliqueJeunePubliques) {
		if (ListUtil.isNotEmpty(typePubliqueRencontreGrandPubliqueJeunePubliques)) {
			typePubliqueRencontreGrandPubliqueJeunePubliques
					.forEach(e -> typePubliqueRencontreGrandPubliqueJeunePubliqueDao.delete(e));
		}
	}

	@Override
	public void update(
			List<TypePubliqueRencontreGrandPubliqueJeunePublique> typePubliqueRencontreGrandPubliqueJeunePubliques) {
		if (ListUtil.isNotEmpty(typePubliqueRencontreGrandPubliqueJeunePubliques)) {
			typePubliqueRencontreGrandPubliqueJeunePubliques.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<TypePubliqueRencontreGrandPubliqueJeunePublique>> getToBeSavedAndToBeDeleted(
			List<TypePubliqueRencontreGrandPubliqueJeunePublique> oldList,
			List<TypePubliqueRencontreGrandPubliqueJeunePublique> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

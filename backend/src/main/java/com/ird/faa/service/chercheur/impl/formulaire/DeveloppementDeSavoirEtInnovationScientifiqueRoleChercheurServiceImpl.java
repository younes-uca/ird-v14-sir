package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifique;
import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueRole;
import com.ird.faa.bean.config.RoleDeveloppementDeSavoir;
import com.ird.faa.dao.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueRoleDao;
import com.ird.faa.service.chercheur.facade.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueRoleChercheurService;
import com.ird.faa.service.chercheur.facade.config.RoleDeveloppementDeSavoirChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueRoleVo;

@Service
public class DeveloppementDeSavoirEtInnovationScientifiqueRoleChercheurServiceImpl
		extends AbstractServiceImpl<DeveloppementDeSavoirEtInnovationScientifiqueRole>
		implements DeveloppementDeSavoirEtInnovationScientifiqueRoleChercheurService {

	@Autowired
	private DeveloppementDeSavoirEtInnovationScientifiqueRoleDao developpementDeSavoirEtInnovationScientifiqueRoleDao;

	@Autowired
	private DeveloppementDeSavoirEtInnovationScientifiqueChercheurService developpementDeSavoirEtInnovationScientifiqueService;
	@Autowired
	private RoleDeveloppementDeSavoirChercheurService roleDeveloppementDeSavoirService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findAll() {
		return developpementDeSavoirEtInnovationScientifiqueRoleDao.findAll();
	}

	@Override
	public List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByRoleDeveloppementDeSavoirCode(String code) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDao.findByRoleDeveloppementDeSavoirCode(code);
	}

	@Override
	@Transactional
	public int deleteByRoleDeveloppementDeSavoirCode(String code) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDao.deleteByRoleDeveloppementDeSavoirCode(code);
	}

	@Override
	public List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByRoleDeveloppementDeSavoirId(Long id) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDao.findByRoleDeveloppementDeSavoirId(id);
	}

	@Override
	@Transactional
	public int deleteByRoleDeveloppementDeSavoirId(Long id) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDao.deleteByRoleDeveloppementDeSavoirId(id);
	}

	@Override
	public List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByDeveloppementDeSavoirEtInnovationScientifiqueId(
			Long id) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDao
				.findByDeveloppementDeSavoirEtInnovationScientifiqueId(id);
	}

	@Override
	@Transactional
	public int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id) {
		return developpementDeSavoirEtInnovationScientifiqueRoleDao
				.deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(id);
	}

	@Override
	public DeveloppementDeSavoirEtInnovationScientifiqueRole findById(Long id) {
		if (id == null)
			return null;
		return developpementDeSavoirEtInnovationScientifiqueRoleDao.getOne(id);
	}

	@Override
	public DeveloppementDeSavoirEtInnovationScientifiqueRole findByIdWithAssociatedList(Long id) {
		DeveloppementDeSavoirEtInnovationScientifiqueRole developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir = findById(
				id);
		return developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir;
	}

	@Transactional
	public int deleteById(Long id) {
		if (developpementDeSavoirEtInnovationScientifiqueRoleDao.findById(id) == null)
			return 0;
		else {
			developpementDeSavoirEtInnovationScientifiqueRoleDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public DeveloppementDeSavoirEtInnovationScientifiqueRole update(
			DeveloppementDeSavoirEtInnovationScientifiqueRole developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir) {
		DeveloppementDeSavoirEtInnovationScientifiqueRole foundedDeveloppementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir = findById(
				developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir.getId());
		if (foundedDeveloppementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir == null)
			return null;
		else {
			return developpementDeSavoirEtInnovationScientifiqueRoleDao
					.save(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir);
		}
	}

	@Override
	public DeveloppementDeSavoirEtInnovationScientifiqueRole save(
			DeveloppementDeSavoirEtInnovationScientifiqueRole developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir) {

		findRoleDeveloppementDeSavoir(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir);
		findDeveloppementDeSavoirEtInnovationScientifique(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir);

		DeveloppementDeSavoirEtInnovationScientifiqueRole savedDeveloppementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir = developpementDeSavoirEtInnovationScientifiqueRoleDao
				.save(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir);
		return savedDeveloppementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir;
	}

	@Override
	public List<DeveloppementDeSavoirEtInnovationScientifiqueRole> save(
			List<DeveloppementDeSavoirEtInnovationScientifiqueRole> developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirs) {
		List<DeveloppementDeSavoirEtInnovationScientifiqueRole> list = new ArrayList<DeveloppementDeSavoirEtInnovationScientifiqueRole>();
		for (DeveloppementDeSavoirEtInnovationScientifiqueRole developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir : developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirs) {
			list.add(save(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(
			DeveloppementDeSavoirEtInnovationScientifiqueRole developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir) {
		if (developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir.getId() == null)
			return -1;
		DeveloppementDeSavoirEtInnovationScientifiqueRole foundedDeveloppementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir = findById(
				developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir.getId());
		if (foundedDeveloppementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir == null)
			return -1;
		developpementDeSavoirEtInnovationScientifiqueRoleDao
				.delete(foundedDeveloppementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir);
		return 1;
	}

	public List<DeveloppementDeSavoirEtInnovationScientifiqueRole> findByCriteria(
			DeveloppementDeSavoirEtInnovationScientifiqueRoleVo developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo) {

		String query = "SELECT o FROM DeveloppementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=",
				developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo.getId());
		if (developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo.getRoleDeveloppementDeSavoirVo() != null) {
			query += SearchUtil.addConstraint("o", "roleDeveloppementDeSavoir.id", "=",
					developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo.getRoleDeveloppementDeSavoirVo().getId());
			query += SearchUtil.addConstraint("o", "roleDeveloppementDeSavoir.code", "LIKE",
					developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo.getRoleDeveloppementDeSavoirVo().getCode());
		}

		if (developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo
				.getDeveloppementDeSavoirEtInnovationScientifiqueVo() != null) {
			query += SearchUtil.addConstraint("o", "developpementDeSavoirEtInnovationScientifique.id", "=",
					developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirVo
							.getDeveloppementDeSavoirEtInnovationScientifiqueVo().getId());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findRoleDeveloppementDeSavoir(
			DeveloppementDeSavoirEtInnovationScientifiqueRole developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir) {
		RoleDeveloppementDeSavoir loadedRoleDeveloppementDeSavoir = roleDeveloppementDeSavoirService
				.findByIdOrCode(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir.getRoleDeveloppementDeSavoir());

		if (loadedRoleDeveloppementDeSavoir == null) {
			return;
		}
		developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir.setRoleDeveloppementDeSavoir(loadedRoleDeveloppementDeSavoir);
	}

	private void findDeveloppementDeSavoirEtInnovationScientifique(
			DeveloppementDeSavoirEtInnovationScientifiqueRole developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir) {
		DeveloppementDeSavoirEtInnovationScientifique loadedDeveloppementDeSavoirEtInnovationScientifique = null;
		if (developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir
				.getDeveloppementDeSavoirEtInnovationScientifique() != null
				&& developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir
						.getDeveloppementDeSavoirEtInnovationScientifique().getId() != null)
			loadedDeveloppementDeSavoirEtInnovationScientifique = developpementDeSavoirEtInnovationScientifiqueService
					.findById(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir
							.getDeveloppementDeSavoirEtInnovationScientifique().getId());

		if (loadedDeveloppementDeSavoirEtInnovationScientifique == null) {
			return;
		}
		developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoir
				.setDeveloppementDeSavoirEtInnovationScientifique(loadedDeveloppementDeSavoirEtInnovationScientifique);
	}

	@Override
	@Transactional
	public void delete(
			List<DeveloppementDeSavoirEtInnovationScientifiqueRole> developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirs) {
		if (ListUtil.isNotEmpty(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirs)) {
			developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirs
					.forEach(e -> developpementDeSavoirEtInnovationScientifiqueRoleDao.delete(e));
		}
	}

	@Override
	public void update(
			List<DeveloppementDeSavoirEtInnovationScientifiqueRole> developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirs) {
		if (ListUtil.isNotEmpty(developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirs)) {
			developpementDeSavoirEtInnovationScientifiqueRoleDeveloppementDeSavoirs
					.forEach(e -> developpementDeSavoirEtInnovationScientifiqueRoleDao.save(e));
		}
	}

	@Override
	public List<List<DeveloppementDeSavoirEtInnovationScientifiqueRole>> getToBeSavedAndToBeDeleted(
			List<DeveloppementDeSavoirEtInnovationScientifiqueRole> oldList,
			List<DeveloppementDeSavoirEtInnovationScientifiqueRole> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

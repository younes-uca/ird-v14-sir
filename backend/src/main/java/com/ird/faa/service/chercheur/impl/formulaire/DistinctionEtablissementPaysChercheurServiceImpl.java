package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.DistinctionEtablissementPays;
import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.referentiel.Etablissement;
import com.ird.faa.bean.formulaire.Distinction;
import com.ird.faa.dao.formulaire.DistinctionEtablissementPaysDao;
import com.ird.faa.service.chercheur.facade.formulaire.DistinctionEtablissementPaysChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.DistinctionChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EtablissementChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.PaysChercheurService;

import com.ird.faa.ws.rest.provided.vo.DistinctionEtablissementPaysVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class DistinctionEtablissementPaysChercheurServiceImpl extends AbstractServiceImpl<DistinctionEtablissementPays>
		implements DistinctionEtablissementPaysChercheurService {

	@Autowired
	private DistinctionEtablissementPaysDao distinctionEtablissementPaysDao;

	@Autowired
	private DistinctionChercheurService distinctionService;
	@Autowired
	private EtablissementChercheurService etablissementService;
	@Autowired
	private PaysChercheurService paysService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<DistinctionEtablissementPays> findAll() {
		return distinctionEtablissementPaysDao.findAll();
	}

	@Override
	public List<DistinctionEtablissementPays> findByPaysCode(String code) {
		return distinctionEtablissementPaysDao.findByPaysCode(code);
	}

	@Override
	@Transactional
	public int deleteByPaysCode(String code) {
		return distinctionEtablissementPaysDao.deleteByPaysCode(code);
	}

	@Override
	public List<DistinctionEtablissementPays> findByPaysId(Long id) {
		return distinctionEtablissementPaysDao.findByPaysId(id);
	}

	@Override
	@Transactional
	public int deleteByPaysId(Long id) {
		return distinctionEtablissementPaysDao.deleteByPaysId(id);
	}

	@Override
	public List<DistinctionEtablissementPays> findByEtablissementCode(String code) {
		return distinctionEtablissementPaysDao.findByEtablissementCode(code);
	}

	@Override
	@Transactional
	public int deleteByEtablissementCode(String code) {
		return distinctionEtablissementPaysDao.deleteByEtablissementCode(code);
	}

	@Override
	public List<DistinctionEtablissementPays> findByEtablissementId(Long id) {
		return distinctionEtablissementPaysDao.findByEtablissementId(id);
	}

	@Override
	@Transactional
	public int deleteByEtablissementId(Long id) {
		return distinctionEtablissementPaysDao.deleteByEtablissementId(id);
	}

	@Override
	public List<DistinctionEtablissementPays> findByDistinctionId(Long id) {
		return distinctionEtablissementPaysDao.findByDistinctionId(id);
	}

	@Override
	@Transactional
	public int deleteByDistinctionId(Long id) {
		return distinctionEtablissementPaysDao.deleteByDistinctionId(id);
	}

	@Override
	public DistinctionEtablissementPays findById(Long id) {
		if (id == null)
			return null;
		return distinctionEtablissementPaysDao.getOne(id);
	}

	@Override
	public DistinctionEtablissementPays findByIdWithAssociatedList(Long id) {
		DistinctionEtablissementPays distinctionEtablissementPays = findById(id);
		return distinctionEtablissementPays;
	}

	@Transactional
	public int deleteById(Long id) {
		if (distinctionEtablissementPaysDao.findById(id) == null)
			return 0;
		else {
			distinctionEtablissementPaysDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public DistinctionEtablissementPays update(DistinctionEtablissementPays distinctionEtablissementPays) {
		DistinctionEtablissementPays foundedDistinctionEtablissementPays = findById(
				distinctionEtablissementPays.getId());
		if (foundedDistinctionEtablissementPays == null)
			return null;
		else {
			return distinctionEtablissementPaysDao.save(distinctionEtablissementPays);
		}
	}

	@Override
	public DistinctionEtablissementPays save(DistinctionEtablissementPays distinctionEtablissementPays) {

		findPays(distinctionEtablissementPays);
		findEtablissement(distinctionEtablissementPays);
		findDistinction(distinctionEtablissementPays);

		DistinctionEtablissementPays savedDistinctionEtablissementPays = distinctionEtablissementPaysDao
				.save(distinctionEtablissementPays);
		return savedDistinctionEtablissementPays;
	}

	@Override
	public List<DistinctionEtablissementPays> save(List<DistinctionEtablissementPays> distinctionEtablissementPayss) {
		List<DistinctionEtablissementPays> list = new ArrayList<DistinctionEtablissementPays>();
		for (DistinctionEtablissementPays distinctionEtablissementPays : distinctionEtablissementPayss) {
			list.add(save(distinctionEtablissementPays));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(DistinctionEtablissementPays distinctionEtablissementPays) {
		if (distinctionEtablissementPays.getId() == null)
			return -1;
		DistinctionEtablissementPays foundedDistinctionEtablissementPays = findById(
				distinctionEtablissementPays.getId());
		if (foundedDistinctionEtablissementPays == null)
			return -1;
		distinctionEtablissementPaysDao.delete(foundedDistinctionEtablissementPays);
		return 1;
	}

	public List<DistinctionEtablissementPays> findByCriteria(
			DistinctionEtablissementPaysVo distinctionEtablissementPaysVo) {

		String query = "SELECT o FROM DistinctionEtablissementPays o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", distinctionEtablissementPaysVo.getId());
		if (distinctionEtablissementPaysVo.getPaysVo() != null) {
			query += SearchUtil.addConstraint("o", "pays.id", "=", distinctionEtablissementPaysVo.getPaysVo().getId());
			query += SearchUtil.addConstraint("o", "pays.code", "LIKE",
					distinctionEtablissementPaysVo.getPaysVo().getCode());
		}

		if (distinctionEtablissementPaysVo.getEtablissementVo() != null) {
			query += SearchUtil.addConstraint("o", "etablissement.id", "=",
					distinctionEtablissementPaysVo.getEtablissementVo().getId());
			query += SearchUtil.addConstraint("o", "etablissement.code", "LIKE",
					distinctionEtablissementPaysVo.getEtablissementVo().getCode());
		}

		if (distinctionEtablissementPaysVo.getDistinctionVo() != null) {
			query += SearchUtil.addConstraint("o", "distinction.id", "=",
					distinctionEtablissementPaysVo.getDistinctionVo().getId());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findPays(DistinctionEtablissementPays distinctionEtablissementPays) {
		Pays loadedPays = paysService.findByIdOrCode(distinctionEtablissementPays.getPays());

		if (loadedPays == null) {
			return;
		}
		distinctionEtablissementPays.setPays(loadedPays);
	}

	private void findEtablissement(DistinctionEtablissementPays distinctionEtablissementPays) {
		Etablissement loadedEtablissement = etablissementService
				.findByIdOrCode(distinctionEtablissementPays.getEtablissement());

		if (loadedEtablissement == null) {
			return;
		}
		distinctionEtablissementPays.setEtablissement(loadedEtablissement);
	}

	private void findDistinction(DistinctionEtablissementPays distinctionEtablissementPays) {
		Distinction loadedDistinction = null;
		if (distinctionEtablissementPays.getDistinction() != null
				&& distinctionEtablissementPays.getDistinction().getId() != null)
			loadedDistinction = distinctionService.findById(distinctionEtablissementPays.getDistinction().getId());

		if (loadedDistinction == null) {
			return;
		}
		distinctionEtablissementPays.setDistinction(loadedDistinction);
	}

	@Override
	@Transactional
	public void delete(List<DistinctionEtablissementPays> distinctionEtablissementPayss) {
		if (ListUtil.isNotEmpty(distinctionEtablissementPayss)) {
			distinctionEtablissementPayss.forEach(e -> distinctionEtablissementPaysDao.delete(e));
		}
	}

	@Override
	public void update(List<DistinctionEtablissementPays> distinctionEtablissementPayss) {
		if (ListUtil.isNotEmpty(distinctionEtablissementPayss)) {
			distinctionEtablissementPayss.forEach(e -> distinctionEtablissementPaysDao.save(e));
		}
	}

	@Override
	public List<List<DistinctionEtablissementPays>> getToBeSavedAndToBeDeleted(
			List<DistinctionEtablissementPays> oldList, List<DistinctionEtablissementPays> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

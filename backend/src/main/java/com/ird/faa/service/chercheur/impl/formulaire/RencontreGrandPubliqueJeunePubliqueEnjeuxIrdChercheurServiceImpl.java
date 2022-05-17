package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.referentiel.EnjeuxIrd;
import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePublique;
import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePubliqueEnjeuxIrd;
import com.ird.faa.dao.formulaire.RencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao;
import com.ird.faa.service.chercheur.facade.formulaire.EnjeuxIrdChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreGrandPubliqueJeunePubliqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreGrandPubliqueJeunePubliqueEnjeuxIrdChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.RencontreGrandPubliqueJeunePubliqueEnjeuxIrdVo;

@Service
public class RencontreGrandPubliqueJeunePubliqueEnjeuxIrdChercheurServiceImpl
		extends AbstractServiceImpl<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd>
		implements RencontreGrandPubliqueJeunePubliqueEnjeuxIrdChercheurService {

	@Autowired
	private RencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao;

	@Autowired
	private RencontreGrandPubliqueJeunePubliqueChercheurService rencontreGrandPubliqueJeunePubliqueService;
	@Autowired
	private EnjeuxIrdChercheurService enjeuxIrdService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd> findAll() {
		return rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.findAll();
	}

	@Override
	public List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd> findByRencontreGrandPubliqueJeunePubliqueId(Long id) {
		return rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.findByRencontreGrandPubliqueJeunePubliqueId(id);
	}

	@Override
	@Transactional
	public int deleteByRencontreGrandPubliqueJeunePubliqueId(Long id) {
		return rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.deleteByRencontreGrandPubliqueJeunePubliqueId(id);
	}

	@Override
	public List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd> findByEnjeuxIrdCode(String code) {
		return rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.findByEnjeuxIrdCode(code);
	}

	@Override
	@Transactional
	public int deleteByEnjeuxIrdCode(String code) {
		return rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.deleteByEnjeuxIrdCode(code);
	}

	@Override
	public List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd> findByEnjeuxIrdId(Long id) {
		return rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.findByEnjeuxIrdId(id);
	}

	@Override
	@Transactional
	public int deleteByEnjeuxIrdId(Long id) {
		return rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.deleteByEnjeuxIrdId(id);
	}

	@Override
	public RencontreGrandPubliqueJeunePubliqueEnjeuxIrd findById(Long id) {
		if (id == null)
			return null;
		return rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.getOne(id);
	}

	@Override
	public RencontreGrandPubliqueJeunePubliqueEnjeuxIrd findByIdWithAssociatedList(Long id) {
		RencontreGrandPubliqueJeunePubliqueEnjeuxIrd rencontreGrandPubliqueJeunePubliqueEnjeuxIrd = findById(id);
		return rencontreGrandPubliqueJeunePubliqueEnjeuxIrd;
	}

	@Transactional
	public int deleteById(Long id) {
		if (rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.findById(id) == null)
			return 0;
		else {
			rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public RencontreGrandPubliqueJeunePubliqueEnjeuxIrd update(
			RencontreGrandPubliqueJeunePubliqueEnjeuxIrd rencontreGrandPubliqueJeunePubliqueEnjeuxIrd) {
		RencontreGrandPubliqueJeunePubliqueEnjeuxIrd foundedRencontreGrandPubliqueJeunePubliqueEnjeuxIrd = findById(
				rencontreGrandPubliqueJeunePubliqueEnjeuxIrd.getId());
		if (foundedRencontreGrandPubliqueJeunePubliqueEnjeuxIrd == null)
			return null;
		else {
			return rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.save(rencontreGrandPubliqueJeunePubliqueEnjeuxIrd);
		}
	}

	@Override
	public RencontreGrandPubliqueJeunePubliqueEnjeuxIrd save(
			RencontreGrandPubliqueJeunePubliqueEnjeuxIrd rencontreGrandPubliqueJeunePubliqueEnjeuxIrd) {

		findRencontreGrandPubliqueJeunePublique(rencontreGrandPubliqueJeunePubliqueEnjeuxIrd);
		findEnjeuxIrd(rencontreGrandPubliqueJeunePubliqueEnjeuxIrd);

		RencontreGrandPubliqueJeunePubliqueEnjeuxIrd savedRencontreGrandPubliqueJeunePubliqueEnjeuxIrd = rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao
				.save(rencontreGrandPubliqueJeunePubliqueEnjeuxIrd);
		return savedRencontreGrandPubliqueJeunePubliqueEnjeuxIrd;
	}

	@Override
	public List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd> save(
			List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd> rencontreGrandPubliqueJeunePubliqueEnjeuxIrds) {
		List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd> list = new ArrayList<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd>();
		for (RencontreGrandPubliqueJeunePubliqueEnjeuxIrd rencontreGrandPubliqueJeunePubliqueEnjeuxIrd : rencontreGrandPubliqueJeunePubliqueEnjeuxIrds) {
			list.add(save(rencontreGrandPubliqueJeunePubliqueEnjeuxIrd));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(RencontreGrandPubliqueJeunePubliqueEnjeuxIrd rencontreGrandPubliqueJeunePubliqueEnjeuxIrd) {
		if (rencontreGrandPubliqueJeunePubliqueEnjeuxIrd.getId() == null)
			return -1;
		RencontreGrandPubliqueJeunePubliqueEnjeuxIrd foundedRencontreGrandPubliqueJeunePubliqueEnjeuxIrd = findById(
				rencontreGrandPubliqueJeunePubliqueEnjeuxIrd.getId());
		if (foundedRencontreGrandPubliqueJeunePubliqueEnjeuxIrd == null)
			return -1;
		rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.delete(foundedRencontreGrandPubliqueJeunePubliqueEnjeuxIrd);
		return 1;
	}

	public List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd> findByCriteria(
			RencontreGrandPubliqueJeunePubliqueEnjeuxIrdVo rencontreGrandPubliqueJeunePubliqueEnjeuxIrdVo) {

		String query = "SELECT o FROM RencontreGrandPubliqueJeunePubliqueEnjeuxIrd o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", rencontreGrandPubliqueJeunePubliqueEnjeuxIrdVo.getId());
		if (rencontreGrandPubliqueJeunePubliqueEnjeuxIrdVo.getRencontreGrandPubliqueJeunePubliqueVo() != null) {
			query += SearchUtil.addConstraint("o", "rencontreGrandPubliqueJeunePublique.id", "=",
					rencontreGrandPubliqueJeunePubliqueEnjeuxIrdVo.getRencontreGrandPubliqueJeunePubliqueVo().getId());
		}

		if (rencontreGrandPubliqueJeunePubliqueEnjeuxIrdVo.getEnjeuxIrdVo() != null) {
			query += SearchUtil.addConstraint("o", "enjeuxIrd.id", "=",
					rencontreGrandPubliqueJeunePubliqueEnjeuxIrdVo.getEnjeuxIrdVo().getId());
			query += SearchUtil.addConstraint("o", "enjeuxIrd.code", "LIKE",
					rencontreGrandPubliqueJeunePubliqueEnjeuxIrdVo.getEnjeuxIrdVo().getCode());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findRencontreGrandPubliqueJeunePublique(
			RencontreGrandPubliqueJeunePubliqueEnjeuxIrd rencontreGrandPubliqueJeunePubliqueEnjeuxIrd) {
		RencontreGrandPubliqueJeunePublique loadedRencontreGrandPubliqueJeunePublique = null;
		if (rencontreGrandPubliqueJeunePubliqueEnjeuxIrd.getRencontreGrandPubliqueJeunePublique() != null
				&& rencontreGrandPubliqueJeunePubliqueEnjeuxIrd.getRencontreGrandPubliqueJeunePublique()
						.getId() != null)
			loadedRencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePubliqueService.findById(
					rencontreGrandPubliqueJeunePubliqueEnjeuxIrd.getRencontreGrandPubliqueJeunePublique().getId());

		if (loadedRencontreGrandPubliqueJeunePublique == null) {
			return;
		}
		rencontreGrandPubliqueJeunePubliqueEnjeuxIrd
				.setRencontreGrandPubliqueJeunePublique(loadedRencontreGrandPubliqueJeunePublique);
	}

	private void findEnjeuxIrd(
			RencontreGrandPubliqueJeunePubliqueEnjeuxIrd rencontreGrandPubliqueJeunePubliqueEnjeuxIrd) {
		EnjeuxIrd loadedEnjeuxIrd = enjeuxIrdService
				.findByIdOrCode(rencontreGrandPubliqueJeunePubliqueEnjeuxIrd.getEnjeuxIrd());

		if (loadedEnjeuxIrd == null) {
			return;
		}
		rencontreGrandPubliqueJeunePubliqueEnjeuxIrd.setEnjeuxIrd(loadedEnjeuxIrd);
	}

	@Override
	@Transactional
	public void delete(
			List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd> rencontreGrandPubliqueJeunePubliqueEnjeuxIrds) {
		if (ListUtil.isNotEmpty(rencontreGrandPubliqueJeunePubliqueEnjeuxIrds)) {
			rencontreGrandPubliqueJeunePubliqueEnjeuxIrds
					.forEach(e -> rencontreGrandPubliqueJeunePubliqueEnjeuxIrdDao.delete(e));
		}
	}

	@Override
	public void update(
			List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd> rencontreGrandPubliqueJeunePubliqueEnjeuxIrds) {
		if (ListUtil.isNotEmpty(rencontreGrandPubliqueJeunePubliqueEnjeuxIrds)) {
			rencontreGrandPubliqueJeunePubliqueEnjeuxIrds.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd>> getToBeSavedAndToBeDeleted(
			List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd> oldList,
			List<RencontreGrandPubliqueJeunePubliqueEnjeuxIrd> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

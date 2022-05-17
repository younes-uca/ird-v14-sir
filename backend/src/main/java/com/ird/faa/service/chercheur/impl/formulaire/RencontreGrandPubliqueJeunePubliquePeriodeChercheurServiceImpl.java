package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePublique;
import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePubliquePeriode;
import com.ird.faa.dao.formulaire.RencontreGrandPubliqueJeunePubliquePeriodeDao;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreGrandPubliqueJeunePubliqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreGrandPubliqueJeunePubliquePeriodeChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.RencontreGrandPubliqueJeunePubliquePeriodeVo;

@Service
public class RencontreGrandPubliqueJeunePubliquePeriodeChercheurServiceImpl
		extends AbstractServiceImpl<RencontreGrandPubliqueJeunePubliquePeriode>
		implements RencontreGrandPubliqueJeunePubliquePeriodeChercheurService {

	@Autowired
	private RencontreGrandPubliqueJeunePubliquePeriodeDao rencontreGrandPubliqueJeunePubliquePeriodeDao;

	@Autowired
	private RencontreGrandPubliqueJeunePubliqueChercheurService rencontreGrandPubliqueJeunePubliqueService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<RencontreGrandPubliqueJeunePubliquePeriode> findAll() {
		return rencontreGrandPubliqueJeunePubliquePeriodeDao.findAll();
	}

	@Override
	public List<RencontreGrandPubliqueJeunePubliquePeriode> findByRencontreGrandPubliqueJeunePubliqueId(Long id) {
		return rencontreGrandPubliqueJeunePubliquePeriodeDao.findByRencontreGrandPubliqueJeunePubliqueId(id);
	}

	@Override
	@Transactional
	public int deleteByRencontreGrandPubliqueJeunePubliqueId(Long id) {
		return rencontreGrandPubliqueJeunePubliquePeriodeDao.deleteByRencontreGrandPubliqueJeunePubliqueId(id);
	}

	@Override
	public RencontreGrandPubliqueJeunePubliquePeriode findById(Long id) {
		if (id == null)
			return null;
		return rencontreGrandPubliqueJeunePubliquePeriodeDao.getOne(id);
	}

	@Override
	public RencontreGrandPubliqueJeunePubliquePeriode findByIdWithAssociatedList(Long id) {
		RencontreGrandPubliqueJeunePubliquePeriode rencontreGrandPubliqueJeunePubliquePeriode = findById(id);
		return rencontreGrandPubliqueJeunePubliquePeriode;
	}

	@Transactional
	public int deleteById(Long id) {
		if (rencontreGrandPubliqueJeunePubliquePeriodeDao.findById(id) == null)
			return 0;
		else {
			rencontreGrandPubliqueJeunePubliquePeriodeDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public RencontreGrandPubliqueJeunePubliquePeriode update(
			RencontreGrandPubliqueJeunePubliquePeriode rencontreGrandPubliqueJeunePubliquePeriode) {
		RencontreGrandPubliqueJeunePubliquePeriode foundedRencontreGrandPubliqueJeunePubliquePeriode = findById(
				rencontreGrandPubliqueJeunePubliquePeriode.getId());
		if (foundedRencontreGrandPubliqueJeunePubliquePeriode == null)
			return null;
		else {
			return rencontreGrandPubliqueJeunePubliquePeriodeDao.save(rencontreGrandPubliqueJeunePubliquePeriode);
		}
	}

	@Override
	public RencontreGrandPubliqueJeunePubliquePeriode save(
			RencontreGrandPubliqueJeunePubliquePeriode rencontreGrandPubliqueJeunePubliquePeriode) {

		findRencontreGrandPubliqueJeunePublique(rencontreGrandPubliqueJeunePubliquePeriode);

		RencontreGrandPubliqueJeunePubliquePeriode savedRencontreGrandPubliqueJeunePubliquePeriode = rencontreGrandPubliqueJeunePubliquePeriodeDao
				.save(rencontreGrandPubliqueJeunePubliquePeriode);
		return savedRencontreGrandPubliqueJeunePubliquePeriode;
	}

	@Override
	public List<RencontreGrandPubliqueJeunePubliquePeriode> save(
			List<RencontreGrandPubliqueJeunePubliquePeriode> rencontreGrandPubliqueJeunePubliquePeriodes) {
		List<RencontreGrandPubliqueJeunePubliquePeriode> list = new ArrayList<RencontreGrandPubliqueJeunePubliquePeriode>();
		for (RencontreGrandPubliqueJeunePubliquePeriode rencontreGrandPubliqueJeunePubliquePeriode : rencontreGrandPubliqueJeunePubliquePeriodes) {
			list.add(save(rencontreGrandPubliqueJeunePubliquePeriode));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(RencontreGrandPubliqueJeunePubliquePeriode rencontreGrandPubliqueJeunePubliquePeriode) {
		if (rencontreGrandPubliqueJeunePubliquePeriode.getId() == null)
			return -1;
		RencontreGrandPubliqueJeunePubliquePeriode foundedRencontreGrandPubliqueJeunePubliquePeriode = findById(
				rencontreGrandPubliqueJeunePubliquePeriode.getId());
		if (foundedRencontreGrandPubliqueJeunePubliquePeriode == null)
			return -1;
		rencontreGrandPubliqueJeunePubliquePeriodeDao.delete(foundedRencontreGrandPubliqueJeunePubliquePeriode);
		return 1;
	}

	public List<RencontreGrandPubliqueJeunePubliquePeriode> findByCriteria(
			RencontreGrandPubliqueJeunePubliquePeriodeVo rencontreGrandPubliqueJeunePubliquePeriodeVo) {

		String query = "SELECT o FROM RencontreGrandPubliqueJeunePubliquePeriode o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", rencontreGrandPubliqueJeunePubliquePeriodeVo.getId());
		query += SearchUtil.addConstraintDate("o", "dateRencontre", "=",
				rencontreGrandPubliqueJeunePubliquePeriodeVo.getDateRencontre());
		query += SearchUtil.addConstraintMinMaxDate("o", "dateRencontre",
				rencontreGrandPubliqueJeunePubliquePeriodeVo.getDateRencontreMin(),
				rencontreGrandPubliqueJeunePubliquePeriodeVo.getDateRencontreMax());
		if (rencontreGrandPubliqueJeunePubliquePeriodeVo.getRencontreGrandPubliqueJeunePubliqueVo() != null) {
			query += SearchUtil.addConstraint("o", "rencontreGrandPubliqueJeunePublique.id", "=",
					rencontreGrandPubliqueJeunePubliquePeriodeVo.getRencontreGrandPubliqueJeunePubliqueVo().getId());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findRencontreGrandPubliqueJeunePublique(
			RencontreGrandPubliqueJeunePubliquePeriode rencontreGrandPubliqueJeunePubliquePeriode) {
		RencontreGrandPubliqueJeunePublique loadedRencontreGrandPubliqueJeunePublique = null;
		if (rencontreGrandPubliqueJeunePubliquePeriode.getRencontreGrandPubliqueJeunePublique() != null
				&& rencontreGrandPubliqueJeunePubliquePeriode.getRencontreGrandPubliqueJeunePublique().getId() != null)
			loadedRencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePubliqueService.findById(
					rencontreGrandPubliqueJeunePubliquePeriode.getRencontreGrandPubliqueJeunePublique().getId());

		if (loadedRencontreGrandPubliqueJeunePublique == null) {
			return;
		}
		rencontreGrandPubliqueJeunePubliquePeriode
				.setRencontreGrandPubliqueJeunePublique(loadedRencontreGrandPubliqueJeunePublique);
	}

	@Override
	@Transactional
	public void delete(List<RencontreGrandPubliqueJeunePubliquePeriode> rencontreGrandPubliqueJeunePubliquePeriodes) {
		if (ListUtil.isNotEmpty(rencontreGrandPubliqueJeunePubliquePeriodes)) {
			rencontreGrandPubliqueJeunePubliquePeriodes
					.forEach(e -> rencontreGrandPubliqueJeunePubliquePeriodeDao.delete(e));
		}
	}

	@Override
	public void update(List<RencontreGrandPubliqueJeunePubliquePeriode> rencontreGrandPubliqueJeunePubliquePeriodes) {
		if (ListUtil.isNotEmpty(rencontreGrandPubliqueJeunePubliquePeriodes)) {
			rencontreGrandPubliqueJeunePubliquePeriodes.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<RencontreGrandPubliqueJeunePubliquePeriode>> getToBeSavedAndToBeDeleted(
			List<RencontreGrandPubliqueJeunePubliquePeriode> oldList,
			List<RencontreGrandPubliqueJeunePubliquePeriode> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

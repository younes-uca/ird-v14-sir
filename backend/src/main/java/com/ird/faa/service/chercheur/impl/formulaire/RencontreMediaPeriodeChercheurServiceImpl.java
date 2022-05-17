package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.formulaire.RencontreMedia;
import com.ird.faa.bean.formulaire.RencontreMediaPeriode;
import com.ird.faa.dao.formulaire.RencontreMediaPeriodeDao;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreMediaChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreMediaPeriodeChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.RencontreMediaPeriodeVo;

@Service
public class RencontreMediaPeriodeChercheurServiceImpl extends AbstractServiceImpl<RencontreMediaPeriode>
		implements RencontreMediaPeriodeChercheurService {

	@Autowired
	private RencontreMediaPeriodeDao rencontreMediaPeriodeDao;

	@Autowired
	private RencontreMediaChercheurService rencontreMediaService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<RencontreMediaPeriode> findAll() {
		return rencontreMediaPeriodeDao.findAll();
	}

	@Override
	public List<RencontreMediaPeriode> findByRencontreMediaId(Long id) {
		return rencontreMediaPeriodeDao.findByRencontreMediaId(id);
	}

	@Override
	@Transactional
	public int deleteByRencontreMediaId(Long id) {
		return rencontreMediaPeriodeDao.deleteByRencontreMediaId(id);
	}

	@Override
	public RencontreMediaPeriode findById(Long id) {
		if (id == null)
			return null;
		return rencontreMediaPeriodeDao.getOne(id);
	}

	@Override
	public RencontreMediaPeriode findByIdWithAssociatedList(Long id) {
		RencontreMediaPeriode rencontreMediaPeriode = findById(id);
		return rencontreMediaPeriode;
	}

	@Transactional
	public int deleteById(Long id) {
		if (rencontreMediaPeriodeDao.findById(id) == null)
			return 0;
		else {
			rencontreMediaPeriodeDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public RencontreMediaPeriode update(RencontreMediaPeriode rencontreMediaPeriode) {
		RencontreMediaPeriode foundedRencontreMediaPeriode = findById(rencontreMediaPeriode.getId());
		if (foundedRencontreMediaPeriode == null)
			return null;
		else {
			return rencontreMediaPeriodeDao.save(rencontreMediaPeriode);
		}
	}

	@Override
	public RencontreMediaPeriode save(RencontreMediaPeriode rencontreMediaPeriode) {

		findRencontreMedia(rencontreMediaPeriode);

		RencontreMediaPeriode savedRencontreMediaPeriode = rencontreMediaPeriodeDao.save(rencontreMediaPeriode);
		return savedRencontreMediaPeriode;
	}

	@Override
	public List<RencontreMediaPeriode> save(List<RencontreMediaPeriode> rencontreMediaPeriodes) {
		List<RencontreMediaPeriode> list = new ArrayList<RencontreMediaPeriode>();
		for (RencontreMediaPeriode rencontreMediaPeriode : rencontreMediaPeriodes) {
			list.add(save(rencontreMediaPeriode));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(RencontreMediaPeriode rencontreMediaPeriode) {
		if (rencontreMediaPeriode.getId() == null)
			return -1;
		RencontreMediaPeriode foundedRencontreMediaPeriode = findById(rencontreMediaPeriode.getId());
		if (foundedRencontreMediaPeriode == null)
			return -1;
		rencontreMediaPeriodeDao.delete(foundedRencontreMediaPeriode);
		return 1;
	}

	public List<RencontreMediaPeriode> findByCriteria(RencontreMediaPeriodeVo rencontreMediaPeriodeVo) {

		String query = "SELECT o FROM RencontreMediaPeriode o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", rencontreMediaPeriodeVo.getId());
		query += SearchUtil.addConstraintDate("o", "dateRencontre", "=", rencontreMediaPeriodeVo.getDateRencontre());
		query += SearchUtil.addConstraintMinMaxDate("o", "dateRencontre", rencontreMediaPeriodeVo.getDateRencontreMin(),
				rencontreMediaPeriodeVo.getDateRencontreMax());
		if (rencontreMediaPeriodeVo.getRencontreMediaVo() != null) {
			query += SearchUtil.addConstraint("o", "rencontreMedia.id", "=",
					rencontreMediaPeriodeVo.getRencontreMediaVo().getId());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findRencontreMedia(RencontreMediaPeriode rencontreMediaPeriode) {
		RencontreMedia loadedRencontreMedia = null;
		if (rencontreMediaPeriode.getRencontreMedia() != null
				&& rencontreMediaPeriode.getRencontreMedia().getId() != null)
			loadedRencontreMedia = rencontreMediaService.findById(rencontreMediaPeriode.getRencontreMedia().getId());

		if (loadedRencontreMedia == null) {
			return;
		}
		rencontreMediaPeriode.setRencontreMedia(loadedRencontreMedia);
	}

	@Override
	@Transactional
	public void delete(List<RencontreMediaPeriode> rencontreMediaPeriodes) {
		if (ListUtil.isNotEmpty(rencontreMediaPeriodes)) {
			rencontreMediaPeriodes.forEach(e -> rencontreMediaPeriodeDao.delete(e));
		}
	}

	@Override
	public void update(List<RencontreMediaPeriode> rencontreMediaPeriodes) {
		if (ListUtil.isNotEmpty(rencontreMediaPeriodes)) {
			rencontreMediaPeriodes.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<RencontreMediaPeriode>> getToBeSavedAndToBeDeleted(List<RencontreMediaPeriode> oldList,
			List<RencontreMediaPeriode> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.referentiel.OutilPedagogique;
import com.ird.faa.bean.formulaire.OutilPedagogiquePeriode;
import com.ird.faa.dao.formulaire.OutilPedagogiquePeriodeDao;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiquePeriodeChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.OutilPedagogiquePeriodeVo;

@Service
public class OutilPedagogiquePeriodeChercheurServiceImpl extends AbstractServiceImpl<OutilPedagogiquePeriode>
		implements OutilPedagogiquePeriodeChercheurService {

	@Autowired
	private OutilPedagogiquePeriodeDao OutilPedagogiquePeriodeDao;

	@Autowired
	private OutilPedagogiqueChercheurService OutilPedagogiqueService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<OutilPedagogiquePeriode> findAll() {
		return OutilPedagogiquePeriodeDao.findAll();
	}

	@Override
	public List<OutilPedagogiquePeriode> findByOutilPedagogiqueId(Long id) {
		return OutilPedagogiquePeriodeDao.findByOutilPedagogiqueId(id);
	}

	@Override
	@Transactional
	public int deleteByOutilPedagogiqueId(Long id) {
		return OutilPedagogiquePeriodeDao.deleteByOutilPedagogiqueId(id);
	}

	@Override
	public OutilPedagogiquePeriode findById(Long id) {
		if (id == null)
			return null;
		return OutilPedagogiquePeriodeDao.getOne(id);
	}

	@Override
	public OutilPedagogiquePeriode findByIdWithAssociatedList(Long id) {
		OutilPedagogiquePeriode OutilPedagogiquePeriode = findById(id);
		return OutilPedagogiquePeriode;
	}

	@Transactional
	public int deleteById(Long id) {
		if (OutilPedagogiquePeriodeDao.findById(id) == null)
			return 0;
		else {
			OutilPedagogiquePeriodeDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public OutilPedagogiquePeriode update(OutilPedagogiquePeriode OutilPedagogiquePeriode) {
		OutilPedagogiquePeriode foundedOutilPedagogiquePeriode = findById(OutilPedagogiquePeriode.getId());
		if (foundedOutilPedagogiquePeriode == null)
			return null;
		else {
			return OutilPedagogiquePeriodeDao.save(OutilPedagogiquePeriode);
		}
	}

	@Override
	public OutilPedagogiquePeriode save(OutilPedagogiquePeriode OutilPedagogiquePeriode) {

		findOutilPedagogique(OutilPedagogiquePeriode);

		OutilPedagogiquePeriode savedOutilPedagogiquePeriode = OutilPedagogiquePeriodeDao.save(OutilPedagogiquePeriode);
		return savedOutilPedagogiquePeriode;
	}

	@Override
	public List<OutilPedagogiquePeriode> save(List<OutilPedagogiquePeriode> OutilPedagogiquePeriodes) {
		List<OutilPedagogiquePeriode> list = new ArrayList<OutilPedagogiquePeriode>();
		for (OutilPedagogiquePeriode OutilPedagogiquePeriode : OutilPedagogiquePeriodes) {
			list.add(save(OutilPedagogiquePeriode));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(OutilPedagogiquePeriode OutilPedagogiquePeriode) {
		if (OutilPedagogiquePeriode.getId() == null)
			return -1;
		OutilPedagogiquePeriode foundedOutilPedagogiquePeriode = findById(OutilPedagogiquePeriode.getId());
		if (foundedOutilPedagogiquePeriode == null)
			return -1;
		OutilPedagogiquePeriodeDao.delete(foundedOutilPedagogiquePeriode);
		return 1;
	}

	public List<OutilPedagogiquePeriode> findByCriteria(OutilPedagogiquePeriodeVo OutilPedagogiquePeriodeVo) {

		String query = "SELECT o FROM OutilPedagogiquePeriode o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", OutilPedagogiquePeriodeVo.getId());
		query += SearchUtil.addConstraintDate("o", "dateDiffusion", "=", OutilPedagogiquePeriodeVo.getDateDiffusion());
		if (OutilPedagogiquePeriodeVo.getOutilPedagogiqueVo() != null) {
			query += SearchUtil.addConstraint("o", "OutilPedagogique.id", "=",
					OutilPedagogiquePeriodeVo.getOutilPedagogiqueVo().getId());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findOutilPedagogique(OutilPedagogiquePeriode OutilPedagogiquePeriode) {
		OutilPedagogique loadedOutilPedagogique = null;
		if (OutilPedagogiquePeriode.getOutilPedagogique() != null
				&& OutilPedagogiquePeriode.getOutilPedagogique().getId() != null)
			loadedOutilPedagogique = OutilPedagogiqueService
					.findById(OutilPedagogiquePeriode.getOutilPedagogique().getId());

		if (loadedOutilPedagogique == null) {
			return;
		}
		OutilPedagogiquePeriode.setOutilPedagogique(loadedOutilPedagogique);
	}

	@Override
	@Transactional
	public void delete(List<OutilPedagogiquePeriode> OutilPedagogiquePeriodes) {
		if (ListUtil.isNotEmpty(OutilPedagogiquePeriodes)) {
			OutilPedagogiquePeriodes.forEach(e -> OutilPedagogiquePeriodeDao.delete(e));
		}
	}

	@Override
	public void update(List<OutilPedagogiquePeriode> OutilPedagogiquePeriodes) {
		if (ListUtil.isNotEmpty(OutilPedagogiquePeriodes)) {
			OutilPedagogiquePeriodes.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<OutilPedagogiquePeriode>> getToBeSavedAndToBeDeleted(List<OutilPedagogiquePeriode> oldList,
			List<OutilPedagogiquePeriode> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

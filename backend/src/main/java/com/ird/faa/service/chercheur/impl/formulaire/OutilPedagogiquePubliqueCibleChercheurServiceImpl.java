package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.referentiel.OutilPedagogique;
import com.ird.faa.bean.formulaire.OutilPedagogiquePubliqueCible;
import com.ird.faa.bean.formulaire.PublicCible;
import com.ird.faa.dao.formulaire.OutilPedagogiquePubliqueCibleDao;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiquePubliqueCibleChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.PublicCibleChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.OutilPedagogiquePubliqueCibleVo;

@Service
public class OutilPedagogiquePubliqueCibleChercheurServiceImpl extends
		AbstractServiceImpl<OutilPedagogiquePubliqueCible> implements OutilPedagogiquePubliqueCibleChercheurService {

	@Autowired
	private OutilPedagogiquePubliqueCibleDao outilPedagogiquePubliqueCibleDao;

	@Autowired
	private OutilPedagogiqueChercheurService outilPedagogiqueService;
	@Autowired
	private PublicCibleChercheurService publicCibleService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<OutilPedagogiquePubliqueCible> findAll() {
		return outilPedagogiquePubliqueCibleDao.findAll();
	}

	@Override
	public List<OutilPedagogiquePubliqueCible> findByPubliqueCibleCode(String code) {
		return outilPedagogiquePubliqueCibleDao.findByPublicCibleCode(code);
	}

	@Override
	@Transactional
	public int deleteByPubliqueCibleCode(String code) {
		return outilPedagogiquePubliqueCibleDao.deleteByPublicCibleCode(code);
	}

	@Override
	public List<OutilPedagogiquePubliqueCible> findByPubliqueCibleId(Long id) {
		return outilPedagogiquePubliqueCibleDao.findByPublicCibleId(id);
	}

	@Override
	@Transactional
	public int deleteByPubliqueCibleId(Long id) {
		return outilPedagogiquePubliqueCibleDao.deleteByPublicCibleId(id);
	}

	@Override
	public List<OutilPedagogiquePubliqueCible> findByOutilPedagogiqueId(Long id) {
		return outilPedagogiquePubliqueCibleDao.findByOutilPedagogiqueId(id);
	}

	@Override
	@Transactional
	public int deleteByOutilPedagogiqueId(Long id) {
		return outilPedagogiquePubliqueCibleDao.deleteByOutilPedagogiqueId(id);
	}

	@Override
	public OutilPedagogiquePubliqueCible findById(Long id) {
		if (id == null)
			return null;
		return outilPedagogiquePubliqueCibleDao.getOne(id);
	}

	@Override
	public OutilPedagogiquePubliqueCible findByIdWithAssociatedList(Long id) {
		OutilPedagogiquePubliqueCible outilPedagogiquePubliqueCible = findById(id);
		return outilPedagogiquePubliqueCible;
	}

	@Transactional
	public int deleteById(Long id) {
		if (outilPedagogiquePubliqueCibleDao.findById(id) == null)
			return 0;
		else {
			outilPedagogiquePubliqueCibleDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public OutilPedagogiquePubliqueCible update(OutilPedagogiquePubliqueCible outilPedagogiquePubliqueCible) {
		OutilPedagogiquePubliqueCible foundedOutilPedagogiquePubliqueCible = findById(
				outilPedagogiquePubliqueCible.getId());
		if (foundedOutilPedagogiquePubliqueCible == null)
			return null;
		else {
			return outilPedagogiquePubliqueCibleDao.save(outilPedagogiquePubliqueCible);
		}
	}

	@Override
	public OutilPedagogiquePubliqueCible save(OutilPedagogiquePubliqueCible outilPedagogiquePubliqueCible) {

		findPubliqueCible(outilPedagogiquePubliqueCible);
		findOutilPedagogique(outilPedagogiquePubliqueCible);

		OutilPedagogiquePubliqueCible savedOutilPedagogiquePubliqueCible = outilPedagogiquePubliqueCibleDao
				.save(outilPedagogiquePubliqueCible);
		return savedOutilPedagogiquePubliqueCible;
	}

	@Override
	public List<OutilPedagogiquePubliqueCible> save(
			List<OutilPedagogiquePubliqueCible> outilPedagogiquePubliqueCibles) {
		List<OutilPedagogiquePubliqueCible> list = new ArrayList<OutilPedagogiquePubliqueCible>();
		for (OutilPedagogiquePubliqueCible outilPedagogiquePubliqueCible : outilPedagogiquePubliqueCibles) {
			list.add(save(outilPedagogiquePubliqueCible));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(OutilPedagogiquePubliqueCible outilPedagogiquePubliqueCible) {
		if (outilPedagogiquePubliqueCible.getId() == null)
			return -1;
		OutilPedagogiquePubliqueCible foundedOutilPedagogiquePubliqueCible = findById(
				outilPedagogiquePubliqueCible.getId());
		if (foundedOutilPedagogiquePubliqueCible == null)
			return -1;
		outilPedagogiquePubliqueCibleDao.delete(foundedOutilPedagogiquePubliqueCible);
		return 1;
	}

	public List<OutilPedagogiquePubliqueCible> findByCriteria(
			OutilPedagogiquePubliqueCibleVo outilPedagogiquePubliqueCibleVo) {

		String query = "SELECT o FROM OutilPedagogiquePubliqueCible o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", outilPedagogiquePubliqueCibleVo.getId());
		if (outilPedagogiquePubliqueCibleVo.getPublicCibleVo() != null) {
			query += SearchUtil.addConstraint("o", "publiqueCible.id", "=",
					outilPedagogiquePubliqueCibleVo.getPublicCibleVo().getId());
			query += SearchUtil.addConstraint("o", "publiqueCible.code", "LIKE",
					outilPedagogiquePubliqueCibleVo.getPublicCibleVo().getCode());
		}

		if (outilPedagogiquePubliqueCibleVo.getOutilPedagogiqueVo() != null) {
			query += SearchUtil.addConstraint("o", "outilPedagogique.id", "=",
					outilPedagogiquePubliqueCibleVo.getOutilPedagogiqueVo().getId());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findPubliqueCible(OutilPedagogiquePubliqueCible outilPedagogiquePubliqueCible) {
		PublicCible loadedPubliqueCible = publicCibleService
				.findByIdOrCode(outilPedagogiquePubliqueCible.getPubliqueCible());

		if (loadedPubliqueCible == null) {
			return;
		}
		outilPedagogiquePubliqueCible.setPublicCible(loadedPubliqueCible);
	}

	private void findOutilPedagogique(OutilPedagogiquePubliqueCible outilPedagogiquePubliqueCible) {
		OutilPedagogique loadedOutilPedagogique = null;
		if (outilPedagogiquePubliqueCible.getOutilPedagogique() != null
				&& outilPedagogiquePubliqueCible.getOutilPedagogique().getId() != null)
			loadedOutilPedagogique = outilPedagogiqueService
					.findById(outilPedagogiquePubliqueCible.getOutilPedagogique().getId());

		if (loadedOutilPedagogique == null) {
			return;
		}
		outilPedagogiquePubliqueCible.setOutilPedagogique(loadedOutilPedagogique);
	}

	@Override
	@Transactional
	public void delete(List<OutilPedagogiquePubliqueCible> outilPedagogiquePubliqueCibles) {
		if (ListUtil.isNotEmpty(outilPedagogiquePubliqueCibles)) {
			outilPedagogiquePubliqueCibles.forEach(e -> outilPedagogiquePubliqueCibleDao.delete(e));
		}
	}

	@Override
	public void update(List<OutilPedagogiquePubliqueCible> outilPedagogiquePubliqueCibles) {
		if (ListUtil.isNotEmpty(outilPedagogiquePubliqueCibles)) {
			outilPedagogiquePubliqueCibles.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<OutilPedagogiquePubliqueCible>> getToBeSavedAndToBeDeleted(
			List<OutilPedagogiquePubliqueCible> oldList, List<OutilPedagogiquePubliqueCible> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

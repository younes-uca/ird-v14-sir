package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.referentiel.OutilPedagogique;
import com.ird.faa.bean.formulaire.OutilPedagogiquePaysConception;
import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.dao.formulaire.OutilPedagogiquePaysConceptionDao;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiquePaysConceptionChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.PaysChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.OutilPedagogiquePaysConceptionVo;

@Service
public class OutilPedagogiquePaysConceptionChercheurServiceImpl extends
		AbstractServiceImpl<OutilPedagogiquePaysConception> implements OutilPedagogiquePaysConceptionChercheurService {

	@Autowired
	private OutilPedagogiquePaysConceptionDao outilPedagogiquePaysConceptionDao;

	@Autowired
	private OutilPedagogiqueChercheurService outilPedagogiqueService;
	@Autowired
	private PaysChercheurService paysService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<OutilPedagogiquePaysConception> findAll() {
		return outilPedagogiquePaysConceptionDao.findAll();
	}

	@Override
	public List<OutilPedagogiquePaysConception> findByPaysCode(String code) {
		return outilPedagogiquePaysConceptionDao.findByPaysCode(code);
	}

	@Override
	@Transactional
	public int deleteByPaysCode(String code) {
		return outilPedagogiquePaysConceptionDao.deleteByPaysCode(code);
	}

	@Override
	public List<OutilPedagogiquePaysConception> findByPaysId(Long id) {
		return outilPedagogiquePaysConceptionDao.findByPaysId(id);
	}

	@Override
	@Transactional
	public int deleteByPaysId(Long id) {
		return outilPedagogiquePaysConceptionDao.deleteByPaysId(id);
	}

	@Override
	public List<OutilPedagogiquePaysConception> findByOutilPedagogiqueId(Long id) {
		return outilPedagogiquePaysConceptionDao.findByOutilPedagogiqueId(id);
	}

	@Override
	@Transactional
	public int deleteByOutilPedagogiqueId(Long id) {
		return outilPedagogiquePaysConceptionDao.deleteByOutilPedagogiqueId(id);
	}

	@Override
	public OutilPedagogiquePaysConception findById(Long id) {
		if (id == null)
			return null;
		return outilPedagogiquePaysConceptionDao.getOne(id);
	}

	@Override
	public OutilPedagogiquePaysConception findByIdWithAssociatedList(Long id) {
		OutilPedagogiquePaysConception outilPedagogiquePaysConception = findById(id);
		return outilPedagogiquePaysConception;
	}

	@Transactional
	public int deleteById(Long id) {
		if (outilPedagogiquePaysConceptionDao.findById(id) == null)
			return 0;
		else {
			outilPedagogiquePaysConceptionDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public OutilPedagogiquePaysConception update(OutilPedagogiquePaysConception outilPedagogiquePaysConception) {
		OutilPedagogiquePaysConception foundedOutilPedagogiquePaysConception = findById(
				outilPedagogiquePaysConception.getId());
		if (foundedOutilPedagogiquePaysConception == null)
			return null;
		else {
			return outilPedagogiquePaysConceptionDao.save(outilPedagogiquePaysConception);
		}
	}

	@Override
	public OutilPedagogiquePaysConception save(OutilPedagogiquePaysConception outilPedagogiquePaysConception) {

		findPays(outilPedagogiquePaysConception);
		findOutilPedagogique(outilPedagogiquePaysConception);

		OutilPedagogiquePaysConception savedOutilPedagogiquePaysConception = outilPedagogiquePaysConceptionDao
				.save(outilPedagogiquePaysConception);
		return savedOutilPedagogiquePaysConception;
	}

	@Override
	public List<OutilPedagogiquePaysConception> save(
			List<OutilPedagogiquePaysConception> outilPedagogiquePaysConceptions) {
		List<OutilPedagogiquePaysConception> list = new ArrayList<OutilPedagogiquePaysConception>();
		for (OutilPedagogiquePaysConception outilPedagogiquePaysConception : outilPedagogiquePaysConceptions) {
			list.add(save(outilPedagogiquePaysConception));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(OutilPedagogiquePaysConception outilPedagogiquePaysConception) {
		if (outilPedagogiquePaysConception.getId() == null)
			return -1;
		OutilPedagogiquePaysConception foundedOutilPedagogiquePaysConception = findById(
				outilPedagogiquePaysConception.getId());
		if (foundedOutilPedagogiquePaysConception == null)
			return -1;
		outilPedagogiquePaysConceptionDao.delete(foundedOutilPedagogiquePaysConception);
		return 1;
	}

	public List<OutilPedagogiquePaysConception> findByCriteria(
			OutilPedagogiquePaysConceptionVo outilPedagogiquePaysConceptionVo) {

		String query = "SELECT o FROM OutilPedagogiquePaysConception o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", outilPedagogiquePaysConceptionVo.getId());
		if (outilPedagogiquePaysConceptionVo.getPaysVo() != null) {
			query += SearchUtil.addConstraint("o", "pays.id", "=",
					outilPedagogiquePaysConceptionVo.getPaysVo().getId());
			query += SearchUtil.addConstraint("o", "pays.code", "LIKE",
					outilPedagogiquePaysConceptionVo.getPaysVo().getCode());
		}

		if (outilPedagogiquePaysConceptionVo.getOutilPedagogiqueVo() != null) {
			query += SearchUtil.addConstraint("o", "outilPedagogique.id", "=",
					outilPedagogiquePaysConceptionVo.getOutilPedagogiqueVo().getId());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findPays(OutilPedagogiquePaysConception outilPedagogiquePaysConception) {
		Pays loadedPays = paysService.findByIdOrCode(outilPedagogiquePaysConception.getPays());

		if (loadedPays == null) {
			return;
		}
		outilPedagogiquePaysConception.setPays(loadedPays);
	}

	private void findOutilPedagogique(OutilPedagogiquePaysConception outilPedagogiquePaysConception) {
		OutilPedagogique loadedOutilPedagogique = null;
		if (outilPedagogiquePaysConception.getOutilPedagogique() != null
				&& outilPedagogiquePaysConception.getOutilPedagogique().getId() != null)
			loadedOutilPedagogique = outilPedagogiqueService
					.findById(outilPedagogiquePaysConception.getOutilPedagogique().getId());

		if (loadedOutilPedagogique == null) {
			return;
		}
		outilPedagogiquePaysConception.setOutilPedagogique(loadedOutilPedagogique);
	}

	@Override
	@Transactional
	public void delete(List<OutilPedagogiquePaysConception> outilPedagogiquePaysConceptions) {
		if (ListUtil.isNotEmpty(outilPedagogiquePaysConceptions)) {
			outilPedagogiquePaysConceptions.forEach(e -> outilPedagogiquePaysConceptionDao.delete(e));
		}
	}

	@Override
	public void update(List<OutilPedagogiquePaysConception> outilPedagogiquePaysConceptions) {
		if (ListUtil.isNotEmpty(outilPedagogiquePaysConceptions)) {
			outilPedagogiquePaysConceptions.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<OutilPedagogiquePaysConception>> getToBeSavedAndToBeDeleted(
			List<OutilPedagogiquePaysConception> oldList, List<OutilPedagogiquePaysConception> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.referentiel.OutilPedagogique;
import com.ird.faa.bean.formulaire.OutilPedagogiquePaysDiffusion;
import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.dao.formulaire.OutilPedagogiquePaysDiffusionDao;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiquePaysDiffusionChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.PaysChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.OutilPedagogiquePaysDiffusionVo;

@Service
public class OutilPedagogiquePaysDiffusionChercheurServiceImpl extends
		AbstractServiceImpl<OutilPedagogiquePaysDiffusion> implements OutilPedagogiquePaysDiffusionChercheurService {

	@Autowired
	private OutilPedagogiquePaysDiffusionDao outilPedagogiquePaysDiffusionDao;

	@Autowired
	private OutilPedagogiqueChercheurService outilPedagogiqueService;
	@Autowired
	private PaysChercheurService paysService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<OutilPedagogiquePaysDiffusion> findAll() {
		return outilPedagogiquePaysDiffusionDao.findAll();
	}

	@Override
	public List<OutilPedagogiquePaysDiffusion> findByPaysCode(String code) {
		return outilPedagogiquePaysDiffusionDao.findByPaysCode(code);
	}

	@Override
	@Transactional
	public int deleteByPaysCode(String code) {
		return outilPedagogiquePaysDiffusionDao.deleteByPaysCode(code);
	}

	@Override
	public List<OutilPedagogiquePaysDiffusion> findByPaysId(Long id) {
		return outilPedagogiquePaysDiffusionDao.findByPaysId(id);
	}

	@Override
	@Transactional
	public int deleteByPaysId(Long id) {
		return outilPedagogiquePaysDiffusionDao.deleteByPaysId(id);
	}

	@Override
	public List<OutilPedagogiquePaysDiffusion> findByOutilPedagogiqueId(Long id) {
		return outilPedagogiquePaysDiffusionDao.findByOutilPedagogiqueId(id);
	}

	@Override
	@Transactional
	public int deleteByOutilPedagogiqueId(Long id) {
		return outilPedagogiquePaysDiffusionDao.deleteByOutilPedagogiqueId(id);
	}

	@Override
	public OutilPedagogiquePaysDiffusion findById(Long id) {
		if (id == null)
			return null;
		return outilPedagogiquePaysDiffusionDao.getOne(id);
	}

	@Override
	public OutilPedagogiquePaysDiffusion findByIdWithAssociatedList(Long id) {
		OutilPedagogiquePaysDiffusion outilPedagogiquePaysDiffusion = findById(id);
		return outilPedagogiquePaysDiffusion;
	}

	@Transactional
	public int deleteById(Long id) {
		if (outilPedagogiquePaysDiffusionDao.findById(id) == null)
			return 0;
		else {
			outilPedagogiquePaysDiffusionDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public OutilPedagogiquePaysDiffusion update(OutilPedagogiquePaysDiffusion outilPedagogiquePaysDiffusion) {
		OutilPedagogiquePaysDiffusion foundedOutilPedagogiquePaysDiffusion = findById(
				outilPedagogiquePaysDiffusion.getId());
		if (foundedOutilPedagogiquePaysDiffusion == null)
			return null;
		else {
			return outilPedagogiquePaysDiffusionDao.save(outilPedagogiquePaysDiffusion);
		}
	}

	@Override
	public OutilPedagogiquePaysDiffusion save(OutilPedagogiquePaysDiffusion outilPedagogiquePaysDiffusion) {

		findPays(outilPedagogiquePaysDiffusion);
		findOutilPedagogique(outilPedagogiquePaysDiffusion);

		OutilPedagogiquePaysDiffusion savedOutilPedagogiquePaysDiffusion = outilPedagogiquePaysDiffusionDao
				.save(outilPedagogiquePaysDiffusion);
		return savedOutilPedagogiquePaysDiffusion;
	}

	@Override
	public List<OutilPedagogiquePaysDiffusion> save(
			List<OutilPedagogiquePaysDiffusion> outilPedagogiquePaysDiffusions) {
		List<OutilPedagogiquePaysDiffusion> list = new ArrayList<OutilPedagogiquePaysDiffusion>();
		for (OutilPedagogiquePaysDiffusion outilPedagogiquePaysDiffusion : outilPedagogiquePaysDiffusions) {
			list.add(save(outilPedagogiquePaysDiffusion));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(OutilPedagogiquePaysDiffusion outilPedagogiquePaysDiffusion) {
		if (outilPedagogiquePaysDiffusion.getId() == null)
			return -1;
		OutilPedagogiquePaysDiffusion foundedOutilPedagogiquePaysDiffusion = findById(
				outilPedagogiquePaysDiffusion.getId());
		if (foundedOutilPedagogiquePaysDiffusion == null)
			return -1;
		outilPedagogiquePaysDiffusionDao.delete(foundedOutilPedagogiquePaysDiffusion);
		return 1;
	}

	public List<OutilPedagogiquePaysDiffusion> findByCriteria(
			OutilPedagogiquePaysDiffusionVo outilPedagogiquePaysDiffusionVo) {

		String query = "SELECT o FROM OutilPedagogiquePaysDiffusion o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", outilPedagogiquePaysDiffusionVo.getId());
		if (outilPedagogiquePaysDiffusionVo.getPaysVo() != null) {
			query += SearchUtil.addConstraint("o", "pays.id", "=", outilPedagogiquePaysDiffusionVo.getPaysVo().getId());
			query += SearchUtil.addConstraint("o", "pays.code", "LIKE",
					outilPedagogiquePaysDiffusionVo.getPaysVo().getCode());
		}

		if (outilPedagogiquePaysDiffusionVo.getOutilPedagogiqueVo() != null) {
			query += SearchUtil.addConstraint("o", "outilPedagogique.id", "=",
					outilPedagogiquePaysDiffusionVo.getOutilPedagogiqueVo().getId());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findPays(OutilPedagogiquePaysDiffusion outilPedagogiquePaysDiffusion) {
		Pays loadedPays = paysService.findByIdOrCode(outilPedagogiquePaysDiffusion.getPays());

		if (loadedPays == null) {
			return;
		}
		outilPedagogiquePaysDiffusion.setPays(loadedPays);
	}

	private void findOutilPedagogique(OutilPedagogiquePaysDiffusion outilPedagogiquePaysDiffusion) {
		OutilPedagogique loadedOutilPedagogique = null;
		if (outilPedagogiquePaysDiffusion.getOutilPedagogique() != null
				&& outilPedagogiquePaysDiffusion.getOutilPedagogique().getId() != null)
			loadedOutilPedagogique = outilPedagogiqueService
					.findById(outilPedagogiquePaysDiffusion.getOutilPedagogique().getId());

		if (loadedOutilPedagogique == null) {
			return;
		}
		outilPedagogiquePaysDiffusion.setOutilPedagogique(loadedOutilPedagogique);
	}

	@Override
	@Transactional
	public void delete(List<OutilPedagogiquePaysDiffusion> outilPedagogiquePaysDiffusions) {
		if (ListUtil.isNotEmpty(outilPedagogiquePaysDiffusions)) {
			outilPedagogiquePaysDiffusions.forEach(e -> outilPedagogiquePaysDiffusionDao.delete(e));
		}
	}

	@Override
	public void update(List<OutilPedagogiquePaysDiffusion> outilPedagogiquePaysDiffusions) {
		if (ListUtil.isNotEmpty(outilPedagogiquePaysDiffusions)) {
			outilPedagogiquePaysDiffusions.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<OutilPedagogiquePaysDiffusion>> getToBeSavedAndToBeDeleted(
			List<OutilPedagogiquePaysDiffusion> oldList, List<OutilPedagogiquePaysDiffusion> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

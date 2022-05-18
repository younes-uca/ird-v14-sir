package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.formulaire.DisciplineScientifique;
import com.ird.faa.bean.referentiel.OutilPedagogique;
import com.ird.faa.bean.formulaire.OutilPedagogiqueDisciplineScientifique;
import com.ird.faa.dao.formulaire.OutilPedagogiqueDisciplineScientifiqueDao;
import com.ird.faa.service.chercheur.facade.formulaire.DisciplineScientifiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueDisciplineScientifiqueChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.OutilPedagogiqueDisciplineScientifiqueVo;

@Service
public class OutilPedagogiqueDisciplineScientifiqueChercheurServiceImpl
		extends AbstractServiceImpl<OutilPedagogiqueDisciplineScientifique>
		implements OutilPedagogiqueDisciplineScientifiqueChercheurService {

	@Autowired
	private OutilPedagogiqueDisciplineScientifiqueDao outilPedagogiqueDisciplineScientifiqueDao;

	@Autowired
	private OutilPedagogiqueChercheurService outilPedagogiqueService;
	@Autowired
	private DisciplineScientifiqueChercheurService disciplineScientifiqueService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<OutilPedagogiqueDisciplineScientifique> findAll() {
		return outilPedagogiqueDisciplineScientifiqueDao.findAll();
	}

	@Override
	public List<OutilPedagogiqueDisciplineScientifique> findByOutilPedagogiqueId(Long id) {
		return outilPedagogiqueDisciplineScientifiqueDao.findByOutilPedagogiqueId(id);
	}

	@Override
	@Transactional
	public int deleteByOutilPedagogiqueId(Long id) {
		return outilPedagogiqueDisciplineScientifiqueDao.deleteByOutilPedagogiqueId(id);
	}

	@Override
	public List<OutilPedagogiqueDisciplineScientifique> findByDisciplineScientifiqueCode(String code) {
		return outilPedagogiqueDisciplineScientifiqueDao.findByDisciplineScientifiqueCode(code);
	}

	@Override
	@Transactional
	public int deleteByDisciplineScientifiqueCode(String code) {
		return outilPedagogiqueDisciplineScientifiqueDao.deleteByDisciplineScientifiqueCode(code);
	}

	@Override
	public List<OutilPedagogiqueDisciplineScientifique> findByDisciplineScientifiqueId(Long id) {
		return outilPedagogiqueDisciplineScientifiqueDao.findByDisciplineScientifiqueId(id);
	}

	@Override
	@Transactional
	public int deleteByDisciplineScientifiqueId(Long id) {
		return outilPedagogiqueDisciplineScientifiqueDao.deleteByDisciplineScientifiqueId(id);
	}

	@Override
	public OutilPedagogiqueDisciplineScientifique findById(Long id) {
		if (id == null)
			return null;
		return outilPedagogiqueDisciplineScientifiqueDao.getOne(id);
	}

	@Override
	public OutilPedagogiqueDisciplineScientifique findByIdWithAssociatedList(Long id) {
		OutilPedagogiqueDisciplineScientifique outilPedagogiqueDisciplineScientifique = findById(id);
		return outilPedagogiqueDisciplineScientifique;
	}

	@Transactional
	public int deleteById(Long id) {
		if (outilPedagogiqueDisciplineScientifiqueDao.findById(id) == null)
			return 0;
		else {
			outilPedagogiqueDisciplineScientifiqueDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public OutilPedagogiqueDisciplineScientifique update(
			OutilPedagogiqueDisciplineScientifique outilPedagogiqueDisciplineScientifique) {
		OutilPedagogiqueDisciplineScientifique foundedOutilPedagogiqueDisciplineScientifique = findById(
				outilPedagogiqueDisciplineScientifique.getId());
		if (foundedOutilPedagogiqueDisciplineScientifique == null)
			return null;
		else {
			return outilPedagogiqueDisciplineScientifiqueDao.save(outilPedagogiqueDisciplineScientifique);
		}
	}

	@Override
	public OutilPedagogiqueDisciplineScientifique save(
			OutilPedagogiqueDisciplineScientifique outilPedagogiqueDisciplineScientifique) {

		findOutilPedagogique(outilPedagogiqueDisciplineScientifique);
		findDisciplineScientifique(outilPedagogiqueDisciplineScientifique);

		OutilPedagogiqueDisciplineScientifique savedOutilPedagogiqueDisciplineScientifique = outilPedagogiqueDisciplineScientifiqueDao
				.save(outilPedagogiqueDisciplineScientifique);
		return savedOutilPedagogiqueDisciplineScientifique;
	}

	@Override
	public List<OutilPedagogiqueDisciplineScientifique> save(
			List<OutilPedagogiqueDisciplineScientifique> outilPedagogiqueDisciplineScientifiques) {
		List<OutilPedagogiqueDisciplineScientifique> list = new ArrayList<OutilPedagogiqueDisciplineScientifique>();
		for (OutilPedagogiqueDisciplineScientifique outilPedagogiqueDisciplineScientifique : outilPedagogiqueDisciplineScientifiques) {
			list.add(save(outilPedagogiqueDisciplineScientifique));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(OutilPedagogiqueDisciplineScientifique outilPedagogiqueDisciplineScientifique) {
		if (outilPedagogiqueDisciplineScientifique.getId() == null)
			return -1;
		OutilPedagogiqueDisciplineScientifique foundedOutilPedagogiqueDisciplineScientifique = findById(
				outilPedagogiqueDisciplineScientifique.getId());
		if (foundedOutilPedagogiqueDisciplineScientifique == null)
			return -1;
		outilPedagogiqueDisciplineScientifiqueDao.delete(foundedOutilPedagogiqueDisciplineScientifique);
		return 1;
	}

	public List<OutilPedagogiqueDisciplineScientifique> findByCriteria(
			OutilPedagogiqueDisciplineScientifiqueVo outilPedagogiqueDisciplineScientifiqueVo) {

		String query = "SELECT o FROM OutilPedagogiqueDisciplineScientifique o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", outilPedagogiqueDisciplineScientifiqueVo.getId());
		if (outilPedagogiqueDisciplineScientifiqueVo.getOutilPedagogiqueVo() != null) {
			query += SearchUtil.addConstraint("o", "outilPedagogique.id", "=",
					outilPedagogiqueDisciplineScientifiqueVo.getOutilPedagogiqueVo().getId());
		}

		if (outilPedagogiqueDisciplineScientifiqueVo.getDisciplineScientifiqueVo() != null) {
			query += SearchUtil.addConstraint("o", "disciplineScientifique.id", "=",
					outilPedagogiqueDisciplineScientifiqueVo.getDisciplineScientifiqueVo().getId());
			query += SearchUtil.addConstraint("o", "disciplineScientifique.code", "LIKE",
					outilPedagogiqueDisciplineScientifiqueVo.getDisciplineScientifiqueVo().getCode());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findOutilPedagogique(OutilPedagogiqueDisciplineScientifique outilPedagogiqueDisciplineScientifique) {
		OutilPedagogique loadedOutilPedagogique = null;
		if (outilPedagogiqueDisciplineScientifique.getOutilPedagogique() != null
				&& outilPedagogiqueDisciplineScientifique.getOutilPedagogique().getId() != null)
			loadedOutilPedagogique = outilPedagogiqueService
					.findById(outilPedagogiqueDisciplineScientifique.getOutilPedagogique().getId());

		if (loadedOutilPedagogique == null) {
			return;
		}
		outilPedagogiqueDisciplineScientifique.setOutilPedagogique(loadedOutilPedagogique);
	}

	private void findDisciplineScientifique(
			OutilPedagogiqueDisciplineScientifique outilPedagogiqueDisciplineScientifique) {
		DisciplineScientifique loadedDisciplineScientifique = disciplineScientifiqueService
				.findByIdOrCode(outilPedagogiqueDisciplineScientifique.getDisciplineScientifique());

		if (loadedDisciplineScientifique == null) {
			return;
		}
		outilPedagogiqueDisciplineScientifique.setDisciplineScientifique(loadedDisciplineScientifique);
	}

	@Override
	@Transactional
	public void delete(List<OutilPedagogiqueDisciplineScientifique> outilPedagogiqueDisciplineScientifiques) {
		if (ListUtil.isNotEmpty(outilPedagogiqueDisciplineScientifiques)) {
			outilPedagogiqueDisciplineScientifiques.forEach(e -> outilPedagogiqueDisciplineScientifiqueDao.delete(e));
		}
	}

	@Override
	public void update(List<OutilPedagogiqueDisciplineScientifique> outilPedagogiqueDisciplineScientifiques) {
		if (ListUtil.isNotEmpty(outilPedagogiqueDisciplineScientifiques)) {
			outilPedagogiqueDisciplineScientifiques.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<OutilPedagogiqueDisciplineScientifique>> getToBeSavedAndToBeDeleted(
			List<OutilPedagogiqueDisciplineScientifique> oldList,
			List<OutilPedagogiqueDisciplineScientifique> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

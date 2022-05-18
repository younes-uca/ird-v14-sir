package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.formulaire.PaysRencontreGrandPubliqueJeunePublique;
import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePublique;
import com.ird.faa.dao.formulaire.PaysRencontreGrandPubliqueJeunePubliqueDao;
import com.ird.faa.service.chercheur.facade.formulaire.PaysChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.PaysRencontreGrandPubliqueJeunePubliqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreGrandPubliqueJeunePubliqueChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.PaysRencontreGrandPubliqueJeunePubliqueVo;

@Service
public class PaysRencontreGrandPubliqueJeunePubliqueChercheurServiceImpl
		extends AbstractServiceImpl<PaysRencontreGrandPubliqueJeunePublique>
		implements PaysRencontreGrandPubliqueJeunePubliqueChercheurService {

	@Autowired
	private PaysRencontreGrandPubliqueJeunePubliqueDao paysRencontreGrandPubliqueJeunePubliqueDao;

	@Autowired
	private RencontreGrandPubliqueJeunePubliqueChercheurService rencontreGrandPubliqueJeunePubliqueService;
	@Autowired
	private PaysChercheurService paysService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<PaysRencontreGrandPubliqueJeunePublique> findAll() {
		return paysRencontreGrandPubliqueJeunePubliqueDao.findAll();
	}

	@Override
	public List<PaysRencontreGrandPubliqueJeunePublique> findByPaysCode(String code) {
		return paysRencontreGrandPubliqueJeunePubliqueDao.findByPaysCode(code);
	}

	@Override
	@Transactional
	public int deleteByPaysCode(String code) {
		return paysRencontreGrandPubliqueJeunePubliqueDao.deleteByPaysCode(code);
	}

	@Override
	public List<PaysRencontreGrandPubliqueJeunePublique> findByPaysId(Long id) {
		return paysRencontreGrandPubliqueJeunePubliqueDao.findByPaysId(id);
	}

	@Override
	@Transactional
	public int deleteByPaysId(Long id) {
		return paysRencontreGrandPubliqueJeunePubliqueDao.deleteByPaysId(id);
	}

	@Override
	public List<PaysRencontreGrandPubliqueJeunePublique> findByRencontreGrandPubliqueJeunePubliqueId(Long id) {
		return paysRencontreGrandPubliqueJeunePubliqueDao.findByRencontreGrandPubliqueJeunePubliqueId(id);
	}

	@Override
	@Transactional
	public int deleteByRencontreGrandPubliqueJeunePubliqueId(Long id) {
		return paysRencontreGrandPubliqueJeunePubliqueDao.deleteByRencontreGrandPubliqueJeunePubliqueId(id);
	}

	@Override
	public PaysRencontreGrandPubliqueJeunePublique findById(Long id) {
		if (id == null)
			return null;
		return paysRencontreGrandPubliqueJeunePubliqueDao.getOne(id);
	}

	@Override
	public PaysRencontreGrandPubliqueJeunePublique findByIdWithAssociatedList(Long id) {
		PaysRencontreGrandPubliqueJeunePublique paysRencontreGrandPubliqueJeunePublique = findById(id);
		return paysRencontreGrandPubliqueJeunePublique;
	}

	@Transactional
	public int deleteById(Long id) {
		if (paysRencontreGrandPubliqueJeunePubliqueDao.findById(id) == null)
			return 0;
		else {
			paysRencontreGrandPubliqueJeunePubliqueDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public PaysRencontreGrandPubliqueJeunePublique update(
			PaysRencontreGrandPubliqueJeunePublique paysRencontreGrandPubliqueJeunePublique) {
		PaysRencontreGrandPubliqueJeunePublique foundedPaysRencontreGrandPubliqueJeunePublique = findById(
				paysRencontreGrandPubliqueJeunePublique.getId());
		if (foundedPaysRencontreGrandPubliqueJeunePublique == null)
			return null;
		else {
			return paysRencontreGrandPubliqueJeunePubliqueDao.save(paysRencontreGrandPubliqueJeunePublique);
		}
	}

	@Override
	public PaysRencontreGrandPubliqueJeunePublique save(
			PaysRencontreGrandPubliqueJeunePublique paysRencontreGrandPubliqueJeunePublique) {

		findPays(paysRencontreGrandPubliqueJeunePublique);
		findRencontreGrandPubliqueJeunePublique(paysRencontreGrandPubliqueJeunePublique);

		PaysRencontreGrandPubliqueJeunePublique savedPaysRencontreGrandPubliqueJeunePublique = paysRencontreGrandPubliqueJeunePubliqueDao
				.save(paysRencontreGrandPubliqueJeunePublique);
		return savedPaysRencontreGrandPubliqueJeunePublique;
	}

	@Override
	public List<PaysRencontreGrandPubliqueJeunePublique> save(
			List<PaysRencontreGrandPubliqueJeunePublique> paysRencontreGrandPubliqueJeunePubliques) {
		List<PaysRencontreGrandPubliqueJeunePublique> list = new ArrayList<PaysRencontreGrandPubliqueJeunePublique>();
		for (PaysRencontreGrandPubliqueJeunePublique paysRencontreGrandPubliqueJeunePublique : paysRencontreGrandPubliqueJeunePubliques) {
			list.add(save(paysRencontreGrandPubliqueJeunePublique));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(PaysRencontreGrandPubliqueJeunePublique paysRencontreGrandPubliqueJeunePublique) {
		if (paysRencontreGrandPubliqueJeunePublique.getId() == null)
			return -1;
		PaysRencontreGrandPubliqueJeunePublique foundedPaysRencontreGrandPubliqueJeunePublique = findById(
				paysRencontreGrandPubliqueJeunePublique.getId());
		if (foundedPaysRencontreGrandPubliqueJeunePublique == null)
			return -1;
		paysRencontreGrandPubliqueJeunePubliqueDao.delete(foundedPaysRencontreGrandPubliqueJeunePublique);
		return 1;
	}

	public List<PaysRencontreGrandPubliqueJeunePublique> findByCriteria(
			PaysRencontreGrandPubliqueJeunePubliqueVo paysRencontreGrandPubliqueJeunePubliqueVo) {

		String query = "SELECT o FROM PaysRencontreGrandPubliqueJeunePublique o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", paysRencontreGrandPubliqueJeunePubliqueVo.getId());
		if (paysRencontreGrandPubliqueJeunePubliqueVo.getPaysVo() != null) {
			query += SearchUtil.addConstraint("o", "pays.id", "=",
					paysRencontreGrandPubliqueJeunePubliqueVo.getPaysVo().getId());
			query += SearchUtil.addConstraint("o", "pays.code", "LIKE",
					paysRencontreGrandPubliqueJeunePubliqueVo.getPaysVo().getCode());
		}

		if (paysRencontreGrandPubliqueJeunePubliqueVo.getRencontreGrandPubliqueJeunePubliqueVo() != null) {
			query += SearchUtil.addConstraint("o", "rencontreGrandPubliqueJeunePublique.id", "=",
					paysRencontreGrandPubliqueJeunePubliqueVo.getRencontreGrandPubliqueJeunePubliqueVo().getId());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findPays(PaysRencontreGrandPubliqueJeunePublique paysRencontreGrandPubliqueJeunePublique) {
		Pays loadedPays = paysService.findByIdOrCode(paysRencontreGrandPubliqueJeunePublique.getPays());

		if (loadedPays == null) {
			return;
		}
		paysRencontreGrandPubliqueJeunePublique.setPays(loadedPays);
	}

	private void findRencontreGrandPubliqueJeunePublique(
			PaysRencontreGrandPubliqueJeunePublique paysRencontreGrandPubliqueJeunePublique) {
		RencontreGrandPubliqueJeunePublique loadedRencontreGrandPubliqueJeunePublique = null;
		if (paysRencontreGrandPubliqueJeunePublique.getRencontreGrandPubliqueJeunePublique() != null
				&& paysRencontreGrandPubliqueJeunePublique.getRencontreGrandPubliqueJeunePublique().getId() != null)
			loadedRencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePubliqueService
					.findById(paysRencontreGrandPubliqueJeunePublique.getRencontreGrandPubliqueJeunePublique().getId());

		if (loadedRencontreGrandPubliqueJeunePublique == null) {
			return;
		}
		paysRencontreGrandPubliqueJeunePublique
				.setRencontreGrandPubliqueJeunePublique(loadedRencontreGrandPubliqueJeunePublique);
	}

	@Override
	@Transactional
	public void delete(List<PaysRencontreGrandPubliqueJeunePublique> paysRencontreGrandPubliqueJeunePubliques) {
		if (ListUtil.isNotEmpty(paysRencontreGrandPubliqueJeunePubliques)) {
			paysRencontreGrandPubliqueJeunePubliques.forEach(e -> paysRencontreGrandPubliqueJeunePubliqueDao.delete(e));
		}
	}

	@Override
	public void update(List<PaysRencontreGrandPubliqueJeunePublique> paysRencontreGrandPubliqueJeunePubliques) {
		if (ListUtil.isNotEmpty(paysRencontreGrandPubliqueJeunePubliques)) {
			paysRencontreGrandPubliqueJeunePubliques.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<PaysRencontreGrandPubliqueJeunePublique>> getToBeSavedAndToBeDeleted(
			List<PaysRencontreGrandPubliqueJeunePublique> oldList,
			List<PaysRencontreGrandPubliqueJeunePublique> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

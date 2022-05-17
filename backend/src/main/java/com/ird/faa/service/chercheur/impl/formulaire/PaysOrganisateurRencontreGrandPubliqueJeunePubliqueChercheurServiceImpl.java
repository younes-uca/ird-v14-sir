package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.formulaire.PaysOrganisateurRencontreGrandPubliqueJeunePublique;
import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePublique;
import com.ird.faa.dao.formulaire.PaysOrganisateurRencontreGrandPubliqueJeunePubliqueDao;
import com.ird.faa.service.chercheur.facade.formulaire.PaysChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.PaysOrganisateurRencontreGrandPubliqueJeunePubliqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreGrandPubliqueJeunePubliqueChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.PaysOrganisateurRencontreGrandPubliqueJeunePubliqueVo;

@Service
public class PaysOrganisateurRencontreGrandPubliqueJeunePubliqueChercheurServiceImpl
		extends AbstractServiceImpl<PaysOrganisateurRencontreGrandPubliqueJeunePublique>
		implements PaysOrganisateurRencontreGrandPubliqueJeunePubliqueChercheurService {

	@Autowired
	private PaysOrganisateurRencontreGrandPubliqueJeunePubliqueDao paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao;

	@Autowired
	private RencontreGrandPubliqueJeunePubliqueChercheurService rencontreGrandPubliqueJeunePubliqueService;
	@Autowired
	private PaysChercheurService paysService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<PaysOrganisateurRencontreGrandPubliqueJeunePublique> findAll() {
		return paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao.findAll();
	}

	@Override
	public List<PaysOrganisateurRencontreGrandPubliqueJeunePublique> findByRencontreGrandPubliqueJeunePubliqueId(
			Long id) {
		return paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao.findByRencontreGrandPubliqueJeunePubliqueId(id);
	}

	@Override
	@Transactional
	public int deleteByRencontreGrandPubliqueJeunePubliqueId(Long id) {
		return paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao.deleteByRencontreGrandPubliqueJeunePubliqueId(id);
	}

	@Override
	public List<PaysOrganisateurRencontreGrandPubliqueJeunePublique> findByPaysCode(String code) {
		return paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao.findByPaysCode(code);
	}

	@Override
	@Transactional
	public int deleteByPaysCode(String code) {
		return paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao.deleteByPaysCode(code);
	}

	@Override
	public List<PaysOrganisateurRencontreGrandPubliqueJeunePublique> findByPaysId(Long id) {
		return paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao.findByPaysId(id);
	}

	@Override
	@Transactional
	public int deleteByPaysId(Long id) {
		return paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao.deleteByPaysId(id);
	}

	@Override
	public PaysOrganisateurRencontreGrandPubliqueJeunePublique findById(Long id) {
		if (id == null)
			return null;
		return paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao.getOne(id);
	}

	@Override
	public PaysOrganisateurRencontreGrandPubliqueJeunePublique findByIdWithAssociatedList(Long id) {
		PaysOrganisateurRencontreGrandPubliqueJeunePublique paysOrganisateurRencontreGrandPubliqueJeunePublique = findById(
				id);
		return paysOrganisateurRencontreGrandPubliqueJeunePublique;
	}

	@Transactional
	public int deleteById(Long id) {
		if (paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao.findById(id) == null)
			return 0;
		else {
			paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public PaysOrganisateurRencontreGrandPubliqueJeunePublique update(
			PaysOrganisateurRencontreGrandPubliqueJeunePublique paysOrganisateurRencontreGrandPubliqueJeunePublique) {
		PaysOrganisateurRencontreGrandPubliqueJeunePublique foundedPaysOrganisateurRencontreGrandPubliqueJeunePublique = findById(
				paysOrganisateurRencontreGrandPubliqueJeunePublique.getId());
		if (foundedPaysOrganisateurRencontreGrandPubliqueJeunePublique == null)
			return null;
		else {
			return paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao
					.save(paysOrganisateurRencontreGrandPubliqueJeunePublique);
		}
	}

	@Override
	public PaysOrganisateurRencontreGrandPubliqueJeunePublique save(
			PaysOrganisateurRencontreGrandPubliqueJeunePublique paysOrganisateurRencontreGrandPubliqueJeunePublique) {

		findRencontreGrandPubliqueJeunePublique(paysOrganisateurRencontreGrandPubliqueJeunePublique);
		findPays(paysOrganisateurRencontreGrandPubliqueJeunePublique);

		PaysOrganisateurRencontreGrandPubliqueJeunePublique savedPaysOrganisateurRencontreGrandPubliqueJeunePublique = paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao
				.save(paysOrganisateurRencontreGrandPubliqueJeunePublique);
		return savedPaysOrganisateurRencontreGrandPubliqueJeunePublique;
	}

	@Override
	public List<PaysOrganisateurRencontreGrandPubliqueJeunePublique> save(
			List<PaysOrganisateurRencontreGrandPubliqueJeunePublique> paysOrganisateurRencontreGrandPubliqueJeunePubliques) {
		List<PaysOrganisateurRencontreGrandPubliqueJeunePublique> list = new ArrayList<PaysOrganisateurRencontreGrandPubliqueJeunePublique>();
		for (PaysOrganisateurRencontreGrandPubliqueJeunePublique paysOrganisateurRencontreGrandPubliqueJeunePublique : paysOrganisateurRencontreGrandPubliqueJeunePubliques) {
			list.add(save(paysOrganisateurRencontreGrandPubliqueJeunePublique));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(
			PaysOrganisateurRencontreGrandPubliqueJeunePublique paysOrganisateurRencontreGrandPubliqueJeunePublique) {
		if (paysOrganisateurRencontreGrandPubliqueJeunePublique.getId() == null)
			return -1;
		PaysOrganisateurRencontreGrandPubliqueJeunePublique foundedPaysOrganisateurRencontreGrandPubliqueJeunePublique = findById(
				paysOrganisateurRencontreGrandPubliqueJeunePublique.getId());
		if (foundedPaysOrganisateurRencontreGrandPubliqueJeunePublique == null)
			return -1;
		paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao
				.delete(foundedPaysOrganisateurRencontreGrandPubliqueJeunePublique);
		return 1;
	}

	public List<PaysOrganisateurRencontreGrandPubliqueJeunePublique> findByCriteria(
			PaysOrganisateurRencontreGrandPubliqueJeunePubliqueVo paysOrganisateurRencontreGrandPubliqueJeunePubliqueVo) {

		String query = "SELECT o FROM PaysOrganisateurRencontreGrandPubliqueJeunePublique o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=",
				paysOrganisateurRencontreGrandPubliqueJeunePubliqueVo.getId());
		if (paysOrganisateurRencontreGrandPubliqueJeunePubliqueVo.getRencontreGrandPubliqueJeunePubliqueVo() != null) {
			query += SearchUtil.addConstraint("o", "rencontreGrandPubliqueJeunePublique.id", "=",
					paysOrganisateurRencontreGrandPubliqueJeunePubliqueVo.getRencontreGrandPubliqueJeunePubliqueVo()
							.getId());
		}

		if (paysOrganisateurRencontreGrandPubliqueJeunePubliqueVo.getPaysVo() != null) {
			query += SearchUtil.addConstraint("o", "pays.id", "=",
					paysOrganisateurRencontreGrandPubliqueJeunePubliqueVo.getPaysVo().getId());
			query += SearchUtil.addConstraint("o", "pays.code", "LIKE",
					paysOrganisateurRencontreGrandPubliqueJeunePubliqueVo.getPaysVo().getCode());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findRencontreGrandPubliqueJeunePublique(
			PaysOrganisateurRencontreGrandPubliqueJeunePublique paysOrganisateurRencontreGrandPubliqueJeunePublique) {
		RencontreGrandPubliqueJeunePublique loadedRencontreGrandPubliqueJeunePublique = null;
		if (paysOrganisateurRencontreGrandPubliqueJeunePublique.getRencontreGrandPubliqueJeunePublique() != null
				&& paysOrganisateurRencontreGrandPubliqueJeunePublique.getRencontreGrandPubliqueJeunePublique()
						.getId() != null)
			loadedRencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePubliqueService
					.findById(paysOrganisateurRencontreGrandPubliqueJeunePublique
							.getRencontreGrandPubliqueJeunePublique().getId());

		if (loadedRencontreGrandPubliqueJeunePublique == null) {
			return;
		}
		paysOrganisateurRencontreGrandPubliqueJeunePublique
				.setRencontreGrandPubliqueJeunePublique(loadedRencontreGrandPubliqueJeunePublique);
	}

	private void findPays(
			PaysOrganisateurRencontreGrandPubliqueJeunePublique paysOrganisateurRencontreGrandPubliqueJeunePublique) {
		Pays loadedPays = paysService.findByIdOrCode(paysOrganisateurRencontreGrandPubliqueJeunePublique.getPays());

		if (loadedPays == null) {
			return;
		}
		paysOrganisateurRencontreGrandPubliqueJeunePublique.setPays(loadedPays);
	}

	@Override
	@Transactional
	public void delete(
			List<PaysOrganisateurRencontreGrandPubliqueJeunePublique> paysOrganisateurRencontreGrandPubliqueJeunePubliques) {
		if (ListUtil.isNotEmpty(paysOrganisateurRencontreGrandPubliqueJeunePubliques)) {
			paysOrganisateurRencontreGrandPubliqueJeunePubliques
					.forEach(e -> paysOrganisateurRencontreGrandPubliqueJeunePubliqueDao.delete(e));
		}
	}

	@Override
	public void update(
			List<PaysOrganisateurRencontreGrandPubliqueJeunePublique> paysOrganisateurRencontreGrandPubliqueJeunePubliques) {
		if (ListUtil.isNotEmpty(paysOrganisateurRencontreGrandPubliqueJeunePubliques)) {
			paysOrganisateurRencontreGrandPubliqueJeunePubliques.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<PaysOrganisateurRencontreGrandPubliqueJeunePublique>> getToBeSavedAndToBeDeleted(
			List<PaysOrganisateurRencontreGrandPubliqueJeunePublique> oldList,
			List<PaysOrganisateurRencontreGrandPubliqueJeunePublique> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

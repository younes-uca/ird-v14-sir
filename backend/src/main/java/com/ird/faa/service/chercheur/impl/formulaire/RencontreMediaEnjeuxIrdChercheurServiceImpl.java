package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.referentiel.EnjeuxIrd;
import com.ird.faa.bean.formulaire.RencontreMedia;
import com.ird.faa.bean.formulaire.RencontreMediaEnjeuxIrd;
import com.ird.faa.dao.formulaire.RencontreMediaEnjeuxIrdDao;
import com.ird.faa.service.chercheur.facade.formulaire.EnjeuxIrdChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreMediaChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreMediaEnjeuxIrdChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.RencontreMediaEnjeuxIrdVo;

@Service
public class RencontreMediaEnjeuxIrdChercheurServiceImpl extends AbstractServiceImpl<RencontreMediaEnjeuxIrd>
		implements RencontreMediaEnjeuxIrdChercheurService {

	@Autowired
	private RencontreMediaEnjeuxIrdDao rencontreMediaEnjeuxIrdDao;

	@Autowired
	private RencontreMediaChercheurService rencontreMediaService;
	@Autowired
	private EnjeuxIrdChercheurService enjeuxIrdService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<RencontreMediaEnjeuxIrd> findAll() {
		return rencontreMediaEnjeuxIrdDao.findAll();
	}

	@Override
	public List<RencontreMediaEnjeuxIrd> findByRencontreMediaId(Long id) {
		return rencontreMediaEnjeuxIrdDao.findByRencontreMediaId(id);
	}

	@Override
	@Transactional
	public int deleteByRencontreMediaId(Long id) {
		return rencontreMediaEnjeuxIrdDao.deleteByRencontreMediaId(id);
	}

	@Override
	public List<RencontreMediaEnjeuxIrd> findByEnjeuxIrdCode(String code) {
		return rencontreMediaEnjeuxIrdDao.findByEnjeuxIrdCode(code);
	}

	@Override
	@Transactional
	public int deleteByEnjeuxIrdCode(String code) {
		return rencontreMediaEnjeuxIrdDao.deleteByEnjeuxIrdCode(code);
	}

	@Override
	public List<RencontreMediaEnjeuxIrd> findByEnjeuxIrdId(Long id) {
		return rencontreMediaEnjeuxIrdDao.findByEnjeuxIrdId(id);
	}

	@Override
	@Transactional
	public int deleteByEnjeuxIrdId(Long id) {
		return rencontreMediaEnjeuxIrdDao.deleteByEnjeuxIrdId(id);
	}

	@Override
	public RencontreMediaEnjeuxIrd findById(Long id) {
		if (id == null)
			return null;
		return rencontreMediaEnjeuxIrdDao.getOne(id);
	}

	@Override
	public RencontreMediaEnjeuxIrd findByIdWithAssociatedList(Long id) {
		RencontreMediaEnjeuxIrd rencontreMediaEnjeuxIrd = findById(id);
		return rencontreMediaEnjeuxIrd;
	}

	@Transactional
	public int deleteById(Long id) {
		if (rencontreMediaEnjeuxIrdDao.findById(id) == null)
			return 0;
		else {
			rencontreMediaEnjeuxIrdDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public RencontreMediaEnjeuxIrd update(RencontreMediaEnjeuxIrd rencontreMediaEnjeuxIrd) {
		RencontreMediaEnjeuxIrd foundedRencontreMediaEnjeuxIrd = findById(rencontreMediaEnjeuxIrd.getId());
		if (foundedRencontreMediaEnjeuxIrd == null)
			return null;
		else {
			return rencontreMediaEnjeuxIrdDao.save(rencontreMediaEnjeuxIrd);
		}
	}

	@Override
	public RencontreMediaEnjeuxIrd save(RencontreMediaEnjeuxIrd rencontreMediaEnjeuxIrd) {

		findRencontreMedia(rencontreMediaEnjeuxIrd);
		findEnjeuxIrd(rencontreMediaEnjeuxIrd);

		RencontreMediaEnjeuxIrd savedRencontreMediaEnjeuxIrd = rencontreMediaEnjeuxIrdDao.save(rencontreMediaEnjeuxIrd);
		return savedRencontreMediaEnjeuxIrd;
	}

	@Override
	public List<RencontreMediaEnjeuxIrd> save(List<RencontreMediaEnjeuxIrd> rencontreMediaEnjeuxIrds) {
		List<RencontreMediaEnjeuxIrd> list = new ArrayList<RencontreMediaEnjeuxIrd>();
		for (RencontreMediaEnjeuxIrd rencontreMediaEnjeuxIrd : rencontreMediaEnjeuxIrds) {
			list.add(save(rencontreMediaEnjeuxIrd));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(RencontreMediaEnjeuxIrd rencontreMediaEnjeuxIrd) {
		if (rencontreMediaEnjeuxIrd.getId() == null)
			return -1;
		RencontreMediaEnjeuxIrd foundedRencontreMediaEnjeuxIrd = findById(rencontreMediaEnjeuxIrd.getId());
		if (foundedRencontreMediaEnjeuxIrd == null)
			return -1;
		rencontreMediaEnjeuxIrdDao.delete(foundedRencontreMediaEnjeuxIrd);
		return 1;
	}

	public List<RencontreMediaEnjeuxIrd> findByCriteria(RencontreMediaEnjeuxIrdVo rencontreMediaEnjeuxIrdVo) {

		String query = "SELECT o FROM RencontreMediaEnjeuxIrd o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", rencontreMediaEnjeuxIrdVo.getId());
		if (rencontreMediaEnjeuxIrdVo.getRencontreMediaVo() != null) {
			query += SearchUtil.addConstraint("o", "rencontreMedia.id", "=",
					rencontreMediaEnjeuxIrdVo.getRencontreMediaVo().getId());
		}

		if (rencontreMediaEnjeuxIrdVo.getEnjeuxIrdVo() != null) {
			query += SearchUtil.addConstraint("o", "enjeuxIrd.id", "=",
					rencontreMediaEnjeuxIrdVo.getEnjeuxIrdVo().getId());
			query += SearchUtil.addConstraint("o", "enjeuxIrd.code", "LIKE",
					rencontreMediaEnjeuxIrdVo.getEnjeuxIrdVo().getCode());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findRencontreMedia(RencontreMediaEnjeuxIrd rencontreMediaEnjeuxIrd) {
		RencontreMedia loadedRencontreMedia = null;
		if (rencontreMediaEnjeuxIrd.getRencontreMedia() != null
				&& rencontreMediaEnjeuxIrd.getRencontreMedia().getId() != null)
			loadedRencontreMedia = rencontreMediaService.findById(rencontreMediaEnjeuxIrd.getRencontreMedia().getId());

		if (loadedRencontreMedia == null) {
			return;
		}
		rencontreMediaEnjeuxIrd.setRencontreMedia(loadedRencontreMedia);
	}

	private void findEnjeuxIrd(RencontreMediaEnjeuxIrd rencontreMediaEnjeuxIrd) {
		EnjeuxIrd loadedEnjeuxIrd = enjeuxIrdService.findByIdOrCode(rencontreMediaEnjeuxIrd.getEnjeuxIrd());

		if (loadedEnjeuxIrd == null) {
			return;
		}
		rencontreMediaEnjeuxIrd.setEnjeuxIrd(loadedEnjeuxIrd);
	}

	@Override
	@Transactional
	public void delete(List<RencontreMediaEnjeuxIrd> rencontreMediaEnjeuxIrds) {
		if (ListUtil.isNotEmpty(rencontreMediaEnjeuxIrds)) {
			rencontreMediaEnjeuxIrds.forEach(e -> rencontreMediaEnjeuxIrdDao.delete(e));
		}
	}

	@Override
	public void update(List<RencontreMediaEnjeuxIrd> rencontreMediaEnjeuxIrds) {
		if (ListUtil.isNotEmpty(rencontreMediaEnjeuxIrds)) {
			rencontreMediaEnjeuxIrds.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<RencontreMediaEnjeuxIrd>> getToBeSavedAndToBeDeleted(List<RencontreMediaEnjeuxIrd> oldList,
			List<RencontreMediaEnjeuxIrd> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

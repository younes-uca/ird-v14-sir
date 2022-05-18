package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.referentiel.OutilPedagogique;
import com.ird.faa.bean.formulaire.OutilPedagogiqueTypeInstrumentIrd;
import com.ird.faa.bean.referentiel.TypeInstrumentIrd;
import com.ird.faa.dao.formulaire.OutilPedagogiqueTypeInstrumentIrdDao;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueTypeInstrumentIrdChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.TypeInstrumentIrdChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.OutilPedagogiqueTypeInstrumentIrdVo;

@Service
public class OutilPedagogiqueTypeInstrumentIrdChercheurServiceImpl
		extends AbstractServiceImpl<OutilPedagogiqueTypeInstrumentIrd>
		implements OutilPedagogiqueTypeInstrumentIrdChercheurService {

	@Autowired
	private OutilPedagogiqueTypeInstrumentIrdDao outilPedagogiqueTypeInstrumentIrdDao;

	@Autowired
	private OutilPedagogiqueChercheurService outilPedagogiqueService;
	@Autowired
	private TypeInstrumentIrdChercheurService TypeInstrumentIrdService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<OutilPedagogiqueTypeInstrumentIrd> findAll() {
		return outilPedagogiqueTypeInstrumentIrdDao.findAll();
	}

	@Override
	public List<OutilPedagogiqueTypeInstrumentIrd> findByTypeInstrumentIrdCode(String code) {
		return outilPedagogiqueTypeInstrumentIrdDao.findByTypeInstrumentIrdCode(code);
	}

	@Override
	@Transactional
	public int deleteByTypeInstrumentIrdCode(String code) {
		return outilPedagogiqueTypeInstrumentIrdDao.deleteByTypeInstrumentIrdCode(code);
	}

	@Override
	public List<OutilPedagogiqueTypeInstrumentIrd> findByTypeInstrumentIrdId(Long id) {
		return outilPedagogiqueTypeInstrumentIrdDao.findByTypeInstrumentIrdId(id);
	}

	@Override
	@Transactional
	public int deleteByTypeInstrumentIrdId(Long id) {
		return outilPedagogiqueTypeInstrumentIrdDao.deleteByTypeInstrumentIrdId(id);
	}

	@Override
	public List<OutilPedagogiqueTypeInstrumentIrd> findByOutilPedagogiqueId(Long id) {
		return outilPedagogiqueTypeInstrumentIrdDao.findByOutilPedagogiqueId(id);
	}

	@Override
	@Transactional
	public int deleteByOutilPedagogiqueId(Long id) {
		return outilPedagogiqueTypeInstrumentIrdDao.deleteByOutilPedagogiqueId(id);
	}

	@Override
	public OutilPedagogiqueTypeInstrumentIrd findById(Long id) {
		if (id == null)
			return null;
		return outilPedagogiqueTypeInstrumentIrdDao.getOne(id);
	}

	@Override
	public OutilPedagogiqueTypeInstrumentIrd findByIdWithAssociatedList(Long id) {
		OutilPedagogiqueTypeInstrumentIrd outilPedagogiqueTypeInstrumentIrd = findById(id);
		return outilPedagogiqueTypeInstrumentIrd;
	}

	@Transactional
	public int deleteById(Long id) {
		if (outilPedagogiqueTypeInstrumentIrdDao.findById(id) == null)
			return 0;
		else {
			outilPedagogiqueTypeInstrumentIrdDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public OutilPedagogiqueTypeInstrumentIrd update(
			OutilPedagogiqueTypeInstrumentIrd outilPedagogiqueTypeInstrumentIrd) {
		OutilPedagogiqueTypeInstrumentIrd foundedOutilPedagogiqueTypeInstrumentIrd = findById(
				outilPedagogiqueTypeInstrumentIrd.getId());
		if (foundedOutilPedagogiqueTypeInstrumentIrd == null)
			return null;
		else {
			return outilPedagogiqueTypeInstrumentIrdDao.save(outilPedagogiqueTypeInstrumentIrd);
		}
	}

	@Override
	public OutilPedagogiqueTypeInstrumentIrd save(OutilPedagogiqueTypeInstrumentIrd outilPedagogiqueTypeInstrumentIrd) {

		findTypeInstrumentIrd(outilPedagogiqueTypeInstrumentIrd);
		findOutilPedagogique(outilPedagogiqueTypeInstrumentIrd);

		OutilPedagogiqueTypeInstrumentIrd savedOutilPedagogiqueTypeInstrumentIrd = outilPedagogiqueTypeInstrumentIrdDao
				.save(outilPedagogiqueTypeInstrumentIrd);
		return savedOutilPedagogiqueTypeInstrumentIrd;
	}

	@Override
	public List<OutilPedagogiqueTypeInstrumentIrd> save(
			List<OutilPedagogiqueTypeInstrumentIrd> outilPedagogiqueTypeInstrumentIrds) {
		List<OutilPedagogiqueTypeInstrumentIrd> list = new ArrayList<OutilPedagogiqueTypeInstrumentIrd>();
		for (OutilPedagogiqueTypeInstrumentIrd outilPedagogiqueTypeInstrumentIrd : outilPedagogiqueTypeInstrumentIrds) {
			list.add(save(outilPedagogiqueTypeInstrumentIrd));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(OutilPedagogiqueTypeInstrumentIrd outilPedagogiqueTypeInstrumentIrd) {
		if (outilPedagogiqueTypeInstrumentIrd.getId() == null)
			return -1;
		OutilPedagogiqueTypeInstrumentIrd foundedOutilPedagogiqueTypeInstrumentIrd = findById(
				outilPedagogiqueTypeInstrumentIrd.getId());
		if (foundedOutilPedagogiqueTypeInstrumentIrd == null)
			return -1;
		outilPedagogiqueTypeInstrumentIrdDao.delete(foundedOutilPedagogiqueTypeInstrumentIrd);
		return 1;
	}

	public List<OutilPedagogiqueTypeInstrumentIrd> findByCriteria(
			OutilPedagogiqueTypeInstrumentIrdVo outilPedagogiqueTypeInstrumentIrdVo) {

		String query = "SELECT o FROM OutilPedagogiqueTypeInstrumentIrd o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", outilPedagogiqueTypeInstrumentIrdVo.getId());
		if (outilPedagogiqueTypeInstrumentIrdVo.getTypeInstrumentIrdVo() != null) {
			query += SearchUtil.addConstraint("o", "TypeInstrumentIrd.id", "=",
					outilPedagogiqueTypeInstrumentIrdVo.getTypeInstrumentIrdVo().getId());
			query += SearchUtil.addConstraint("o", "TypeInstrumentIrd.code", "LIKE",
					outilPedagogiqueTypeInstrumentIrdVo.getTypeInstrumentIrdVo().getCode());
		}

		if (outilPedagogiqueTypeInstrumentIrdVo.getOutilPedagogiqueVo() != null) {
			query += SearchUtil.addConstraint("o", "outilPedagogique.id", "=",
					outilPedagogiqueTypeInstrumentIrdVo.getOutilPedagogiqueVo().getId());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findTypeInstrumentIrd(OutilPedagogiqueTypeInstrumentIrd outilPedagogiqueTypeInstrumentIrd) {
		TypeInstrumentIrd loadedTypeInstrumentIrd = TypeInstrumentIrdService
				.findByIdOrCode(outilPedagogiqueTypeInstrumentIrd.getTypeInstrumentIrd());

		if (loadedTypeInstrumentIrd == null) {
			return;
		}
		outilPedagogiqueTypeInstrumentIrd.setTypeInstrumentIrd(loadedTypeInstrumentIrd);
	}

	private void findOutilPedagogique(OutilPedagogiqueTypeInstrumentIrd outilPedagogiqueTypeInstrumentIrd) {
		OutilPedagogique loadedOutilPedagogique = null;
		if (outilPedagogiqueTypeInstrumentIrd.getOutilPedagogique() != null
				&& outilPedagogiqueTypeInstrumentIrd.getOutilPedagogique().getId() != null)
			loadedOutilPedagogique = outilPedagogiqueService
					.findById(outilPedagogiqueTypeInstrumentIrd.getOutilPedagogique().getId());

		if (loadedOutilPedagogique == null) {
			return;
		}
		outilPedagogiqueTypeInstrumentIrd.setOutilPedagogique(loadedOutilPedagogique);
	}

	@Override
	@Transactional
	public void delete(List<OutilPedagogiqueTypeInstrumentIrd> outilPedagogiqueTypeInstrumentIrds) {
		if (ListUtil.isNotEmpty(outilPedagogiqueTypeInstrumentIrds)) {
			outilPedagogiqueTypeInstrumentIrds.forEach(e -> outilPedagogiqueTypeInstrumentIrdDao.delete(e));
		}
	}

	@Override
	public void update(List<OutilPedagogiqueTypeInstrumentIrd> outilPedagogiqueTypeInstrumentIrds) {
		if (ListUtil.isNotEmpty(outilPedagogiqueTypeInstrumentIrds)) {
			outilPedagogiqueTypeInstrumentIrds.forEach(e -> {
				if (e.getId() != null) {
					update(e);
				} else {
					save(e);
				}
			});
		}
	}

	@Override
	public List<List<OutilPedagogiqueTypeInstrumentIrd>> getToBeSavedAndToBeDeleted(
			List<OutilPedagogiqueTypeInstrumentIrd> oldList, List<OutilPedagogiqueTypeInstrumentIrd> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

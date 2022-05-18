package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifique;
import com.ird.faa.bean.referentiel.TypeUtilisateur;
import com.ird.faa.bean.formulaire.TypeUtilisateurSavoirConcu;
import com.ird.faa.dao.formulaire.TypeUtilisateurSavoirConcuDao;
import com.ird.faa.service.chercheur.facade.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.TypeUtilisateurChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.TypeUtilisateurSavoirConcuChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.TypeUtilisateurSavoirConcuVo;

@Service
public class TypeUtilisateurSavoirConcuChercheurServiceImpl extends AbstractServiceImpl<TypeUtilisateurSavoirConcu>
		implements TypeUtilisateurSavoirConcuChercheurService {

	@Autowired
	private TypeUtilisateurSavoirConcuDao typeUtilisateurSavoirConcuDao;

	@Autowired
	private TypeUtilisateurChercheurService typeUtilisateurService;
	@Autowired
	private DeveloppementDeSavoirEtInnovationScientifiqueChercheurService developpementDeSavoirEtInnovationScientifiqueService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<TypeUtilisateurSavoirConcu> findAll() {
		return typeUtilisateurSavoirConcuDao.findAll();
	}

	@Override
	public List<TypeUtilisateurSavoirConcu> findByTypeUtilisateurCode(String code) {
		return typeUtilisateurSavoirConcuDao.findByTypeUtilisateurCode(code);
	}

	@Override
	@Transactional
	public int deleteByTypeUtilisateurCode(String code) {
		return typeUtilisateurSavoirConcuDao.deleteByTypeUtilisateurCode(code);
	}

	@Override
	public List<TypeUtilisateurSavoirConcu> findByTypeUtilisateurId(Long id) {
		return typeUtilisateurSavoirConcuDao.findByTypeUtilisateurId(id);
	}

	@Override
	@Transactional
	public int deleteByTypeUtilisateurId(Long id) {
		return typeUtilisateurSavoirConcuDao.deleteByTypeUtilisateurId(id);
	}

	@Override
	public List<TypeUtilisateurSavoirConcu> findByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id) {
		return typeUtilisateurSavoirConcuDao.findByDeveloppementDeSavoirEtInnovationScientifiqueId(id);
	}

	@Override
	@Transactional
	public int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id) {
		return typeUtilisateurSavoirConcuDao.deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(id);
	}

	@Override
	public TypeUtilisateurSavoirConcu findById(Long id) {
		if (id == null)
			return null;
		return typeUtilisateurSavoirConcuDao.getOne(id);
	}

	@Override
	public TypeUtilisateurSavoirConcu findByIdWithAssociatedList(Long id) {
		TypeUtilisateurSavoirConcu typeUtilisateurSavoirConcu = findById(id);
		return typeUtilisateurSavoirConcu;
	}

	@Transactional
	public int deleteById(Long id) {
		if (typeUtilisateurSavoirConcuDao.findById(id) == null)
			return 0;
		else {
			typeUtilisateurSavoirConcuDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public TypeUtilisateurSavoirConcu update(TypeUtilisateurSavoirConcu typeUtilisateurSavoirConcu) {
		TypeUtilisateurSavoirConcu foundedTypeUtilisateurSavoirConcu = findById(typeUtilisateurSavoirConcu.getId());
		if (foundedTypeUtilisateurSavoirConcu == null)
			return null;
		else {
			return typeUtilisateurSavoirConcuDao.save(typeUtilisateurSavoirConcu);
		}
	}

	@Override
	public TypeUtilisateurSavoirConcu save(TypeUtilisateurSavoirConcu typeUtilisateurSavoirConcu) {

		findTypeUtilisateur(typeUtilisateurSavoirConcu);
		findDeveloppementDeSavoirEtInnovationScientifique(typeUtilisateurSavoirConcu);

		TypeUtilisateurSavoirConcu savedTypeUtilisateurSavoirConcu = typeUtilisateurSavoirConcuDao
				.save(typeUtilisateurSavoirConcu);
		return savedTypeUtilisateurSavoirConcu;
	}

	@Override
	public List<TypeUtilisateurSavoirConcu> save(List<TypeUtilisateurSavoirConcu> typeUtilisateurSavoirConcus) {
		List<TypeUtilisateurSavoirConcu> list = new ArrayList<TypeUtilisateurSavoirConcu>();
		for (TypeUtilisateurSavoirConcu typeUtilisateurSavoirConcu : typeUtilisateurSavoirConcus) {
			list.add(save(typeUtilisateurSavoirConcu));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(TypeUtilisateurSavoirConcu typeUtilisateurSavoirConcu) {
		if (typeUtilisateurSavoirConcu.getId() == null)
			return -1;
		TypeUtilisateurSavoirConcu foundedTypeUtilisateurSavoirConcu = findById(typeUtilisateurSavoirConcu.getId());
		if (foundedTypeUtilisateurSavoirConcu == null)
			return -1;
		typeUtilisateurSavoirConcuDao.delete(foundedTypeUtilisateurSavoirConcu);
		return 1;
	}

	public List<TypeUtilisateurSavoirConcu> findByCriteria(TypeUtilisateurSavoirConcuVo typeUtilisateurSavoirConcuVo) {

		String query = "SELECT o FROM TypeUtilisateurSavoirConcu o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", typeUtilisateurSavoirConcuVo.getId());
		if (typeUtilisateurSavoirConcuVo.getTypeUtilisateurVo() != null) {
			query += SearchUtil.addConstraint("o", "typeUtilisateur.id", "=",
					typeUtilisateurSavoirConcuVo.getTypeUtilisateurVo().getId());
			query += SearchUtil.addConstraint("o", "typeUtilisateur.code", "LIKE",
					typeUtilisateurSavoirConcuVo.getTypeUtilisateurVo().getCode());
		}

		if (typeUtilisateurSavoirConcuVo.getDeveloppementDeSavoirEtInnovationScientifiqueVo() != null) {
			query += SearchUtil.addConstraint("o", "developpementDeSavoirEtInnovationScientifique.id", "=",
					typeUtilisateurSavoirConcuVo.getDeveloppementDeSavoirEtInnovationScientifiqueVo().getId());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findTypeUtilisateur(TypeUtilisateurSavoirConcu typeUtilisateurSavoirConcu) {
		TypeUtilisateur loadedTypeUtilisateur = typeUtilisateurService
				.findByIdOrCode(typeUtilisateurSavoirConcu.getTypeUtilisateur());

		if (loadedTypeUtilisateur == null) {
			return;
		}
		typeUtilisateurSavoirConcu.setTypeUtilisateur(loadedTypeUtilisateur);
	}

	private void findDeveloppementDeSavoirEtInnovationScientifique(
			TypeUtilisateurSavoirConcu typeUtilisateurSavoirConcu) {
		DeveloppementDeSavoirEtInnovationScientifique loadedDeveloppementDeSavoirEtInnovationScientifique = null;
		if (typeUtilisateurSavoirConcu.getDeveloppementDeSavoirEtInnovationScientifique() != null
				&& typeUtilisateurSavoirConcu.getDeveloppementDeSavoirEtInnovationScientifique().getId() != null)
			loadedDeveloppementDeSavoirEtInnovationScientifique = developpementDeSavoirEtInnovationScientifiqueService
					.findById(typeUtilisateurSavoirConcu.getDeveloppementDeSavoirEtInnovationScientifique().getId());

		if (loadedDeveloppementDeSavoirEtInnovationScientifique == null) {
			return;
		}
		typeUtilisateurSavoirConcu
				.setDeveloppementDeSavoirEtInnovationScientifique(loadedDeveloppementDeSavoirEtInnovationScientifique);
	}

	@Override
	@Transactional
	public void delete(List<TypeUtilisateurSavoirConcu> typeUtilisateurSavoirConcus) {
		if (ListUtil.isNotEmpty(typeUtilisateurSavoirConcus)) {
			typeUtilisateurSavoirConcus.forEach(e -> typeUtilisateurSavoirConcuDao.delete(e));
		}
	}

	@Override
	public void update(List<TypeUtilisateurSavoirConcu> typeUtilisateurSavoirConcus) {
		if (ListUtil.isNotEmpty(typeUtilisateurSavoirConcus)) {
			typeUtilisateurSavoirConcus.forEach(e -> typeUtilisateurSavoirConcuDao.save(e));
		}
	}

	@Override
	public List<List<TypeUtilisateurSavoirConcu>> getToBeSavedAndToBeDeleted(List<TypeUtilisateurSavoirConcu> oldList,
			List<TypeUtilisateurSavoirConcu> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.security.common.SecurityUtil;
import com.ird.faa.security.bean.User;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.Etablissement;
import com.ird.faa.bean.referentiel.Ville;
import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.dao.formulaire.EtablissementDao;
import com.ird.faa.service.chercheur.facade.formulaire.EtablissementChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.VilleChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.PaysChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.EtablissementVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtablissementChercheurServiceImpl extends AbstractServiceImpl<Etablissement>
		implements EtablissementChercheurService {

	@Autowired
	private EtablissementDao etablissementDao;

	@Autowired
	private ArchivableService<Etablissement> archivableService;
	@Autowired
	private VilleChercheurService villeService;
	@Autowired
	private PaysChercheurService paysService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Etablissement> findAll() {
		List<Etablissement> resultat = new ArrayList();
		resultat.addAll(findAllNonArchive());
		resultat.addAll(findAllByOwner());
		return resultat;
	}

	@Override
	public List<Etablissement> findByVilleCode(String code) {
		return etablissementDao.findByVilleCode(code);
	}

	@Override
	@Transactional
	public int deleteByVilleCode(String code) {
		return etablissementDao.deleteByVilleCode(code);
	}

	@Override
	public List<Etablissement> findByVilleId(Long id) {
		return etablissementDao.findByVilleId(id);
	}

	@Override
	@Transactional
	public int deleteByVilleId(Long id) {
		return etablissementDao.deleteByVilleId(id);
	}

	@Override
	public List<Etablissement> findByPaysCode(String code) {
		return etablissementDao.findByPaysCode(code);
	}

	@Override
	@Transactional
	public int deleteByPaysCode(String code) {
		return etablissementDao.deleteByPaysCode(code);
	}

	@Override
	public List<Etablissement> findByPaysId(Long id) {
		return etablissementDao.findByPaysId(id);
	}

	@Override
	@Transactional
	public int deleteByPaysId(Long id) {
		return etablissementDao.deleteByPaysId(id);
	}

	@Override
	public Etablissement findByCode(String code) {
		if (code == null)
			return null;
		return etablissementDao.findByCode(code);
	}

	@Override
	@Transactional
	public int deleteByCode(String code) {
		return etablissementDao.deleteByCode(code);
	}

	@Override
	public Etablissement findByIdOrCode(Etablissement etablissement) {
		Etablissement resultat = null;
		if (etablissement != null) {
			if (StringUtil.isNotEmpty(etablissement.getId())) {
				resultat = etablissementDao.getOne(etablissement.getId());
			} else if (StringUtil.isNotEmpty(etablissement.getCode())) {
				resultat = etablissementDao.findByCode(etablissement.getCode());
			}
		}
		return resultat;
	}

	@Override
	public Etablissement findById(Long id) {
		if (id == null)
			return null;
		return etablissementDao.getOne(id);
	}

	@Override
	public Etablissement findByIdWithAssociatedList(Long id) {
		return findById(id);
	}

	@Transactional
	public int deleteById(Long id) {
		int res = 0;
		if (etablissementDao.findById(id).isPresent()) {
			etablissementDao.deleteById(id);
			res = 1;
		}
		return res;
	}

	@Override
	public Etablissement update(Etablissement etablissement) {
		Etablissement foundedEtablissement = findById(etablissement.getId());
		if (foundedEtablissement == null)
			return null;
		else {
			archivableService.prepare(etablissement);
			return etablissementDao.save(etablissement);
		}
	}

	private void prepareSave(Etablissement etablissement) {
		etablissement.setDateCreation(new Date());
		if (etablissement.getValide() == null)
			etablissement.setValide(false);
		if (etablissement.getArchive() == null)
			etablissement.setArchive(false);
		if (etablissement.getAdmin() == null)
			etablissement.setAdmin(false);
		if (etablissement.getVisible() == null)
			etablissement.setVisible(false);

		etablissement.setAdmin(false);
		etablissement.setVisible(false);
		User currentUser = SecurityUtil.getCurrentUser();
		if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())) {
			etablissement.setUsername(currentUser.getUsername());
		}

	}

	@Override
	public Etablissement save(Etablissement etablissement) {
		prepareSave(etablissement);

		Etablissement result = null;
		Etablissement foundedEtablissement = findByCode(etablissement.getCode());
		if (foundedEtablissement == null) {

			findVille(etablissement);
			findPays(etablissement);

			Etablissement savedEtablissement = etablissementDao.save(etablissement);

			result = savedEtablissement;
		}

		return result;
	}

	@Override
	public List<Etablissement> save(List<Etablissement> etablissements) {
		List<Etablissement> list = new ArrayList<>();
		for (Etablissement etablissement : etablissements) {
			list.add(save(etablissement));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(Etablissement etablissement) {
		if (etablissement.getCode() == null)
			return -1;

		Etablissement foundedEtablissement = findByCode(etablissement.getCode());
		if (foundedEtablissement == null)
			return -1;
		etablissementDao.delete(foundedEtablissement);
		return 1;
	}

	public List<Etablissement> findByCriteria(EtablissementVo etablissementVo) {

		String query = "SELECT o FROM Etablissement o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", etablissementVo.getId());
		query += SearchUtil.addConstraint("o", "libelle", "LIKE", etablissementVo.getLibelle());
		query += SearchUtil.addConstraint("o", "code", "LIKE", etablissementVo.getCode());
		query += SearchUtil.addConstraint("o", "description", "LIKE", etablissementVo.getDescription());
		query += SearchUtil.addConstraint("o", "sigleOfficiel", "LIKE", etablissementVo.getSigleOfficiel());
		query += SearchUtil.addConstraint("o", "nomEnFrancais", "LIKE", etablissementVo.getNomEnFrancais());
		query += SearchUtil.addConstraint("o", "sigleEnFrancais", "LIKE", etablissementVo.getSigleEnFrancais());
		query += SearchUtil.addConstraint("o", "anciensNom", "LIKE", etablissementVo.getAnciensNom());
		query += SearchUtil.addConstraint("o", "champIntervention", "LIKE", etablissementVo.getChampIntervention());
		query += SearchUtil.addConstraint("o", "valide", "=", etablissementVo.getValide());
		query += SearchUtil.addConstraint("o", "archive", "=", etablissementVo.getArchive());
		query += SearchUtil.addConstraintDate("o", "dateArchivage", "=", etablissementVo.getDateArchivage());
		query += SearchUtil.addConstraintDate("o", "dateCreation", "=", etablissementVo.getDateCreation());
		query += SearchUtil.addConstraint("o", "admin", "=", etablissementVo.getAdmin());
		query += SearchUtil.addConstraint("o", "visible", "=", etablissementVo.getVisible());
		query += SearchUtil.addConstraint("o", "username", "LIKE", etablissementVo.getUsername());
		query += SearchUtil.addConstraintMinMaxDate("o", "dateArchivage", etablissementVo.getDateArchivageMin(),
				etablissementVo.getDateArchivageMax());
		query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", etablissementVo.getDateCreationMin(),
				etablissementVo.getDateCreationMax());
		if (etablissementVo.getVilleVo() != null) {
			query += SearchUtil.addConstraint("o", "ville.id", "=", etablissementVo.getVilleVo().getId());
			query += SearchUtil.addConstraint("o", "ville.code", "LIKE", etablissementVo.getVilleVo().getCode());
		}

		if (etablissementVo.getPaysVo() != null) {
			query += SearchUtil.addConstraint("o", "pays.id", "=", etablissementVo.getPaysVo().getId());
			query += SearchUtil.addConstraint("o", "pays.code", "LIKE", etablissementVo.getPaysVo().getCode());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void findVille(Etablissement etablissement) {
		Ville loadedVille = villeService.findByIdOrCode(etablissement.getVille());

		if (loadedVille == null) {
			return;
		}
		etablissement.setVille(loadedVille);
	}

	private void findPays(Etablissement etablissement) {
		Pays loadedPays = paysService.findByIdOrCode(etablissement.getPays());

		if (loadedPays == null) {
			return;
		}
		etablissement.setPays(loadedPays);
	}

	@Override
	@Transactional
	public void delete(List<Etablissement> etablissements) {
		if (ListUtil.isNotEmpty(etablissements)) {
			etablissements.forEach(e -> etablissementDao.delete(e));
		}
	}

	@Override
	public void update(List<Etablissement> etablissements) {
		if (ListUtil.isNotEmpty(etablissements)) {
			etablissements.forEach(e -> etablissementDao.save(e));
		}
	}

	public List<Etablissement> findAllNonArchive() {
		String query = "SELECT o FROM Etablissement o  WHERE o.archive != true AND o.visible = true";
		return entityManager.createQuery(query).getResultList();
	}

	public List<Etablissement> findAllByOwner() {
		List<Etablissement> result = new ArrayList();
		User currentUser = SecurityUtil.getCurrentUser();
		if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())) {
			String query = "SELECT o FROM Etablissement o  WHERE o.archive != true AND o.visible = false AND o.username = '"
					+ currentUser.getUsername() + "'";
			result = entityManager.createQuery(query).getResultList();
		}
		return result;
	}

}

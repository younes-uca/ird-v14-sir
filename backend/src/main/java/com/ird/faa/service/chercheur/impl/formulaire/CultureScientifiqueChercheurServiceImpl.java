package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.formulaire.Campagne;
import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.bean.formulaire.CultureScientifique;
import com.ird.faa.bean.config.EtatEtapeCampagne;
import com.ird.faa.bean.referentiel.NatureActiviteGrandPublique;
import com.ird.faa.bean.referentiel.OutilPedagogique;
import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePublique;
import com.ird.faa.bean.formulaire.RencontreMedia;
import com.ird.faa.dao.formulaire.CultureScientifiqueDao;
import com.ird.faa.security.bean.User;
import com.ird.faa.security.common.SecurityUtil;
import com.ird.faa.service.chercheur.facade.formulaire.CampagneChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.ChercheurChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.CultureScientifiqueChercheurService;
import com.ird.faa.service.chercheur.facade.config.EtatEtapeCampagneChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.NatureActiviteGrandPubliqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreGrandPubliqueJeunePubliqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreMediaChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.CultureScientifiqueVo;

@Service
public class CultureScientifiqueChercheurServiceImpl extends AbstractServiceImpl<CultureScientifique>
		implements CultureScientifiqueChercheurService {

	@Autowired
	private CultureScientifiqueDao cultureScientifiqueDao;

	@Autowired
	private EtatEtapeCampagneChercheurService etatEtapeCampagneService;
	@Autowired
	private OutilPedagogiqueChercheurService outilPedagogiqueService;
	@Autowired
	private RencontreGrandPubliqueJeunePubliqueChercheurService rencontreGrandPubliqueJeunePubliqueService;
	@Autowired
	private RencontreMediaChercheurService rencontreMediaService;
	@Autowired
	private NatureActiviteGrandPubliqueChercheurService natureActiviteGrandPubliqueService;
	@Autowired
	private CampagneChercheurService campagneService;
	@Autowired
	private ChercheurChercheurService chercheurService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<CultureScientifique> findAll() {
		User currentUser = SecurityUtil.getCurrentUser();
		if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())) {
			return cultureScientifiqueDao.findByChercheurUsername(currentUser.getUsername());
		}
		return new ArrayList<>();
	}

	@Override
	public List<CultureScientifique> findByCampagneCode(String code) {
		return cultureScientifiqueDao.findByCampagneCode(code);
	}

	@Override
	@Transactional
	public int deleteByCampagneCode(String code) {
		return cultureScientifiqueDao.deleteByCampagneCode(code);
	}

	@Override
	public List<CultureScientifique> findByCampagneId(Long id) {
		return cultureScientifiqueDao.findByCampagneId(id);
	}

	@Override
	@Transactional
	public int deleteByCampagneId(Long id) {
		return cultureScientifiqueDao.deleteByCampagneId(id);
	}

	@Override
	public List<CultureScientifique> findByChercheurNumeroMatricule(String numeroMatricule) {
		return cultureScientifiqueDao.findByChercheurNumeroMatricule(numeroMatricule);
	}

	@Override
	@Transactional
	public int deleteByChercheurNumeroMatricule(String numeroMatricule) {
		return cultureScientifiqueDao.deleteByChercheurNumeroMatricule(numeroMatricule);
	}

	@Override
	public List<CultureScientifique> findByChercheurId(Long id) {
		return cultureScientifiqueDao.findByChercheurId(id);
	}

	@Override
	@Transactional
	public int deleteByChercheurId(Long id) {
		return cultureScientifiqueDao.deleteByChercheurId(id);
	}

	@Override
	public List<CultureScientifique> findByEtatEtapeCampagneCode(String code) {
		return cultureScientifiqueDao.findByEtatEtapeCampagneCode(code);
	}

	@Override
	@Transactional
	public int deleteByEtatEtapeCampagneCode(String code) {
		return cultureScientifiqueDao.deleteByEtatEtapeCampagneCode(code);
	}

	@Override
	public List<CultureScientifique> findByEtatEtapeCampagneId(Long id) {
		return cultureScientifiqueDao.findByEtatEtapeCampagneId(id);
	}

	@Override
	@Transactional
	public int deleteByEtatEtapeCampagneId(Long id) {
		return cultureScientifiqueDao.deleteByEtatEtapeCampagneId(id);
	}

	@Override
	public List<CultureScientifique> findByNatureActiviteGrandPubliqueCode(String code) {
		return cultureScientifiqueDao.findByNatureActiviteGrandPubliqueCode(code);
	}

	@Override
	@Transactional
	public int deleteByNatureActiviteGrandPubliqueCode(String code) {
		return cultureScientifiqueDao.deleteByNatureActiviteGrandPubliqueCode(code);
	}

	@Override
	public List<CultureScientifique> findByNatureActiviteGrandPubliqueId(Long id) {
		return cultureScientifiqueDao.findByNatureActiviteGrandPubliqueId(id);
	}

	@Override
	@Transactional
	public int deleteByNatureActiviteGrandPubliqueId(Long id) {
		return cultureScientifiqueDao.deleteByNatureActiviteGrandPubliqueId(id);
	}

	@Override
	public CultureScientifique findById(Long id) {
		if (id == null)
			return null;
		return cultureScientifiqueDao.getOne(id);
	}

	@Override
	public CultureScientifique findByIdWithAssociatedList(Long id) {
		CultureScientifique cultureScientifique = findById(id);
		findAssociatedLists(cultureScientifique);
		return cultureScientifique;
	}

	private void findAssociatedLists(CultureScientifique cultureScientifique) {
		if (cultureScientifique == null || cultureScientifique.getId() == null)
			return;
		else {
			List<RencontreGrandPubliqueJeunePublique> rencontreGrandPubliqueJeunePubliques = rencontreGrandPubliqueJeunePubliqueService
					.findByCultureScientifiqueId(cultureScientifique.getId());
			cultureScientifique.setRencontreGrandPubliqueJeunePubliques(rencontreGrandPubliqueJeunePubliques);
			List<RencontreMedia> rencontreMedias = rencontreMediaService
					.findByCultureScientifiqueId(cultureScientifique.getId());
			cultureScientifique.setRencontreMedias(rencontreMedias);
			List<OutilPedagogique> outilPedagogiques = outilPedagogiqueService
					.findByCultureScientifiqueId(cultureScientifique.getId());
			cultureScientifique.setOutilPedagogiques(outilPedagogiques);
		}
	}

	private void deleteAssociatedLists(Long id) {
		if (id == null)
			return;
		else {
			List<RencontreGrandPubliqueJeunePublique> rencontresGrandPublic = rencontreGrandPubliqueJeunePubliqueService.findByCultureScientifiqueId(id);
			rencontresGrandPublic.forEach(rencontre -> {
				rencontreGrandPubliqueJeunePubliqueService.deleteById(rencontre.getId());
			});
			List<RencontreMedia> rencontresMedia = rencontreMediaService.findByCultureScientifiqueId(id);
			rencontresMedia.forEach(rencontreMedia -> {
				rencontreMediaService.deleteById(rencontreMedia.getId());
			});
			List<OutilPedagogique> outilsPedagogique = outilPedagogiqueService.findByCultureScientifiqueId(id);
			outilsPedagogique.forEach(outil -> {
				outilPedagogiqueService.deleteById(outil.getId());
			});

		}
	}

	private void updateAssociatedLists(CultureScientifique cultureScientifique) {
		if (cultureScientifique == null || cultureScientifique.getId() == null)
			return;
		else {
			List<List<RencontreGrandPubliqueJeunePublique>> resultRencontreGrandPubliqueJeunePubliques = rencontreGrandPubliqueJeunePubliqueService
					.getToBeSavedAndToBeDeleted(
							rencontreGrandPubliqueJeunePubliqueService
									.findByCultureScientifiqueId(cultureScientifique.getId()),
							cultureScientifique.getRencontreGrandPubliqueJeunePubliques());
			rencontreGrandPubliqueJeunePubliqueService.delete(resultRencontreGrandPubliqueJeunePubliques.get(1));
			associateRencontreGrandPubliqueJeunePublique(cultureScientifique,
					resultRencontreGrandPubliqueJeunePubliques.get(0));
			rencontreGrandPubliqueJeunePubliqueService.update(resultRencontreGrandPubliqueJeunePubliques.get(0));

			List<List<RencontreMedia>> resultRencontreMedias = rencontreMediaService.getToBeSavedAndToBeDeleted(
					rencontreMediaService.findByCultureScientifiqueId(cultureScientifique.getId()),
					cultureScientifique.getRencontreMedias());
			rencontreMediaService.delete(resultRencontreMedias.get(1));
			associateRencontreMedia(cultureScientifique, resultRencontreMedias.get(0));
			rencontreMediaService.update(resultRencontreMedias.get(0));

			List<List<OutilPedagogique>> resultOutilPedagogiques = outilPedagogiqueService.getToBeSavedAndToBeDeleted(
					outilPedagogiqueService.findByCultureScientifiqueId(cultureScientifique.getId()),
					cultureScientifique.getOutilPedagogiques());
			outilPedagogiqueService.delete(resultOutilPedagogiques.get(1));
			associateOutilPedagogique(cultureScientifique, resultOutilPedagogiques.get(0));
			outilPedagogiqueService.update(resultOutilPedagogiques.get(0));

		}
	}

	@Transactional
	public int deleteById(Long id) {
		if (cultureScientifiqueDao.findById(id) == null)
			return 0;
		else {
			deleteAssociatedLists(id);
			cultureScientifiqueDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public CultureScientifique update(CultureScientifique cultureScientifique) {
		CultureScientifique foundedCultureScientifique = findById(cultureScientifique.getId());
		if (foundedCultureScientifique == null)
			return null;
		else {
			updateAssociatedLists(cultureScientifique);
			return cultureScientifiqueDao.save(cultureScientifique);
		}
	}

	@Override
	public CultureScientifique save(CultureScientifique cultureScientifique) {

		CultureScientifique resultat = new CultureScientifique();

		User currentUser = SecurityUtil.getCurrentUser();
		if (currentUser == null || StringUtil.isEmpty(currentUser.getUsername())) {
			return resultat;
		}
		String username = currentUser.getUsername();
		Chercheur loadedChercheur = chercheurService.findByUsername(username);
		if (loadedChercheur == null) {
			return resultat;
		}
		Campagne laodedCampagne = campagneService.findProgressCampagneByChercheurUsername(username);
		if (laodedCampagne == null) {
			return resultat;
		} else {
			cultureScientifique.setChercheur(loadedChercheur);
			cultureScientifique.setCampagne(laodedCampagne);

			findCampagne(cultureScientifique);
			findChercheur(cultureScientifique);
			findEtatEtapeCampagne(cultureScientifique);
			findNatureActiviteGrandPublique(cultureScientifique);

			CultureScientifique savedCultureScientifique = cultureScientifiqueDao.save(cultureScientifique);
			saveRencontreGrandPubliqueJeunePubliques(savedCultureScientifique,
					cultureScientifique.getRencontreGrandPubliqueJeunePubliques());
			saveRencontreMedias(savedCultureScientifique, cultureScientifique.getRencontreMedias());
			saveOutilPedagogiques(savedCultureScientifique, cultureScientifique.getOutilPedagogiques());
			return savedCultureScientifique;
		}
	}

	@Override
	public List<CultureScientifique> save(List<CultureScientifique> cultureScientifiques) {
		List<CultureScientifique> list = new ArrayList<CultureScientifique>();
		for (CultureScientifique cultureScientifique : cultureScientifiques) {
			list.add(save(cultureScientifique));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(CultureScientifique cultureScientifique) {
		if (cultureScientifique.getId() == null)
			return -1;
		CultureScientifique foundedCultureScientifique = findById(cultureScientifique.getId());
		if (foundedCultureScientifique == null)
			return -1;
		cultureScientifiqueDao.delete(foundedCultureScientifique);
		return 1;
	}

	public List<CultureScientifique> findByCriteria(CultureScientifiqueVo cultureScientifiqueVo) {
		User currentUser = SecurityUtil.getCurrentUser();
		if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())) {

			String query = "SELECT o FROM CultureScientifique o where 1=1 ";
			query += SearchUtil.addConstraint("o", "chercheur.username", "=", currentUser.getUsername());

			query += SearchUtil.addConstraint("o", "id", "=", cultureScientifiqueVo.getId());
			query += SearchUtil.addConstraint("o", "annee", "=", cultureScientifiqueVo.getAnnee());
			query += SearchUtil.addConstraint("o", "tempsEstimePourCetteAnnne", "=",
					cultureScientifiqueVo.getTempsEstimePourCetteAnnne());
			query += SearchUtil.addConstraintMinMax("o", "annee", cultureScientifiqueVo.getAnneeMin(),
					cultureScientifiqueVo.getAnneeMax());
			query += SearchUtil.addConstraintMinMax("o", "tempsEstimePourCetteAnnne",
					cultureScientifiqueVo.getTempsEstimePourCetteAnnneMin(),
					cultureScientifiqueVo.getTempsEstimePourCetteAnnneMax());
			if (cultureScientifiqueVo.getCampagneVo() != null) {
				query += SearchUtil.addConstraint("o", "campagne.id", "=",
						cultureScientifiqueVo.getCampagneVo().getId());
				query += SearchUtil.addConstraint("o", "campagne.code", "LIKE",
						cultureScientifiqueVo.getCampagneVo().getCode());
			}

			if (cultureScientifiqueVo.getChercheurVo() != null) {
				query += SearchUtil.addConstraint("o", "chercheur.id", "=",
						cultureScientifiqueVo.getChercheurVo().getId());
				query += SearchUtil.addConstraint("o", "chercheur.numeroMatricule", "LIKE",
						cultureScientifiqueVo.getChercheurVo().getNumeroMatricule());
			}

			if (cultureScientifiqueVo.getEtatEtapeCampagneVo() != null) {
				query += SearchUtil.addConstraint("o", "etatEtapeCampagne.id", "=",
						cultureScientifiqueVo.getEtatEtapeCampagneVo().getId());
				query += SearchUtil.addConstraint("o", "etatEtapeCampagne.code", "LIKE",
						cultureScientifiqueVo.getEtatEtapeCampagneVo().getCode());
			}

			if (cultureScientifiqueVo.getNatureActiviteGrandPubliqueVo() != null) {
				query += SearchUtil.addConstraint("o", "natureActiviteGrandPublique.id", "=",
						cultureScientifiqueVo.getNatureActiviteGrandPubliqueVo().getId());
				query += SearchUtil.addConstraint("o", "natureActiviteGrandPublique.code", "LIKE",
						cultureScientifiqueVo.getNatureActiviteGrandPubliqueVo().getCode());
			}

			return entityManager.createQuery(query).getResultList();
		}
		return new ArrayList<>();
	}

	private void saveRencontreGrandPubliqueJeunePubliques(CultureScientifique cultureScientifique,
			List<RencontreGrandPubliqueJeunePublique> rencontreGrandPubliqueJeunePubliques) {

		if (ListUtil.isNotEmpty(cultureScientifique.getRencontreGrandPubliqueJeunePubliques())) {
			List<RencontreGrandPubliqueJeunePublique> savedRencontreGrandPubliqueJeunePubliques = new ArrayList<>();
			rencontreGrandPubliqueJeunePubliques.forEach(element -> {
				element.setCultureScientifique(cultureScientifique);
				rencontreGrandPubliqueJeunePubliqueService.save(element);
			});
			cultureScientifique.setRencontreGrandPubliqueJeunePubliques(savedRencontreGrandPubliqueJeunePubliques);
		}
	}

	private void saveRencontreMedias(CultureScientifique cultureScientifique, List<RencontreMedia> rencontreMedias) {

		if (ListUtil.isNotEmpty(cultureScientifique.getRencontreMedias())) {
			List<RencontreMedia> savedRencontreMedias = new ArrayList<>();
			rencontreMedias.forEach(element -> {
				element.setCultureScientifique(cultureScientifique);
				rencontreMediaService.save(element);
			});
			cultureScientifique.setRencontreMedias(savedRencontreMedias);
		}
	}

	private void saveOutilPedagogiques(CultureScientifique cultureScientifique,
			List<OutilPedagogique> outilPedagogiques) {

		if (ListUtil.isNotEmpty(cultureScientifique.getOutilPedagogiques())) {
			List<OutilPedagogique> savedOutilPedagogiques = new ArrayList<>();
			outilPedagogiques.forEach(element -> {
				element.setCultureScientifique(cultureScientifique);
				outilPedagogiqueService.save(element);
			});
			cultureScientifique.setOutilPedagogiques(savedOutilPedagogiques);
		}
	}

	private void findCampagne(CultureScientifique cultureScientifique) {
		Campagne loadedCampagne = campagneService.findByIdOrCode(cultureScientifique.getCampagne());

		if (loadedCampagne == null) {
			return;
		}
		cultureScientifique.setCampagne(loadedCampagne);
	}

	private void findChercheur(CultureScientifique cultureScientifique) {
		Chercheur loadedChercheur = chercheurService.findByIdOrNumeroMatricule(cultureScientifique.getChercheur());

		if (loadedChercheur == null) {
			return;
		}
		cultureScientifique.setChercheur(loadedChercheur);
	}

	private void findEtatEtapeCampagne(CultureScientifique cultureScientifique) {
		EtatEtapeCampagne loadedEtatEtapeCampagne = etatEtapeCampagneService
				.findByIdOrCode(cultureScientifique.getEtatEtapeCampagne());

		if (loadedEtatEtapeCampagne == null) {
			return;
		}
		cultureScientifique.setEtatEtapeCampagne(loadedEtatEtapeCampagne);
	}

	private void findNatureActiviteGrandPublique(CultureScientifique cultureScientifique) {
		NatureActiviteGrandPublique loadedNatureActiviteGrandPublique = natureActiviteGrandPubliqueService
				.findByIdOrCode(cultureScientifique.getNatureActiviteGrandPublique());

		if (loadedNatureActiviteGrandPublique == null) {
			return;
		}
		cultureScientifique.setNatureActiviteGrandPublique(loadedNatureActiviteGrandPublique);
	}

	@Override
	@Transactional
	public void delete(List<CultureScientifique> cultureScientifiques) {
		if (ListUtil.isNotEmpty(cultureScientifiques)) {
			cultureScientifiques.forEach(e -> cultureScientifiqueDao.delete(e));
		}
	}

	@Override
	public void update(List<CultureScientifique> cultureScientifiques) {
		if (ListUtil.isNotEmpty(cultureScientifiques)) {
			cultureScientifiques.forEach(e -> cultureScientifiqueDao.save(e));
		}
	}

	private void associateRencontreGrandPubliqueJeunePublique(CultureScientifique cultureScientifique,
			List<RencontreGrandPubliqueJeunePublique> rencontreGrandPubliqueJeunePublique) {
		if (ListUtil.isNotEmpty(rencontreGrandPubliqueJeunePublique)) {
			rencontreGrandPubliqueJeunePublique.forEach(e -> e.setCultureScientifique(cultureScientifique));
		}
	}

	private void associateRencontreMedia(CultureScientifique cultureScientifique, List<RencontreMedia> rencontreMedia) {
		if (ListUtil.isNotEmpty(rencontreMedia)) {
			rencontreMedia.forEach(e -> e.setCultureScientifique(cultureScientifique));
		}
	}

	private void associateOutilPedagogique(CultureScientifique cultureScientifique,
			List<OutilPedagogique> outilPedagogique) {
		if (ListUtil.isNotEmpty(outilPedagogique)) {
			outilPedagogique.forEach(e -> e.setCultureScientifique(cultureScientifique));
		}
	}

	@Override
	public List<CultureScientifique> findByChercheurUsernameAndCampagneId(String username, Long compagneId) {
		List<CultureScientifique> resultat = cultureScientifiqueDao.findByChercheurUsernameAndCampagneId(username,
				compagneId);
		return resultat;
	}

	@Override
	public List<List<CultureScientifique>> getToBeSavedAndToBeDeleted(List<CultureScientifique> oldList,
			List<CultureScientifique> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

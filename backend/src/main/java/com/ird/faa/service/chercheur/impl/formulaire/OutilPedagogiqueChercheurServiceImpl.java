package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.formulaire.CultureScientifique;
import com.ird.faa.bean.config.EtatEtapeCampagne;
import com.ird.faa.bean.referentiel.OutilPedagogique;
import com.ird.faa.bean.formulaire.OutilPedagogiqueDisciplineScientifique;
import com.ird.faa.bean.formulaire.OutilPedagogiqueEnjeuxIrd;
import com.ird.faa.bean.formulaire.OutilPedagogiqueInstrumentIrd;
import com.ird.faa.bean.formulaire.OutilPedagogiqueLangue;
import com.ird.faa.bean.formulaire.OutilPedagogiquePaysConception;
import com.ird.faa.bean.formulaire.OutilPedagogiquePaysDiffusion;
import com.ird.faa.bean.formulaire.OutilPedagogiquePeriode;
import com.ird.faa.bean.formulaire.OutilPedagogiquePubliqueCible;
import com.ird.faa.bean.formulaire.OutilPedagogiqueTypeInstrumentIrd;
import com.ird.faa.bean.referentiel.TypeOutilPedagogique;
import com.ird.faa.dao.formulaire.OutilPedagogiqueDao;
import com.ird.faa.service.chercheur.facade.formulaire.CultureScientifiqueChercheurService;
import com.ird.faa.service.chercheur.facade.config.EtatEtapeCampagneChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueDisciplineScientifiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueEnjeuxIrdChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueInstrumentIrdChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueLangueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiquePaysConceptionChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiquePaysDiffusionChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiquePeriodeChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiquePubliqueCibleChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.OutilPedagogiqueTypeInstrumentIrdChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.TypeOutilPedagogiqueChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.OutilPedagogiqueVo;

@Service
public class OutilPedagogiqueChercheurServiceImpl extends AbstractServiceImpl<OutilPedagogique>
		implements OutilPedagogiqueChercheurService {

	@Autowired
	private OutilPedagogiqueDao outilPedagogiqueDao;

	@Autowired
	private OutilPedagogiqueLangueChercheurService outilPedagogiqueLangueService;
	@Autowired
	private EtatEtapeCampagneChercheurService etatEtapeCampagneService;
	@Autowired
	private OutilPedagogiqueEnjeuxIrdChercheurService outilPedagogiqueEnjeuxIrdService;
	@Autowired
	private OutilPedagogiquePaysDiffusionChercheurService outilPedagogiquePaysDiffusionService;
	@Autowired
	private OutilPedagogiquePubliqueCibleChercheurService outilPedagogiquePubliqueCibleService;
	@Autowired
	private TypeOutilPedagogiqueChercheurService typeOutilPedagogiqueService;
	@Autowired
	private OutilPedagogiquePaysConceptionChercheurService outilPedagogiquePaysConceptionService;
	@Autowired
	private OutilPedagogiqueInstrumentIrdChercheurService outilPedagogiqueInstrumentIrdService;
	@Autowired
	private OutilPedagogiqueTypeInstrumentIrdChercheurService outilPedagogiqueTypeInstrumentIrdService;
	@Autowired
	private CultureScientifiqueChercheurService cultureScientifiqueService;
	@Autowired
	private OutilPedagogiqueDisciplineScientifiqueChercheurService outilPedagogiqueDisciplineScientifiqueService;
	@Autowired
	private OutilPedagogiquePeriodeChercheurService outilPedagogiquePeriodeService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<OutilPedagogique> findAll() {
		return outilPedagogiqueDao.findAll();
	}

	@Override
	public List<OutilPedagogique> findByCultureScientifiqueId(Long id) {
		List<OutilPedagogique> listOutilPedagogique=outilPedagogiqueDao.findByCultureScientifiqueId(id);
		List<OutilPedagogique> listOutilPedagogiqueWithList=new ArrayList<>();
		for(OutilPedagogique outilPedagogique:listOutilPedagogique) {
			OutilPedagogique outilWithList=findByIdWithAssociatedList(outilPedagogique.getId());
			listOutilPedagogiqueWithList.add(outilWithList);
		}
		return listOutilPedagogiqueWithList;
	}

	@Override
	@Transactional
	public int deleteByCultureScientifiqueId(Long id) {
		return outilPedagogiqueDao.deleteByCultureScientifiqueId(id);
	}

	@Override
	public List<OutilPedagogique> findByEtatEtapeCampagneCode(String code) {
		return outilPedagogiqueDao.findByEtatEtapeCampagneCode(code);
	}

	@Override
	@Transactional
	public int deleteByEtatEtapeCampagneCode(String code) {
		return outilPedagogiqueDao.deleteByEtatEtapeCampagneCode(code);
	}

	@Override
	public List<OutilPedagogique> findByEtatEtapeCampagneId(Long id) {
		return outilPedagogiqueDao.findByEtatEtapeCampagneId(id);
	}

	@Override
	@Transactional
	public int deleteByEtatEtapeCampagneId(Long id) {
		return outilPedagogiqueDao.deleteByEtatEtapeCampagneId(id);
	}

	@Override
	public OutilPedagogique findById(Long id) {
		if (id == null)
			return null;
		return outilPedagogiqueDao.getOne(id);
	}

	@Override
	public OutilPedagogique findByIdWithAssociatedList(Long id) {
		OutilPedagogique outilPedagogique = findById(id);
		findAssociatedLists(outilPedagogique);
		return outilPedagogique;
	}

	private void findAssociatedLists(OutilPedagogique outilPedagogique) {
		if (outilPedagogique == null || outilPedagogique.getId() == null)
			return;
		else {
			List<OutilPedagogiqueEnjeuxIrd> outilPedagogiqueEnjeuxIrds = outilPedagogiqueEnjeuxIrdService
					.findByOutilPedagogiqueId(outilPedagogique.getId());
			outilPedagogique.setOutilPedagogiqueEnjeuxIrds(outilPedagogiqueEnjeuxIrds);
			List<OutilPedagogiqueDisciplineScientifique> outilPedagogiqueDisciplineScientifiques = outilPedagogiqueDisciplineScientifiqueService
					.findByOutilPedagogiqueId(outilPedagogique.getId());
			outilPedagogique.setOutilPedagogiqueDisciplineScientifiques(outilPedagogiqueDisciplineScientifiques);
			List<OutilPedagogiquePubliqueCible> outilPedagogiquePubliqueCibles = outilPedagogiquePubliqueCibleService
					.findByOutilPedagogiqueId(outilPedagogique.getId());
			outilPedagogique.setOutilPedagogiquePubliqueCibles(outilPedagogiquePubliqueCibles);
			List<TypeOutilPedagogique> typeOutilPedagogiques = typeOutilPedagogiqueService
					.findByOutilPedagogiqueId(outilPedagogique.getId());
			outilPedagogique.setTypeOutilPedagogiques(typeOutilPedagogiques);
			List<OutilPedagogiqueLangue> outilPedagogiqueLangues = outilPedagogiqueLangueService
					.findByOutilPedagogiqueId(outilPedagogique.getId());
			outilPedagogique.setOutilPedagogiqueLangues(outilPedagogiqueLangues);
			List<OutilPedagogiquePaysConception> outilPedagogiquePaysConceptions = outilPedagogiquePaysConceptionService
					.findByOutilPedagogiqueId(outilPedagogique.getId());
			outilPedagogique.setOutilPedagogiquePaysConceptions(outilPedagogiquePaysConceptions);
			List<OutilPedagogiquePaysDiffusion> outilPedagogiquePaysDiffusions = outilPedagogiquePaysDiffusionService
					.findByOutilPedagogiqueId(outilPedagogique.getId());
			outilPedagogique.setOutilPedagogiquePaysDiffusions(outilPedagogiquePaysDiffusions);
			List<OutilPedagogiqueInstrumentIrd> outilPedagogiqueInstrumentIrds = outilPedagogiqueInstrumentIrdService
					.findByOutilPedagogiqueId(outilPedagogique.getId());
			outilPedagogique.setOutilPedagogiqueInstrumentIrds(outilPedagogiqueInstrumentIrds);
			List<OutilPedagogiqueTypeInstrumentIrd> outilPedagogiqueTypeInstrumentIrds = outilPedagogiqueTypeInstrumentIrdService
					.findByOutilPedagogiqueId(outilPedagogique.getId());
			outilPedagogique.setOutilPedagogiqueTypeInstrumentIrds(outilPedagogiqueTypeInstrumentIrds);
			List<OutilPedagogiquePeriode> outilPedagogiquePeriodes=outilPedagogiquePeriodeService.findByOutilPedagogiqueId(outilPedagogique.getId());
			outilPedagogique.setOutilPedagogiquePeriodes(outilPedagogiquePeriodes);
		}
	}

	private void deleteAssociatedLists(Long id) {
		if (id == null)
			return;
		else {
			outilPedagogiqueEnjeuxIrdService.deleteByOutilPedagogiqueId(id);
			outilPedagogiqueDisciplineScientifiqueService.deleteByOutilPedagogiqueId(id);
			outilPedagogiquePubliqueCibleService.deleteByOutilPedagogiqueId(id);
			typeOutilPedagogiqueService.deleteByOutilPedagogiqueId(id);
			outilPedagogiqueLangueService.deleteByOutilPedagogiqueId(id);
			outilPedagogiquePaysConceptionService.deleteByOutilPedagogiqueId(id);
			outilPedagogiquePaysDiffusionService.deleteByOutilPedagogiqueId(id);
			outilPedagogiqueInstrumentIrdService.deleteByOutilPedagogiqueId(id);
			outilPedagogiqueTypeInstrumentIrdService.deleteByOutilPedagogiqueId(id);
			outilPedagogiquePeriodeService.deleteByOutilPedagogiqueId(id);
		}
	}

	private void updateAssociatedLists(OutilPedagogique outilPedagogique) {
		if (outilPedagogique == null || outilPedagogique.getId() == null)
			return;
		else {
			List<List<OutilPedagogiqueEnjeuxIrd>> resultOutilPedagogiqueEnjeuxIrds = outilPedagogiqueEnjeuxIrdService
					.getToBeSavedAndToBeDeleted(
							outilPedagogiqueEnjeuxIrdService.findByOutilPedagogiqueId(outilPedagogique.getId()),
							outilPedagogique.getOutilPedagogiqueEnjeuxIrds());
			outilPedagogiqueEnjeuxIrdService.delete(resultOutilPedagogiqueEnjeuxIrds.get(1));
			associateOutilPedagogiqueEnjeuxIrd(outilPedagogique, resultOutilPedagogiqueEnjeuxIrds.get(0));
			outilPedagogiqueEnjeuxIrdService.update(resultOutilPedagogiqueEnjeuxIrds.get(0));

			List<List<OutilPedagogiqueDisciplineScientifique>> resultOutilPedagogiqueDisciplineScientifiques = outilPedagogiqueDisciplineScientifiqueService
					.getToBeSavedAndToBeDeleted(
							outilPedagogiqueDisciplineScientifiqueService
									.findByOutilPedagogiqueId(outilPedagogique.getId()),
							outilPedagogique.getOutilPedagogiqueDisciplineScientifiques());
			outilPedagogiqueDisciplineScientifiqueService.delete(resultOutilPedagogiqueDisciplineScientifiques.get(1));
			associateOutilPedagogiqueDisciplineScientifique(outilPedagogique,
					resultOutilPedagogiqueDisciplineScientifiques.get(0));
			outilPedagogiqueDisciplineScientifiqueService.update(resultOutilPedagogiqueDisciplineScientifiques.get(0));

			List<List<OutilPedagogiquePubliqueCible>> resultOutilPedagogiquePubliqueCibles = outilPedagogiquePubliqueCibleService
					.getToBeSavedAndToBeDeleted(
							outilPedagogiquePubliqueCibleService.findByOutilPedagogiqueId(outilPedagogique.getId()),
							outilPedagogique.getOutilPedagogiquePubliqueCibles());
			outilPedagogiquePubliqueCibleService.delete(resultOutilPedagogiquePubliqueCibles.get(1));
			associateOutilPedagogiquePubliqueCible(outilPedagogique, resultOutilPedagogiquePubliqueCibles.get(0));
			outilPedagogiquePubliqueCibleService.update(resultOutilPedagogiquePubliqueCibles.get(0));

			List<List<TypeOutilPedagogique>> resultTypeOutilPedagogiques = typeOutilPedagogiqueService
					.getToBeSavedAndToBeDeleted(
							typeOutilPedagogiqueService.findByOutilPedagogiqueId(outilPedagogique.getId()),
							outilPedagogique.getTypeOutilPedagogiques());
			typeOutilPedagogiqueService.delete(resultTypeOutilPedagogiques.get(1));
			associateTypeOutilPedagogique(outilPedagogique, resultTypeOutilPedagogiques.get(0));
			typeOutilPedagogiqueService.update(resultTypeOutilPedagogiques.get(0));

			List<List<OutilPedagogiqueLangue>> resultOutilPedagogiqueLangues = outilPedagogiqueLangueService
					.getToBeSavedAndToBeDeleted(
							outilPedagogiqueLangueService.findByOutilPedagogiqueId(outilPedagogique.getId()),
							outilPedagogique.getOutilPedagogiqueLangues());
			outilPedagogiqueLangueService.delete(resultOutilPedagogiqueLangues.get(1));
			associateOutilPedagogiqueLangue(outilPedagogique, resultOutilPedagogiqueLangues.get(0));
			outilPedagogiqueLangueService.update(resultOutilPedagogiqueLangues.get(0));

			List<List<OutilPedagogiquePaysConception>> resultOutilPedagogiquePaysConceptions = outilPedagogiquePaysConceptionService
					.getToBeSavedAndToBeDeleted(
							outilPedagogiquePaysConceptionService.findByOutilPedagogiqueId(outilPedagogique.getId()),
							outilPedagogique.getOutilPedagogiquePaysConceptions());
			outilPedagogiquePaysConceptionService.delete(resultOutilPedagogiquePaysConceptions.get(1));
			associateOutilPedagogiquePaysConception(outilPedagogique, resultOutilPedagogiquePaysConceptions.get(0));
			outilPedagogiquePaysConceptionService.update(resultOutilPedagogiquePaysConceptions.get(0));

			List<List<OutilPedagogiquePaysDiffusion>> resultOutilPedagogiquePaysDiffusions = outilPedagogiquePaysDiffusionService
					.getToBeSavedAndToBeDeleted(
							outilPedagogiquePaysDiffusionService.findByOutilPedagogiqueId(outilPedagogique.getId()),
							outilPedagogique.getOutilPedagogiquePaysDiffusions());
			outilPedagogiquePaysDiffusionService.delete(resultOutilPedagogiquePaysDiffusions.get(1));
			associateOutilPedagogiquePaysDiffusion(outilPedagogique, resultOutilPedagogiquePaysDiffusions.get(0));
			outilPedagogiquePaysDiffusionService.update(resultOutilPedagogiquePaysDiffusions.get(0));

			List<List<OutilPedagogiqueInstrumentIrd>> resultOutilPedagogiqueInstrumentIrds = outilPedagogiqueInstrumentIrdService
					.getToBeSavedAndToBeDeleted(
							outilPedagogiqueInstrumentIrdService.findByOutilPedagogiqueId(outilPedagogique.getId()),
							outilPedagogique.getOutilPedagogiqueInstrumentIrds());
			outilPedagogiqueInstrumentIrdService.delete(resultOutilPedagogiqueInstrumentIrds.get(1));
			associateOutilPedagogiqueInstrumentIrd(outilPedagogique, resultOutilPedagogiqueInstrumentIrds.get(0));
			outilPedagogiqueInstrumentIrdService.update(resultOutilPedagogiqueInstrumentIrds.get(0));

			List<List<OutilPedagogiquePeriode>> resultOutilPedagogiquePeriodes = outilPedagogiquePeriodeService
					.getToBeSavedAndToBeDeleted(
							outilPedagogiquePeriodeService.findByOutilPedagogiqueId(outilPedagogique.getId()),
							outilPedagogique.getOutilPedagogiquePeriodes());
			outilPedagogiquePeriodeService.delete(resultOutilPedagogiquePeriodes.get(1));
			associateOutilPedagogiquePeriode(outilPedagogique, resultOutilPedagogiquePeriodes.get(0));
			outilPedagogiquePeriodeService.update(resultOutilPedagogiquePeriodes.get(0));

			List<List<OutilPedagogiqueTypeInstrumentIrd>> resultOutilPedagogiqueTypeInstrumentIrds = outilPedagogiqueTypeInstrumentIrdService
					.getToBeSavedAndToBeDeleted(
							outilPedagogiqueTypeInstrumentIrdService.findByOutilPedagogiqueId(outilPedagogique.getId()),
							outilPedagogique.getOutilPedagogiqueTypeInstrumentIrds());
			outilPedagogiqueTypeInstrumentIrdService.delete(resultOutilPedagogiqueTypeInstrumentIrds.get(1));
			associateOutilPedagogiqueTypeInstrumentIrd(outilPedagogique,
					resultOutilPedagogiqueTypeInstrumentIrds.get(0));
			outilPedagogiqueTypeInstrumentIrdService.update(resultOutilPedagogiqueTypeInstrumentIrds.get(0));

		}
	}

	@Transactional
	public int deleteById(Long id) {
		if (outilPedagogiqueDao.findById(id) == null)
			return 0;
		else {
			deleteAssociatedLists(id);
			outilPedagogiqueDao.deleteById(id);
			return 1;
		}
	}

	@Override
	public OutilPedagogique update(OutilPedagogique outilPedagogique) {
		OutilPedagogique foundedOutilPedagogique = findById(outilPedagogique.getId());
		if (foundedOutilPedagogique == null)
			return null;
		else {
			updateAssociatedLists(outilPedagogique);
			return outilPedagogiqueDao.save(outilPedagogique);
		}
	}

	@Override
	public OutilPedagogique save(OutilPedagogique outilPedagogique) {

		findCultureScientifique(outilPedagogique);
		findEtatEtapeCampagne(outilPedagogique);

		OutilPedagogique savedOutilPedagogique = outilPedagogiqueDao.save(outilPedagogique);
		saveOutilPedagogiqueEnjeuxIrds(savedOutilPedagogique, outilPedagogique.getOutilPedagogiqueEnjeuxIrds());
		saveOutilPedagogiqueDisciplineScientifiques(savedOutilPedagogique,
				outilPedagogique.getOutilPedagogiqueDisciplineScientifiques());
		saveOutilPedagogiquePubliqueCibles(savedOutilPedagogique, outilPedagogique.getOutilPedagogiquePubliqueCibles());
		saveTypeOutilPedagogiques(savedOutilPedagogique, outilPedagogique.getTypeOutilPedagogiques());
		saveOutilPedagogiqueLangues(savedOutilPedagogique, outilPedagogique.getOutilPedagogiqueLangues());
		saveOutilPedagogiquePaysConceptions(savedOutilPedagogique,
				outilPedagogique.getOutilPedagogiquePaysConceptions());
		saveOutilPedagogiquePaysDiffusions(savedOutilPedagogique, outilPedagogique.getOutilPedagogiquePaysDiffusions());
		saveOutilPedagogiqueInstrumentIrds(savedOutilPedagogique, outilPedagogique.getOutilPedagogiqueInstrumentIrds());
		saveOutilPedagogiqueTypeInstrumentIrds(savedOutilPedagogique,
				outilPedagogique.getOutilPedagogiqueTypeInstrumentIrds());
		saveOutilPedagogiquePeriode(savedOutilPedagogique, outilPedagogique.getOutilPedagogiquePeriodes());
		return savedOutilPedagogique;
	}

	@Override
	public List<OutilPedagogique> save(List<OutilPedagogique> outilPedagogiques) {
		List<OutilPedagogique> list = new ArrayList<OutilPedagogique>();
		for (OutilPedagogique outilPedagogique : outilPedagogiques) {
			list.add(save(outilPedagogique));
		}
		return list;
	}

	@Override
	@Transactional
	public int delete(OutilPedagogique outilPedagogique) {
		if (outilPedagogique.getId() == null)
			return -1;
		OutilPedagogique foundedOutilPedagogique = findById(outilPedagogique.getId());
		if (foundedOutilPedagogique == null)
			return -1;
		outilPedagogiqueDao.delete(foundedOutilPedagogique);
		return 1;
	}

	public List<OutilPedagogique> findByCriteria(OutilPedagogiqueVo outilPedagogiqueVo) {

		String query = "SELECT o FROM OutilPedagogique o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", outilPedagogiqueVo.getId());
		query += SearchUtil.addConstraint("o", "nom", "LIKE", outilPedagogiqueVo.getNom());
		query += SearchUtil.addConstraint("o", "roleOutilPedagogique", "LIKE",
				outilPedagogiqueVo.getRoleOutilPedagogique());
		query += SearchUtil.addConstraintDate("o", "dateDiffusion", "=", outilPedagogiqueVo.getDateDiffusion());
		query += SearchUtil.addConstraint("o", "disponnibleNumerique", "=",
				outilPedagogiqueVo.getDisponnibleNumerique());
		query += SearchUtil.addConstraint("o", "lienWeb", "LIKE", outilPedagogiqueVo.getLienWeb());
		query += SearchUtil.addConstraint("o", "lienInstrumentIrd", "=", outilPedagogiqueVo.getLienInstrumentIrd());
		query += SearchUtil.addConstraint("o", "partenaireEventuel", "LIKE",
				outilPedagogiqueVo.getPartenaireEventuel());
		query += SearchUtil.addConstraint("o", "remarque", "LIKE", outilPedagogiqueVo.getRemarque());
		query += SearchUtil.addConstraintMinMaxDate("o", "dateDiffusion", outilPedagogiqueVo.getDateDiffusionMin(),
				outilPedagogiqueVo.getDateDiffusionMax());
		if (outilPedagogiqueVo.getCultureScientifiqueVo() != null) {
			query += SearchUtil.addConstraint("o", "cultureScientifique.id", "=",
					outilPedagogiqueVo.getCultureScientifiqueVo().getId());
		}

		if (outilPedagogiqueVo.getEtatEtapeCampagneVo() != null) {
			query += SearchUtil.addConstraint("o", "etatEtapeCampagne.id", "=",
					outilPedagogiqueVo.getEtatEtapeCampagneVo().getId());
			query += SearchUtil.addConstraint("o", "etatEtapeCampagne.code", "LIKE",
					outilPedagogiqueVo.getEtatEtapeCampagneVo().getCode());
		}

		return entityManager.createQuery(query).getResultList();
	}

	private void saveOutilPedagogiqueEnjeuxIrds(OutilPedagogique outilPedagogique,
			List<OutilPedagogiqueEnjeuxIrd> outilPedagogiqueEnjeuxIrds) {

		if (ListUtil.isNotEmpty(outilPedagogique.getOutilPedagogiqueEnjeuxIrds())) {
			List<OutilPedagogiqueEnjeuxIrd> savedOutilPedagogiqueEnjeuxIrds = new ArrayList<>();
			outilPedagogiqueEnjeuxIrds.forEach(element -> {
				element.setOutilPedagogique(outilPedagogique);
				outilPedagogiqueEnjeuxIrdService.save(element);
			});
			outilPedagogique.setOutilPedagogiqueEnjeuxIrds(savedOutilPedagogiqueEnjeuxIrds);
		}
	}

	private void saveOutilPedagogiqueDisciplineScientifiques(OutilPedagogique outilPedagogique,
			List<OutilPedagogiqueDisciplineScientifique> outilPedagogiqueDisciplineScientifiques) {

		if (ListUtil.isNotEmpty(outilPedagogique.getOutilPedagogiqueDisciplineScientifiques())) {
			List<OutilPedagogiqueDisciplineScientifique> savedOutilPedagogiqueDisciplineScientifiques = new ArrayList<>();
			outilPedagogiqueDisciplineScientifiques.forEach(element -> {
				element.setOutilPedagogique(outilPedagogique);
				outilPedagogiqueDisciplineScientifiqueService.save(element);
			});
			outilPedagogique.setOutilPedagogiqueDisciplineScientifiques(savedOutilPedagogiqueDisciplineScientifiques);
		}
	}

	private void saveOutilPedagogiquePubliqueCibles(OutilPedagogique outilPedagogique,
			List<OutilPedagogiquePubliqueCible> outilPedagogiquePubliqueCibles) {

		if (ListUtil.isNotEmpty(outilPedagogique.getOutilPedagogiquePubliqueCibles())) {
			List<OutilPedagogiquePubliqueCible> savedOutilPedagogiquePubliqueCibles = new ArrayList<>();
			outilPedagogiquePubliqueCibles.forEach(element -> {
				element.setOutilPedagogique(outilPedagogique);
				outilPedagogiquePubliqueCibleService.save(element);
			});
			outilPedagogique.setOutilPedagogiquePubliqueCibles(savedOutilPedagogiquePubliqueCibles);
		}
	}

	private void saveTypeOutilPedagogiques(OutilPedagogique outilPedagogique,
			List<TypeOutilPedagogique> typeOutilPedagogiques) {

		if (ListUtil.isNotEmpty(outilPedagogique.getTypeOutilPedagogiques())) {
			List<TypeOutilPedagogique> savedTypeOutilPedagogiques = new ArrayList<>();
			typeOutilPedagogiques.forEach(element -> {
				element.setOutilPedagogique(outilPedagogique);
				typeOutilPedagogiqueService.save(element);
			});
			outilPedagogique.setTypeOutilPedagogiques(savedTypeOutilPedagogiques);
		}
	}

	private void saveOutilPedagogiqueLangues(OutilPedagogique outilPedagogique,
			List<OutilPedagogiqueLangue> outilPedagogiqueLangues) {

		if (ListUtil.isNotEmpty(outilPedagogique.getOutilPedagogiqueLangues())) {
			List<OutilPedagogiqueLangue> savedOutilPedagogiqueLangues = new ArrayList<>();
			outilPedagogiqueLangues.forEach(element -> {
				element.setOutilPedagogique(outilPedagogique);
				outilPedagogiqueLangueService.save(element);
			});
			outilPedagogique.setOutilPedagogiqueLangues(savedOutilPedagogiqueLangues);
		}
	}

	private void saveOutilPedagogiquePaysConceptions(OutilPedagogique outilPedagogique,
			List<OutilPedagogiquePaysConception> outilPedagogiquePaysConceptions) {

		if (ListUtil.isNotEmpty(outilPedagogique.getOutilPedagogiquePaysConceptions())) {
			List<OutilPedagogiquePaysConception> savedOutilPedagogiquePaysConceptions = new ArrayList<>();
			outilPedagogiquePaysConceptions.forEach(element -> {
				element.setOutilPedagogique(outilPedagogique);
				outilPedagogiquePaysConceptionService.save(element);
			});
			outilPedagogique.setOutilPedagogiquePaysConceptions(savedOutilPedagogiquePaysConceptions);
		}
	}

	private void saveOutilPedagogiquePaysDiffusions(OutilPedagogique outilPedagogique,
			List<OutilPedagogiquePaysDiffusion> outilPedagogiquePaysDiffusions) {

		if (ListUtil.isNotEmpty(outilPedagogique.getOutilPedagogiquePaysDiffusions())) {
			List<OutilPedagogiquePaysDiffusion> savedOutilPedagogiquePaysDiffusions = new ArrayList<>();
			outilPedagogiquePaysDiffusions.forEach(element -> {
				element.setOutilPedagogique(outilPedagogique);
				outilPedagogiquePaysDiffusionService.save(element);
			});
			outilPedagogique.setOutilPedagogiquePaysDiffusions(savedOutilPedagogiquePaysDiffusions);
		}
	}

	private void saveOutilPedagogiqueInstrumentIrds(OutilPedagogique outilPedagogique,
			List<OutilPedagogiqueInstrumentIrd> outilPedagogiqueInstrumentIrds) {

		if (ListUtil.isNotEmpty(outilPedagogique.getOutilPedagogiqueInstrumentIrds())) {
			List<OutilPedagogiqueInstrumentIrd> savedOutilPedagogiqueInstrumentIrds = new ArrayList<>();
			outilPedagogiqueInstrumentIrds.forEach(element -> {
				element.setOutilPedagogique(outilPedagogique);
				outilPedagogiqueInstrumentIrdService.save(element);
			});
			outilPedagogique.setOutilPedagogiqueInstrumentIrds(savedOutilPedagogiqueInstrumentIrds);
		}
	}

	private void saveOutilPedagogiqueTypeInstrumentIrds(OutilPedagogique outilPedagogique,
			List<OutilPedagogiqueTypeInstrumentIrd> outilPedagogiqueTypeInstrumentIrds) {

		if (ListUtil.isNotEmpty(outilPedagogique.getOutilPedagogiqueTypeInstrumentIrds())) {
			List<OutilPedagogiqueTypeInstrumentIrd> savedOutilPedagogiqueTypeInstrumentIrds = new ArrayList<>();
			outilPedagogiqueTypeInstrumentIrds.forEach(element -> {
				element.setOutilPedagogique(outilPedagogique);
				outilPedagogiqueTypeInstrumentIrdService.save(element);
			});
			outilPedagogique.setOutilPedagogiqueTypeInstrumentIrds(savedOutilPedagogiqueTypeInstrumentIrds);
		}
	}

	private void saveOutilPedagogiquePeriode(OutilPedagogique outilPedagogique,
			List<OutilPedagogiquePeriode> outilPedagogiquePeriodes) {

		if (ListUtil.isNotEmpty(outilPedagogique.getOutilPedagogiquePeriodes())) {
			List<OutilPedagogiquePeriode> savedOutilPedagogiquePeriodes = new ArrayList<>();
			outilPedagogiquePeriodes.forEach(element -> {
				element.setOutilPedagogique(outilPedagogique);
				outilPedagogiquePeriodeService.save(element);
			});
			outilPedagogique.setOutilPedagogiquePeriodes(savedOutilPedagogiquePeriodes);
		}
	}

	private void findCultureScientifique(OutilPedagogique outilPedagogique) {
		CultureScientifique loadedCultureScientifique = null;
		if (outilPedagogique.getCultureScientifique() != null
				&& outilPedagogique.getCultureScientifique().getId() != null)
			loadedCultureScientifique = cultureScientifiqueService
					.findById(outilPedagogique.getCultureScientifique().getId());

		if (loadedCultureScientifique == null) {
			return;
		}
		outilPedagogique.setCultureScientifique(loadedCultureScientifique);
	}

	private void findEtatEtapeCampagne(OutilPedagogique outilPedagogique) {
		EtatEtapeCampagne loadedEtatEtapeCampagne = etatEtapeCampagneService
				.findByIdOrCode(outilPedagogique.getEtatEtapeCampagne());

		if (loadedEtatEtapeCampagne == null) {
			return;
		}
		outilPedagogique.setEtatEtapeCampagne(loadedEtatEtapeCampagne);
	}

	@Override
	@Transactional
	public void delete(List<OutilPedagogique> outilPedagogiques) {
		if (ListUtil.isNotEmpty(outilPedagogiques)) {
			outilPedagogiques.forEach(e -> deleteById(e.getId()));
		}
	}

	@Override
	public void update(List<OutilPedagogique> outilPedagogiques) {
		if (ListUtil.isNotEmpty(outilPedagogiques)) {
			outilPedagogiques.forEach(e ->{
				if(e.getId()!=null) {
					update(e);
				}else {
					save(e);
				}
			} );
		}
	}

	private void associateOutilPedagogiqueEnjeuxIrd(OutilPedagogique outilPedagogique,
			List<OutilPedagogiqueEnjeuxIrd> outilPedagogiqueEnjeuxIrd) {
		if (ListUtil.isNotEmpty(outilPedagogiqueEnjeuxIrd)) {
			outilPedagogiqueEnjeuxIrd.forEach(e -> e.setOutilPedagogique(outilPedagogique));
		}
	}

	private void associateOutilPedagogiqueDisciplineScientifique(OutilPedagogique outilPedagogique,
			List<OutilPedagogiqueDisciplineScientifique> outilPedagogiqueDisciplineScientifique) {
		if (ListUtil.isNotEmpty(outilPedagogiqueDisciplineScientifique)) {
			outilPedagogiqueDisciplineScientifique.forEach(e -> e.setOutilPedagogique(outilPedagogique));
		}
	}

	private void associateOutilPedagogiquePubliqueCible(OutilPedagogique outilPedagogique,
			List<OutilPedagogiquePubliqueCible> outilPedagogiquePubliqueCible) {
		if (ListUtil.isNotEmpty(outilPedagogiquePubliqueCible)) {
			outilPedagogiquePubliqueCible.forEach(e -> e.setOutilPedagogique(outilPedagogique));
		}
	}

	private void associateTypeOutilPedagogique(OutilPedagogique outilPedagogique,
			List<TypeOutilPedagogique> typeOutilPedagogique) {
		if (ListUtil.isNotEmpty(typeOutilPedagogique)) {
			typeOutilPedagogique.forEach(e -> e.setOutilPedagogique(outilPedagogique));
		}
	}

	private void associateOutilPedagogiqueLangue(OutilPedagogique outilPedagogique,
			List<OutilPedagogiqueLangue> outilPedagogiqueLangue) {
		if (ListUtil.isNotEmpty(outilPedagogiqueLangue)) {
			outilPedagogiqueLangue.forEach(e -> e.setOutilPedagogique(outilPedagogique));
		}
	}

	private void associateOutilPedagogiquePaysConception(OutilPedagogique outilPedagogique,
			List<OutilPedagogiquePaysConception> outilPedagogiquePaysConception) {
		if (ListUtil.isNotEmpty(outilPedagogiquePaysConception)) {
			outilPedagogiquePaysConception.forEach(e -> e.setOutilPedagogique(outilPedagogique));
		}
	}

	private void associateOutilPedagogiquePaysDiffusion(OutilPedagogique outilPedagogique,
			List<OutilPedagogiquePaysDiffusion> outilPedagogiquePaysDiffusion) {
		if (ListUtil.isNotEmpty(outilPedagogiquePaysDiffusion)) {
			outilPedagogiquePaysDiffusion.forEach(e -> e.setOutilPedagogique(outilPedagogique));
		}
	}

	private void associateOutilPedagogiqueInstrumentIrd(OutilPedagogique outilPedagogique,
			List<OutilPedagogiqueInstrumentIrd> outilPedagogiqueInstrumentIrd) {
		if (ListUtil.isNotEmpty(outilPedagogiqueInstrumentIrd)) {
			outilPedagogiqueInstrumentIrd.forEach(e -> e.setOutilPedagogique(outilPedagogique));
		}
	}

	private void associateOutilPedagogiqueTypeInstrumentIrd(OutilPedagogique outilPedagogique,
			List<OutilPedagogiqueTypeInstrumentIrd> outilPedagogiqueTypeInstrumentIrd) {
		if (ListUtil.isNotEmpty(outilPedagogiqueTypeInstrumentIrd)) {
			outilPedagogiqueTypeInstrumentIrd.forEach(e -> e.setOutilPedagogique(outilPedagogique));
		}
	}

	private void associateOutilPedagogiquePeriode(OutilPedagogique outilPedagogique,
			List<OutilPedagogiquePeriode> outilPedagogiquePeriodes) {
		if (ListUtil.isNotEmpty(outilPedagogiquePeriodes)) {
			outilPedagogiquePeriodes.forEach(e -> e.setOutilPedagogique(outilPedagogique));
		}
	}

	@Override
	public List<List<OutilPedagogique>> getToBeSavedAndToBeDeleted(List<OutilPedagogique> oldList,
			List<OutilPedagogique> newList) {
		return super.getToBeSavedAndToBeDeleted(oldList, newList);
	}

}

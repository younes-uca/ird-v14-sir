package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.formulaire.Campagne;
import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.bean.config.EtatEtapeCampagne;
import com.ird.faa.bean.formulaire.GestionEquipe;
import com.ird.faa.bean.formulaire.GestionEquipeDetail;
import com.ird.faa.dao.formulaire.GestionEquipeDao;
import com.ird.faa.security.bean.User;
import com.ird.faa.security.common.SecurityUtil;
import com.ird.faa.service.chercheur.facade.formulaire.CampagneChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.ChercheurChercheurService;
import com.ird.faa.service.chercheur.facade.config.EtatEtapeCampagneChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.GestionEquipeChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.GestionEquipeDetailChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.GestionEquipeVo;

@Service
public class GestionEquipeChercheurServiceImpl extends AbstractServiceImpl<GestionEquipe> implements GestionEquipeChercheurService {

	
	String  etat = null;
@Autowired
private GestionEquipeDao gestionEquipeDao;

@Autowired
private EtatEtapeCampagneChercheurService etatEtapeCampagneChercheurService;

        @Autowired
        private EtatEtapeCampagneChercheurService etatEtapeCampagneService ;
        @Autowired
	private GestionEquipeDetailChercheurService gestionEquipeDetailService;
	@Autowired
        private CampagneChercheurService campagneService ;
        @Autowired
        private ChercheurChercheurService chercheurService ;


@Autowired
private EntityManager entityManager;


@Override
public List<GestionEquipe> findAll(){
User currentUser = SecurityUtil.getCurrentUser();
if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
    return gestionEquipeDao.findByChercheurUsername(currentUser.getUsername());
    }
    return new ArrayList<>();
}

        @Override
        public List<GestionEquipe> findByChercheurNumeroMatricule(String numeroMatricule){
        return gestionEquipeDao.findByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByChercheurNumeroMatricule(String numeroMatricule){
        return gestionEquipeDao.deleteByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<GestionEquipe> findByChercheurId(Long id){
        return gestionEquipeDao.findByChercheurId(id);
        }

        @Override
        @Transactional
        public int deleteByChercheurId(Long id){
        return gestionEquipeDao.deleteByChercheurId(id);
        }


        @Override
        public List<GestionEquipe> findByCampagneCode(String code){
        return gestionEquipeDao.findByCampagneCode(code);
        }

        @Override
        @Transactional
        public int deleteByCampagneCode(String code){
        return gestionEquipeDao.deleteByCampagneCode(code);
        }

        @Override
        public List<GestionEquipe> findByCampagneId(Long id){
        return gestionEquipeDao.findByCampagneId(id);
        }

        @Override
        @Transactional
        public int deleteByCampagneId(Long id){
        return gestionEquipeDao.deleteByCampagneId(id);
        }


        @Override
        public List<GestionEquipe> findByEtatEtapeCampagneCode(String code){
        return gestionEquipeDao.findByEtatEtapeCampagneCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtatEtapeCampagneCode(String code){
        return gestionEquipeDao.deleteByEtatEtapeCampagneCode(code);
        }

        @Override
        public List<GestionEquipe> findByEtatEtapeCampagneId(Long id){
        return gestionEquipeDao.findByEtatEtapeCampagneId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatEtapeCampagneId(Long id){
        return gestionEquipeDao.deleteByEtatEtapeCampagneId(id);
        }


@Override
public GestionEquipe findById(Long id){
if(id==null) return null;
return gestionEquipeDao.getOne(id);
}

@Override
public GestionEquipe findByIdWithAssociatedList(Long id){
GestionEquipe gestionEquipe  = findById(id);
		findAssociatedLists(gestionEquipe);
return gestionEquipe;
}

	private void findAssociatedLists(GestionEquipe gestionEquipe) {
		if (gestionEquipe == null || gestionEquipe.getId() == null)
			return;
		else {
			List<GestionEquipeDetail> gestionEquipeDetails = gestionEquipeDetailService
					.findByGestionEquipeId(gestionEquipe.getId());
			gestionEquipe.setGestionEquipeDetails(gestionEquipeDetails);
		}
	}

	private void deleteAssociatedLists(Long id) {
		if (id == null)
			return;
		else {
			gestionEquipeDetailService.deleteByGestionEquipeId(id);
		}
	}

	private void updateAssociatedLists(GestionEquipe gestionEquipe) {
		if (gestionEquipe == null || gestionEquipe.getId() == null)
			return;
		else {
			List<List<GestionEquipeDetail>> resultGestionEquipeDetails = gestionEquipeDetailService
					.getToBeSavedAndToBeDeleted(gestionEquipeDetailService.findByGestionEquipeId(gestionEquipe.getId()),
							gestionEquipe.getGestionEquipeDetails());
			gestionEquipeDetailService.delete(resultGestionEquipeDetails.get(1));
			associateGestionEquipeDetail(gestionEquipe, resultGestionEquipeDetails.get(0));
			gestionEquipeDetailService.update(resultGestionEquipeDetails.get(0));

		}
	}

@Transactional
public int deleteById(Long id){
if(gestionEquipeDao.findById(id) == null) return 0;
else{
			deleteAssociatedLists(id);
gestionEquipeDao.deleteById(id);
return 1;
}
}


@Override
public GestionEquipe update(GestionEquipe gestionEquipe){
GestionEquipe foundedGestionEquipe = findById(gestionEquipe.getId());
if(foundedGestionEquipe==null) return null;
else{
			updateAssociatedLists(gestionEquipe);
return  gestionEquipeDao.save(gestionEquipe);
}
}

	@Override
	public GestionEquipe save(GestionEquipe gestionEquipe) {

		GestionEquipe resultat = new GestionEquipe();

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
			gestionEquipe.setChercheur(loadedChercheur);
			gestionEquipe.setCampagne(laodedCampagne);

			findChercheur(gestionEquipe);
			findCampagne(gestionEquipe);
			findEtatEtapeCampagne(gestionEquipe);
			
			
			String etatGestionEquipe=etatEncadrementEquipe(gestionEquipe.getGestionEquipeDetails());
			if(etatGestionEquipe!=null) {
				EtatEtapeCampagne etapeCampagne = etatEtapeCampagneChercheurService.findByCode(etatGestionEquipe);	
			    gestionEquipe.setEtatEtapeCampagne(etapeCampagne);
			}
			
			GestionEquipe savedGestionEquipe = gestionEquipeDao.save(gestionEquipe);
			saveGestionEquipeDetails(savedGestionEquipe, gestionEquipe.getGestionEquipeDetails());
			findAssociatedLists(savedGestionEquipe);
			return savedGestionEquipe;
		}
	}

	private String etatEncadrementEquipe(List<GestionEquipeDetail> gestionEquipeDetails) {
		
		if(gestionEquipeDetails!=null) {
			etat="termine";
			gestionEquipeDetails.forEach(element -> {
				if(element.getEtatEtapeCampagne().getCode().equals("encours")) {
					etat="encours";
				   
				}});
		}
		
		return etat;
	}
@Override
public List<GestionEquipe> save(List<GestionEquipe> gestionEquipes){
List<GestionEquipe> list = new ArrayList<GestionEquipe>();
for(GestionEquipe gestionEquipe: gestionEquipes){
list.add(save(gestionEquipe));
}
return list;
}



@Override
@Transactional
public int delete(GestionEquipe gestionEquipe){
		if (gestionEquipe.getId() == null)
			return -1;
		GestionEquipe foundedGestionEquipe = findById(gestionEquipe.getId());
    if(foundedGestionEquipe==null) return -1;
gestionEquipeDao.delete(foundedGestionEquipe);
return 1;
}


public List<GestionEquipe> findByCriteria(GestionEquipeVo gestionEquipeVo){
User currentUser = SecurityUtil.getCurrentUser();
if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())) {

String query = "SELECT o FROM GestionEquipe o where 1=1 ";
    query += SearchUtil.addConstraint("o", "chercheur.username", "=", currentUser.getUsername());

            query += SearchUtil.addConstraint( "o", "id","=",gestionEquipeVo.getId());
            query += SearchUtil.addConstraint( "o", "tempsEstimePourCetteAnnne","=",gestionEquipeVo.getTempsEstimePourCetteAnnne());
            query += SearchUtil.addConstraintMinMax("o","tempsEstimePourCetteAnnne",gestionEquipeVo.getTempsEstimePourCetteAnnneMin(),gestionEquipeVo.getTempsEstimePourCetteAnnneMax());
    if(gestionEquipeVo.getChercheurVo()!=null){
        query += SearchUtil.addConstraint( "o", "chercheur.id","=",gestionEquipeVo.getChercheurVo().getId());
            query += SearchUtil.addConstraint( "o", "chercheur.numeroMatricule","LIKE",gestionEquipeVo.getChercheurVo().getNumeroMatricule());
    }

    if(gestionEquipeVo.getCampagneVo()!=null){
        query += SearchUtil.addConstraint( "o", "campagne.id","=",gestionEquipeVo.getCampagneVo().getId());
            query += SearchUtil.addConstraint( "o", "campagne.code","LIKE",gestionEquipeVo.getCampagneVo().getCode());
    }

    if(gestionEquipeVo.getEtatEtapeCampagneVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatEtapeCampagne.id","=",gestionEquipeVo.getEtatEtapeCampagneVo().getId());
            query += SearchUtil.addConstraint( "o", "etatEtapeCampagne.code","LIKE",gestionEquipeVo.getEtatEtapeCampagneVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}
return new ArrayList<>();
}

	private void saveGestionEquipeDetails(GestionEquipe gestionEquipe, List<GestionEquipeDetail> gestionEquipeDetails) {

		
		if (ListUtil.isNotEmpty(gestionEquipe.getGestionEquipeDetails())) {
			
			List<GestionEquipeDetail> savedGestionEquipeDetails = new ArrayList<>();
			gestionEquipeDetails.forEach(element -> {
				if(!element.getEtatEtapeCampagne().getCode().equals("")) {
				    EtatEtapeCampagne etapeCampagne = etatEtapeCampagneChercheurService.findByCode(element.getEtatEtapeCampagne().getCode());	
					element.setEtatEtapeCampagne(etapeCampagne);
				}
				element.setGestionEquipe(gestionEquipe);
				gestionEquipeDetailService.save(element);
			});
			gestionEquipe.setGestionEquipeDetails(savedGestionEquipeDetails);
		}
	}

    private void findChercheur(GestionEquipe gestionEquipe){
        Chercheur loadedChercheur =chercheurService.findByIdOrNumeroMatricule(gestionEquipe.getChercheur());

    if(loadedChercheur==null ) {
        return;
    }
    gestionEquipe.setChercheur(loadedChercheur);
    }
    private void findCampagne(GestionEquipe gestionEquipe){
        Campagne loadedCampagne =campagneService.findByIdOrCode(gestionEquipe.getCampagne());

    if(loadedCampagne==null ) {
        return;
    }
    gestionEquipe.setCampagne(loadedCampagne);
    }
    private void findEtatEtapeCampagne(GestionEquipe gestionEquipe){
        EtatEtapeCampagne loadedEtatEtapeCampagne =etatEtapeCampagneService.findByIdOrCode(gestionEquipe.getEtatEtapeCampagne());

    if(loadedEtatEtapeCampagne==null ) {
        return;
    }
    gestionEquipe.setEtatEtapeCampagne(loadedEtatEtapeCampagne);
    }

@Override
@Transactional
public void delete(List<GestionEquipe> gestionEquipes){
        if(ListUtil.isNotEmpty(gestionEquipes)){
        gestionEquipes.forEach(e->gestionEquipeDao.delete(e));
        }
}
@Override
public void update(List<GestionEquipe> gestionEquipes){
if(ListUtil.isNotEmpty(gestionEquipes)){
gestionEquipes.forEach(e->gestionEquipeDao.save(e));
}
}

	private void associateGestionEquipeDetail(GestionEquipe gestionEquipe,
			List<GestionEquipeDetail> gestionEquipeDetail) {
		if (ListUtil.isNotEmpty(gestionEquipeDetail)) {
			gestionEquipeDetail.forEach(e -> e.setGestionEquipe(gestionEquipe));
		}
	}

@Override
public List<GestionEquipe> findByChercheurUsernameAndCampagneId(String username, Long compagneId){
List<GestionEquipe> resultat= gestionEquipeDao.findByChercheurUsernameAndCampagneId(username, compagneId);
    return resultat;
}

@Override
public List<List<GestionEquipe>>  getToBeSavedAndToBeDeleted(List<GestionEquipe> oldList,List<GestionEquipe> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

@Override
public List<GestionEquipe> findAllByOrderByAnneeDesc() {
	
	return gestionEquipeDao.findAllByOrderByAnneeDesc();
}



}

package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.security.common.SecurityUtil;
import com.ird.faa.security.bean.User;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.Encadrement;
import com.ird.faa.bean.formulaire.Campagne;
import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.bean.config.EtatEtapeCampagne;
import com.ird.faa.dao.formulaire.EncadrementDao;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementEtudiantChercheurService;
import com.ird.faa.service.chercheur.facade.config.EtatEtapeCampagneChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementDoctorantChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.CampagneChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.ChercheurChercheurService;

import com.ird.faa.ws.rest.provided.vo.EncadrementVo;
import com.ird.faa.service.util.*;
import com.ird.faa.bean.formulaire.EncadrementEtudiant;
import com.ird.faa.bean.formulaire.EncadrementDoctorant;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EncadrementChercheurServiceImpl extends AbstractServiceImpl<Encadrement> implements EncadrementChercheurService {
	String  etat = null;
@Autowired
private EncadrementDao encadrementDao;

        @Autowired
        private EncadrementEtudiantChercheurService encadrementEtudiantService ;
        @Autowired
        private EtatEtapeCampagneChercheurService etatEtapeCampagneService ;
        @Autowired
        private EncadrementDoctorantChercheurService encadrementDoctorantService ;
        @Autowired
        private CampagneChercheurService campagneService ;
        @Autowired
        private ChercheurChercheurService chercheurService ;
        
        @Autowired
        private EtatEtapeCampagneChercheurService etatEtapeCampagneChercheurService;


@Autowired
private EntityManager entityManager;


@Override
public List<Encadrement> findAll(){
User currentUser = SecurityUtil.getCurrentUser();
if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
    return encadrementDao.findByChercheurUsername(currentUser.getUsername());
    }
    return new ArrayList<>();
}

        @Override
        public List<Encadrement> findByCampagneCode(String code){
        return encadrementDao.findByCampagneCode(code);
        }

        @Override
        @Transactional
        public int deleteByCampagneCode(String code){
        return encadrementDao.deleteByCampagneCode(code);
        }

        @Override
        public List<Encadrement> findByCampagneId(Long id){
        return encadrementDao.findByCampagneId(id);
        }

        @Override
        @Transactional
        public int deleteByCampagneId(Long id){
        return encadrementDao.deleteByCampagneId(id);
        }


        @Override
        public List<Encadrement> findByChercheurNumeroMatricule(String numeroMatricule){
        return encadrementDao.findByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByChercheurNumeroMatricule(String numeroMatricule){
        return encadrementDao.deleteByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<Encadrement> findByChercheurId(Long id){
        return encadrementDao.findByChercheurId(id);
        }

        @Override
        @Transactional
        public int deleteByChercheurId(Long id){
        return encadrementDao.deleteByChercheurId(id);
        }


        @Override
        public List<Encadrement> findByEtatEtapeCampagneCode(String code){
        return encadrementDao.findByEtatEtapeCampagneCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtatEtapeCampagneCode(String code){
        return encadrementDao.deleteByEtatEtapeCampagneCode(code);
        }

        @Override
        public List<Encadrement> findByEtatEtapeCampagneId(Long id){
        return encadrementDao.findByEtatEtapeCampagneId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatEtapeCampagneId(Long id){
        return encadrementDao.deleteByEtatEtapeCampagneId(id);
        }


@Override
public Encadrement findById(Long id){
if(id==null) return null;
return encadrementDao.getOne(id);
}

@Override
public Encadrement findByIdWithAssociatedList(Long id){
Encadrement encadrement  = findById(id);
    findAssociatedLists(encadrement);
return encadrement;
}
private void findAssociatedLists(Encadrement encadrement){
if(encadrement==null || encadrement.getId()==null) return ;
else{
        List<EncadrementEtudiant> encadrementEtudiants = encadrementEtudiantService.findByEncadrementId(encadrement.getId());
        encadrement.setEncadrementEtudiants(encadrementEtudiants);
        List<EncadrementDoctorant> encadrementDoctorants = encadrementDoctorantService.findByEncadrementId(encadrement.getId());
        encadrement.setEncadrementDoctorants(encadrementDoctorants);
}
}
private void deleteAssociatedLists(Long id){
if(id==null ) return ;
else{
	List<EncadrementEtudiant> encadrementEtudiants= encadrementEtudiantService.findByEncadrementId(id);
	List<EncadrementDoctorant> encadrementDoctorants = encadrementDoctorantService.findByEncadrementId(id);
	if(!encadrementEtudiants.isEmpty()) {
		
		encadrementEtudiants.forEach(encadrementEtudiant-> {
			encadrementEtudiantService.deleteById(encadrementEtudiant.getId());
			
		});
		
		
	}
	if(!encadrementDoctorants.isEmpty()) {
		encadrementDoctorants.forEach(encadrementDoctorant-> {
			encadrementDoctorantService.deleteById(encadrementDoctorant.getId());
			
		});
		
	}
}
}

    private void updateAssociatedLists(Encadrement encadrement){
    if(encadrement==null || encadrement.getId()==null) return ;
    else{
            List<List<EncadrementEtudiant>> resultEncadrementEtudiants= encadrementEtudiantService.getToBeSavedAndToBeDeleted(encadrementEtudiantService.findByEncadrementId(encadrement.getId()),encadrement.getEncadrementEtudiants());
            encadrementEtudiantService.delete(resultEncadrementEtudiants.get(1));
            associateEncadrementEtudiant(encadrement,resultEncadrementEtudiants.get(0));
            encadrementEtudiantService.update(resultEncadrementEtudiants.get(0));

            List<List<EncadrementDoctorant>> resultEncadrementDoctorants= encadrementDoctorantService.getToBeSavedAndToBeDeleted(encadrementDoctorantService.findByEncadrementId(encadrement.getId()),encadrement.getEncadrementDoctorants());
            encadrementDoctorantService.delete(resultEncadrementDoctorants.get(1));
            associateEncadrementDoctorant(encadrement,resultEncadrementDoctorants.get(0));
            encadrementDoctorantService.update(resultEncadrementDoctorants.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
if(encadrementDao.findById(id) == null) return 0;
else{
deleteAssociatedLists(id);
encadrementDao.deleteById(id);
return 1;
}
}


@Override
public Encadrement update(Encadrement encadrement){
Encadrement foundedEncadrement = findById(encadrement.getId());
if(foundedEncadrement==null) return null;
else{
    updateAssociatedLists(encadrement);
return  encadrementDao.save(encadrement);
}
}

	@Override
	public Encadrement save(Encadrement encadrement) {

		Encadrement resultat = new Encadrement();

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
			encadrement.setChercheur(loadedChercheur);
			encadrement.setCampagne(laodedCampagne);

			findCampagne(encadrement);
			findChercheur(encadrement);
			findEtatEtapeCampagne(encadrement);
			
			
			String etatEncadrement=etatEncadrement(encadrement.getEncadrementEtudiants(),encadrement.getEncadrementDoctorants());
			if(etatEncadrement!=null) {
				EtatEtapeCampagne etapeCampagne = etatEtapeCampagneChercheurService.findByCode(etatEncadrement);	
				encadrement.setEtatEtapeCampagne(etapeCampagne);
			}

			Encadrement savedEncadrement = encadrementDao.save(encadrement);
			
			
			if(ListUtil.isNotEmpty(encadrement.getEncadrementEtudiants())) {
				savedEncadrement.setEncadrementEtudiants(encadrement.getEncadrementEtudiants());
				saveEncadrementEtudiants(savedEncadrement, encadrement.getEncadrementEtudiants());
			}
			
			if(ListUtil.isNotEmpty(encadrement.getEncadrementDoctorants())) {
				savedEncadrement.setEncadrementDoctorants(encadrement.getEncadrementDoctorants());
				saveEncadrementDoctorants(savedEncadrement, encadrement.getEncadrementDoctorants());
			}
			
			findAssociatedLists(savedEncadrement);
			return savedEncadrement;
		}
	}

	
	private String etatEncadrement(List<EncadrementEtudiant> encadrementEtudiants, List<EncadrementDoctorant> encadrementDoctorants ) {
		if(encadrementEtudiants!=null) {
			etat=Etat.TERMINE;
			encadrementEtudiants.forEach(element -> {
				if(element.getEtatEtapeCampagne().getCode().equals(Etat.ENCOURS)) {
					etat=Etat.ENCOURS;
				   
				}});
			
		}
		
		if(encadrementDoctorants!=null) { 
			encadrementDoctorants.forEach(element -> {
				if(element.getEtatEtapeCampagne().getCode().equals(Etat.ENCOURS)) {
					etat=Etat.ENCOURS;
				   
				}});
		}
			

		return etat;
			
		}
		
		
	
@Override
public List<Encadrement> save(List<Encadrement> encadrements){
List<Encadrement> list = new ArrayList<Encadrement>();
for(Encadrement encadrement: encadrements){
list.add(save(encadrement));
}
return list;
}



@Override
@Transactional
public int delete(Encadrement encadrement){
    if(encadrement.getId()==null) return -1;
    Encadrement foundedEncadrement = findById(encadrement.getId());
    if(foundedEncadrement==null) return -1;
encadrementDao.delete(foundedEncadrement);
return 1;
}


public List<Encadrement> findByCriteria(EncadrementVo encadrementVo){
User currentUser = SecurityUtil.getCurrentUser();
if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())) {

String query = "SELECT o FROM Encadrement o where 1=1 ";
    query += SearchUtil.addConstraint("o", "chercheur.username", "=", currentUser.getUsername());

            query += SearchUtil.addConstraint( "o", "id","=",encadrementVo.getId());
            query += SearchUtil.addConstraint( "o", "annee","=",encadrementVo.getAnnee());
            query += SearchUtil.addConstraint( "o", "tempsEstimePourCetteAnnne","=",encadrementVo.getTempsEstimePourCetteAnnne());
            query += SearchUtil.addConstraintMinMax("o","annee",encadrementVo.getAnneeMin(),encadrementVo.getAnneeMax());
            query += SearchUtil.addConstraintMinMax("o","tempsEstimePourCetteAnnne",encadrementVo.getTempsEstimePourCetteAnnneMin(),encadrementVo.getTempsEstimePourCetteAnnneMax());
    if(encadrementVo.getCampagneVo()!=null){
        query += SearchUtil.addConstraint( "o", "campagne.id","=",encadrementVo.getCampagneVo().getId());
            query += SearchUtil.addConstraint( "o", "campagne.code","LIKE",encadrementVo.getCampagneVo().getCode());
    }

    if(encadrementVo.getChercheurVo()!=null){
        query += SearchUtil.addConstraint( "o", "chercheur.id","=",encadrementVo.getChercheurVo().getId());
            query += SearchUtil.addConstraint( "o", "chercheur.numeroMatricule","LIKE",encadrementVo.getChercheurVo().getNumeroMatricule());
    }

    if(encadrementVo.getEtatEtapeCampagneVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatEtapeCampagne.id","=",encadrementVo.getEtatEtapeCampagneVo().getId());
            query += SearchUtil.addConstraint( "o", "etatEtapeCampagne.code","LIKE",encadrementVo.getEtatEtapeCampagneVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}
return new ArrayList<>();
}

	private void saveEncadrementEtudiants(Encadrement encadrement, List<EncadrementEtudiant> encadrementEtudiants) {

		if (ListUtil.isNotEmpty(encadrement.getEncadrementEtudiants())) {
			List<EncadrementEtudiant> savedEncadrementEtudiants = new ArrayList<>();
			encadrementEtudiants.forEach(element -> {
				
				if(!element.getEtatEtapeCampagne().getCode().equals("")) {
				    EtatEtapeCampagne etapeCampagne = etatEtapeCampagneChercheurService.findByCode(element.getEtatEtapeCampagne().getCode());	
					element.setEtatEtapeCampagne(etapeCampagne);
				}
				element.setEncadrement(encadrement);
				if(element.getId()!=null) {
					encadrementEtudiantService.update(element);
				}
				else {
					encadrementEtudiantService.save(element);
				}
				
			});
			
			
		
			encadrement.setEncadrementEtudiants(savedEncadrementEtudiants);
		}
	}

	private void saveEncadrementDoctorants(Encadrement encadrement, List<EncadrementDoctorant> encadrementDoctorants) {

		if (ListUtil.isNotEmpty(encadrement.getEncadrementDoctorants())) {
			List<EncadrementDoctorant> savedEncadrementDoctorants = new ArrayList<>();
			encadrementDoctorants.forEach(element -> {
				element.setEncadrement(encadrement);
				if(element.getId()!=null) {
					encadrementDoctorantService.update(element);
				}
				else {
					encadrementDoctorantService.save(element);
				}
				
			});
			encadrement.setEncadrementDoctorants(savedEncadrementDoctorants);
		}
	}

    private void findCampagne(Encadrement encadrement){
        Campagne loadedCampagne =campagneService.findByIdOrCode(encadrement.getCampagne());

    if(loadedCampagne==null ) {
        return;
    }
    encadrement.setCampagne(loadedCampagne);
    }
    private void findChercheur(Encadrement encadrement){
        Chercheur loadedChercheur =chercheurService.findByIdOrNumeroMatricule(encadrement.getChercheur());

    if(loadedChercheur==null ) {
        return;
    }
    encadrement.setChercheur(loadedChercheur);
    }
    private void findEtatEtapeCampagne(Encadrement encadrement){
        EtatEtapeCampagne loadedEtatEtapeCampagne =etatEtapeCampagneService.findByIdOrCode(encadrement.getEtatEtapeCampagne());

    if(loadedEtatEtapeCampagne==null ) {
        return;
    }
    encadrement.setEtatEtapeCampagne(loadedEtatEtapeCampagne);
    }

@Override
@Transactional
public void delete(List<Encadrement> encadrements){
        if(ListUtil.isNotEmpty(encadrements)){
        encadrements.forEach(e->encadrementDao.delete(e));
        }
}
@Override
public void update(List<Encadrement> encadrements){
if(ListUtil.isNotEmpty(encadrements)){
encadrements.forEach(e->encadrementDao.save(e));
}
}

private void associateEncadrementEtudiant(Encadrement encadrement, List<EncadrementEtudiant> encadrementEtudiant) {
    if (ListUtil.isNotEmpty(encadrementEtudiant)) {
        encadrementEtudiant.forEach(e -> e.setEncadrement(encadrement));
    }
    }
private void associateEncadrementDoctorant(Encadrement encadrement, List<EncadrementDoctorant> encadrementDoctorant) {
    if (ListUtil.isNotEmpty(encadrementDoctorant)) {
        encadrementDoctorant.forEach(e -> e.setEncadrement(encadrement));
    }
    }

@Override
public List<Encadrement> findByChercheurUsernameAndCampagneId(String username, Long compagneId){
List<Encadrement> resultat= encadrementDao.findByChercheurUsernameAndCampagneId(username, compagneId);
    return resultat;
}

@Override
public List<List<Encadrement>>  getToBeSavedAndToBeDeleted(List<Encadrement> oldList,List<Encadrement> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

@Override
public List<Encadrement> findAllByOrderByAnneeDesc() {
	
	return encadrementDao.findAllByOrderByAnneeDesc();
}


}

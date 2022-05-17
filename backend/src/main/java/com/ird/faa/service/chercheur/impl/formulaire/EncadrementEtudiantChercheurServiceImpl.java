package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.formulaire.Encadrement;
import com.ird.faa.bean.formulaire.EncadrementEtudiant;
import com.ird.faa.bean.referentiel.NiveauFormationPostBac;
import com.ird.faa.bean.referentiel.Etablissement;
import com.ird.faa.bean.formulaire.EtablissementEncadrementEtudiant;
import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.formulaire.PaysEncadrementEtudiant;
import com.ird.faa.bean.formulaire.ResponsabiliteEncadrementEtudiant;
import com.ird.faa.bean.config.EtatEtapeCampagne;
import com.ird.faa.dao.formulaire.EncadrementEtudiantDao;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementEtudiantChercheurService;
import com.ird.faa.service.chercheur.facade.config.EtatEtapeCampagneChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.ResponsabiliteEncadrementEtudiantChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementEtudiantEnjeuxIrdChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.NiveauFormationPostBacChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EtablissementChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EtablissementEncadrementEtudiantChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementEtudiantDisciplineScientifiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.PaysChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.PaysEncadrementEtudiantChercheurService;
import com.ird.faa.ws.rest.provided.vo.EncadrementEtudiantVo;
import com.ird.faa.bean.formulaire.EncadrementEtudiantEnjeuxIrd;
import com.ird.faa.bean.formulaire.EncadrementEtudiantDisciplineScientifique;

import com.ird.faa.dao.formulaire.EncadrementDao;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;

@Service
public class EncadrementEtudiantChercheurServiceImpl extends AbstractServiceImpl<EncadrementEtudiant> implements EncadrementEtudiantChercheurService {

@Autowired
private EncadrementEtudiantDao encadrementEtudiantDao;

	@Autowired
	private EncadrementDao encadrementDao;

        @Autowired
        private EtatEtapeCampagneChercheurService etatEtapeCampagneService ;
        @Autowired
        private ResponsabiliteEncadrementEtudiantChercheurService responsabiliteEncadrementEtudiantService ;
        @Autowired
        private EncadrementChercheurService encadrementService ;
        @Autowired
        private EncadrementEtudiantEnjeuxIrdChercheurService encadrementEtudiantEnjeuxIrdService ;
        
        
        @Autowired
    	private EtablissementEncadrementEtudiantChercheurService etablissementEncadrementEtudiantService;

    	@Autowired
    	private PaysEncadrementEtudiantChercheurService paysEncadrementEtudiantService;
        
    	@Autowired
        private NiveauFormationPostBacChercheurService niveauFormationPostBacService ;
        @Autowired
        private EtablissementChercheurService etablissementService ;
        @Autowired
        private EncadrementEtudiantDisciplineScientifiqueChercheurService encadrementEtudiantDisciplineScientifiqueService ;
        @Autowired
        private PaysChercheurService paysService ;


@Autowired
private EntityManager entityManager;


@Override
public List<EncadrementEtudiant> findAll(){
return encadrementEtudiantDao.findAll();
}

        @Override
        public List<EncadrementEtudiant> findByNiveauFormationPostBacCode(String code){
        return encadrementEtudiantDao.findByNiveauFormationPostBacCode(code);
        }

        @Override
        @Transactional
        public int deleteByNiveauFormationPostBacCode(String code){
        return encadrementEtudiantDao.deleteByNiveauFormationPostBacCode(code);
        }

        @Override
        public List<EncadrementEtudiant> findByNiveauFormationPostBacId(Long id){
        return encadrementEtudiantDao.findByNiveauFormationPostBacId(id);
        }

        @Override
        @Transactional
        public int deleteByNiveauFormationPostBacId(Long id){
        return encadrementEtudiantDao.deleteByNiveauFormationPostBacId(id);
        }


        @Override
        public List<EncadrementEtudiant> findByResponsabiliteEncadrementEtudiantCode(String code){
        return encadrementEtudiantDao.findByResponsabiliteEncadrementEtudiantCode(code);
        }

        @Override
        @Transactional
        public int deleteByResponsabiliteEncadrementEtudiantCode(String code){
        return encadrementEtudiantDao.deleteByResponsabiliteEncadrementEtudiantCode(code);
        }

        @Override
        public List<EncadrementEtudiant> findByResponsabiliteEncadrementEtudiantId(Long id){
        return encadrementEtudiantDao.findByResponsabiliteEncadrementEtudiantId(id);
        }

        @Override
        @Transactional
        public int deleteByResponsabiliteEncadrementEtudiantId(Long id){
        return encadrementEtudiantDao.deleteByResponsabiliteEncadrementEtudiantId(id);
        }


        @Override
        public List<EncadrementEtudiant> findByEtablissementCode(String code){
        return encadrementEtudiantDao.findByEtablissementCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtablissementCode(String code){
        return encadrementEtudiantDao.deleteByEtablissementCode(code);
        }

        @Override
        public List<EncadrementEtudiant> findByEtablissementId(Long id){
        return encadrementEtudiantDao.findByEtablissementId(id);
        }

        @Override
        @Transactional
        public int deleteByEtablissementId(Long id){
        return encadrementEtudiantDao.deleteByEtablissementId(id);
        }


        @Override
        public List<EncadrementEtudiant> findByPaysCode(String code){
        return encadrementEtudiantDao.findByPaysCode(code);
        }

        @Override
        @Transactional
        public int deleteByPaysCode(String code){
        return encadrementEtudiantDao.deleteByPaysCode(code);
        }

        @Override
        public List<EncadrementEtudiant> findByPaysId(Long id){
        return encadrementEtudiantDao.findByPaysId(id);
        }

        @Override
        @Transactional
        public int deleteByPaysId(Long id){
        return encadrementEtudiantDao.deleteByPaysId(id);
        }

        @Override
        public List<EncadrementEtudiant> findByEncadrementId(Long id){
        return encadrementEtudiantDao.findByEncadrementId(id);
        }

        @Override
        @Transactional
        public int deleteByEncadrementId(Long id){
        return encadrementEtudiantDao.deleteByEncadrementId(id);
        }


        @Override
        public List<EncadrementEtudiant> findByEtatEtapeCampagneCode(String code){
        return encadrementEtudiantDao.findByEtatEtapeCampagneCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtatEtapeCampagneCode(String code){
        return encadrementEtudiantDao.deleteByEtatEtapeCampagneCode(code);
        }

        @Override
        public List<EncadrementEtudiant> findByEtatEtapeCampagneId(Long id){
        return encadrementEtudiantDao.findByEtatEtapeCampagneId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatEtapeCampagneId(Long id){
        return encadrementEtudiantDao.deleteByEtatEtapeCampagneId(id);
        }


@Override
public EncadrementEtudiant findById(Long id){
if(id==null) return null;
return encadrementEtudiantDao.getOne(id);
}

@Override
public EncadrementEtudiant findByIdWithAssociatedList(Long id){
EncadrementEtudiant encadrementEtudiant  = findById(id);
    findAssociatedLists(encadrementEtudiant);
return encadrementEtudiant;
}
private void findAssociatedLists(EncadrementEtudiant encadrementEtudiant){
if(encadrementEtudiant==null || encadrementEtudiant.getId()==null) return ;
else{
        List<EncadrementEtudiantEnjeuxIrd> encadrementEtudiantEnjeuxIrds = encadrementEtudiantEnjeuxIrdService.findByEncadrementEtudiantId(encadrementEtudiant.getId());
        encadrementEtudiant.setEncadrementEtudiantEnjeuxIrds(encadrementEtudiantEnjeuxIrds);
        
        List<PaysEncadrementEtudiant> paysEncadrementEtudiants = paysEncadrementEtudiantService
				.findByEncadrementEtudiantId(encadrementEtudiant.getId());
		encadrementEtudiant.setPaysEncadrementEtudiants(paysEncadrementEtudiants);
		
		List<EtablissementEncadrementEtudiant> etablissementEncadrementEtudiants = etablissementEncadrementEtudiantService
				.findByEncadrementEtudiantId(encadrementEtudiant.getId());
		encadrementEtudiant.setEtablissementEncadrementEtudiants(etablissementEncadrementEtudiants);

        
        
        
        List<EncadrementEtudiantDisciplineScientifique> encadrementEtudiantDisciplineScientifiques = encadrementEtudiantDisciplineScientifiqueService.findByEncadrementEtudiantId(encadrementEtudiant.getId());
        encadrementEtudiant.setEncadrementEtudiantDisciplineScientifiques(encadrementEtudiantDisciplineScientifiques);
}
}
private void deleteAssociatedLists(Long id){
if(id==null ) return ;
else{
        encadrementEtudiantEnjeuxIrdService.deleteByEncadrementEtudiantId(id);
        paysEncadrementEtudiantService.deleteByEncadrementEtudiantId(id);
		etablissementEncadrementEtudiantService.deleteByEncadrementEtudiantId(id);
        encadrementEtudiantDisciplineScientifiqueService.deleteByEncadrementEtudiantId(id);
}
}

    private void updateAssociatedLists(EncadrementEtudiant encadrementEtudiant){
    if(encadrementEtudiant==null || encadrementEtudiant.getId()==null) return ;
    else{
            List<List<EncadrementEtudiantEnjeuxIrd>> resultEncadrementEtudiantEnjeuxIrds= encadrementEtudiantEnjeuxIrdService.getToBeSavedAndToBeDeleted(encadrementEtudiantEnjeuxIrdService.findByEncadrementEtudiantId(encadrementEtudiant.getId()),encadrementEtudiant.getEncadrementEtudiantEnjeuxIrds());
            encadrementEtudiantEnjeuxIrdService.delete(resultEncadrementEtudiantEnjeuxIrds.get(1));
            associateEncadrementEtudiantEnjeuxIrd(encadrementEtudiant,resultEncadrementEtudiantEnjeuxIrds.get(0));
            encadrementEtudiantEnjeuxIrdService.update(resultEncadrementEtudiantEnjeuxIrds.get(0));

            List<List<PaysEncadrementEtudiant>> resultPaysEncadrementEtudiants = paysEncadrementEtudiantService
					.getToBeSavedAndToBeDeleted(
							paysEncadrementEtudiantService
									.findByEncadrementEtudiantId(encadrementEtudiant.getId()),
							encadrementEtudiant.getPaysEncadrementEtudiants());
			paysEncadrementEtudiantService.delete(resultPaysEncadrementEtudiants.get(1));
			associatePaysEncadrementEtudiant(encadrementEtudiant, resultPaysEncadrementEtudiants.get(0));
			paysEncadrementEtudiantService.update(resultPaysEncadrementEtudiants.get(0));
			
			List<List<EtablissementEncadrementEtudiant>> resultEtablissementEncadrementEtudiants = etablissementEncadrementEtudiantService
					.getToBeSavedAndToBeDeleted(
							etablissementEncadrementEtudiantService
									.findByEncadrementEtudiantId(encadrementEtudiant.getId()),
							encadrementEtudiant.getEtablissementEncadrementEtudiants());
			etablissementEncadrementEtudiantService.delete(resultEtablissementEncadrementEtudiants.get(1));
			associateEtablissementEncadrementEtudiant(encadrementEtudiant, resultEtablissementEncadrementEtudiants.get(0));
			etablissementEncadrementEtudiantService.update(resultEtablissementEncadrementEtudiants.get(0));
		
            
            
            
            
            List<List<EncadrementEtudiantDisciplineScientifique>> resultEncadrementEtudiantDisciplineScientifiques= encadrementEtudiantDisciplineScientifiqueService.getToBeSavedAndToBeDeleted(encadrementEtudiantDisciplineScientifiqueService.findByEncadrementEtudiantId(encadrementEtudiant.getId()),encadrementEtudiant.getEncadrementEtudiantDisciplineScientifiques());
            encadrementEtudiantDisciplineScientifiqueService.delete(resultEncadrementEtudiantDisciplineScientifiques.get(1));
            associateEncadrementEtudiantDisciplineScientifique(encadrementEtudiant,resultEncadrementEtudiantDisciplineScientifiques.get(0));
            encadrementEtudiantDisciplineScientifiqueService.update(resultEncadrementEtudiantDisciplineScientifiques.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
if(encadrementEtudiantDao.findById(id) == null) return 0;
else{
deleteAssociatedLists(id);
encadrementEtudiantDao.deleteById(id);
return 1;
}
}


@Override
public EncadrementEtudiant update(EncadrementEtudiant encadrementEtudiant){
EncadrementEtudiant foundedEncadrementEtudiant = findById(encadrementEtudiant.getId());
if(foundedEncadrementEtudiant==null) return null;
else{
    updateAssociatedLists(encadrementEtudiant);
return  encadrementEtudiantDao.save(encadrementEtudiant);
}
}

@Override
public EncadrementEtudiant save (EncadrementEtudiant encadrementEtudiant){


    findNiveauFormationPostBac(encadrementEtudiant);
    findResponsabiliteEncadrementEtudiant(encadrementEtudiant);
    findEtablissement(encadrementEtudiant);
    findPays(encadrementEtudiant);
    findEncadrement(encadrementEtudiant);
    findEtatEtapeCampagne(encadrementEtudiant);

EncadrementEtudiant savedEncadrementEtudiant = encadrementEtudiantDao.save(encadrementEtudiant);
       saveEncadrementEtudiantEnjeuxIrds(savedEncadrementEtudiant,encadrementEtudiant.getEncadrementEtudiantEnjeuxIrds());
       saveEtablissementEncadrementEtudiants(savedEncadrementEtudiant,
    		    encadrementEtudiant.getEtablissementEncadrementEtudiants());
    		savePaysEncadrementEtudiants(savedEncadrementEtudiant,
    		    encadrementEtudiant.getPaysEncadrementEtudiants());
       saveEncadrementEtudiantDisciplineScientifiques(savedEncadrementEtudiant,encadrementEtudiant.getEncadrementEtudiantDisciplineScientifiques());
return savedEncadrementEtudiant;
}



@Override
public List<EncadrementEtudiant> save(List<EncadrementEtudiant> encadrementEtudiants){
List<EncadrementEtudiant> list = new ArrayList<EncadrementEtudiant>();
for(EncadrementEtudiant encadrementEtudiant: encadrementEtudiants){
list.add(save(encadrementEtudiant));
}
return list;
}



@Override
@Transactional
public int delete(EncadrementEtudiant encadrementEtudiant){
    if(encadrementEtudiant.getId()==null) return -1;
    EncadrementEtudiant foundedEncadrementEtudiant = findById(encadrementEtudiant.getId());
    if(foundedEncadrementEtudiant==null) return -1;
encadrementEtudiantDao.delete(foundedEncadrementEtudiant);
return 1;
}


public List<EncadrementEtudiant> findByCriteria(EncadrementEtudiantVo encadrementEtudiantVo){

String query = "SELECT o FROM EncadrementEtudiant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",encadrementEtudiantVo.getId());
            query += SearchUtil.addConstraint( "o", "sujetEtude","LIKE",encadrementEtudiantVo.getSujetEtude());
            query += SearchUtil.addConstraint( "o", "cursus","LIKE",encadrementEtudiantVo.isCursus());
    if(encadrementEtudiantVo.getNiveauFormationPostBacVo()!=null){
        query += SearchUtil.addConstraint( "o", "niveauFormationPostBac.id","=",encadrementEtudiantVo.getNiveauFormationPostBacVo().getId());
            query += SearchUtil.addConstraint( "o", "niveauFormationPostBac.code","LIKE",encadrementEtudiantVo.getNiveauFormationPostBacVo().getCode());
    }

    if(encadrementEtudiantVo.getResponsabiliteEncadrementEtudiantVo()!=null){
        query += SearchUtil.addConstraint( "o", "responsabiliteEncadrementEtudiant.id","=",encadrementEtudiantVo.getResponsabiliteEncadrementEtudiantVo().getId());
            query += SearchUtil.addConstraint( "o", "responsabiliteEncadrementEtudiant.code","LIKE",encadrementEtudiantVo.getResponsabiliteEncadrementEtudiantVo().getCode());
    }

    if(encadrementEtudiantVo.getEtablissementVo()!=null){
        query += SearchUtil.addConstraint( "o", "etablissement.id","=",encadrementEtudiantVo.getEtablissementVo().getId());
            query += SearchUtil.addConstraint( "o", "etablissement.code","LIKE",encadrementEtudiantVo.getEtablissementVo().getCode());
    }

    if(encadrementEtudiantVo.getPaysVo()!=null){
        query += SearchUtil.addConstraint( "o", "pays.id","=",encadrementEtudiantVo.getPaysVo().getId());
            query += SearchUtil.addConstraint( "o", "pays.code","LIKE",encadrementEtudiantVo.getPaysVo().getCode());
    }

    if(encadrementEtudiantVo.getEncadrementVo()!=null){
        query += SearchUtil.addConstraint( "o", "encadrement.id","=",encadrementEtudiantVo.getEncadrementVo().getId());
    }

    if(encadrementEtudiantVo.getEtatEtapeCampagneVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatEtapeCampagne.id","=",encadrementEtudiantVo.getEtatEtapeCampagneVo().getId());
            query += SearchUtil.addConstraint( "o", "etatEtapeCampagne.code","LIKE",encadrementEtudiantVo.getEtatEtapeCampagneVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}
        private  void saveEncadrementEtudiantEnjeuxIrds(EncadrementEtudiant encadrementEtudiant,List<EncadrementEtudiantEnjeuxIrd> encadrementEtudiantEnjeuxIrds){

        if (ListUtil.isNotEmpty(encadrementEtudiant.getEncadrementEtudiantEnjeuxIrds())) {
        List<EncadrementEtudiantEnjeuxIrd> savedEncadrementEtudiantEnjeuxIrds = new ArrayList<>();
        encadrementEtudiantEnjeuxIrds.forEach(element -> {
        element.setEncadrementEtudiant(encadrementEtudiant);
        encadrementEtudiantEnjeuxIrdService.save(element);
        });
        encadrementEtudiant.setEncadrementEtudiantEnjeuxIrds(savedEncadrementEtudiantEnjeuxIrds);
        }
        }
        
        private void saveEtablissementEncadrementEtudiants(EncadrementEtudiant encadrementEtudiant,
    			List<EtablissementEncadrementEtudiant> etablissementEncadrementEtudiants) {

    		if (ListUtil.isNotEmpty(encadrementEtudiant.getEtablissementEncadrementEtudiants())) {
    			List<EtablissementEncadrementEtudiant> savedEtablissementEncadrementEtudiants = new ArrayList<>();
    			etablissementEncadrementEtudiants.forEach(element -> {
    				element.setEncadrementEtudiant(encadrementEtudiant);
    				etablissementEncadrementEtudiantService.save(element);
    			});
    			encadrementEtudiant.setEtablissementEncadrementEtudiants(savedEtablissementEncadrementEtudiants);
    		}
    	}
    	
    	
    	private void savePaysEncadrementEtudiants(EncadrementEtudiant encadrementEtudiant,
    			List<PaysEncadrementEtudiant> paysEncadrementEtudiants) {

    		if (ListUtil.isNotEmpty(encadrementEtudiant.getPaysEncadrementEtudiants())) {
    			List<PaysEncadrementEtudiant> savedPaysEncadrementEtudiants = new ArrayList<>();
    			paysEncadrementEtudiants.forEach(element -> {
    				element.setEncadrementEtudiant(encadrementEtudiant);
    				paysEncadrementEtudiantService.save(element);
    			});
    			encadrementEtudiant.setPaysEncadrementEtudiants(savedPaysEncadrementEtudiants);
    		}
    	}

        private  void saveEncadrementEtudiantDisciplineScientifiques(EncadrementEtudiant encadrementEtudiant,List<EncadrementEtudiantDisciplineScientifique> encadrementEtudiantDisciplineScientifiques){

        if (ListUtil.isNotEmpty(encadrementEtudiant.getEncadrementEtudiantDisciplineScientifiques())) {
        List<EncadrementEtudiantDisciplineScientifique> savedEncadrementEtudiantDisciplineScientifiques = new ArrayList<>();
        encadrementEtudiantDisciplineScientifiques.forEach(element -> {
        element.setEncadrementEtudiant(encadrementEtudiant);
        encadrementEtudiantDisciplineScientifiqueService.save(element);
        });
        encadrementEtudiant.setEncadrementEtudiantDisciplineScientifiques(savedEncadrementEtudiantDisciplineScientifiques);
        }
        }

    private void findNiveauFormationPostBac(EncadrementEtudiant encadrementEtudiant){
    	
    		  NiveauFormationPostBac loadedNiveauFormationPostBac =niveauFormationPostBacService.findByIdOrCode(encadrementEtudiant.getNiveauFormationPostBac());

    		    if(loadedNiveauFormationPostBac==null ) {
    		        return;
    		    }
    		    encadrementEtudiant.setNiveauFormationPostBac(loadedNiveauFormationPostBac);
    	
      
    }

	private void findResponsabiliteEncadrementEtudiant(EncadrementEtudiant encadrementEtudiant) {
		ResponsabiliteEncadrementEtudiant loadedResponsabiliteEncadrementEtudiant = responsabiliteEncadrementEtudiantService
				.findByIdOrCode(encadrementEtudiant.getResponsabiliteEncadrementEtudiant());

		if (loadedResponsabiliteEncadrementEtudiant == null) {
			return;
		}
		encadrementEtudiant.setResponsabiliteEncadrementEtudiant(loadedResponsabiliteEncadrementEtudiant);
	}
    private void findEtablissement(EncadrementEtudiant encadrementEtudiant){
        Etablissement loadedEtablissement =etablissementService.findByIdOrCode(encadrementEtudiant.getEtablissement());

    if(loadedEtablissement==null ) {
        return;
    }
    encadrementEtudiant.setEtablissement(loadedEtablissement);
    }
    private void findPays(EncadrementEtudiant encadrementEtudiant){
        Pays loadedPays =paysService.findByIdOrCode(encadrementEtudiant.getPays());

    if(loadedPays==null ) {
        return;
    }
    encadrementEtudiant.setPays(loadedPays);
    }
    private void findEncadrement(EncadrementEtudiant encadrementEtudiant){
        Encadrement loadedEncadrement = null;
        if(encadrementEtudiant.getEncadrement() != null && encadrementEtudiant.getEncadrement().getId() !=null)
        loadedEncadrement =encadrementService.findById(encadrementEtudiant.getEncadrement().getId());

    if(loadedEncadrement==null ) {
        return;
    }
    encadrementEtudiant.setEncadrement(loadedEncadrement);
    }
    private void findEtatEtapeCampagne(EncadrementEtudiant encadrementEtudiant){
        EtatEtapeCampagne loadedEtatEtapeCampagne =etatEtapeCampagneService.findByIdOrCode(encadrementEtudiant.getEtatEtapeCampagne());

    if(loadedEtatEtapeCampagne==null ) {
        return;
    }
    encadrementEtudiant.setEtatEtapeCampagne(loadedEtatEtapeCampagne);
    }

@Override
@Transactional
public void delete(List<EncadrementEtudiant> encadrementEtudiants){
        if(ListUtil.isNotEmpty(encadrementEtudiants)){
        encadrementEtudiants.forEach(e->encadrementEtudiantDao.delete(e));
        }
}
@Override
public void update(List<EncadrementEtudiant> encadrementEtudiants){
if(ListUtil.isNotEmpty(encadrementEtudiants)){
encadrementEtudiants.forEach(e->encadrementEtudiantDao.save(e));
}
}

private void associateEncadrementEtudiantEnjeuxIrd(EncadrementEtudiant encadrementEtudiant, List<EncadrementEtudiantEnjeuxIrd> encadrementEtudiantEnjeuxIrd) {
    if (ListUtil.isNotEmpty(encadrementEtudiantEnjeuxIrd)) {
        encadrementEtudiantEnjeuxIrd.forEach(e -> e.setEncadrementEtudiant(encadrementEtudiant));
    }
    }

private void associatePaysEncadrementEtudiant(EncadrementEtudiant encadrementEtudiant,
		List<PaysEncadrementEtudiant> paysEncadrementEtudiant) {
		if (ListUtil.isNotEmpty(paysEncadrementEtudiant)) {
		paysEncadrementEtudiant.forEach(e -> e.setEncadrementEtudiant(encadrementEtudiant));
		}
		}

private void associateEtablissementEncadrementEtudiant(EncadrementEtudiant encadrementEtudiant,
	    List<EtablissementEncadrementEtudiant> etablissementEncadrementEtudiant) {
	    if (ListUtil.isNotEmpty(etablissementEncadrementEtudiant)) {
	    etablissementEncadrementEtudiant.forEach(e -> e.setEncadrementEtudiant(encadrementEtudiant));
	    }
	    }
private void associateEncadrementEtudiantDisciplineScientifique(EncadrementEtudiant encadrementEtudiant, List<EncadrementEtudiantDisciplineScientifique> encadrementEtudiantDisciplineScientifique) {
    if (ListUtil.isNotEmpty(encadrementEtudiantDisciplineScientifique)) {
        encadrementEtudiantDisciplineScientifique.forEach(e -> e.setEncadrementEtudiant(encadrementEtudiant));
    }
    }


@Override
public List<List<EncadrementEtudiant>>  getToBeSavedAndToBeDeleted(List<EncadrementEtudiant> oldList,List<EncadrementEtudiant> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

	@Override
	public List<EncadrementEtudiant> findByChercheurUsernameAndCampagneId(String username, Long compagneId) {

		List<Encadrement> encadrements = encadrementDao.findByChercheurUsernameAndCampagneId(username,
				compagneId);

		List<EncadrementEtudiant> encadrementEtudiants = new ArrayList<>();

		if (encadrements != null) {
			encadrements.forEach(encadrement -> {
				encadrementEtudiants.addAll(encadrement.getEncadrementEtudiants());
			});

		}

		return encadrementEtudiants;
	}

}

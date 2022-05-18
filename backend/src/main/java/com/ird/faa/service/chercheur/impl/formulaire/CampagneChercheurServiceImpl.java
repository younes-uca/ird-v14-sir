package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.Campagne;
        import com.ird.faa.bean.config.EtatCampagne;
        import com.ird.faa.bean.formulaire.TemplateOuverture;
        import com.ird.faa.bean.formulaire.TemplateCloture;
import com.ird.faa.dao.formulaire.CampagneDao;
import com.ird.faa.security.common.SecurityUtil;
import com.ird.faa.service.chercheur.facade.formulaire.CampagneChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.CampagneChercheurOuvertureChercheurService;
        import com.ird.faa.service.chercheur.facade.config.EtatCampagneChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.TemplateClotureChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.TemplateOuvertureChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.CampagneRelanceChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.CampagneChercheurChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.CampagneRappelChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.CampagneChercheurFermetureChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.CampagneVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.formulaire.CampagneChercheur;
        import com.ird.faa.bean.formulaire.Chercheur;
        import com.ird.faa.bean.formulaire.CampagneChercheurOuverture;
        import com.ird.faa.bean.formulaire.CampagneChercheurFermeture;
        import com.ird.faa.bean.formulaire.CampagneRelance;
import com.ird.faa.bean.formulaire.CampagneRappel;
        



import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CampagneChercheurServiceImpl extends AbstractServiceImpl<Campagne> implements CampagneChercheurService {

@Autowired
private CampagneDao campagneDao;

        @Autowired
        private CampagneChercheurOuvertureChercheurService campagneChercheurOuvertureService ;
        @Autowired
        private EtatCampagneChercheurService etatCampagneService ;
        @Autowired
        private TemplateClotureChercheurService templateClotureService ;
        @Autowired
        private TemplateOuvertureChercheurService templateOuvertureService ;
        @Autowired
        private CampagneRelanceChercheurService campagneRelanceService ;
        @Autowired
        private CampagneChercheurChercheurService campagneChercheurService ;
        @Autowired
        private CampagneRappelChercheurService campagneRappelService ;
        @Autowired
        private CampagneChercheurFermetureChercheurService campagneChercheurFermetureService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Campagne> findAll(){
return campagneDao.findAll();
}

        @Override
        public List<Campagne> findByEtatCampagneCode(String code){
        return campagneDao.findByEtatCampagneCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtatCampagneCode(String code){
        return campagneDao.deleteByEtatCampagneCode(code);
        }

        @Override
        public List<Campagne> findByEtatCampagneId(Long id){
        return campagneDao.findByEtatCampagneId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatCampagneId(Long id){
        return campagneDao.deleteByEtatCampagneId(id);
        }


        @Override
        public List<Campagne> findByTemplateOuvertureCode(String code){
        return campagneDao.findByTemplateOuvertureCode(code);
        }

        @Override
        @Transactional
        public int deleteByTemplateOuvertureCode(String code){
        return campagneDao.deleteByTemplateOuvertureCode(code);
        }

        @Override
        public List<Campagne> findByTemplateOuvertureId(Long id){
        return campagneDao.findByTemplateOuvertureId(id);
        }

        @Override
        @Transactional
        public int deleteByTemplateOuvertureId(Long id){
        return campagneDao.deleteByTemplateOuvertureId(id);
        }


        @Override
        public List<Campagne> findByTemplateClotureCode(String code){
        return campagneDao.findByTemplateClotureCode(code);
        }

        @Override
        @Transactional
        public int deleteByTemplateClotureCode(String code){
        return campagneDao.deleteByTemplateClotureCode(code);
        }

        @Override
        public List<Campagne> findByTemplateClotureId(Long id){
        return campagneDao.findByTemplateClotureId(id);
        }

        @Override
        @Transactional
        public int deleteByTemplateClotureId(Long id){
        return campagneDao.deleteByTemplateClotureId(id);
        }

    @Override
    public Campagne findByCode(String code){
    if( code==null) return null;
    return campagneDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return campagneDao.deleteByCode(code);
    }
    @Override
    public Campagne findByIdOrCode(Campagne campagne){
    Campagne resultat=null;
    if(campagne == null || ( campagne.getCode()==null && campagne.getId()==null))
    return resultat;
    else{
    if(campagne.getId() != null){
    resultat= campagneDao.findById(campagne.getId()).get();
    }else if(StringUtil.isNotEmpty(campagne.getCode())) {
    resultat= campagneDao.findByCode(campagne.getCode());
    }
    return resultat;
    }
    }

@Override
public Campagne findById(Long id){
if(id==null) return null;
return campagneDao.getOne(id);
}

@Override
public Campagne findByIdWithAssociatedList(Long id){
Campagne campagne  = findById(id);
    findAssociatedLists(campagne);
return campagne;
}
private void findAssociatedLists(Campagne campagne){
if(campagne==null || campagne.getId()==null) return ;
else{
      /*  List<CampagneChercheur> campagneChercheurs = campagneChercheurService.findByCampagneId(campagne.getId());
        campagne.setCampagneChercheurs(campagneChercheurs);*/
        List<CampagneChercheurOuverture> campagneChercheurOuvertures = campagneChercheurOuvertureService.findByCampagneId(campagne.getId());
        campagne.setCampagneChercheurOuvertures(campagneChercheurOuvertures);
        List<CampagneChercheurFermeture> campagneChercheurFermetures = campagneChercheurFermetureService.findByCampagneId(campagne.getId());
        campagne.setCampagneChercheurFermetures(campagneChercheurFermetures);
        List<CampagneRelance> campagneRelances = campagneRelanceService.findByCampagneId(campagne.getId());
        campagne.setCampagneRelances(campagneRelances);
        List<CampagneRappel> campagneRappels = campagneRappelService.findByCampagneId(campagne.getId());
        campagne.setCampagneRappels(campagneRappels);
}
}
private void deleteAssociatedLists(Long id){
if(id==null ) return ;
else{
        campagneChercheurService.deleteByCampagneId(id);
        campagneChercheurOuvertureService.deleteByCampagneId(id);
        campagneChercheurFermetureService.deleteByCampagneId(id);
        campagneRelanceService.deleteByCampagneId(id);
        campagneRappelService.deleteByCampagneId(id);
}
}

    private void updateAssociatedLists(Campagne campagne){
    if(campagne==null || campagne.getId()==null) return ;
    else{
            /*List<List<CampagneChercheur>> resultCampagneChercheurs= campagneChercheurService.getToBeSavedAndToBeDeleted(campagneChercheurService.findByCampagneId(campagne.getId()),campagne.getCampagneChercheurs());
            campagneChercheurService.delete(resultCampagneChercheurs.get(1));
            associateCampagneChercheur(campagne,resultCampagneChercheurs.get(0));
            campagneChercheurService.update(resultCampagneChercheurs.get(0));*/

            List<List<CampagneChercheurOuverture>> resultCampagneChercheurOuvertures= campagneChercheurOuvertureService.getToBeSavedAndToBeDeleted(campagneChercheurOuvertureService.findByCampagneId(campagne.getId()),campagne.getCampagneChercheurOuvertures());
            campagneChercheurOuvertureService.delete(resultCampagneChercheurOuvertures.get(1));
            associateCampagneChercheurOuverture(campagne,resultCampagneChercheurOuvertures.get(0));
            campagneChercheurOuvertureService.update(resultCampagneChercheurOuvertures.get(0));

            List<List<CampagneChercheurFermeture>> resultCampagneChercheurFermetures= campagneChercheurFermetureService.getToBeSavedAndToBeDeleted(campagneChercheurFermetureService.findByCampagneId(campagne.getId()),campagne.getCampagneChercheurFermetures());
            campagneChercheurFermetureService.delete(resultCampagneChercheurFermetures.get(1));
            associateCampagneChercheurFermeture(campagne,resultCampagneChercheurFermetures.get(0));
            campagneChercheurFermetureService.update(resultCampagneChercheurFermetures.get(0));

            List<List<CampagneRelance>> resultCampagneRelances= campagneRelanceService.getToBeSavedAndToBeDeleted(campagneRelanceService.findByCampagneId(campagne.getId()),campagne.getCampagneRelances());
            campagneRelanceService.delete(resultCampagneRelances.get(1));
            associateCampagneRelance(campagne,resultCampagneRelances.get(0));
            campagneRelanceService.update(resultCampagneRelances.get(0));

            List<List<CampagneRappel>> resultCampagneRappels= campagneRappelService.getToBeSavedAndToBeDeleted(campagneRappelService.findByCampagneId(campagne.getId()),campagne.getCampagneRappels());
            campagneRappelService.delete(resultCampagneRappels.get(1));
            associateCampagneRappel(campagne,resultCampagneRappels.get(0));
            campagneRappelService.update(resultCampagneRappels.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
if(campagneDao.findById(id) == null) return 0;
else{
deleteAssociatedLists(id);
campagneDao.deleteById(id);
return 1;
}
}


@Override
public Campagne update(Campagne campagne){
Campagne foundedCampagne = findById(campagne.getId());
if(foundedCampagne==null) return null;
else{
    updateAssociatedLists(campagne);
return  campagneDao.save(campagne);
}
}

@Override
public Campagne save (Campagne campagne){
    Campagne foundedCampagne = findByCode(campagne.getCode());
   if(foundedCampagne!=null) return null;


    findEtatCampagne(campagne);
    findTemplateOuverture(campagne);
    findTemplateCloture(campagne);

Campagne savedCampagne = campagneDao.save(campagne);
       //saveCampagneChercheurs(savedCampagne,campagne.getCampagneChercheurs());
       saveCampagneChercheurOuvertures(savedCampagne,campagne.getCampagneChercheurOuvertures());
       saveCampagneChercheurFermetures(savedCampagne,campagne.getCampagneChercheurFermetures());
       saveCampagneRelances(savedCampagne,campagne.getCampagneRelances());
       saveCampagneRappels(savedCampagne,campagne.getCampagneRappels());
return savedCampagne;
}

@Override
public List<Campagne> save(List<Campagne> campagnes){
List<Campagne> list = new ArrayList<Campagne>();
for(Campagne campagne: campagnes){
list.add(save(campagne));
}
return list;
}



@Override
@Transactional
public int delete(Campagne campagne){
    if(campagne.getCode()==null) return -1;

    Campagne foundedCampagne = findByCode(campagne.getCode());
    if(foundedCampagne==null) return -1;
campagneDao.delete(foundedCampagne);
return 1;
}


	public List<Campagne> findByCriteria(CampagneVo campagneVo) {

		String query = "SELECT o FROM Campagne o where 1=1 ";

		query += SearchUtil.addConstraint("o", "id", "=", campagneVo.getId());
		query += SearchUtil.addConstraint("o", "libelle", "LIKE", campagneVo.getLibelle());
		query += SearchUtil.addConstraint("o", "description", "LIKE", campagneVo.getDescription());
		query += SearchUtil.addConstraint("o", "code", "LIKE", campagneVo.getCode());
		query += SearchUtil.addConstraint("o", "annee", "=", campagneVo.getAnnee());
		query += SearchUtil.addConstraintDate("o", "dateDepart", "=", campagneVo.getDateDepart());
		query += SearchUtil.addConstraintDate("o", "dateFin", "=", campagneVo.getDateFin());
		query += SearchUtil.addConstraint("o", "objetOuverture", "LIKE", campagneVo.getObjetOuverture());
		query += SearchUtil.addConstraint("o", "messageOuverture", "LIKE", campagneVo.getMessageOuverture());
		query += SearchUtil.addConstraint("o", "objetCloture", "LIKE", campagneVo.getObjetCloture());
		query += SearchUtil.addConstraint("o", "messageCloture", "LIKE", campagneVo.getMessageCloture());
		query += SearchUtil.addConstraintMinMax("o", "annee", campagneVo.getAnneeMin(), campagneVo.getAnneeMax());
		query += SearchUtil.addConstraintMinMaxDate("o", "dateDepart", campagneVo.getDateDepartMin(),
				campagneVo.getDateDepartMax());
		query += SearchUtil.addConstraintMinMaxDate("o", "dateFin", campagneVo.getDateFinMin(),
				campagneVo.getDateFinMax());
		if (campagneVo.getEtatCampagneVo() != null) {
			query += SearchUtil.addConstraint("o", "etatCampagne.id", "=", campagneVo.getEtatCampagneVo().getId());
			query += SearchUtil.addConstraint("o", "etatCampagne.code", "LIKE",
					campagneVo.getEtatCampagneVo().getCode());
		}

		if (campagneVo.getTemplateOuvertureVo() != null) {
			query += SearchUtil.addConstraint("o", "templateOuverture.id", "=",
					campagneVo.getTemplateOuvertureVo().getId());
			query += SearchUtil.addConstraint("o", "templateOuverture.code", "LIKE",
					campagneVo.getTemplateOuvertureVo().getCode());
		}

		if (campagneVo.getTemplateClotureVo() != null) {
			query += SearchUtil.addConstraint("o", "templateCloture.id", "=",
					campagneVo.getTemplateClotureVo().getId());
			query += SearchUtil.addConstraint("o", "templateCloture.code", "LIKE",
					campagneVo.getTemplateClotureVo().getCode());
		}

		query += " ORDER BY o.dateDepart";
		return entityManager.createQuery(query).getResultList();
	}



private  void saveCampagneChercheurs(Campagne campagne,List<CampagneChercheur> campagneChercheurs){

        /*if (ListUtil.isNotEmpty(campagne.getCampagneChercheurs())) {
        List<CampagneChercheur> savedCampagneChercheurs = new ArrayList<>();
        campagneChercheurs.forEach(element -> {
        element.setCampagne(campagne);
        campagneChercheurService.save(element);
        });
        campagne.setCampagneChercheurs(savedCampagneChercheurs);
        }*/
        }
        private  void saveCampagneChercheurOuvertures(Campagne campagne,List<CampagneChercheurOuverture> campagneChercheurOuvertures){

        if (ListUtil.isNotEmpty(campagne.getCampagneChercheurOuvertures())) {
        List<CampagneChercheurOuverture> savedCampagneChercheurOuvertures = new ArrayList<>();
        campagneChercheurOuvertures.forEach(element -> {
        element.setCampagne(campagne);
        campagneChercheurOuvertureService.save(element);
        });
        campagne.setCampagneChercheurOuvertures(savedCampagneChercheurOuvertures);
        }
        }
        private  void saveCampagneChercheurFermetures(Campagne campagne,List<CampagneChercheurFermeture> campagneChercheurFermetures){

        if (ListUtil.isNotEmpty(campagne.getCampagneChercheurFermetures())) {
        List<CampagneChercheurFermeture> savedCampagneChercheurFermetures = new ArrayList<>();
        campagneChercheurFermetures.forEach(element -> {
        element.setCampagne(campagne);
        campagneChercheurFermetureService.save(element);
        });
        campagne.setCampagneChercheurFermetures(savedCampagneChercheurFermetures);
        }
        }
        private  void saveCampagneRelances(Campagne campagne,List<CampagneRelance> campagneRelances){

        if (ListUtil.isNotEmpty(campagne.getCampagneRelances())) {
        List<CampagneRelance> savedCampagneRelances = new ArrayList<>();
        campagneRelances.forEach(element -> {
        element.setCampagne(campagne);
        campagneRelanceService.save(element);
        });
        campagne.setCampagneRelances(savedCampagneRelances);
        }
        }
        private  void saveCampagneRappels(Campagne campagne,List<CampagneRappel> campagneRappels){

        if (ListUtil.isNotEmpty(campagne.getCampagneRappels())) {
        List<CampagneRappel> savedCampagneRappels = new ArrayList<>();
        campagneRappels.forEach(element -> {
        element.setCampagne(campagne);
        campagneRappelService.save(element);
        });
        campagne.setCampagneRappels(savedCampagneRappels);
        }
        }

    private void findEtatCampagne(Campagne campagne){
        EtatCampagne loadedEtatCampagne =etatCampagneService.findByIdOrCode(campagne.getEtatCampagne());

    if(loadedEtatCampagne==null ) {
        return;
    }
    campagne.setEtatCampagne(loadedEtatCampagne);
    }
    private void findTemplateOuverture(Campagne campagne){
        TemplateOuverture loadedTemplateOuverture =templateOuvertureService.findByIdOrCode(campagne.getTemplateOuverture());

    if(loadedTemplateOuverture==null ) {
        return;
    }
    campagne.setTemplateOuverture(loadedTemplateOuverture);
    }
    private void findTemplateCloture(Campagne campagne){
        TemplateCloture loadedTemplateCloture =templateClotureService.findByIdOrCode(campagne.getTemplateCloture());

    if(loadedTemplateCloture==null ) {
        return;
    }
    campagne.setTemplateCloture(loadedTemplateCloture);
    }

@Override
@Transactional
public void delete(List<Campagne> campagnes){
        if(ListUtil.isNotEmpty(campagnes)){
        campagnes.forEach(e->campagneDao.delete(e));
        }
}
@Override
public void update(List<Campagne> campagnes){
if(ListUtil.isNotEmpty(campagnes)){
campagnes.forEach(e->campagneDao.save(e));
}
}

private void associateCampagneChercheur(Campagne campagne, List<CampagneChercheur> campagneChercheur) {
    if (ListUtil.isNotEmpty(campagneChercheur)) {
        campagneChercheur.forEach(e -> e.setCampagne(campagne));
    }
    }
private void associateCampagneChercheurOuverture(Campagne campagne, List<CampagneChercheurOuverture> campagneChercheurOuverture) {
    if (ListUtil.isNotEmpty(campagneChercheurOuverture)) {
        campagneChercheurOuverture.forEach(e -> e.setCampagne(campagne));
    }
    }
private void associateCampagneChercheurFermeture(Campagne campagne, List<CampagneChercheurFermeture> campagneChercheurFermeture) {
    if (ListUtil.isNotEmpty(campagneChercheurFermeture)) {
        campagneChercheurFermeture.forEach(e -> e.setCampagne(campagne));
    }
    }
private void associateCampagneRelance(Campagne campagne, List<CampagneRelance> campagneRelance) {
    if (ListUtil.isNotEmpty(campagneRelance)) {
        campagneRelance.forEach(e -> e.setCampagne(campagne));
    }
    }
private void associateCampagneRappel(Campagne campagne, List<CampagneRappel> campagneRappel) {
    if (ListUtil.isNotEmpty(campagneRappel)) {
        campagneRappel.forEach(e -> e.setCampagne(campagne));
    }
    }

@Override
public Campagne findProgressCampagneByChercheurUsername(String username) {
	Chercheur chercheur = SecurityUtil.getCurrentChercheur();
	
String query = "SELECT o FROM Campagne o ";
query += "inner join  CampagneChercheurOuverture cc on o.id=cc.campagne.id where 1=1";
query += SearchUtil.addConstraint("cc", "chercheur.username", "=", chercheur.getUsername());
query += SearchUtil.addConstraint("o", "etatCampagne.code", "!=", "termine");
query += " ORDER BY o.dateDepart DESC";
List<Campagne> campagnes = entityManager.createQuery(query).getResultList();
    if (campagnes != null && !campagnes.isEmpty()) {
    return campagnes.get(0);
    }
    return null;
    }

@Override
public List<List<Campagne>>  getToBeSavedAndToBeDeleted(List<Campagne> oldList,List<Campagne> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

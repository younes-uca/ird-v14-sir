package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.Chercheur;
        import com.ird.faa.bean.referentiel.TypeEntiteAdministrative;
        import com.ird.faa.bean.referentiel.EntiteAdministrative;
        import com.ird.faa.bean.referentiel.Pays;
        import com.ird.faa.bean.referentiel.Ville;
        import com.ird.faa.bean.formulaire.DepartementScientifique;
        import com.ird.faa.bean.formulaire.CommissionScientifique;
        import com.ird.faa.bean.referentiel.Grade;
        import com.ird.faa.bean.referentiel.Corps;
        import com.ird.faa.bean.referentiel.Sexe;
import com.ird.faa.dao.formulaire.ChercheurDao;
import com.ird.faa.service.chercheur.facade.formulaire.ChercheurChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.CommunauteSavoirChercheurChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.TypeEntiteAdministrativeChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.DepartementScientifiqueChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.ZoneActiviteInteractionRechercheChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.GradeChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.CorpsChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.CommissionScientifiqueChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.PaysChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.IdentifiantAuteurExpertChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.DomaineScientifiqueChercheurChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.EntiteAdministrativeChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.SexeChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.VilleChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.InstrumentsEtDispositifsIrdChercheurChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ChercheurVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.formulaire.DomaineScientifiqueChercheur;
import com.ird.faa.bean.formulaire.ZoneActiviteInteractionRecherche;
import com.ird.faa.bean.formulaire.CommunauteSavoirChercheur;
import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrdChercheur;
import com.ird.faa.bean.formulaire.IdentifiantAuteurExpert;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ChercheurChercheurServiceImpl extends AbstractServiceImpl<Chercheur> implements ChercheurChercheurService {

@Autowired
private ChercheurDao chercheurDao;

        @Autowired
        private CommunauteSavoirChercheurChercheurService communauteSavoirChercheurService ;
        @Autowired
        private TypeEntiteAdministrativeChercheurService typeEntiteAdministrativeService ;
        @Autowired
        private DepartementScientifiqueChercheurService departementScientifiqueService ;
        @Autowired
        private ZoneActiviteInteractionRechercheChercheurService zoneActiviteInteractionRechercheService ;
        @Autowired
        private GradeChercheurService gradeService ;
        @Autowired
        private CorpsChercheurService corpsService ;
        @Autowired
        private CommissionScientifiqueChercheurService commissionScientifiqueService ;
        @Autowired
        private PaysChercheurService paysService ;
        @Autowired
        private IdentifiantAuteurExpertChercheurService identifiantAuteurExpertService ;
        @Autowired
        private DomaineScientifiqueChercheurChercheurService domaineScientifiqueChercheurService ;
        @Autowired
        private EntiteAdministrativeChercheurService entiteAdministrativeService ;
        @Autowired
        private SexeChercheurService sexeService ;
        @Autowired
        private VilleChercheurService villeService ;
        @Autowired
        private InstrumentsEtDispositifsIrdChercheurChercheurService instrumentsEtDispositifsIrdChercheurService ;

 
@Autowired
private EntityManager entityManager;

    @Override
   public Chercheur findByUsername(String username){
    return chercheurDao.findByUsername(username);
    }

@Override
public List<Chercheur> findAll(){
return chercheurDao.findAll();
}

        @Override
        public List<Chercheur> findByTypeEntiteAdministrativeCode(String code){
        return chercheurDao.findByTypeEntiteAdministrativeCode(code);
        }

        @Override
        @Transactional
        public int deleteByTypeEntiteAdministrativeCode(String code){
        return chercheurDao.deleteByTypeEntiteAdministrativeCode(code);
        }

        @Override
        public List<Chercheur> findByTypeEntiteAdministrativeId(Long id){
        return chercheurDao.findByTypeEntiteAdministrativeId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeEntiteAdministrativeId(Long id){
        return chercheurDao.deleteByTypeEntiteAdministrativeId(id);
        }


        @Override
        public List<Chercheur> findByEntiteAdministrativeCode(String code){
        return chercheurDao.findByEntiteAdministrativeCode(code);
        }

        @Override
        @Transactional
        public int deleteByEntiteAdministrativeCode(String code){
        return chercheurDao.deleteByEntiteAdministrativeCode(code);
        }

        @Override
        public List<Chercheur> findByEntiteAdministrativeId(Long id){
        return chercheurDao.findByEntiteAdministrativeId(id);
        }

        @Override
        @Transactional
        public int deleteByEntiteAdministrativeId(Long id){
        return chercheurDao.deleteByEntiteAdministrativeId(id);
        }


        @Override
        public List<Chercheur> findByPaysCode(String code){
        return chercheurDao.findByPaysCode(code);
        }

        @Override
        @Transactional
        public int deleteByPaysCode(String code){
        return chercheurDao.deleteByPaysCode(code);
        }

        @Override
        public List<Chercheur> findByPaysId(Long id){
        return chercheurDao.findByPaysId(id);
        }

        @Override
        @Transactional
        public int deleteByPaysId(Long id){
        return chercheurDao.deleteByPaysId(id);
        }


        @Override
        public List<Chercheur> findByVilleCode(String code){
        return chercheurDao.findByVilleCode(code);
        }

        @Override
        @Transactional
        public int deleteByVilleCode(String code){
        return chercheurDao.deleteByVilleCode(code);
        }

        @Override
        public List<Chercheur> findByVilleId(Long id){
        return chercheurDao.findByVilleId(id);
        }

        @Override
        @Transactional
        public int deleteByVilleId(Long id){
        return chercheurDao.deleteByVilleId(id);
        }


        @Override
        public List<Chercheur> findByDepartementScientifiqueCode(String code){
        return chercheurDao.findByDepartementScientifiqueCode(code);
        }

        @Override
        @Transactional
        public int deleteByDepartementScientifiqueCode(String code){
        return chercheurDao.deleteByDepartementScientifiqueCode(code);
        }

        @Override
        public List<Chercheur> findByDepartementScientifiqueId(Long id){
        return chercheurDao.findByDepartementScientifiqueId(id);
        }

        @Override
        @Transactional
        public int deleteByDepartementScientifiqueId(Long id){
        return chercheurDao.deleteByDepartementScientifiqueId(id);
        }


        @Override
        public List<Chercheur> findByCommissionScientifiqueCode(String code){
        return chercheurDao.findByCommissionScientifiqueCode(code);
        }

        @Override
        @Transactional
        public int deleteByCommissionScientifiqueCode(String code){
        return chercheurDao.deleteByCommissionScientifiqueCode(code);
        }

        @Override
        public List<Chercheur> findByCommissionScientifiqueId(Long id){
        return chercheurDao.findByCommissionScientifiqueId(id);
        }

        @Override
        @Transactional
        public int deleteByCommissionScientifiqueId(Long id){
        return chercheurDao.deleteByCommissionScientifiqueId(id);
        }


        @Override
        public List<Chercheur> findByGradeCode(String code){
        return chercheurDao.findByGradeCode(code);
        }

        @Override
        @Transactional
        public int deleteByGradeCode(String code){
        return chercheurDao.deleteByGradeCode(code);
        }

        @Override
        public List<Chercheur> findByGradeId(Long id){
        return chercheurDao.findByGradeId(id);
        }

        @Override
        @Transactional
        public int deleteByGradeId(Long id){
        return chercheurDao.deleteByGradeId(id);
        }


        @Override
        public List<Chercheur> findByCorpsCode(String code){
        return chercheurDao.findByCorpsCode(code);
        }

        @Override
        @Transactional
        public int deleteByCorpsCode(String code){
        return chercheurDao.deleteByCorpsCode(code);
        }

        @Override
        public List<Chercheur> findByCorpsId(Long id){
        return chercheurDao.findByCorpsId(id);
        }

        @Override
        @Transactional
        public int deleteByCorpsId(Long id){
        return chercheurDao.deleteByCorpsId(id);
        }


        @Override
        public List<Chercheur> findBySexeCode(String code){
        return chercheurDao.findBySexeCode(code);
        }

        @Override
        @Transactional
        public int deleteBySexeCode(String code){
        return chercheurDao.deleteBySexeCode(code);
        }

        @Override
        public List<Chercheur> findBySexeId(Long id){
        return chercheurDao.findBySexeId(id);
        }

        @Override
        @Transactional
        public int deleteBySexeId(Long id){
        return chercheurDao.deleteBySexeId(id);
        }

    @Override
    public Chercheur findByNumeroMatricule(String numeroMatricule){
    if( numeroMatricule==null) return null;
    return chercheurDao.findByNumeroMatricule(numeroMatricule);
    }

    @Override
    @Transactional
    public int deleteByNumeroMatricule(String  numeroMatricule) {
    return chercheurDao.deleteByNumeroMatricule(numeroMatricule);
    }
    @Override
    public Chercheur findByIdOrNumeroMatricule(Chercheur chercheur){
    Chercheur resultat=null;
    if(chercheur == null || ( chercheur.getNumeroMatricule()==null && chercheur.getId()==null))
    return resultat;
    else{
    if(chercheur.getId() != null){
    resultat= chercheurDao.findById(chercheur.getId()).get();
    }else if(StringUtil.isNotEmpty(chercheur.getNumeroMatricule())) {
    resultat= chercheurDao.findByNumeroMatricule(chercheur.getNumeroMatricule());
    }else if(StringUtil.isNotEmpty(chercheur.getUsername())) {
    resultat = chercheurDao.findByUsername(chercheur.getUsername());
    }
    return resultat;
    }
    }

@Override
public Chercheur findById(Long id){
if(id==null) return null;
return chercheurDao.getOne(id);
}

@Override
public Chercheur findByIdWithAssociatedList(Long id){
Chercheur chercheur  = findById(id);
    findAssociatedLists(chercheur);
return chercheur;
}
private void findAssociatedLists(Chercheur chercheur){
if(chercheur==null || chercheur.getId()==null) return ;
else{
        List<DomaineScientifiqueChercheur> domaineScientifiqueChercheurs = domaineScientifiqueChercheurService.findByChercheurId(chercheur.getId());
        chercheur.setDomaineScientifiqueChercheurs(domaineScientifiqueChercheurs);
        List<ZoneActiviteInteractionRecherche> zoneActiviteInteractionRecherches = zoneActiviteInteractionRechercheService.findByChercheurId(chercheur.getId());
        chercheur.setZoneActiviteInteractionRecherches(zoneActiviteInteractionRecherches);
        List<CommunauteSavoirChercheur> communauteSavoirChercheurs = communauteSavoirChercheurService.findByChercheurId(chercheur.getId());
        chercheur.setCommunauteSavoirChercheurs(communauteSavoirChercheurs);
        List<InstrumentsEtDispositifsIrdChercheur> instrumentsEtDispositifsIrdChercheurs = instrumentsEtDispositifsIrdChercheurService.findByChercheurId(chercheur.getId());
        chercheur.setInstrumentsEtDispositifsIrdChercheurs(instrumentsEtDispositifsIrdChercheurs);
        List<IdentifiantAuteurExpert> identifiantAuteurExperts = identifiantAuteurExpertService.findByChercheurId(chercheur.getId());
        chercheur.setIdentifiantAuteurExperts(identifiantAuteurExperts);
}
}
private void deleteAssociatedLists(Long id){
if(id==null ) return ;
else{
        domaineScientifiqueChercheurService.deleteByChercheurId(id);
        zoneActiviteInteractionRechercheService.deleteByChercheurId(id);
        communauteSavoirChercheurService.deleteByChercheurId(id);
        instrumentsEtDispositifsIrdChercheurService.deleteByChercheurId(id);
        identifiantAuteurExpertService.deleteByChercheurId(id);
}
}

    private void updateAssociatedLists(Chercheur chercheur){
    if(chercheur==null || chercheur.getId()==null) return ;
    else{
            List<List<DomaineScientifiqueChercheur>> resultDomaineScientifiqueChercheurs= domaineScientifiqueChercheurService.getToBeSavedAndToBeDeleted(domaineScientifiqueChercheurService.findByChercheurId(chercheur.getId()),chercheur.getDomaineScientifiqueChercheurs());
            domaineScientifiqueChercheurService.delete(resultDomaineScientifiqueChercheurs.get(1));
            associateDomaineScientifiqueChercheur(chercheur,resultDomaineScientifiqueChercheurs.get(0));
            domaineScientifiqueChercheurService.update(resultDomaineScientifiqueChercheurs.get(0));

            List<List<ZoneActiviteInteractionRecherche>> resultZoneActiviteInteractionRecherches= zoneActiviteInteractionRechercheService.getToBeSavedAndToBeDeleted(zoneActiviteInteractionRechercheService.findByChercheurId(chercheur.getId()),chercheur.getZoneActiviteInteractionRecherches());
            zoneActiviteInteractionRechercheService.delete(resultZoneActiviteInteractionRecherches.get(1));
            associateZoneActiviteInteractionRecherche(chercheur,resultZoneActiviteInteractionRecherches.get(0));
            zoneActiviteInteractionRechercheService.update(resultZoneActiviteInteractionRecherches.get(0));

            List<List<CommunauteSavoirChercheur>> resultCommunauteSavoirChercheurs= communauteSavoirChercheurService.getToBeSavedAndToBeDeleted(communauteSavoirChercheurService.findByChercheurId(chercheur.getId()),chercheur.getCommunauteSavoirChercheurs());
            communauteSavoirChercheurService.delete(resultCommunauteSavoirChercheurs.get(1));
            associateCommunauteSavoirChercheur(chercheur,resultCommunauteSavoirChercheurs.get(0));
            communauteSavoirChercheurService.update(resultCommunauteSavoirChercheurs.get(0));

            List<List<InstrumentsEtDispositifsIrdChercheur>> resultInstrumentsEtDispositifsIrdChercheurs= instrumentsEtDispositifsIrdChercheurService.getToBeSavedAndToBeDeleted(instrumentsEtDispositifsIrdChercheurService.findByChercheurId(chercheur.getId()),chercheur.getInstrumentsEtDispositifsIrdChercheurs());
            instrumentsEtDispositifsIrdChercheurService.delete(resultInstrumentsEtDispositifsIrdChercheurs.get(1));
            associateInstrumentsEtDispositifsIrdChercheur(chercheur,resultInstrumentsEtDispositifsIrdChercheurs.get(0));
            instrumentsEtDispositifsIrdChercheurService.update(resultInstrumentsEtDispositifsIrdChercheurs.get(0));

            List<List<IdentifiantAuteurExpert>> resultIdentifiantAuteurExperts= identifiantAuteurExpertService.getToBeSavedAndToBeDeleted(identifiantAuteurExpertService.findByChercheurId(chercheur.getId()),chercheur.getIdentifiantAuteurExperts());
            identifiantAuteurExpertService.delete(resultIdentifiantAuteurExperts.get(1));
            associateIdentifiantAuteurExpert(chercheur,resultIdentifiantAuteurExperts.get(0));
            identifiantAuteurExpertService.update(resultIdentifiantAuteurExperts.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
if(chercheurDao.findById(id) == null) return 0;
else{
deleteAssociatedLists(id);
chercheurDao.deleteById(id);
return 1;
}
}


@Override
public Chercheur update(Chercheur chercheur){
Chercheur foundedChercheur = findById(chercheur.getId());
if(foundedChercheur==null) return null;
else{
    updateAssociatedLists(chercheur);
return  chercheurDao.save(chercheur);
}
}

@Override
public Chercheur save (Chercheur chercheur){
    Chercheur foundedChercheur = findByNumeroMatricule(chercheur.getNumeroMatricule());
   if(foundedChercheur!=null) return null;


    findTypeEntiteAdministrative(chercheur);
    findEntiteAdministrative(chercheur);
    findPays(chercheur);
    findVille(chercheur);
    findDepartementScientifique(chercheur);
    findCommissionScientifique(chercheur);
    findGrade(chercheur);
    findCorps(chercheur);
    findSexe(chercheur);

Chercheur savedChercheur = chercheurDao.save(chercheur);
       saveDomaineScientifiqueChercheurs(savedChercheur,chercheur.getDomaineScientifiqueChercheurs());
       saveZoneActiviteInteractionRecherches(savedChercheur,chercheur.getZoneActiviteInteractionRecherches());
       saveCommunauteSavoirChercheurs(savedChercheur,chercheur.getCommunauteSavoirChercheurs());
       saveInstrumentsEtDispositifsIrdChercheurs(savedChercheur,chercheur.getInstrumentsEtDispositifsIrdChercheurs());
       saveIdentifiantAuteurExperts(savedChercheur,chercheur.getIdentifiantAuteurExperts());
return savedChercheur;
}

@Override
public List<Chercheur> save(List<Chercheur> chercheurs){
List<Chercheur> list = new ArrayList<Chercheur>();
for(Chercheur chercheur: chercheurs){
list.add(save(chercheur));
}
return list;
}



@Override
@Transactional
public int delete(Chercheur chercheur){
    if(chercheur.getNumeroMatricule()==null) return -1;

    Chercheur foundedChercheur = findByNumeroMatricule(chercheur.getNumeroMatricule());
    if(foundedChercheur==null) return -1;
chercheurDao.delete(foundedChercheur);
return 1;
}


public List<Chercheur> findByCriteria(ChercheurVo chercheurVo){

String query = "SELECT o FROM Chercheur o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",chercheurVo.getId());
            query += SearchUtil.addConstraint( "o", "numeroMatricule","LIKE",chercheurVo.getNumeroMatricule());
            query += SearchUtil.addConstraint( "o", "email","LIKE",chercheurVo.getEmail());
            query += SearchUtil.addConstraint( "o", "natureImplication","LIKE",chercheurVo.getNatureImplication());
            query += SearchUtil.addConstraint( "o", "resume","LIKE",chercheurVo.getResume());
            query += SearchUtil.addConstraint( "o", "formationEnManagement","=",chercheurVo.getFormationEnManagement());
            query += SearchUtil.addConstraint( "o", "credentialsNonExpired","=",chercheurVo.getCredentialsNonExpired());
            query += SearchUtil.addConstraint( "o", "enabled","=",chercheurVo.getEnabled());
        query += SearchUtil.addConstraintDate( "o", "createdAt","=",chercheurVo.getCreatedAt());
        query += SearchUtil.addConstraintDate( "o", "updatedAt","=",chercheurVo.getUpdatedAt());
            query += SearchUtil.addConstraint( "o", "accountNonExpired","=",chercheurVo.getAccountNonExpired());
            query += SearchUtil.addConstraint( "o", "accountNonLocked","=",chercheurVo.getAccountNonLocked());
            query += SearchUtil.addConstraint( "o", "username","LIKE",chercheurVo.getUsername());
            query += SearchUtil.addConstraint( "o", "password","LIKE",chercheurVo.getPassword());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",chercheurVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",chercheurVo.getNom());
            query += SearchUtil.addConstraint( "o", "role","LIKE",chercheurVo.getRole());
            query += SearchUtil.addConstraint( "o", "passwordChanged","=",chercheurVo.getPasswordChanged());
            query += SearchUtil.addConstraintMinMaxDate("o","createdAt",chercheurVo.getCreatedAtMin(),chercheurVo.getCreatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","updatedAt",chercheurVo.getUpdatedAtMin(),chercheurVo.getUpdatedAtMax());
    if(chercheurVo.getTypeEntiteAdministrativeVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeEntiteAdministrative.id","=",chercheurVo.getTypeEntiteAdministrativeVo().getId());
            query += SearchUtil.addConstraint( "o", "typeEntiteAdministrative.code","LIKE",chercheurVo.getTypeEntiteAdministrativeVo().getCode());
    }

    if(chercheurVo.getEntiteAdministrativeVo()!=null){
        query += SearchUtil.addConstraint( "o", "entiteAdministrative.id","=",chercheurVo.getEntiteAdministrativeVo().getId());
            query += SearchUtil.addConstraint( "o", "entiteAdministrative.code","LIKE",chercheurVo.getEntiteAdministrativeVo().getCode());
    }

    if(chercheurVo.getPaysVo()!=null){
        query += SearchUtil.addConstraint( "o", "pays.id","=",chercheurVo.getPaysVo().getId());
            query += SearchUtil.addConstraint( "o", "pays.code","LIKE",chercheurVo.getPaysVo().getCode());
    }

    if(chercheurVo.getVilleVo()!=null){
        query += SearchUtil.addConstraint( "o", "ville.id","=",chercheurVo.getVilleVo().getId());
            query += SearchUtil.addConstraint( "o", "ville.code","LIKE",chercheurVo.getVilleVo().getCode());
    }

    if(chercheurVo.getDepartementScientifiqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "departementScientifique.id","=",chercheurVo.getDepartementScientifiqueVo().getId());
            query += SearchUtil.addConstraint( "o", "departementScientifique.code","LIKE",chercheurVo.getDepartementScientifiqueVo().getCode());
    }

    if(chercheurVo.getCommissionScientifiqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "commissionScientifique.id","=",chercheurVo.getCommissionScientifiqueVo().getId());
            query += SearchUtil.addConstraint( "o", "commissionScientifique.code","LIKE",chercheurVo.getCommissionScientifiqueVo().getCode());
    }

    if(chercheurVo.getGradeVo()!=null){
        query += SearchUtil.addConstraint( "o", "grade.id","=",chercheurVo.getGradeVo().getId());
            query += SearchUtil.addConstraint( "o", "grade.code","LIKE",chercheurVo.getGradeVo().getCode());
    }

    if(chercheurVo.getCorpsVo()!=null){
        query += SearchUtil.addConstraint( "o", "corps.id","=",chercheurVo.getCorpsVo().getId());
            query += SearchUtil.addConstraint( "o", "corps.code","LIKE",chercheurVo.getCorpsVo().getCode());
    }

    if(chercheurVo.getSexeVo()!=null){
        query += SearchUtil.addConstraint( "o", "sexe.id","=",chercheurVo.getSexeVo().getId());
            query += SearchUtil.addConstraint( "o", "sexe.code","LIKE",chercheurVo.getSexeVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}
        private  void saveDomaineScientifiqueChercheurs(Chercheur chercheur,List<DomaineScientifiqueChercheur> domaineScientifiqueChercheurs){

        if (ListUtil.isNotEmpty(chercheur.getDomaineScientifiqueChercheurs())) {
        List<DomaineScientifiqueChercheur> savedDomaineScientifiqueChercheurs = new ArrayList<>();
        domaineScientifiqueChercheurs.forEach(element -> {
        element.setChercheur(chercheur);
        domaineScientifiqueChercheurService.save(element);
        });
        chercheur.setDomaineScientifiqueChercheurs(savedDomaineScientifiqueChercheurs);
        }
        }
        private  void saveZoneActiviteInteractionRecherches(Chercheur chercheur,List<ZoneActiviteInteractionRecherche> zoneActiviteInteractionRecherches){

        if (ListUtil.isNotEmpty(chercheur.getZoneActiviteInteractionRecherches())) {
        List<ZoneActiviteInteractionRecherche> savedZoneActiviteInteractionRecherches = new ArrayList<>();
        zoneActiviteInteractionRecherches.forEach(element -> {
        element.setChercheur(chercheur);
        zoneActiviteInteractionRechercheService.save(element);
        });
        chercheur.setZoneActiviteInteractionRecherches(savedZoneActiviteInteractionRecherches);
        }
        }
        private  void saveCommunauteSavoirChercheurs(Chercheur chercheur,List<CommunauteSavoirChercheur> communauteSavoirChercheurs){

        if (ListUtil.isNotEmpty(chercheur.getCommunauteSavoirChercheurs())) {
        List<CommunauteSavoirChercheur> savedCommunauteSavoirChercheurs = new ArrayList<>();
        communauteSavoirChercheurs.forEach(element -> {
        element.setChercheur(chercheur);
        communauteSavoirChercheurService.save(element);
        });
        chercheur.setCommunauteSavoirChercheurs(savedCommunauteSavoirChercheurs);
        }
        }
        private  void saveInstrumentsEtDispositifsIrdChercheurs(Chercheur chercheur,List<InstrumentsEtDispositifsIrdChercheur> instrumentsEtDispositifsIrdChercheurs){

        if (ListUtil.isNotEmpty(chercheur.getInstrumentsEtDispositifsIrdChercheurs())) {
        List<InstrumentsEtDispositifsIrdChercheur> savedInstrumentsEtDispositifsIrdChercheurs = new ArrayList<>();
        instrumentsEtDispositifsIrdChercheurs.forEach(element -> {
        element.setChercheur(chercheur);
        instrumentsEtDispositifsIrdChercheurService.save(element);
        });
        chercheur.setInstrumentsEtDispositifsIrdChercheurs(savedInstrumentsEtDispositifsIrdChercheurs);
        }
        }
        private  void saveIdentifiantAuteurExperts(Chercheur chercheur,List<IdentifiantAuteurExpert> identifiantAuteurExperts){

        if (ListUtil.isNotEmpty(chercheur.getIdentifiantAuteurExperts())) {
        List<IdentifiantAuteurExpert> savedIdentifiantAuteurExperts = new ArrayList<>();
        identifiantAuteurExperts.forEach(element -> {
        element.setChercheur(chercheur);
        identifiantAuteurExpertService.save(element);
        });
        chercheur.setIdentifiantAuteurExperts(savedIdentifiantAuteurExperts);
        }
        }

    private void findTypeEntiteAdministrative(Chercheur chercheur){
        TypeEntiteAdministrative loadedTypeEntiteAdministrative =typeEntiteAdministrativeService.findByIdOrCode(chercheur.getTypeEntiteAdministrative());

    if(loadedTypeEntiteAdministrative==null ) {
        return;
    }
    chercheur.setTypeEntiteAdministrative(loadedTypeEntiteAdministrative);
    }
    private void findEntiteAdministrative(Chercheur chercheur){
        EntiteAdministrative loadedEntiteAdministrative =entiteAdministrativeService.findByIdOrCode(chercheur.getEntiteAdministrative());

    if(loadedEntiteAdministrative==null ) {
        return;
    }
    chercheur.setEntiteAdministrative(loadedEntiteAdministrative);
    }
    private void findPays(Chercheur chercheur){
        Pays loadedPays =paysService.findByIdOrCode(chercheur.getPays());

    if(loadedPays==null ) {
        return;
    }
    chercheur.setPays(loadedPays);
    }
    private void findVille(Chercheur chercheur){
        Ville loadedVille =villeService.findByIdOrCode(chercheur.getVille());

    if(loadedVille==null ) {
        return;
    }
    chercheur.setVille(loadedVille);
    }
    private void findDepartementScientifique(Chercheur chercheur){
        DepartementScientifique loadedDepartementScientifique =departementScientifiqueService.findByIdOrCode(chercheur.getDepartementScientifique());

    if(loadedDepartementScientifique==null ) {
        return;
    }
    chercheur.setDepartementScientifique(loadedDepartementScientifique);
    }
    private void findCommissionScientifique(Chercheur chercheur){
        CommissionScientifique loadedCommissionScientifique =commissionScientifiqueService.findByIdOrCode(chercheur.getCommissionScientifique());

    if(loadedCommissionScientifique==null ) {
        return;
    }
    chercheur.setCommissionScientifique(loadedCommissionScientifique);
    }
    private void findGrade(Chercheur chercheur){
        Grade loadedGrade =gradeService.findByIdOrCode(chercheur.getGrade());

    if(loadedGrade==null ) {
        return;
    }
    chercheur.setGrade(loadedGrade);
    }
    private void findCorps(Chercheur chercheur){
        Corps loadedCorps =corpsService.findByIdOrCode(chercheur.getCorps());

    if(loadedCorps==null ) {
        return;
    }
    chercheur.setCorps(loadedCorps);
    }
    private void findSexe(Chercheur chercheur){
        Sexe loadedSexe =sexeService.findByIdOrCode(chercheur.getSexe());

    if(loadedSexe==null ) {
        return;
    }
    chercheur.setSexe(loadedSexe);
    }

@Override
@Transactional
public void delete(List<Chercheur> chercheurs){
        if(ListUtil.isNotEmpty(chercheurs)){
        chercheurs.forEach(e->chercheurDao.delete(e));
        }
}
@Override
public void update(List<Chercheur> chercheurs){
if(ListUtil.isNotEmpty(chercheurs)){
chercheurs.forEach(e->chercheurDao.save(e));
}
}

private void associateDomaineScientifiqueChercheur(Chercheur chercheur, List<DomaineScientifiqueChercheur> domaineScientifiqueChercheur) {
    if (ListUtil.isNotEmpty(domaineScientifiqueChercheur)) {
        domaineScientifiqueChercheur.forEach(e -> e.setChercheur(chercheur));
    }
    }
private void associateZoneActiviteInteractionRecherche(Chercheur chercheur, List<ZoneActiviteInteractionRecherche> zoneActiviteInteractionRecherche) {
    if (ListUtil.isNotEmpty(zoneActiviteInteractionRecherche)) {
        zoneActiviteInteractionRecherche.forEach(e -> e.setChercheur(chercheur));
    }
    }
private void associateCommunauteSavoirChercheur(Chercheur chercheur, List<CommunauteSavoirChercheur> communauteSavoirChercheur) {
    if (ListUtil.isNotEmpty(communauteSavoirChercheur)) {
        communauteSavoirChercheur.forEach(e -> e.setChercheur(chercheur));
    }
    }
private void associateInstrumentsEtDispositifsIrdChercheur(Chercheur chercheur, List<InstrumentsEtDispositifsIrdChercheur> instrumentsEtDispositifsIrdChercheur) {
    if (ListUtil.isNotEmpty(instrumentsEtDispositifsIrdChercheur)) {
        instrumentsEtDispositifsIrdChercheur.forEach(e -> e.setChercheur(chercheur));
    }
    }
private void associateIdentifiantAuteurExpert(Chercheur chercheur, List<IdentifiantAuteurExpert> identifiantAuteurExpert) {
    if (ListUtil.isNotEmpty(identifiantAuteurExpert)) {
        identifiantAuteurExpert.forEach(e -> e.setChercheur(chercheur));
    }
    }


@Override
public List<List<Chercheur>>  getToBeSavedAndToBeDeleted(List<Chercheur> oldList,List<Chercheur> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	// TODO Auto-generated method stub
	Chercheur chercheur = chercheurDao.findByUsername(username);
	return chercheur;
}



}

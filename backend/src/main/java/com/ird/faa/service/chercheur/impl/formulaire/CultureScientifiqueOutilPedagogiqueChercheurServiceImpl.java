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
import com.ird.faa.bean.formulaire.CultureScientifiqueOutilPedagogique;
        import com.ird.faa.bean.formulaire.Campagne;
        import com.ird.faa.bean.formulaire.Chercheur;
        import com.ird.faa.bean.config.EtatEtapeCampagne;
import com.ird.faa.dao.formulaire.CultureScientifiqueOutilPedagogiqueDao;
import com.ird.faa.service.chercheur.facade.formulaire.CultureScientifiqueOutilPedagogiqueChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.EtablissementCultureScientifiqueOutilPedagogiqueChercheurService;
        import com.ird.faa.service.chercheur.facade.config.EtatEtapeCampagneChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.PaysTypeOutilCultureScientifiqueOutilPedagogiqueChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.TypeOutilCultureScientifiqueOutilPedagogiqueChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.CampagneChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.PublicCibleCultureScientifiqueOutilPedagogiqueChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.ChercheurChercheurService;

import com.ird.faa.ws.rest.provided.vo.CultureScientifiqueOutilPedagogiqueVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.formulaire.PublicCibleCultureScientifiqueOutilPedagogique;
import com.ird.faa.bean.formulaire.TypeOutilCultureScientifiqueOutilPedagogique;
import com.ird.faa.bean.formulaire.PaysTypeOutilCultureScientifiqueOutilPedagogique;
import com.ird.faa.bean.formulaire.EtablissementCultureScientifiqueOutilPedagogique;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CultureScientifiqueOutilPedagogiqueChercheurServiceImpl extends AbstractServiceImpl<CultureScientifiqueOutilPedagogique> implements CultureScientifiqueOutilPedagogiqueChercheurService {

@Autowired
private CultureScientifiqueOutilPedagogiqueDao cultureScientifiqueOutilPedagogiqueDao;

        @Autowired
        private EtablissementCultureScientifiqueOutilPedagogiqueChercheurService etablissementCultureScientifiqueOutilPedagogiqueService ;
        @Autowired
        private EtatEtapeCampagneChercheurService etatEtapeCampagneService ;
        @Autowired
        private PaysTypeOutilCultureScientifiqueOutilPedagogiqueChercheurService paysTypeOutilCultureScientifiqueOutilPedagogiqueService ;
        @Autowired
        private TypeOutilCultureScientifiqueOutilPedagogiqueChercheurService typeOutilCultureScientifiqueOutilPedagogiqueService ;
        @Autowired
        private CampagneChercheurService campagneService ;
        @Autowired
        private PublicCibleCultureScientifiqueOutilPedagogiqueChercheurService publicCibleCultureScientifiqueOutilPedagogiqueService ;
        @Autowired
        private ChercheurChercheurService chercheurService ;


@Autowired
private EntityManager entityManager;


@Override
public List<CultureScientifiqueOutilPedagogique> findAll(){
User currentUser = SecurityUtil.getCurrentUser();
if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
    return cultureScientifiqueOutilPedagogiqueDao.findByChercheurUsername(currentUser.getUsername());
    }
    return new ArrayList<>();
}

        @Override
        public List<CultureScientifiqueOutilPedagogique> findByCampagneCode(String code){
        return cultureScientifiqueOutilPedagogiqueDao.findByCampagneCode(code);
        }

        @Override
        @Transactional
        public int deleteByCampagneCode(String code){
        return cultureScientifiqueOutilPedagogiqueDao.deleteByCampagneCode(code);
        }

        @Override
        public List<CultureScientifiqueOutilPedagogique> findByCampagneId(Long id){
        return cultureScientifiqueOutilPedagogiqueDao.findByCampagneId(id);
        }

        @Override
        @Transactional
        public int deleteByCampagneId(Long id){
        return cultureScientifiqueOutilPedagogiqueDao.deleteByCampagneId(id);
        }


        @Override
        public List<CultureScientifiqueOutilPedagogique> findByChercheurNumeroMatricule(String numeroMatricule){
        return cultureScientifiqueOutilPedagogiqueDao.findByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByChercheurNumeroMatricule(String numeroMatricule){
        return cultureScientifiqueOutilPedagogiqueDao.deleteByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<CultureScientifiqueOutilPedagogique> findByChercheurId(Long id){
        return cultureScientifiqueOutilPedagogiqueDao.findByChercheurId(id);
        }

        @Override
        @Transactional
        public int deleteByChercheurId(Long id){
        return cultureScientifiqueOutilPedagogiqueDao.deleteByChercheurId(id);
        }


        @Override
        public List<CultureScientifiqueOutilPedagogique> findByEtatEtapeCampagneCode(String code){
        return cultureScientifiqueOutilPedagogiqueDao.findByEtatEtapeCampagneCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtatEtapeCampagneCode(String code){
        return cultureScientifiqueOutilPedagogiqueDao.deleteByEtatEtapeCampagneCode(code);
        }

        @Override
        public List<CultureScientifiqueOutilPedagogique> findByEtatEtapeCampagneId(Long id){
        return cultureScientifiqueOutilPedagogiqueDao.findByEtatEtapeCampagneId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatEtapeCampagneId(Long id){
        return cultureScientifiqueOutilPedagogiqueDao.deleteByEtatEtapeCampagneId(id);
        }


@Override
public CultureScientifiqueOutilPedagogique findById(Long id){
if(id==null) return null;
return cultureScientifiqueOutilPedagogiqueDao.getOne(id);
}

@Override
public CultureScientifiqueOutilPedagogique findByIdWithAssociatedList(Long id){
CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique  = findById(id);
    findAssociatedLists(cultureScientifiqueOutilPedagogique);
return cultureScientifiqueOutilPedagogique;
}
private void findAssociatedLists(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique){
if(cultureScientifiqueOutilPedagogique==null || cultureScientifiqueOutilPedagogique.getId()==null) return ;
else{
        List<PublicCibleCultureScientifiqueOutilPedagogique> publicCibleCultureScientifiqueOutilPedagogiques = publicCibleCultureScientifiqueOutilPedagogiqueService.findByCultureScientifiqueOutilPedagogiqueId(cultureScientifiqueOutilPedagogique.getId());
        cultureScientifiqueOutilPedagogique.setPublicCibleCultureScientifiqueOutilPedagogiques(publicCibleCultureScientifiqueOutilPedagogiques);
        List<TypeOutilCultureScientifiqueOutilPedagogique> typeOutilCultureScientifiqueOutilPedagogiques = typeOutilCultureScientifiqueOutilPedagogiqueService.findByCultureScientifiqueOutilPedagogiqueId(cultureScientifiqueOutilPedagogique.getId());
        cultureScientifiqueOutilPedagogique.setTypeOutilCultureScientifiqueOutilPedagogiques(typeOutilCultureScientifiqueOutilPedagogiques);
        List<PaysTypeOutilCultureScientifiqueOutilPedagogique> paysTypeOutilCultureScientifiqueOutilPedagogiques = paysTypeOutilCultureScientifiqueOutilPedagogiqueService.findByCultureScientifiqueOutilPedagogiqueId(cultureScientifiqueOutilPedagogique.getId());
        cultureScientifiqueOutilPedagogique.setPaysTypeOutilCultureScientifiqueOutilPedagogiques(paysTypeOutilCultureScientifiqueOutilPedagogiques);
        List<EtablissementCultureScientifiqueOutilPedagogique> etablissementCultureScientifiqueOutilPedagogiques = etablissementCultureScientifiqueOutilPedagogiqueService.findByCultureScientifiqueOutilPedagogiqueId(cultureScientifiqueOutilPedagogique.getId());
        cultureScientifiqueOutilPedagogique.setEtablissementCultureScientifiqueOutilPedagogiques(etablissementCultureScientifiqueOutilPedagogiques);
}
}
private void deleteAssociatedLists(Long id){
if(id==null ) return ;
else{
        publicCibleCultureScientifiqueOutilPedagogiqueService.deleteByCultureScientifiqueOutilPedagogiqueId(id);
        typeOutilCultureScientifiqueOutilPedagogiqueService.deleteByCultureScientifiqueOutilPedagogiqueId(id);
        paysTypeOutilCultureScientifiqueOutilPedagogiqueService.deleteByCultureScientifiqueOutilPedagogiqueId(id);
        etablissementCultureScientifiqueOutilPedagogiqueService.deleteByCultureScientifiqueOutilPedagogiqueId(id);
}
}

    private void updateAssociatedLists(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique){
    if(cultureScientifiqueOutilPedagogique==null || cultureScientifiqueOutilPedagogique.getId()==null) return ;
    else{
            List<List<PublicCibleCultureScientifiqueOutilPedagogique>> resultPublicCibleCultureScientifiqueOutilPedagogiques= publicCibleCultureScientifiqueOutilPedagogiqueService.getToBeSavedAndToBeDeleted(publicCibleCultureScientifiqueOutilPedagogiqueService.findByCultureScientifiqueOutilPedagogiqueId(cultureScientifiqueOutilPedagogique.getId()),cultureScientifiqueOutilPedagogique.getPublicCibleCultureScientifiqueOutilPedagogiques());
            publicCibleCultureScientifiqueOutilPedagogiqueService.delete(resultPublicCibleCultureScientifiqueOutilPedagogiques.get(1));
            associatePublicCibleCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogique,resultPublicCibleCultureScientifiqueOutilPedagogiques.get(0));
            publicCibleCultureScientifiqueOutilPedagogiqueService.update(resultPublicCibleCultureScientifiqueOutilPedagogiques.get(0));

            List<List<TypeOutilCultureScientifiqueOutilPedagogique>> resultTypeOutilCultureScientifiqueOutilPedagogiques= typeOutilCultureScientifiqueOutilPedagogiqueService.getToBeSavedAndToBeDeleted(typeOutilCultureScientifiqueOutilPedagogiqueService.findByCultureScientifiqueOutilPedagogiqueId(cultureScientifiqueOutilPedagogique.getId()),cultureScientifiqueOutilPedagogique.getTypeOutilCultureScientifiqueOutilPedagogiques());
            typeOutilCultureScientifiqueOutilPedagogiqueService.delete(resultTypeOutilCultureScientifiqueOutilPedagogiques.get(1));
            associateTypeOutilCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogique,resultTypeOutilCultureScientifiqueOutilPedagogiques.get(0));
            typeOutilCultureScientifiqueOutilPedagogiqueService.update(resultTypeOutilCultureScientifiqueOutilPedagogiques.get(0));

            List<List<PaysTypeOutilCultureScientifiqueOutilPedagogique>> resultPaysTypeOutilCultureScientifiqueOutilPedagogiques= paysTypeOutilCultureScientifiqueOutilPedagogiqueService.getToBeSavedAndToBeDeleted(paysTypeOutilCultureScientifiqueOutilPedagogiqueService.findByCultureScientifiqueOutilPedagogiqueId(cultureScientifiqueOutilPedagogique.getId()),cultureScientifiqueOutilPedagogique.getPaysTypeOutilCultureScientifiqueOutilPedagogiques());
            paysTypeOutilCultureScientifiqueOutilPedagogiqueService.delete(resultPaysTypeOutilCultureScientifiqueOutilPedagogiques.get(1));
            associatePaysTypeOutilCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogique,resultPaysTypeOutilCultureScientifiqueOutilPedagogiques.get(0));
            paysTypeOutilCultureScientifiqueOutilPedagogiqueService.update(resultPaysTypeOutilCultureScientifiqueOutilPedagogiques.get(0));

            List<List<EtablissementCultureScientifiqueOutilPedagogique>> resultEtablissementCultureScientifiqueOutilPedagogiques= etablissementCultureScientifiqueOutilPedagogiqueService.getToBeSavedAndToBeDeleted(etablissementCultureScientifiqueOutilPedagogiqueService.findByCultureScientifiqueOutilPedagogiqueId(cultureScientifiqueOutilPedagogique.getId()),cultureScientifiqueOutilPedagogique.getEtablissementCultureScientifiqueOutilPedagogiques());
            etablissementCultureScientifiqueOutilPedagogiqueService.delete(resultEtablissementCultureScientifiqueOutilPedagogiques.get(1));
            associateEtablissementCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogique,resultEtablissementCultureScientifiqueOutilPedagogiques.get(0));
            etablissementCultureScientifiqueOutilPedagogiqueService.update(resultEtablissementCultureScientifiqueOutilPedagogiques.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
if(cultureScientifiqueOutilPedagogiqueDao.findById(id) == null) return 0;
else{
deleteAssociatedLists(id);
cultureScientifiqueOutilPedagogiqueDao.deleteById(id);
return 1;
}
}


@Override
public CultureScientifiqueOutilPedagogique update(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique){
CultureScientifiqueOutilPedagogique foundedCultureScientifiqueOutilPedagogique = findById(cultureScientifiqueOutilPedagogique.getId());
if(foundedCultureScientifiqueOutilPedagogique==null) return null;
else{
    updateAssociatedLists(cultureScientifiqueOutilPedagogique);
return  cultureScientifiqueOutilPedagogiqueDao.save(cultureScientifiqueOutilPedagogique);
}
}

@Override
public CultureScientifiqueOutilPedagogique save (CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique){

CultureScientifiqueOutilPedagogique resultat = new CultureScientifiqueOutilPedagogique();

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
    cultureScientifiqueOutilPedagogique.setChercheur(loadedChercheur);
    cultureScientifiqueOutilPedagogique.setCampagne(laodedCampagne);

    findCampagne(cultureScientifiqueOutilPedagogique);
    findChercheur(cultureScientifiqueOutilPedagogique);
    findEtatEtapeCampagne(cultureScientifiqueOutilPedagogique);

CultureScientifiqueOutilPedagogique savedCultureScientifiqueOutilPedagogique = cultureScientifiqueOutilPedagogiqueDao.save(cultureScientifiqueOutilPedagogique);
       savePublicCibleCultureScientifiqueOutilPedagogiques(savedCultureScientifiqueOutilPedagogique,cultureScientifiqueOutilPedagogique.getPublicCibleCultureScientifiqueOutilPedagogiques());
       saveTypeOutilCultureScientifiqueOutilPedagogiques(savedCultureScientifiqueOutilPedagogique,cultureScientifiqueOutilPedagogique.getTypeOutilCultureScientifiqueOutilPedagogiques());
       savePaysTypeOutilCultureScientifiqueOutilPedagogiques(savedCultureScientifiqueOutilPedagogique,cultureScientifiqueOutilPedagogique.getPaysTypeOutilCultureScientifiqueOutilPedagogiques());
       saveEtablissementCultureScientifiqueOutilPedagogiques(savedCultureScientifiqueOutilPedagogique,cultureScientifiqueOutilPedagogique.getEtablissementCultureScientifiqueOutilPedagogiques());
return savedCultureScientifiqueOutilPedagogique;
}
}

@Override
public List<CultureScientifiqueOutilPedagogique> save(List<CultureScientifiqueOutilPedagogique> cultureScientifiqueOutilPedagogiques){
List<CultureScientifiqueOutilPedagogique> list = new ArrayList<CultureScientifiqueOutilPedagogique>();
for(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique: cultureScientifiqueOutilPedagogiques){
list.add(save(cultureScientifiqueOutilPedagogique));
}
return list;
}



@Override
@Transactional
public int delete(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique){
    if(cultureScientifiqueOutilPedagogique.getId()==null) return -1;
    CultureScientifiqueOutilPedagogique foundedCultureScientifiqueOutilPedagogique = findById(cultureScientifiqueOutilPedagogique.getId());
    if(foundedCultureScientifiqueOutilPedagogique==null) return -1;
cultureScientifiqueOutilPedagogiqueDao.delete(foundedCultureScientifiqueOutilPedagogique);
return 1;
}


public List<CultureScientifiqueOutilPedagogique> findByCriteria(CultureScientifiqueOutilPedagogiqueVo cultureScientifiqueOutilPedagogiqueVo){
User currentUser = SecurityUtil.getCurrentUser();
if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())) {

String query = "SELECT o FROM CultureScientifiqueOutilPedagogique o where 1=1 ";
    query += SearchUtil.addConstraint("o", "chercheur.username", "=", currentUser.getUsername());

            query += SearchUtil.addConstraint( "o", "id","=",cultureScientifiqueOutilPedagogiqueVo.getId());
            query += SearchUtil.addConstraint( "o", "role","LIKE",cultureScientifiqueOutilPedagogiqueVo.getRole());
            query += SearchUtil.addConstraint( "o", "nomOutil","LIKE",cultureScientifiqueOutilPedagogiqueVo.getNomOutil());
            query += SearchUtil.addConstraint( "o", "sortieAnnee","=",cultureScientifiqueOutilPedagogiqueVo.getSortieAnnee());
            query += SearchUtil.addConstraint( "o", "sortieMois","=",cultureScientifiqueOutilPedagogiqueVo.getSortieMois());
            query += SearchUtil.addConstraint( "o", "lienWeb","LIKE",cultureScientifiqueOutilPedagogiqueVo.getLienWeb());
            query += SearchUtil.addConstraintMinMax("o","sortieAnnee",cultureScientifiqueOutilPedagogiqueVo.getSortieAnneeMin(),cultureScientifiqueOutilPedagogiqueVo.getSortieAnneeMax());
            query += SearchUtil.addConstraintMinMax("o","sortieMois",cultureScientifiqueOutilPedagogiqueVo.getSortieMoisMin(),cultureScientifiqueOutilPedagogiqueVo.getSortieMoisMax());
    if(cultureScientifiqueOutilPedagogiqueVo.getCampagneVo()!=null){
        query += SearchUtil.addConstraint( "o", "campagne.id","=",cultureScientifiqueOutilPedagogiqueVo.getCampagneVo().getId());
            query += SearchUtil.addConstraint( "o", "campagne.code","LIKE",cultureScientifiqueOutilPedagogiqueVo.getCampagneVo().getCode());
    }

    if(cultureScientifiqueOutilPedagogiqueVo.getChercheurVo()!=null){
        query += SearchUtil.addConstraint( "o", "chercheur.id","=",cultureScientifiqueOutilPedagogiqueVo.getChercheurVo().getId());
            query += SearchUtil.addConstraint( "o", "chercheur.numeroMatricule","LIKE",cultureScientifiqueOutilPedagogiqueVo.getChercheurVo().getNumeroMatricule());
    }

    if(cultureScientifiqueOutilPedagogiqueVo.getEtatEtapeCampagneVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatEtapeCampagne.id","=",cultureScientifiqueOutilPedagogiqueVo.getEtatEtapeCampagneVo().getId());
            query += SearchUtil.addConstraint( "o", "etatEtapeCampagne.code","LIKE",cultureScientifiqueOutilPedagogiqueVo.getEtatEtapeCampagneVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}
return new ArrayList<>();
}
        private  void savePublicCibleCultureScientifiqueOutilPedagogiques(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique,List<PublicCibleCultureScientifiqueOutilPedagogique> publicCibleCultureScientifiqueOutilPedagogiques){

        if (ListUtil.isNotEmpty(cultureScientifiqueOutilPedagogique.getPublicCibleCultureScientifiqueOutilPedagogiques())) {
        List<PublicCibleCultureScientifiqueOutilPedagogique> savedPublicCibleCultureScientifiqueOutilPedagogiques = new ArrayList<>();
        publicCibleCultureScientifiqueOutilPedagogiques.forEach(element -> {
        element.setCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogique);
        publicCibleCultureScientifiqueOutilPedagogiqueService.save(element);
        });
        cultureScientifiqueOutilPedagogique.setPublicCibleCultureScientifiqueOutilPedagogiques(savedPublicCibleCultureScientifiqueOutilPedagogiques);
        }
        }
        private  void saveTypeOutilCultureScientifiqueOutilPedagogiques(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique,List<TypeOutilCultureScientifiqueOutilPedagogique> typeOutilCultureScientifiqueOutilPedagogiques){

        if (ListUtil.isNotEmpty(cultureScientifiqueOutilPedagogique.getTypeOutilCultureScientifiqueOutilPedagogiques())) {
        List<TypeOutilCultureScientifiqueOutilPedagogique> savedTypeOutilCultureScientifiqueOutilPedagogiques = new ArrayList<>();
        typeOutilCultureScientifiqueOutilPedagogiques.forEach(element -> {
        element.setCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogique);
        typeOutilCultureScientifiqueOutilPedagogiqueService.save(element);
        });
        cultureScientifiqueOutilPedagogique.setTypeOutilCultureScientifiqueOutilPedagogiques(savedTypeOutilCultureScientifiqueOutilPedagogiques);
        }
        }
        private  void savePaysTypeOutilCultureScientifiqueOutilPedagogiques(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique,List<PaysTypeOutilCultureScientifiqueOutilPedagogique> paysTypeOutilCultureScientifiqueOutilPedagogiques){

        if (ListUtil.isNotEmpty(cultureScientifiqueOutilPedagogique.getPaysTypeOutilCultureScientifiqueOutilPedagogiques())) {
        List<PaysTypeOutilCultureScientifiqueOutilPedagogique> savedPaysTypeOutilCultureScientifiqueOutilPedagogiques = new ArrayList<>();
        paysTypeOutilCultureScientifiqueOutilPedagogiques.forEach(element -> {
        element.setCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogique);
        paysTypeOutilCultureScientifiqueOutilPedagogiqueService.save(element);
        });
        cultureScientifiqueOutilPedagogique.setPaysTypeOutilCultureScientifiqueOutilPedagogiques(savedPaysTypeOutilCultureScientifiqueOutilPedagogiques);
        }
        }
        private  void saveEtablissementCultureScientifiqueOutilPedagogiques(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique,List<EtablissementCultureScientifiqueOutilPedagogique> etablissementCultureScientifiqueOutilPedagogiques){

        if (ListUtil.isNotEmpty(cultureScientifiqueOutilPedagogique.getEtablissementCultureScientifiqueOutilPedagogiques())) {
        List<EtablissementCultureScientifiqueOutilPedagogique> savedEtablissementCultureScientifiqueOutilPedagogiques = new ArrayList<>();
        etablissementCultureScientifiqueOutilPedagogiques.forEach(element -> {
        element.setCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogique);
        etablissementCultureScientifiqueOutilPedagogiqueService.save(element);
        });
        cultureScientifiqueOutilPedagogique.setEtablissementCultureScientifiqueOutilPedagogiques(savedEtablissementCultureScientifiqueOutilPedagogiques);
        }
        }

    private void findCampagne(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique){
        Campagne loadedCampagne =campagneService.findByIdOrCode(cultureScientifiqueOutilPedagogique.getCampagne());

    if(loadedCampagne==null ) {
        return;
    }
    cultureScientifiqueOutilPedagogique.setCampagne(loadedCampagne);
    }
    private void findChercheur(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique){
        Chercheur loadedChercheur =chercheurService.findByIdOrNumeroMatricule(cultureScientifiqueOutilPedagogique.getChercheur());

    if(loadedChercheur==null ) {
        return;
    }
    cultureScientifiqueOutilPedagogique.setChercheur(loadedChercheur);
    }
    private void findEtatEtapeCampagne(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique){
        EtatEtapeCampagne loadedEtatEtapeCampagne =etatEtapeCampagneService.findByIdOrCode(cultureScientifiqueOutilPedagogique.getEtatEtapeCampagne());

    if(loadedEtatEtapeCampagne==null ) {
        return;
    }
    cultureScientifiqueOutilPedagogique.setEtatEtapeCampagne(loadedEtatEtapeCampagne);
    }

@Override
@Transactional
public void delete(List<CultureScientifiqueOutilPedagogique> cultureScientifiqueOutilPedagogiques){
        if(ListUtil.isNotEmpty(cultureScientifiqueOutilPedagogiques)){
        cultureScientifiqueOutilPedagogiques.forEach(e->cultureScientifiqueOutilPedagogiqueDao.delete(e));
        }
}
@Override
public void update(List<CultureScientifiqueOutilPedagogique> cultureScientifiqueOutilPedagogiques){
if(ListUtil.isNotEmpty(cultureScientifiqueOutilPedagogiques)){
cultureScientifiqueOutilPedagogiques.forEach(e->cultureScientifiqueOutilPedagogiqueDao.save(e));
}
}

private void associatePublicCibleCultureScientifiqueOutilPedagogique(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique, List<PublicCibleCultureScientifiqueOutilPedagogique> publicCibleCultureScientifiqueOutilPedagogique) {
    if (ListUtil.isNotEmpty(publicCibleCultureScientifiqueOutilPedagogique)) {
        publicCibleCultureScientifiqueOutilPedagogique.forEach(e -> e.setCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogique));
    }
    }
private void associateTypeOutilCultureScientifiqueOutilPedagogique(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique, List<TypeOutilCultureScientifiqueOutilPedagogique> typeOutilCultureScientifiqueOutilPedagogique) {
    if (ListUtil.isNotEmpty(typeOutilCultureScientifiqueOutilPedagogique)) {
        typeOutilCultureScientifiqueOutilPedagogique.forEach(e -> e.setCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogique));
    }
    }
private void associatePaysTypeOutilCultureScientifiqueOutilPedagogique(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique, List<PaysTypeOutilCultureScientifiqueOutilPedagogique> paysTypeOutilCultureScientifiqueOutilPedagogique) {
    if (ListUtil.isNotEmpty(paysTypeOutilCultureScientifiqueOutilPedagogique)) {
        paysTypeOutilCultureScientifiqueOutilPedagogique.forEach(e -> e.setCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogique));
    }
    }
private void associateEtablissementCultureScientifiqueOutilPedagogique(CultureScientifiqueOutilPedagogique cultureScientifiqueOutilPedagogique, List<EtablissementCultureScientifiqueOutilPedagogique> etablissementCultureScientifiqueOutilPedagogique) {
    if (ListUtil.isNotEmpty(etablissementCultureScientifiqueOutilPedagogique)) {
        etablissementCultureScientifiqueOutilPedagogique.forEach(e -> e.setCultureScientifiqueOutilPedagogique(cultureScientifiqueOutilPedagogique));
    }
    }

@Override
public List<CultureScientifiqueOutilPedagogique> findByChercheurUsernameAndCampagneId(String username, Long compagneId){
List<CultureScientifiqueOutilPedagogique> resultat= cultureScientifiqueOutilPedagogiqueDao.findByChercheurUsernameAndCampagneId(username, compagneId);
    return resultat;
}

@Override
public List<List<CultureScientifiqueOutilPedagogique>>  getToBeSavedAndToBeDeleted(List<CultureScientifiqueOutilPedagogique> oldList,List<CultureScientifiqueOutilPedagogique> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

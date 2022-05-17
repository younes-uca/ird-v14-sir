//package com.ird.faa.service.chercheur.impl;
//
//import java.util.List;
//import java.util.ArrayList;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//    import com.ird.faa.service.util.StringUtil;
//    import com.ird.faa.security.common.SecurityUtil;
//    import com.ird.faa.security.bean.User;
//import org.springframework.stereotype.Service;
//import javax.persistence.EntityManager;
//import com.ird.faa.bean.formulaire.Bourse;
//        import com.ird.faa.bean.formulaire.ProjetActiviteRecherche;
//        import com.ird.faa.bean.formulaire.Campagne;
//        import com.ird.faa.bean.formulaire.Chercheur;
//import com.ird.faa.dao.formulaire.BourseDao;
//import com.ird.faa.service.chercheur.facade.formulaire.BourseChercheurService;
//        import com.ird.faa.service.chercheur.facade.formulaire.ProjetActiviteRechercheChercheurService;
//        import com.ird.faa.service.chercheur.facade.formulaire.CampagneChercheurService;
//        import com.ird.faa.service.chercheur.facade.formulaire.ChercheurChercheurService;
//
//import com.ird.faa.ws.rest.provided.vo.BourseVo;
//import com.ird.faa.service.util.*;
//
//import com.ird.faa.service.core.impl.AbstractServiceImpl;
//
//@Service
//public class BourseChercheurServiceImpl extends AbstractServiceImpl<Bourse> implements BourseChercheurService {
//
//@Autowired
//private BourseDao bourseDao;
//
//        @Autowired
//        private ProjetActiviteRechercheChercheurService projetActiviteRechercheService ;
//        @Autowired
//        private CampagneChercheurService campagneService ;
//        @Autowired
//        private ChercheurChercheurService chercheurService ;
//
//
//@Autowired
//private EntityManager entityManager;
//
//
//@Override
//public List<Bourse> findAll(){
//User currentUser = SecurityUtil.getCurrentUser();
//if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
//    return bourseDao.findByChercheurUsername(currentUser.getUsername());
//    }
//    return new ArrayList<>();
//}
//
//        @Override
//        public List<Bourse> findByProjetActiviteRechercheAnnee(Integer annee){
//        return bourseDao.findByProjetActiviteRechercheAnnee(annee);
//        }
//
//        @Override
//        @Transactional
//        public int deleteByProjetActiviteRechercheAnnee(Integer annee){
//        return bourseDao.deleteByProjetActiviteRechercheAnnee(annee);
//        }
//
//        @Override
//        public List<Bourse> findByProjetActiviteRechercheId(Long id){
//        return bourseDao.findByProjetActiviteRechercheId(id);
//        }
//
//        @Override
//        @Transactional
//        public int deleteByProjetActiviteRechercheId(Long id){
//        return bourseDao.deleteByProjetActiviteRechercheId(id);
//        }
//
//
//        @Override
//        public List<Bourse> findByCampagneCode(String code){
//        return bourseDao.findByCampagneCode(code);
//        }
//
//        @Override
//        @Transactional
//        public int deleteByCampagneCode(String code){
//        return bourseDao.deleteByCampagneCode(code);
//        }
//
//        @Override
//        public List<Bourse> findByCampagneId(Long id){
//        return bourseDao.findByCampagneId(id);
//        }
//
//        @Override
//        @Transactional
//        public int deleteByCampagneId(Long id){
//        return bourseDao.deleteByCampagneId(id);
//        }
//
//
//        @Override
//        public List<Bourse> findByChercheurNumeroMatricule(String numeroMatricule){
//        return bourseDao.findByChercheurNumeroMatricule(numeroMatricule);
//        }
//
//        @Override
//        @Transactional
//        public int deleteByChercheurNumeroMatricule(String numeroMatricule){
//        return bourseDao.deleteByChercheurNumeroMatricule(numeroMatricule);
//        }
//
//        @Override
//        public List<Bourse> findByChercheurId(Long id){
//        return bourseDao.findByChercheurId(id);
//        }
//
//        @Override
//        @Transactional
//        public int deleteByChercheurId(Long id){
//        return bourseDao.deleteByChercheurId(id);
//        }
//
//
//@Override
//public Bourse findById(Long id){
//if(id==null) return null;
//return bourseDao.getOne(id);
//}
//
//@Override
//public Bourse findByIdWithAssociatedList(Long id){
//Bourse bourse  = findById(id);
//return bourse;
//}
//
//
//@Transactional
//public int deleteById(Long id){
//if(bourseDao.findById(id) == null) return 0;
//else{
//bourseDao.deleteById(id);
//return 1;
//}
//}
//
//
//@Override
//public Bourse update(Bourse bourse){
//Bourse foundedBourse = findById(bourse.getId());
//if(foundedBourse==null) return null;
//else{
//return  bourseDao.save(bourse);
//}
//}
//
//@Override
//public Bourse save (Bourse bourse){
//
//Bourse resultat = new Bourse();
//
//User currentUser = SecurityUtil.getCurrentUser();
//if (currentUser == null || StringUtil.isEmpty(currentUser.getUsername())) {
//return resultat;
//}
//String username = currentUser.getUsername();
//Chercheur loadedChercheur = chercheurService.findByUsername(username);
//if (loadedChercheur == null) {
//return resultat;
//}
//Campagne laodedCampagne = campagneService.findProgressCampagneByChercheurUsername(username);
//if (laodedCampagne == null) {
//return resultat;
//} else {
//    bourse.setChercheur(loadedChercheur);
//    bourse.setCampagne(laodedCampagne);
//
//    findProjetActiviteRecherche(bourse);
//    findCampagne(bourse);
//    findChercheur(bourse);
//
//Bourse savedBourse = bourseDao.save(bourse);
//return savedBourse;
//}
//}
//
//@Override
//public List<Bourse> save(List<Bourse> bourses){
//List<Bourse> list = new ArrayList<Bourse>();
//for(Bourse bourse: bourses){
//list.add(save(bourse));
//}
//return list;
//}
//
//
//
//@Override
//@Transactional
//public int delete(Bourse bourse){
//    if(bourse.getId()==null) return -1;
//    Bourse foundedBourse = findById(bourse.getId());
//    if(foundedBourse==null) return -1;
//bourseDao.delete(foundedBourse);
//return 1;
//}
//
//
//public List<Bourse> findByCriteria(BourseVo bourseVo){
//User currentUser = SecurityUtil.getCurrentUser();
//if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())) {
//
//String query = "SELECT o FROM Bourse o where 1=1 ";
//    query += SearchUtil.addConstraint("o", "chercheur.username", "=", currentUser.getUsername());
//
//            query += SearchUtil.addConstraint( "o", "id","=",bourseVo.getId());
//        query += SearchUtil.addConstraintDate( "o", "dateObtention","=",bourseVo.getDateObtention());
//            query += SearchUtil.addConstraint( "o", "intitule","LIKE",bourseVo.getIntitule());
//            query += SearchUtil.addConstraint( "o", "participationIndividuelle","=",bourseVo.getParticipationIndividuelle());
//            query += SearchUtil.addConstraint( "o", "montant","=",bourseVo.getMontant());
//            query += SearchUtil.addConstraint( "o", "dureeEnMois","=",bourseVo.getDureeEnMois());
//            query += SearchUtil.addConstraintMinMaxDate("o","dateObtention",bourseVo.getDateObtentionMin(),bourseVo.getDateObtentionMax());
//            query += SearchUtil.addConstraintMinMax("o","montant",bourseVo.getMontantMin(),bourseVo.getMontantMax());
//            query += SearchUtil.addConstraintMinMax("o","dureeEnMois",bourseVo.getDureeEnMoisMin(),bourseVo.getDureeEnMoisMax());
//    if(bourseVo.getProjetActiviteRechercheVo()!=null){
//        query += SearchUtil.addConstraint( "o", "projetActiviteRecherche.id","=",bourseVo.getProjetActiviteRechercheVo().getId());
//            query += SearchUtil.addConstraint( "o", "projetActiviteRecherche.annee","=",bourseVo.getProjetActiviteRechercheVo().getAnnee());
//    }
//
//    if(bourseVo.getCampagneVo()!=null){
//        query += SearchUtil.addConstraint( "o", "campagne.id","=",bourseVo.getCampagneVo().getId());
//            query += SearchUtil.addConstraint( "o", "campagne.code","LIKE",bourseVo.getCampagneVo().getCode());
//    }
//
//    if(bourseVo.getChercheurVo()!=null){
//        query += SearchUtil.addConstraint( "o", "chercheur.id","=",bourseVo.getChercheurVo().getId());
//            query += SearchUtil.addConstraint( "o", "chercheur.numeroMatricule","LIKE",bourseVo.getChercheurVo().getNumeroMatricule());
//    }
//
//return entityManager.createQuery(query).getResultList();
//}
//return new ArrayList<>();
//}
//
//    private void findProjetActiviteRecherche(Bourse bourse){
//        ProjetActiviteRecherche loadedProjetActiviteRecherche =projetActiviteRechercheService.findByIdOrAnnee(bourse.getProjetActiviteRecherche());
//
//    if(loadedProjetActiviteRecherche==null ) {
//        return;
//    }
//    bourse.setProjetActiviteRecherche(loadedProjetActiviteRecherche);
//    }
//    private void findCampagne(Bourse bourse){
//        Campagne loadedCampagne =campagneService.findByIdOrCode(bourse.getCampagne());
//
//    if(loadedCampagne==null ) {
//        return;
//    }
//    bourse.setCampagne(loadedCampagne);
//    }
//    private void findChercheur(Bourse bourse){
//        Chercheur loadedChercheur =chercheurService.findByIdOrNumeroMatricule(bourse.getChercheur());
//
//    if(loadedChercheur==null ) {
//        return;
//    }
//    bourse.setChercheur(loadedChercheur);
//    }
//
//@Override
//@Transactional
//public void delete(List<Bourse> bourses){
//        if(ListUtil.isNotEmpty(bourses)){
//        bourses.forEach(e->bourseDao.delete(e));
//        }
//}
//@Override
//public void update(List<Bourse> bourses){
//if(ListUtil.isNotEmpty(bourses)){
//bourses.forEach(e->bourseDao.save(e));
//}
//}
//
//
//@Override
//public List<Bourse> findByChercheurUsernameAndCampagneId(String username, Long compagneId){
//List<Bourse> resultat= bourseDao.findByChercheurUsernameAndCampagneId(username, compagneId);
//    return resultat;
//}
//
//@Override
//public List<List<Bourse>>  getToBeSavedAndToBeDeleted(List<Bourse> oldList,List<Bourse> newList){
//            return super.getToBeSavedAndToBeDeleted(oldList,newList);
//            }
//
//}

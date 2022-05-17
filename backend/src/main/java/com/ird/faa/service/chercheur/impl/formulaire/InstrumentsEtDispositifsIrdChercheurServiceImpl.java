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
import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrd;
        import com.ird.faa.bean.formulaire.Campagne;
        import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.dao.formulaire.InstrumentsEtDispositifsIrdDao;
import com.ird.faa.service.chercheur.facade.formulaire.InstrumentsEtDispositifsIrdChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.CampagneChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.ChercheurChercheurService;

import com.ird.faa.ws.rest.provided.vo.InstrumentsEtDispositifsIrdVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class InstrumentsEtDispositifsIrdChercheurServiceImpl extends AbstractServiceImpl<InstrumentsEtDispositifsIrd> implements InstrumentsEtDispositifsIrdChercheurService {

@Autowired
private InstrumentsEtDispositifsIrdDao instrumentsEtDispositifsIrdDao;

        @Autowired
        private CampagneChercheurService campagneService ;
        @Autowired
        private ChercheurChercheurService chercheurService ;


@Autowired
private EntityManager entityManager;


@Override
public List<InstrumentsEtDispositifsIrd> findAll(){
User currentUser = SecurityUtil.getCurrentUser();
if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
    return instrumentsEtDispositifsIrdDao.findByChercheurUsername(currentUser.getUsername());
    }
    return new ArrayList<>();
}

        @Override
        public List<InstrumentsEtDispositifsIrd> findByCampagneCode(String code){
        return instrumentsEtDispositifsIrdDao.findByCampagneCode(code);
        }

        @Override
        @Transactional
        public int deleteByCampagneCode(String code){
        return instrumentsEtDispositifsIrdDao.deleteByCampagneCode(code);
        }

        @Override
        public List<InstrumentsEtDispositifsIrd> findByCampagneId(Long id){
        return instrumentsEtDispositifsIrdDao.findByCampagneId(id);
        }

        @Override
        @Transactional
        public int deleteByCampagneId(Long id){
        return instrumentsEtDispositifsIrdDao.deleteByCampagneId(id);
        }


        @Override
        public List<InstrumentsEtDispositifsIrd> findByChercheurNumeroMatricule(String numeroMatricule){
        return instrumentsEtDispositifsIrdDao.findByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByChercheurNumeroMatricule(String numeroMatricule){
        return instrumentsEtDispositifsIrdDao.deleteByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<InstrumentsEtDispositifsIrd> findByChercheurId(Long id){
        return instrumentsEtDispositifsIrdDao.findByChercheurId(id);
        }

        @Override
        @Transactional
        public int deleteByChercheurId(Long id){
        return instrumentsEtDispositifsIrdDao.deleteByChercheurId(id);
        }

    @Override
    public InstrumentsEtDispositifsIrd findByCode(String code){
    if( code==null) return null;
    return instrumentsEtDispositifsIrdDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return instrumentsEtDispositifsIrdDao.deleteByCode(code);
    }
    @Override
    public InstrumentsEtDispositifsIrd findByIdOrCode(InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd){
    InstrumentsEtDispositifsIrd resultat=null;
    if(instrumentsEtDispositifsIrd == null || ( instrumentsEtDispositifsIrd.getCode()==null && instrumentsEtDispositifsIrd.getId()==null))
    return resultat;
    else{
    if(instrumentsEtDispositifsIrd.getId() != null){
    resultat= instrumentsEtDispositifsIrdDao.findById(instrumentsEtDispositifsIrd.getId()).get();
    }else if(StringUtil.isNotEmpty(instrumentsEtDispositifsIrd.getCode())) {
    resultat= instrumentsEtDispositifsIrdDao.findByCode(instrumentsEtDispositifsIrd.getCode());
    }
    return resultat;
    }
    }

@Override
public InstrumentsEtDispositifsIrd findById(Long id){
if(id==null) return null;
return instrumentsEtDispositifsIrdDao.getOne(id);
}

@Override
public InstrumentsEtDispositifsIrd findByIdWithAssociatedList(Long id){
InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd  = findById(id);
return instrumentsEtDispositifsIrd;
}


@Transactional
public int deleteById(Long id){
if(instrumentsEtDispositifsIrdDao.findById(id) == null) return 0;
else{
instrumentsEtDispositifsIrdDao.deleteById(id);
return 1;
}
}


@Override
public InstrumentsEtDispositifsIrd update(InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd){
InstrumentsEtDispositifsIrd foundedInstrumentsEtDispositifsIrd = findById(instrumentsEtDispositifsIrd.getId());
if(foundedInstrumentsEtDispositifsIrd==null) return null;
else{
return  instrumentsEtDispositifsIrdDao.save(instrumentsEtDispositifsIrd);
}
}

@Override
public InstrumentsEtDispositifsIrd save (InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd){
    InstrumentsEtDispositifsIrd foundedInstrumentsEtDispositifsIrd = findByCode(instrumentsEtDispositifsIrd.getCode());
   if(foundedInstrumentsEtDispositifsIrd!=null) return null;

InstrumentsEtDispositifsIrd resultat = new InstrumentsEtDispositifsIrd();

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
    instrumentsEtDispositifsIrd.setChercheur(loadedChercheur);
    instrumentsEtDispositifsIrd.setCampagne(laodedCampagne);

    findCampagne(instrumentsEtDispositifsIrd);
    findChercheur(instrumentsEtDispositifsIrd);

InstrumentsEtDispositifsIrd savedInstrumentsEtDispositifsIrd = instrumentsEtDispositifsIrdDao.save(instrumentsEtDispositifsIrd);
return savedInstrumentsEtDispositifsIrd;
}
}

@Override
public List<InstrumentsEtDispositifsIrd> save(List<InstrumentsEtDispositifsIrd> instrumentsEtDispositifsIrds){
List<InstrumentsEtDispositifsIrd> list = new ArrayList<InstrumentsEtDispositifsIrd>();
for(InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd: instrumentsEtDispositifsIrds){
list.add(save(instrumentsEtDispositifsIrd));
}
return list;
}



@Override
@Transactional
public int delete(InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd){
    if(instrumentsEtDispositifsIrd.getCode()==null) return -1;

    InstrumentsEtDispositifsIrd foundedInstrumentsEtDispositifsIrd = findByCode(instrumentsEtDispositifsIrd.getCode());
    if(foundedInstrumentsEtDispositifsIrd==null) return -1;
instrumentsEtDispositifsIrdDao.delete(foundedInstrumentsEtDispositifsIrd);
return 1;
}


public List<InstrumentsEtDispositifsIrd> findByCriteria(InstrumentsEtDispositifsIrdVo instrumentsEtDispositifsIrdVo){
User currentUser = SecurityUtil.getCurrentUser();
if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())) {

String query = "SELECT o FROM InstrumentsEtDispositifsIrd o where 1=1 ";
    query += SearchUtil.addConstraint("o", "chercheur.username", "=", currentUser.getUsername());

            query += SearchUtil.addConstraint( "o", "id","=",instrumentsEtDispositifsIrdVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",instrumentsEtDispositifsIrdVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",instrumentsEtDispositifsIrdVo.getCode());
            query += SearchUtil.addConstraint( "o", "description","LIKE",instrumentsEtDispositifsIrdVo.getDescription());
    if(instrumentsEtDispositifsIrdVo.getCampagneVo()!=null){
        query += SearchUtil.addConstraint( "o", "campagne.id","=",instrumentsEtDispositifsIrdVo.getCampagneVo().getId());
            query += SearchUtil.addConstraint( "o", "campagne.code","LIKE",instrumentsEtDispositifsIrdVo.getCampagneVo().getCode());
    }

    if(instrumentsEtDispositifsIrdVo.getChercheurVo()!=null){
        query += SearchUtil.addConstraint( "o", "chercheur.id","=",instrumentsEtDispositifsIrdVo.getChercheurVo().getId());
            query += SearchUtil.addConstraint( "o", "chercheur.numeroMatricule","LIKE",instrumentsEtDispositifsIrdVo.getChercheurVo().getNumeroMatricule());
    }

return entityManager.createQuery(query).getResultList();
}
return new ArrayList<>();
}

    private void findCampagne(InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd){
        Campagne loadedCampagne =campagneService.findByIdOrCode(instrumentsEtDispositifsIrd.getCampagne());

    if(loadedCampagne==null ) {
        return;
    }
    instrumentsEtDispositifsIrd.setCampagne(loadedCampagne);
    }
    private void findChercheur(InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd){
        Chercheur loadedChercheur =chercheurService.findByIdOrNumeroMatricule(instrumentsEtDispositifsIrd.getChercheur());

    if(loadedChercheur==null ) {
        return;
    }
    instrumentsEtDispositifsIrd.setChercheur(loadedChercheur);
    }

@Override
@Transactional
public void delete(List<InstrumentsEtDispositifsIrd> instrumentsEtDispositifsIrds){
        if(ListUtil.isNotEmpty(instrumentsEtDispositifsIrds)){
        instrumentsEtDispositifsIrds.forEach(e->instrumentsEtDispositifsIrdDao.delete(e));
        }
}
@Override
public void update(List<InstrumentsEtDispositifsIrd> instrumentsEtDispositifsIrds){
if(ListUtil.isNotEmpty(instrumentsEtDispositifsIrds)){
instrumentsEtDispositifsIrds.forEach(e->instrumentsEtDispositifsIrdDao.save(e));
}
}


@Override
public List<InstrumentsEtDispositifsIrd> findByChercheurUsernameAndCampagneId(String username, Long compagneId){
List<InstrumentsEtDispositifsIrd> resultat= instrumentsEtDispositifsIrdDao.findByChercheurUsernameAndCampagneId(username, compagneId);
    return resultat;
}

@Override
public List<List<InstrumentsEtDispositifsIrd>>  getToBeSavedAndToBeDeleted(List<InstrumentsEtDispositifsIrd> oldList,List<InstrumentsEtDispositifsIrd> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

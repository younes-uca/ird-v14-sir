package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.InstrumentsEtDispositifsIrdChercheur;
        import com.ird.faa.bean.referentiel.TypeInstrumentsEtDispositifsIrd;
        import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.dao.formulaire.InstrumentsEtDispositifsIrdChercheurDao;
import com.ird.faa.service.chercheur.facade.formulaire.InstrumentsEtDispositifsIrdChercheurChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.TypeInstrumentsEtDispositifsIrdChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.ChercheurChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.InstrumentsEtDispositifsIrdChercheurVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class InstrumentsEtDispositifsIrdChercheurChercheurServiceImpl extends AbstractServiceImpl<InstrumentsEtDispositifsIrdChercheur> implements InstrumentsEtDispositifsIrdChercheurChercheurService {

@Autowired
private InstrumentsEtDispositifsIrdChercheurDao instrumentsEtDispositifsIrdChercheurDao;

        @Autowired
        private TypeInstrumentsEtDispositifsIrdChercheurService typeInstrumentsEtDispositifsIrdService ;
        @Autowired
        private ChercheurChercheurService chercheurService ;


@Autowired
private EntityManager entityManager;


@Override
public List<InstrumentsEtDispositifsIrdChercheur> findAll(){
return instrumentsEtDispositifsIrdChercheurDao.findAll();
}

        @Override
        public List<InstrumentsEtDispositifsIrdChercheur> findByTypeInstrumentsEtDispositifsIrdCode(String code){
        return instrumentsEtDispositifsIrdChercheurDao.findByTypeInstrumentsEtDispositifsIrdCode(code);
        }

        @Override
        @Transactional
        public int deleteByTypeInstrumentsEtDispositifsIrdCode(String code){
        return instrumentsEtDispositifsIrdChercheurDao.deleteByTypeInstrumentsEtDispositifsIrdCode(code);
        }

        @Override
        public List<InstrumentsEtDispositifsIrdChercheur> findByTypeInstrumentsEtDispositifsIrdId(Long id){
        return instrumentsEtDispositifsIrdChercheurDao.findByTypeInstrumentsEtDispositifsIrdId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeInstrumentsEtDispositifsIrdId(Long id){
        return instrumentsEtDispositifsIrdChercheurDao.deleteByTypeInstrumentsEtDispositifsIrdId(id);
        }


        @Override
        public List<InstrumentsEtDispositifsIrdChercheur> findByChercheurNumeroMatricule(String numeroMatricule){
        return instrumentsEtDispositifsIrdChercheurDao.findByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByChercheurNumeroMatricule(String numeroMatricule){
        return instrumentsEtDispositifsIrdChercheurDao.deleteByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<InstrumentsEtDispositifsIrdChercheur> findByChercheurId(Long id){
        return instrumentsEtDispositifsIrdChercheurDao.findByChercheurId(id);
        }

        @Override
        @Transactional
        public int deleteByChercheurId(Long id){
        return instrumentsEtDispositifsIrdChercheurDao.deleteByChercheurId(id);
        }


@Override
public InstrumentsEtDispositifsIrdChercheur findById(Long id){
if(id==null) return null;
return instrumentsEtDispositifsIrdChercheurDao.getOne(id);
}

@Override
public InstrumentsEtDispositifsIrdChercheur findByIdWithAssociatedList(Long id){
InstrumentsEtDispositifsIrdChercheur instrumentsEtDispositifsIrdChercheur  = findById(id);
return instrumentsEtDispositifsIrdChercheur;
}


@Transactional
public int deleteById(Long id){
if(instrumentsEtDispositifsIrdChercheurDao.findById(id) == null) return 0;
else{
instrumentsEtDispositifsIrdChercheurDao.deleteById(id);
return 1;
}
}


@Override
public InstrumentsEtDispositifsIrdChercheur update(InstrumentsEtDispositifsIrdChercheur instrumentsEtDispositifsIrdChercheur){
InstrumentsEtDispositifsIrdChercheur foundedInstrumentsEtDispositifsIrdChercheur = findById(instrumentsEtDispositifsIrdChercheur.getId());
if(foundedInstrumentsEtDispositifsIrdChercheur==null) return null;
else{
return  instrumentsEtDispositifsIrdChercheurDao.save(instrumentsEtDispositifsIrdChercheur);
}
}

@Override
public InstrumentsEtDispositifsIrdChercheur save (InstrumentsEtDispositifsIrdChercheur instrumentsEtDispositifsIrdChercheur){


    findTypeInstrumentsEtDispositifsIrd(instrumentsEtDispositifsIrdChercheur);
    findChercheur(instrumentsEtDispositifsIrdChercheur);

InstrumentsEtDispositifsIrdChercheur savedInstrumentsEtDispositifsIrdChercheur = instrumentsEtDispositifsIrdChercheurDao.save(instrumentsEtDispositifsIrdChercheur);
return savedInstrumentsEtDispositifsIrdChercheur;
}

@Override
public List<InstrumentsEtDispositifsIrdChercheur> save(List<InstrumentsEtDispositifsIrdChercheur> instrumentsEtDispositifsIrdChercheurs){
List<InstrumentsEtDispositifsIrdChercheur> list = new ArrayList<InstrumentsEtDispositifsIrdChercheur>();
for(InstrumentsEtDispositifsIrdChercheur instrumentsEtDispositifsIrdChercheur: instrumentsEtDispositifsIrdChercheurs){
list.add(save(instrumentsEtDispositifsIrdChercheur));
}
return list;
}



@Override
@Transactional
public int delete(InstrumentsEtDispositifsIrdChercheur instrumentsEtDispositifsIrdChercheur){
    if(instrumentsEtDispositifsIrdChercheur.getId()==null) return -1;
    InstrumentsEtDispositifsIrdChercheur foundedInstrumentsEtDispositifsIrdChercheur = findById(instrumentsEtDispositifsIrdChercheur.getId());
    if(foundedInstrumentsEtDispositifsIrdChercheur==null) return -1;
instrumentsEtDispositifsIrdChercheurDao.delete(foundedInstrumentsEtDispositifsIrdChercheur);
return 1;
}


public List<InstrumentsEtDispositifsIrdChercheur> findByCriteria(InstrumentsEtDispositifsIrdChercheurVo instrumentsEtDispositifsIrdChercheurVo){

String query = "SELECT o FROM InstrumentsEtDispositifsIrdChercheur o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",instrumentsEtDispositifsIrdChercheurVo.getId());
    if(instrumentsEtDispositifsIrdChercheurVo.getTypeInstrumentsEtDispositifsIrdVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeInstrumentsEtDispositifsIrd.id","=",instrumentsEtDispositifsIrdChercheurVo.getTypeInstrumentsEtDispositifsIrdVo().getId());
            query += SearchUtil.addConstraint( "o", "typeInstrumentsEtDispositifsIrd.code","LIKE",instrumentsEtDispositifsIrdChercheurVo.getTypeInstrumentsEtDispositifsIrdVo().getCode());
    }

    if(instrumentsEtDispositifsIrdChercheurVo.getChercheurVo()!=null){
        query += SearchUtil.addConstraint( "o", "chercheur.id","=",instrumentsEtDispositifsIrdChercheurVo.getChercheurVo().getId());
            query += SearchUtil.addConstraint( "o", "chercheur.numeroMatricule","LIKE",instrumentsEtDispositifsIrdChercheurVo.getChercheurVo().getNumeroMatricule());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findTypeInstrumentsEtDispositifsIrd(InstrumentsEtDispositifsIrdChercheur instrumentsEtDispositifsIrdChercheur){
        TypeInstrumentsEtDispositifsIrd loadedTypeInstrumentsEtDispositifsIrd =typeInstrumentsEtDispositifsIrdService.findByIdOrCode(instrumentsEtDispositifsIrdChercheur.getTypeInstrumentsEtDispositifsIrd());

    if(loadedTypeInstrumentsEtDispositifsIrd==null ) {
        return;
    }
    instrumentsEtDispositifsIrdChercheur.setTypeInstrumentsEtDispositifsIrd(loadedTypeInstrumentsEtDispositifsIrd);
    }
    private void findChercheur(InstrumentsEtDispositifsIrdChercheur instrumentsEtDispositifsIrdChercheur){
        Chercheur loadedChercheur =chercheurService.findByIdOrNumeroMatricule(instrumentsEtDispositifsIrdChercheur.getChercheur());

    if(loadedChercheur==null ) {
        return;
    }
    instrumentsEtDispositifsIrdChercheur.setChercheur(loadedChercheur);
    }

@Override
@Transactional
public void delete(List<InstrumentsEtDispositifsIrdChercheur> instrumentsEtDispositifsIrdChercheurs){
        if(ListUtil.isNotEmpty(instrumentsEtDispositifsIrdChercheurs)){
        instrumentsEtDispositifsIrdChercheurs.forEach(e->instrumentsEtDispositifsIrdChercheurDao.delete(e));
        }
}
@Override
public void update(List<InstrumentsEtDispositifsIrdChercheur> instrumentsEtDispositifsIrdChercheurs){
if(ListUtil.isNotEmpty(instrumentsEtDispositifsIrdChercheurs)){
instrumentsEtDispositifsIrdChercheurs.forEach(e->instrumentsEtDispositifsIrdChercheurDao.save(e));
}
}



@Override
public List<List<InstrumentsEtDispositifsIrdChercheur>>  getToBeSavedAndToBeDeleted(List<InstrumentsEtDispositifsIrdChercheur> oldList,List<InstrumentsEtDispositifsIrdChercheur> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

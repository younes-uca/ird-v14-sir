package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.DomaineScientifiqueChercheur;
        import com.ird.faa.bean.formulaire.DomaineScientifique;
        import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.dao.formulaire.DomaineScientifiqueChercheurDao;
import com.ird.faa.service.chercheur.facade.formulaire.DomaineScientifiqueChercheurChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.DomaineScientifiqueChercheurService;
        import com.ird.faa.service.chercheur.facade.formulaire.ChercheurChercheurService;

import com.ird.faa.ws.rest.provided.vo.DomaineScientifiqueChercheurVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class DomaineScientifiqueChercheurChercheurServiceImpl extends AbstractServiceImpl<DomaineScientifiqueChercheur> implements DomaineScientifiqueChercheurChercheurService {

@Autowired
private DomaineScientifiqueChercheurDao domaineScientifiqueChercheurDao;

        @Autowired
        private DomaineScientifiqueChercheurService domaineScientifiqueService ;
        @Autowired
        private ChercheurChercheurService chercheurService ;


@Autowired
private EntityManager entityManager;


@Override
public List<DomaineScientifiqueChercheur> findAll(){
return domaineScientifiqueChercheurDao.findAll();
}

        @Override
        public List<DomaineScientifiqueChercheur> findByDomaineScientifiqueCode(String code){
        return domaineScientifiqueChercheurDao.findByDomaineScientifiqueCode(code);
        }

        @Override
        @Transactional
        public int deleteByDomaineScientifiqueCode(String code){
        return domaineScientifiqueChercheurDao.deleteByDomaineScientifiqueCode(code);
        }

        @Override
        public List<DomaineScientifiqueChercheur> findByDomaineScientifiqueId(Long id){
        return domaineScientifiqueChercheurDao.findByDomaineScientifiqueId(id);
        }

        @Override
        @Transactional
        public int deleteByDomaineScientifiqueId(Long id){
        return domaineScientifiqueChercheurDao.deleteByDomaineScientifiqueId(id);
        }


        @Override
        public List<DomaineScientifiqueChercheur> findByChercheurNumeroMatricule(String numeroMatricule){
        return domaineScientifiqueChercheurDao.findByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByChercheurNumeroMatricule(String numeroMatricule){
        return domaineScientifiqueChercheurDao.deleteByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<DomaineScientifiqueChercheur> findByChercheurId(Long id){
        return domaineScientifiqueChercheurDao.findByChercheurId(id);
        }

        @Override
        @Transactional
        public int deleteByChercheurId(Long id){
        return domaineScientifiqueChercheurDao.deleteByChercheurId(id);
        }


@Override
public DomaineScientifiqueChercheur findById(Long id){
if(id==null) return null;
return domaineScientifiqueChercheurDao.getOne(id);
}

@Override
public DomaineScientifiqueChercheur findByIdWithAssociatedList(Long id){
DomaineScientifiqueChercheur domaineScientifiqueChercheur  = findById(id);
return domaineScientifiqueChercheur;
}


@Transactional
public int deleteById(Long id){
if(domaineScientifiqueChercheurDao.findById(id) == null) return 0;
else{
domaineScientifiqueChercheurDao.deleteById(id);
return 1;
}
}


@Override
public DomaineScientifiqueChercheur update(DomaineScientifiqueChercheur domaineScientifiqueChercheur){
DomaineScientifiqueChercheur foundedDomaineScientifiqueChercheur = findById(domaineScientifiqueChercheur.getId());
if(foundedDomaineScientifiqueChercheur==null) return null;
else{
return  domaineScientifiqueChercheurDao.save(domaineScientifiqueChercheur);
}
}

@Override
public DomaineScientifiqueChercheur save (DomaineScientifiqueChercheur domaineScientifiqueChercheur){


    findDomaineScientifique(domaineScientifiqueChercheur);
    findChercheur(domaineScientifiqueChercheur);

DomaineScientifiqueChercheur savedDomaineScientifiqueChercheur = domaineScientifiqueChercheurDao.save(domaineScientifiqueChercheur);
return savedDomaineScientifiqueChercheur;
}

@Override
public List<DomaineScientifiqueChercheur> save(List<DomaineScientifiqueChercheur> domaineScientifiqueChercheurs){
List<DomaineScientifiqueChercheur> list = new ArrayList<DomaineScientifiqueChercheur>();
for(DomaineScientifiqueChercheur domaineScientifiqueChercheur: domaineScientifiqueChercheurs){
list.add(save(domaineScientifiqueChercheur));
}
return list;
}



@Override
@Transactional
public int delete(DomaineScientifiqueChercheur domaineScientifiqueChercheur){
    if(domaineScientifiqueChercheur.getId()==null) return -1;
    DomaineScientifiqueChercheur foundedDomaineScientifiqueChercheur = findById(domaineScientifiqueChercheur.getId());
    if(foundedDomaineScientifiqueChercheur==null) return -1;
domaineScientifiqueChercheurDao.delete(foundedDomaineScientifiqueChercheur);
return 1;
}


public List<DomaineScientifiqueChercheur> findByCriteria(DomaineScientifiqueChercheurVo domaineScientifiqueChercheurVo){

String query = "SELECT o FROM DomaineScientifiqueChercheur o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",domaineScientifiqueChercheurVo.getId());
    if(domaineScientifiqueChercheurVo.getDomaineScientifiqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "domaineScientifique.id","=",domaineScientifiqueChercheurVo.getDomaineScientifiqueVo().getId());
            query += SearchUtil.addConstraint( "o", "domaineScientifique.code","LIKE",domaineScientifiqueChercheurVo.getDomaineScientifiqueVo().getCode());
    }

    if(domaineScientifiqueChercheurVo.getChercheurVo()!=null){
        query += SearchUtil.addConstraint( "o", "chercheur.id","=",domaineScientifiqueChercheurVo.getChercheurVo().getId());
            query += SearchUtil.addConstraint( "o", "chercheur.numeroMatricule","LIKE",domaineScientifiqueChercheurVo.getChercheurVo().getNumeroMatricule());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findDomaineScientifique(DomaineScientifiqueChercheur domaineScientifiqueChercheur){
        DomaineScientifique loadedDomaineScientifique =domaineScientifiqueService.findByIdOrCode(domaineScientifiqueChercheur.getDomaineScientifique());

    if(loadedDomaineScientifique==null ) {
        return;
    }
    domaineScientifiqueChercheur.setDomaineScientifique(loadedDomaineScientifique);
    }
    private void findChercheur(DomaineScientifiqueChercheur domaineScientifiqueChercheur){
        Chercheur loadedChercheur =chercheurService.findByIdOrNumeroMatricule(domaineScientifiqueChercheur.getChercheur());

    if(loadedChercheur==null ) {
        return;
    }
    domaineScientifiqueChercheur.setChercheur(loadedChercheur);
    }

@Override
@Transactional
public void delete(List<DomaineScientifiqueChercheur> domaineScientifiqueChercheurs){
        if(ListUtil.isNotEmpty(domaineScientifiqueChercheurs)){
        domaineScientifiqueChercheurs.forEach(e->domaineScientifiqueChercheurDao.delete(e));
        }
}
@Override
public void update(List<DomaineScientifiqueChercheur> domaineScientifiqueChercheurs){
if(ListUtil.isNotEmpty(domaineScientifiqueChercheurs)){
domaineScientifiqueChercheurs.forEach(e->domaineScientifiqueChercheurDao.save(e));
}
}



@Override
public List<List<DomaineScientifiqueChercheur>>  getToBeSavedAndToBeDeleted(List<DomaineScientifiqueChercheur> oldList,List<DomaineScientifiqueChercheur> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

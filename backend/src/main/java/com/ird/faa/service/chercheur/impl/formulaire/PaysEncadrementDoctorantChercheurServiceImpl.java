package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.PaysEncadrementDoctorant;
import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.formulaire.EncadrementDoctorant;
import com.ird.faa.dao.formulaire.PaysEncadrementDoctorantDao;
import com.ird.faa.service.chercheur.facade.formulaire.PaysEncadrementDoctorantChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.PaysChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementDoctorantChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.PaysEncadrementDoctorantVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PaysEncadrementDoctorantChercheurServiceImpl extends AbstractServiceImpl<PaysEncadrementDoctorant> implements PaysEncadrementDoctorantChercheurService {

@Autowired
private PaysEncadrementDoctorantDao paysEncadrementDoctorantDao;

        @Autowired
        private PaysChercheurService paysService ;
        @Autowired
        private EncadrementDoctorantChercheurService encadrementDoctorantService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PaysEncadrementDoctorant> findAll(){
return paysEncadrementDoctorantDao.findAll();
}

        @Override
        public List<PaysEncadrementDoctorant> findByPaysCode(String code){
        return paysEncadrementDoctorantDao.findByPaysCode(code);
        }

        @Override
        @Transactional
        public int deleteByPaysCode(String code){
        return paysEncadrementDoctorantDao.deleteByPaysCode(code);
        }

        @Override
        public List<PaysEncadrementDoctorant> findByPaysId(Long id){
        return paysEncadrementDoctorantDao.findByPaysId(id);
        }

        @Override
        @Transactional
        public int deleteByPaysId(Long id){
        return paysEncadrementDoctorantDao.deleteByPaysId(id);
        }

        @Override
        public List<PaysEncadrementDoctorant> findByEncadrementDoctorantId(Long id){
        return paysEncadrementDoctorantDao.findByEncadrementDoctorantId(id);
        }

        @Override
        @Transactional
        public int deleteByEncadrementDoctorantId(Long id){
        return paysEncadrementDoctorantDao.deleteByEncadrementDoctorantId(id);
        }


@Override
public PaysEncadrementDoctorant findById(Long id){
if(id==null) return null;
return paysEncadrementDoctorantDao.getOne(id);
}

@Override
public PaysEncadrementDoctorant findByIdWithAssociatedList(Long id){
PaysEncadrementDoctorant paysEncadrementDoctorant  = findById(id);
return paysEncadrementDoctorant;
}


@Transactional
public int deleteById(Long id){
if(paysEncadrementDoctorantDao.findById(id) == null) return 0;
else{
paysEncadrementDoctorantDao.deleteById(id);
return 1;
}
}


@Override
public PaysEncadrementDoctorant update(PaysEncadrementDoctorant paysEncadrementDoctorant){
PaysEncadrementDoctorant foundedPaysEncadrementDoctorant = findById(paysEncadrementDoctorant.getId());
if(foundedPaysEncadrementDoctorant==null) return null;
else{
return  paysEncadrementDoctorantDao.save(paysEncadrementDoctorant);
}
}

@Override
public PaysEncadrementDoctorant save (PaysEncadrementDoctorant paysEncadrementDoctorant){


    findPays(paysEncadrementDoctorant);
    findEncadrementDoctorant(paysEncadrementDoctorant);

PaysEncadrementDoctorant savedPaysEncadrementDoctorant = paysEncadrementDoctorantDao.save(paysEncadrementDoctorant);
return savedPaysEncadrementDoctorant;
}

@Override
public List<PaysEncadrementDoctorant> save(List<PaysEncadrementDoctorant> paysEncadrementDoctorants){
List<PaysEncadrementDoctorant> list = new ArrayList<PaysEncadrementDoctorant>();
for(PaysEncadrementDoctorant paysEncadrementDoctorant: paysEncadrementDoctorants){
list.add(save(paysEncadrementDoctorant));
}
return list;
}



@Override
@Transactional
public int delete(PaysEncadrementDoctorant paysEncadrementDoctorant){
    if(paysEncadrementDoctorant.getId()==null) return -1;
    PaysEncadrementDoctorant foundedPaysEncadrementDoctorant = findById(paysEncadrementDoctorant.getId());
    if(foundedPaysEncadrementDoctorant==null) return -1;
paysEncadrementDoctorantDao.delete(foundedPaysEncadrementDoctorant);
return 1;
}


public List<PaysEncadrementDoctorant> findByCriteria(PaysEncadrementDoctorantVo paysEncadrementDoctorantVo){

String query = "SELECT o FROM PaysEncadrementDoctorant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",paysEncadrementDoctorantVo.getId());
    if(paysEncadrementDoctorantVo.getPaysVo()!=null){
        query += SearchUtil.addConstraint( "o", "pays.id","=",paysEncadrementDoctorantVo.getPaysVo().getId());
            query += SearchUtil.addConstraint( "o", "pays.code","LIKE",paysEncadrementDoctorantVo.getPaysVo().getCode());
    }

    if(paysEncadrementDoctorantVo.getEncadrementDoctorantVo()!=null){
        query += SearchUtil.addConstraint( "o", "encadrementDoctorant.id","=",paysEncadrementDoctorantVo.getEncadrementDoctorantVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findPays(PaysEncadrementDoctorant paysEncadrementDoctorant){
        Pays loadedPays =paysService.findByIdOrCode(paysEncadrementDoctorant.getPays());

    if(loadedPays==null ) {
        return;
    }
    paysEncadrementDoctorant.setPays(loadedPays);
    }
    private void findEncadrementDoctorant(PaysEncadrementDoctorant paysEncadrementDoctorant){
        EncadrementDoctorant loadedEncadrementDoctorant = null;
        if(paysEncadrementDoctorant.getEncadrementDoctorant() != null && paysEncadrementDoctorant.getEncadrementDoctorant().getId() !=null)
        loadedEncadrementDoctorant =encadrementDoctorantService.findById(paysEncadrementDoctorant.getEncadrementDoctorant().getId());

    if(loadedEncadrementDoctorant==null ) {
        return;
    }
    paysEncadrementDoctorant.setEncadrementDoctorant(loadedEncadrementDoctorant);
    }

@Override
@Transactional
public void delete(List<PaysEncadrementDoctorant> paysEncadrementDoctorants){
        if(ListUtil.isNotEmpty(paysEncadrementDoctorants)){
        paysEncadrementDoctorants.forEach(e->paysEncadrementDoctorantDao.delete(e));
        }
}
@Override
public void update(List<PaysEncadrementDoctorant> paysEncadrementDoctorants){
if(ListUtil.isNotEmpty(paysEncadrementDoctorants)){
paysEncadrementDoctorants.forEach(e->paysEncadrementDoctorantDao.save(e));
}
}



@Override
public List<List<PaysEncadrementDoctorant>>  getToBeSavedAndToBeDeleted(List<PaysEncadrementDoctorant> oldList,List<PaysEncadrementDoctorant> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

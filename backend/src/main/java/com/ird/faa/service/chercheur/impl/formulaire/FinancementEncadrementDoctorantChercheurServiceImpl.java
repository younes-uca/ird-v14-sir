package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.FinancementEncadrementDoctorant;
import com.ird.faa.bean.formulaire.FinancementDoctorant;
import com.ird.faa.bean.formulaire.EncadrementDoctorant;
import com.ird.faa.dao.formulaire.FinancementEncadrementDoctorantDao;
import com.ird.faa.service.chercheur.facade.formulaire.FinancementEncadrementDoctorantChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.FinancementDoctorantChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementDoctorantChercheurService;

import com.ird.faa.ws.rest.provided.vo.FinancementEncadrementDoctorantVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class FinancementEncadrementDoctorantChercheurServiceImpl extends AbstractServiceImpl<FinancementEncadrementDoctorant> implements FinancementEncadrementDoctorantChercheurService {

@Autowired
private FinancementEncadrementDoctorantDao financementEncadrementDoctorantDao;

        @Autowired
        private FinancementDoctorantChercheurService financementDoctorantChercheurService ;
        @Autowired
        private EncadrementDoctorantChercheurService encadrementDoctorantService ;


@Autowired
private EntityManager entityManager;


@Override
public List<FinancementEncadrementDoctorant> findAll(){
return financementEncadrementDoctorantDao.findAll();
}

        @Override
        public List<FinancementEncadrementDoctorant> findByFinancementCode(String code){
        return financementEncadrementDoctorantDao.findByFinancementCode(code);
        }

        @Override
        @Transactional
        public int deleteByFinancementCode(String code){
        return financementEncadrementDoctorantDao.deleteByFinancementCode(code);
        }

        @Override
        public List<FinancementEncadrementDoctorant> findByFinancementId(Long id){
        return financementEncadrementDoctorantDao.findByFinancementId(id);
        }

        @Override
        @Transactional
        public int deleteByFinancementId(Long id){
        return financementEncadrementDoctorantDao.deleteByFinancementId(id);
        }

        @Override
        public List<FinancementEncadrementDoctorant> findByEncadrementDoctorantId(Long id){
        return financementEncadrementDoctorantDao.findByEncadrementDoctorantId(id);
        }

        @Override
        @Transactional
        public int deleteByEncadrementDoctorantId(Long id){
        return financementEncadrementDoctorantDao.deleteByEncadrementDoctorantId(id);
        }


@Override
public FinancementEncadrementDoctorant findById(Long id){
if(id==null) return null;
return financementEncadrementDoctorantDao.getOne(id);
}

@Override
public FinancementEncadrementDoctorant findByIdWithAssociatedList(Long id){
FinancementEncadrementDoctorant enjeuxIrdEncadrementDoctorant  = findById(id);
return enjeuxIrdEncadrementDoctorant;
}


@Transactional
public int deleteById(Long id){
if(financementEncadrementDoctorantDao.findById(id) == null) return 0;
else{
financementEncadrementDoctorantDao.deleteById(id);
return 1;
}
}


@Override
public FinancementEncadrementDoctorant update(FinancementEncadrementDoctorant enjeuxIrdEncadrementDoctorant){
FinancementEncadrementDoctorant foundedFinancementEncadrementDoctorant = findById(enjeuxIrdEncadrementDoctorant.getId());
if(foundedFinancementEncadrementDoctorant==null) return null;
else{
return  financementEncadrementDoctorantDao.save(enjeuxIrdEncadrementDoctorant);
}
}

@Override
public FinancementEncadrementDoctorant save (FinancementEncadrementDoctorant enjeuxIrdEncadrementDoctorant){


    findFinancement(enjeuxIrdEncadrementDoctorant);
    findEncadrementDoctorant(enjeuxIrdEncadrementDoctorant);

FinancementEncadrementDoctorant savedFinancementEncadrementDoctorant = financementEncadrementDoctorantDao.save(enjeuxIrdEncadrementDoctorant);
return savedFinancementEncadrementDoctorant;
}

@Override
public List<FinancementEncadrementDoctorant> save(List<FinancementEncadrementDoctorant> enjeuxIrdEncadrementDoctorants){
List<FinancementEncadrementDoctorant> list = new ArrayList<FinancementEncadrementDoctorant>();
for(FinancementEncadrementDoctorant enjeuxIrdEncadrementDoctorant: enjeuxIrdEncadrementDoctorants){
list.add(save(enjeuxIrdEncadrementDoctorant));
}
return list;
}



@Override
@Transactional
public int delete(FinancementEncadrementDoctorant enjeuxIrdEncadrementDoctorant){
    if(enjeuxIrdEncadrementDoctorant.getId()==null) return -1;
    FinancementEncadrementDoctorant foundedFinancementEncadrementDoctorant = findById(enjeuxIrdEncadrementDoctorant.getId());
    if(foundedFinancementEncadrementDoctorant==null) return -1;
financementEncadrementDoctorantDao.delete(foundedFinancementEncadrementDoctorant);
return 1;
}


public List<FinancementEncadrementDoctorant> findByCriteria(FinancementEncadrementDoctorantVo enjeuxIrdEncadrementDoctorantVo){

String query = "SELECT o FROM FinancementEncadrementDoctorant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",enjeuxIrdEncadrementDoctorantVo.getId());
    if(enjeuxIrdEncadrementDoctorantVo.getFinancementDoctorantVo()!=null){
        query += SearchUtil.addConstraint( "o", "enjeuxIrd.id","=",enjeuxIrdEncadrementDoctorantVo.getFinancementDoctorantVo().getId());
            query += SearchUtil.addConstraint( "o", "enjeuxIrd.code","LIKE",enjeuxIrdEncadrementDoctorantVo.getFinancementDoctorantVo().getCode());
    }

    if(enjeuxIrdEncadrementDoctorantVo.getEncadrementDoctorantVo()!=null){
        query += SearchUtil.addConstraint( "o", "encadrementDoctorant.id","=",enjeuxIrdEncadrementDoctorantVo.getEncadrementDoctorantVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findFinancement(FinancementEncadrementDoctorant enjeuxIrdEncadrementDoctorant){
        FinancementDoctorant loadedFinancement =financementDoctorantChercheurService.findByIdOrCode(enjeuxIrdEncadrementDoctorant.getFinancement());

    if(loadedFinancement==null ) {
        return;
    }
    enjeuxIrdEncadrementDoctorant.setFinancement(loadedFinancement);
    }
    private void findEncadrementDoctorant(FinancementEncadrementDoctorant enjeuxIrdEncadrementDoctorant){
        EncadrementDoctorant loadedEncadrementDoctorant = null;
        if(enjeuxIrdEncadrementDoctorant.getEncadrementDoctorant() != null && enjeuxIrdEncadrementDoctorant.getEncadrementDoctorant().getId() !=null)
        loadedEncadrementDoctorant =encadrementDoctorantService.findById(enjeuxIrdEncadrementDoctorant.getEncadrementDoctorant().getId());

    if(loadedEncadrementDoctorant==null ) {
        return;
    }
    enjeuxIrdEncadrementDoctorant.setEncadrementDoctorant(loadedEncadrementDoctorant);
    }

@Override
@Transactional
public void delete(List<FinancementEncadrementDoctorant> enjeuxIrdEncadrementDoctorants){
        if(ListUtil.isNotEmpty(enjeuxIrdEncadrementDoctorants)){
        enjeuxIrdEncadrementDoctorants.forEach(e->financementEncadrementDoctorantDao.delete(e));
        }
}
@Override
public void update(List<FinancementEncadrementDoctorant> enjeuxIrdEncadrementDoctorants){
if(ListUtil.isNotEmpty(enjeuxIrdEncadrementDoctorants)){
enjeuxIrdEncadrementDoctorants.forEach(e->financementEncadrementDoctorantDao.save(e));
}
}



@Override
public List<List<FinancementEncadrementDoctorant>>  getToBeSavedAndToBeDeleted(List<FinancementEncadrementDoctorant> oldList,List<FinancementEncadrementDoctorant> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

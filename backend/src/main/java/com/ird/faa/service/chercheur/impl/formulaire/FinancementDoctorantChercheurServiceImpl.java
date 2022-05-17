package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.FinancementDoctorant;
import com.ird.faa.dao.formulaire.FinancementDoctorantDao;
import com.ird.faa.service.chercheur.facade.formulaire.FinancementDoctorantChercheurService;

import com.ird.faa.ws.rest.provided.vo.FinancementDoctorantVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class FinancementDoctorantChercheurServiceImpl extends AbstractServiceImpl<FinancementDoctorant> implements FinancementDoctorantChercheurService {

@Autowired
private FinancementDoctorantDao financementDoctorantDao;



@Autowired
private EntityManager entityManager;


@Override
public List<FinancementDoctorant> findAll(){
return financementDoctorantDao.findAll();
}
    @Override
    public FinancementDoctorant findByCode(String code){
    if( code==null) return null;
    return financementDoctorantDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return financementDoctorantDao.deleteByCode(code);
    }
    @Override
    public FinancementDoctorant findByIdOrCode(FinancementDoctorant financementDoctorant){
    FinancementDoctorant resultat=null;
    if(financementDoctorant == null || ( financementDoctorant.getCode()==null && financementDoctorant.getId()==null))
    return resultat;
    else{
    if(financementDoctorant.getId() != null){
    resultat= financementDoctorantDao.findById(financementDoctorant.getId()).get();
    }else if(StringUtil.isNotEmpty(financementDoctorant.getCode())) {
    resultat= financementDoctorantDao.findByCode(financementDoctorant.getCode());
    }
    return resultat;
    }
    }

@Override
public FinancementDoctorant findById(Long id){
if(id==null) return null;
return financementDoctorantDao.getOne(id);
}

@Override
public FinancementDoctorant findByIdWithAssociatedList(Long id){
FinancementDoctorant financementDoctorant  = findById(id);
return financementDoctorant;
}


@Transactional
public int deleteById(Long id){
if(financementDoctorantDao.findById(id) == null) return 0;
else{
financementDoctorantDao.deleteById(id);
return 1;
}
}


@Override
public FinancementDoctorant update(FinancementDoctorant financementDoctorant){
FinancementDoctorant foundedFinancementDoctorant = findById(financementDoctorant.getId());
if(foundedFinancementDoctorant==null) return null;
else{
return  financementDoctorantDao.save(financementDoctorant);
}
}

@Override
public FinancementDoctorant save (FinancementDoctorant financementDoctorant){
    FinancementDoctorant foundedFinancementDoctorant = findByCode(financementDoctorant.getCode());
   if(foundedFinancementDoctorant!=null) return null;



FinancementDoctorant savedFinancementDoctorant = financementDoctorantDao.save(financementDoctorant);
return savedFinancementDoctorant;
}

@Override
public List<FinancementDoctorant> save(List<FinancementDoctorant> financementDoctorants){
List<FinancementDoctorant> list = new ArrayList<FinancementDoctorant>();
for(FinancementDoctorant financementDoctorant: financementDoctorants){
list.add(save(financementDoctorant));
}
return list;
}



@Override
@Transactional
public int delete(FinancementDoctorant financementDoctorant){
    if(financementDoctorant.getCode()==null) return -1;

    FinancementDoctorant foundedFinancementDoctorant = findByCode(financementDoctorant.getCode());
    if(foundedFinancementDoctorant==null) return -1;
financementDoctorantDao.delete(foundedFinancementDoctorant);
return 1;
}


public List<FinancementDoctorant> findByCriteria(FinancementDoctorantVo financementDoctorantVo){

String query = "SELECT o FROM FinancementDoctorant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",financementDoctorantVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",financementDoctorantVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",financementDoctorantVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<FinancementDoctorant> financementDoctorants){
        if(ListUtil.isNotEmpty(financementDoctorants)){
        financementDoctorants.forEach(e->financementDoctorantDao.delete(e));
        }
}
@Override
public void update(List<FinancementDoctorant> financementDoctorants){
if(ListUtil.isNotEmpty(financementDoctorants)){
financementDoctorants.forEach(e->financementDoctorantDao.save(e));
}
}



@Override
public List<List<FinancementDoctorant>>  getToBeSavedAndToBeDeleted(List<FinancementDoctorant> oldList,List<FinancementDoctorant> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

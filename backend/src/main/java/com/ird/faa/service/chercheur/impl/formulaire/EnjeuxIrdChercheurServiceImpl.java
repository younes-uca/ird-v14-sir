package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.EnjeuxIrd;
import com.ird.faa.dao.formulaire.EnjeuxIrdDao;
import com.ird.faa.service.chercheur.facade.formulaire.EnjeuxIrdChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.EnjeuxIrdVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EnjeuxIrdChercheurServiceImpl extends AbstractServiceImpl<EnjeuxIrd> implements EnjeuxIrdChercheurService {

@Autowired
private EnjeuxIrdDao enjeuxIrdDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EnjeuxIrd> findAll(){
return enjeuxIrdDao.findAll();
}
    @Override
    public EnjeuxIrd findByCode(String code){
    if( code==null) return null;
    return enjeuxIrdDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return enjeuxIrdDao.deleteByCode(code);
    }
    @Override
    public EnjeuxIrd findByIdOrCode(EnjeuxIrd enjeuxIrd){
    EnjeuxIrd resultat=null;
    if(enjeuxIrd == null || ( enjeuxIrd.getCode()==null && enjeuxIrd.getId()==null))
    return resultat;
    else{
    if(enjeuxIrd.getId() != null){
    resultat= enjeuxIrdDao.findById(enjeuxIrd.getId()).get();
    }else if(StringUtil.isNotEmpty(enjeuxIrd.getCode())) {
    resultat= enjeuxIrdDao.findByCode(enjeuxIrd.getCode());
    }
    return resultat;
    }
    }

@Override
public EnjeuxIrd findById(Long id){
if(id==null) return null;
return enjeuxIrdDao.getOne(id);
}

@Override
public EnjeuxIrd findByIdWithAssociatedList(Long id){
EnjeuxIrd enjeuxIrd  = findById(id);
return enjeuxIrd;
}


@Transactional
public int deleteById(Long id){
if(enjeuxIrdDao.findById(id) == null) return 0;
else{
enjeuxIrdDao.deleteById(id);
return 1;
}
}


@Override
public EnjeuxIrd update(EnjeuxIrd enjeuxIrd){
EnjeuxIrd foundedEnjeuxIrd = findById(enjeuxIrd.getId());
if(foundedEnjeuxIrd==null) return null;
else{
return  enjeuxIrdDao.save(enjeuxIrd);
}
}

@Override
public EnjeuxIrd save (EnjeuxIrd enjeuxIrd){
    EnjeuxIrd foundedEnjeuxIrd = findByCode(enjeuxIrd.getCode());
   if(foundedEnjeuxIrd!=null) return null;



EnjeuxIrd savedEnjeuxIrd = enjeuxIrdDao.save(enjeuxIrd);
return savedEnjeuxIrd;
}

@Override
public List<EnjeuxIrd> save(List<EnjeuxIrd> enjeuxIrds){
List<EnjeuxIrd> list = new ArrayList<EnjeuxIrd>();
for(EnjeuxIrd enjeuxIrd: enjeuxIrds){
list.add(save(enjeuxIrd));
}
return list;
}



@Override
@Transactional
public int delete(EnjeuxIrd enjeuxIrd){
    if(enjeuxIrd.getCode()==null) return -1;

    EnjeuxIrd foundedEnjeuxIrd = findByCode(enjeuxIrd.getCode());
    if(foundedEnjeuxIrd==null) return -1;
enjeuxIrdDao.delete(foundedEnjeuxIrd);
return 1;
}


public List<EnjeuxIrd> findByCriteria(EnjeuxIrdVo enjeuxIrdVo){

String query = "SELECT o FROM EnjeuxIrd o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",enjeuxIrdVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",enjeuxIrdVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",enjeuxIrdVo.getCode());
            query += SearchUtil.addConstraint( "o", "description","LIKE",enjeuxIrdVo.getDescription());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EnjeuxIrd> enjeuxIrds){
        if(ListUtil.isNotEmpty(enjeuxIrds)){
        enjeuxIrds.forEach(e->enjeuxIrdDao.delete(e));
        }
}
@Override
public void update(List<EnjeuxIrd> enjeuxIrds){
if(ListUtil.isNotEmpty(enjeuxIrds)){
enjeuxIrds.forEach(e->enjeuxIrdDao.save(e));
}
}



@Override
public List<List<EnjeuxIrd>>  getToBeSavedAndToBeDeleted(List<EnjeuxIrd> oldList,List<EnjeuxIrd> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

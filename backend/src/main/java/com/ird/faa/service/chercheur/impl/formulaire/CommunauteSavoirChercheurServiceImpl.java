package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.CommunauteSavoir;
import com.ird.faa.dao.formulaire.CommunauteSavoirDao;
import com.ird.faa.service.chercheur.facade.formulaire.CommunauteSavoirChercheurService;

import com.ird.faa.ws.rest.provided.vo.CommunauteSavoirVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CommunauteSavoirChercheurServiceImpl extends AbstractServiceImpl<CommunauteSavoir> implements CommunauteSavoirChercheurService {

@Autowired
private CommunauteSavoirDao communauteSavoirDao;



@Autowired
private EntityManager entityManager;


@Override
public List<CommunauteSavoir> findAll(){
return communauteSavoirDao.findAll();
}
    @Override
    public CommunauteSavoir findByCode(String code){
    if( code==null) return null;
    return communauteSavoirDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return communauteSavoirDao.deleteByCode(code);
    }
    @Override
    public CommunauteSavoir findByIdOrCode(CommunauteSavoir communauteSavoir){
    CommunauteSavoir resultat=null;
    if(communauteSavoir == null || ( communauteSavoir.getCode()==null && communauteSavoir.getId()==null))
    return resultat;
    else{
    if(communauteSavoir.getId() != null){
    resultat= communauteSavoirDao.findById(communauteSavoir.getId()).get();
    }else if(StringUtil.isNotEmpty(communauteSavoir.getCode())) {
    resultat= communauteSavoirDao.findByCode(communauteSavoir.getCode());
    }
    return resultat;
    }
    }

@Override
public CommunauteSavoir findById(Long id){
if(id==null) return null;
return communauteSavoirDao.getOne(id);
}

@Override
public CommunauteSavoir findByIdWithAssociatedList(Long id){
CommunauteSavoir communauteSavoir  = findById(id);
return communauteSavoir;
}


@Transactional
public int deleteById(Long id){
if(communauteSavoirDao.findById(id) == null) return 0;
else{
communauteSavoirDao.deleteById(id);
return 1;
}
}


@Override
public CommunauteSavoir update(CommunauteSavoir communauteSavoir){
CommunauteSavoir foundedCommunauteSavoir = findById(communauteSavoir.getId());
if(foundedCommunauteSavoir==null) return null;
else{
return  communauteSavoirDao.save(communauteSavoir);
}
}

@Override
public CommunauteSavoir save (CommunauteSavoir communauteSavoir){
    CommunauteSavoir foundedCommunauteSavoir = findByCode(communauteSavoir.getCode());
   if(foundedCommunauteSavoir!=null) return null;



CommunauteSavoir savedCommunauteSavoir = communauteSavoirDao.save(communauteSavoir);
return savedCommunauteSavoir;
}

@Override
public List<CommunauteSavoir> save(List<CommunauteSavoir> communauteSavoirs){
List<CommunauteSavoir> list = new ArrayList<CommunauteSavoir>();
for(CommunauteSavoir communauteSavoir: communauteSavoirs){
list.add(save(communauteSavoir));
}
return list;
}



@Override
@Transactional
public int delete(CommunauteSavoir communauteSavoir){
    if(communauteSavoir.getCode()==null) return -1;

    CommunauteSavoir foundedCommunauteSavoir = findByCode(communauteSavoir.getCode());
    if(foundedCommunauteSavoir==null) return -1;
communauteSavoirDao.delete(foundedCommunauteSavoir);
return 1;
}


public List<CommunauteSavoir> findByCriteria(CommunauteSavoirVo communauteSavoirVo){

String query = "SELECT o FROM CommunauteSavoir o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",communauteSavoirVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",communauteSavoirVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",communauteSavoirVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<CommunauteSavoir> communauteSavoirs){
        if(ListUtil.isNotEmpty(communauteSavoirs)){
        communauteSavoirs.forEach(e->communauteSavoirDao.delete(e));
        }
}
@Override
public void update(List<CommunauteSavoir> communauteSavoirs){
if(ListUtil.isNotEmpty(communauteSavoirs)){
communauteSavoirs.forEach(e->communauteSavoirDao.save(e));
}
}



@Override
public List<List<CommunauteSavoir>>  getToBeSavedAndToBeDeleted(List<CommunauteSavoir> oldList,List<CommunauteSavoir> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.MasterInternational;
import com.ird.faa.dao.formulaire.MasterInternationalDao;
import com.ird.faa.service.chercheur.facade.formulaire.MasterInternationalChercheurService;

import com.ird.faa.ws.rest.provided.vo.MasterInternationalVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class MasterInternationalChercheurServiceImpl extends AbstractServiceImpl<MasterInternational> implements MasterInternationalChercheurService {

@Autowired
private MasterInternationalDao masterInternationalDao;



@Autowired
private EntityManager entityManager;


@Override
public List<MasterInternational> findAll(){
return masterInternationalDao.findAll();
}
    @Override
    public MasterInternational findByCode(String code){
    if( code==null) return null;
    return masterInternationalDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return masterInternationalDao.deleteByCode(code);
    }
    @Override
    public MasterInternational findByIdOrCode(MasterInternational masterInternational){
    MasterInternational resultat=null;
    if(masterInternational == null || ( masterInternational.getCode()==null && masterInternational.getId()==null))
    return resultat;
    else{
    if(masterInternational.getId() != null){
    resultat= masterInternationalDao.findById(masterInternational.getId()).get();
    }else if(StringUtil.isNotEmpty(masterInternational.getCode())) {
    resultat= masterInternationalDao.findByCode(masterInternational.getCode());
    }
    return resultat;
    }
    }

@Override
public MasterInternational findById(Long id){
if(id==null) return null;
return masterInternationalDao.getOne(id);
}

@Override
public MasterInternational findByIdWithAssociatedList(Long id){
MasterInternational masterInternational  = findById(id);
return masterInternational;
}


@Transactional
public int deleteById(Long id){
if(masterInternationalDao.findById(id) == null) return 0;
else{
masterInternationalDao.deleteById(id);
return 1;
}
}


@Override
public MasterInternational update(MasterInternational masterInternational){
MasterInternational foundedMasterInternational = findById(masterInternational.getId());
if(foundedMasterInternational==null) return null;
else{
return  masterInternationalDao.save(masterInternational);
}
}

@Override
public MasterInternational save (MasterInternational masterInternational){
    MasterInternational foundedMasterInternational = findByCode(masterInternational.getCode());
   if(foundedMasterInternational!=null) return null;



MasterInternational savedMasterInternational = masterInternationalDao.save(masterInternational);
return savedMasterInternational;
}

@Override
public List<MasterInternational> save(List<MasterInternational> masterInternationals){
List<MasterInternational> list = new ArrayList<MasterInternational>();
for(MasterInternational masterInternational: masterInternationals){
list.add(save(masterInternational));
}
return list;
}



@Override
@Transactional
public int delete(MasterInternational masterInternational){
    if(masterInternational.getCode()==null) return -1;

    MasterInternational foundedMasterInternational = findByCode(masterInternational.getCode());
    if(foundedMasterInternational==null) return -1;
masterInternationalDao.delete(foundedMasterInternational);
return 1;
}


public List<MasterInternational> findByCriteria(MasterInternationalVo masterInternationalVo){

String query = "SELECT o FROM MasterInternational o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",masterInternationalVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",masterInternationalVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",masterInternationalVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<MasterInternational> masterInternationals){
        if(ListUtil.isNotEmpty(masterInternationals)){
        masterInternationals.forEach(e->masterInternationalDao.delete(e));
        }
}
@Override
public void update(List<MasterInternational> masterInternationals){
if(ListUtil.isNotEmpty(masterInternationals)){
masterInternationals.forEach(e->masterInternationalDao.save(e));
}
}



@Override
public List<List<MasterInternational>>  getToBeSavedAndToBeDeleted(List<MasterInternational> oldList,List<MasterInternational> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.ObjetGlobal;
import com.ird.faa.dao.formulaire.ObjetGlobalDao;
import com.ird.faa.service.chercheur.facade.formulaire.ObjetGlobalChercheurService;

import com.ird.faa.ws.rest.provided.vo.ObjetGlobalVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ObjetGlobalChercheurServiceImpl extends AbstractServiceImpl<ObjetGlobal> implements ObjetGlobalChercheurService {

@Autowired
private ObjetGlobalDao objetGlobalDao;



@Autowired
private EntityManager entityManager;


@Override
public List<ObjetGlobal> findAll(){
return objetGlobalDao.findAll();
}
    @Override
    public ObjetGlobal findByCode(String code){
    if( code==null) return null;
    return objetGlobalDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return objetGlobalDao.deleteByCode(code);
    }
    @Override
    public ObjetGlobal findByIdOrCode(ObjetGlobal objetGlobal){
    ObjetGlobal resultat=null;
    if(objetGlobal == null || ( objetGlobal.getCode()==null && objetGlobal.getId()==null))
    return resultat;
    else{
    if(objetGlobal.getId() != null){
    resultat= objetGlobalDao.findById(objetGlobal.getId()).get();
    }else if(StringUtil.isNotEmpty(objetGlobal.getCode())) {
    resultat= objetGlobalDao.findByCode(objetGlobal.getCode());
    }
    return resultat;
    }
    }

@Override
public ObjetGlobal findById(Long id){
if(id==null) return null;
return objetGlobalDao.getOne(id);
}

@Override
public ObjetGlobal findByIdWithAssociatedList(Long id){
ObjetGlobal objetGlobal  = findById(id);
return objetGlobal;
}


@Transactional
public int deleteById(Long id){
if(objetGlobalDao.findById(id) == null) return 0;
else{
objetGlobalDao.deleteById(id);
return 1;
}
}


@Override
public ObjetGlobal update(ObjetGlobal objetGlobal){
ObjetGlobal foundedObjetGlobal = findById(objetGlobal.getId());
if(foundedObjetGlobal==null) return null;
else{
return  objetGlobalDao.save(objetGlobal);
}
}

@Override
public ObjetGlobal save (ObjetGlobal objetGlobal){
    ObjetGlobal foundedObjetGlobal = findByCode(objetGlobal.getCode());
   if(foundedObjetGlobal!=null) return null;



ObjetGlobal savedObjetGlobal = objetGlobalDao.save(objetGlobal);
return savedObjetGlobal;
}

@Override
public List<ObjetGlobal> save(List<ObjetGlobal> objetGlobals){
List<ObjetGlobal> list = new ArrayList<ObjetGlobal>();
for(ObjetGlobal objetGlobal: objetGlobals){
list.add(save(objetGlobal));
}
return list;
}



@Override
@Transactional
public int delete(ObjetGlobal objetGlobal){
    if(objetGlobal.getCode()==null) return -1;

    ObjetGlobal foundedObjetGlobal = findByCode(objetGlobal.getCode());
    if(foundedObjetGlobal==null) return -1;
objetGlobalDao.delete(foundedObjetGlobal);
return 1;
}


public List<ObjetGlobal> findByCriteria(ObjetGlobalVo objetGlobalVo){

String query = "SELECT o FROM ObjetGlobal o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",objetGlobalVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",objetGlobalVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",objetGlobalVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<ObjetGlobal> objetGlobals){
        if(ListUtil.isNotEmpty(objetGlobals)){
        objetGlobals.forEach(e->objetGlobalDao.delete(e));
        }
}
@Override
public void update(List<ObjetGlobal> objetGlobals){
if(ListUtil.isNotEmpty(objetGlobals)){
objetGlobals.forEach(e->objetGlobalDao.save(e));
}
}



@Override
public List<List<ObjetGlobal>>  getToBeSavedAndToBeDeleted(List<ObjetGlobal> oldList,List<ObjetGlobal> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

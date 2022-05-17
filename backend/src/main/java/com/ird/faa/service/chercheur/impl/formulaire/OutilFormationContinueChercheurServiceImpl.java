package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.OutilFormationContinue;
import com.ird.faa.dao.formulaire.OutilFormationContinueDao;
import com.ird.faa.service.chercheur.facade.formulaire.OutilFormationContinueChercheurService;

import com.ird.faa.ws.rest.provided.vo.OutilFormationContinueVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class OutilFormationContinueChercheurServiceImpl extends AbstractServiceImpl<OutilFormationContinue> implements OutilFormationContinueChercheurService {

@Autowired
private OutilFormationContinueDao outilFormationContinueDao;



@Autowired
private EntityManager entityManager;


@Override
public List<OutilFormationContinue> findAll(){
return outilFormationContinueDao.findAll();
}
    @Override
    public OutilFormationContinue findByCode(String code){
    if( code==null) return null;
    return outilFormationContinueDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return outilFormationContinueDao.deleteByCode(code);
    }
    @Override
    public OutilFormationContinue findByIdOrCode(OutilFormationContinue outilFormationContinue){
    OutilFormationContinue resultat=null;
    if(outilFormationContinue == null || ( outilFormationContinue.getCode()==null && outilFormationContinue.getId()==null))
    return resultat;
    else{
    if(outilFormationContinue.getId() != null){
    resultat= outilFormationContinueDao.findById(outilFormationContinue.getId()).get();
    }else if(StringUtil.isNotEmpty(outilFormationContinue.getCode())) {
    resultat= outilFormationContinueDao.findByCode(outilFormationContinue.getCode());
    }
    return resultat;
    }
    }

@Override
public OutilFormationContinue findById(Long id){
if(id==null) return null;
return outilFormationContinueDao.getOne(id);
}

@Override
public OutilFormationContinue findByIdWithAssociatedList(Long id){
OutilFormationContinue outilFormationContinue  = findById(id);
return outilFormationContinue;
}


@Transactional
public int deleteById(Long id){
if(outilFormationContinueDao.findById(id) == null) return 0;
else{
outilFormationContinueDao.deleteById(id);
return 1;
}
}


@Override
public OutilFormationContinue update(OutilFormationContinue outilFormationContinue){
OutilFormationContinue foundedOutilFormationContinue = findById(outilFormationContinue.getId());
if(foundedOutilFormationContinue==null) return null;
else{
return  outilFormationContinueDao.save(outilFormationContinue);
}
}

@Override
public OutilFormationContinue save (OutilFormationContinue outilFormationContinue){
    OutilFormationContinue foundedOutilFormationContinue = findByCode(outilFormationContinue.getCode());
   if(foundedOutilFormationContinue!=null) return null;



OutilFormationContinue savedOutilFormationContinue = outilFormationContinueDao.save(outilFormationContinue);
return savedOutilFormationContinue;
}

@Override
public List<OutilFormationContinue> save(List<OutilFormationContinue> outilFormationContinues){
List<OutilFormationContinue> list = new ArrayList<OutilFormationContinue>();
for(OutilFormationContinue outilFormationContinue: outilFormationContinues){
list.add(save(outilFormationContinue));
}
return list;
}



@Override
@Transactional
public int delete(OutilFormationContinue outilFormationContinue){
    if(outilFormationContinue.getCode()==null) return -1;

    OutilFormationContinue foundedOutilFormationContinue = findByCode(outilFormationContinue.getCode());
    if(foundedOutilFormationContinue==null) return -1;
outilFormationContinueDao.delete(foundedOutilFormationContinue);
return 1;
}


public List<OutilFormationContinue> findByCriteria(OutilFormationContinueVo outilFormationContinueVo){

String query = "SELECT o FROM OutilFormationContinue o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",outilFormationContinueVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",outilFormationContinueVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",outilFormationContinueVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<OutilFormationContinue> outilFormationContinues){
        if(ListUtil.isNotEmpty(outilFormationContinues)){
        outilFormationContinues.forEach(e->outilFormationContinueDao.delete(e));
        }
}
@Override
public void update(List<OutilFormationContinue> outilFormationContinues){
if(ListUtil.isNotEmpty(outilFormationContinues)){
outilFormationContinues.forEach(e->outilFormationContinueDao.save(e));
}
}



@Override
public List<List<OutilFormationContinue>>  getToBeSavedAndToBeDeleted(List<OutilFormationContinue> oldList,List<OutilFormationContinue> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

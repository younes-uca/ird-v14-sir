package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.StatutEcoleDoctorale;
import com.ird.faa.dao.formulaire.StatutEcoleDoctoraleDao;
import com.ird.faa.service.chercheur.facade.formulaire.StatutEcoleDoctoraleChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.StatutEcoleDoctoraleVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class StatutEcoleDoctoraleChercheurServiceImpl extends AbstractServiceImpl<StatutEcoleDoctorale> implements StatutEcoleDoctoraleChercheurService {

@Autowired
private StatutEcoleDoctoraleDao statutEcoleDoctoraleDao;



@Autowired
private EntityManager entityManager;


@Override
public List<StatutEcoleDoctorale> findAll(){
return statutEcoleDoctoraleDao.findAll();
}
    @Override
    public StatutEcoleDoctorale findByCode(String code){
    if( code==null) return null;
    return statutEcoleDoctoraleDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return statutEcoleDoctoraleDao.deleteByCode(code);
    }
    @Override
    public StatutEcoleDoctorale findByIdOrCode(StatutEcoleDoctorale statutEcoleDoctorale){
    StatutEcoleDoctorale resultat=null;
    if(statutEcoleDoctorale == null || ( statutEcoleDoctorale.getCode()==null && statutEcoleDoctorale.getId()==null))
    return resultat;
    else{
    if(statutEcoleDoctorale.getId() != null){
    resultat= statutEcoleDoctoraleDao.findById(statutEcoleDoctorale.getId()).get();
    }else if(StringUtil.isNotEmpty(statutEcoleDoctorale.getCode())) {
    resultat= statutEcoleDoctoraleDao.findByCode(statutEcoleDoctorale.getCode());
    }
    return resultat;
    }
    }

@Override
public StatutEcoleDoctorale findById(Long id){
if(id==null) return null;
return statutEcoleDoctoraleDao.getOne(id);
}

@Override
public StatutEcoleDoctorale findByIdWithAssociatedList(Long id){
StatutEcoleDoctorale statutEcoleDoctorale  = findById(id);
return statutEcoleDoctorale;
}


@Transactional
public int deleteById(Long id){
if(statutEcoleDoctoraleDao.findById(id) == null) return 0;
else{
statutEcoleDoctoraleDao.deleteById(id);
return 1;
}
}


@Override
public StatutEcoleDoctorale update(StatutEcoleDoctorale statutEcoleDoctorale){
StatutEcoleDoctorale foundedStatutEcoleDoctorale = findById(statutEcoleDoctorale.getId());
if(foundedStatutEcoleDoctorale==null) return null;
else{
return  statutEcoleDoctoraleDao.save(statutEcoleDoctorale);
}
}

@Override
public StatutEcoleDoctorale save (StatutEcoleDoctorale statutEcoleDoctorale){
    StatutEcoleDoctorale foundedStatutEcoleDoctorale = findByCode(statutEcoleDoctorale.getCode());
   if(foundedStatutEcoleDoctorale!=null) return null;



StatutEcoleDoctorale savedStatutEcoleDoctorale = statutEcoleDoctoraleDao.save(statutEcoleDoctorale);
return savedStatutEcoleDoctorale;
}

@Override
public List<StatutEcoleDoctorale> save(List<StatutEcoleDoctorale> statutEcoleDoctorales){
List<StatutEcoleDoctorale> list = new ArrayList<StatutEcoleDoctorale>();
for(StatutEcoleDoctorale statutEcoleDoctorale: statutEcoleDoctorales){
list.add(save(statutEcoleDoctorale));
}
return list;
}



@Override
@Transactional
public int delete(StatutEcoleDoctorale statutEcoleDoctorale){
    if(statutEcoleDoctorale.getCode()==null) return -1;

    StatutEcoleDoctorale foundedStatutEcoleDoctorale = findByCode(statutEcoleDoctorale.getCode());
    if(foundedStatutEcoleDoctorale==null) return -1;
statutEcoleDoctoraleDao.delete(foundedStatutEcoleDoctorale);
return 1;
}


public List<StatutEcoleDoctorale> findByCriteria(StatutEcoleDoctoraleVo statutEcoleDoctoraleVo){

String query = "SELECT o FROM StatutEcoleDoctorale o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",statutEcoleDoctoraleVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",statutEcoleDoctoraleVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",statutEcoleDoctoraleVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<StatutEcoleDoctorale> statutEcoleDoctorales){
        if(ListUtil.isNotEmpty(statutEcoleDoctorales)){
        statutEcoleDoctorales.forEach(e->statutEcoleDoctoraleDao.delete(e));
        }
}
@Override
public void update(List<StatutEcoleDoctorale> statutEcoleDoctorales){
if(ListUtil.isNotEmpty(statutEcoleDoctorales)){
statutEcoleDoctorales.forEach(e->statutEcoleDoctoraleDao.save(e));
}
}



@Override
public List<List<StatutEcoleDoctorale>>  getToBeSavedAndToBeDeleted(List<StatutEcoleDoctorale> oldList,List<StatutEcoleDoctorale> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

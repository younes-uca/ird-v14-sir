package com.ird.faa.service.admin.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.TypeSavoir;
import com.ird.faa.dao.formulaire.TypeSavoirDao;
import com.ird.faa.service.admin.facade.formulaire.TypeSavoirAdminService;

import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.TypeSavoirVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeSavoirAdminServiceImpl extends AbstractServiceImpl<TypeSavoir> implements TypeSavoirAdminService {

@Autowired
private TypeSavoirDao typeSavoirDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeSavoir> findAll(){
return typeSavoirDao.findAll();
}
    @Override
    public TypeSavoir findByCode(String code){
    if( code==null) return null;
    return typeSavoirDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return typeSavoirDao.deleteByCode(code);
    }
    @Override
    public TypeSavoir findByIdOrCode(TypeSavoir typeSavoir){
    TypeSavoir resultat=null;
    if(typeSavoir == null || ( typeSavoir.getCode()==null && typeSavoir.getId()==null))
    return resultat;
    else{
    if(typeSavoir.getId() != null){
    resultat= typeSavoirDao.findById(typeSavoir.getId()).get();
    }else if(StringUtil.isNotEmpty(typeSavoir.getCode())) {
    resultat= typeSavoirDao.findByCode(typeSavoir.getCode());
    }
    return resultat;
    }
    }

@Override
public TypeSavoir findById(Long id){
if(id==null) return null;
return typeSavoirDao.getOne(id);
}

@Override
public TypeSavoir findByIdWithAssociatedList(Long id){
TypeSavoir typeSavoir  = findById(id);
return typeSavoir;
}


@Transactional
public int deleteById(Long id){
if(typeSavoirDao.findById(id) == null) return 0;
else{
typeSavoirDao.deleteById(id);
return 1;
}
}


@Override
public TypeSavoir update(TypeSavoir typeSavoir){
TypeSavoir foundedTypeSavoir = findById(typeSavoir.getId());
if(foundedTypeSavoir==null) return null;
else{
return  typeSavoirDao.save(typeSavoir);
}
}

@Override
public TypeSavoir save (TypeSavoir typeSavoir){
    TypeSavoir foundedTypeSavoir = findByCode(typeSavoir.getCode());
   if(foundedTypeSavoir!=null) return null;



TypeSavoir savedTypeSavoir = typeSavoirDao.save(typeSavoir);
return savedTypeSavoir;
}

@Override
public List<TypeSavoir> save(List<TypeSavoir> typeSavoirs){
List<TypeSavoir> list = new ArrayList<TypeSavoir>();
for(TypeSavoir typeSavoir: typeSavoirs){
list.add(save(typeSavoir));
}
return list;
}



@Override
@Transactional
public int delete(TypeSavoir typeSavoir){
    if(typeSavoir.getCode()==null) return -1;

    TypeSavoir foundedTypeSavoir = findByCode(typeSavoir.getCode());
    if(foundedTypeSavoir==null) return -1;
typeSavoirDao.delete(foundedTypeSavoir);
return 1;
}


public List<TypeSavoir> findByCriteria(TypeSavoirVo typeSavoirVo){

String query = "SELECT o FROM TypeSavoir o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeSavoirVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeSavoirVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",typeSavoirVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeSavoir> typeSavoirs){
        if(ListUtil.isNotEmpty(typeSavoirs)){
        typeSavoirs.forEach(e->typeSavoirDao.delete(e));
        }
}
@Override
public void update(List<TypeSavoir> typeSavoirs){
if(ListUtil.isNotEmpty(typeSavoirs)){
typeSavoirs.forEach(e->typeSavoirDao.save(e));
}
}



@Override
public List<List<TypeSavoir>>  getToBeSavedAndToBeDeleted(List<TypeSavoir> oldList,List<TypeSavoir> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

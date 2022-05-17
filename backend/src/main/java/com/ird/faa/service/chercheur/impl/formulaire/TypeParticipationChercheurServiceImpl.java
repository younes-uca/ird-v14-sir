package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.TypeParticipation;
import com.ird.faa.dao.formulaire.TypeParticipationDao;
import com.ird.faa.service.chercheur.facade.formulaire.TypeParticipationChercheurService;

import com.ird.faa.ws.rest.provided.vo.TypeParticipationVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeParticipationChercheurServiceImpl extends AbstractServiceImpl<TypeParticipation> implements TypeParticipationChercheurService {

@Autowired
private TypeParticipationDao typeParticipationDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeParticipation> findAll(){
return typeParticipationDao.findAll();
}
    @Override
    public TypeParticipation findByCode(String code){
    if( code==null) return null;
    return typeParticipationDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return typeParticipationDao.deleteByCode(code);
    }
    @Override
    public TypeParticipation findByIdOrCode(TypeParticipation typeParticipation){
    TypeParticipation resultat=null;
    if(typeParticipation == null || ( typeParticipation.getCode()==null && typeParticipation.getId()==null))
    return resultat;
    else{
    if(typeParticipation.getId() != null){
    resultat= typeParticipationDao.findById(typeParticipation.getId()).get();
    }else if(StringUtil.isNotEmpty(typeParticipation.getCode())) {
    resultat= typeParticipationDao.findByCode(typeParticipation.getCode());
    }
    return resultat;
    }
    }

@Override
public TypeParticipation findById(Long id){
if(id==null) return null;
return typeParticipationDao.getOne(id);
}

@Override
public TypeParticipation findByIdWithAssociatedList(Long id){
TypeParticipation typeParticipation  = findById(id);
return typeParticipation;
}


@Transactional
public int deleteById(Long id){
if(typeParticipationDao.findById(id) == null) return 0;
else{
typeParticipationDao.deleteById(id);
return 1;
}
}


@Override
public TypeParticipation update(TypeParticipation typeParticipation){
TypeParticipation foundedTypeParticipation = findById(typeParticipation.getId());
if(foundedTypeParticipation==null) return null;
else{
return  typeParticipationDao.save(typeParticipation);
}
}

@Override
public TypeParticipation save (TypeParticipation typeParticipation){
    TypeParticipation foundedTypeParticipation = findByCode(typeParticipation.getCode());
   if(foundedTypeParticipation!=null) return null;



TypeParticipation savedTypeParticipation = typeParticipationDao.save(typeParticipation);
return savedTypeParticipation;
}

@Override
public List<TypeParticipation> save(List<TypeParticipation> typeParticipations){
List<TypeParticipation> list = new ArrayList<TypeParticipation>();
for(TypeParticipation typeParticipation: typeParticipations){
list.add(save(typeParticipation));
}
return list;
}



@Override
@Transactional
public int delete(TypeParticipation typeParticipation){
    if(typeParticipation.getCode()==null) return -1;

    TypeParticipation foundedTypeParticipation = findByCode(typeParticipation.getCode());
    if(foundedTypeParticipation==null) return -1;
typeParticipationDao.delete(foundedTypeParticipation);
return 1;
}


public List<TypeParticipation> findByCriteria(TypeParticipationVo typeParticipationVo){

String query = "SELECT o FROM TypeParticipation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeParticipationVo.getId());
            query += SearchUtil.addConstraint( "o", "code","LIKE",typeParticipationVo.getCode());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeParticipationVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeParticipation> typeParticipations){
        if(ListUtil.isNotEmpty(typeParticipations)){
        typeParticipations.forEach(e->typeParticipationDao.delete(e));
        }
}
@Override
public void update(List<TypeParticipation> typeParticipations){
if(ListUtil.isNotEmpty(typeParticipations)){
typeParticipations.forEach(e->typeParticipationDao.save(e));
}
}



@Override
public List<List<TypeParticipation>>  getToBeSavedAndToBeDeleted(List<TypeParticipation> oldList,List<TypeParticipation> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.TypeInstrumentsEtDispositifsIrd;
import com.ird.faa.dao.formulaire.TypeInstrumentsEtDispositifsIrdDao;
import com.ird.faa.service.chercheur.facade.formulaire.TypeInstrumentsEtDispositifsIrdChercheurService;

import com.ird.faa.ws.rest.provided.vo.TypeInstrumentsEtDispositifsIrdVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeInstrumentsEtDispositifsIrdChercheurServiceImpl extends AbstractServiceImpl<TypeInstrumentsEtDispositifsIrd> implements TypeInstrumentsEtDispositifsIrdChercheurService {

@Autowired
private TypeInstrumentsEtDispositifsIrdDao typeInstrumentsEtDispositifsIrdDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeInstrumentsEtDispositifsIrd> findAll(){
return typeInstrumentsEtDispositifsIrdDao.findAll();
}
    @Override
    public TypeInstrumentsEtDispositifsIrd findByCode(String code){
    if( code==null) return null;
    return typeInstrumentsEtDispositifsIrdDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return typeInstrumentsEtDispositifsIrdDao.deleteByCode(code);
    }
    @Override
    public TypeInstrumentsEtDispositifsIrd findByIdOrCode(TypeInstrumentsEtDispositifsIrd typeInstrumentsEtDispositifsIrd){
    TypeInstrumentsEtDispositifsIrd resultat=null;
    if(typeInstrumentsEtDispositifsIrd == null || ( typeInstrumentsEtDispositifsIrd.getCode()==null && typeInstrumentsEtDispositifsIrd.getId()==null))
    return resultat;
    else{
    if(typeInstrumentsEtDispositifsIrd.getId() != null){
    resultat= typeInstrumentsEtDispositifsIrdDao.findById(typeInstrumentsEtDispositifsIrd.getId()).get();
    }else if(StringUtil.isNotEmpty(typeInstrumentsEtDispositifsIrd.getCode())) {
    resultat= typeInstrumentsEtDispositifsIrdDao.findByCode(typeInstrumentsEtDispositifsIrd.getCode());
    }
    return resultat;
    }
    }

@Override
public TypeInstrumentsEtDispositifsIrd findById(Long id){
if(id==null) return null;
return typeInstrumentsEtDispositifsIrdDao.getOne(id);
}

@Override
public TypeInstrumentsEtDispositifsIrd findByIdWithAssociatedList(Long id){
TypeInstrumentsEtDispositifsIrd typeInstrumentsEtDispositifsIrd  = findById(id);
return typeInstrumentsEtDispositifsIrd;
}


@Transactional
public int deleteById(Long id){
if(typeInstrumentsEtDispositifsIrdDao.findById(id) == null) return 0;
else{
typeInstrumentsEtDispositifsIrdDao.deleteById(id);
return 1;
}
}


@Override
public TypeInstrumentsEtDispositifsIrd update(TypeInstrumentsEtDispositifsIrd typeInstrumentsEtDispositifsIrd){
TypeInstrumentsEtDispositifsIrd foundedTypeInstrumentsEtDispositifsIrd = findById(typeInstrumentsEtDispositifsIrd.getId());
if(foundedTypeInstrumentsEtDispositifsIrd==null) return null;
else{
return  typeInstrumentsEtDispositifsIrdDao.save(typeInstrumentsEtDispositifsIrd);
}
}

@Override
public TypeInstrumentsEtDispositifsIrd save (TypeInstrumentsEtDispositifsIrd typeInstrumentsEtDispositifsIrd){
    TypeInstrumentsEtDispositifsIrd foundedTypeInstrumentsEtDispositifsIrd = findByCode(typeInstrumentsEtDispositifsIrd.getCode());
   if(foundedTypeInstrumentsEtDispositifsIrd!=null) return null;



TypeInstrumentsEtDispositifsIrd savedTypeInstrumentsEtDispositifsIrd = typeInstrumentsEtDispositifsIrdDao.save(typeInstrumentsEtDispositifsIrd);
return savedTypeInstrumentsEtDispositifsIrd;
}

@Override
public List<TypeInstrumentsEtDispositifsIrd> save(List<TypeInstrumentsEtDispositifsIrd> typeInstrumentsEtDispositifsIrds){
List<TypeInstrumentsEtDispositifsIrd> list = new ArrayList<TypeInstrumentsEtDispositifsIrd>();
for(TypeInstrumentsEtDispositifsIrd typeInstrumentsEtDispositifsIrd: typeInstrumentsEtDispositifsIrds){
list.add(save(typeInstrumentsEtDispositifsIrd));
}
return list;
}



@Override
@Transactional
public int delete(TypeInstrumentsEtDispositifsIrd typeInstrumentsEtDispositifsIrd){
    if(typeInstrumentsEtDispositifsIrd.getCode()==null) return -1;

    TypeInstrumentsEtDispositifsIrd foundedTypeInstrumentsEtDispositifsIrd = findByCode(typeInstrumentsEtDispositifsIrd.getCode());
    if(foundedTypeInstrumentsEtDispositifsIrd==null) return -1;
typeInstrumentsEtDispositifsIrdDao.delete(foundedTypeInstrumentsEtDispositifsIrd);
return 1;
}


public List<TypeInstrumentsEtDispositifsIrd> findByCriteria(TypeInstrumentsEtDispositifsIrdVo typeInstrumentsEtDispositifsIrdVo){

String query = "SELECT o FROM TypeInstrumentsEtDispositifsIrd o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeInstrumentsEtDispositifsIrdVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeInstrumentsEtDispositifsIrdVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",typeInstrumentsEtDispositifsIrdVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeInstrumentsEtDispositifsIrd> typeInstrumentsEtDispositifsIrds){
        if(ListUtil.isNotEmpty(typeInstrumentsEtDispositifsIrds)){
        typeInstrumentsEtDispositifsIrds.forEach(e->typeInstrumentsEtDispositifsIrdDao.delete(e));
        }
}
@Override
public void update(List<TypeInstrumentsEtDispositifsIrd> typeInstrumentsEtDispositifsIrds){
if(ListUtil.isNotEmpty(typeInstrumentsEtDispositifsIrds)){
typeInstrumentsEtDispositifsIrds.forEach(e->typeInstrumentsEtDispositifsIrdDao.save(e));
}
}



@Override
public List<List<TypeInstrumentsEtDispositifsIrd>>  getToBeSavedAndToBeDeleted(List<TypeInstrumentsEtDispositifsIrd> oldList,List<TypeInstrumentsEtDispositifsIrd> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

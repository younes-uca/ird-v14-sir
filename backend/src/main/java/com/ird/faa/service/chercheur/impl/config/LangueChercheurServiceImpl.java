package com.ird.faa.service.chercheur.impl.config;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.config.Langue;
import com.ird.faa.dao.config.LangueDao;
import com.ird.faa.service.chercheur.facade.config.LangueChercheurService;

import com.ird.faa.ws.rest.provided.vo.LangueVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class LangueChercheurServiceImpl extends AbstractServiceImpl<Langue> implements LangueChercheurService {

@Autowired
private LangueDao langueDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Langue> findAll(){
return langueDao.findAll();
}
    @Override
    public Langue findByCode(String code){
    if( code==null) return null;
    return langueDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return langueDao.deleteByCode(code);
    }
    @Override
    public Langue findByIdOrCode(Langue langue){
    Langue resultat=null;
    if(langue == null || ( langue.getCode()==null && langue.getId()==null))
    return resultat;
    else{
    if(langue.getId() != null){
    resultat= langueDao.findById(langue.getId()).get();
    }else if(StringUtil.isNotEmpty(langue.getCode())) {
    resultat= langueDao.findByCode(langue.getCode());
    }
    return resultat;
    }
    }

@Override
public Langue findById(Long id){
if(id==null) return null;
return langueDao.getOne(id);
}

@Override
public Langue findByIdWithAssociatedList(Long id){
Langue langue  = findById(id);
return langue;
}


@Transactional
public int deleteById(Long id){
if(langueDao.findById(id) == null) return 0;
else{
langueDao.deleteById(id);
return 1;
}
}


@Override
public Langue update(Langue langue){
Langue foundedLangue = findById(langue.getId());
if(foundedLangue==null) return null;
else{
return  langueDao.save(langue);
}
}

@Override
public Langue save (Langue langue){
    Langue foundedLangue = findByCode(langue.getCode());
   if(foundedLangue!=null) return null;



Langue savedLangue = langueDao.save(langue);
return savedLangue;
}

@Override
public List<Langue> save(List<Langue> langues){
List<Langue> list = new ArrayList<Langue>();
for(Langue langue: langues){
list.add(save(langue));
}
return list;
}



@Override
@Transactional
public int delete(Langue langue){
    if(langue.getCode()==null) return -1;

    Langue foundedLangue = findByCode(langue.getCode());
    if(foundedLangue==null) return -1;
langueDao.delete(foundedLangue);
return 1;
}


public List<Langue> findByCriteria(LangueVo langueVo){

String query = "SELECT o FROM Langue o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",langueVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",langueVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",langueVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Langue> langues){
        if(ListUtil.isNotEmpty(langues)){
        langues.forEach(e->langueDao.delete(e));
        }
}
@Override
public void update(List<Langue> langues){
if(ListUtil.isNotEmpty(langues)){
langues.forEach(e->langueDao.save(e));
}
}



@Override
public List<List<Langue>>  getToBeSavedAndToBeDeleted(List<Langue> oldList,List<Langue> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

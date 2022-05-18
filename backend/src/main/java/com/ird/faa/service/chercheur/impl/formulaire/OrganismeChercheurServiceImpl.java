package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.Organisme;
import com.ird.faa.dao.formulaire.OrganismeDao;
import com.ird.faa.service.chercheur.facade.formulaire.OrganismeChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.OrganismeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class OrganismeChercheurServiceImpl extends AbstractServiceImpl<Organisme> implements OrganismeChercheurService {

@Autowired
private OrganismeDao organismeDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Organisme> findAll(){
return organismeDao.findAll();
}
    @Override
    public Organisme findByCode(String code){
    if( code==null) return null;
    return organismeDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return organismeDao.deleteByCode(code);
    }
    @Override
    public Organisme findByIdOrCode(Organisme organisme){
    Organisme resultat=null;
    if(organisme == null || ( organisme.getCode()==null && organisme.getId()==null))
    return resultat;
    else{
    if(organisme.getId() != null){
    resultat= organismeDao.findById(organisme.getId()).get();
    }else if(StringUtil.isNotEmpty(organisme.getCode())) {
    resultat= organismeDao.findByCode(organisme.getCode());
    }
    return resultat;
    }
    }

@Override
public Organisme findById(Long id){
if(id==null) return null;
return organismeDao.getOne(id);
}

@Override
public Organisme findByIdWithAssociatedList(Long id){
Organisme organisme  = findById(id);
return organisme;
}


@Transactional
public int deleteById(Long id){
if(organismeDao.findById(id) == null) return 0;
else{
organismeDao.deleteById(id);
return 1;
}
}


@Override
public Organisme update(Organisme organisme){
Organisme foundedOrganisme = findById(organisme.getId());
if(foundedOrganisme==null) return null;
else{
return  organismeDao.save(organisme);
}
}

@Override
public Organisme save (Organisme organisme){
    Organisme foundedOrganisme = findByCode(organisme.getCode());
   if(foundedOrganisme!=null) return null;



Organisme savedOrganisme = organismeDao.save(organisme);
return savedOrganisme;
}

@Override
public List<Organisme> save(List<Organisme> organismes){
List<Organisme> list = new ArrayList<Organisme>();
for(Organisme organisme: organismes){
list.add(save(organisme));
}
return list;
}



@Override
@Transactional
public int delete(Organisme organisme){
    if(organisme.getCode()==null) return -1;

    Organisme foundedOrganisme = findByCode(organisme.getCode());
    if(foundedOrganisme==null) return -1;
organismeDao.delete(foundedOrganisme);
return 1;
}


public List<Organisme> findByCriteria(OrganismeVo organismeVo){

String query = "SELECT o FROM Organisme o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",organismeVo.getId());
            query += SearchUtil.addConstraint( "o", "intitule","LIKE",organismeVo.getIntitule());
            query += SearchUtil.addConstraint( "o", "code","LIKE",organismeVo.getCode());
            query += SearchUtil.addConstraint( "o", "description","LIKE",organismeVo.getDescription());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Organisme> organismes){
        if(ListUtil.isNotEmpty(organismes)){
        organismes.forEach(e->organismeDao.delete(e));
        }
}
@Override
public void update(List<Organisme> organismes){
if(ListUtil.isNotEmpty(organismes)){
organismes.forEach(e->organismeDao.save(e));
}
}



@Override
public List<List<Organisme>>  getToBeSavedAndToBeDeleted(List<Organisme> oldList,List<Organisme> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

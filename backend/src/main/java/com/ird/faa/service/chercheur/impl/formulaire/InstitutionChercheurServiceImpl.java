package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.Institution;
import com.ird.faa.dao.formulaire.InstitutionDao;
import com.ird.faa.service.chercheur.facade.formulaire.InstitutionChercheurService;

import com.ird.faa.ws.rest.provided.vo.InstitutionVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class InstitutionChercheurServiceImpl extends AbstractServiceImpl<Institution> implements InstitutionChercheurService {

@Autowired
private InstitutionDao institutionDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Institution> findAll(){
return institutionDao.findAll();
}
    @Override
    public Institution findByCode(String code){
    if( code==null) return null;
    return institutionDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return institutionDao.deleteByCode(code);
    }
    @Override
    public Institution findByIdOrCode(Institution institution){
    Institution resultat=null;
    if(institution == null || ( institution.getCode()==null && institution.getId()==null))
    return resultat;
    else{
    if(institution.getId() != null){
    resultat= institutionDao.findById(institution.getId()).get();
    }else if(StringUtil.isNotEmpty(institution.getCode())) {
    resultat= institutionDao.findByCode(institution.getCode());
    }
    return resultat;
    }
    }

@Override
public Institution findById(Long id){
if(id==null) return null;
return institutionDao.getOne(id);
}

@Override
public Institution findByIdWithAssociatedList(Long id){
Institution institution  = findById(id);
return institution;
}


@Transactional
public int deleteById(Long id){
if(institutionDao.findById(id) == null) return 0;
else{
institutionDao.deleteById(id);
return 1;
}
}


@Override
public Institution update(Institution institution){
Institution foundedInstitution = findById(institution.getId());
if(foundedInstitution==null) return null;
else{
return  institutionDao.save(institution);
}
}

@Override
public Institution save (Institution institution){
    Institution foundedInstitution = findByCode(institution.getCode());
   if(foundedInstitution!=null) return null;



Institution savedInstitution = institutionDao.save(institution);
return savedInstitution;
}

@Override
public List<Institution> save(List<Institution> institutions){
List<Institution> list = new ArrayList<Institution>();
for(Institution institution: institutions){
list.add(save(institution));
}
return list;
}



@Override
@Transactional
public int delete(Institution institution){
    if(institution.getCode()==null) return -1;

    Institution foundedInstitution = findByCode(institution.getCode());
    if(foundedInstitution==null) return -1;
institutionDao.delete(foundedInstitution);
return 1;
}


public List<Institution> findByCriteria(InstitutionVo institutionVo){

String query = "SELECT o FROM Institution o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",institutionVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",institutionVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",institutionVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Institution> institutions){
        if(ListUtil.isNotEmpty(institutions)){
        institutions.forEach(e->institutionDao.delete(e));
        }
}
@Override
public void update(List<Institution> institutions){
if(ListUtil.isNotEmpty(institutions)){
institutions.forEach(e->institutionDao.save(e));
}
}



@Override
public List<List<Institution>>  getToBeSavedAndToBeDeleted(List<Institution> oldList,List<Institution> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

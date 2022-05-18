package com.ird.faa.service.admin.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.PubliquePrincipal;
import com.ird.faa.dao.formulaire.PubliquePrincipalDao;
import com.ird.faa.service.admin.facade.formulaire.PubliquePrincipalAdminService;

import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.PubliquePrincipalVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PubliquePrincipalAdminServiceImpl extends AbstractServiceImpl<PubliquePrincipal> implements PubliquePrincipalAdminService {

@Autowired
private PubliquePrincipalDao publiquePrincipalDao;



@Autowired
private EntityManager entityManager;


@Override
public List<PubliquePrincipal> findAll(){
return publiquePrincipalDao.findAll();
}

@Override
public PubliquePrincipal findById(Long id){
if(id==null) return null;
return publiquePrincipalDao.getOne(id);
}

@Override
public PubliquePrincipal findByIdWithAssociatedList(Long id){
PubliquePrincipal publiquePrincipal  = findById(id);
return publiquePrincipal;
}


@Transactional
public int deleteById(Long id){
if(publiquePrincipalDao.findById(id) == null) return 0;
else{
publiquePrincipalDao.deleteById(id);
return 1;
}
}


@Override
public PubliquePrincipal update(PubliquePrincipal publiquePrincipal){
PubliquePrincipal foundedPubliquePrincipal = findById(publiquePrincipal.getId());
if(foundedPubliquePrincipal==null) return null;
else{
return  publiquePrincipalDao.save(publiquePrincipal);
}
}

@Override
public PubliquePrincipal save (PubliquePrincipal publiquePrincipal){



PubliquePrincipal savedPubliquePrincipal = publiquePrincipalDao.save(publiquePrincipal);
return savedPubliquePrincipal;
}

@Override
public List<PubliquePrincipal> save(List<PubliquePrincipal> publiquePrincipals){
List<PubliquePrincipal> list = new ArrayList<PubliquePrincipal>();
for(PubliquePrincipal publiquePrincipal: publiquePrincipals){
list.add(save(publiquePrincipal));
}
return list;
}



@Override
@Transactional
public int delete(PubliquePrincipal publiquePrincipal){
    if(publiquePrincipal.getId()==null) return -1;
    PubliquePrincipal foundedPubliquePrincipal = findById(publiquePrincipal.getId());
    if(foundedPubliquePrincipal==null) return -1;
publiquePrincipalDao.delete(foundedPubliquePrincipal);
return 1;
}


public List<PubliquePrincipal> findByCriteria(PubliquePrincipalVo publiquePrincipalVo){

String query = "SELECT o FROM PubliquePrincipal o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",publiquePrincipalVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",publiquePrincipalVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",publiquePrincipalVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<PubliquePrincipal> publiquePrincipals){
        if(ListUtil.isNotEmpty(publiquePrincipals)){
        publiquePrincipals.forEach(e->publiquePrincipalDao.delete(e));
        }
}
@Override
public void update(List<PubliquePrincipal> publiquePrincipals){
if(ListUtil.isNotEmpty(publiquePrincipals)){
publiquePrincipals.forEach(e->publiquePrincipalDao.save(e));
}
}



@Override
public List<List<PubliquePrincipal>>  getToBeSavedAndToBeDeleted(List<PubliquePrincipal> oldList,List<PubliquePrincipal> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.PubliqueProfessionel;
import com.ird.faa.dao.formulaire.PubliqueProfessionelDao;
import com.ird.faa.service.chercheur.facade.formulaire.PubliqueProfessionelChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.PubliqueProfessionelVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PubliqueProfessionelChercheurServiceImpl extends AbstractServiceImpl<PubliqueProfessionel> implements PubliqueProfessionelChercheurService {

@Autowired
private PubliqueProfessionelDao publiqueProfessionelDao;

@Autowired
private ArchivableService<PubliqueProfessionel> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<PubliqueProfessionel> findAll(){
    String query = "SELECT o FROM PubliqueProfessionel o where 1=1 ";
    query+= " AND o.archive != true";
    return entityManager.createQuery(query).getResultList();
}

@Override
public PubliqueProfessionel findById(Long id){
if(id==null) return null;
return publiqueProfessionelDao.getOne(id);
}

@Override
public PubliqueProfessionel findByIdWithAssociatedList(Long id){
return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(publiqueProfessionelDao.findById(id).isPresent())  {
publiqueProfessionelDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PubliqueProfessionel update(PubliqueProfessionel publiqueProfessionel){
PubliqueProfessionel foundedPubliqueProfessionel = findById(publiqueProfessionel.getId());
if(foundedPubliqueProfessionel==null) return null;
else{
    archivableService.prepare(publiqueProfessionel);
return  publiqueProfessionelDao.save(publiqueProfessionel);
}
}
private void prepareSave(PubliqueProfessionel publiqueProfessionel){
publiqueProfessionel.setDateCreation(new Date());
if(publiqueProfessionel.getArchive() == null)
  publiqueProfessionel.setArchive(false);

}

@Override
public PubliqueProfessionel save (PubliqueProfessionel publiqueProfessionel){
prepareSave(publiqueProfessionel);




return publiqueProfessionelDao.save(publiqueProfessionel);


}

@Override
public List<PubliqueProfessionel> save(List<PubliqueProfessionel> publiqueProfessionels){
List<PubliqueProfessionel> list = new ArrayList<>();
for(PubliqueProfessionel publiqueProfessionel: publiqueProfessionels){
list.add(save(publiqueProfessionel));
}
return list;
}



@Override
@Transactional
public int delete(PubliqueProfessionel publiqueProfessionel){
    if(publiqueProfessionel.getId()==null) return -1;
    PubliqueProfessionel foundedPubliqueProfessionel = findById(publiqueProfessionel.getId());
    if(foundedPubliqueProfessionel==null) return -1;
publiqueProfessionelDao.delete(foundedPubliqueProfessionel);
return 1;
}


public List<PubliqueProfessionel> findByCriteria(PubliqueProfessionelVo publiqueProfessionelVo){

String query = "SELECT o FROM PubliqueProfessionel o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",publiqueProfessionelVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",publiqueProfessionelVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",publiqueProfessionelVo.getCode());
            query += SearchUtil.addConstraint( "o", "archive","=",publiqueProfessionelVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",publiqueProfessionelVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",publiqueProfessionelVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",publiqueProfessionelVo.getDateArchivageMin(),publiqueProfessionelVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",publiqueProfessionelVo.getDateCreationMin(),publiqueProfessionelVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<PubliqueProfessionel> publiqueProfessionels){
        if(ListUtil.isNotEmpty(publiqueProfessionels)){
        publiqueProfessionels.forEach(e->publiqueProfessionelDao.delete(e));
        }
}
@Override
public void update(List<PubliqueProfessionel> publiqueProfessionels){
if(ListUtil.isNotEmpty(publiqueProfessionels)){
publiqueProfessionels.forEach(e->publiqueProfessionelDao.save(e));
}
}



}

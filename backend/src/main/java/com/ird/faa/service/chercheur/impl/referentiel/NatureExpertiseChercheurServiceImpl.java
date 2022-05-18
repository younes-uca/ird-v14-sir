package com.ird.faa.service.chercheur.impl.formulaire;

import com.ird.faa.bean.referentiel.NatureExpertise;
import com.ird.faa.dao.formulaire.NatureExpertiseDao;
import com.ird.faa.security.bean.User;
import com.ird.faa.security.common.SecurityUtil;
import com.ird.faa.service.chercheur.facade.formulaire.NatureExpertiseChercheurService;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.NatureExpertiseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NatureExpertiseChercheurServiceImpl extends AbstractServiceImpl<NatureExpertise> implements NatureExpertiseChercheurService {

@Autowired
private NatureExpertiseDao natureExpertiseDao;

    @Autowired
    private ArchivableService<NatureExpertise> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<NatureExpertise> findAll(){
    List<NatureExpertise> result= new ArrayList();
    result.addAll(findAllNonArchive());
    result.addAll(findAllByOwner());
    return result;
}
    @Override
    public NatureExpertise findByCode(String code){
    if( code==null) return null;
    return natureExpertiseDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return natureExpertiseDao.deleteByCode(code);
    }
    @Override
    public NatureExpertise findByIdOrCode(NatureExpertise natureExpertise){
    NatureExpertise resultat=null;
    if(natureExpertise != null){
    if(StringUtil.isNotEmpty(natureExpertise.getId())){
    resultat= natureExpertiseDao.getOne(natureExpertise.getId());
    }else if(StringUtil.isNotEmpty(natureExpertise.getCode())) {
    resultat= natureExpertiseDao.findByCode(natureExpertise.getCode());
    }
    }
    return resultat;
    }

@Override
public NatureExpertise findById(Long id){
if(id==null) return null;
return natureExpertiseDao.getOne(id);
}

@Override
public NatureExpertise findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(natureExpertiseDao.findById(id).isPresent())  {
natureExpertiseDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public NatureExpertise update(NatureExpertise natureExpertise){
NatureExpertise foundedNatureExpertise = findById(natureExpertise.getId());
if(foundedNatureExpertise==null) return null;
else{
    archivableService.prepare(natureExpertise);
return  natureExpertiseDao.save(natureExpertise);
}
}
    private void prepareSave(NatureExpertise natureExpertise){
        natureExpertise.setDateCreation(new Date());
        if(natureExpertise.getDateArchivage() == null)
        natureExpertise.setDateArchivage(new Date());
                    if(natureExpertise.getArchive() == null)
                natureExpertise.setArchive(false);




    }

@Override
public NatureExpertise save (NatureExpertise natureExpertise){
    prepareSave(natureExpertise);

    NatureExpertise result =null;
    NatureExpertise foundedNatureExpertise = findByCode(natureExpertise.getCode());
    if(foundedNatureExpertise == null){




    NatureExpertise savedNatureExpertise = natureExpertiseDao.save(natureExpertise);

    result = savedNatureExpertise;
    }

    return result;
}

@Override
public List<NatureExpertise> save(List<NatureExpertise> natureExpertises){
List<NatureExpertise> list = new ArrayList<>();
for(NatureExpertise natureExpertise: natureExpertises){
list.add(save(natureExpertise));
}
return list;
}



@Override
@Transactional
public int delete(NatureExpertise natureExpertise){
    if(natureExpertise.getCode()==null) return -1;

    NatureExpertise foundedNatureExpertise = findByCode(natureExpertise.getCode());
    if(foundedNatureExpertise==null) return -1;
natureExpertiseDao.delete(foundedNatureExpertise);
return 1;
}


public List<NatureExpertise> findByCriteria(NatureExpertiseVo natureExpertiseVo){

String query = "SELECT o FROM NatureExpertise o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",natureExpertiseVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",natureExpertiseVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",natureExpertiseVo.getCode());
            query += SearchUtil.addConstraint( "o", "description","LIKE",natureExpertiseVo.getDescription());
            query += SearchUtil.addConstraint( "o", "archive","=",natureExpertiseVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",natureExpertiseVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",natureExpertiseVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",natureExpertiseVo.getDateArchivageMin(),natureExpertiseVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",natureExpertiseVo.getDateCreationMin(),natureExpertiseVo.getDateCreationMax());
    query+= " ORDER BY o.code";
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<NatureExpertise> natureExpertises){
if(ListUtil.isNotEmpty(natureExpertises)){
natureExpertises.forEach(e->natureExpertiseDao.delete(e));
}
}
@Override
public void update(List<NatureExpertise> natureExpertises){
if(ListUtil.isNotEmpty(natureExpertises)){
natureExpertises.forEach(e->natureExpertiseDao.save(e));
}
}




        public List<NatureExpertise> findAllNonArchive(){
        String query = "SELECT o FROM NatureExpertise o  WHERE o.archive != true AND o.visible = true";
            query+= " ORDER BY o.code";
        return entityManager.createQuery(query).getResultList();
        }

        public List<NatureExpertise> findAllByOwner(){
        List<NatureExpertise> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM NatureExpertise o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
            query+= " ORDER BY o.code";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

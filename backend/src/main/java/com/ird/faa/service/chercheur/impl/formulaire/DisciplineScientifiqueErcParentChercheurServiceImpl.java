package com.ird.faa.service.chercheur.impl.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueErcParent;
import com.ird.faa.dao.formulaire.DisciplineScientifiqueErcParentDao;
import com.ird.faa.security.bean.User;
import com.ird.faa.security.common.SecurityUtil;
import com.ird.faa.service.chercheur.facade.formulaire.DisciplineScientifiqueErcParentChercheurService;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DisciplineScientifiqueErcParentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DisciplineScientifiqueErcParentChercheurServiceImpl extends AbstractServiceImpl<DisciplineScientifiqueErcParent> implements DisciplineScientifiqueErcParentChercheurService {

@Autowired
private DisciplineScientifiqueErcParentDao disciplineScientifiqueErcParentDao;

    @Autowired
    private ArchivableService<DisciplineScientifiqueErcParent> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<DisciplineScientifiqueErcParent> findAll(){
    List<DisciplineScientifiqueErcParent> result= new ArrayList();
    result.addAll(findAllNonArchive());
    result.addAll(findAllByOwner());
    return result;
}
    @Override
    public DisciplineScientifiqueErcParent findByCode(String code){
    if( code==null) return null;
    return disciplineScientifiqueErcParentDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return disciplineScientifiqueErcParentDao.deleteByCode(code);
    }
    @Override
    public DisciplineScientifiqueErcParent findByIdOrCode(DisciplineScientifiqueErcParent disciplineScientifiqueErcParent){
    DisciplineScientifiqueErcParent resultat=null;
    if(disciplineScientifiqueErcParent != null){
    if(StringUtil.isNotEmpty(disciplineScientifiqueErcParent.getId())){
    resultat= disciplineScientifiqueErcParentDao.getOne(disciplineScientifiqueErcParent.getId());
    }else if(StringUtil.isNotEmpty(disciplineScientifiqueErcParent.getCode())) {
    resultat= disciplineScientifiqueErcParentDao.findByCode(disciplineScientifiqueErcParent.getCode());
    }
    }
    return resultat;
    }

@Override
public DisciplineScientifiqueErcParent findById(Long id){
if(id==null) return null;
return disciplineScientifiqueErcParentDao.getOne(id);
}

@Override
public DisciplineScientifiqueErcParent findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(disciplineScientifiqueErcParentDao.findById(id).isPresent())  {
disciplineScientifiqueErcParentDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public DisciplineScientifiqueErcParent update(DisciplineScientifiqueErcParent disciplineScientifiqueErcParent){
DisciplineScientifiqueErcParent foundedDisciplineScientifiqueErcParent = findById(disciplineScientifiqueErcParent.getId());
if(foundedDisciplineScientifiqueErcParent==null) return null;
else{
    archivableService.prepare(disciplineScientifiqueErcParent);
return  disciplineScientifiqueErcParentDao.save(disciplineScientifiqueErcParent);
}
}
    private void prepareSave(DisciplineScientifiqueErcParent disciplineScientifiqueErcParent){
        disciplineScientifiqueErcParent.setDateCreation(new Date());
        if(disciplineScientifiqueErcParent.getDateArchivage() == null)
        disciplineScientifiqueErcParent.setDateArchivage(new Date());
                    if(disciplineScientifiqueErcParent.getArchive() == null)
                disciplineScientifiqueErcParent.setArchive(false);




    }

@Override
public DisciplineScientifiqueErcParent save (DisciplineScientifiqueErcParent disciplineScientifiqueErcParent){
    prepareSave(disciplineScientifiqueErcParent);

    DisciplineScientifiqueErcParent result =null;
    DisciplineScientifiqueErcParent foundedDisciplineScientifiqueErcParent = findByCode(disciplineScientifiqueErcParent.getCode());
    if(foundedDisciplineScientifiqueErcParent == null){




    DisciplineScientifiqueErcParent savedDisciplineScientifiqueErcParent = disciplineScientifiqueErcParentDao.save(disciplineScientifiqueErcParent);

    result = savedDisciplineScientifiqueErcParent;
    }

    return result;
}

@Override
public List<DisciplineScientifiqueErcParent> save(List<DisciplineScientifiqueErcParent> disciplineScientifiqueErcParents){
List<DisciplineScientifiqueErcParent> list = new ArrayList<>();
for(DisciplineScientifiqueErcParent disciplineScientifiqueErcParent: disciplineScientifiqueErcParents){
list.add(save(disciplineScientifiqueErcParent));
}
return list;
}



@Override
@Transactional
public int delete(DisciplineScientifiqueErcParent disciplineScientifiqueErcParent){
    if(disciplineScientifiqueErcParent.getCode()==null) return -1;

    DisciplineScientifiqueErcParent foundedDisciplineScientifiqueErcParent = findByCode(disciplineScientifiqueErcParent.getCode());
    if(foundedDisciplineScientifiqueErcParent==null) return -1;
disciplineScientifiqueErcParentDao.delete(foundedDisciplineScientifiqueErcParent);
return 1;
}


public List<DisciplineScientifiqueErcParent> findByCriteria(DisciplineScientifiqueErcParentVo disciplineScientifiqueErcParentVo){

String query = "SELECT o FROM DisciplineScientifiqueErcParent o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",disciplineScientifiqueErcParentVo.getId());
            query += SearchUtil.addConstraint( "o", "libelleFr","LIKE",disciplineScientifiqueErcParentVo.getLibelleFr());
            query += SearchUtil.addConstraint( "o", "libelleEng","LIKE",disciplineScientifiqueErcParentVo.getLibelleEng());
            query += SearchUtil.addConstraint( "o", "code","LIKE",disciplineScientifiqueErcParentVo.getCode());
            query += SearchUtil.addConstraint( "o", "niveau","=",disciplineScientifiqueErcParentVo.getNiveau());
            query += SearchUtil.addConstraint( "o", "archive","=",disciplineScientifiqueErcParentVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",disciplineScientifiqueErcParentVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",disciplineScientifiqueErcParentVo.getDateCreation());
            query += SearchUtil.addConstraintMinMax("o","niveau",disciplineScientifiqueErcParentVo.getNiveauMin(),disciplineScientifiqueErcParentVo.getNiveauMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",disciplineScientifiqueErcParentVo.getDateArchivageMin(),disciplineScientifiqueErcParentVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",disciplineScientifiqueErcParentVo.getDateCreationMin(),disciplineScientifiqueErcParentVo.getDateCreationMax());
    query+= " ORDER BY o.code";
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<DisciplineScientifiqueErcParent> disciplineScientifiqueErcParents){
if(ListUtil.isNotEmpty(disciplineScientifiqueErcParents)){
disciplineScientifiqueErcParents.forEach(e->disciplineScientifiqueErcParentDao.delete(e));
}
}
@Override
public void update(List<DisciplineScientifiqueErcParent> disciplineScientifiqueErcParents){
if(ListUtil.isNotEmpty(disciplineScientifiqueErcParents)){
disciplineScientifiqueErcParents.forEach(e->disciplineScientifiqueErcParentDao.save(e));
}
}




        public List<DisciplineScientifiqueErcParent> findAllNonArchive(){
        String query = "SELECT o FROM DisciplineScientifiqueErcParent o  WHERE o.archive != true AND o.visible = true";
            query+= " ORDER BY o.code";
        return entityManager.createQuery(query).getResultList();
        }

        public List<DisciplineScientifiqueErcParent> findAllByOwner(){
        List<DisciplineScientifiqueErcParent> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM DisciplineScientifiqueErcParent o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
            query+= " ORDER BY o.code";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.ResponsabiliteEncadrementDoctorant;
import com.ird.faa.dao.formulaire.ResponsabiliteEncadrementDoctorantDao;
import com.ird.faa.service.chercheur.facade.formulaire.ResponsabiliteEncadrementDoctorantChercheurService;

import com.ird.faa.ws.rest.provided.vo.ResponsabiliteEncadrementDoctorantVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ResponsabiliteEncadrementDoctorantChercheurServiceImpl extends AbstractServiceImpl<ResponsabiliteEncadrementDoctorant> implements ResponsabiliteEncadrementDoctorantChercheurService {

@Autowired
private ResponsabiliteEncadrementDoctorantDao responsabiliteEncadrementDoctorantDao;

@Autowired
private ArchivableService<ResponsabiliteEncadrementDoctorant> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<ResponsabiliteEncadrementDoctorant> findAll(){
return responsabiliteEncadrementDoctorantDao.findAll();
}
    @Override
    public ResponsabiliteEncadrementDoctorant findByCode(String code){
    if( code==null) return null;
    return responsabiliteEncadrementDoctorantDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return responsabiliteEncadrementDoctorantDao.deleteByCode(code);
    }
    @Override
    public ResponsabiliteEncadrementDoctorant findByIdOrCode(ResponsabiliteEncadrementDoctorant responsabiliteEncadrementDoctorant){
    ResponsabiliteEncadrementDoctorant resultat=null;
    if(responsabiliteEncadrementDoctorant == null || ( responsabiliteEncadrementDoctorant.getCode()==null && responsabiliteEncadrementDoctorant.getId()==null))
    return resultat;
    else{
    if(responsabiliteEncadrementDoctorant.getId() != null){
    resultat= responsabiliteEncadrementDoctorantDao.findById(responsabiliteEncadrementDoctorant.getId()).get();
    }else if(StringUtil.isNotEmpty(responsabiliteEncadrementDoctorant.getCode())) {
    resultat= responsabiliteEncadrementDoctorantDao.findByCode(responsabiliteEncadrementDoctorant.getCode());
    }
    return resultat;
    }
    }

@Override
public ResponsabiliteEncadrementDoctorant findById(Long id){
if(id==null) return null;
return responsabiliteEncadrementDoctorantDao.getOne(id);
}

@Override
public ResponsabiliteEncadrementDoctorant findByIdWithAssociatedList(Long id){
ResponsabiliteEncadrementDoctorant responsabiliteEncadrementDoctorant  = findById(id);
return responsabiliteEncadrementDoctorant;
}


@Transactional
public int deleteById(Long id){
if(responsabiliteEncadrementDoctorantDao.findById(id) == null) return 0;
else{
responsabiliteEncadrementDoctorantDao.deleteById(id);
return 1;
}
}


@Override
public ResponsabiliteEncadrementDoctorant update(ResponsabiliteEncadrementDoctorant responsabiliteEncadrementDoctorant){
ResponsabiliteEncadrementDoctorant foundedResponsabiliteEncadrementDoctorant = findById(responsabiliteEncadrementDoctorant.getId());
if(foundedResponsabiliteEncadrementDoctorant==null) return null;
else{
    archivableService.prepare(responsabiliteEncadrementDoctorant);
return  responsabiliteEncadrementDoctorantDao.save(responsabiliteEncadrementDoctorant);
}
}

@Override
public ResponsabiliteEncadrementDoctorant save (ResponsabiliteEncadrementDoctorant responsabiliteEncadrementDoctorant){
    ResponsabiliteEncadrementDoctorant foundedResponsabiliteEncadrementDoctorant = findByCode(responsabiliteEncadrementDoctorant.getCode());
   if(foundedResponsabiliteEncadrementDoctorant!=null) return null;



ResponsabiliteEncadrementDoctorant savedResponsabiliteEncadrementDoctorant = responsabiliteEncadrementDoctorantDao.save(responsabiliteEncadrementDoctorant);
return savedResponsabiliteEncadrementDoctorant;
}

@Override
public List<ResponsabiliteEncadrementDoctorant> save(List<ResponsabiliteEncadrementDoctorant> responsabiliteEncadrementDoctorants){
List<ResponsabiliteEncadrementDoctorant> list = new ArrayList<ResponsabiliteEncadrementDoctorant>();
for(ResponsabiliteEncadrementDoctorant responsabiliteEncadrementDoctorant: responsabiliteEncadrementDoctorants){
list.add(save(responsabiliteEncadrementDoctorant));
}
return list;
}



@Override
@Transactional
public int delete(ResponsabiliteEncadrementDoctorant responsabiliteEncadrementDoctorant){
    if(responsabiliteEncadrementDoctorant.getCode()==null) return -1;

    ResponsabiliteEncadrementDoctorant foundedResponsabiliteEncadrementDoctorant = findByCode(responsabiliteEncadrementDoctorant.getCode());
    if(foundedResponsabiliteEncadrementDoctorant==null) return -1;
responsabiliteEncadrementDoctorantDao.delete(foundedResponsabiliteEncadrementDoctorant);
return 1;
}


public List<ResponsabiliteEncadrementDoctorant> findByCriteria(ResponsabiliteEncadrementDoctorantVo responsabiliteEncadrementDoctorantVo){

String query = "SELECT o FROM ResponsabiliteEncadrementDoctorant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",responsabiliteEncadrementDoctorantVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",responsabiliteEncadrementDoctorantVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",responsabiliteEncadrementDoctorantVo.getCode());
            query += SearchUtil.addConstraint( "o", "archive","=",responsabiliteEncadrementDoctorantVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",responsabiliteEncadrementDoctorantVo.getDateArchivage());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",responsabiliteEncadrementDoctorantVo.getDateArchivageMin(),responsabiliteEncadrementDoctorantVo.getDateArchivageMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<ResponsabiliteEncadrementDoctorant> responsabiliteEncadrementDoctorants){
        if(ListUtil.isNotEmpty(responsabiliteEncadrementDoctorants)){
        responsabiliteEncadrementDoctorants.forEach(e->responsabiliteEncadrementDoctorantDao.delete(e));
        }
}
@Override
public void update(List<ResponsabiliteEncadrementDoctorant> responsabiliteEncadrementDoctorants){
if(ListUtil.isNotEmpty(responsabiliteEncadrementDoctorants)){
responsabiliteEncadrementDoctorants.forEach(e->responsabiliteEncadrementDoctorantDao.save(e));
}
}



@Override
public List<List<ResponsabiliteEncadrementDoctorant>>  getToBeSavedAndToBeDeleted(List<ResponsabiliteEncadrementDoctorant> oldList,List<ResponsabiliteEncadrementDoctorant> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.ObjetFormationGenerique;
import com.ird.faa.dao.formulaire.ObjetFormationGeneriqueDao;
import com.ird.faa.service.chercheur.facade.formulaire.ObjetFormationGeneriqueChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ObjetFormationGeneriqueVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ObjetFormationGeneriqueChercheurServiceImpl extends AbstractServiceImpl<ObjetFormationGenerique> implements ObjetFormationGeneriqueChercheurService {

@Autowired
private ObjetFormationGeneriqueDao objetFormationGeneriqueDao;

@Autowired
private ArchivableService<ObjetFormationGenerique> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<ObjetFormationGenerique> findAll(){
    String query = "SELECT o FROM ObjetFormationGenerique o where 1=1 ";
    query+= " AND o.archive != true";
    return entityManager.createQuery(query).getResultList();
}
    @Override
    public ObjetFormationGenerique findByCode(String code){
    if( code==null) return null;
    return objetFormationGeneriqueDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return objetFormationGeneriqueDao.deleteByCode(code);
    }
    @Override
    public ObjetFormationGenerique findByIdOrCode(ObjetFormationGenerique objetFormationGenerique){
        ObjetFormationGenerique resultat=null;
        if(objetFormationGenerique != null){
            if(StringUtil.isNotEmpty(objetFormationGenerique.getId())){
            resultat= objetFormationGeneriqueDao.getOne(objetFormationGenerique.getId());
            }else if(StringUtil.isNotEmpty(objetFormationGenerique.getCode())) {
            resultat= objetFormationGeneriqueDao.findByCode(objetFormationGenerique.getCode());
            }
        }
    return resultat;
    }

@Override
public ObjetFormationGenerique findById(Long id){
if(id==null) return null;
return objetFormationGeneriqueDao.getOne(id);
}

@Override
public ObjetFormationGenerique findByIdWithAssociatedList(Long id){
return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(objetFormationGeneriqueDao.findById(id).isPresent())  {
objetFormationGeneriqueDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public ObjetFormationGenerique update(ObjetFormationGenerique objetFormationGenerique){
ObjetFormationGenerique foundedObjetFormationGenerique = findById(objetFormationGenerique.getId());
if(foundedObjetFormationGenerique==null) return null;
else{
    archivableService.prepare(objetFormationGenerique);
return  objetFormationGeneriqueDao.save(objetFormationGenerique);
}
}
private void prepareSave(ObjetFormationGenerique objetFormationGenerique){
objetFormationGenerique.setDateCreation(new Date());
if(objetFormationGenerique.getArchive() == null)
  objetFormationGenerique.setArchive(false);

}

@Override
public ObjetFormationGenerique save (ObjetFormationGenerique objetFormationGenerique){
prepareSave(objetFormationGenerique);

ObjetFormationGenerique result =null;
    ObjetFormationGenerique foundedObjetFormationGenerique = findByCode(objetFormationGenerique.getCode());
   if(foundedObjetFormationGenerique == null){



ObjetFormationGenerique savedObjetFormationGenerique = objetFormationGeneriqueDao.save(objetFormationGenerique);

result = savedObjetFormationGenerique;
   }

return result;
}

@Override
public List<ObjetFormationGenerique> save(List<ObjetFormationGenerique> objetFormationGeneriques){
List<ObjetFormationGenerique> list = new ArrayList<>();
for(ObjetFormationGenerique objetFormationGenerique: objetFormationGeneriques){
list.add(save(objetFormationGenerique));
}
return list;
}



@Override
@Transactional
public int delete(ObjetFormationGenerique objetFormationGenerique){
    if(objetFormationGenerique.getCode()==null) return -1;

    ObjetFormationGenerique foundedObjetFormationGenerique = findByCode(objetFormationGenerique.getCode());
    if(foundedObjetFormationGenerique==null) return -1;
objetFormationGeneriqueDao.delete(foundedObjetFormationGenerique);
return 1;
}


public List<ObjetFormationGenerique> findByCriteria(ObjetFormationGeneriqueVo objetFormationGeneriqueVo){

String query = "SELECT o FROM ObjetFormationGenerique o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",objetFormationGeneriqueVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",objetFormationGeneriqueVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",objetFormationGeneriqueVo.getCode());
            query += SearchUtil.addConstraint( "o", "archive","=",objetFormationGeneriqueVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",objetFormationGeneriqueVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",objetFormationGeneriqueVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",objetFormationGeneriqueVo.getDateArchivageMin(),objetFormationGeneriqueVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",objetFormationGeneriqueVo.getDateCreationMin(),objetFormationGeneriqueVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<ObjetFormationGenerique> objetFormationGeneriques){
        if(ListUtil.isNotEmpty(objetFormationGeneriques)){
        objetFormationGeneriques.forEach(e->objetFormationGeneriqueDao.delete(e));
        }
}
@Override
public void update(List<ObjetFormationGenerique> objetFormationGeneriques){
if(ListUtil.isNotEmpty(objetFormationGeneriques)){
objetFormationGeneriques.forEach(e->objetFormationGeneriqueDao.save(e));
}
}



}

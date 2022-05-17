package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.DisciplineScientifique;
import com.ird.faa.dao.formulaire.DisciplineScientifiqueDao;
import com.ird.faa.service.chercheur.facade.formulaire.DisciplineScientifiqueChercheurService;

import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class DisciplineScientifiqueChercheurServiceImpl extends AbstractServiceImpl<DisciplineScientifique> implements DisciplineScientifiqueChercheurService {

@Autowired
private DisciplineScientifiqueDao disciplineScientifiqueDao;



@Autowired
private EntityManager entityManager;


@Override
public List<DisciplineScientifique> findAll(){
return disciplineScientifiqueDao.findAll();
}
    @Override
    public DisciplineScientifique findByCode(String code){
    if( code==null) return null;
    return disciplineScientifiqueDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return disciplineScientifiqueDao.deleteByCode(code);
    }
    @Override
    public DisciplineScientifique findByIdOrCode(DisciplineScientifique disciplineScientifique){
    DisciplineScientifique resultat=null;
    if(disciplineScientifique == null || ( disciplineScientifique.getCode()==null && disciplineScientifique.getId()==null))
    return resultat;
    else{
    if(disciplineScientifique.getId() != null){
    resultat= disciplineScientifiqueDao.findById(disciplineScientifique.getId()).get();
    }else if(StringUtil.isNotEmpty(disciplineScientifique.getCode())) {
    resultat= disciplineScientifiqueDao.findByCode(disciplineScientifique.getCode());
    }
    return resultat;
    }
    }

@Override
public DisciplineScientifique findById(Long id){
if(id==null) return null;
return disciplineScientifiqueDao.getOne(id);
}

@Override
public DisciplineScientifique findByIdWithAssociatedList(Long id){
DisciplineScientifique disciplineScientifique  = findById(id);
return disciplineScientifique;
}


@Transactional
public int deleteById(Long id){
if(disciplineScientifiqueDao.findById(id) == null) return 0;
else{
disciplineScientifiqueDao.deleteById(id);
return 1;
}
}


@Override
public DisciplineScientifique update(DisciplineScientifique disciplineScientifique){
DisciplineScientifique foundedDisciplineScientifique = findById(disciplineScientifique.getId());
if(foundedDisciplineScientifique==null) return null;
else{
return  disciplineScientifiqueDao.save(disciplineScientifique);
}
}

@Override
public DisciplineScientifique save (DisciplineScientifique disciplineScientifique){
    DisciplineScientifique foundedDisciplineScientifique = findByCode(disciplineScientifique.getCode());
   if(foundedDisciplineScientifique!=null) return null;



DisciplineScientifique savedDisciplineScientifique = disciplineScientifiqueDao.save(disciplineScientifique);
return savedDisciplineScientifique;
}

@Override
public List<DisciplineScientifique> save(List<DisciplineScientifique> disciplineScientifiques){
List<DisciplineScientifique> list = new ArrayList<DisciplineScientifique>();
for(DisciplineScientifique disciplineScientifique: disciplineScientifiques){
list.add(save(disciplineScientifique));
}
return list;
}



@Override
@Transactional
public int delete(DisciplineScientifique disciplineScientifique){
    if(disciplineScientifique.getCode()==null) return -1;

    DisciplineScientifique foundedDisciplineScientifique = findByCode(disciplineScientifique.getCode());
    if(foundedDisciplineScientifique==null) return -1;
disciplineScientifiqueDao.delete(foundedDisciplineScientifique);
return 1;
}


public List<DisciplineScientifique> findByCriteria(DisciplineScientifiqueVo disciplineScientifiqueVo){

String query = "SELECT o FROM DisciplineScientifique o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",disciplineScientifiqueVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",disciplineScientifiqueVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",disciplineScientifiqueVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<DisciplineScientifique> disciplineScientifiques){
        if(ListUtil.isNotEmpty(disciplineScientifiques)){
        disciplineScientifiques.forEach(e->disciplineScientifiqueDao.delete(e));
        }
}
@Override
public void update(List<DisciplineScientifique> disciplineScientifiques){
if(ListUtil.isNotEmpty(disciplineScientifiques)){
disciplineScientifiques.forEach(e->disciplineScientifiqueDao.save(e));
}
}



@Override
public List<List<DisciplineScientifique>>  getToBeSavedAndToBeDeleted(List<DisciplineScientifique> oldList,List<DisciplineScientifique> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.ResponsabiliteEncadrementEtudiant;
import com.ird.faa.dao.formulaire.ResponsabiliteEncadrementEtudiantDao;
import com.ird.faa.service.chercheur.facade.formulaire.ResponsabiliteEncadrementEtudiantChercheurService;

import com.ird.faa.ws.rest.provided.vo.ResponsabiliteEncadrementEtudiantVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ResponsabiliteEncadrementEtudiantChercheurServiceImpl extends AbstractServiceImpl<ResponsabiliteEncadrementEtudiant> implements ResponsabiliteEncadrementEtudiantChercheurService {

@Autowired
private ResponsabiliteEncadrementEtudiantDao responsabiliteEncadrementEtudiantDao;



@Autowired
private EntityManager entityManager;


@Override
public List<ResponsabiliteEncadrementEtudiant> findAll(){
return responsabiliteEncadrementEtudiantDao.findAll();
}
    @Override
    public ResponsabiliteEncadrementEtudiant findByCode(String code){
    if( code==null) return null;
    return responsabiliteEncadrementEtudiantDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return responsabiliteEncadrementEtudiantDao.deleteByCode(code);
    }
    @Override
    public ResponsabiliteEncadrementEtudiant findByIdOrCode(ResponsabiliteEncadrementEtudiant responsabiliteEncadrementEtudiant){
    ResponsabiliteEncadrementEtudiant resultat=null;
    if(responsabiliteEncadrementEtudiant == null || ( responsabiliteEncadrementEtudiant.getCode()==null && responsabiliteEncadrementEtudiant.getId()==null))
    return resultat;
    else{
    if(responsabiliteEncadrementEtudiant.getId() != null){
    resultat= responsabiliteEncadrementEtudiantDao.findById(responsabiliteEncadrementEtudiant.getId()).get();
    }else if(StringUtil.isNotEmpty(responsabiliteEncadrementEtudiant.getCode())) {
    resultat= responsabiliteEncadrementEtudiantDao.findByCode(responsabiliteEncadrementEtudiant.getCode());
    }
    return resultat;
    }
    }

@Override
public ResponsabiliteEncadrementEtudiant findById(Long id){
if(id==null) return null;
return responsabiliteEncadrementEtudiantDao.getOne(id);
}

@Override
public ResponsabiliteEncadrementEtudiant findByIdWithAssociatedList(Long id){
ResponsabiliteEncadrementEtudiant responsabiliteEncadrementEtudiant  = findById(id);
return responsabiliteEncadrementEtudiant;
}


@Transactional
public int deleteById(Long id){
if(responsabiliteEncadrementEtudiantDao.findById(id) == null) return 0;
else{
responsabiliteEncadrementEtudiantDao.deleteById(id);
return 1;
}
}


@Override
public ResponsabiliteEncadrementEtudiant update(ResponsabiliteEncadrementEtudiant responsabiliteEncadrementEtudiant){
ResponsabiliteEncadrementEtudiant foundedResponsabiliteEncadrementEtudiant = findById(responsabiliteEncadrementEtudiant.getId());
if(foundedResponsabiliteEncadrementEtudiant==null) return null;
else{
return  responsabiliteEncadrementEtudiantDao.save(responsabiliteEncadrementEtudiant);
}
}

@Override
public ResponsabiliteEncadrementEtudiant save (ResponsabiliteEncadrementEtudiant responsabiliteEncadrementEtudiant){
    ResponsabiliteEncadrementEtudiant foundedResponsabiliteEncadrementEtudiant = findByCode(responsabiliteEncadrementEtudiant.getCode());
   if(foundedResponsabiliteEncadrementEtudiant!=null) return null;



ResponsabiliteEncadrementEtudiant savedResponsabiliteEncadrementEtudiant = responsabiliteEncadrementEtudiantDao.save(responsabiliteEncadrementEtudiant);
return savedResponsabiliteEncadrementEtudiant;
}

@Override
public List<ResponsabiliteEncadrementEtudiant> save(List<ResponsabiliteEncadrementEtudiant> responsabiliteEncadrementEtudiants){
List<ResponsabiliteEncadrementEtudiant> list = new ArrayList<ResponsabiliteEncadrementEtudiant>();
for(ResponsabiliteEncadrementEtudiant responsabiliteEncadrementEtudiant: responsabiliteEncadrementEtudiants){
list.add(save(responsabiliteEncadrementEtudiant));
}
return list;
}



@Override
@Transactional
public int delete(ResponsabiliteEncadrementEtudiant responsabiliteEncadrementEtudiant){
    if(responsabiliteEncadrementEtudiant.getCode()==null) return -1;

    ResponsabiliteEncadrementEtudiant foundedResponsabiliteEncadrementEtudiant = findByCode(responsabiliteEncadrementEtudiant.getCode());
    if(foundedResponsabiliteEncadrementEtudiant==null) return -1;
responsabiliteEncadrementEtudiantDao.delete(foundedResponsabiliteEncadrementEtudiant);
return 1;
}


public List<ResponsabiliteEncadrementEtudiant> findByCriteria(ResponsabiliteEncadrementEtudiantVo responsabiliteEncadrementEtudiantVo){

String query = "SELECT o FROM ResponsabiliteEncadrementEtudiant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",responsabiliteEncadrementEtudiantVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",responsabiliteEncadrementEtudiantVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",responsabiliteEncadrementEtudiantVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<ResponsabiliteEncadrementEtudiant> responsabiliteEncadrementEtudiants){
        if(ListUtil.isNotEmpty(responsabiliteEncadrementEtudiants)){
        responsabiliteEncadrementEtudiants.forEach(e->responsabiliteEncadrementEtudiantDao.delete(e));
        }
}
@Override
public void update(List<ResponsabiliteEncadrementEtudiant> responsabiliteEncadrementEtudiants){
if(ListUtil.isNotEmpty(responsabiliteEncadrementEtudiants)){
responsabiliteEncadrementEtudiants.forEach(e->responsabiliteEncadrementEtudiantDao.save(e));
}
}



@Override
public List<List<ResponsabiliteEncadrementEtudiant>>  getToBeSavedAndToBeDeleted(List<ResponsabiliteEncadrementEtudiant> oldList,List<ResponsabiliteEncadrementEtudiant> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

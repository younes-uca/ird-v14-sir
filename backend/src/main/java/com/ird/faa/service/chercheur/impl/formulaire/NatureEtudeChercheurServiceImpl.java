package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.referentiel.NatureEtude;
import com.ird.faa.dao.formulaire.NatureEtudeDao;
import com.ird.faa.service.chercheur.facade.formulaire.NatureEtudeChercheurService;

import com.ird.faa.ws.rest.provided.vo.NatureEtudeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class NatureEtudeChercheurServiceImpl extends AbstractServiceImpl<NatureEtude> implements NatureEtudeChercheurService {

@Autowired
private NatureEtudeDao natureEtudeDao;



@Autowired
private EntityManager entityManager;


@Override
public List<NatureEtude> findAll(){
return natureEtudeDao.findAll();
}
    @Override
    public NatureEtude findByCode(String code){
    if( code==null) return null;
    return natureEtudeDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return natureEtudeDao.deleteByCode(code);
    }
    @Override
    public NatureEtude findByIdOrCode(NatureEtude natureEtude){
    NatureEtude resultat=null;
    if(natureEtude == null || ( natureEtude.getCode()==null && natureEtude.getId()==null))
    return resultat;
    else{
    if(natureEtude.getId() != null){
    resultat= natureEtudeDao.findById(natureEtude.getId()).get();
    }else if(StringUtil.isNotEmpty(natureEtude.getCode())) {
    resultat= natureEtudeDao.findByCode(natureEtude.getCode());
    }
    return resultat;
    }
    }

@Override
public NatureEtude findById(Long id){
if(id==null) return null;
return natureEtudeDao.getOne(id);
}

@Override
public NatureEtude findByIdWithAssociatedList(Long id){
NatureEtude natureEtude  = findById(id);
return natureEtude;
}


@Transactional
public int deleteById(Long id){
if(natureEtudeDao.findById(id) == null) return 0;
else{
natureEtudeDao.deleteById(id);
return 1;
}
}


@Override
public NatureEtude update(NatureEtude natureEtude){
NatureEtude foundedNatureEtude = findById(natureEtude.getId());
if(foundedNatureEtude==null) return null;
else{
return  natureEtudeDao.save(natureEtude);
}
}

@Override
public NatureEtude save (NatureEtude natureEtude){
    NatureEtude foundedNatureEtude = findByCode(natureEtude.getCode());
   if(foundedNatureEtude!=null) return null;



NatureEtude savedNatureEtude = natureEtudeDao.save(natureEtude);
return savedNatureEtude;
}

@Override
public List<NatureEtude> save(List<NatureEtude> natureEtudes){
List<NatureEtude> list = new ArrayList<NatureEtude>();
for(NatureEtude natureEtude: natureEtudes){
list.add(save(natureEtude));
}
return list;
}



@Override
@Transactional
public int delete(NatureEtude natureEtude){
    if(natureEtude.getCode()==null) return -1;

    NatureEtude foundedNatureEtude = findByCode(natureEtude.getCode());
    if(foundedNatureEtude==null) return -1;
natureEtudeDao.delete(foundedNatureEtude);
return 1;
}


public List<NatureEtude> findByCriteria(NatureEtudeVo natureEtudeVo){

String query = "SELECT o FROM NatureEtude o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",natureEtudeVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",natureEtudeVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",natureEtudeVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<NatureEtude> natureEtudes){
        if(ListUtil.isNotEmpty(natureEtudes)){
        natureEtudes.forEach(e->natureEtudeDao.delete(e));
        }
}
@Override
public void update(List<NatureEtude> natureEtudes){
if(ListUtil.isNotEmpty(natureEtudes)){
natureEtudes.forEach(e->natureEtudeDao.save(e));
}
}



@Override
public List<List<NatureEtude>>  getToBeSavedAndToBeDeleted(List<NatureEtude> oldList,List<NatureEtude> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

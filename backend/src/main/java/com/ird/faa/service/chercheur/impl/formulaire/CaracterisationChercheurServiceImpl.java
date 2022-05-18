package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.Caracterisation;
import com.ird.faa.dao.formulaire.CaracterisationDao;
import com.ird.faa.service.chercheur.facade.formulaire.CaracterisationChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.CaracterisationVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CaracterisationChercheurServiceImpl extends AbstractServiceImpl<Caracterisation> implements CaracterisationChercheurService {

@Autowired
private CaracterisationDao caracterisationDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Caracterisation> findAll(){
return caracterisationDao.findAll();
}
    @Override
    public Caracterisation findByCode(String code){
    if( code==null) return null;
    return caracterisationDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return caracterisationDao.deleteByCode(code);
    }
    @Override
    public Caracterisation findByIdOrCode(Caracterisation caracterisation){
    Caracterisation resultat=null;
    if(caracterisation == null || ( caracterisation.getCode()==null && caracterisation.getId()==null))
    return resultat;
    else{
    if(caracterisation.getId() != null){
    resultat= caracterisationDao.findById(caracterisation.getId()).get();
    }else if(StringUtil.isNotEmpty(caracterisation.getCode())) {
    resultat= caracterisationDao.findByCode(caracterisation.getCode());
    }
    return resultat;
    }
    }

@Override
public Caracterisation findById(Long id){
if(id==null) return null;
return caracterisationDao.getOne(id);
}

@Override
public Caracterisation findByIdWithAssociatedList(Long id){
Caracterisation caracterisation  = findById(id);
return caracterisation;
}


@Transactional
public int deleteById(Long id){
if(caracterisationDao.findById(id) == null) return 0;
else{
caracterisationDao.deleteById(id);
return 1;
}
}


@Override
public Caracterisation update(Caracterisation caracterisation){
Caracterisation foundedCaracterisation = findById(caracterisation.getId());
if(foundedCaracterisation==null) return null;
else{
return  caracterisationDao.save(caracterisation);
}
}

@Override
public Caracterisation save (Caracterisation caracterisation){
    Caracterisation foundedCaracterisation = findByCode(caracterisation.getCode());
   if(foundedCaracterisation!=null) return null;



Caracterisation savedCaracterisation = caracterisationDao.save(caracterisation);
return savedCaracterisation;
}

@Override
public List<Caracterisation> save(List<Caracterisation> caracterisations){
List<Caracterisation> list = new ArrayList<Caracterisation>();
for(Caracterisation caracterisation: caracterisations){
list.add(save(caracterisation));
}
return list;
}



@Override
@Transactional
public int delete(Caracterisation caracterisation){
    if(caracterisation.getCode()==null) return -1;

    Caracterisation foundedCaracterisation = findByCode(caracterisation.getCode());
    if(foundedCaracterisation==null) return -1;
caracterisationDao.delete(foundedCaracterisation);
return 1;
}


public List<Caracterisation> findByCriteria(CaracterisationVo caracterisationVo){

String query = "SELECT o FROM Caracterisation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",caracterisationVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",caracterisationVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",caracterisationVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Caracterisation> caracterisations){
        if(ListUtil.isNotEmpty(caracterisations)){
        caracterisations.forEach(e->caracterisationDao.delete(e));
        }
}
@Override
public void update(List<Caracterisation> caracterisations){
if(ListUtil.isNotEmpty(caracterisations)){
caracterisations.forEach(e->caracterisationDao.save(e));
}
}



@Override
public List<List<Caracterisation>>  getToBeSavedAndToBeDeleted(List<Caracterisation> oldList,List<Caracterisation> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

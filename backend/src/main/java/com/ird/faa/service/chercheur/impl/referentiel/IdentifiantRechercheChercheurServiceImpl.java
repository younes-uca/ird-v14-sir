package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.IdentifiantRecherche;
import com.ird.faa.dao.formulaire.IdentifiantRechercheDao;
import com.ird.faa.service.chercheur.facade.formulaire.IdentifiantRechercheChercheurService;

import com.ird.faa.ws.rest.provided.vo.IdentifiantRechercheVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class IdentifiantRechercheChercheurServiceImpl extends AbstractServiceImpl<IdentifiantRecherche> implements IdentifiantRechercheChercheurService {

@Autowired
private IdentifiantRechercheDao identifiantRechercheDao;



@Autowired
private EntityManager entityManager;


@Override
public List<IdentifiantRecherche> findAll(){
return identifiantRechercheDao.findAll();
}
    @Override
    public IdentifiantRecherche findByCode(String code){
    if( code==null) return null;
    return identifiantRechercheDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return identifiantRechercheDao.deleteByCode(code);
    }
    @Override
    public IdentifiantRecherche findByIdOrCode(IdentifiantRecherche identifiantRecherche){
    IdentifiantRecherche resultat=null;
    if(identifiantRecherche == null || ( identifiantRecherche.getCode()==null && identifiantRecherche.getId()==null))
    return resultat;
    else{
    if(identifiantRecherche.getId() != null){
    resultat= identifiantRechercheDao.findById(identifiantRecherche.getId()).get();
    }else if(StringUtil.isNotEmpty(identifiantRecherche.getCode())) {
    resultat= identifiantRechercheDao.findByCode(identifiantRecherche.getCode());
    }
    return resultat;
    }
    }

@Override
public IdentifiantRecherche findById(Long id){
if(id==null) return null;
return identifiantRechercheDao.getOne(id);
}

@Override
public IdentifiantRecherche findByIdWithAssociatedList(Long id){
IdentifiantRecherche identifiantRecherche  = findById(id);
return identifiantRecherche;
}


@Transactional
public int deleteById(Long id){
if(identifiantRechercheDao.findById(id) == null) return 0;
else{
identifiantRechercheDao.deleteById(id);
return 1;
}
}


@Override
public IdentifiantRecherche update(IdentifiantRecherche identifiantRecherche){
IdentifiantRecherche foundedIdentifiantRecherche = findById(identifiantRecherche.getId());
if(foundedIdentifiantRecherche==null) return null;
else{
return  identifiantRechercheDao.save(identifiantRecherche);
}
}

@Override
public IdentifiantRecherche save (IdentifiantRecherche identifiantRecherche){
    IdentifiantRecherche foundedIdentifiantRecherche = findByCode(identifiantRecherche.getCode());
   if(foundedIdentifiantRecherche!=null) return null;



IdentifiantRecherche savedIdentifiantRecherche = identifiantRechercheDao.save(identifiantRecherche);
return savedIdentifiantRecherche;
}

@Override
public List<IdentifiantRecherche> save(List<IdentifiantRecherche> identifiantRecherches){
List<IdentifiantRecherche> list = new ArrayList<IdentifiantRecherche>();
for(IdentifiantRecherche identifiantRecherche: identifiantRecherches){
list.add(save(identifiantRecherche));
}
return list;
}



@Override
@Transactional
public int delete(IdentifiantRecherche identifiantRecherche){
    if(identifiantRecherche.getCode()==null) return -1;

    IdentifiantRecherche foundedIdentifiantRecherche = findByCode(identifiantRecherche.getCode());
    if(foundedIdentifiantRecherche==null) return -1;
identifiantRechercheDao.delete(foundedIdentifiantRecherche);
return 1;
}


public List<IdentifiantRecherche> findByCriteria(IdentifiantRechercheVo identifiantRechercheVo){

String query = "SELECT o FROM IdentifiantRecherche o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",identifiantRechercheVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",identifiantRechercheVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",identifiantRechercheVo.getCode());
            query += SearchUtil.addConstraint( "o", "description","LIKE",identifiantRechercheVo.getDescription());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<IdentifiantRecherche> identifiantRecherches){
        if(ListUtil.isNotEmpty(identifiantRecherches)){
        identifiantRecherches.forEach(e->identifiantRechercheDao.delete(e));
        }
}
@Override
public void update(List<IdentifiantRecherche> identifiantRecherches){
if(ListUtil.isNotEmpty(identifiantRecherches)){
identifiantRecherches.forEach(e->identifiantRechercheDao.save(e));
}
}



@Override
public List<List<IdentifiantRecherche>>  getToBeSavedAndToBeDeleted(List<IdentifiantRecherche> oldList,List<IdentifiantRecherche> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

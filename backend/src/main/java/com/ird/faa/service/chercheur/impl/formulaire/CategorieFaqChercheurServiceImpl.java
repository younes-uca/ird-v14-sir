package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;

import com.ird.faa.dao.formulaire.FaqDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.CategorieFaq;
import com.ird.faa.dao.formulaire.CategorieFaqDao;
import com.ird.faa.service.chercheur.facade.formulaire.CategorieFaqChercheurService;

import com.ird.faa.ws.rest.provided.vo.CategorieFaqVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CategorieFaqChercheurServiceImpl extends AbstractServiceImpl<CategorieFaq> implements CategorieFaqChercheurService {

@Autowired
private CategorieFaqDao categorieFaqDao;



@Autowired
private EntityManager entityManager;

    @Autowired
    private FaqDao faqDao;


    @Override
    public List<CategorieFaq> findAllWithFaq() {
        List<CategorieFaq> categorieFaqs = categorieFaqDao.findByArchiveOrderByOrdre(false);
        for (CategorieFaq cat : categorieFaqs) {
            cat.setFaqs(faqDao.findByArchiveAndCategorieFaqOrderByOrdre(false, cat));
        }
        return categorieFaqs;
    }


@Override
public List<CategorieFaq> findAll(){
return categorieFaqDao.findAll();
}
    @Override
    public CategorieFaq findByOrdre(Integer ordre){
    if( ordre==null) return null;
    return categorieFaqDao.findByOrdre(ordre);
    }

    @Override
    @Transactional
    public int deleteByOrdre(Integer  ordre) {
    return categorieFaqDao.deleteByOrdre(ordre);
    }
    @Override
    public CategorieFaq findByIdOrOrdre(CategorieFaq categorieFaq){
    CategorieFaq resultat=null;
    if(categorieFaq == null || ( categorieFaq.getOrdre()==null && categorieFaq.getId()==null))
    return resultat;
    else{
    if(categorieFaq.getId() != null){
    resultat= categorieFaqDao.findById(categorieFaq.getId()).get();
    }else if(StringUtil.isNotEmpty(categorieFaq.getOrdre())) {
    resultat= categorieFaqDao.findByOrdre(categorieFaq.getOrdre());
    }
    return resultat;
    }
    }

@Override
public CategorieFaq findById(Long id){
if(id==null) return null;
return categorieFaqDao.getOne(id);
}

@Override
public CategorieFaq findByIdWithAssociatedList(Long id){
CategorieFaq categorieFaq  = findById(id);
return categorieFaq;
}


@Transactional
public int deleteById(Long id){
if(categorieFaqDao.findById(id) == null) return 0;
else{
categorieFaqDao.deleteById(id);
return 1;
}
}


@Override
public CategorieFaq update(CategorieFaq categorieFaq){
CategorieFaq foundedCategorieFaq = findById(categorieFaq.getId());
if(foundedCategorieFaq==null) return null;
else{
return  categorieFaqDao.save(categorieFaq);
}
}

@Override
public CategorieFaq save (CategorieFaq categorieFaq){
    CategorieFaq foundedCategorieFaq = findByOrdre(categorieFaq.getOrdre());
   if(foundedCategorieFaq!=null) return null;



CategorieFaq savedCategorieFaq = categorieFaqDao.save(categorieFaq);
return savedCategorieFaq;
}

@Override
public List<CategorieFaq> save(List<CategorieFaq> categorieFaqs){
List<CategorieFaq> list = new ArrayList<CategorieFaq>();
for(CategorieFaq categorieFaq: categorieFaqs){
list.add(save(categorieFaq));
}
return list;
}



@Override
@Transactional
public int delete(CategorieFaq categorieFaq){
    if(categorieFaq.getOrdre()==null) return -1;

    CategorieFaq foundedCategorieFaq = findByOrdre(categorieFaq.getOrdre());
    if(foundedCategorieFaq==null) return -1;
categorieFaqDao.delete(foundedCategorieFaq);
return 1;
}


public List<CategorieFaq> findByCriteria(CategorieFaqVo categorieFaqVo){

String query = "SELECT o FROM CategorieFaq o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",categorieFaqVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",categorieFaqVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "ordre","=",categorieFaqVo.getOrdre());
            query += SearchUtil.addConstraint( "o", "archive","=",categorieFaqVo.getArchive());
            query += SearchUtil.addConstraintMinMax("o","ordre",categorieFaqVo.getOrdreMin(),categorieFaqVo.getOrdreMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<CategorieFaq> categorieFaqs){
        if(ListUtil.isNotEmpty(categorieFaqs)){
        categorieFaqs.forEach(e->categorieFaqDao.delete(e));
        }
}
@Override
public void update(List<CategorieFaq> categorieFaqs){
if(ListUtil.isNotEmpty(categorieFaqs)){
categorieFaqs.forEach(e->categorieFaqDao.save(e));
}
}



@Override
public List<List<CategorieFaq>>  getToBeSavedAndToBeDeleted(List<CategorieFaq> oldList,List<CategorieFaq> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

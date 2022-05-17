package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.TemplateRelance;
import com.ird.faa.dao.formulaire.TemplateRelanceDao;
import com.ird.faa.service.chercheur.facade.formulaire.TemplateRelanceChercheurService;

import com.ird.faa.ws.rest.provided.vo.TemplateRelanceVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TemplateRelanceChercheurServiceImpl extends AbstractServiceImpl<TemplateRelance> implements TemplateRelanceChercheurService {

@Autowired
private TemplateRelanceDao templateRelanceDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TemplateRelance> findAll(){
return templateRelanceDao.findAll();
}
    @Override
    public TemplateRelance findByCode(String code){
    if( code==null) return null;
    return templateRelanceDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return templateRelanceDao.deleteByCode(code);
    }
    @Override
    public TemplateRelance findByIdOrCode(TemplateRelance templateRelance){
    TemplateRelance resultat=null;
    if(templateRelance == null || ( templateRelance.getCode()==null && templateRelance.getId()==null))
    return resultat;
    else{
    if(templateRelance.getId() != null){
    resultat= templateRelanceDao.findById(templateRelance.getId()).get();
    }else if(StringUtil.isNotEmpty(templateRelance.getCode())) {
    resultat= templateRelanceDao.findByCode(templateRelance.getCode());
    }
    return resultat;
    }
    }

@Override
public TemplateRelance findById(Long id){
if(id==null) return null;
return templateRelanceDao.getOne(id);
}

@Override
public TemplateRelance findByIdWithAssociatedList(Long id){
TemplateRelance templateRelance  = findById(id);
return templateRelance;
}


@Transactional
public int deleteById(Long id){
if(templateRelanceDao.findById(id) == null) return 0;
else{
templateRelanceDao.deleteById(id);
return 1;
}
}


@Override
public TemplateRelance update(TemplateRelance templateRelance){
TemplateRelance foundedTemplateRelance = findById(templateRelance.getId());
if(foundedTemplateRelance==null) return null;
else{
return  templateRelanceDao.save(templateRelance);
}
}

@Override
public TemplateRelance save (TemplateRelance templateRelance){
    TemplateRelance foundedTemplateRelance = findByCode(templateRelance.getCode());
   if(foundedTemplateRelance!=null) return null;



TemplateRelance savedTemplateRelance = templateRelanceDao.save(templateRelance);
return savedTemplateRelance;
}

@Override
public List<TemplateRelance> save(List<TemplateRelance> templateRelances){
List<TemplateRelance> list = new ArrayList<TemplateRelance>();
for(TemplateRelance templateRelance: templateRelances){
list.add(save(templateRelance));
}
return list;
}



@Override
@Transactional
public int delete(TemplateRelance templateRelance){
    if(templateRelance.getCode()==null) return -1;

    TemplateRelance foundedTemplateRelance = findByCode(templateRelance.getCode());
    if(foundedTemplateRelance==null) return -1;
templateRelanceDao.delete(foundedTemplateRelance);
return 1;
}


public List<TemplateRelance> findByCriteria(TemplateRelanceVo templateRelanceVo){

String query = "SELECT o FROM TemplateRelance o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",templateRelanceVo.getId());
            query += SearchUtil.addConstraint( "o", "code","LIKE",templateRelanceVo.getCode());
            query += SearchUtil.addConstraint( "o", "objet","LIKE",templateRelanceVo.getObjet());
            query += SearchUtil.addConstraint( "o", "message","LIKE",templateRelanceVo.getMessage());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TemplateRelance> templateRelances){
        if(ListUtil.isNotEmpty(templateRelances)){
        templateRelances.forEach(e->templateRelanceDao.delete(e));
        }
}
@Override
public void update(List<TemplateRelance> templateRelances){
if(ListUtil.isNotEmpty(templateRelances)){
templateRelances.forEach(e->templateRelanceDao.save(e));
}
}



@Override
public List<List<TemplateRelance>>  getToBeSavedAndToBeDeleted(List<TemplateRelance> oldList,List<TemplateRelance> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

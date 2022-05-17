package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.TemplateRappel;
import com.ird.faa.dao.formulaire.TemplateRappelDao;
import com.ird.faa.service.chercheur.facade.formulaire.TemplateRappelChercheurService;

import com.ird.faa.ws.rest.provided.vo.TemplateRappelVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TemplateRappelChercheurServiceImpl extends AbstractServiceImpl<TemplateRappel> implements TemplateRappelChercheurService {

@Autowired
private TemplateRappelDao templateRappelDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TemplateRappel> findAll(){
return templateRappelDao.findAll();
}
    @Override
    public TemplateRappel findByCode(String code){
    if( code==null) return null;
    return templateRappelDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return templateRappelDao.deleteByCode(code);
    }
    @Override
    public TemplateRappel findByIdOrCode(TemplateRappel templateRappel){
    TemplateRappel resultat=null;
    if(templateRappel == null || ( templateRappel.getCode()==null && templateRappel.getId()==null))
    return resultat;
    else{
    if(templateRappel.getId() != null){
    resultat= templateRappelDao.findById(templateRappel.getId()).get();
    }else if(StringUtil.isNotEmpty(templateRappel.getCode())) {
    resultat= templateRappelDao.findByCode(templateRappel.getCode());
    }
    return resultat;
    }
    }

@Override
public TemplateRappel findById(Long id){
if(id==null) return null;
return templateRappelDao.getOne(id);
}

@Override
public TemplateRappel findByIdWithAssociatedList(Long id){
TemplateRappel templateRappel  = findById(id);
return templateRappel;
}


@Transactional
public int deleteById(Long id){
if(templateRappelDao.findById(id) == null) return 0;
else{
templateRappelDao.deleteById(id);
return 1;
}
}


@Override
public TemplateRappel update(TemplateRappel templateRappel){
TemplateRappel foundedTemplateRappel = findById(templateRappel.getId());
if(foundedTemplateRappel==null) return null;
else{
return  templateRappelDao.save(templateRappel);
}
}

@Override
public TemplateRappel save (TemplateRappel templateRappel){
    TemplateRappel foundedTemplateRappel = findByCode(templateRappel.getCode());
   if(foundedTemplateRappel!=null) return null;



TemplateRappel savedTemplateRappel = templateRappelDao.save(templateRappel);
return savedTemplateRappel;
}

@Override
public List<TemplateRappel> save(List<TemplateRappel> templateRappels){
List<TemplateRappel> list = new ArrayList<TemplateRappel>();
for(TemplateRappel templateRappel: templateRappels){
list.add(save(templateRappel));
}
return list;
}



@Override
@Transactional
public int delete(TemplateRappel templateRappel){
    if(templateRappel.getCode()==null) return -1;

    TemplateRappel foundedTemplateRappel = findByCode(templateRappel.getCode());
    if(foundedTemplateRappel==null) return -1;
templateRappelDao.delete(foundedTemplateRappel);
return 1;
}


public List<TemplateRappel> findByCriteria(TemplateRappelVo templateRappelVo){

String query = "SELECT o FROM TemplateRappel o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",templateRappelVo.getId());
            query += SearchUtil.addConstraint( "o", "code","LIKE",templateRappelVo.getCode());
            query += SearchUtil.addConstraint( "o", "objet","LIKE",templateRappelVo.getObjet());
            query += SearchUtil.addConstraint( "o", "message","LIKE",templateRappelVo.getMessage());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TemplateRappel> templateRappels){
        if(ListUtil.isNotEmpty(templateRappels)){
        templateRappels.forEach(e->templateRappelDao.delete(e));
        }
}
@Override
public void update(List<TemplateRappel> templateRappels){
if(ListUtil.isNotEmpty(templateRappels)){
templateRappels.forEach(e->templateRappelDao.save(e));
}
}



@Override
public List<List<TemplateRappel>>  getToBeSavedAndToBeDeleted(List<TemplateRappel> oldList,List<TemplateRappel> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

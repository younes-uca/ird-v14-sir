package com.ird.faa.service.chercheur.impl.formulaire;

import com.ird.faa.bean.formulaire.TypeExpertiseEvaluation;
import com.ird.faa.dao.formulaire.TypeExpertiseEvaluationDao;
import com.ird.faa.security.bean.User;
import com.ird.faa.security.common.SecurityUtil;
import com.ird.faa.service.chercheur.facade.formulaire.TypeExpertiseEvaluationChercheurService;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.TypeExpertiseEvaluationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TypeExpertiseEvaluationChercheurServiceImpl extends AbstractServiceImpl<TypeExpertiseEvaluation> implements TypeExpertiseEvaluationChercheurService {

@Autowired
private TypeExpertiseEvaluationDao typeExpertiseEvaluationDao;

    @Autowired
    private ArchivableService<TypeExpertiseEvaluation> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<TypeExpertiseEvaluation> findAll(){
    List<TypeExpertiseEvaluation> result= new ArrayList();
    result.addAll(findAllNonArchive());
    result.addAll(findAllByOwner());
    return result;
}
    @Override
    public TypeExpertiseEvaluation findByCode(String code){
    if( code==null) return null;
    return typeExpertiseEvaluationDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return typeExpertiseEvaluationDao.deleteByCode(code);
    }
    @Override
    public TypeExpertiseEvaluation findByIdOrCode(TypeExpertiseEvaluation typeExpertiseEvaluation){
    TypeExpertiseEvaluation resultat=null;
    if(typeExpertiseEvaluation != null){
    if(StringUtil.isNotEmpty(typeExpertiseEvaluation.getId())){
    resultat= typeExpertiseEvaluationDao.getOne(typeExpertiseEvaluation.getId());
    }else if(StringUtil.isNotEmpty(typeExpertiseEvaluation.getCode())) {
    resultat= typeExpertiseEvaluationDao.findByCode(typeExpertiseEvaluation.getCode());
    }
    }
    return resultat;
    }

@Override
public TypeExpertiseEvaluation findById(Long id){
if(id==null) return null;
return typeExpertiseEvaluationDao.getOne(id);
}

@Override
public TypeExpertiseEvaluation findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(typeExpertiseEvaluationDao.findById(id).isPresent())  {
typeExpertiseEvaluationDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeExpertiseEvaluation update(TypeExpertiseEvaluation typeExpertiseEvaluation){
TypeExpertiseEvaluation foundedTypeExpertiseEvaluation = findById(typeExpertiseEvaluation.getId());
if(foundedTypeExpertiseEvaluation==null) return null;
else{
    archivableService.prepare(typeExpertiseEvaluation);
return  typeExpertiseEvaluationDao.save(typeExpertiseEvaluation);
}
}
    private void prepareSave(TypeExpertiseEvaluation typeExpertiseEvaluation){
        typeExpertiseEvaluation.setDateCreation(new Date());
        if(typeExpertiseEvaluation.getDateArchivage() == null)
        typeExpertiseEvaluation.setDateArchivage(new Date());
                    if(typeExpertiseEvaluation.getArchive() == null)
                typeExpertiseEvaluation.setArchive(false);




    }

@Override
public TypeExpertiseEvaluation save (TypeExpertiseEvaluation typeExpertiseEvaluation){
    prepareSave(typeExpertiseEvaluation);

    TypeExpertiseEvaluation result =null;
    TypeExpertiseEvaluation foundedTypeExpertiseEvaluation = findByCode(typeExpertiseEvaluation.getCode());
    if(foundedTypeExpertiseEvaluation == null){




    TypeExpertiseEvaluation savedTypeExpertiseEvaluation = typeExpertiseEvaluationDao.save(typeExpertiseEvaluation);

    result = savedTypeExpertiseEvaluation;
    }

    return result;
}

@Override
public List<TypeExpertiseEvaluation> save(List<TypeExpertiseEvaluation> typeExpertiseEvaluations){
List<TypeExpertiseEvaluation> list = new ArrayList<>();
for(TypeExpertiseEvaluation typeExpertiseEvaluation: typeExpertiseEvaluations){
list.add(save(typeExpertiseEvaluation));
}
return list;
}



@Override
@Transactional
public int delete(TypeExpertiseEvaluation typeExpertiseEvaluation){
    if(typeExpertiseEvaluation.getCode()==null) return -1;

    TypeExpertiseEvaluation foundedTypeExpertiseEvaluation = findByCode(typeExpertiseEvaluation.getCode());
    if(foundedTypeExpertiseEvaluation==null) return -1;
typeExpertiseEvaluationDao.delete(foundedTypeExpertiseEvaluation);
return 1;
}


public List<TypeExpertiseEvaluation> findByCriteria(TypeExpertiseEvaluationVo typeExpertiseEvaluationVo){

String query = "SELECT o FROM TypeExpertiseEvaluation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeExpertiseEvaluationVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeExpertiseEvaluationVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",typeExpertiseEvaluationVo.getCode());
            query += SearchUtil.addConstraint( "o", "archive","=",typeExpertiseEvaluationVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",typeExpertiseEvaluationVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",typeExpertiseEvaluationVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",typeExpertiseEvaluationVo.getDateArchivageMin(),typeExpertiseEvaluationVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",typeExpertiseEvaluationVo.getDateCreationMin(),typeExpertiseEvaluationVo.getDateCreationMax());
    query+= " ORDER BY o.code";
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeExpertiseEvaluation> typeExpertiseEvaluations){
if(ListUtil.isNotEmpty(typeExpertiseEvaluations)){
typeExpertiseEvaluations.forEach(e->typeExpertiseEvaluationDao.delete(e));
}
}
@Override
public void update(List<TypeExpertiseEvaluation> typeExpertiseEvaluations){
if(ListUtil.isNotEmpty(typeExpertiseEvaluations)){
typeExpertiseEvaluations.forEach(e->typeExpertiseEvaluationDao.save(e));
}
}




        public List<TypeExpertiseEvaluation> findAllNonArchive(){
        String query = "SELECT o FROM TypeExpertiseEvaluation o  WHERE o.archive != true AND o.visible = true";
            query+= " ORDER BY o.code";
        return entityManager.createQuery(query).getResultList();
        }

        public List<TypeExpertiseEvaluation> findAllByOwner(){
        List<TypeExpertiseEvaluation> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM TypeExpertiseEvaluation o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
            query+= " ORDER BY o.code";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

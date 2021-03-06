package com.ird.faa.service.chercheur.impl.formulaire;

import com.ird.faa.bean.formulaire.SemanticRelationship;
import com.ird.faa.dao.formulaire.SemanticRelationshipDao;
import com.ird.faa.security.bean.User;
import com.ird.faa.security.common.SecurityUtil;
import com.ird.faa.service.chercheur.facade.formulaire.SemanticRelationshipChercheurService;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.SemanticRelationshipVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SemanticRelationshipChercheurServiceImpl extends AbstractServiceImpl<SemanticRelationship> implements SemanticRelationshipChercheurService {

@Autowired
private SemanticRelationshipDao semanticRelationshipDao;

    @Autowired
    private ArchivableService<SemanticRelationship> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<SemanticRelationship> findAll(){
    List<SemanticRelationship> result= new ArrayList();
    result.addAll(findAllNonArchive());
    result.addAll(findAllByOwner());
    return result;
}
    @Override
    public SemanticRelationship findByCode(String code){
    if( code==null) return null;
    return semanticRelationshipDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return semanticRelationshipDao.deleteByCode(code);
    }
    @Override
    public SemanticRelationship findByIdOrCode(SemanticRelationship semanticRelationship){
    SemanticRelationship resultat=null;
    if(semanticRelationship != null){
    if(StringUtil.isNotEmpty(semanticRelationship.getId())){
    resultat= semanticRelationshipDao.getOne(semanticRelationship.getId());
    }else if(StringUtil.isNotEmpty(semanticRelationship.getCode())) {
    resultat= semanticRelationshipDao.findByCode(semanticRelationship.getCode());
    }
    }
    return resultat;
    }

@Override
public SemanticRelationship findById(Long id){
if(id==null) return null;
return semanticRelationshipDao.getOne(id);
}

@Override
public SemanticRelationship findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(semanticRelationshipDao.findById(id).isPresent())  {
semanticRelationshipDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public SemanticRelationship update(SemanticRelationship semanticRelationship){
SemanticRelationship foundedSemanticRelationship = findById(semanticRelationship.getId());
if(foundedSemanticRelationship==null) return null;
else{
    archivableService.prepare(semanticRelationship);
return  semanticRelationshipDao.save(semanticRelationship);
}
}
    private void prepareSave(SemanticRelationship semanticRelationship){
        semanticRelationship.setDateCreation(new Date());
        if(semanticRelationship.getDateArchivage() == null)
        semanticRelationship.setDateArchivage(new Date());
                    if(semanticRelationship.getArchive() == null)
                semanticRelationship.setArchive(false);




    }

@Override
public SemanticRelationship save (SemanticRelationship semanticRelationship){
    prepareSave(semanticRelationship);

    SemanticRelationship result =null;
    SemanticRelationship foundedSemanticRelationship = findByCode(semanticRelationship.getCode());
    if(foundedSemanticRelationship == null){




    SemanticRelationship savedSemanticRelationship = semanticRelationshipDao.save(semanticRelationship);

    result = savedSemanticRelationship;
    }

    return result;
}

@Override
public List<SemanticRelationship> save(List<SemanticRelationship> semanticRelationships){
List<SemanticRelationship> list = new ArrayList<>();
for(SemanticRelationship semanticRelationship: semanticRelationships){
list.add(save(semanticRelationship));
}
return list;
}



@Override
@Transactional
public int delete(SemanticRelationship semanticRelationship){
    if(semanticRelationship.getCode()==null) return -1;

    SemanticRelationship foundedSemanticRelationship = findByCode(semanticRelationship.getCode());
    if(foundedSemanticRelationship==null) return -1;
semanticRelationshipDao.delete(foundedSemanticRelationship);
return 1;
}


public List<SemanticRelationship> findByCriteria(SemanticRelationshipVo semanticRelationshipVo){

String query = "SELECT o FROM SemanticRelationship o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",semanticRelationshipVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",semanticRelationshipVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",semanticRelationshipVo.getCode());
            query += SearchUtil.addConstraint( "o", "niveauExactitude","=",semanticRelationshipVo.getNiveauExactitude());
            query += SearchUtil.addConstraint( "o", "archive","=",semanticRelationshipVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",semanticRelationshipVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",semanticRelationshipVo.getDateCreation());
            query += SearchUtil.addConstraintMinMax("o","niveauExactitude",semanticRelationshipVo.getNiveauExactitudeMin(),semanticRelationshipVo.getNiveauExactitudeMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",semanticRelationshipVo.getDateArchivageMin(),semanticRelationshipVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",semanticRelationshipVo.getDateCreationMin(),semanticRelationshipVo.getDateCreationMax());
    query+= " ORDER BY o.niveauExactitude";
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<SemanticRelationship> semanticRelationships){
if(ListUtil.isNotEmpty(semanticRelationships)){
semanticRelationships.forEach(e->semanticRelationshipDao.delete(e));
}
}
@Override
public void update(List<SemanticRelationship> semanticRelationships){
if(ListUtil.isNotEmpty(semanticRelationships)){
semanticRelationships.forEach(e->semanticRelationshipDao.save(e));
}
}




        public List<SemanticRelationship> findAllNonArchive(){
        String query = "SELECT o FROM SemanticRelationship o  WHERE o.archive != true AND o.visible = true";
            query+= " ORDER BY o.niveauExactitude";
        return entityManager.createQuery(query).getResultList();
        }

        public List<SemanticRelationship> findAllByOwner(){
        List<SemanticRelationship> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM SemanticRelationship o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
            query+= " ORDER BY o.niveauExactitude";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

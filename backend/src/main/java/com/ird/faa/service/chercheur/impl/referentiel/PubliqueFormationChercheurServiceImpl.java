package com.ird.faa.service.chercheur.impl.formulaire;

import com.ird.faa.bean.referentiel.PubliqueFormation;
import com.ird.faa.dao.formulaire.PubliqueFormationDao;
import com.ird.faa.security.bean.User;
import com.ird.faa.security.common.SecurityUtil;
import com.ird.faa.service.chercheur.facade.formulaire.PubliqueFormationChercheurService;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.PubliqueFormationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PubliqueFormationChercheurServiceImpl extends AbstractServiceImpl<PubliqueFormation> implements PubliqueFormationChercheurService {

@Autowired
private PubliqueFormationDao publiqueFormationDao;

    @Autowired
    private ArchivableService<PubliqueFormation> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<PubliqueFormation> findAll(){
    List<PubliqueFormation> result= new ArrayList();
    result.addAll(findAllNonArchive());
    result.addAll(findAllByOwner());
    return result;
}
    @Override
    public PubliqueFormation findByCode(String code){
    if( code==null) return null;
    return publiqueFormationDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return publiqueFormationDao.deleteByCode(code);
    }
    @Override
    public PubliqueFormation findByIdOrCode(PubliqueFormation publiqueFormation){
    PubliqueFormation resultat=null;
    if(publiqueFormation != null){
    if(StringUtil.isNotEmpty(publiqueFormation.getId())){
    resultat= publiqueFormationDao.getOne(publiqueFormation.getId());
    }else if(StringUtil.isNotEmpty(publiqueFormation.getCode())) {
    resultat= publiqueFormationDao.findByCode(publiqueFormation.getCode());
    }
    }
    return resultat;
    }

@Override
public PubliqueFormation findById(Long id){
if(id==null) return null;
return publiqueFormationDao.getOne(id);
}

@Override
public PubliqueFormation findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(publiqueFormationDao.findById(id).isPresent())  {
publiqueFormationDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PubliqueFormation update(PubliqueFormation publiqueFormation){
PubliqueFormation foundedPubliqueFormation = findById(publiqueFormation.getId());
if(foundedPubliqueFormation==null) return null;
else{
    archivableService.prepare(publiqueFormation);
return  publiqueFormationDao.save(publiqueFormation);
}
}
    private void prepareSave(PubliqueFormation publiqueFormation){
        publiqueFormation.setDateCreation(new Date());
        if(publiqueFormation.getDateArchivage() == null)
        publiqueFormation.setDateArchivage(new Date());
                    if(publiqueFormation.getArchive() == null)
                publiqueFormation.setArchive(false);




    }

@Override
public PubliqueFormation save (PubliqueFormation publiqueFormation){
    prepareSave(publiqueFormation);

    PubliqueFormation result =null;
    PubliqueFormation foundedPubliqueFormation = findByCode(publiqueFormation.getCode());
    if(foundedPubliqueFormation == null){




    PubliqueFormation savedPubliqueFormation = publiqueFormationDao.save(publiqueFormation);

    result = savedPubliqueFormation;
    }

    return result;
}

@Override
public List<PubliqueFormation> save(List<PubliqueFormation> publiqueFormations){
List<PubliqueFormation> list = new ArrayList<>();
for(PubliqueFormation publiqueFormation: publiqueFormations){
list.add(save(publiqueFormation));
}
return list;
}



@Override
@Transactional
public int delete(PubliqueFormation publiqueFormation){
    if(publiqueFormation.getCode()==null) return -1;

    PubliqueFormation foundedPubliqueFormation = findByCode(publiqueFormation.getCode());
    if(foundedPubliqueFormation==null) return -1;
publiqueFormationDao.delete(foundedPubliqueFormation);
return 1;
}


public List<PubliqueFormation> findByCriteria(PubliqueFormationVo publiqueFormationVo){

String query = "SELECT o FROM PubliqueFormation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",publiqueFormationVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",publiqueFormationVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",publiqueFormationVo.getCode());
            query += SearchUtil.addConstraint( "o", "archive","=",publiqueFormationVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",publiqueFormationVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",publiqueFormationVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",publiqueFormationVo.getDateArchivageMin(),publiqueFormationVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",publiqueFormationVo.getDateCreationMin(),publiqueFormationVo.getDateCreationMax());
    query+= " ORDER BY o.code";
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<PubliqueFormation> publiqueFormations){
if(ListUtil.isNotEmpty(publiqueFormations)){
publiqueFormations.forEach(e->publiqueFormationDao.delete(e));
}
}
@Override
public void update(List<PubliqueFormation> publiqueFormations){
if(ListUtil.isNotEmpty(publiqueFormations)){
publiqueFormations.forEach(e->publiqueFormationDao.save(e));
}
}




        public List<PubliqueFormation> findAllNonArchive(){
        String query = "SELECT o FROM PubliqueFormation o  WHERE o.archive != true AND o.visible = true";
            query+= " ORDER BY o.code";
        return entityManager.createQuery(query).getResultList();
        }

        public List<PubliqueFormation> findAllByOwner(){
        List<PubliqueFormation> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM PubliqueFormation o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
            query+= " ORDER BY o.code";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

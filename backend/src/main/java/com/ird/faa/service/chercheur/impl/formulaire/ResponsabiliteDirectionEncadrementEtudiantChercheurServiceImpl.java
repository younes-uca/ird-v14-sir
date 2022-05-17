package com.ird.faa.service.chercheur.impl.formulaire;

import com.ird.faa.bean.formulaire.ResponsabiliteDirectionEncadrementEtudiant;
import com.ird.faa.dao.formulaire.ResponsabiliteDirectionEncadrementEtudiantDao;
import com.ird.faa.security.bean.User;
import com.ird.faa.security.common.SecurityUtil;
import com.ird.faa.service.chercheur.facade.formulaire.ResponsabiliteDirectionEncadrementEtudiantChercheurService;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.ResponsabiliteDirectionEncadrementEtudiantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResponsabiliteDirectionEncadrementEtudiantChercheurServiceImpl extends AbstractServiceImpl<ResponsabiliteDirectionEncadrementEtudiant> implements ResponsabiliteDirectionEncadrementEtudiantChercheurService {

@Autowired
private ResponsabiliteDirectionEncadrementEtudiantDao responsabiliteDirectionEncadrementEtudiantDao;

    @Autowired
    private ArchivableService<ResponsabiliteDirectionEncadrementEtudiant> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<ResponsabiliteDirectionEncadrementEtudiant> findAll(){
    List<ResponsabiliteDirectionEncadrementEtudiant> result= new ArrayList();
    result.addAll(findAllNonArchive());
    result.addAll(findAllByOwner());
    return result;
}
    @Override
    public ResponsabiliteDirectionEncadrementEtudiant findByCode(String code){
    if( code==null) return null;
    return responsabiliteDirectionEncadrementEtudiantDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return responsabiliteDirectionEncadrementEtudiantDao.deleteByCode(code);
    }
    @Override
    public ResponsabiliteDirectionEncadrementEtudiant findByIdOrCode(ResponsabiliteDirectionEncadrementEtudiant responsabiliteDirectionEncadrementEtudiant){
    ResponsabiliteDirectionEncadrementEtudiant resultat=null;
    if(responsabiliteDirectionEncadrementEtudiant != null){
    if(StringUtil.isNotEmpty(responsabiliteDirectionEncadrementEtudiant.getId())){
    resultat= responsabiliteDirectionEncadrementEtudiantDao.getOne(responsabiliteDirectionEncadrementEtudiant.getId());
    }else if(StringUtil.isNotEmpty(responsabiliteDirectionEncadrementEtudiant.getCode())) {
    resultat= responsabiliteDirectionEncadrementEtudiantDao.findByCode(responsabiliteDirectionEncadrementEtudiant.getCode());
    }
    }
    return resultat;
    }

@Override
public ResponsabiliteDirectionEncadrementEtudiant findById(Long id){
if(id==null) return null;
return responsabiliteDirectionEncadrementEtudiantDao.getOne(id);
}

@Override
public ResponsabiliteDirectionEncadrementEtudiant findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(responsabiliteDirectionEncadrementEtudiantDao.findById(id).isPresent())  {
responsabiliteDirectionEncadrementEtudiantDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public ResponsabiliteDirectionEncadrementEtudiant update(ResponsabiliteDirectionEncadrementEtudiant responsabiliteDirectionEncadrementEtudiant){
ResponsabiliteDirectionEncadrementEtudiant foundedResponsabiliteDirectionEncadrementEtudiant = findById(responsabiliteDirectionEncadrementEtudiant.getId());
if(foundedResponsabiliteDirectionEncadrementEtudiant==null) return null;
else{
    archivableService.prepare(responsabiliteDirectionEncadrementEtudiant);
return  responsabiliteDirectionEncadrementEtudiantDao.save(responsabiliteDirectionEncadrementEtudiant);
}
}
    private void prepareSave(ResponsabiliteDirectionEncadrementEtudiant responsabiliteDirectionEncadrementEtudiant){
        responsabiliteDirectionEncadrementEtudiant.setDateCreation(new Date());
        if(responsabiliteDirectionEncadrementEtudiant.getDateArchivage() == null)
        responsabiliteDirectionEncadrementEtudiant.setDateArchivage(new Date());
                    if(responsabiliteDirectionEncadrementEtudiant.getArchive() == null)
                responsabiliteDirectionEncadrementEtudiant.setArchive(false);




    }

@Override
public ResponsabiliteDirectionEncadrementEtudiant save (ResponsabiliteDirectionEncadrementEtudiant responsabiliteDirectionEncadrementEtudiant){
    prepareSave(responsabiliteDirectionEncadrementEtudiant);

    ResponsabiliteDirectionEncadrementEtudiant result =null;
    ResponsabiliteDirectionEncadrementEtudiant foundedResponsabiliteDirectionEncadrementEtudiant = findByCode(responsabiliteDirectionEncadrementEtudiant.getCode());
    if(foundedResponsabiliteDirectionEncadrementEtudiant == null){




    ResponsabiliteDirectionEncadrementEtudiant savedResponsabiliteDirectionEncadrementEtudiant = responsabiliteDirectionEncadrementEtudiantDao.save(responsabiliteDirectionEncadrementEtudiant);

    result = savedResponsabiliteDirectionEncadrementEtudiant;
    }

    return result;
}

@Override
public List<ResponsabiliteDirectionEncadrementEtudiant> save(List<ResponsabiliteDirectionEncadrementEtudiant> responsabiliteDirectionEncadrementEtudiants){
List<ResponsabiliteDirectionEncadrementEtudiant> list = new ArrayList<>();
for(ResponsabiliteDirectionEncadrementEtudiant responsabiliteDirectionEncadrementEtudiant: responsabiliteDirectionEncadrementEtudiants){
list.add(save(responsabiliteDirectionEncadrementEtudiant));
}
return list;
}



@Override
@Transactional
public int delete(ResponsabiliteDirectionEncadrementEtudiant responsabiliteDirectionEncadrementEtudiant){
    if(responsabiliteDirectionEncadrementEtudiant.getCode()==null) return -1;

    ResponsabiliteDirectionEncadrementEtudiant foundedResponsabiliteDirectionEncadrementEtudiant = findByCode(responsabiliteDirectionEncadrementEtudiant.getCode());
    if(foundedResponsabiliteDirectionEncadrementEtudiant==null) return -1;
responsabiliteDirectionEncadrementEtudiantDao.delete(foundedResponsabiliteDirectionEncadrementEtudiant);
return 1;
}


public List<ResponsabiliteDirectionEncadrementEtudiant> findByCriteria(ResponsabiliteDirectionEncadrementEtudiantVo responsabiliteDirectionEncadrementEtudiantVo){

String query = "SELECT o FROM ResponsabiliteDirectionEncadrementEtudiant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",responsabiliteDirectionEncadrementEtudiantVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",responsabiliteDirectionEncadrementEtudiantVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",responsabiliteDirectionEncadrementEtudiantVo.getCode());
            query += SearchUtil.addConstraint( "o", "archive","=",responsabiliteDirectionEncadrementEtudiantVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",responsabiliteDirectionEncadrementEtudiantVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",responsabiliteDirectionEncadrementEtudiantVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",responsabiliteDirectionEncadrementEtudiantVo.getDateArchivageMin(),responsabiliteDirectionEncadrementEtudiantVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",responsabiliteDirectionEncadrementEtudiantVo.getDateCreationMin(),responsabiliteDirectionEncadrementEtudiantVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<ResponsabiliteDirectionEncadrementEtudiant> responsabiliteDirectionEncadrementEtudiants){
if(ListUtil.isNotEmpty(responsabiliteDirectionEncadrementEtudiants)){
responsabiliteDirectionEncadrementEtudiants.forEach(e->responsabiliteDirectionEncadrementEtudiantDao.delete(e));
}
}
@Override
public void update(List<ResponsabiliteDirectionEncadrementEtudiant> responsabiliteDirectionEncadrementEtudiants){
if(ListUtil.isNotEmpty(responsabiliteDirectionEncadrementEtudiants)){
responsabiliteDirectionEncadrementEtudiants.forEach(e->responsabiliteDirectionEncadrementEtudiantDao.save(e));
}
}




        public List<ResponsabiliteDirectionEncadrementEtudiant> findAllNonArchive(){
        String query = "SELECT o FROM ResponsabiliteDirectionEncadrementEtudiant o  WHERE o.archive != true AND o.visible = true";
        return entityManager.createQuery(query).getResultList();
        }

        public List<ResponsabiliteDirectionEncadrementEtudiant> findAllByOwner(){
        List<ResponsabiliteDirectionEncadrementEtudiant> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM ResponsabiliteDirectionEncadrementEtudiant o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

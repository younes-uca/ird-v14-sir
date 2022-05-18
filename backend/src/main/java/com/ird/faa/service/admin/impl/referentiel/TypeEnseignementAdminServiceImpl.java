package com.ird.faa.service.admin.impl.formulaire;

import com.ird.faa.bean.referentiel.TypeEnseignement;
import com.ird.faa.dao.formulaire.TypeEnseignementDao;
import com.ird.faa.service.admin.facade.formulaire.TypeEnseignementAdminService;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.TypeEnseignementVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TypeEnseignementAdminServiceImpl extends AbstractServiceImpl<TypeEnseignement> implements TypeEnseignementAdminService {

@Autowired
private TypeEnseignementDao typeEnseignementDao;

    @Autowired
    private ArchivableService<TypeEnseignement> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<TypeEnseignement> findAll(){
        String query = "SELECT o FROM TypeEnseignement o where 1=1 ";
        query+= " ORDER BY o.code";
        return entityManager.createQuery(query).getResultList();
}
    @Override
    public TypeEnseignement findByCode(String code){
    if( code==null) return null;
    return typeEnseignementDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return typeEnseignementDao.deleteByCode(code);
    }
    @Override
    public TypeEnseignement findByIdOrCode(TypeEnseignement typeEnseignement){
    TypeEnseignement resultat=null;
    if(typeEnseignement != null){
    if(StringUtil.isNotEmpty(typeEnseignement.getId())){
    resultat= typeEnseignementDao.getOne(typeEnseignement.getId());
    }else if(StringUtil.isNotEmpty(typeEnseignement.getCode())) {
    resultat= typeEnseignementDao.findByCode(typeEnseignement.getCode());
    }
    }
    return resultat;
    }

@Override
public TypeEnseignement findById(Long id){
if(id==null) return null;
return typeEnseignementDao.getOne(id);
}

@Override
public TypeEnseignement findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public TypeEnseignement archiver(TypeEnseignement typeEnseignement) {
    if (typeEnseignement.getArchive() == null) {
    typeEnseignement.setArchive(false);
    }
    typeEnseignement.setArchive(true);
    typeEnseignement.setDateArchivage(new Date());
    typeEnseignementDao.save(typeEnseignement);
    return typeEnseignement;

    }

    @Override
    public TypeEnseignement desarchiver(TypeEnseignement typeEnseignement) {
    if (typeEnseignement.getArchive() == null) {
    typeEnseignement.setArchive(false);
    }
    typeEnseignement.setArchive(false);
    typeEnseignementDao.save(typeEnseignement);
    return typeEnseignement;
    }




@Transactional
public int deleteById(Long id){
int res=0;
if(typeEnseignementDao.findById(id).isPresent())  {
typeEnseignementDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeEnseignement update(TypeEnseignement typeEnseignement){
TypeEnseignement foundedTypeEnseignement = findById(typeEnseignement.getId());
if(foundedTypeEnseignement==null) return null;
else{
    archivableService.prepare(typeEnseignement);
return  typeEnseignementDao.save(typeEnseignement);
}
}
    private void prepareSave(TypeEnseignement typeEnseignement){
        typeEnseignement.setDateCreation(new Date());
        if(typeEnseignement.getDateArchivage() == null)
        typeEnseignement.setDateArchivage(new Date());
                    if(typeEnseignement.getArchive() == null)
                typeEnseignement.setArchive(false);




    }

@Override
public TypeEnseignement save (TypeEnseignement typeEnseignement){
    prepareSave(typeEnseignement);

    TypeEnseignement result =null;
    TypeEnseignement foundedTypeEnseignement = findByCode(typeEnseignement.getCode());
    if(foundedTypeEnseignement == null){




    TypeEnseignement savedTypeEnseignement = typeEnseignementDao.save(typeEnseignement);

    result = savedTypeEnseignement;
    }

    return result;
}

@Override
public List<TypeEnseignement> save(List<TypeEnseignement> typeEnseignements){
List<TypeEnseignement> list = new ArrayList<>();
for(TypeEnseignement typeEnseignement: typeEnseignements){
list.add(save(typeEnseignement));
}
return list;
}



@Override
@Transactional
public int delete(TypeEnseignement typeEnseignement){
    if(typeEnseignement.getCode()==null) return -1;

    TypeEnseignement foundedTypeEnseignement = findByCode(typeEnseignement.getCode());
    if(foundedTypeEnseignement==null) return -1;
typeEnseignementDao.delete(foundedTypeEnseignement);
return 1;
}


public List<TypeEnseignement> findByCriteria(TypeEnseignementVo typeEnseignementVo){

String query = "SELECT o FROM TypeEnseignement o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeEnseignementVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeEnseignementVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",typeEnseignementVo.getCode());
            query += SearchUtil.addConstraint( "o", "archive","=",typeEnseignementVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",typeEnseignementVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",typeEnseignementVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",typeEnseignementVo.getDateArchivageMin(),typeEnseignementVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",typeEnseignementVo.getDateCreationMin(),typeEnseignementVo.getDateCreationMax());
    query+= " ORDER BY o.code";
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeEnseignement> typeEnseignements){
if(ListUtil.isNotEmpty(typeEnseignements)){
typeEnseignements.forEach(e->typeEnseignementDao.delete(e));
}
}
@Override
public void update(List<TypeEnseignement> typeEnseignements){
if(ListUtil.isNotEmpty(typeEnseignements)){
typeEnseignements.forEach(e->typeEnseignementDao.save(e));
}
}





    }

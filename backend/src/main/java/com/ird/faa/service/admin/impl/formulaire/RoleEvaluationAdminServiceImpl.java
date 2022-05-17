package com.ird.faa.service.admin.impl.formulaire;

import com.ird.faa.bean.referentiel.RoleEvaluation;
import com.ird.faa.dao.formulaire.RoleEvaluationDao;
import com.ird.faa.service.admin.facade.formulaire.RoleEvaluationAdminService;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.RoleEvaluationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoleEvaluationAdminServiceImpl extends AbstractServiceImpl<RoleEvaluation> implements RoleEvaluationAdminService {

@Autowired
private RoleEvaluationDao roleEvaluationDao;

    @Autowired
    private ArchivableService<RoleEvaluation> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<RoleEvaluation> findAll(){
        String query = "SELECT o FROM RoleEvaluation o where 1=1 ";
        query+= " ORDER BY o.code";
        return entityManager.createQuery(query).getResultList();
}
    @Override
    public RoleEvaluation findByCode(String code){
    if( code==null) return null;
    return roleEvaluationDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return roleEvaluationDao.deleteByCode(code);
    }
    @Override
    public RoleEvaluation findByIdOrCode(RoleEvaluation roleEvaluation){
    RoleEvaluation resultat=null;
    if(roleEvaluation != null){
    if(StringUtil.isNotEmpty(roleEvaluation.getId())){
    resultat= roleEvaluationDao.getOne(roleEvaluation.getId());
    }else if(StringUtil.isNotEmpty(roleEvaluation.getCode())) {
    resultat= roleEvaluationDao.findByCode(roleEvaluation.getCode());
    }
    }
    return resultat;
    }

@Override
public RoleEvaluation findById(Long id){
if(id==null) return null;
return roleEvaluationDao.getOne(id);
}

@Override
public RoleEvaluation findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public RoleEvaluation archiver(RoleEvaluation roleEvaluation) {
    if (roleEvaluation.getArchive() == null) {
    roleEvaluation.setArchive(false);
    }
    roleEvaluation.setArchive(true);
    roleEvaluation.setDateArchivage(new Date());
    roleEvaluationDao.save(roleEvaluation);
    return roleEvaluation;

    }

    @Override
    public RoleEvaluation desarchiver(RoleEvaluation roleEvaluation) {
    if (roleEvaluation.getArchive() == null) {
    roleEvaluation.setArchive(false);
    }
    roleEvaluation.setArchive(false);
    roleEvaluationDao.save(roleEvaluation);
    return roleEvaluation;
    }




@Transactional
public int deleteById(Long id){
int res=0;
if(roleEvaluationDao.findById(id).isPresent())  {
roleEvaluationDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public RoleEvaluation update(RoleEvaluation roleEvaluation){
RoleEvaluation foundedRoleEvaluation = findById(roleEvaluation.getId());
if(foundedRoleEvaluation==null) return null;
else{
    archivableService.prepare(roleEvaluation);
return  roleEvaluationDao.save(roleEvaluation);
}
}
    private void prepareSave(RoleEvaluation roleEvaluation){
        roleEvaluation.setDateCreation(new Date());
        if(roleEvaluation.getDateArchivage() == null)
        roleEvaluation.setDateArchivage(new Date());
                    if(roleEvaluation.getArchive() == null)
                roleEvaluation.setArchive(false);




    }

@Override
public RoleEvaluation save (RoleEvaluation roleEvaluation){
    prepareSave(roleEvaluation);

    RoleEvaluation result =null;
    RoleEvaluation foundedRoleEvaluation = findByCode(roleEvaluation.getCode());
    if(foundedRoleEvaluation == null){




    RoleEvaluation savedRoleEvaluation = roleEvaluationDao.save(roleEvaluation);

    result = savedRoleEvaluation;
    }

    return result;
}

@Override
public List<RoleEvaluation> save(List<RoleEvaluation> roleEvaluations){
List<RoleEvaluation> list = new ArrayList<>();
for(RoleEvaluation roleEvaluation: roleEvaluations){
list.add(save(roleEvaluation));
}
return list;
}



@Override
@Transactional
public int delete(RoleEvaluation roleEvaluation){
    if(roleEvaluation.getCode()==null) return -1;

    RoleEvaluation foundedRoleEvaluation = findByCode(roleEvaluation.getCode());
    if(foundedRoleEvaluation==null) return -1;
roleEvaluationDao.delete(foundedRoleEvaluation);
return 1;
}


public List<RoleEvaluation> findByCriteria(RoleEvaluationVo roleEvaluationVo){

String query = "SELECT o FROM RoleEvaluation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",roleEvaluationVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",roleEvaluationVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",roleEvaluationVo.getCode());
            query += SearchUtil.addConstraint( "o", "archive","=",roleEvaluationVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",roleEvaluationVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",roleEvaluationVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",roleEvaluationVo.getDateArchivageMin(),roleEvaluationVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",roleEvaluationVo.getDateCreationMin(),roleEvaluationVo.getDateCreationMax());
    query+= " ORDER BY o.code";
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<RoleEvaluation> roleEvaluations){
if(ListUtil.isNotEmpty(roleEvaluations)){
roleEvaluations.forEach(e->roleEvaluationDao.delete(e));
}
}
@Override
public void update(List<RoleEvaluation> roleEvaluations){
if(ListUtil.isNotEmpty(roleEvaluations)){
roleEvaluations.forEach(e->roleEvaluationDao.save(e));
}
}





    }

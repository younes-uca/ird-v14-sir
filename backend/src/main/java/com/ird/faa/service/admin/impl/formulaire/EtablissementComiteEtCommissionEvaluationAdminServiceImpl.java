package com.ird.faa.service.admin.impl.formulaire;

import com.ird.faa.bean.formulaire.ComiteEtCommissionEvaluation;
import com.ird.faa.bean.formulaire.Etablissement;
import com.ird.faa.bean.formulaire.EtablissementComiteEtCommissionEvaluation;
import com.ird.faa.dao.formulaire.EtablissementComiteEtCommissionEvaluationDao;
import com.ird.faa.service.admin.facade.formulaire.ComiteEtCommissionEvaluationAdminService;
import com.ird.faa.service.admin.facade.formulaire.EtablissementAdminService;
import com.ird.faa.service.admin.facade.formulaire.EtablissementComiteEtCommissionEvaluationAdminService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.EtablissementComiteEtCommissionEvaluationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class EtablissementComiteEtCommissionEvaluationAdminServiceImpl extends AbstractServiceImpl<EtablissementComiteEtCommissionEvaluation> implements EtablissementComiteEtCommissionEvaluationAdminService {

@Autowired
private EtablissementComiteEtCommissionEvaluationDao etablissementComiteEtCommissionEvaluationDao;

        @Autowired
        private ComiteEtCommissionEvaluationAdminService comiteEtCommissionEvaluationService ;
        @Autowired
        private EtablissementAdminService etablissementService ;


@Autowired
private EntityManager entityManager;


@Override
public List<EtablissementComiteEtCommissionEvaluation> findAll(){
        return etablissementComiteEtCommissionEvaluationDao.findAll();
}

        @Override
        public List<EtablissementComiteEtCommissionEvaluation> findByEtablissementCode(String code){
        return etablissementComiteEtCommissionEvaluationDao.findByEtablissementCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtablissementCode(String code){
        return etablissementComiteEtCommissionEvaluationDao.deleteByEtablissementCode(code);
        }

        @Override
        public List<EtablissementComiteEtCommissionEvaluation> findByEtablissementId(Long id){
        return etablissementComiteEtCommissionEvaluationDao.findByEtablissementId(id);
        }

        @Override
        @Transactional
        public int deleteByEtablissementId(Long id){
        return etablissementComiteEtCommissionEvaluationDao.deleteByEtablissementId(id);
        }

        @Override
        public List<EtablissementComiteEtCommissionEvaluation> findByComiteEtCommissionEvaluationId(Long id){
        return etablissementComiteEtCommissionEvaluationDao.findByComiteEtCommissionEvaluationId(id);
        }

        @Override
        @Transactional
        public int deleteByComiteEtCommissionEvaluationId(Long id){
        return etablissementComiteEtCommissionEvaluationDao.deleteByComiteEtCommissionEvaluationId(id);
        }


@Override
public EtablissementComiteEtCommissionEvaluation findById(Long id){
if(id==null) return null;
return etablissementComiteEtCommissionEvaluationDao.getOne(id);
}

@Override
public EtablissementComiteEtCommissionEvaluation findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(etablissementComiteEtCommissionEvaluationDao.findById(id).isPresent())  {
etablissementComiteEtCommissionEvaluationDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtablissementComiteEtCommissionEvaluation update(EtablissementComiteEtCommissionEvaluation etablissementComiteEtCommissionEvaluation){
EtablissementComiteEtCommissionEvaluation foundedEtablissementComiteEtCommissionEvaluation = findById(etablissementComiteEtCommissionEvaluation.getId());
if(foundedEtablissementComiteEtCommissionEvaluation==null) return null;
else{
return  etablissementComiteEtCommissionEvaluationDao.save(etablissementComiteEtCommissionEvaluation);
}
}

@Override
public EtablissementComiteEtCommissionEvaluation save (EtablissementComiteEtCommissionEvaluation etablissementComiteEtCommissionEvaluation){



    findEtablissement(etablissementComiteEtCommissionEvaluation);
    findComiteEtCommissionEvaluation(etablissementComiteEtCommissionEvaluation);

    return etablissementComiteEtCommissionEvaluationDao.save(etablissementComiteEtCommissionEvaluation);


}

@Override
public List<EtablissementComiteEtCommissionEvaluation> save(List<EtablissementComiteEtCommissionEvaluation> etablissementComiteEtCommissionEvaluations){
List<EtablissementComiteEtCommissionEvaluation> list = new ArrayList<>();
for(EtablissementComiteEtCommissionEvaluation etablissementComiteEtCommissionEvaluation: etablissementComiteEtCommissionEvaluations){
list.add(save(etablissementComiteEtCommissionEvaluation));
}
return list;
}



@Override
@Transactional
public int delete(EtablissementComiteEtCommissionEvaluation etablissementComiteEtCommissionEvaluation){
    if(etablissementComiteEtCommissionEvaluation.getId()==null) return -1;
    EtablissementComiteEtCommissionEvaluation foundedEtablissementComiteEtCommissionEvaluation = findById(etablissementComiteEtCommissionEvaluation.getId());
    if(foundedEtablissementComiteEtCommissionEvaluation==null) return -1;
etablissementComiteEtCommissionEvaluationDao.delete(foundedEtablissementComiteEtCommissionEvaluation);
return 1;
}


public List<EtablissementComiteEtCommissionEvaluation> findByCriteria(EtablissementComiteEtCommissionEvaluationVo etablissementComiteEtCommissionEvaluationVo){

String query = "SELECT o FROM EtablissementComiteEtCommissionEvaluation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etablissementComiteEtCommissionEvaluationVo.getId());
    if(etablissementComiteEtCommissionEvaluationVo.getEtablissementVo()!=null){
        query += SearchUtil.addConstraint( "o", "etablissement.id","=",etablissementComiteEtCommissionEvaluationVo.getEtablissementVo().getId());
            query += SearchUtil.addConstraint( "o", "etablissement.code","LIKE",etablissementComiteEtCommissionEvaluationVo.getEtablissementVo().getCode());
    }

    if(etablissementComiteEtCommissionEvaluationVo.getComiteEtCommissionEvaluationVo()!=null){
        query += SearchUtil.addConstraint( "o", "comiteEtCommissionEvaluation.id","=",etablissementComiteEtCommissionEvaluationVo.getComiteEtCommissionEvaluationVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findEtablissement(EtablissementComiteEtCommissionEvaluation etablissementComiteEtCommissionEvaluation){
        Etablissement loadedEtablissement =etablissementService.findByIdOrCode(etablissementComiteEtCommissionEvaluation.getEtablissement());

    if(loadedEtablissement==null ) {
    return;
    }
    etablissementComiteEtCommissionEvaluation.setEtablissement(loadedEtablissement);
    }
    private void findComiteEtCommissionEvaluation(EtablissementComiteEtCommissionEvaluation etablissementComiteEtCommissionEvaluation){
        ComiteEtCommissionEvaluation loadedComiteEtCommissionEvaluation = null;
        if(etablissementComiteEtCommissionEvaluation.getComiteEtCommissionEvaluation() != null && etablissementComiteEtCommissionEvaluation.getComiteEtCommissionEvaluation().getId() !=null)
        loadedComiteEtCommissionEvaluation =comiteEtCommissionEvaluationService.findById(etablissementComiteEtCommissionEvaluation.getComiteEtCommissionEvaluation().getId());

    if(loadedComiteEtCommissionEvaluation==null ) {
    return;
    }
    etablissementComiteEtCommissionEvaluation.setComiteEtCommissionEvaluation(loadedComiteEtCommissionEvaluation);
    }

@Override
@Transactional
public void delete(List<EtablissementComiteEtCommissionEvaluation> etablissementComiteEtCommissionEvaluations){
if(ListUtil.isNotEmpty(etablissementComiteEtCommissionEvaluations)){
etablissementComiteEtCommissionEvaluations.forEach(e->etablissementComiteEtCommissionEvaluationDao.delete(e));
}
}
@Override
public void update(List<EtablissementComiteEtCommissionEvaluation> etablissementComiteEtCommissionEvaluations){
if(ListUtil.isNotEmpty(etablissementComiteEtCommissionEvaluations)){
etablissementComiteEtCommissionEvaluations.forEach(e->etablissementComiteEtCommissionEvaluationDao.save(e));
}
}





    }

package com.ird.faa.service.admin.impl.formulaire;

import com.ird.faa.bean.formulaire.ComiteEtCommissionEvaluation;
import com.ird.faa.bean.formulaire.InstrumentIrdComiteEtCommissionEvaluation;
import com.ird.faa.bean.referentiel.InstrumentIrd;
import com.ird.faa.bean.referentiel.TypeInstrumentIrd;
import com.ird.faa.dao.formulaire.InstrumentIrdComiteEtCommissionEvaluationDao;
import com.ird.faa.service.admin.facade.formulaire.ComiteEtCommissionEvaluationAdminService;
import com.ird.faa.service.admin.facade.formulaire.InstrumentIrdAdminService;
import com.ird.faa.service.admin.facade.formulaire.InstrumentIrdComiteEtCommissionEvaluationAdminService;
import com.ird.faa.service.admin.facade.formulaire.TypeInstrumentIrdAdminService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.InstrumentIrdComiteEtCommissionEvaluationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstrumentIrdComiteEtCommissionEvaluationAdminServiceImpl extends AbstractServiceImpl<InstrumentIrdComiteEtCommissionEvaluation> implements InstrumentIrdComiteEtCommissionEvaluationAdminService {

@Autowired
private InstrumentIrdComiteEtCommissionEvaluationDao instrumentIrdComiteEtCommissionEvaluationDao;

        @Autowired
        private TypeInstrumentIrdAdminService typeInstrumentIrdService ;
        @Autowired
        private ComiteEtCommissionEvaluationAdminService comiteEtCommissionEvaluationService ;
        @Autowired
        private InstrumentIrdAdminService instrumentIrdService ;


@Autowired
private EntityManager entityManager;


@Override
public List<InstrumentIrdComiteEtCommissionEvaluation> findAll(){
        return instrumentIrdComiteEtCommissionEvaluationDao.findAll();
}

        @Override
        public List<InstrumentIrdComiteEtCommissionEvaluation> findByInstrumentIrdCode(String code){
        return instrumentIrdComiteEtCommissionEvaluationDao.findByInstrumentIrdCode(code);
        }

        @Override
        @Transactional
        public int deleteByInstrumentIrdCode(String code){
        return instrumentIrdComiteEtCommissionEvaluationDao.deleteByInstrumentIrdCode(code);
        }

        @Override
        public List<InstrumentIrdComiteEtCommissionEvaluation> findByInstrumentIrdId(Long id){
        return instrumentIrdComiteEtCommissionEvaluationDao.findByInstrumentIrdId(id);
        }

        @Override
        @Transactional
        public int deleteByInstrumentIrdId(Long id){
        return instrumentIrdComiteEtCommissionEvaluationDao.deleteByInstrumentIrdId(id);
        }


        @Override
        public List<InstrumentIrdComiteEtCommissionEvaluation> findByTypeInstrumentIrdCode(String code){
        return instrumentIrdComiteEtCommissionEvaluationDao.findByTypeInstrumentIrdCode(code);
        }

        @Override
        @Transactional
        public int deleteByTypeInstrumentIrdCode(String code){
        return instrumentIrdComiteEtCommissionEvaluationDao.deleteByTypeInstrumentIrdCode(code);
        }

        @Override
        public List<InstrumentIrdComiteEtCommissionEvaluation> findByTypeInstrumentIrdId(Long id){
        return instrumentIrdComiteEtCommissionEvaluationDao.findByTypeInstrumentIrdId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeInstrumentIrdId(Long id){
        return instrumentIrdComiteEtCommissionEvaluationDao.deleteByTypeInstrumentIrdId(id);
        }

        @Override
        public List<InstrumentIrdComiteEtCommissionEvaluation> findByComiteEtCommissionEvaluationId(Long id){
        return instrumentIrdComiteEtCommissionEvaluationDao.findByComiteEtCommissionEvaluationId(id);
        }

        @Override
        @Transactional
        public int deleteByComiteEtCommissionEvaluationId(Long id){
        return instrumentIrdComiteEtCommissionEvaluationDao.deleteByComiteEtCommissionEvaluationId(id);
        }


@Override
public InstrumentIrdComiteEtCommissionEvaluation findById(Long id){
if(id==null) return null;
return instrumentIrdComiteEtCommissionEvaluationDao.getOne(id);
}

@Override
public InstrumentIrdComiteEtCommissionEvaluation findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(instrumentIrdComiteEtCommissionEvaluationDao.findById(id).isPresent())  {
instrumentIrdComiteEtCommissionEvaluationDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public InstrumentIrdComiteEtCommissionEvaluation update(InstrumentIrdComiteEtCommissionEvaluation instrumentIrdComiteEtCommissionEvaluation){
InstrumentIrdComiteEtCommissionEvaluation foundedInstrumentIrdComiteEtCommissionEvaluation = findById(instrumentIrdComiteEtCommissionEvaluation.getId());
if(foundedInstrumentIrdComiteEtCommissionEvaluation==null) return null;
else{
return  instrumentIrdComiteEtCommissionEvaluationDao.save(instrumentIrdComiteEtCommissionEvaluation);
}
}

@Override
public InstrumentIrdComiteEtCommissionEvaluation save (InstrumentIrdComiteEtCommissionEvaluation instrumentIrdComiteEtCommissionEvaluation){



    findInstrumentIrd(instrumentIrdComiteEtCommissionEvaluation);
    findTypeInstrumentIrd(instrumentIrdComiteEtCommissionEvaluation);
    findComiteEtCommissionEvaluation(instrumentIrdComiteEtCommissionEvaluation);

    return instrumentIrdComiteEtCommissionEvaluationDao.save(instrumentIrdComiteEtCommissionEvaluation);


}

@Override
public List<InstrumentIrdComiteEtCommissionEvaluation> save(List<InstrumentIrdComiteEtCommissionEvaluation> instrumentIrdComiteEtCommissionEvaluations){
List<InstrumentIrdComiteEtCommissionEvaluation> list = new ArrayList<>();
for(InstrumentIrdComiteEtCommissionEvaluation instrumentIrdComiteEtCommissionEvaluation: instrumentIrdComiteEtCommissionEvaluations){
list.add(save(instrumentIrdComiteEtCommissionEvaluation));
}
return list;
}



@Override
@Transactional
public int delete(InstrumentIrdComiteEtCommissionEvaluation instrumentIrdComiteEtCommissionEvaluation){
    if(instrumentIrdComiteEtCommissionEvaluation.getId()==null) return -1;
    InstrumentIrdComiteEtCommissionEvaluation foundedInstrumentIrdComiteEtCommissionEvaluation = findById(instrumentIrdComiteEtCommissionEvaluation.getId());
    if(foundedInstrumentIrdComiteEtCommissionEvaluation==null) return -1;
instrumentIrdComiteEtCommissionEvaluationDao.delete(foundedInstrumentIrdComiteEtCommissionEvaluation);
return 1;
}


public List<InstrumentIrdComiteEtCommissionEvaluation> findByCriteria(InstrumentIrdComiteEtCommissionEvaluationVo instrumentIrdComiteEtCommissionEvaluationVo){

String query = "SELECT o FROM InstrumentIrdComiteEtCommissionEvaluation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",instrumentIrdComiteEtCommissionEvaluationVo.getId());
    if(instrumentIrdComiteEtCommissionEvaluationVo.getInstrumentIrdVo()!=null){
        query += SearchUtil.addConstraint( "o", "instrumentIrd.id","=",instrumentIrdComiteEtCommissionEvaluationVo.getInstrumentIrdVo().getId());
            query += SearchUtil.addConstraint( "o", "instrumentIrd.code","LIKE",instrumentIrdComiteEtCommissionEvaluationVo.getInstrumentIrdVo().getCode());
    }

    if(instrumentIrdComiteEtCommissionEvaluationVo.getTypeInstrumentIrdVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeInstrumentIrd.id","=",instrumentIrdComiteEtCommissionEvaluationVo.getTypeInstrumentIrdVo().getId());
            query += SearchUtil.addConstraint( "o", "typeInstrumentIrd.code","LIKE",instrumentIrdComiteEtCommissionEvaluationVo.getTypeInstrumentIrdVo().getCode());
    }

    if(instrumentIrdComiteEtCommissionEvaluationVo.getComiteEtCommissionEvaluationVo()!=null){
        query += SearchUtil.addConstraint( "o", "comiteEtCommissionEvaluation.id","=",instrumentIrdComiteEtCommissionEvaluationVo.getComiteEtCommissionEvaluationVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findInstrumentIrd(InstrumentIrdComiteEtCommissionEvaluation instrumentIrdComiteEtCommissionEvaluation){
        InstrumentIrd loadedInstrumentIrd =instrumentIrdService.findByIdOrCode(instrumentIrdComiteEtCommissionEvaluation.getInstrumentIrd());

    if(loadedInstrumentIrd==null ) {
    return;
    }
    instrumentIrdComiteEtCommissionEvaluation.setInstrumentIrd(loadedInstrumentIrd);
    }
    private void findTypeInstrumentIrd(InstrumentIrdComiteEtCommissionEvaluation instrumentIrdComiteEtCommissionEvaluation){
        TypeInstrumentIrd loadedTypeInstrumentIrd =typeInstrumentIrdService.findByIdOrCode(instrumentIrdComiteEtCommissionEvaluation.getTypeInstrumentIrd());

    if(loadedTypeInstrumentIrd==null ) {
    return;
    }
    instrumentIrdComiteEtCommissionEvaluation.setTypeInstrumentIrd(loadedTypeInstrumentIrd);
    }
    private void findComiteEtCommissionEvaluation(InstrumentIrdComiteEtCommissionEvaluation instrumentIrdComiteEtCommissionEvaluation){
        ComiteEtCommissionEvaluation loadedComiteEtCommissionEvaluation = null;
        if(instrumentIrdComiteEtCommissionEvaluation.getComiteEtCommissionEvaluation() != null && instrumentIrdComiteEtCommissionEvaluation.getComiteEtCommissionEvaluation().getId() !=null)
        loadedComiteEtCommissionEvaluation =comiteEtCommissionEvaluationService.findById(instrumentIrdComiteEtCommissionEvaluation.getComiteEtCommissionEvaluation().getId());

    if(loadedComiteEtCommissionEvaluation==null ) {
    return;
    }
    instrumentIrdComiteEtCommissionEvaluation.setComiteEtCommissionEvaluation(loadedComiteEtCommissionEvaluation);
    }

@Override
@Transactional
public void delete(List<InstrumentIrdComiteEtCommissionEvaluation> instrumentIrdComiteEtCommissionEvaluations){
if(ListUtil.isNotEmpty(instrumentIrdComiteEtCommissionEvaluations)){
instrumentIrdComiteEtCommissionEvaluations.forEach(e->instrumentIrdComiteEtCommissionEvaluationDao.delete(e));
}
}
@Override
public void update(List<InstrumentIrdComiteEtCommissionEvaluation> instrumentIrdComiteEtCommissionEvaluations){
if(ListUtil.isNotEmpty(instrumentIrdComiteEtCommissionEvaluations)){
instrumentIrdComiteEtCommissionEvaluations.forEach(e->instrumentIrdComiteEtCommissionEvaluationDao.save(e));
}
}





    }

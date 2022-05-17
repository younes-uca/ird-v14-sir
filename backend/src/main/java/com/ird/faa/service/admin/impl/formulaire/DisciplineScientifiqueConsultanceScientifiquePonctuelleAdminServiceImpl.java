package com.ird.faa.service.admin.impl.formulaire;

import com.ird.faa.bean.formulaire.ConsultanceScientifiquePonctuelle;
import com.ird.faa.bean.formulaire.DisciplineScientifique;
import com.ird.faa.bean.formulaire.DisciplineScientifiqueConsultanceScientifiquePonctuelle;
import com.ird.faa.dao.formulaire.DisciplineScientifiqueConsultanceScientifiquePonctuelleDao;
import com.ird.faa.service.admin.facade.formulaire.ConsultanceScientifiquePonctuelleAdminService;
import com.ird.faa.service.admin.facade.formulaire.DisciplineScientifiqueAdminService;
import com.ird.faa.service.admin.facade.formulaire.DisciplineScientifiqueConsultanceScientifiquePonctuelleAdminService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueConsultanceScientifiquePonctuelleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplineScientifiqueConsultanceScientifiquePonctuelleAdminServiceImpl extends AbstractServiceImpl<DisciplineScientifiqueConsultanceScientifiquePonctuelle> implements DisciplineScientifiqueConsultanceScientifiquePonctuelleAdminService {

@Autowired
private DisciplineScientifiqueConsultanceScientifiquePonctuelleDao disciplineScientifiqueConsultanceScientifiquePonctuelleDao;

        @Autowired
        private ConsultanceScientifiquePonctuelleAdminService consultanceScientifiquePonctuelleService ;
        @Autowired
        private DisciplineScientifiqueAdminService disciplineScientifiqueService ;


@Autowired
private EntityManager entityManager;


@Override
public List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> findAll(){
        return disciplineScientifiqueConsultanceScientifiquePonctuelleDao.findAll();
}
        @Override
        public List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> findByConsultanceScientifiquePonctuelleId(Long id){
        return disciplineScientifiqueConsultanceScientifiquePonctuelleDao.findByConsultanceScientifiquePonctuelleId(id);
        }

        @Override
        @Transactional
        public int deleteByConsultanceScientifiquePonctuelleId(Long id){
        return disciplineScientifiqueConsultanceScientifiquePonctuelleDao.deleteByConsultanceScientifiquePonctuelleId(id);
        }


        @Override
        public List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> findByDisciplineScientifiqueCode(String code){
        return disciplineScientifiqueConsultanceScientifiquePonctuelleDao.findByDisciplineScientifiqueCode(code);
        }

        @Override
        @Transactional
        public int deleteByDisciplineScientifiqueCode(String code){
        return disciplineScientifiqueConsultanceScientifiquePonctuelleDao.deleteByDisciplineScientifiqueCode(code);
        }

        @Override
        public List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> findByDisciplineScientifiqueId(Long id){
        return disciplineScientifiqueConsultanceScientifiquePonctuelleDao.findByDisciplineScientifiqueId(id);
        }

        @Override
        @Transactional
        public int deleteByDisciplineScientifiqueId(Long id){
        return disciplineScientifiqueConsultanceScientifiquePonctuelleDao.deleteByDisciplineScientifiqueId(id);
        }


@Override
public DisciplineScientifiqueConsultanceScientifiquePonctuelle findById(Long id){
if(id==null) return null;
return disciplineScientifiqueConsultanceScientifiquePonctuelleDao.getOne(id);
}

@Override
public DisciplineScientifiqueConsultanceScientifiquePonctuelle findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(disciplineScientifiqueConsultanceScientifiquePonctuelleDao.findById(id).isPresent())  {
disciplineScientifiqueConsultanceScientifiquePonctuelleDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public DisciplineScientifiqueConsultanceScientifiquePonctuelle update(DisciplineScientifiqueConsultanceScientifiquePonctuelle disciplineScientifiqueConsultanceScientifiquePonctuelle){
DisciplineScientifiqueConsultanceScientifiquePonctuelle foundedDisciplineScientifiqueConsultanceScientifiquePonctuelle = findById(disciplineScientifiqueConsultanceScientifiquePonctuelle.getId());
if(foundedDisciplineScientifiqueConsultanceScientifiquePonctuelle==null) return null;
else{
return  disciplineScientifiqueConsultanceScientifiquePonctuelleDao.save(disciplineScientifiqueConsultanceScientifiquePonctuelle);
}
}

@Override
public DisciplineScientifiqueConsultanceScientifiquePonctuelle save (DisciplineScientifiqueConsultanceScientifiquePonctuelle disciplineScientifiqueConsultanceScientifiquePonctuelle){



    findConsultanceScientifiquePonctuelle(disciplineScientifiqueConsultanceScientifiquePonctuelle);
    findDisciplineScientifique(disciplineScientifiqueConsultanceScientifiquePonctuelle);

    return disciplineScientifiqueConsultanceScientifiquePonctuelleDao.save(disciplineScientifiqueConsultanceScientifiquePonctuelle);


}

@Override
public List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> save(List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> disciplineScientifiqueConsultanceScientifiquePonctuelles){
List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> list = new ArrayList<>();
for(DisciplineScientifiqueConsultanceScientifiquePonctuelle disciplineScientifiqueConsultanceScientifiquePonctuelle: disciplineScientifiqueConsultanceScientifiquePonctuelles){
list.add(save(disciplineScientifiqueConsultanceScientifiquePonctuelle));
}
return list;
}



@Override
@Transactional
public int delete(DisciplineScientifiqueConsultanceScientifiquePonctuelle disciplineScientifiqueConsultanceScientifiquePonctuelle){
    if(disciplineScientifiqueConsultanceScientifiquePonctuelle.getId()==null) return -1;
    DisciplineScientifiqueConsultanceScientifiquePonctuelle foundedDisciplineScientifiqueConsultanceScientifiquePonctuelle = findById(disciplineScientifiqueConsultanceScientifiquePonctuelle.getId());
    if(foundedDisciplineScientifiqueConsultanceScientifiquePonctuelle==null) return -1;
disciplineScientifiqueConsultanceScientifiquePonctuelleDao.delete(foundedDisciplineScientifiqueConsultanceScientifiquePonctuelle);
return 1;
}


public List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> findByCriteria(DisciplineScientifiqueConsultanceScientifiquePonctuelleVo disciplineScientifiqueConsultanceScientifiquePonctuelleVo){

String query = "SELECT o FROM DisciplineScientifiqueConsultanceScientifiquePonctuelle o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",disciplineScientifiqueConsultanceScientifiquePonctuelleVo.getId());
    if(disciplineScientifiqueConsultanceScientifiquePonctuelleVo.getConsultanceScientifiquePonctuelleVo()!=null){
        query += SearchUtil.addConstraint( "o", "consultanceScientifiquePonctuelle.id","=",disciplineScientifiqueConsultanceScientifiquePonctuelleVo.getConsultanceScientifiquePonctuelleVo().getId());
    }

    if(disciplineScientifiqueConsultanceScientifiquePonctuelleVo.getDisciplineScientifiqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "disciplineScientifique.id","=",disciplineScientifiqueConsultanceScientifiquePonctuelleVo.getDisciplineScientifiqueVo().getId());
            query += SearchUtil.addConstraint( "o", "disciplineScientifique.code","LIKE",disciplineScientifiqueConsultanceScientifiquePonctuelleVo.getDisciplineScientifiqueVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findConsultanceScientifiquePonctuelle(DisciplineScientifiqueConsultanceScientifiquePonctuelle disciplineScientifiqueConsultanceScientifiquePonctuelle){
        ConsultanceScientifiquePonctuelle loadedConsultanceScientifiquePonctuelle = null;
        if(disciplineScientifiqueConsultanceScientifiquePonctuelle.getConsultanceScientifiquePonctuelle() != null && disciplineScientifiqueConsultanceScientifiquePonctuelle.getConsultanceScientifiquePonctuelle().getId() !=null)
        loadedConsultanceScientifiquePonctuelle =consultanceScientifiquePonctuelleService.findById(disciplineScientifiqueConsultanceScientifiquePonctuelle.getConsultanceScientifiquePonctuelle().getId());

    if(loadedConsultanceScientifiquePonctuelle==null ) {
    return;
    }
    disciplineScientifiqueConsultanceScientifiquePonctuelle.setConsultanceScientifiquePonctuelle(loadedConsultanceScientifiquePonctuelle);
    }
    private void findDisciplineScientifique(DisciplineScientifiqueConsultanceScientifiquePonctuelle disciplineScientifiqueConsultanceScientifiquePonctuelle){
        DisciplineScientifique loadedDisciplineScientifique =disciplineScientifiqueService.findByIdOrCode(disciplineScientifiqueConsultanceScientifiquePonctuelle.getDisciplineScientifique());

    if(loadedDisciplineScientifique==null ) {
    return;
    }
    disciplineScientifiqueConsultanceScientifiquePonctuelle.setDisciplineScientifique(loadedDisciplineScientifique);
    }

@Override
@Transactional
public void delete(List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> disciplineScientifiqueConsultanceScientifiquePonctuelles){
if(ListUtil.isNotEmpty(disciplineScientifiqueConsultanceScientifiquePonctuelles)){
disciplineScientifiqueConsultanceScientifiquePonctuelles.forEach(e->disciplineScientifiqueConsultanceScientifiquePonctuelleDao.delete(e));
}
}
@Override
public void update(List<DisciplineScientifiqueConsultanceScientifiquePonctuelle> disciplineScientifiqueConsultanceScientifiquePonctuelles){
if(ListUtil.isNotEmpty(disciplineScientifiqueConsultanceScientifiquePonctuelles)){
disciplineScientifiqueConsultanceScientifiquePonctuelles.forEach(e->disciplineScientifiqueConsultanceScientifiquePonctuelleDao.save(e));
}
}





    }

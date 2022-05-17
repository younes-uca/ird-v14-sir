package com.ird.faa.service.chercheur.impl.formulaire;

import com.ird.faa.bean.formulaire.ConsultanceScientifiquePonctuelle;
import com.ird.faa.bean.formulaire.InstrumentIrdConsultanceScientifiquePonctuelle;
import com.ird.faa.bean.referentiel.InstrumentIrd;
import com.ird.faa.dao.formulaire.InstrumentIrdConsultanceScientifiquePonctuelleDao;
import com.ird.faa.service.chercheur.facade.formulaire.ConsultanceScientifiquePonctuelleChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.InstrumentIrdChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.InstrumentIrdConsultanceScientifiquePonctuelleChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.InstrumentIrdConsultanceScientifiquePonctuelleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstrumentIrdConsultanceScientifiquePonctuelleChercheurServiceImpl extends AbstractServiceImpl<InstrumentIrdConsultanceScientifiquePonctuelle> implements InstrumentIrdConsultanceScientifiquePonctuelleChercheurService {

@Autowired
private InstrumentIrdConsultanceScientifiquePonctuelleDao instrumentIrdConsultanceScientifiquePonctuelleDao;

        @Autowired
        private ConsultanceScientifiquePonctuelleChercheurService consultanceScientifiquePonctuelleService ;
        @Autowired
        private InstrumentIrdChercheurService instrumentIrdService ;


@Autowired
private EntityManager entityManager;


@Override
public List<InstrumentIrdConsultanceScientifiquePonctuelle> findAll(){
        return instrumentIrdConsultanceScientifiquePonctuelleDao.findAll();
}
        @Override
        public List<InstrumentIrdConsultanceScientifiquePonctuelle> findByConsultanceScientifiquePonctuelleId(Long id){
        return instrumentIrdConsultanceScientifiquePonctuelleDao.findByConsultanceScientifiquePonctuelleId(id);
        }

        @Override
        @Transactional
        public int deleteByConsultanceScientifiquePonctuelleId(Long id){
        return instrumentIrdConsultanceScientifiquePonctuelleDao.deleteByConsultanceScientifiquePonctuelleId(id);
        }


        @Override
        public List<InstrumentIrdConsultanceScientifiquePonctuelle> findByInstrumentIrdCode(String code){
        return instrumentIrdConsultanceScientifiquePonctuelleDao.findByInstrumentIrdCode(code);
        }

        @Override
        @Transactional
        public int deleteByInstrumentIrdCode(String code){
        return instrumentIrdConsultanceScientifiquePonctuelleDao.deleteByInstrumentIrdCode(code);
        }

        @Override
        public List<InstrumentIrdConsultanceScientifiquePonctuelle> findByInstrumentIrdId(Long id){
        return instrumentIrdConsultanceScientifiquePonctuelleDao.findByInstrumentIrdId(id);
        }

        @Override
        @Transactional
        public int deleteByInstrumentIrdId(Long id){
        return instrumentIrdConsultanceScientifiquePonctuelleDao.deleteByInstrumentIrdId(id);
        }


@Override
public InstrumentIrdConsultanceScientifiquePonctuelle findById(Long id){
if(id==null) return null;
return instrumentIrdConsultanceScientifiquePonctuelleDao.getOne(id);
}

@Override
public InstrumentIrdConsultanceScientifiquePonctuelle findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(instrumentIrdConsultanceScientifiquePonctuelleDao.findById(id).isPresent())  {
instrumentIrdConsultanceScientifiquePonctuelleDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public InstrumentIrdConsultanceScientifiquePonctuelle update(InstrumentIrdConsultanceScientifiquePonctuelle instrumentIrdConsultanceScientifiquePonctuelle){
InstrumentIrdConsultanceScientifiquePonctuelle foundedInstrumentIrdConsultanceScientifiquePonctuelle = findById(instrumentIrdConsultanceScientifiquePonctuelle.getId());
if(foundedInstrumentIrdConsultanceScientifiquePonctuelle==null) return null;
else{
return  instrumentIrdConsultanceScientifiquePonctuelleDao.save(instrumentIrdConsultanceScientifiquePonctuelle);
}
}
    private void prepareSave(InstrumentIrdConsultanceScientifiquePonctuelle instrumentIrdConsultanceScientifiquePonctuelle){
                    if(instrumentIrdConsultanceScientifiquePonctuelle.getExiste() == null)
                instrumentIrdConsultanceScientifiquePonctuelle.setExiste(false);




    }

@Override
public InstrumentIrdConsultanceScientifiquePonctuelle save (InstrumentIrdConsultanceScientifiquePonctuelle instrumentIrdConsultanceScientifiquePonctuelle){
    prepareSave(instrumentIrdConsultanceScientifiquePonctuelle);



    findConsultanceScientifiquePonctuelle(instrumentIrdConsultanceScientifiquePonctuelle);
    findInstrumentIrd(instrumentIrdConsultanceScientifiquePonctuelle);

    return instrumentIrdConsultanceScientifiquePonctuelleDao.save(instrumentIrdConsultanceScientifiquePonctuelle);


}

@Override
public List<InstrumentIrdConsultanceScientifiquePonctuelle> save(List<InstrumentIrdConsultanceScientifiquePonctuelle> instrumentIrdConsultanceScientifiquePonctuelles){
List<InstrumentIrdConsultanceScientifiquePonctuelle> list = new ArrayList<>();
for(InstrumentIrdConsultanceScientifiquePonctuelle instrumentIrdConsultanceScientifiquePonctuelle: instrumentIrdConsultanceScientifiquePonctuelles){
list.add(save(instrumentIrdConsultanceScientifiquePonctuelle));
}
return list;
}



@Override
@Transactional
public int delete(InstrumentIrdConsultanceScientifiquePonctuelle instrumentIrdConsultanceScientifiquePonctuelle){
    if(instrumentIrdConsultanceScientifiquePonctuelle.getId()==null) return -1;
    InstrumentIrdConsultanceScientifiquePonctuelle foundedInstrumentIrdConsultanceScientifiquePonctuelle = findById(instrumentIrdConsultanceScientifiquePonctuelle.getId());
    if(foundedInstrumentIrdConsultanceScientifiquePonctuelle==null) return -1;
instrumentIrdConsultanceScientifiquePonctuelleDao.delete(foundedInstrumentIrdConsultanceScientifiquePonctuelle);
return 1;
}


public List<InstrumentIrdConsultanceScientifiquePonctuelle> findByCriteria(InstrumentIrdConsultanceScientifiquePonctuelleVo instrumentIrdConsultanceScientifiquePonctuelleVo){

String query = "SELECT o FROM InstrumentIrdConsultanceScientifiquePonctuelle o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",instrumentIrdConsultanceScientifiquePonctuelleVo.getId());
            query += SearchUtil.addConstraint( "o", "existe","=",instrumentIrdConsultanceScientifiquePonctuelleVo.getExiste());
    if(instrumentIrdConsultanceScientifiquePonctuelleVo.getConsultanceScientifiquePonctuelleVo()!=null){
        query += SearchUtil.addConstraint( "o", "consultanceScientifiquePonctuelle.id","=",instrumentIrdConsultanceScientifiquePonctuelleVo.getConsultanceScientifiquePonctuelleVo().getId());
    }

    if(instrumentIrdConsultanceScientifiquePonctuelleVo.getInstrumentIrdVo()!=null){
        query += SearchUtil.addConstraint( "o", "instrumentIrd.id","=",instrumentIrdConsultanceScientifiquePonctuelleVo.getInstrumentIrdVo().getId());
            query += SearchUtil.addConstraint( "o", "instrumentIrd.code","LIKE",instrumentIrdConsultanceScientifiquePonctuelleVo.getInstrumentIrdVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findConsultanceScientifiquePonctuelle(InstrumentIrdConsultanceScientifiquePonctuelle instrumentIrdConsultanceScientifiquePonctuelle){
        ConsultanceScientifiquePonctuelle loadedConsultanceScientifiquePonctuelle = null;
        if(instrumentIrdConsultanceScientifiquePonctuelle.getConsultanceScientifiquePonctuelle() != null && instrumentIrdConsultanceScientifiquePonctuelle.getConsultanceScientifiquePonctuelle().getId() !=null)
        loadedConsultanceScientifiquePonctuelle =consultanceScientifiquePonctuelleService.findById(instrumentIrdConsultanceScientifiquePonctuelle.getConsultanceScientifiquePonctuelle().getId());

    if(loadedConsultanceScientifiquePonctuelle==null ) {
    return;
    }
    instrumentIrdConsultanceScientifiquePonctuelle.setConsultanceScientifiquePonctuelle(loadedConsultanceScientifiquePonctuelle);
    }
    private void findInstrumentIrd(InstrumentIrdConsultanceScientifiquePonctuelle instrumentIrdConsultanceScientifiquePonctuelle){
        InstrumentIrd loadedInstrumentIrd =instrumentIrdService.findByIdOrCode(instrumentIrdConsultanceScientifiquePonctuelle.getInstrumentIrd());

    if(loadedInstrumentIrd==null ) {
    return;
    }
    instrumentIrdConsultanceScientifiquePonctuelle.setInstrumentIrd(loadedInstrumentIrd);
    }

@Override
@Transactional
public void delete(List<InstrumentIrdConsultanceScientifiquePonctuelle> instrumentIrdConsultanceScientifiquePonctuelles){
if(ListUtil.isNotEmpty(instrumentIrdConsultanceScientifiquePonctuelles)){
instrumentIrdConsultanceScientifiquePonctuelles.forEach(e->instrumentIrdConsultanceScientifiquePonctuelleDao.delete(e));
}
}
@Override
public void update(List<InstrumentIrdConsultanceScientifiquePonctuelle> instrumentIrdConsultanceScientifiquePonctuelles){
if(ListUtil.isNotEmpty(instrumentIrdConsultanceScientifiquePonctuelles)){
instrumentIrdConsultanceScientifiquePonctuelles.forEach(e->instrumentIrdConsultanceScientifiquePonctuelleDao.save(e));
}
}





    }

package com.ird.faa.service.admin.impl.formulaire;

import com.ird.faa.bean.formulaire.PaysZoneGeographique;
import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.referentiel.ZoneGeographique;
import com.ird.faa.dao.formulaire.PaysZoneGeographiqueDao;
import com.ird.faa.service.admin.facade.formulaire.PaysAdminService;
import com.ird.faa.service.admin.facade.formulaire.PaysZoneGeographiqueAdminService;
import com.ird.faa.service.admin.facade.formulaire.ZoneGeographiqueAdminService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.PaysZoneGeographiqueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaysZoneGeographiqueAdminServiceImpl extends AbstractServiceImpl<PaysZoneGeographique> implements PaysZoneGeographiqueAdminService {

@Autowired
private PaysZoneGeographiqueDao paysZoneGeographiqueDao;

        @Autowired
        private ZoneGeographiqueAdminService zoneGeographiqueService ;
        @Autowired
        private PaysAdminService paysService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PaysZoneGeographique> findAll(){
        return paysZoneGeographiqueDao.findAll();
}

        @Override
        public List<PaysZoneGeographique> findByPaysCode(String code){
        return paysZoneGeographiqueDao.findByPaysCode(code);
        }

        @Override
        @Transactional
        public int deleteByPaysCode(String code){
        return paysZoneGeographiqueDao.deleteByPaysCode(code);
        }

        @Override
        public List<PaysZoneGeographique> findByPaysId(Long id){
        return paysZoneGeographiqueDao.findByPaysId(id);
        }

        @Override
        @Transactional
        public int deleteByPaysId(Long id){
        return paysZoneGeographiqueDao.deleteByPaysId(id);
        }


        @Override
        public List<PaysZoneGeographique> findByZoneGeographiqueCode(String code){
        return paysZoneGeographiqueDao.findByZoneGeographiqueCode(code);
        }

        @Override
        @Transactional
        public int deleteByZoneGeographiqueCode(String code){
        return paysZoneGeographiqueDao.deleteByZoneGeographiqueCode(code);
        }

        @Override
        public List<PaysZoneGeographique> findByZoneGeographiqueId(Long id){
        return paysZoneGeographiqueDao.findByZoneGeographiqueId(id);
        }

        @Override
        @Transactional
        public int deleteByZoneGeographiqueId(Long id){
        return paysZoneGeographiqueDao.deleteByZoneGeographiqueId(id);
        }


@Override
public PaysZoneGeographique findById(Long id){
if(id==null) return null;
return paysZoneGeographiqueDao.getOne(id);
}

@Override
public PaysZoneGeographique findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(paysZoneGeographiqueDao.findById(id).isPresent())  {
paysZoneGeographiqueDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PaysZoneGeographique update(PaysZoneGeographique paysZoneGeographique){
PaysZoneGeographique foundedPaysZoneGeographique = findById(paysZoneGeographique.getId());
if(foundedPaysZoneGeographique==null) return null;
else{
return  paysZoneGeographiqueDao.save(paysZoneGeographique);
}
}

@Override
public PaysZoneGeographique save (PaysZoneGeographique paysZoneGeographique){



    findPays(paysZoneGeographique);
    findZoneGeographique(paysZoneGeographique);

    return paysZoneGeographiqueDao.save(paysZoneGeographique);


}

@Override
public List<PaysZoneGeographique> save(List<PaysZoneGeographique> paysZoneGeographiques){
List<PaysZoneGeographique> list = new ArrayList<>();
for(PaysZoneGeographique paysZoneGeographique: paysZoneGeographiques){
list.add(save(paysZoneGeographique));
}
return list;
}



@Override
@Transactional
public int delete(PaysZoneGeographique paysZoneGeographique){
    if(paysZoneGeographique.getId()==null) return -1;
    PaysZoneGeographique foundedPaysZoneGeographique = findById(paysZoneGeographique.getId());
    if(foundedPaysZoneGeographique==null) return -1;
paysZoneGeographiqueDao.delete(foundedPaysZoneGeographique);
return 1;
}


public List<PaysZoneGeographique> findByCriteria(PaysZoneGeographiqueVo paysZoneGeographiqueVo){

String query = "SELECT o FROM PaysZoneGeographique o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",paysZoneGeographiqueVo.getId());
    if(paysZoneGeographiqueVo.getPaysVo()!=null){
        query += SearchUtil.addConstraint( "o", "pays.id","=",paysZoneGeographiqueVo.getPaysVo().getId());
            query += SearchUtil.addConstraint( "o", "pays.code","LIKE",paysZoneGeographiqueVo.getPaysVo().getCode());
    }

    if(paysZoneGeographiqueVo.getZoneGeographiqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "zoneGeographique.id","=",paysZoneGeographiqueVo.getZoneGeographiqueVo().getId());
            query += SearchUtil.addConstraint( "o", "zoneGeographique.code","LIKE",paysZoneGeographiqueVo.getZoneGeographiqueVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findPays(PaysZoneGeographique paysZoneGeographique){
        Pays loadedPays =paysService.findByIdOrCode(paysZoneGeographique.getPays());

    if(loadedPays==null ) {
    return;
    }
    paysZoneGeographique.setPays(loadedPays);
    }
    private void findZoneGeographique(PaysZoneGeographique paysZoneGeographique){
        ZoneGeographique loadedZoneGeographique =zoneGeographiqueService.findByIdOrCode(paysZoneGeographique.getZoneGeographique());

    if(loadedZoneGeographique==null ) {
    return;
    }
    paysZoneGeographique.setZoneGeographique(loadedZoneGeographique);
    }

@Override
@Transactional
public void delete(List<PaysZoneGeographique> paysZoneGeographiques){
if(ListUtil.isNotEmpty(paysZoneGeographiques)){
paysZoneGeographiques.forEach(e->paysZoneGeographiqueDao.delete(e));
}
}
@Override
public void update(List<PaysZoneGeographique> paysZoneGeographiques){
if(ListUtil.isNotEmpty(paysZoneGeographiques)){
paysZoneGeographiques.forEach(e->paysZoneGeographiqueDao.save(e));
}
}





    }

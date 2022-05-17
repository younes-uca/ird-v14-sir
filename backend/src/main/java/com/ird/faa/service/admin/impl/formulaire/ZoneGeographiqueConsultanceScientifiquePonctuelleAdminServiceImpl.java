package com.ird.faa.service.admin.impl.formulaire;

import com.ird.faa.bean.formulaire.ConsultanceScientifiquePonctuelle;
import com.ird.faa.bean.formulaire.ZoneGeographiqueConsultanceScientifiquePonctuelle;
import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.referentiel.ZoneGeographique;
import com.ird.faa.dao.formulaire.ZoneGeographiqueConsultanceScientifiquePonctuelleDao;
import com.ird.faa.service.admin.facade.formulaire.ConsultanceScientifiquePonctuelleAdminService;
import com.ird.faa.service.admin.facade.formulaire.PaysAdminService;
import com.ird.faa.service.admin.facade.formulaire.ZoneGeographiqueAdminService;
import com.ird.faa.service.admin.facade.formulaire.ZoneGeographiqueConsultanceScientifiquePonctuelleAdminService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.ZoneGeographiqueConsultanceScientifiquePonctuelleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ZoneGeographiqueConsultanceScientifiquePonctuelleAdminServiceImpl extends AbstractServiceImpl<ZoneGeographiqueConsultanceScientifiquePonctuelle> implements ZoneGeographiqueConsultanceScientifiquePonctuelleAdminService {

@Autowired
private ZoneGeographiqueConsultanceScientifiquePonctuelleDao zoneGeographiqueConsultanceScientifiquePonctuelleDao;

        @Autowired
        private ConsultanceScientifiquePonctuelleAdminService consultanceScientifiquePonctuelleService ;
        @Autowired
        private ZoneGeographiqueAdminService zoneGeographiqueService ;
        @Autowired
        private PaysAdminService paysService ;


@Autowired
private EntityManager entityManager;


@Override
public List<ZoneGeographiqueConsultanceScientifiquePonctuelle> findAll(){
        return zoneGeographiqueConsultanceScientifiquePonctuelleDao.findAll();
}
        @Override
        public List<ZoneGeographiqueConsultanceScientifiquePonctuelle> findByConsultanceScientifiquePonctuelleId(Long id){
        return zoneGeographiqueConsultanceScientifiquePonctuelleDao.findByConsultanceScientifiquePonctuelleId(id);
        }

        @Override
        @Transactional
        public int deleteByConsultanceScientifiquePonctuelleId(Long id){
        return zoneGeographiqueConsultanceScientifiquePonctuelleDao.deleteByConsultanceScientifiquePonctuelleId(id);
        }


        @Override
        public List<ZoneGeographiqueConsultanceScientifiquePonctuelle> findByZoneGeographiqueCode(String code){
        return zoneGeographiqueConsultanceScientifiquePonctuelleDao.findByZoneGeographiqueCode(code);
        }

        @Override
        @Transactional
        public int deleteByZoneGeographiqueCode(String code){
        return zoneGeographiqueConsultanceScientifiquePonctuelleDao.deleteByZoneGeographiqueCode(code);
        }

        @Override
        public List<ZoneGeographiqueConsultanceScientifiquePonctuelle> findByZoneGeographiqueId(Long id){
        return zoneGeographiqueConsultanceScientifiquePonctuelleDao.findByZoneGeographiqueId(id);
        }

        @Override
        @Transactional
        public int deleteByZoneGeographiqueId(Long id){
        return zoneGeographiqueConsultanceScientifiquePonctuelleDao.deleteByZoneGeographiqueId(id);
        }


        @Override
        public List<ZoneGeographiqueConsultanceScientifiquePonctuelle> findByPaysCode(String code){
        return zoneGeographiqueConsultanceScientifiquePonctuelleDao.findByPaysCode(code);
        }

        @Override
        @Transactional
        public int deleteByPaysCode(String code){
        return zoneGeographiqueConsultanceScientifiquePonctuelleDao.deleteByPaysCode(code);
        }

        @Override
        public List<ZoneGeographiqueConsultanceScientifiquePonctuelle> findByPaysId(Long id){
        return zoneGeographiqueConsultanceScientifiquePonctuelleDao.findByPaysId(id);
        }

        @Override
        @Transactional
        public int deleteByPaysId(Long id){
        return zoneGeographiqueConsultanceScientifiquePonctuelleDao.deleteByPaysId(id);
        }


@Override
public ZoneGeographiqueConsultanceScientifiquePonctuelle findById(Long id){
if(id==null) return null;
return zoneGeographiqueConsultanceScientifiquePonctuelleDao.getOne(id);
}

@Override
public ZoneGeographiqueConsultanceScientifiquePonctuelle findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(zoneGeographiqueConsultanceScientifiquePonctuelleDao.findById(id).isPresent())  {
zoneGeographiqueConsultanceScientifiquePonctuelleDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public ZoneGeographiqueConsultanceScientifiquePonctuelle update(ZoneGeographiqueConsultanceScientifiquePonctuelle zoneGeographiqueConsultanceScientifiquePonctuelle){
ZoneGeographiqueConsultanceScientifiquePonctuelle foundedZoneGeographiqueConsultanceScientifiquePonctuelle = findById(zoneGeographiqueConsultanceScientifiquePonctuelle.getId());
if(foundedZoneGeographiqueConsultanceScientifiquePonctuelle==null) return null;
else{
return  zoneGeographiqueConsultanceScientifiquePonctuelleDao.save(zoneGeographiqueConsultanceScientifiquePonctuelle);
}
}

@Override
public ZoneGeographiqueConsultanceScientifiquePonctuelle save (ZoneGeographiqueConsultanceScientifiquePonctuelle zoneGeographiqueConsultanceScientifiquePonctuelle){



    findConsultanceScientifiquePonctuelle(zoneGeographiqueConsultanceScientifiquePonctuelle);
    findZoneGeographique(zoneGeographiqueConsultanceScientifiquePonctuelle);
    findPays(zoneGeographiqueConsultanceScientifiquePonctuelle);

    return zoneGeographiqueConsultanceScientifiquePonctuelleDao.save(zoneGeographiqueConsultanceScientifiquePonctuelle);


}

@Override
public List<ZoneGeographiqueConsultanceScientifiquePonctuelle> save(List<ZoneGeographiqueConsultanceScientifiquePonctuelle> zoneGeographiqueConsultanceScientifiquePonctuelles){
List<ZoneGeographiqueConsultanceScientifiquePonctuelle> list = new ArrayList<>();
for(ZoneGeographiqueConsultanceScientifiquePonctuelle zoneGeographiqueConsultanceScientifiquePonctuelle: zoneGeographiqueConsultanceScientifiquePonctuelles){
list.add(save(zoneGeographiqueConsultanceScientifiquePonctuelle));
}
return list;
}



@Override
@Transactional
public int delete(ZoneGeographiqueConsultanceScientifiquePonctuelle zoneGeographiqueConsultanceScientifiquePonctuelle){
    if(zoneGeographiqueConsultanceScientifiquePonctuelle.getId()==null) return -1;
    ZoneGeographiqueConsultanceScientifiquePonctuelle foundedZoneGeographiqueConsultanceScientifiquePonctuelle = findById(zoneGeographiqueConsultanceScientifiquePonctuelle.getId());
    if(foundedZoneGeographiqueConsultanceScientifiquePonctuelle==null) return -1;
zoneGeographiqueConsultanceScientifiquePonctuelleDao.delete(foundedZoneGeographiqueConsultanceScientifiquePonctuelle);
return 1;
}


public List<ZoneGeographiqueConsultanceScientifiquePonctuelle> findByCriteria(ZoneGeographiqueConsultanceScientifiquePonctuelleVo zoneGeographiqueConsultanceScientifiquePonctuelleVo){

String query = "SELECT o FROM ZoneGeographiqueConsultanceScientifiquePonctuelle o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",zoneGeographiqueConsultanceScientifiquePonctuelleVo.getId());
    if(zoneGeographiqueConsultanceScientifiquePonctuelleVo.getConsultanceScientifiquePonctuelleVo()!=null){
        query += SearchUtil.addConstraint( "o", "consultanceScientifiquePonctuelle.id","=",zoneGeographiqueConsultanceScientifiquePonctuelleVo.getConsultanceScientifiquePonctuelleVo().getId());
    }

    if(zoneGeographiqueConsultanceScientifiquePonctuelleVo.getZoneGeographiqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "zoneGeographique.id","=",zoneGeographiqueConsultanceScientifiquePonctuelleVo.getZoneGeographiqueVo().getId());
            query += SearchUtil.addConstraint( "o", "zoneGeographique.code","LIKE",zoneGeographiqueConsultanceScientifiquePonctuelleVo.getZoneGeographiqueVo().getCode());
    }

    if(zoneGeographiqueConsultanceScientifiquePonctuelleVo.getPaysVo()!=null){
        query += SearchUtil.addConstraint( "o", "pays.id","=",zoneGeographiqueConsultanceScientifiquePonctuelleVo.getPaysVo().getId());
            query += SearchUtil.addConstraint( "o", "pays.code","LIKE",zoneGeographiqueConsultanceScientifiquePonctuelleVo.getPaysVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findConsultanceScientifiquePonctuelle(ZoneGeographiqueConsultanceScientifiquePonctuelle zoneGeographiqueConsultanceScientifiquePonctuelle){
        ConsultanceScientifiquePonctuelle loadedConsultanceScientifiquePonctuelle = null;
        if(zoneGeographiqueConsultanceScientifiquePonctuelle.getConsultanceScientifiquePonctuelle() != null && zoneGeographiqueConsultanceScientifiquePonctuelle.getConsultanceScientifiquePonctuelle().getId() !=null)
        loadedConsultanceScientifiquePonctuelle =consultanceScientifiquePonctuelleService.findById(zoneGeographiqueConsultanceScientifiquePonctuelle.getConsultanceScientifiquePonctuelle().getId());

    if(loadedConsultanceScientifiquePonctuelle==null ) {
    return;
    }
    zoneGeographiqueConsultanceScientifiquePonctuelle.setConsultanceScientifiquePonctuelle(loadedConsultanceScientifiquePonctuelle);
    }
    private void findZoneGeographique(ZoneGeographiqueConsultanceScientifiquePonctuelle zoneGeographiqueConsultanceScientifiquePonctuelle){
        ZoneGeographique loadedZoneGeographique =zoneGeographiqueService.findByIdOrCode(zoneGeographiqueConsultanceScientifiquePonctuelle.getZoneGeographique());

    if(loadedZoneGeographique==null ) {
    return;
    }
    zoneGeographiqueConsultanceScientifiquePonctuelle.setZoneGeographique(loadedZoneGeographique);
    }
    private void findPays(ZoneGeographiqueConsultanceScientifiquePonctuelle zoneGeographiqueConsultanceScientifiquePonctuelle){
        Pays loadedPays =paysService.findByIdOrCode(zoneGeographiqueConsultanceScientifiquePonctuelle.getPays());

    if(loadedPays==null ) {
    return;
    }
    zoneGeographiqueConsultanceScientifiquePonctuelle.setPays(loadedPays);
    }

@Override
@Transactional
public void delete(List<ZoneGeographiqueConsultanceScientifiquePonctuelle> zoneGeographiqueConsultanceScientifiquePonctuelles){
if(ListUtil.isNotEmpty(zoneGeographiqueConsultanceScientifiquePonctuelles)){
zoneGeographiqueConsultanceScientifiquePonctuelles.forEach(e->zoneGeographiqueConsultanceScientifiquePonctuelleDao.delete(e));
}
}
@Override
public void update(List<ZoneGeographiqueConsultanceScientifiquePonctuelle> zoneGeographiqueConsultanceScientifiquePonctuelles){
if(ListUtil.isNotEmpty(zoneGeographiqueConsultanceScientifiquePonctuelles)){
zoneGeographiqueConsultanceScientifiquePonctuelles.forEach(e->zoneGeographiqueConsultanceScientifiquePonctuelleDao.save(e));
}
}





    }

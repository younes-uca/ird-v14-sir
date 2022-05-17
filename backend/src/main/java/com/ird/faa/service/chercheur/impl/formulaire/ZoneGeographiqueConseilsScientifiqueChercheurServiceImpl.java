package com.ird.faa.service.chercheur.impl.formulaire;

import com.ird.faa.bean.formulaire.ConseilsScientifique;
import com.ird.faa.bean.formulaire.ZoneGeographiqueConseilsScientifique;
import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.referentiel.ZoneGeographique;
import com.ird.faa.dao.formulaire.ZoneGeographiqueConseilsScientifiqueDao;
import com.ird.faa.service.chercheur.facade.formulaire.ConseilsScientifiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.PaysChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.ZoneGeographiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.ZoneGeographiqueConseilsScientifiqueChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.ZoneGeographiqueConseilsScientifiqueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ZoneGeographiqueConseilsScientifiqueChercheurServiceImpl extends AbstractServiceImpl<ZoneGeographiqueConseilsScientifique> implements ZoneGeographiqueConseilsScientifiqueChercheurService {

@Autowired
private ZoneGeographiqueConseilsScientifiqueDao zoneGeographiqueConseilsScientifiqueDao;

        @Autowired
        private ZoneGeographiqueChercheurService zoneGeographiqueService ;
        @Autowired
        private ConseilsScientifiqueChercheurService conseilsScientifiqueService ;
        @Autowired
        private PaysChercheurService paysService ;


@Autowired
private EntityManager entityManager;


@Override
public List<ZoneGeographiqueConseilsScientifique> findAll(){
        return zoneGeographiqueConseilsScientifiqueDao.findAll();
}
        @Override
        public List<ZoneGeographiqueConseilsScientifique> findByConseilsScientifiqueId(Long id){
        return zoneGeographiqueConseilsScientifiqueDao.findByConseilsScientifiqueId(id);
        }

        @Override
        @Transactional
        public int deleteByConseilsScientifiqueId(Long id){
        return zoneGeographiqueConseilsScientifiqueDao.deleteByConseilsScientifiqueId(id);
        }


        @Override
        public List<ZoneGeographiqueConseilsScientifique> findByZoneGeographiqueCode(String code){
        return zoneGeographiqueConseilsScientifiqueDao.findByZoneGeographiqueCode(code);
        }

        @Override
        @Transactional
        public int deleteByZoneGeographiqueCode(String code){
        return zoneGeographiqueConseilsScientifiqueDao.deleteByZoneGeographiqueCode(code);
        }

        @Override
        public List<ZoneGeographiqueConseilsScientifique> findByZoneGeographiqueId(Long id){
        return zoneGeographiqueConseilsScientifiqueDao.findByZoneGeographiqueId(id);
        }

        @Override
        @Transactional
        public int deleteByZoneGeographiqueId(Long id){
        return zoneGeographiqueConseilsScientifiqueDao.deleteByZoneGeographiqueId(id);
        }


        @Override
        public List<ZoneGeographiqueConseilsScientifique> findByPaysCode(String code){
        return zoneGeographiqueConseilsScientifiqueDao.findByPaysCode(code);
        }

        @Override
        @Transactional
        public int deleteByPaysCode(String code){
        return zoneGeographiqueConseilsScientifiqueDao.deleteByPaysCode(code);
        }

        @Override
        public List<ZoneGeographiqueConseilsScientifique> findByPaysId(Long id){
        return zoneGeographiqueConseilsScientifiqueDao.findByPaysId(id);
        }

        @Override
        @Transactional
        public int deleteByPaysId(Long id){
        return zoneGeographiqueConseilsScientifiqueDao.deleteByPaysId(id);
        }


@Override
public ZoneGeographiqueConseilsScientifique findById(Long id){
if(id==null) return null;
return zoneGeographiqueConseilsScientifiqueDao.getOne(id);
}

@Override
public ZoneGeographiqueConseilsScientifique findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(zoneGeographiqueConseilsScientifiqueDao.findById(id).isPresent())  {
zoneGeographiqueConseilsScientifiqueDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public ZoneGeographiqueConseilsScientifique update(ZoneGeographiqueConseilsScientifique zoneGeographiqueConseilsScientifique){
ZoneGeographiqueConseilsScientifique foundedZoneGeographiqueConseilsScientifique = findById(zoneGeographiqueConseilsScientifique.getId());
if(foundedZoneGeographiqueConseilsScientifique==null) return null;
else{
return  zoneGeographiqueConseilsScientifiqueDao.save(zoneGeographiqueConseilsScientifique);
}
}

@Override
public ZoneGeographiqueConseilsScientifique save (ZoneGeographiqueConseilsScientifique zoneGeographiqueConseilsScientifique){



    findConseilsScientifique(zoneGeographiqueConseilsScientifique);
    findZoneGeographique(zoneGeographiqueConseilsScientifique);
    findPays(zoneGeographiqueConseilsScientifique);

    return zoneGeographiqueConseilsScientifiqueDao.save(zoneGeographiqueConseilsScientifique);


}

@Override
public List<ZoneGeographiqueConseilsScientifique> save(List<ZoneGeographiqueConseilsScientifique> zoneGeographiqueConseilsScientifiques){
List<ZoneGeographiqueConseilsScientifique> list = new ArrayList<>();
for(ZoneGeographiqueConseilsScientifique zoneGeographiqueConseilsScientifique: zoneGeographiqueConseilsScientifiques){
list.add(save(zoneGeographiqueConseilsScientifique));
}
return list;
}



@Override
@Transactional
public int delete(ZoneGeographiqueConseilsScientifique zoneGeographiqueConseilsScientifique){
    if(zoneGeographiqueConseilsScientifique.getId()==null) return -1;
    ZoneGeographiqueConseilsScientifique foundedZoneGeographiqueConseilsScientifique = findById(zoneGeographiqueConseilsScientifique.getId());
    if(foundedZoneGeographiqueConseilsScientifique==null) return -1;
zoneGeographiqueConseilsScientifiqueDao.delete(foundedZoneGeographiqueConseilsScientifique);
return 1;
}


public List<ZoneGeographiqueConseilsScientifique> findByCriteria(ZoneGeographiqueConseilsScientifiqueVo zoneGeographiqueConseilsScientifiqueVo){

String query = "SELECT o FROM ZoneGeographiqueConseilsScientifique o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",zoneGeographiqueConseilsScientifiqueVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",zoneGeographiqueConseilsScientifiqueVo.getLibelle());
    if(zoneGeographiqueConseilsScientifiqueVo.getConseilsScientifiqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "conseilsScientifique.id","=",zoneGeographiqueConseilsScientifiqueVo.getConseilsScientifiqueVo().getId());
    }

    if(zoneGeographiqueConseilsScientifiqueVo.getZoneGeographiqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "zoneGeographique.id","=",zoneGeographiqueConseilsScientifiqueVo.getZoneGeographiqueVo().getId());
            query += SearchUtil.addConstraint( "o", "zoneGeographique.code","LIKE",zoneGeographiqueConseilsScientifiqueVo.getZoneGeographiqueVo().getCode());
    }

    if(zoneGeographiqueConseilsScientifiqueVo.getPaysVo()!=null){
        query += SearchUtil.addConstraint( "o", "pays.id","=",zoneGeographiqueConseilsScientifiqueVo.getPaysVo().getId());
            query += SearchUtil.addConstraint( "o", "pays.code","LIKE",zoneGeographiqueConseilsScientifiqueVo.getPaysVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findConseilsScientifique(ZoneGeographiqueConseilsScientifique zoneGeographiqueConseilsScientifique){
        ConseilsScientifique loadedConseilsScientifique = null;
        if(zoneGeographiqueConseilsScientifique.getConseilsScientifique() != null && zoneGeographiqueConseilsScientifique.getConseilsScientifique().getId() !=null)
        loadedConseilsScientifique =conseilsScientifiqueService.findById(zoneGeographiqueConseilsScientifique.getConseilsScientifique().getId());

    if(loadedConseilsScientifique==null ) {
    return;
    }
    zoneGeographiqueConseilsScientifique.setConseilsScientifique(loadedConseilsScientifique);
    }
    private void findZoneGeographique(ZoneGeographiqueConseilsScientifique zoneGeographiqueConseilsScientifique){
        ZoneGeographique loadedZoneGeographique =zoneGeographiqueService.findByIdOrCode(zoneGeographiqueConseilsScientifique.getZoneGeographique());

    if(loadedZoneGeographique==null ) {
    return;
    }
    zoneGeographiqueConseilsScientifique.setZoneGeographique(loadedZoneGeographique);
    }
    private void findPays(ZoneGeographiqueConseilsScientifique zoneGeographiqueConseilsScientifique){
        Pays loadedPays =paysService.findByIdOrCode(zoneGeographiqueConseilsScientifique.getPays());

    if(loadedPays==null ) {
    return;
    }
    zoneGeographiqueConseilsScientifique.setPays(loadedPays);
    }

@Override
@Transactional
public void delete(List<ZoneGeographiqueConseilsScientifique> zoneGeographiqueConseilsScientifiques){
if(ListUtil.isNotEmpty(zoneGeographiqueConseilsScientifiques)){
zoneGeographiqueConseilsScientifiques.forEach(e->zoneGeographiqueConseilsScientifiqueDao.delete(e));
}
}
@Override
public void update(List<ZoneGeographiqueConseilsScientifique> zoneGeographiqueConseilsScientifiques){
if(ListUtil.isNotEmpty(zoneGeographiqueConseilsScientifiques)){
zoneGeographiqueConseilsScientifiques.forEach(e->zoneGeographiqueConseilsScientifiqueDao.save(e));
}
}





    }

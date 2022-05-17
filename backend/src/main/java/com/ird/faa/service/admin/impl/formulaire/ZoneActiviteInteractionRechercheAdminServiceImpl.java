package com.ird.faa.service.admin.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.ZoneActiviteInteractionRecherche;
        import com.ird.faa.bean.referentiel.Pays;
        import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.dao.formulaire.ZoneActiviteInteractionRechercheDao;
import com.ird.faa.service.admin.facade.formulaire.ZoneActiviteInteractionRechercheAdminService;
        import com.ird.faa.service.admin.facade.formulaire.PaysAdminService;
        import com.ird.faa.service.admin.facade.formulaire.ChercheurAdminService;

import com.ird.faa.ws.rest.provided.vo.ZoneActiviteInteractionRechercheVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ZoneActiviteInteractionRechercheAdminServiceImpl extends AbstractServiceImpl<ZoneActiviteInteractionRecherche> implements ZoneActiviteInteractionRechercheAdminService {

@Autowired
private ZoneActiviteInteractionRechercheDao zoneActiviteInteractionRechercheDao;

        @Autowired
        private PaysAdminService paysService ;
        @Autowired
        private ChercheurAdminService chercheurService ;


@Autowired
private EntityManager entityManager;


@Override
public List<ZoneActiviteInteractionRecherche> findAll(){
return zoneActiviteInteractionRechercheDao.findAll();
}

        @Override
        public List<ZoneActiviteInteractionRecherche> findByPaysCode(String code){
        return zoneActiviteInteractionRechercheDao.findByPaysCode(code);
        }

        @Override
        @Transactional
        public int deleteByPaysCode(String code){
        return zoneActiviteInteractionRechercheDao.deleteByPaysCode(code);
        }

        @Override
        public List<ZoneActiviteInteractionRecherche> findByPaysId(Long id){
        return zoneActiviteInteractionRechercheDao.findByPaysId(id);
        }

        @Override
        @Transactional
        public int deleteByPaysId(Long id){
        return zoneActiviteInteractionRechercheDao.deleteByPaysId(id);
        }


        @Override
        public List<ZoneActiviteInteractionRecherche> findByChercheurNumeroMatricule(String numeroMatricule){
        return zoneActiviteInteractionRechercheDao.findByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByChercheurNumeroMatricule(String numeroMatricule){
        return zoneActiviteInteractionRechercheDao.deleteByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<ZoneActiviteInteractionRecherche> findByChercheurId(Long id){
        return zoneActiviteInteractionRechercheDao.findByChercheurId(id);
        }

        @Override
        @Transactional
        public int deleteByChercheurId(Long id){
        return zoneActiviteInteractionRechercheDao.deleteByChercheurId(id);
        }


@Override
public ZoneActiviteInteractionRecherche findById(Long id){
if(id==null) return null;
return zoneActiviteInteractionRechercheDao.getOne(id);
}

@Override
public ZoneActiviteInteractionRecherche findByIdWithAssociatedList(Long id){
ZoneActiviteInteractionRecherche zoneActiviteInteractionRecherche  = findById(id);
return zoneActiviteInteractionRecherche;
}


@Transactional
public int deleteById(Long id){
if(zoneActiviteInteractionRechercheDao.findById(id) == null) return 0;
else{
zoneActiviteInteractionRechercheDao.deleteById(id);
return 1;
}
}


@Override
public ZoneActiviteInteractionRecherche update(ZoneActiviteInteractionRecherche zoneActiviteInteractionRecherche){
ZoneActiviteInteractionRecherche foundedZoneActiviteInteractionRecherche = findById(zoneActiviteInteractionRecherche.getId());
if(foundedZoneActiviteInteractionRecherche==null) return null;
else{
return  zoneActiviteInteractionRechercheDao.save(zoneActiviteInteractionRecherche);
}
}

@Override
public ZoneActiviteInteractionRecherche save (ZoneActiviteInteractionRecherche zoneActiviteInteractionRecherche){


    findPays(zoneActiviteInteractionRecherche);
    findChercheur(zoneActiviteInteractionRecherche);

ZoneActiviteInteractionRecherche savedZoneActiviteInteractionRecherche = zoneActiviteInteractionRechercheDao.save(zoneActiviteInteractionRecherche);
return savedZoneActiviteInteractionRecherche;
}

@Override
public List<ZoneActiviteInteractionRecherche> save(List<ZoneActiviteInteractionRecherche> zoneActiviteInteractionRecherches){
List<ZoneActiviteInteractionRecherche> list = new ArrayList<ZoneActiviteInteractionRecherche>();
for(ZoneActiviteInteractionRecherche zoneActiviteInteractionRecherche: zoneActiviteInteractionRecherches){
list.add(save(zoneActiviteInteractionRecherche));
}
return list;
}



@Override
@Transactional
public int delete(ZoneActiviteInteractionRecherche zoneActiviteInteractionRecherche){
    if(zoneActiviteInteractionRecherche.getId()==null) return -1;
    ZoneActiviteInteractionRecherche foundedZoneActiviteInteractionRecherche = findById(zoneActiviteInteractionRecherche.getId());
    if(foundedZoneActiviteInteractionRecherche==null) return -1;
zoneActiviteInteractionRechercheDao.delete(foundedZoneActiviteInteractionRecherche);
return 1;
}


public List<ZoneActiviteInteractionRecherche> findByCriteria(ZoneActiviteInteractionRechercheVo zoneActiviteInteractionRechercheVo){

String query = "SELECT o FROM ZoneActiviteInteractionRecherche o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",zoneActiviteInteractionRechercheVo.getId());
    if(zoneActiviteInteractionRechercheVo.getPaysVo()!=null){
        query += SearchUtil.addConstraint( "o", "pays.id","=",zoneActiviteInteractionRechercheVo.getPaysVo().getId());
            query += SearchUtil.addConstraint( "o", "pays.code","LIKE",zoneActiviteInteractionRechercheVo.getPaysVo().getCode());
    }

    if(zoneActiviteInteractionRechercheVo.getChercheurVo()!=null){
        query += SearchUtil.addConstraint( "o", "chercheur.id","=",zoneActiviteInteractionRechercheVo.getChercheurVo().getId());
            query += SearchUtil.addConstraint( "o", "chercheur.numeroMatricule","LIKE",zoneActiviteInteractionRechercheVo.getChercheurVo().getNumeroMatricule());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findPays(ZoneActiviteInteractionRecherche zoneActiviteInteractionRecherche){
        Pays loadedPays =paysService.findByIdOrCode(zoneActiviteInteractionRecherche.getPays());

    if(loadedPays==null ) {
        return;
    }
    zoneActiviteInteractionRecherche.setPays(loadedPays);
    }
    private void findChercheur(ZoneActiviteInteractionRecherche zoneActiviteInteractionRecherche){
        Chercheur loadedChercheur =chercheurService.findByIdOrNumeroMatricule(zoneActiviteInteractionRecherche.getChercheur());

    if(loadedChercheur==null ) {
        return;
    }
    zoneActiviteInteractionRecherche.setChercheur(loadedChercheur);
    }

@Override
@Transactional
public void delete(List<ZoneActiviteInteractionRecherche> zoneActiviteInteractionRecherches){
        if(ListUtil.isNotEmpty(zoneActiviteInteractionRecherches)){
        zoneActiviteInteractionRecherches.forEach(e->zoneActiviteInteractionRechercheDao.delete(e));
        }
}
@Override
public void update(List<ZoneActiviteInteractionRecherche> zoneActiviteInteractionRecherches){
if(ListUtil.isNotEmpty(zoneActiviteInteractionRecherches)){
zoneActiviteInteractionRecherches.forEach(e->zoneActiviteInteractionRechercheDao.save(e));
}
}



@Override
public List<List<ZoneActiviteInteractionRecherche>>  getToBeSavedAndToBeDeleted(List<ZoneActiviteInteractionRecherche> oldList,List<ZoneActiviteInteractionRecherche> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.EtablissementEncadrementDoctorant;
import com.ird.faa.bean.referentiel.Etablissement;
import com.ird.faa.bean.formulaire.EncadrementDoctorant;
import com.ird.faa.dao.formulaire.EtablissementEncadrementDoctorantDao;
import com.ird.faa.service.chercheur.facade.formulaire.EtablissementEncadrementDoctorantChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EtablissementChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementDoctorantChercheurService;

import com.ird.faa.ws.rest.provided.vo.EtablissementEncadrementDoctorantVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtablissementEncadrementDoctorantChercheurServiceImpl extends AbstractServiceImpl<EtablissementEncadrementDoctorant> implements EtablissementEncadrementDoctorantChercheurService {

@Autowired
private EtablissementEncadrementDoctorantDao etablissementEncadrementDoctorantDao;

        @Autowired
        private EtablissementChercheurService etablissementService ;
        @Autowired
        private EncadrementDoctorantChercheurService encadrementDoctorantService ;


@Autowired
private EntityManager entityManager;


@Override
public List<EtablissementEncadrementDoctorant> findAll(){
return etablissementEncadrementDoctorantDao.findAll();
}

        @Override
        public List<EtablissementEncadrementDoctorant> findByEtablissementCode(String code){
        return etablissementEncadrementDoctorantDao.findByEtablissementCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtablissementCode(String code){
        return etablissementEncadrementDoctorantDao.deleteByEtablissementCode(code);
        }

        @Override
        public List<EtablissementEncadrementDoctorant> findByEtablissementId(Long id){
        return etablissementEncadrementDoctorantDao.findByEtablissementId(id);
        }

        @Override
        @Transactional
        public int deleteByEtablissementId(Long id){
        return etablissementEncadrementDoctorantDao.deleteByEtablissementId(id);
        }

        @Override
        public List<EtablissementEncadrementDoctorant> findByEncadrementDoctorantId(Long id){
        return etablissementEncadrementDoctorantDao.findByEncadrementDoctorantId(id);
        }

        @Override
        @Transactional
        public int deleteByEncadrementDoctorantId(Long id){
        return etablissementEncadrementDoctorantDao.deleteByEncadrementDoctorantId(id);
        }


@Override
public EtablissementEncadrementDoctorant findById(Long id){
if(id==null) return null;
return etablissementEncadrementDoctorantDao.getOne(id);
}

@Override
public EtablissementEncadrementDoctorant findByIdWithAssociatedList(Long id){
EtablissementEncadrementDoctorant etablissementEncadrementDoctorant  = findById(id);
return etablissementEncadrementDoctorant;
}


@Transactional
public int deleteById(Long id){
if(etablissementEncadrementDoctorantDao.findById(id) == null) return 0;
else{
etablissementEncadrementDoctorantDao.deleteById(id);
return 1;
}
}


@Override
public EtablissementEncadrementDoctorant update(EtablissementEncadrementDoctorant etablissementEncadrementDoctorant){
EtablissementEncadrementDoctorant foundedEtablissementEncadrementDoctorant = findById(etablissementEncadrementDoctorant.getId());
if(foundedEtablissementEncadrementDoctorant==null) return null;
else{
return  etablissementEncadrementDoctorantDao.save(etablissementEncadrementDoctorant);
}
}

@Override
public EtablissementEncadrementDoctorant save (EtablissementEncadrementDoctorant etablissementEncadrementDoctorant){


    findEtablissement(etablissementEncadrementDoctorant);
    findEncadrementDoctorant(etablissementEncadrementDoctorant);

EtablissementEncadrementDoctorant savedEtablissementEncadrementDoctorant = etablissementEncadrementDoctorantDao.save(etablissementEncadrementDoctorant);
return savedEtablissementEncadrementDoctorant;
}

@Override
public List<EtablissementEncadrementDoctorant> save(List<EtablissementEncadrementDoctorant> etablissementEncadrementDoctorants){
List<EtablissementEncadrementDoctorant> list = new ArrayList<EtablissementEncadrementDoctorant>();
for(EtablissementEncadrementDoctorant etablissementEncadrementDoctorant: etablissementEncadrementDoctorants){
list.add(save(etablissementEncadrementDoctorant));
}
return list;
}



@Override
@Transactional
public int delete(EtablissementEncadrementDoctorant etablissementEncadrementDoctorant){
    if(etablissementEncadrementDoctorant.getId()==null) return -1;
    EtablissementEncadrementDoctorant foundedEtablissementEncadrementDoctorant = findById(etablissementEncadrementDoctorant.getId());
    if(foundedEtablissementEncadrementDoctorant==null) return -1;
etablissementEncadrementDoctorantDao.delete(foundedEtablissementEncadrementDoctorant);
return 1;
}


public List<EtablissementEncadrementDoctorant> findByCriteria(EtablissementEncadrementDoctorantVo etablissementEncadrementDoctorantVo){

String query = "SELECT o FROM EtablissementEncadrementDoctorant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etablissementEncadrementDoctorantVo.getId());
    if(etablissementEncadrementDoctorantVo.getEtablissementVo()!=null){
        query += SearchUtil.addConstraint( "o", "etablissement.id","=",etablissementEncadrementDoctorantVo.getEtablissementVo().getId());
            query += SearchUtil.addConstraint( "o", "etablissement.code","LIKE",etablissementEncadrementDoctorantVo.getEtablissementVo().getCode());
    }

    if(etablissementEncadrementDoctorantVo.getEncadrementDoctorantVo()!=null){
        query += SearchUtil.addConstraint( "o", "encadrementDoctorant.id","=",etablissementEncadrementDoctorantVo.getEncadrementDoctorantVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findEtablissement(EtablissementEncadrementDoctorant etablissementEncadrementDoctorant){
        Etablissement loadedEtablissement =etablissementService.findByIdOrCode(etablissementEncadrementDoctorant.getEtablissement());

    if(loadedEtablissement==null ) {
        return;
    }
    etablissementEncadrementDoctorant.setEtablissement(loadedEtablissement);
    }
    private void findEncadrementDoctorant(EtablissementEncadrementDoctorant etablissementEncadrementDoctorant){
        EncadrementDoctorant loadedEncadrementDoctorant = null;
        if(etablissementEncadrementDoctorant.getEncadrementDoctorant() != null && etablissementEncadrementDoctorant.getEncadrementDoctorant().getId() !=null)
        loadedEncadrementDoctorant =encadrementDoctorantService.findById(etablissementEncadrementDoctorant.getEncadrementDoctorant().getId());

    if(loadedEncadrementDoctorant==null ) {
        return;
    }
    etablissementEncadrementDoctorant.setEncadrementDoctorant(loadedEncadrementDoctorant);
    }

@Override
@Transactional
public void delete(List<EtablissementEncadrementDoctorant> etablissementEncadrementDoctorants){
        if(ListUtil.isNotEmpty(etablissementEncadrementDoctorants)){
        etablissementEncadrementDoctorants.forEach(e->etablissementEncadrementDoctorantDao.delete(e));
        }
}
@Override
public void update(List<EtablissementEncadrementDoctorant> etablissementEncadrementDoctorants){
if(ListUtil.isNotEmpty(etablissementEncadrementDoctorants)){
etablissementEncadrementDoctorants.forEach(e->etablissementEncadrementDoctorantDao.save(e));
}
}



@Override
public List<List<EtablissementEncadrementDoctorant>>  getToBeSavedAndToBeDeleted(List<EtablissementEncadrementDoctorant> oldList,List<EtablissementEncadrementDoctorant> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

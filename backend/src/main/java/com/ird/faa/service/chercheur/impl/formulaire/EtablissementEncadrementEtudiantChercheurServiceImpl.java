package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.EtablissementEncadrementEtudiant;
import com.ird.faa.bean.referentiel.Etablissement;
import com.ird.faa.bean.formulaire.EncadrementEtudiant;
import com.ird.faa.dao.formulaire.EtablissementEncadrementEtudiantDao;
import com.ird.faa.service.chercheur.facade.formulaire.EtablissementEncadrementEtudiantChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EtablissementChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementEtudiantChercheurService;

import com.ird.faa.ws.rest.provided.vo.EtablissementEncadrementEtudiantVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtablissementEncadrementEtudiantChercheurServiceImpl extends AbstractServiceImpl<EtablissementEncadrementEtudiant> implements EtablissementEncadrementEtudiantChercheurService {

@Autowired
private EtablissementEncadrementEtudiantDao etablissementEncadrementEtudiantDao;

        @Autowired
        private EtablissementChercheurService etablissementService ;
        @Autowired
        private EncadrementEtudiantChercheurService encadrementEtudiantService ;


@Autowired
private EntityManager entityManager;


@Override
public List<EtablissementEncadrementEtudiant> findAll(){
return etablissementEncadrementEtudiantDao.findAll();
}

        @Override
        public List<EtablissementEncadrementEtudiant> findByEtablissementCode(String code){
        return etablissementEncadrementEtudiantDao.findByEtablissementCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtablissementCode(String code){
        return etablissementEncadrementEtudiantDao.deleteByEtablissementCode(code);
        }

        @Override
        public List<EtablissementEncadrementEtudiant> findByEtablissementId(Long id){
        return etablissementEncadrementEtudiantDao.findByEtablissementId(id);
        }

        @Override
        @Transactional
        public int deleteByEtablissementId(Long id){
        return etablissementEncadrementEtudiantDao.deleteByEtablissementId(id);
        }

        @Override
        public List<EtablissementEncadrementEtudiant> findByEncadrementEtudiantId(Long id){
        return etablissementEncadrementEtudiantDao.findByEncadrementEtudiantId(id);
        }

        @Override
        @Transactional
        public int deleteByEncadrementEtudiantId(Long id){
        return etablissementEncadrementEtudiantDao.deleteByEncadrementEtudiantId(id);
        }


@Override
public EtablissementEncadrementEtudiant findById(Long id){
if(id==null) return null;
return etablissementEncadrementEtudiantDao.getOne(id);
}

@Override
public EtablissementEncadrementEtudiant findByIdWithAssociatedList(Long id){
EtablissementEncadrementEtudiant etablissementEncadrementEtudiant  = findById(id);
return etablissementEncadrementEtudiant;
}


@Transactional
public int deleteById(Long id){
if(etablissementEncadrementEtudiantDao.findById(id) == null) return 0;
else{
etablissementEncadrementEtudiantDao.deleteById(id);
return 1;
}
}


@Override
public EtablissementEncadrementEtudiant update(EtablissementEncadrementEtudiant etablissementEncadrementEtudiant){
EtablissementEncadrementEtudiant foundedEtablissementEncadrementEtudiant = findById(etablissementEncadrementEtudiant.getId());
if(foundedEtablissementEncadrementEtudiant==null) return null;
else{
return  etablissementEncadrementEtudiantDao.save(etablissementEncadrementEtudiant);
}
}

@Override
public EtablissementEncadrementEtudiant save (EtablissementEncadrementEtudiant etablissementEncadrementEtudiant){


    findEtablissement(etablissementEncadrementEtudiant);
    findEncadrementEtudiant(etablissementEncadrementEtudiant);

EtablissementEncadrementEtudiant savedEtablissementEncadrementEtudiant = etablissementEncadrementEtudiantDao.save(etablissementEncadrementEtudiant);
return savedEtablissementEncadrementEtudiant;
}

@Override
public List<EtablissementEncadrementEtudiant> save(List<EtablissementEncadrementEtudiant> etablissementEncadrementEtudiants){
List<EtablissementEncadrementEtudiant> list = new ArrayList<EtablissementEncadrementEtudiant>();
for(EtablissementEncadrementEtudiant etablissementEncadrementEtudiant: etablissementEncadrementEtudiants){
list.add(save(etablissementEncadrementEtudiant));
}
return list;
}



@Override
@Transactional
public int delete(EtablissementEncadrementEtudiant etablissementEncadrementEtudiant){
    if(etablissementEncadrementEtudiant.getId()==null) return -1;
    EtablissementEncadrementEtudiant foundedEtablissementEncadrementEtudiant = findById(etablissementEncadrementEtudiant.getId());
    if(foundedEtablissementEncadrementEtudiant==null) return -1;
etablissementEncadrementEtudiantDao.delete(foundedEtablissementEncadrementEtudiant);
return 1;
}


public List<EtablissementEncadrementEtudiant> findByCriteria(EtablissementEncadrementEtudiantVo etablissementEncadrementEtudiantVo){

String query = "SELECT o FROM EtablissementEncadrementEtudiant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etablissementEncadrementEtudiantVo.getId());
    if(etablissementEncadrementEtudiantVo.getEtablissementVo()!=null){
        query += SearchUtil.addConstraint( "o", "etablissement.id","=",etablissementEncadrementEtudiantVo.getEtablissementVo().getId());
            query += SearchUtil.addConstraint( "o", "etablissement.code","LIKE",etablissementEncadrementEtudiantVo.getEtablissementVo().getCode());
    }

    if(etablissementEncadrementEtudiantVo.getEncadrementEtudiantVo()!=null){
        query += SearchUtil.addConstraint( "o", "encadrementEtudiant.id","=",etablissementEncadrementEtudiantVo.getEncadrementEtudiantVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findEtablissement(EtablissementEncadrementEtudiant etablissementEncadrementEtudiant){
        Etablissement loadedEtablissement =etablissementService.findByIdOrCode(etablissementEncadrementEtudiant.getEtablissement());

    if(loadedEtablissement==null ) {
        return;
    }
    etablissementEncadrementEtudiant.setEtablissement(loadedEtablissement);
    }
    private void findEncadrementEtudiant(EtablissementEncadrementEtudiant etablissementEncadrementEtudiant){
        EncadrementEtudiant loadedEncadrementEtudiant = null;
        if(etablissementEncadrementEtudiant.getEncadrementEtudiant() != null && etablissementEncadrementEtudiant.getEncadrementEtudiant().getId() !=null)
        loadedEncadrementEtudiant =encadrementEtudiantService.findById(etablissementEncadrementEtudiant.getEncadrementEtudiant().getId());

    if(loadedEncadrementEtudiant==null ) {
        return;
    }
    etablissementEncadrementEtudiant.setEncadrementEtudiant(loadedEncadrementEtudiant);
    }

@Override
@Transactional
public void delete(List<EtablissementEncadrementEtudiant> etablissementEncadrementEtudiants){
        if(ListUtil.isNotEmpty(etablissementEncadrementEtudiants)){
        etablissementEncadrementEtudiants.forEach(e->etablissementEncadrementEtudiantDao.delete(e));
        }
}
@Override
public void update(List<EtablissementEncadrementEtudiant> etablissementEncadrementEtudiants){
if(ListUtil.isNotEmpty(etablissementEncadrementEtudiants)){
etablissementEncadrementEtudiants.forEach(e->etablissementEncadrementEtudiantDao.save(e));
}
}



@Override
public List<List<EtablissementEncadrementEtudiant>>  getToBeSavedAndToBeDeleted(List<EtablissementEncadrementEtudiant> oldList,List<EtablissementEncadrementEtudiant> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

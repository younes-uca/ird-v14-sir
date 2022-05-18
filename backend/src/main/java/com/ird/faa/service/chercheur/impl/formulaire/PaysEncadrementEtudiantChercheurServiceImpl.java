package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.formulaire.PaysEncadrementEtudiant;
import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.formulaire.EncadrementEtudiant;
import com.ird.faa.dao.formulaire.PaysEncadrementEtudiantDao;
import com.ird.faa.service.chercheur.facade.formulaire.PaysEncadrementEtudiantChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.PaysChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.EncadrementEtudiantChercheurService;

import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.PaysEncadrementEtudiantVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PaysEncadrementEtudiantChercheurServiceImpl extends AbstractServiceImpl<PaysEncadrementEtudiant> implements PaysEncadrementEtudiantChercheurService {

@Autowired
private PaysEncadrementEtudiantDao paysEncadrementEtudiantDao;

        @Autowired
        private PaysChercheurService paysService ;
        @Autowired
        private EncadrementEtudiantChercheurService encadrementEtudiantService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PaysEncadrementEtudiant> findAll(){
return paysEncadrementEtudiantDao.findAll();
}

        @Override
        public List<PaysEncadrementEtudiant> findByPaysCode(String code){
        return paysEncadrementEtudiantDao.findByPaysCode(code);
        }

        @Override
        @Transactional
        public int deleteByPaysCode(String code){
        return paysEncadrementEtudiantDao.deleteByPaysCode(code);
        }

        @Override
        public List<PaysEncadrementEtudiant> findByPaysId(Long id){
        return paysEncadrementEtudiantDao.findByPaysId(id);
        }

        @Override
        @Transactional
        public int deleteByPaysId(Long id){
        return paysEncadrementEtudiantDao.deleteByPaysId(id);
        }

        @Override
        public List<PaysEncadrementEtudiant> findByEncadrementEtudiantId(Long id){
        return paysEncadrementEtudiantDao.findByEncadrementEtudiantId(id);
        }

        @Override
        @Transactional
        public int deleteByEncadrementEtudiantId(Long id){
        return paysEncadrementEtudiantDao.deleteByEncadrementEtudiantId(id);
        }


@Override
public PaysEncadrementEtudiant findById(Long id){
if(id==null) return null;
return paysEncadrementEtudiantDao.getOne(id);
}

@Override
public PaysEncadrementEtudiant findByIdWithAssociatedList(Long id){
PaysEncadrementEtudiant paysEncadrementEtudiant  = findById(id);
return paysEncadrementEtudiant;
}


@Transactional
public int deleteById(Long id){
if(paysEncadrementEtudiantDao.findById(id) == null) return 0;
else{
paysEncadrementEtudiantDao.deleteById(id);
return 1;
}
}


@Override
public PaysEncadrementEtudiant update(PaysEncadrementEtudiant paysEncadrementEtudiant){
PaysEncadrementEtudiant foundedPaysEncadrementEtudiant = findById(paysEncadrementEtudiant.getId());
if(foundedPaysEncadrementEtudiant==null) return null;
else{
return  paysEncadrementEtudiantDao.save(paysEncadrementEtudiant);
}
}

@Override
public PaysEncadrementEtudiant save (PaysEncadrementEtudiant paysEncadrementEtudiant){


    findPays(paysEncadrementEtudiant);
    findEncadrementEtudiant(paysEncadrementEtudiant);

PaysEncadrementEtudiant savedPaysEncadrementEtudiant = paysEncadrementEtudiantDao.save(paysEncadrementEtudiant);
return savedPaysEncadrementEtudiant;
}

@Override
public List<PaysEncadrementEtudiant> save(List<PaysEncadrementEtudiant> paysEncadrementEtudiants){
List<PaysEncadrementEtudiant> list = new ArrayList<PaysEncadrementEtudiant>();
for(PaysEncadrementEtudiant paysEncadrementEtudiant: paysEncadrementEtudiants){
list.add(save(paysEncadrementEtudiant));
}
return list;
}



@Override
@Transactional
public int delete(PaysEncadrementEtudiant paysEncadrementEtudiant){
    if(paysEncadrementEtudiant.getId()==null) return -1;
    PaysEncadrementEtudiant foundedPaysEncadrementEtudiant = findById(paysEncadrementEtudiant.getId());
    if(foundedPaysEncadrementEtudiant==null) return -1;
paysEncadrementEtudiantDao.delete(foundedPaysEncadrementEtudiant);
return 1;
}


public List<PaysEncadrementEtudiant> findByCriteria(PaysEncadrementEtudiantVo paysEncadrementEtudiantVo){

String query = "SELECT o FROM PaysEncadrementEtudiant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",paysEncadrementEtudiantVo.getId());
    if(paysEncadrementEtudiantVo.getPaysVo()!=null){
        query += SearchUtil.addConstraint( "o", "pays.id","=",paysEncadrementEtudiantVo.getPaysVo().getId());
            query += SearchUtil.addConstraint( "o", "pays.code","LIKE",paysEncadrementEtudiantVo.getPaysVo().getCode());
    }

    if(paysEncadrementEtudiantVo.getEncadrementEtudiantVo()!=null){
        query += SearchUtil.addConstraint( "o", "encadrementEtudiant.id","=",paysEncadrementEtudiantVo.getEncadrementEtudiantVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findPays(PaysEncadrementEtudiant paysEncadrementEtudiant){
        Pays loadedPays =paysService.findByIdOrCode(paysEncadrementEtudiant.getPays());

    if(loadedPays==null ) {
        return;
    }
    paysEncadrementEtudiant.setPays(loadedPays);
    }
    private void findEncadrementEtudiant(PaysEncadrementEtudiant paysEncadrementEtudiant){
        EncadrementEtudiant loadedEncadrementEtudiant = null;
        if(paysEncadrementEtudiant.getEncadrementEtudiant() != null && paysEncadrementEtudiant.getEncadrementEtudiant().getId() !=null)
        loadedEncadrementEtudiant =encadrementEtudiantService.findById(paysEncadrementEtudiant.getEncadrementEtudiant().getId());

    if(loadedEncadrementEtudiant==null ) {
        return;
    }
    paysEncadrementEtudiant.setEncadrementEtudiant(loadedEncadrementEtudiant);
    }

@Override
@Transactional
public void delete(List<PaysEncadrementEtudiant> paysEncadrementEtudiants){
        if(ListUtil.isNotEmpty(paysEncadrementEtudiants)){
        paysEncadrementEtudiants.forEach(e->paysEncadrementEtudiantDao.delete(e));
        }
}
@Override
public void update(List<PaysEncadrementEtudiant> paysEncadrementEtudiants){
if(ListUtil.isNotEmpty(paysEncadrementEtudiants)){
paysEncadrementEtudiants.forEach(e->paysEncadrementEtudiantDao.save(e));
}
}



@Override
public List<List<PaysEncadrementEtudiant>>  getToBeSavedAndToBeDeleted(List<PaysEncadrementEtudiant> oldList,List<PaysEncadrementEtudiant> newList){
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

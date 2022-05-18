package com.ird.faa.service.chercheur.impl.formulaire;

import com.ird.faa.bean.formulaire.Chercheur;
import com.ird.faa.bean.formulaire.ChercheurEmail;
import com.ird.faa.dao.formulaire.ChercheurEmailDao;
import com.ird.faa.service.chercheur.facade.formulaire.ChercheurChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.ChercheurEmailChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ChercheurEmailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChercheurEmailChercheurServiceImpl extends AbstractServiceImpl<ChercheurEmail> implements ChercheurEmailChercheurService {

@Autowired
private ChercheurEmailDao chercheurEmailDao;

        @Autowired
        private ChercheurChercheurService chercheurService ;


@Autowired
private EntityManager entityManager;


@Override
public List<ChercheurEmail> findAll(){
        return chercheurEmailDao.findAll();
}

        @Override
        public List<ChercheurEmail> findByChercheurNumeroMatricule(String numeroMatricule){
        return chercheurEmailDao.findByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByChercheurNumeroMatricule(String numeroMatricule){
        return chercheurEmailDao.deleteByChercheurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<ChercheurEmail> findByChercheurId(Long id){
        return chercheurEmailDao.findByChercheurId(id);
        }

        @Override
        @Transactional
        public int deleteByChercheurId(Long id){
        return chercheurEmailDao.deleteByChercheurId(id);
        }


@Override
public ChercheurEmail findById(Long id){
if(id==null) return null;
return chercheurEmailDao.getOne(id);
}

@Override
public ChercheurEmail findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(chercheurEmailDao.findById(id).isPresent())  {
chercheurEmailDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public ChercheurEmail update(ChercheurEmail chercheurEmail){
ChercheurEmail foundedChercheurEmail = findById(chercheurEmail.getId());
if(foundedChercheurEmail==null) return null;
else{
return  chercheurEmailDao.save(chercheurEmail);
}
}
    private void prepareSave(ChercheurEmail chercheurEmail){
                    if(chercheurEmail.getPrincipale() == null)
                chercheurEmail.setPrincipale(false);




    }

@Override
public ChercheurEmail save (ChercheurEmail chercheurEmail){
    prepareSave(chercheurEmail);



    findChercheur(chercheurEmail);

    return chercheurEmailDao.save(chercheurEmail);


}

@Override
public List<ChercheurEmail> save(List<ChercheurEmail> chercheurEmails){
List<ChercheurEmail> list = new ArrayList<>();
for(ChercheurEmail chercheurEmail: chercheurEmails){
list.add(save(chercheurEmail));
}
return list;
}



@Override
@Transactional
public int delete(ChercheurEmail chercheurEmail){
    if(chercheurEmail.getId()==null) return -1;
    ChercheurEmail foundedChercheurEmail = findById(chercheurEmail.getId());
    if(foundedChercheurEmail==null) return -1;
chercheurEmailDao.delete(foundedChercheurEmail);
return 1;
}


public List<ChercheurEmail> findByCriteria(ChercheurEmailVo chercheurEmailVo){

String query = "SELECT o FROM ChercheurEmail o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",chercheurEmailVo.getId());
            query += SearchUtil.addConstraint( "o", "email","LIKE",chercheurEmailVo.getEmail());
            query += SearchUtil.addConstraint( "o", "principale","=",chercheurEmailVo.getPrincipale());
    if(chercheurEmailVo.getChercheurVo()!=null){
        query += SearchUtil.addConstraint( "o", "chercheur.id","=",chercheurEmailVo.getChercheurVo().getId());
            query += SearchUtil.addConstraint( "o", "chercheur.numeroMatricule","LIKE",chercheurEmailVo.getChercheurVo().getNumeroMatricule());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findChercheur(ChercheurEmail chercheurEmail){
        Chercheur loadedChercheur =chercheurService.findByIdOrNumeroMatricule(chercheurEmail.getChercheur());

    if(loadedChercheur==null ) {
    return;
    }
    chercheurEmail.setChercheur(loadedChercheur);
    }

@Override
@Transactional
public void delete(List<ChercheurEmail> chercheurEmails){
if(ListUtil.isNotEmpty(chercheurEmails)){
chercheurEmails.forEach(e->chercheurEmailDao.delete(e));
}
}
@Override
public void update(List<ChercheurEmail> chercheurEmails){
if(ListUtil.isNotEmpty(chercheurEmails)){
chercheurEmails.forEach(e->chercheurEmailDao.save(e));
}
}





    }

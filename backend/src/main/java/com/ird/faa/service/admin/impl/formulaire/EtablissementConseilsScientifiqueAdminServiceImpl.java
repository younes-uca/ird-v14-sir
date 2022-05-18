package com.ird.faa.service.admin.impl.formulaire;

import com.ird.faa.bean.formulaire.ConseilsScientifique;
import com.ird.faa.bean.formulaire.Etablissement;
import com.ird.faa.bean.formulaire.EtablissementConseilsScientifique;
import com.ird.faa.dao.formulaire.EtablissementConseilsScientifiqueDao;
import com.ird.faa.service.admin.facade.formulaire.ConseilsScientifiqueAdminService;
import com.ird.faa.service.admin.facade.formulaire.EtablissementAdminService;
import com.ird.faa.service.admin.facade.formulaire.EtablissementConseilsScientifiqueAdminService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.EtablissementConseilsScientifiqueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class EtablissementConseilsScientifiqueAdminServiceImpl extends AbstractServiceImpl<EtablissementConseilsScientifique> implements EtablissementConseilsScientifiqueAdminService {

@Autowired
private EtablissementConseilsScientifiqueDao etablissementConseilsScientifiqueDao;

        @Autowired
        private ConseilsScientifiqueAdminService conseilsScientifiqueService ;
        @Autowired
        private EtablissementAdminService etablissementService ;


@Autowired
private EntityManager entityManager;


@Override
public List<EtablissementConseilsScientifique> findAll(){
        return etablissementConseilsScientifiqueDao.findAll();
}
        @Override
        public List<EtablissementConseilsScientifique> findByConseilsScientifiqueId(Long id){
        return etablissementConseilsScientifiqueDao.findByConseilsScientifiqueId(id);
        }

        @Override
        @Transactional
        public int deleteByConseilsScientifiqueId(Long id){
        return etablissementConseilsScientifiqueDao.deleteByConseilsScientifiqueId(id);
        }


        @Override
        public List<EtablissementConseilsScientifique> findByEtablissementCode(String code){
        return etablissementConseilsScientifiqueDao.findByEtablissementCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtablissementCode(String code){
        return etablissementConseilsScientifiqueDao.deleteByEtablissementCode(code);
        }

        @Override
        public List<EtablissementConseilsScientifique> findByEtablissementId(Long id){
        return etablissementConseilsScientifiqueDao.findByEtablissementId(id);
        }

        @Override
        @Transactional
        public int deleteByEtablissementId(Long id){
        return etablissementConseilsScientifiqueDao.deleteByEtablissementId(id);
        }


@Override
public EtablissementConseilsScientifique findById(Long id){
if(id==null) return null;
return etablissementConseilsScientifiqueDao.getOne(id);
}

@Override
public EtablissementConseilsScientifique findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(etablissementConseilsScientifiqueDao.findById(id).isPresent())  {
etablissementConseilsScientifiqueDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtablissementConseilsScientifique update(EtablissementConseilsScientifique etablissementConseilsScientifique){
EtablissementConseilsScientifique foundedEtablissementConseilsScientifique = findById(etablissementConseilsScientifique.getId());
if(foundedEtablissementConseilsScientifique==null) return null;
else{
return  etablissementConseilsScientifiqueDao.save(etablissementConseilsScientifique);
}
}

@Override
public EtablissementConseilsScientifique save (EtablissementConseilsScientifique etablissementConseilsScientifique){



    findConseilsScientifique(etablissementConseilsScientifique);
    findEtablissement(etablissementConseilsScientifique);

    return etablissementConseilsScientifiqueDao.save(etablissementConseilsScientifique);


}

@Override
public List<EtablissementConseilsScientifique> save(List<EtablissementConseilsScientifique> etablissementConseilsScientifiques){
List<EtablissementConseilsScientifique> list = new ArrayList<>();
for(EtablissementConseilsScientifique etablissementConseilsScientifique: etablissementConseilsScientifiques){
list.add(save(etablissementConseilsScientifique));
}
return list;
}



@Override
@Transactional
public int delete(EtablissementConseilsScientifique etablissementConseilsScientifique){
    if(etablissementConseilsScientifique.getId()==null) return -1;
    EtablissementConseilsScientifique foundedEtablissementConseilsScientifique = findById(etablissementConseilsScientifique.getId());
    if(foundedEtablissementConseilsScientifique==null) return -1;
etablissementConseilsScientifiqueDao.delete(foundedEtablissementConseilsScientifique);
return 1;
}


public List<EtablissementConseilsScientifique> findByCriteria(EtablissementConseilsScientifiqueVo etablissementConseilsScientifiqueVo){

String query = "SELECT o FROM EtablissementConseilsScientifique o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etablissementConseilsScientifiqueVo.getId());
    if(etablissementConseilsScientifiqueVo.getConseilsScientifiqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "conseilsScientifique.id","=",etablissementConseilsScientifiqueVo.getConseilsScientifiqueVo().getId());
    }

    if(etablissementConseilsScientifiqueVo.getEtablissementVo()!=null){
        query += SearchUtil.addConstraint( "o", "etablissement.id","=",etablissementConseilsScientifiqueVo.getEtablissementVo().getId());
            query += SearchUtil.addConstraint( "o", "etablissement.code","LIKE",etablissementConseilsScientifiqueVo.getEtablissementVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findConseilsScientifique(EtablissementConseilsScientifique etablissementConseilsScientifique){
        ConseilsScientifique loadedConseilsScientifique = null;
        if(etablissementConseilsScientifique.getConseilsScientifique() != null && etablissementConseilsScientifique.getConseilsScientifique().getId() !=null)
        loadedConseilsScientifique =conseilsScientifiqueService.findById(etablissementConseilsScientifique.getConseilsScientifique().getId());

    if(loadedConseilsScientifique==null ) {
    return;
    }
    etablissementConseilsScientifique.setConseilsScientifique(loadedConseilsScientifique);
    }
    private void findEtablissement(EtablissementConseilsScientifique etablissementConseilsScientifique){
        Etablissement loadedEtablissement =etablissementService.findByIdOrCode(etablissementConseilsScientifique.getEtablissement());

    if(loadedEtablissement==null ) {
    return;
    }
    etablissementConseilsScientifique.setEtablissement(loadedEtablissement);
    }

@Override
@Transactional
public void delete(List<EtablissementConseilsScientifique> etablissementConseilsScientifiques){
if(ListUtil.isNotEmpty(etablissementConseilsScientifiques)){
etablissementConseilsScientifiques.forEach(e->etablissementConseilsScientifiqueDao.delete(e));
}
}
@Override
public void update(List<EtablissementConseilsScientifique> etablissementConseilsScientifiques){
if(ListUtil.isNotEmpty(etablissementConseilsScientifiques)){
etablissementConseilsScientifiques.forEach(e->etablissementConseilsScientifiqueDao.save(e));
}
}





    }

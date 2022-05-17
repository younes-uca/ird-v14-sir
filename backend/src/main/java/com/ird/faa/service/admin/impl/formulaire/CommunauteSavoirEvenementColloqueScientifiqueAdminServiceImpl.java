package com.ird.faa.service.admin.impl.formulaire;

import com.ird.faa.bean.formulaire.CommunauteSavoir;
import com.ird.faa.bean.formulaire.CommunauteSavoirEvenementColloqueScientifique;
import com.ird.faa.bean.formulaire.EvenementColloqueScienntifique;
import com.ird.faa.dao.formulaire.CommunauteSavoirEvenementColloqueScientifiqueDao;
import com.ird.faa.service.admin.facade.formulaire.CommunauteSavoirAdminService;
import com.ird.faa.service.admin.facade.formulaire.CommunauteSavoirEvenementColloqueScientifiqueAdminService;
import com.ird.faa.service.admin.facade.formulaire.EvenementColloqueScienntifiqueAdminService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.CommunauteSavoirEvenementColloqueScientifiqueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommunauteSavoirEvenementColloqueScientifiqueAdminServiceImpl extends AbstractServiceImpl<CommunauteSavoirEvenementColloqueScientifique> implements CommunauteSavoirEvenementColloqueScientifiqueAdminService {

@Autowired
private CommunauteSavoirEvenementColloqueScientifiqueDao communauteSavoirEvenementColloqueScientifiqueDao;

        @Autowired
        private EvenementColloqueScienntifiqueAdminService evenementColloqueScienntifiqueService ;
        @Autowired
        private CommunauteSavoirAdminService communauteSavoirService ;


@Autowired
private EntityManager entityManager;


@Override
public List<CommunauteSavoirEvenementColloqueScientifique> findAll(){
        return communauteSavoirEvenementColloqueScientifiqueDao.findAll();
}
        @Override
        public List<CommunauteSavoirEvenementColloqueScientifique> findByEvenementColloqueScienntifiqueId(Long id){
        return communauteSavoirEvenementColloqueScientifiqueDao.findByEvenementColloqueScienntifiqueId(id);
        }

        @Override
        @Transactional
        public int deleteByEvenementColloqueScienntifiqueId(Long id){
        return communauteSavoirEvenementColloqueScientifiqueDao.deleteByEvenementColloqueScienntifiqueId(id);
        }


        @Override
        public List<CommunauteSavoirEvenementColloqueScientifique> findByCommunauteSavoirCode(String code){
        return communauteSavoirEvenementColloqueScientifiqueDao.findByCommunauteSavoirCode(code);
        }

        @Override
        @Transactional
        public int deleteByCommunauteSavoirCode(String code){
        return communauteSavoirEvenementColloqueScientifiqueDao.deleteByCommunauteSavoirCode(code);
        }

        @Override
        public List<CommunauteSavoirEvenementColloqueScientifique> findByCommunauteSavoirId(Long id){
        return communauteSavoirEvenementColloqueScientifiqueDao.findByCommunauteSavoirId(id);
        }

        @Override
        @Transactional
        public int deleteByCommunauteSavoirId(Long id){
        return communauteSavoirEvenementColloqueScientifiqueDao.deleteByCommunauteSavoirId(id);
        }


@Override
public CommunauteSavoirEvenementColloqueScientifique findById(Long id){
if(id==null) return null;
return communauteSavoirEvenementColloqueScientifiqueDao.getOne(id);
}

@Override
public CommunauteSavoirEvenementColloqueScientifique findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(communauteSavoirEvenementColloqueScientifiqueDao.findById(id).isPresent())  {
communauteSavoirEvenementColloqueScientifiqueDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public CommunauteSavoirEvenementColloqueScientifique update(CommunauteSavoirEvenementColloqueScientifique communauteSavoirEvenementColloqueScientifique){
CommunauteSavoirEvenementColloqueScientifique foundedCommunauteSavoirEvenementColloqueScientifique = findById(communauteSavoirEvenementColloqueScientifique.getId());
if(foundedCommunauteSavoirEvenementColloqueScientifique==null) return null;
else{
return  communauteSavoirEvenementColloqueScientifiqueDao.save(communauteSavoirEvenementColloqueScientifique);
}
}

@Override
public CommunauteSavoirEvenementColloqueScientifique save (CommunauteSavoirEvenementColloqueScientifique communauteSavoirEvenementColloqueScientifique){



    findEvenementColloqueScienntifique(communauteSavoirEvenementColloqueScientifique);
    findCommunauteSavoir(communauteSavoirEvenementColloqueScientifique);

    return communauteSavoirEvenementColloqueScientifiqueDao.save(communauteSavoirEvenementColloqueScientifique);


}

@Override
public List<CommunauteSavoirEvenementColloqueScientifique> save(List<CommunauteSavoirEvenementColloqueScientifique> communauteSavoirEvenementColloqueScientifiques){
List<CommunauteSavoirEvenementColloqueScientifique> list = new ArrayList<>();
for(CommunauteSavoirEvenementColloqueScientifique communauteSavoirEvenementColloqueScientifique: communauteSavoirEvenementColloqueScientifiques){
list.add(save(communauteSavoirEvenementColloqueScientifique));
}
return list;
}



@Override
@Transactional
public int delete(CommunauteSavoirEvenementColloqueScientifique communauteSavoirEvenementColloqueScientifique){
    if(communauteSavoirEvenementColloqueScientifique.getId()==null) return -1;
    CommunauteSavoirEvenementColloqueScientifique foundedCommunauteSavoirEvenementColloqueScientifique = findById(communauteSavoirEvenementColloqueScientifique.getId());
    if(foundedCommunauteSavoirEvenementColloqueScientifique==null) return -1;
communauteSavoirEvenementColloqueScientifiqueDao.delete(foundedCommunauteSavoirEvenementColloqueScientifique);
return 1;
}


public List<CommunauteSavoirEvenementColloqueScientifique> findByCriteria(CommunauteSavoirEvenementColloqueScientifiqueVo communauteSavoirEvenementColloqueScientifiqueVo){

String query = "SELECT o FROM CommunauteSavoirEvenementColloqueScientifique o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",communauteSavoirEvenementColloqueScientifiqueVo.getId());
    if(communauteSavoirEvenementColloqueScientifiqueVo.getEvenementColloqueScienntifiqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "evenementColloqueScienntifique.id","=",communauteSavoirEvenementColloqueScientifiqueVo.getEvenementColloqueScienntifiqueVo().getId());
    }

    if(communauteSavoirEvenementColloqueScientifiqueVo.getCommunauteSavoirVo()!=null){
        query += SearchUtil.addConstraint( "o", "communauteSavoir.id","=",communauteSavoirEvenementColloqueScientifiqueVo.getCommunauteSavoirVo().getId());
            query += SearchUtil.addConstraint( "o", "communauteSavoir.code","LIKE",communauteSavoirEvenementColloqueScientifiqueVo.getCommunauteSavoirVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findEvenementColloqueScienntifique(CommunauteSavoirEvenementColloqueScientifique communauteSavoirEvenementColloqueScientifique){
        EvenementColloqueScienntifique loadedEvenementColloqueScienntifique = null;
        if(communauteSavoirEvenementColloqueScientifique.getEvenementColloqueScienntifique() != null && communauteSavoirEvenementColloqueScientifique.getEvenementColloqueScienntifique().getId() !=null)
        loadedEvenementColloqueScienntifique =evenementColloqueScienntifiqueService.findById(communauteSavoirEvenementColloqueScientifique.getEvenementColloqueScienntifique().getId());

    if(loadedEvenementColloqueScienntifique==null ) {
    return;
    }
    communauteSavoirEvenementColloqueScientifique.setEvenementColloqueScienntifique(loadedEvenementColloqueScienntifique);
    }
    private void findCommunauteSavoir(CommunauteSavoirEvenementColloqueScientifique communauteSavoirEvenementColloqueScientifique){
        CommunauteSavoir loadedCommunauteSavoir =communauteSavoirService.findByIdOrCode(communauteSavoirEvenementColloqueScientifique.getCommunauteSavoir());

    if(loadedCommunauteSavoir==null ) {
    return;
    }
    communauteSavoirEvenementColloqueScientifique.setCommunauteSavoir(loadedCommunauteSavoir);
    }

@Override
@Transactional
public void delete(List<CommunauteSavoirEvenementColloqueScientifique> communauteSavoirEvenementColloqueScientifiques){
if(ListUtil.isNotEmpty(communauteSavoirEvenementColloqueScientifiques)){
communauteSavoirEvenementColloqueScientifiques.forEach(e->communauteSavoirEvenementColloqueScientifiqueDao.delete(e));
}
}
@Override
public void update(List<CommunauteSavoirEvenementColloqueScientifique> communauteSavoirEvenementColloqueScientifiques){
if(ListUtil.isNotEmpty(communauteSavoirEvenementColloqueScientifiques)){
communauteSavoirEvenementColloqueScientifiques.forEach(e->communauteSavoirEvenementColloqueScientifiqueDao.save(e));
}
}





    }

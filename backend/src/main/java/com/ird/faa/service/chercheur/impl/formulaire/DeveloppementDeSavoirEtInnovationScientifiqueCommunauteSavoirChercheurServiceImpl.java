package com.ird.faa.service.chercheur.impl.formulaire;

import com.ird.faa.bean.formulaire.CommunauteSavoir;
import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifique;
import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir;
import com.ird.faa.dao.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao;
import com.ird.faa.service.chercheur.facade.formulaire.CommunauteSavoirChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoirChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoirVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoirChercheurServiceImpl extends AbstractServiceImpl<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> implements DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoirChercheurService {

@Autowired
private DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao;

        @Autowired
        private DeveloppementDeSavoirEtInnovationScientifiqueChercheurService developpementDeSavoirEtInnovationScientifiqueService ;
        @Autowired
        private CommunauteSavoirChercheurService communauteSavoirService ;


@Autowired
private EntityManager entityManager;


@Override
public List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> findAll(){
        return developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.findAll();
}

        @Override
        public List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> findByCommunauteSavoirCode(String code){
        return developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.findByCommunauteSavoirCode(code);
        }

        @Override
        @Transactional
        public int deleteByCommunauteSavoirCode(String code){
        return developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.deleteByCommunauteSavoirCode(code);
        }

        @Override
        public List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> findByCommunauteSavoirId(Long id){
        return developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.findByCommunauteSavoirId(id);
        }

        @Override
        @Transactional
        public int deleteByCommunauteSavoirId(Long id){
        return developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.deleteByCommunauteSavoirId(id);
        }

        @Override
        public List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> findByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id){
        return developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.findByDeveloppementDeSavoirEtInnovationScientifiqueId(id);
        }

        @Override
        @Transactional
        public int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id){
        return developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(id);
        }


@Override
public DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir findById(Long id){
if(id==null) return null;
return developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.getOne(id);
}

@Override
public DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.findById(id).isPresent())  {
developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir update(DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir){
DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir foundedDeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir = findById(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir.getId());
if(foundedDeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir==null) return null;
else{
return  developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.save(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir);
}
}

@Override
public DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir save (DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir){



    findCommunauteSavoir(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir);
    findDeveloppementDeSavoirEtInnovationScientifique(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir);

    return developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.save(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir);


}

@Override
public List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> save(List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirs){
List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> list = new ArrayList<>();
for(DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir: developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirs){
list.add(save(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir));
}
return list;
}



@Override
@Transactional
public int delete(DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir){
    if(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir.getId()==null) return -1;
    DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir foundedDeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir = findById(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir.getId());
    if(foundedDeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir==null) return -1;
developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.delete(foundedDeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir);
return 1;
}


public List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> findByCriteria(DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoirVo developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirVo){

String query = "SELECT o FROM DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirVo.getId());
    if(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirVo.getCommunauteSavoirVo()!=null){
        query += SearchUtil.addConstraint( "o", "communauteSavoir.id","=",developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirVo.getCommunauteSavoirVo().getId());
            query += SearchUtil.addConstraint( "o", "communauteSavoir.code","LIKE",developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirVo.getCommunauteSavoirVo().getCode());
    }

    if(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirVo.getDeveloppementDeSavoirEtInnovationScientifiqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "developpementDeSavoirEtInnovationScientifique.id","=",developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirVo.getDeveloppementDeSavoirEtInnovationScientifiqueVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findCommunauteSavoir(DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir){
        CommunauteSavoir loadedCommunauteSavoir =communauteSavoirService.findByIdOrCode(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir.getCommunauteSavoir());

    if(loadedCommunauteSavoir==null ) {
    return;
    }
    developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir.setCommunauteSavoir(loadedCommunauteSavoir);
    }
    private void findDeveloppementDeSavoirEtInnovationScientifique(DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir){
        DeveloppementDeSavoirEtInnovationScientifique loadedDeveloppementDeSavoirEtInnovationScientifique = null;
        if(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir.getDeveloppementDeSavoirEtInnovationScientifique() != null && developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir.getDeveloppementDeSavoirEtInnovationScientifique().getId() !=null)
        loadedDeveloppementDeSavoirEtInnovationScientifique =developpementDeSavoirEtInnovationScientifiqueService.findById(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir.getDeveloppementDeSavoirEtInnovationScientifique().getId());

    if(loadedDeveloppementDeSavoirEtInnovationScientifique==null ) {
    return;
    }
    developpementDeSavoirEtInnovationScientifiqueCommunauteSavoir.setDeveloppementDeSavoirEtInnovationScientifique(loadedDeveloppementDeSavoirEtInnovationScientifique);
    }

@Override
@Transactional
public void delete(List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirs){
if(ListUtil.isNotEmpty(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirs)){
developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirs.forEach(e->developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.delete(e));
}
}
@Override
public void update(List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirs){
if(ListUtil.isNotEmpty(developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirs)){
developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirs.forEach(e->developpementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao.save(e));
}
}





    }

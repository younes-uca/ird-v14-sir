package com.ird.faa.service.chercheur.impl.formulaire;

import com.ird.faa.bean.formulaire.CategorieNotification;
import com.ird.faa.dao.formulaire.CategorieNotificationDao;
import com.ird.faa.service.chercheur.facade.formulaire.CategorieNotificationChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.CategorieNotificationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieNotificationChercheurServiceImpl extends AbstractServiceImpl<CategorieNotification> implements CategorieNotificationChercheurService {

@Autowired
private CategorieNotificationDao categorieNotificationDao;



@Autowired
private EntityManager entityManager;


@Override
public List<CategorieNotification> findAll(){
        return categorieNotificationDao.findAll();
}
    @Override
    public CategorieNotification findByCode(String code){
    if( code==null) return null;
    return categorieNotificationDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return categorieNotificationDao.deleteByCode(code);
    }
    @Override
    public CategorieNotification findByIdOrCode(CategorieNotification categorieNotification){
    CategorieNotification resultat=null;
    if(categorieNotification != null){
    if(StringUtil.isNotEmpty(categorieNotification.getId())){
    resultat= categorieNotificationDao.getOne(categorieNotification.getId());
    }else if(StringUtil.isNotEmpty(categorieNotification.getCode())) {
    resultat= categorieNotificationDao.findByCode(categorieNotification.getCode());
    }
    }
    return resultat;
    }

@Override
public CategorieNotification findById(Long id){
if(id==null) return null;
return categorieNotificationDao.getOne(id);
}

@Override
public CategorieNotification findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(categorieNotificationDao.findById(id).isPresent())  {
categorieNotificationDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public CategorieNotification update(CategorieNotification categorieNotification){
CategorieNotification foundedCategorieNotification = findById(categorieNotification.getId());
if(foundedCategorieNotification==null) return null;
else{
return  categorieNotificationDao.save(categorieNotification);
}
}

@Override
public CategorieNotification save (CategorieNotification categorieNotification){

    CategorieNotification result =null;
    CategorieNotification foundedCategorieNotification = findByCode(categorieNotification.getCode());
    if(foundedCategorieNotification == null){




    CategorieNotification savedCategorieNotification = categorieNotificationDao.save(categorieNotification);

    result = savedCategorieNotification;
    }

    return result;
}

@Override
public List<CategorieNotification> save(List<CategorieNotification> categorieNotifications){
List<CategorieNotification> list = new ArrayList<>();
for(CategorieNotification categorieNotification: categorieNotifications){
list.add(save(categorieNotification));
}
return list;
}



@Override
@Transactional
public int delete(CategorieNotification categorieNotification){
    if(categorieNotification.getCode()==null) return -1;

    CategorieNotification foundedCategorieNotification = findByCode(categorieNotification.getCode());
    if(foundedCategorieNotification==null) return -1;
categorieNotificationDao.delete(foundedCategorieNotification);
return 1;
}


public List<CategorieNotification> findByCriteria(CategorieNotificationVo categorieNotificationVo){

String query = "SELECT o FROM CategorieNotification o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",categorieNotificationVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",categorieNotificationVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",categorieNotificationVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<CategorieNotification> categorieNotifications){
if(ListUtil.isNotEmpty(categorieNotifications)){
categorieNotifications.forEach(e->categorieNotificationDao.delete(e));
}
}
@Override
public void update(List<CategorieNotification> categorieNotifications){
if(ListUtil.isNotEmpty(categorieNotifications)){
categorieNotifications.forEach(e->categorieNotificationDao.save(e));
}
}





    }

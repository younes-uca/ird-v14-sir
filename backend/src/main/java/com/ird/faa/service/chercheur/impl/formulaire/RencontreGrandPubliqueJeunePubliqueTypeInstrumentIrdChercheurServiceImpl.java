package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePublique;
import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd;
import com.ird.faa.bean.referentiel.TypeInstrumentIrd;
import com.ird.faa.dao.formulaire.RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreGrandPubliqueJeunePubliqueChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.TypeInstrumentIrdChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo;

@Service
public class RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdChercheurServiceImpl
		extends AbstractServiceImpl<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd>
		implements RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdChercheurService {

@Autowired
	private RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao;

        @Autowired
        private RencontreGrandPubliqueJeunePubliqueChercheurService rencontreGrandPubliqueJeunePubliqueService ;
        @Autowired
		private TypeInstrumentIrdChercheurService TypeInstrumentIrdService;


@Autowired
private EntityManager entityManager;


@Override
public List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> findAll() {
	return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao.findAll();
}

        @Override
		public List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> findByTypeInstrumentIrdCode(String code) {
			return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao.findByTypeInstrumentIrdCode(code);
        }

        @Override
        @Transactional
		public int deleteByTypeInstrumentIrdCode(String code) {
			return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao.deleteByTypeInstrumentIrdCode(code);
        }

        @Override
		public List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> findByTypeInstrumentIrdId(Long id) {
			return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao.findByTypeInstrumentIrdId(id);
        }

        @Override
        @Transactional
		public int deleteByTypeInstrumentIrdId(Long id) {
			return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao.deleteByTypeInstrumentIrdId(id);
        }

        @Override
		public List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> findByRencontreGrandPubliqueJeunePubliqueId(
				Long id) {
			return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao
					.findByRencontreGrandPubliqueJeunePubliqueId(id);
        }

        @Override
        @Transactional
        public int deleteByRencontreGrandPubliqueJeunePubliqueId(Long id){
			return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao
					.deleteByRencontreGrandPubliqueJeunePubliqueId(id);
        }


@Override
public RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd findById(Long id) {
if(id==null) return null;
	return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao.getOne(id);
}

@Override
public RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd findByIdWithAssociatedList(Long id) {
	RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd = findById(
			id);
	return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd;
}


@Transactional
public int deleteById(Long id){
	if (rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao.findById(id) == null)
		return 0;
else{
		rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao.deleteById(id);
return 1;
}
}


@Override
public RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd update(
		RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd) {
	RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd foundedRencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd = findById(
			rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd.getId());
	if (foundedRencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd == null)
		return null;
else{
		return rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao
				.save(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd);
}
}

@Override
public RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd save(
		RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd) {


	findTypeInstrumentIrd(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd);
	findRencontreGrandPubliqueJeunePublique(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd);

	RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd savedRencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd = rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao
			.save(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd);
	return savedRencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd;
}

@Override
public List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> save(
		List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrds) {
	List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> list = new ArrayList<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd>();
	for (RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd : rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrds) {
		list.add(save(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd));
}
return list;
}



@Override
@Transactional
public int delete(
		RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd) {
	if (rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd.getId() == null)
		return -1;
	RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd foundedRencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd = findById(
			rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd.getId());
	if (foundedRencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd == null)
		return -1;
	rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao
			.delete(foundedRencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd);
return 1;
}


public List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> findByCriteria(
		RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo) {

	String query = "SELECT o FROM RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd o where 1=1 ";

	query += SearchUtil.addConstraint("o", "id", "=", rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo.getId());
	if (rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo.getTypeInstrumentIrdVo() != null) {
		query += SearchUtil.addConstraint("o", "TypeInstrumentIrd.id", "=",
				rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo.getTypeInstrumentIrdVo().getId());
		query += SearchUtil.addConstraint("o", "TypeInstrumentIrd.code", "LIKE",
				rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo.getTypeInstrumentIrdVo().getCode());
    }

	if (rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo.getRencontreGrandPubliqueJeunePubliqueVo() != null) {
		query += SearchUtil.addConstraint("o", "rencontreGrandPubliqueJeunePublique.id", "=",
				rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo.getRencontreGrandPubliqueJeunePubliqueVo()
						.getId());
    }

return entityManager.createQuery(query).getResultList();
}

private void findTypeInstrumentIrd(
		RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd) {
	TypeInstrumentIrd loadedTypeInstrumentIrd = TypeInstrumentIrdService
			.findByIdOrCode(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd.getTypeInstrumentIrd());

	if (loadedTypeInstrumentIrd == null) {
        return;
    }
	rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd.setTypeInstrumentIrd(loadedTypeInstrumentIrd);
    }

private void findRencontreGrandPubliqueJeunePublique(
		RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd) {
        RencontreGrandPubliqueJeunePublique loadedRencontreGrandPubliqueJeunePublique = null;
	if (rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd.getRencontreGrandPubliqueJeunePublique() != null
			&& rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd.getRencontreGrandPubliqueJeunePublique()
					.getId() != null)
		loadedRencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePubliqueService.findById(
				rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd.getRencontreGrandPubliqueJeunePublique().getId());

    if(loadedRencontreGrandPubliqueJeunePublique==null ) {
        return;
    }
	rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd
			.setRencontreGrandPubliqueJeunePublique(loadedRencontreGrandPubliqueJeunePublique);
    }

@Override
@Transactional
public void delete(
		List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrds) {
	if (ListUtil.isNotEmpty(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrds)) {
		rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrds
				.forEach(e -> rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdDao.delete(e));
        }
}
@Override
public void update(
		List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrds) {
	if (ListUtil.isNotEmpty(rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrds)) {
		rencontreGrandPubliqueJeunePubliqueTypeInstrumentIrds
				.forEach(e ->{
					if (e.getId() != null) {
						update(e);
					} else {
						save(e);
					}
				} );
}
}



@Override
public List<List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd>> getToBeSavedAndToBeDeleted(
		List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> oldList,
		List<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd> newList) {
            return super.getToBeSavedAndToBeDeleted(oldList,newList);
            }

}

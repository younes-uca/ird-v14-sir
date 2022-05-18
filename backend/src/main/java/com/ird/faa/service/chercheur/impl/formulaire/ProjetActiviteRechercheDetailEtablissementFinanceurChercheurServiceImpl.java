package com.ird.faa.service.chercheur.impl.formulaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ird.faa.bean.referentiel.Etablissement;
import com.ird.faa.bean.formulaire.ProjetActiviteRechercheDetail;
import com.ird.faa.bean.formulaire.ProjetActiviteRechercheDetailEtablissementFinanceur;
import com.ird.faa.dao.formulaire.ProjetActiviteRechercheDetailEtablissementFinanceurDao;
import com.ird.faa.service.chercheur.facade.formulaire.EtablissementChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.ProjetActiviteRechercheDetailChercheurService;
import com.ird.faa.service.chercheur.facade.formulaire.ProjetActiviteRechercheDetailEtablissementFinanceurChercheurService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.ProjetActiviteRechercheDetailEtablissementFinanceurVo;
@Service
public class ProjetActiviteRechercheDetailEtablissementFinanceurChercheurServiceImpl  extends AbstractServiceImpl<ProjetActiviteRechercheDetailEtablissementFinanceur> implements ProjetActiviteRechercheDetailEtablissementFinanceurChercheurService {
	@Autowired
	private ProjetActiviteRechercheDetailEtablissementFinanceurDao projetActiviteRechercheDetailEtablissementFinanceurDao;

	        @Autowired
	        private ProjetActiviteRechercheDetailChercheurService projetActiviteRechercheDetailService ;
	        @Autowired
	        private EtablissementChercheurService etablissementService ;


	@Autowired
	private EntityManager entityManager;


	@Override
	public List<ProjetActiviteRechercheDetailEtablissementFinanceur> findAll(){
	return projetActiviteRechercheDetailEtablissementFinanceurDao.findAll();
	}

	        @Override
	        public List<ProjetActiviteRechercheDetailEtablissementFinanceur> findByEtablissementCode(String code){
	        return projetActiviteRechercheDetailEtablissementFinanceurDao.findByEtablissementCode(code);
	        }

	        @Override
	        @Transactional
	        public int deleteByEtablissementCode(String code){
	        return projetActiviteRechercheDetailEtablissementFinanceurDao.deleteByEtablissementCode(code);
	        }

	        @Override
	        public List<ProjetActiviteRechercheDetailEtablissementFinanceur> findByEtablissementId(Long id){
	        return projetActiviteRechercheDetailEtablissementFinanceurDao.findByEtablissementId(id);
	        }

	        @Override
	        @Transactional
	        public int deleteByEtablissementId(Long id){
	        return projetActiviteRechercheDetailEtablissementFinanceurDao.deleteByEtablissementId(id);
	        }

	        @Override
	        public List<ProjetActiviteRechercheDetailEtablissementFinanceur> findByProjetActiviteRechercheDetailId(Long id){
	        return projetActiviteRechercheDetailEtablissementFinanceurDao.findByProjetActiviteRechercheDetailId(id);
	        }

	        @Override
	        @Transactional
	        public int deleteByProjetActiviteRechercheDetailId(Long id){
	        return projetActiviteRechercheDetailEtablissementFinanceurDao.deleteByProjetActiviteRechercheDetailId(id);
	        }


	@Override
	public ProjetActiviteRechercheDetailEtablissementFinanceur findById(Long id){
	if(id==null) return null;
	return projetActiviteRechercheDetailEtablissementFinanceurDao.getOne(id);
	}

	@Override
	public ProjetActiviteRechercheDetailEtablissementFinanceur findByIdWithAssociatedList(Long id){
	ProjetActiviteRechercheDetailEtablissementFinanceur ProjetActiviteRechercheDetailEtablissementFinanceur  = findById(id);
	return ProjetActiviteRechercheDetailEtablissementFinanceur;
	}


	@Transactional
	public int deleteById(Long id){
	if(projetActiviteRechercheDetailEtablissementFinanceurDao.findById(id) == null) return 0;
	else{
	projetActiviteRechercheDetailEtablissementFinanceurDao.deleteById(id);
	return 1;
	}
	}


	@Override
	public ProjetActiviteRechercheDetailEtablissementFinanceur update(ProjetActiviteRechercheDetailEtablissementFinanceur ProjetActiviteRechercheDetailEtablissementFinanceur){
	ProjetActiviteRechercheDetailEtablissementFinanceur foundedProjetActiviteRechercheDetailEtablissementFinanceur = findById(ProjetActiviteRechercheDetailEtablissementFinanceur.getId());
	if(foundedProjetActiviteRechercheDetailEtablissementFinanceur==null) return null;
	else{
	return  projetActiviteRechercheDetailEtablissementFinanceurDao.save(ProjetActiviteRechercheDetailEtablissementFinanceur);
	}
	}

	@Override
	public ProjetActiviteRechercheDetailEtablissementFinanceur save (ProjetActiviteRechercheDetailEtablissementFinanceur ProjetActiviteRechercheDetailEtablissementFinanceur){


	    findEtablissement(ProjetActiviteRechercheDetailEtablissementFinanceur);
	    findProjetActiviteRechercheDetail(ProjetActiviteRechercheDetailEtablissementFinanceur);

	ProjetActiviteRechercheDetailEtablissementFinanceur savedProjetActiviteRechercheDetailEtablissementFinanceur = projetActiviteRechercheDetailEtablissementFinanceurDao.save(ProjetActiviteRechercheDetailEtablissementFinanceur);
	return savedProjetActiviteRechercheDetailEtablissementFinanceur;
	}

	@Override
	public List<ProjetActiviteRechercheDetailEtablissementFinanceur> save(List<ProjetActiviteRechercheDetailEtablissementFinanceur> ProjetActiviteRechercheDetailEtablissementFinanceurs){
	List<ProjetActiviteRechercheDetailEtablissementFinanceur> list = new ArrayList<ProjetActiviteRechercheDetailEtablissementFinanceur>();
	for(ProjetActiviteRechercheDetailEtablissementFinanceur ProjetActiviteRechercheDetailEtablissementFinanceur: ProjetActiviteRechercheDetailEtablissementFinanceurs){
	list.add(save(ProjetActiviteRechercheDetailEtablissementFinanceur));
	}
	return list;
	}



	@Override
	@Transactional
	public int delete(ProjetActiviteRechercheDetailEtablissementFinanceur ProjetActiviteRechercheDetailEtablissementFinanceur){
	    if(ProjetActiviteRechercheDetailEtablissementFinanceur.getId()==null) return -1;
	    ProjetActiviteRechercheDetailEtablissementFinanceur foundedProjetActiviteRechercheDetailEtablissementFinanceur = findById(ProjetActiviteRechercheDetailEtablissementFinanceur.getId());
	    if(foundedProjetActiviteRechercheDetailEtablissementFinanceur==null) return -1;
	projetActiviteRechercheDetailEtablissementFinanceurDao.delete(foundedProjetActiviteRechercheDetailEtablissementFinanceur);
	return 1;
	}


	public List<ProjetActiviteRechercheDetailEtablissementFinanceur> findByCriteria(ProjetActiviteRechercheDetailEtablissementFinanceurVo ProjetActiviteRechercheDetailEtablissementFinanceurVo){

	String query = "SELECT o FROM ProjetActiviteRechercheDetailEtablissementFinanceur o where 1=1 ";

	            query += SearchUtil.addConstraint( "o", "id","=",ProjetActiviteRechercheDetailEtablissementFinanceurVo.getId());
	    if(ProjetActiviteRechercheDetailEtablissementFinanceurVo.getEtablissementVo()!=null){
	        query += SearchUtil.addConstraint( "o", "etablissement.id","=",ProjetActiviteRechercheDetailEtablissementFinanceurVo.getEtablissementVo().getId());
	            query += SearchUtil.addConstraint( "o", "etablissement.code","LIKE",ProjetActiviteRechercheDetailEtablissementFinanceurVo.getEtablissementVo().getCode());
	    }

	    if(ProjetActiviteRechercheDetailEtablissementFinanceurVo.getProjetActiviteRechercheDetailVo()!=null){
	        query += SearchUtil.addConstraint( "o", "projetActiviteRechercheDetail.id","=",ProjetActiviteRechercheDetailEtablissementFinanceurVo.getProjetActiviteRechercheDetailVo().getId());
	    }

	return entityManager.createQuery(query).getResultList();
	}

	    private void findEtablissement(ProjetActiviteRechercheDetailEtablissementFinanceur ProjetActiviteRechercheDetailEtablissementFinanceur){
	        Etablissement loadedEtablissement =etablissementService.findByIdOrCode(ProjetActiviteRechercheDetailEtablissementFinanceur.getEtablissement());

	    if(loadedEtablissement==null ) {
	        return;
	    }
	    ProjetActiviteRechercheDetailEtablissementFinanceur.setEtablissement(loadedEtablissement);
	    }
	    private void findProjetActiviteRechercheDetail(ProjetActiviteRechercheDetailEtablissementFinanceur ProjetActiviteRechercheDetailEtablissementFinanceur){
	        ProjetActiviteRechercheDetail loadedProjetActiviteRechercheDetail = null;
	        if(ProjetActiviteRechercheDetailEtablissementFinanceur.getProjetActiviteRechercheDetail() != null && ProjetActiviteRechercheDetailEtablissementFinanceur.getProjetActiviteRechercheDetail().getId() !=null)
	        loadedProjetActiviteRechercheDetail =projetActiviteRechercheDetailService.findById(ProjetActiviteRechercheDetailEtablissementFinanceur.getProjetActiviteRechercheDetail().getId());

	    if(loadedProjetActiviteRechercheDetail==null ) {
	        return;
	    }
	    ProjetActiviteRechercheDetailEtablissementFinanceur.setProjetActiviteRechercheDetail(loadedProjetActiviteRechercheDetail);
	    }

	@Override
	@Transactional
	public void delete(List<ProjetActiviteRechercheDetailEtablissementFinanceur> ProjetActiviteRechercheDetailEtablissementFinanceurs){
	        if(ListUtil.isNotEmpty(ProjetActiviteRechercheDetailEtablissementFinanceurs)){
	        ProjetActiviteRechercheDetailEtablissementFinanceurs.forEach(e->projetActiviteRechercheDetailEtablissementFinanceurDao.delete(e));
	        }
	}
	@Override
	public void update(List<ProjetActiviteRechercheDetailEtablissementFinanceur> ProjetActiviteRechercheDetailEtablissementFinanceurs){
	if(ListUtil.isNotEmpty(ProjetActiviteRechercheDetailEtablissementFinanceurs)){
	ProjetActiviteRechercheDetailEtablissementFinanceurs.forEach(e->projetActiviteRechercheDetailEtablissementFinanceurDao.save(e));
	}
	}



	@Override
	public List<List<ProjetActiviteRechercheDetailEtablissementFinanceur>>  getToBeSavedAndToBeDeleted(List<ProjetActiviteRechercheDetailEtablissementFinanceur> oldList,List<ProjetActiviteRechercheDetailEtablissementFinanceur> newList){
	            return super.getToBeSavedAndToBeDeleted(oldList,newList);
	            }

	}

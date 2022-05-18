package com.ird.faa.service.admin.impl.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifique;
import com.ird.faa.bean.formulaire.DisciplineScientifiqueErc;
import com.ird.faa.bean.formulaire.DisciplineScientifiqueErcAssociation;
import com.ird.faa.bean.formulaire.SemanticRelationship;
import com.ird.faa.dao.formulaire.DisciplineScientifiqueErcAssociationDao;
import com.ird.faa.service.admin.facade.formulaire.DisciplineScientifiqueAdminService;
import com.ird.faa.service.admin.facade.formulaire.DisciplineScientifiqueErcAdminService;
import com.ird.faa.service.admin.facade.formulaire.DisciplineScientifiqueErcAssociationAdminService;
import com.ird.faa.service.admin.facade.formulaire.SemanticRelationshipAdminService;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.DisciplineScientifiqueErcAssociationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DisciplineScientifiqueErcAssociationAdminServiceImpl extends AbstractServiceImpl<DisciplineScientifiqueErcAssociation> implements DisciplineScientifiqueErcAssociationAdminService {

@Autowired
private DisciplineScientifiqueErcAssociationDao disciplineScientifiqueErcAssociationDao;

    @Autowired
    private ArchivableService<DisciplineScientifiqueErcAssociation> archivableService;
        @Autowired
        private DisciplineScientifiqueAdminService disciplineScientifiqueService ;
        @Autowired
        private SemanticRelationshipAdminService semanticRelationshipService ;
        @Autowired
        private DisciplineScientifiqueErcAdminService disciplineScientifiqueErcService ;


@Autowired
private EntityManager entityManager;


@Override
public List<DisciplineScientifiqueErcAssociation> findAll(){
        return disciplineScientifiqueErcAssociationDao.findAll();
}

        @Override
        public List<DisciplineScientifiqueErcAssociation> findByDisciplineScientifiqueErcCode(String code){
        return disciplineScientifiqueErcAssociationDao.findByDisciplineScientifiqueErcCode(code);
        }

        @Override
        @Transactional
        public int deleteByDisciplineScientifiqueErcCode(String code){
        return disciplineScientifiqueErcAssociationDao.deleteByDisciplineScientifiqueErcCode(code);
        }

        @Override
        public List<DisciplineScientifiqueErcAssociation> findByDisciplineScientifiqueErcId(Long id){
        return disciplineScientifiqueErcAssociationDao.findByDisciplineScientifiqueErcId(id);
        }

        @Override
        @Transactional
        public int deleteByDisciplineScientifiqueErcId(Long id){
        return disciplineScientifiqueErcAssociationDao.deleteByDisciplineScientifiqueErcId(id);
        }


        @Override
        public List<DisciplineScientifiqueErcAssociation> findByDisciplineScientifiqueCode(String code){
        return disciplineScientifiqueErcAssociationDao.findByDisciplineScientifiqueCode(code);
        }

        @Override
        @Transactional
        public int deleteByDisciplineScientifiqueCode(String code){
        return disciplineScientifiqueErcAssociationDao.deleteByDisciplineScientifiqueCode(code);
        }

        @Override
        public List<DisciplineScientifiqueErcAssociation> findByDisciplineScientifiqueId(Long id){
        return disciplineScientifiqueErcAssociationDao.findByDisciplineScientifiqueId(id);
        }

        @Override
        @Transactional
        public int deleteByDisciplineScientifiqueId(Long id){
        return disciplineScientifiqueErcAssociationDao.deleteByDisciplineScientifiqueId(id);
        }


        @Override
        public List<DisciplineScientifiqueErcAssociation> findBySemanticRelationshipCode(String code){
        return disciplineScientifiqueErcAssociationDao.findBySemanticRelationshipCode(code);
        }

        @Override
        @Transactional
        public int deleteBySemanticRelationshipCode(String code){
        return disciplineScientifiqueErcAssociationDao.deleteBySemanticRelationshipCode(code);
        }

        @Override
        public List<DisciplineScientifiqueErcAssociation> findBySemanticRelationshipId(Long id){
        return disciplineScientifiqueErcAssociationDao.findBySemanticRelationshipId(id);
        }

        @Override
        @Transactional
        public int deleteBySemanticRelationshipId(Long id){
        return disciplineScientifiqueErcAssociationDao.deleteBySemanticRelationshipId(id);
        }


@Override
public DisciplineScientifiqueErcAssociation findById(Long id){
if(id==null) return null;
return disciplineScientifiqueErcAssociationDao.getOne(id);
}

@Override
public DisciplineScientifiqueErcAssociation findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public DisciplineScientifiqueErcAssociation archiver(DisciplineScientifiqueErcAssociation disciplineScientifiqueErcAssociation) {
    if (disciplineScientifiqueErcAssociation.getArchive() == null) {
    disciplineScientifiqueErcAssociation.setArchive(false);
    }
    disciplineScientifiqueErcAssociation.setArchive(true);
    disciplineScientifiqueErcAssociation.setDateArchivage(new Date());
    disciplineScientifiqueErcAssociationDao.save(disciplineScientifiqueErcAssociation);
    return disciplineScientifiqueErcAssociation;

    }

    @Override
    public DisciplineScientifiqueErcAssociation desarchiver(DisciplineScientifiqueErcAssociation disciplineScientifiqueErcAssociation) {
    if (disciplineScientifiqueErcAssociation.getArchive() == null) {
    disciplineScientifiqueErcAssociation.setArchive(false);
    }
    disciplineScientifiqueErcAssociation.setArchive(false);
    disciplineScientifiqueErcAssociationDao.save(disciplineScientifiqueErcAssociation);
    return disciplineScientifiqueErcAssociation;
    }




@Transactional
public int deleteById(Long id){
int res=0;
if(disciplineScientifiqueErcAssociationDao.findById(id).isPresent())  {
disciplineScientifiqueErcAssociationDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public DisciplineScientifiqueErcAssociation update(DisciplineScientifiqueErcAssociation disciplineScientifiqueErcAssociation){
DisciplineScientifiqueErcAssociation foundedDisciplineScientifiqueErcAssociation = findById(disciplineScientifiqueErcAssociation.getId());
if(foundedDisciplineScientifiqueErcAssociation==null) return null;
else{
    archivableService.prepare(disciplineScientifiqueErcAssociation);
return  disciplineScientifiqueErcAssociationDao.save(disciplineScientifiqueErcAssociation);
}
}
    private void prepareSave(DisciplineScientifiqueErcAssociation disciplineScientifiqueErcAssociation){
        disciplineScientifiqueErcAssociation.setDateCreation(new Date());
        if(disciplineScientifiqueErcAssociation.getDateArchivage() == null)
        disciplineScientifiqueErcAssociation.setDateArchivage(new Date());
                    if(disciplineScientifiqueErcAssociation.getArchive() == null)
                disciplineScientifiqueErcAssociation.setArchive(false);




    }

@Override
public DisciplineScientifiqueErcAssociation save (DisciplineScientifiqueErcAssociation disciplineScientifiqueErcAssociation){
    prepareSave(disciplineScientifiqueErcAssociation);



    findDisciplineScientifiqueErc(disciplineScientifiqueErcAssociation);
    findDisciplineScientifique(disciplineScientifiqueErcAssociation);
    findSemanticRelationship(disciplineScientifiqueErcAssociation);

    return disciplineScientifiqueErcAssociationDao.save(disciplineScientifiqueErcAssociation);


}

@Override
public List<DisciplineScientifiqueErcAssociation> save(List<DisciplineScientifiqueErcAssociation> disciplineScientifiqueErcAssociations){
List<DisciplineScientifiqueErcAssociation> list = new ArrayList<>();
for(DisciplineScientifiqueErcAssociation disciplineScientifiqueErcAssociation: disciplineScientifiqueErcAssociations){
list.add(save(disciplineScientifiqueErcAssociation));
}
return list;
}



@Override
@Transactional
public int delete(DisciplineScientifiqueErcAssociation disciplineScientifiqueErcAssociation){
    if(disciplineScientifiqueErcAssociation.getId()==null) return -1;
    DisciplineScientifiqueErcAssociation foundedDisciplineScientifiqueErcAssociation = findById(disciplineScientifiqueErcAssociation.getId());
    if(foundedDisciplineScientifiqueErcAssociation==null) return -1;
disciplineScientifiqueErcAssociationDao.delete(foundedDisciplineScientifiqueErcAssociation);
return 1;
}


public List<DisciplineScientifiqueErcAssociation> findByCriteria(DisciplineScientifiqueErcAssociationVo disciplineScientifiqueErcAssociationVo){

String query = "SELECT o FROM DisciplineScientifiqueErcAssociation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",disciplineScientifiqueErcAssociationVo.getId());
            query += SearchUtil.addConstraint( "o", "archive","=",disciplineScientifiqueErcAssociationVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",disciplineScientifiqueErcAssociationVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",disciplineScientifiqueErcAssociationVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",disciplineScientifiqueErcAssociationVo.getDateArchivageMin(),disciplineScientifiqueErcAssociationVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",disciplineScientifiqueErcAssociationVo.getDateCreationMin(),disciplineScientifiqueErcAssociationVo.getDateCreationMax());
    if(disciplineScientifiqueErcAssociationVo.getDisciplineScientifiqueErcVo()!=null){
        query += SearchUtil.addConstraint( "o", "disciplineScientifiqueErc.id","=",disciplineScientifiqueErcAssociationVo.getDisciplineScientifiqueErcVo().getId());
            query += SearchUtil.addConstraint( "o", "disciplineScientifiqueErc.code","LIKE",disciplineScientifiqueErcAssociationVo.getDisciplineScientifiqueErcVo().getCode());
    }

    if(disciplineScientifiqueErcAssociationVo.getDisciplineScientifiqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "disciplineScientifique.id","=",disciplineScientifiqueErcAssociationVo.getDisciplineScientifiqueVo().getId());
            query += SearchUtil.addConstraint( "o", "disciplineScientifique.code","LIKE",disciplineScientifiqueErcAssociationVo.getDisciplineScientifiqueVo().getCode());
    }

    if(disciplineScientifiqueErcAssociationVo.getSemanticRelationshipVo()!=null){
        query += SearchUtil.addConstraint( "o", "semanticRelationship.id","=",disciplineScientifiqueErcAssociationVo.getSemanticRelationshipVo().getId());
            query += SearchUtil.addConstraint( "o", "semanticRelationship.code","LIKE",disciplineScientifiqueErcAssociationVo.getSemanticRelationshipVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findDisciplineScientifiqueErc(DisciplineScientifiqueErcAssociation disciplineScientifiqueErcAssociation){
        DisciplineScientifiqueErc loadedDisciplineScientifiqueErc =disciplineScientifiqueErcService.findByIdOrCode(disciplineScientifiqueErcAssociation.getDisciplineScientifiqueErc());

    if(loadedDisciplineScientifiqueErc==null ) {
    return;
    }
    disciplineScientifiqueErcAssociation.setDisciplineScientifiqueErc(loadedDisciplineScientifiqueErc);
    }
    private void findDisciplineScientifique(DisciplineScientifiqueErcAssociation disciplineScientifiqueErcAssociation){
        DisciplineScientifique loadedDisciplineScientifique =disciplineScientifiqueService.findByIdOrCode(disciplineScientifiqueErcAssociation.getDisciplineScientifique());

    if(loadedDisciplineScientifique==null ) {
    return;
    }
    disciplineScientifiqueErcAssociation.setDisciplineScientifique(loadedDisciplineScientifique);
    }
    private void findSemanticRelationship(DisciplineScientifiqueErcAssociation disciplineScientifiqueErcAssociation){
        SemanticRelationship loadedSemanticRelationship =semanticRelationshipService.findByIdOrCode(disciplineScientifiqueErcAssociation.getSemanticRelationship());

    if(loadedSemanticRelationship==null ) {
    return;
    }
    disciplineScientifiqueErcAssociation.setSemanticRelationship(loadedSemanticRelationship);
    }

@Override
@Transactional
public void delete(List<DisciplineScientifiqueErcAssociation> disciplineScientifiqueErcAssociations){
if(ListUtil.isNotEmpty(disciplineScientifiqueErcAssociations)){
disciplineScientifiqueErcAssociations.forEach(e->disciplineScientifiqueErcAssociationDao.delete(e));
}
}
@Override
public void update(List<DisciplineScientifiqueErcAssociation> disciplineScientifiqueErcAssociations){
if(ListUtil.isNotEmpty(disciplineScientifiqueErcAssociations)){
disciplineScientifiqueErcAssociations.forEach(e->disciplineScientifiqueErcAssociationDao.save(e));
}
}





    }

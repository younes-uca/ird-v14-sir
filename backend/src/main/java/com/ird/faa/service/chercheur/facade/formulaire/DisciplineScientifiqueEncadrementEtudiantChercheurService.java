package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.DisciplineScientifiqueEncadrementEtudiant;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueEncadrementEtudiantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DisciplineScientifiqueEncadrementEtudiantChercheurService extends AbstractService<DisciplineScientifiqueEncadrementEtudiant,Long,DisciplineScientifiqueEncadrementEtudiantVo>{




/**
    * delete DisciplineScientifiqueEncadrementEtudiant from database
    * @param id - id of DisciplineScientifiqueEncadrementEtudiant to be deleted
    *
    */
    int deleteById(Long id);


    List<DisciplineScientifiqueEncadrementEtudiant> findByDisciplineScientifiqueCode(String code);

    int deleteByDisciplineScientifiqueCode(String code);

    List<DisciplineScientifiqueEncadrementEtudiant> findByDisciplineScientifiqueId(Long id);

    int deleteByDisciplineScientifiqueId(Long id);

    List<DisciplineScientifiqueEncadrementEtudiant> findByEncadrementEtudiantId(Long id);

    int deleteByEncadrementEtudiantId(Long id);





}

package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueConseilsScientifique;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueConseilsScientifiqueVo;

import java.util.List;

public interface DisciplineScientifiqueConseilsScientifiqueAdminService extends AbstractService<DisciplineScientifiqueConseilsScientifique,Long,DisciplineScientifiqueConseilsScientifiqueVo>{





/**
    * delete DisciplineScientifiqueConseilsScientifique from database
    * @param id - id of DisciplineScientifiqueConseilsScientifique to be deleted
    *
    */
    int deleteById(Long id);



    List<DisciplineScientifiqueConseilsScientifique> findByConseilsScientifiqueId(Long id);

    int deleteByConseilsScientifiqueId(Long id);
    List<DisciplineScientifiqueConseilsScientifique> findByDisciplineScientifiqueCode(String code);

    int deleteByDisciplineScientifiqueCode(String code);

    List<DisciplineScientifiqueConseilsScientifique> findByDisciplineScientifiqueId(Long id);

    int deleteByDisciplineScientifiqueId(Long id);







}
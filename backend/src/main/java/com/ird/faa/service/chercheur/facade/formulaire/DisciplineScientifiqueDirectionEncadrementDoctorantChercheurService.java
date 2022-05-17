package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.DisciplineScientifiqueDirectionEncadrementDoctorant;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueDirectionEncadrementDoctorantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DisciplineScientifiqueDirectionEncadrementDoctorantChercheurService extends AbstractService<DisciplineScientifiqueDirectionEncadrementDoctorant,Long,DisciplineScientifiqueDirectionEncadrementDoctorantVo>{




/**
    * delete DisciplineScientifiqueDirectionEncadrementDoctorant from database
    * @param id - id of DisciplineScientifiqueDirectionEncadrementDoctorant to be deleted
    *
    */
    int deleteById(Long id);



    List<DisciplineScientifiqueDirectionEncadrementDoctorant> findByDirectionEncadrementDoctorantId(Long id);

    int deleteByDirectionEncadrementDoctorantId(Long id);
    List<DisciplineScientifiqueDirectionEncadrementDoctorant> findByDisciplineScientifiqueCode(String code);

    int deleteByDisciplineScientifiqueCode(String code);

    List<DisciplineScientifiqueDirectionEncadrementDoctorant> findByDisciplineScientifiqueId(Long id);

    int deleteByDisciplineScientifiqueId(Long id);





}

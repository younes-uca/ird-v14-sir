package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.KeyWordDisciplineScientifiqueErc;
import com.ird.faa.service.core.facade.AbstractService;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.KeyWordDisciplineScientifiqueErcVo;

import java.util.List;

public interface KeyWordDisciplineScientifiqueErcAdminService extends AbstractService<KeyWordDisciplineScientifiqueErc,Long,KeyWordDisciplineScientifiqueErcVo>{





/**
    * delete KeyWordDisciplineScientifiqueErc from database
    * @param id - id of KeyWordDisciplineScientifiqueErc to be deleted
    *
    */
    int deleteById(Long id);


    List<KeyWordDisciplineScientifiqueErc> findByKeyWordCode(String code);

    int deleteByKeyWordCode(String code);

    List<KeyWordDisciplineScientifiqueErc> findByKeyWordId(Long id);

    int deleteByKeyWordId(Long id);
    List<KeyWordDisciplineScientifiqueErc> findByDisciplineScientifiqueErcCode(String code);

    int deleteByDisciplineScientifiqueErcCode(String code);

    List<KeyWordDisciplineScientifiqueErc> findByDisciplineScientifiqueErcId(Long id);

    int deleteByDisciplineScientifiqueErcId(Long id);






    KeyWordDisciplineScientifiqueErc archiver(KeyWordDisciplineScientifiqueErc keyWordDisciplineScientifiqueErc) ;
    KeyWordDisciplineScientifiqueErc desarchiver(KeyWordDisciplineScientifiqueErc keyWordDisciplineScientifiqueErc);

}

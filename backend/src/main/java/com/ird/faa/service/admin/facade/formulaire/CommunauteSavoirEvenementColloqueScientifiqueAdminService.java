package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.CommunauteSavoirEvenementColloqueScientifique;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.CommunauteSavoirEvenementColloqueScientifiqueVo;

import java.util.List;

public interface CommunauteSavoirEvenementColloqueScientifiqueAdminService extends AbstractService<CommunauteSavoirEvenementColloqueScientifique,Long,CommunauteSavoirEvenementColloqueScientifiqueVo>{





/**
    * delete CommunauteSavoirEvenementColloqueScientifique from database
    * @param id - id of CommunauteSavoirEvenementColloqueScientifique to be deleted
    *
    */
    int deleteById(Long id);



    List<CommunauteSavoirEvenementColloqueScientifique> findByEvenementColloqueScienntifiqueId(Long id);

    int deleteByEvenementColloqueScienntifiqueId(Long id);
    List<CommunauteSavoirEvenementColloqueScientifique> findByCommunauteSavoirCode(String code);

    int deleteByCommunauteSavoirCode(String code);

    List<CommunauteSavoirEvenementColloqueScientifique> findByCommunauteSavoirId(Long id);

    int deleteByCommunauteSavoirId(Long id);







}

package com.ird.faa.service.admin.facade.formulaire;

import com.ird.faa.bean.formulaire.PaysZoneGeographique;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.PaysZoneGeographiqueVo;

import java.util.List;

public interface PaysZoneGeographiqueAdminService extends AbstractService<PaysZoneGeographique,Long,PaysZoneGeographiqueVo>{





/**
    * delete PaysZoneGeographique from database
    * @param id - id of PaysZoneGeographique to be deleted
    *
    */
    int deleteById(Long id);


    List<PaysZoneGeographique> findByPaysCode(String code);

    int deleteByPaysCode(String code);

    List<PaysZoneGeographique> findByPaysId(Long id);

    int deleteByPaysId(Long id);
    List<PaysZoneGeographique> findByZoneGeographiqueCode(String code);

    int deleteByZoneGeographiqueCode(String code);

    List<PaysZoneGeographique> findByZoneGeographiqueId(Long id);

    int deleteByZoneGeographiqueId(Long id);







}

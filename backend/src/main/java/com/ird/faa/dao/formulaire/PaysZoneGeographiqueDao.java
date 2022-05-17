package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.PaysZoneGeographique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaysZoneGeographiqueDao extends JpaRepository<PaysZoneGeographique,Long> {





    List<PaysZoneGeographique> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<PaysZoneGeographique> findByPaysId(Long id);

    int deleteByPaysId(Long id);
    List<PaysZoneGeographique> findByZoneGeographiqueCode(String code);
    int deleteByZoneGeographiqueCode(String code);

    List<PaysZoneGeographique> findByZoneGeographiqueId(Long id);

    int deleteByZoneGeographiqueId(Long id);


}

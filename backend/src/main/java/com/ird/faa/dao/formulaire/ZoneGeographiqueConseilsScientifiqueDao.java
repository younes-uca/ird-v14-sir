package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.ZoneGeographiqueConseilsScientifique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ZoneGeographiqueConseilsScientifiqueDao extends JpaRepository<ZoneGeographiqueConseilsScientifique,Long> {






    List<ZoneGeographiqueConseilsScientifique> findByConseilsScientifiqueId(Long id);

    int deleteByConseilsScientifiqueId(Long id);
    List<ZoneGeographiqueConseilsScientifique> findByZoneGeographiqueCode(String code);
    int deleteByZoneGeographiqueCode(String code);

    List<ZoneGeographiqueConseilsScientifique> findByZoneGeographiqueId(Long id);

    int deleteByZoneGeographiqueId(Long id);
    List<ZoneGeographiqueConseilsScientifique> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<ZoneGeographiqueConseilsScientifique> findByPaysId(Long id);

    int deleteByPaysId(Long id);


}

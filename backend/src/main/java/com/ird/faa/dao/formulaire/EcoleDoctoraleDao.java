package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.EcoleDoctorale;


@Repository
public interface EcoleDoctoraleDao extends JpaRepository<EcoleDoctorale,Long> {




    EcoleDoctorale findByIntitule(String intitule);

    int deleteByIntitule(String intitule);

    List<EcoleDoctorale> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<EcoleDoctorale> findByPaysId(Long id);

    int deleteByPaysId(Long id);


}

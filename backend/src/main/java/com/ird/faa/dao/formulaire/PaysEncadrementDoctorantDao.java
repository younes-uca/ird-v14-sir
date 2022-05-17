package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.PaysEncadrementDoctorant;


@Repository
public interface PaysEncadrementDoctorantDao extends JpaRepository<PaysEncadrementDoctorant,Long> {





    List<PaysEncadrementDoctorant> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<PaysEncadrementDoctorant> findByPaysId(Long id);

    int deleteByPaysId(Long id);

    List<PaysEncadrementDoctorant> findByEncadrementDoctorantId(Long id);

    int deleteByEncadrementDoctorantId(Long id);


}

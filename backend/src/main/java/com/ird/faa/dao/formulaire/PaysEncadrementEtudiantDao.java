package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.PaysEncadrementEtudiant;


@Repository
public interface PaysEncadrementEtudiantDao extends JpaRepository<PaysEncadrementEtudiant,Long> {





    List<PaysEncadrementEtudiant> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<PaysEncadrementEtudiant> findByPaysId(Long id);

    int deleteByPaysId(Long id);

    List<PaysEncadrementEtudiant> findByEncadrementEtudiantId(Long id);

    int deleteByEncadrementEtudiantId(Long id);


}

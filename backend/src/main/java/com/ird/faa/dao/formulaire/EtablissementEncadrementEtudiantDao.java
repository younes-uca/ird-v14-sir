package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.EtablissementEncadrementEtudiant;


@Repository
public interface EtablissementEncadrementEtudiantDao extends JpaRepository<EtablissementEncadrementEtudiant,Long> {





    List<EtablissementEncadrementEtudiant> findByEtablissementCode(String code);
    int deleteByEtablissementCode(String code);

    List<EtablissementEncadrementEtudiant> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);

    List<EtablissementEncadrementEtudiant> findByEncadrementEtudiantId(Long id);

    int deleteByEncadrementEtudiantId(Long id);


}

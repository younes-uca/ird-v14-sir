package com.ird.faa.dao.formulaire;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.ProjetActiviteRechercheDetailEtablissementFinanceur;

@Repository
public interface ProjetActiviteRechercheDetailEtablissementFinanceurDao extends JpaRepository<ProjetActiviteRechercheDetailEtablissementFinanceur,Long> {

    List<ProjetActiviteRechercheDetailEtablissementFinanceur> findByEtablissementCode(String code);
    int deleteByEtablissementCode(String code);

    List<ProjetActiviteRechercheDetailEtablissementFinanceur> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);

    List<ProjetActiviteRechercheDetailEtablissementFinanceur> findByProjetActiviteRechercheDetailId(Long id);

    int deleteByProjetActiviteRechercheDetailId(Long id);
}

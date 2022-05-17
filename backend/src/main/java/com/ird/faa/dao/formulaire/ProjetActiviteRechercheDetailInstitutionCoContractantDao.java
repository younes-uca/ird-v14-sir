package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.ProjetActiviteRechercheDetailInstitutionCoContractant;


@Repository
public interface ProjetActiviteRechercheDetailInstitutionCoContractantDao extends JpaRepository<ProjetActiviteRechercheDetailInstitutionCoContractant,Long> {





    List<ProjetActiviteRechercheDetailInstitutionCoContractant> findByEtablissementCode(String code);
    int deleteByEtablissementCode(String code);

    List<ProjetActiviteRechercheDetailInstitutionCoContractant> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);

    List<ProjetActiviteRechercheDetailInstitutionCoContractant> findByProjetActiviteRechercheDetailId(Long id);

    int deleteByProjetActiviteRechercheDetailId(Long id);


}

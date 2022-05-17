package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.InstitutionCoContractantProjetActiviteRecherche;


@Repository
public interface InstitutionCoContractantProjetActiviteRechercheDao extends JpaRepository<InstitutionCoContractantProjetActiviteRecherche,Long> {






    List<InstitutionCoContractantProjetActiviteRecherche> findByInstitutionCoContractantId(Long id);

    int deleteByInstitutionCoContractantId(Long id);
    List<InstitutionCoContractantProjetActiviteRecherche> findByProjetActiviteRechercheAnnee(Integer annee);
    int deleteByProjetActiviteRechercheAnnee(Integer annee);

    List<InstitutionCoContractantProjetActiviteRecherche> findByProjetActiviteRechercheId(Long id);

    int deleteByProjetActiviteRechercheId(Long id);


}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.ResponsabilitePedagogiqueMaster;


@Repository
public interface ResponsabilitePedagogiqueMasterDao extends JpaRepository<ResponsabilitePedagogiqueMaster,Long> {




    ResponsabilitePedagogiqueMaster findByAnnee(Integer annee);

    int deleteByAnnee(Integer annee);

    List<ResponsabilitePedagogiqueMaster> findByStatutMasterCode(String code);
    int deleteByStatutMasterCode(String code);

    List<ResponsabilitePedagogiqueMaster> findByStatutMasterId(Long id);

    int deleteByStatutMasterId(Long id);
    List<ResponsabilitePedagogiqueMaster> findByMasterCode(String code);
    int deleteByMasterCode(String code);

    List<ResponsabilitePedagogiqueMaster> findByMasterId(Long id);

    int deleteByMasterId(Long id);
    List<ResponsabilitePedagogiqueMaster> findByEtablissementCode(String code);
    int deleteByEtablissementCode(String code);

    List<ResponsabilitePedagogiqueMaster> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);
    List<ResponsabilitePedagogiqueMaster> findByEtatEtapeCampagneCode(String code);
    int deleteByEtatEtapeCampagneCode(String code);

    List<ResponsabilitePedagogiqueMaster> findByEtatEtapeCampagneId(Long id);

    int deleteByEtatEtapeCampagneId(Long id);
    List<ResponsabilitePedagogiqueMaster> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<ResponsabilitePedagogiqueMaster> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);
    List<ResponsabilitePedagogiqueMaster> findByCampagneCode(String code);
    int deleteByCampagneCode(String code);

    List<ResponsabilitePedagogiqueMaster> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);

    List<ResponsabilitePedagogiqueMaster> findByChercheurUsernameAndCampagneId(String username, Long compagneId);
    List<ResponsabilitePedagogiqueMaster> findByChercheurUsername(String username);

}

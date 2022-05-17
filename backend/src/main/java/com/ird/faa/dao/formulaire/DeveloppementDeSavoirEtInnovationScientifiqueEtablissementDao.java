package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueEtablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeveloppementDeSavoirEtInnovationScientifiqueEtablissementDao extends JpaRepository<DeveloppementDeSavoirEtInnovationScientifiqueEtablissement,Long> {





    List<DeveloppementDeSavoirEtInnovationScientifiqueEtablissement> findByEtablissementCode(String code);
    int deleteByEtablissementCode(String code);

    List<DeveloppementDeSavoirEtInnovationScientifiqueEtablissement> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);

    List<DeveloppementDeSavoirEtInnovationScientifiqueEtablissement> findByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);

    int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);


}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique;


@Repository
public interface ModeDiffusionDeveloppementDeSavoirEtInnovationScientifiqueDao extends JpaRepository<ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique,Long> {





    List<ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique> findByModeDiffusionCode(String code);
    int deleteByModeDiffusionCode(String code);

    List<ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique> findByModeDiffusionId(Long id);

    int deleteByModeDiffusionId(Long id);

    List<ModeDiffusionDeveloppementDeSavoirEtInnovationScientifique> findByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);

    int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);


}

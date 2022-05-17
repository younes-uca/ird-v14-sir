package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoirDao extends JpaRepository<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir,Long> {





    List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> findByCommunauteSavoirCode(String code);
    int deleteByCommunauteSavoirCode(String code);

    List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> findByCommunauteSavoirId(Long id);

    int deleteByCommunauteSavoirId(Long id);

    List<DeveloppementDeSavoirEtInnovationScientifiqueCommunauteSavoir> findByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);

    int deleteByDeveloppementDeSavoirEtInnovationScientifiqueId(Long id);


}

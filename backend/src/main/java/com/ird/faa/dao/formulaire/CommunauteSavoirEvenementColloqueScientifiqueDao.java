package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.CommunauteSavoirEvenementColloqueScientifique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommunauteSavoirEvenementColloqueScientifiqueDao extends JpaRepository<CommunauteSavoirEvenementColloqueScientifique,Long> {






    List<CommunauteSavoirEvenementColloqueScientifique> findByEvenementColloqueScienntifiqueId(Long id);

    int deleteByEvenementColloqueScienntifiqueId(Long id);
    List<CommunauteSavoirEvenementColloqueScientifique> findByCommunauteSavoirCode(String code);
    int deleteByCommunauteSavoirCode(String code);

    List<CommunauteSavoirEvenementColloqueScientifique> findByCommunauteSavoirId(Long id);

    int deleteByCommunauteSavoirId(Long id);


}

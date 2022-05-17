package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.CommunauteSavoirEncadrementDoctorant;


@Repository
public interface CommunauteSavoirEncadrementDoctorantDao extends JpaRepository<CommunauteSavoirEncadrementDoctorant,Long> {





    List<CommunauteSavoirEncadrementDoctorant> findByCommunauteSavoirCode(String code);
    int deleteByCommunauteSavoirCode(String code);

    List<CommunauteSavoirEncadrementDoctorant> findByCommunauteSavoirId(Long id);

    int deleteByCommunauteSavoirId(Long id);

    List<CommunauteSavoirEncadrementDoctorant> findByEncadrementDoctorantId(Long id);

    int deleteByEncadrementDoctorantId(Long id);


}

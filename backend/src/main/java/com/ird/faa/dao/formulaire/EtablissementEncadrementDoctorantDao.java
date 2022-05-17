package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.EtablissementEncadrementDoctorant;


@Repository
public interface EtablissementEncadrementDoctorantDao extends JpaRepository<EtablissementEncadrementDoctorant,Long> {





    List<EtablissementEncadrementDoctorant> findByEtablissementCode(String code);
    int deleteByEtablissementCode(String code);

    List<EtablissementEncadrementDoctorant> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);

    List<EtablissementEncadrementDoctorant> findByEncadrementDoctorantId(Long id);

    int deleteByEncadrementDoctorantId(Long id);


}

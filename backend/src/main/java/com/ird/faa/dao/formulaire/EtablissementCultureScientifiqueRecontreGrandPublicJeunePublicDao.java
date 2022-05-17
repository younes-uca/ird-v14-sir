package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic;


@Repository
public interface EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicDao extends JpaRepository<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic,Long> {






    List<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic> findByCultureScientifiqueRecontreGrandPublicJeunePublicId(Long id);

    int deleteByCultureScientifiqueRecontreGrandPublicJeunePublicId(Long id);
    List<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic> findByEtablissementCode(String code);
    int deleteByEtablissementCode(String code);

    List<EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);


}

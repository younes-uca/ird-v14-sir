package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.referentiel.EtablissementProjet;


@Repository
public interface EtablissementProjetDao extends JpaRepository<EtablissementProjet,Long> {




    EtablissementProjet findByCode(String code);

    int deleteByCode(String code);

    List<EtablissementProjet> findByVilleCode(String code);
    int deleteByVilleCode(String code);

    List<EtablissementProjet> findByVilleId(Long id);

    int deleteByVilleId(Long id);
    List<EtablissementProjet> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<EtablissementProjet> findByPaysId(Long id);

    int deleteByPaysId(Long id);


}

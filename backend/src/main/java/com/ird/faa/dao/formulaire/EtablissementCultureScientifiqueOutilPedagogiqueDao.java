package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.EtablissementCultureScientifiqueOutilPedagogique;


@Repository
public interface EtablissementCultureScientifiqueOutilPedagogiqueDao extends JpaRepository<EtablissementCultureScientifiqueOutilPedagogique,Long> {






    List<EtablissementCultureScientifiqueOutilPedagogique> findByCultureScientifiqueOutilPedagogiqueId(Long id);

    int deleteByCultureScientifiqueOutilPedagogiqueId(Long id);
    List<EtablissementCultureScientifiqueOutilPedagogique> findByEtablissementCode(String code);
    int deleteByEtablissementCode(String code);

    List<EtablissementCultureScientifiqueOutilPedagogique> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);


}

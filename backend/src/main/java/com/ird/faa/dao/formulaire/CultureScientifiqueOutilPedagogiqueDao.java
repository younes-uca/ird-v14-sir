package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.CultureScientifiqueOutilPedagogique;


@Repository
public interface CultureScientifiqueOutilPedagogiqueDao extends JpaRepository<CultureScientifiqueOutilPedagogique,Long> {





    List<CultureScientifiqueOutilPedagogique> findByCampagneCode(String code);
    int deleteByCampagneCode(String code);

    List<CultureScientifiqueOutilPedagogique> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);
    List<CultureScientifiqueOutilPedagogique> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<CultureScientifiqueOutilPedagogique> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);
    List<CultureScientifiqueOutilPedagogique> findByEtatEtapeCampagneCode(String code);
    int deleteByEtatEtapeCampagneCode(String code);

    List<CultureScientifiqueOutilPedagogique> findByEtatEtapeCampagneId(Long id);

    int deleteByEtatEtapeCampagneId(Long id);

    List<CultureScientifiqueOutilPedagogique> findByChercheurUsernameAndCampagneId(String username, Long compagneId);
    List<CultureScientifiqueOutilPedagogique> findByChercheurUsername(String username);

}

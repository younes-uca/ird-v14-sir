package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.Bourse;


@Repository
public interface BourseDao extends JpaRepository<Bourse,Long> {





    List<Bourse> findByProjetActiviteRechercheAnnee(Integer annee);
    int deleteByProjetActiviteRechercheAnnee(Integer annee);

    List<Bourse> findByProjetActiviteRechercheId(Long id);

    int deleteByProjetActiviteRechercheId(Long id);
    List<Bourse> findByCampagneCode(String code);
    int deleteByCampagneCode(String code);

    List<Bourse> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);
    List<Bourse> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<Bourse> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);

    List<Bourse> findByChercheurUsernameAndCampagneId(String username, Long compagneId);
    List<Bourse> findByChercheurUsername(String username);

}

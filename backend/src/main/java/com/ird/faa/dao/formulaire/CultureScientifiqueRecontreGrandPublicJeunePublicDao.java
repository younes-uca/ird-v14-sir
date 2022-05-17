package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.CultureScientifiqueRecontreGrandPublicJeunePublic;


@Repository
public interface CultureScientifiqueRecontreGrandPublicJeunePublicDao extends JpaRepository<CultureScientifiqueRecontreGrandPublicJeunePublic,Long> {





    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByFormatRencontreCode(String code);
    int deleteByFormatRencontreCode(String code);

    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByFormatRencontreId(Long id);

    int deleteByFormatRencontreId(Long id);
    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByCampagneCode(String code);
    int deleteByCampagneCode(String code);

    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);
    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);

    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByChercheurUsernameAndCampagneId(String username, Long compagneId);
    List<CultureScientifiqueRecontreGrandPublicJeunePublic> findByChercheurUsername(String username);

}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.ContexteCultureScientifiqueRecontreGrandPublicJeunePublic;


@Repository
public interface ContexteCultureScientifiqueRecontreGrandPublicJeunePublicDao extends JpaRepository<ContexteCultureScientifiqueRecontreGrandPublicJeunePublic,Long> {






    List<ContexteCultureScientifiqueRecontreGrandPublicJeunePublic> findByCultureScientifiqueRecontreGrandPublicJeunePublicId(Long id);

    int deleteByCultureScientifiqueRecontreGrandPublicJeunePublicId(Long id);
    List<ContexteCultureScientifiqueRecontreGrandPublicJeunePublic> findByContexteCode(String code);
    int deleteByContexteCode(String code);

    List<ContexteCultureScientifiqueRecontreGrandPublicJeunePublic> findByContexteId(Long id);

    int deleteByContexteId(Long id);


}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.PaysCultureScientifiqueRecontreGrandPublicJeunePublic;


@Repository
public interface PaysCultureScientifiqueRecontreGrandPublicJeunePublicDao extends JpaRepository<PaysCultureScientifiqueRecontreGrandPublicJeunePublic,Long> {





    List<PaysCultureScientifiqueRecontreGrandPublicJeunePublic> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<PaysCultureScientifiqueRecontreGrandPublicJeunePublic> findByPaysId(Long id);

    int deleteByPaysId(Long id);

    List<PaysCultureScientifiqueRecontreGrandPublicJeunePublic> findByCultureScientifiqueRecontreGrandPublicJeunePublicId(Long id);

    int deleteByCultureScientifiqueRecontreGrandPublicJeunePublicId(Long id);


}

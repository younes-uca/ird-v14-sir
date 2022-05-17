package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.PublicCibleCultureScientifiqueRecontreGrandPublic;


@Repository
public interface PublicCibleCultureScientifiqueRecontreGrandPublicDao extends JpaRepository<PublicCibleCultureScientifiqueRecontreGrandPublic,Long> {





    List<PublicCibleCultureScientifiqueRecontreGrandPublic> findByPublicCibleCode(String code);
    int deleteByPublicCibleCode(String code);

    List<PublicCibleCultureScientifiqueRecontreGrandPublic> findByPublicCibleId(Long id);

    int deleteByPublicCibleId(Long id);
    List<PublicCibleCultureScientifiqueRecontreGrandPublic> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<PublicCibleCultureScientifiqueRecontreGrandPublic> findByPaysId(Long id);

    int deleteByPaysId(Long id);

    List<PublicCibleCultureScientifiqueRecontreGrandPublic> findByCultureScientifiqueRecontreGrandPublicJeunePublicId(Long id);

    int deleteByCultureScientifiqueRecontreGrandPublicJeunePublicId(Long id);


}

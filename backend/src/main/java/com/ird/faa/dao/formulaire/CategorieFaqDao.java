package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.CategorieFaq;


@Repository
public interface CategorieFaqDao extends JpaRepository<CategorieFaq,Long> {



    List<CategorieFaq> findByArchiveOrderByOrdre(Boolean archive);

    CategorieFaq findByOrdre(Integer ordre);

    int deleteByOrdre(Integer ordre);



}

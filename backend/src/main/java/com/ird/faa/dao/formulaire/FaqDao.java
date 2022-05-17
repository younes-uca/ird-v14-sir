package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.CategorieFaq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.Faq;


@Repository
public interface FaqDao extends JpaRepository<Faq,Long> {


    List<Faq> findByArchiveAndCategorieFaqOrderByOrdre(Boolean archive,CategorieFaq categorieFaq);

    List<Faq> findByCategorieFaqOrderByOrdre(CategorieFaq categorieFaq);

    Faq findByOrdre(Integer ordre);
    Faq findByOrdreAndCategorieFaqId(Integer ordre,Long categorieFaqId);

    int deleteByOrdre(Integer ordre);

    List<Faq> findByCategorieFaqOrdre(Integer ordre);
    int deleteByCategorieFaqOrdre(Integer ordre);

    List<Faq> findByCategorieFaqId(Long id);

    int deleteByCategorieFaqId(Long id);


}

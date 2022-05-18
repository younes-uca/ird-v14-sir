package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.CategorieFaq;
import main.java.com.ird.faa.ws.rest.provided.vo.formulaire.CategorieFaqVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CategorieFaqChercheurService extends AbstractService<CategorieFaq,Long,CategorieFaqVo>{

    List<CategorieFaq> findAllWithFaq();
    /**
    * find CategorieFaq from database by ordre (reference)
    * @param ordre - reference of CategorieFaq
    * @return the founded CategorieFaq , If no CategorieFaq were
    *         found in database return  null.
    */
    CategorieFaq findByOrdre(Integer ordre);

    /**
    * find CategorieFaq from database by id (PK) or ordre (reference)
    * @param id - id of CategorieFaq
    * @param ordre - reference of CategorieFaq
    * @return the founded CategorieFaq , If no CategorieFaq were
    *         found in database return  null.
    */
    CategorieFaq findByIdOrOrdre(CategorieFaq categorieFaq);


/**
    * delete CategorieFaq from database
    * @param id - id of CategorieFaq to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete CategorieFaq from database by ordre (reference)
    *
    * @param ordre - reference of CategorieFaq to be deleted
    * @return 1 if CategorieFaq deleted successfully
    */
    int deleteByOrdre(Integer ordre);



}

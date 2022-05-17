package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.PaysTypeOutilCultureScientifiqueOutilPedagogique;


@Repository
public interface PaysTypeOutilCultureScientifiqueOutilPedagogiqueDao extends JpaRepository<PaysTypeOutilCultureScientifiqueOutilPedagogique,Long> {






    List<PaysTypeOutilCultureScientifiqueOutilPedagogique> findByCultureScientifiqueOutilPedagogiqueId(Long id);

    int deleteByCultureScientifiqueOutilPedagogiqueId(Long id);
    List<PaysTypeOutilCultureScientifiqueOutilPedagogique> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<PaysTypeOutilCultureScientifiqueOutilPedagogique> findByPaysId(Long id);

    int deleteByPaysId(Long id);


}

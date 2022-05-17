package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.PublicCibleCultureScientifiqueOutilPedagogique;


@Repository
public interface PublicCibleCultureScientifiqueOutilPedagogiqueDao extends JpaRepository<PublicCibleCultureScientifiqueOutilPedagogique,Long> {





    List<PublicCibleCultureScientifiqueOutilPedagogique> findByPublicCibleCode(String code);
    int deleteByPublicCibleCode(String code);

    List<PublicCibleCultureScientifiqueOutilPedagogique> findByPublicCibleId(Long id);

    int deleteByPublicCibleId(Long id);

    List<PublicCibleCultureScientifiqueOutilPedagogique> findByCultureScientifiqueOutilPedagogiqueId(Long id);

    int deleteByCultureScientifiqueOutilPedagogiqueId(Long id);
    List<PublicCibleCultureScientifiqueOutilPedagogique> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<PublicCibleCultureScientifiqueOutilPedagogique> findByPaysId(Long id);

    int deleteByPaysId(Long id);


}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.OutilPedagogiquePubliqueCible;


@Repository
public interface OutilPedagogiquePubliqueCibleDao extends JpaRepository<OutilPedagogiquePubliqueCible,Long> {





    List<OutilPedagogiquePubliqueCible> findByPublicCibleCode(String code);
    int deleteByPublicCibleCode(String code);

    List<OutilPedagogiquePubliqueCible> findByPublicCibleId(Long id);

    int deleteByPublicCibleId(Long id);

    List<OutilPedagogiquePubliqueCible> findByOutilPedagogiqueId(Long id);

    int deleteByOutilPedagogiqueId(Long id);


}

package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.OutilPedagogiqueInstrumentIrd;


@Repository
public interface OutilPedagogiqueInstrumentIrdDao extends JpaRepository<OutilPedagogiqueInstrumentIrd,Long> {





    List<OutilPedagogiqueInstrumentIrd> findByInstrumentIrdCode(String code);
    int deleteByInstrumentIrdCode(String code);

    List<OutilPedagogiqueInstrumentIrd> findByInstrumentIrdId(Long id);

    int deleteByInstrumentIrdId(Long id);

    List<OutilPedagogiqueInstrumentIrd> findByOutilPedagogiqueId(Long id);

    int deleteByOutilPedagogiqueId(Long id);


}

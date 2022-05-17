package com.ird.faa.dao.formulaire;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.OutilPedagogiqueTypeInstrumentIrd;


@Repository
public interface OutilPedagogiqueTypeInstrumentIrdDao
		extends JpaRepository<OutilPedagogiqueTypeInstrumentIrd, Long> {





	List<OutilPedagogiqueTypeInstrumentIrd> findByTypeInstrumentIrdCode(String code);

	int deleteByTypeInstrumentIrdCode(String code);

	List<OutilPedagogiqueTypeInstrumentIrd> findByTypeInstrumentIrdId(Long id);

	int deleteByTypeInstrumentIrdId(Long id);

	List<OutilPedagogiqueTypeInstrumentIrd> findByOutilPedagogiqueId(Long id);

    int deleteByOutilPedagogiqueId(Long id);


}

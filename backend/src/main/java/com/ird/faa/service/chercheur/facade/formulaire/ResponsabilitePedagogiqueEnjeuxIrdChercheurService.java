package com.ird.faa.service.chercheur.facade.formulaire;

import java.util.List;
import com.ird.faa.bean.formulaire.ResponsabilitePedagogiqueEnjeuxIrd;
import com.ird.faa.ws.rest.provided.vo.ResponsabilitePedagogiqueEnjeuxIrdVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ResponsabilitePedagogiqueEnjeuxIrdChercheurService
		extends AbstractService<ResponsabilitePedagogiqueEnjeuxIrd, Long, ResponsabilitePedagogiqueEnjeuxIrdVo> {

	/**
	 * delete ResponsabilitePedagogiqueEnjeuxIrd from database
	 * 
	 * @param id - id of ResponsabilitePedagogiqueEnjeuxIrd to be deleted
	 *
	 */
	int deleteById(Long id);

	List<ResponsabilitePedagogiqueEnjeuxIrd> findByEnjeuxIrdCode(String code);

	int deleteByEnjeuxIrdCode(String code);

	List<ResponsabilitePedagogiqueEnjeuxIrd> findByEnjeuxIrdId(Long id);

	int deleteByEnjeuxIrdId(Long id);

	List<ResponsabilitePedagogiqueEnjeuxIrd> findByResponsabilitePedagogiqueId(Long id);

	int deleteByResponsabilitePedagogiqueId(Long id);

}

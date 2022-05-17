package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ird.faa.ws.rest.provided.dto.PaysDto;
import com.ird.faa.ws.rest.provided.vo.ContinentVo;
import com.ird.faa.ws.rest.provided.vo.PaysVo;

@Component
public class PaysDtoToVoConverter {
	@Autowired
	private ContinentDtoToVoConverter continentDtoToVoConverter;
	
	public PaysVo toVo(PaysDto paysDto) {
		if (paysDto == null) {
			return null;
		} else {
			PaysVo paysVo=new PaysVo();
			if(paysDto.getLibelleCourt()!=null) {
				paysVo.setLibelle(paysDto.getLibelleCourt());
			}
			if(paysDto.getCode()!=null) {
				paysVo.setCode(paysDto.getCode());
			}
			if(paysDto.getId()!=null) {
				paysVo.setIdGraph(paysDto.getId());
			}
			if(paysDto.getZoneGeographique()!=null) {
				ContinentVo continentVo=continentDtoToVoConverter.toVo(paysDto.getZoneGeographique());
				paysVo.setContinentVo(continentVo);
			}
			return paysVo;
		}
	}
}

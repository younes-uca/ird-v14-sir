package com.ird.faa.ws.rest.provided.converter;
import org.springframework.stereotype.Component;

import com.ird.faa.ws.rest.provided.dto.ZoneGeographiqueDto;
import com.ird.faa.ws.rest.provided.vo.ContinentVo;

@Component
public class ContinentDtoToVoConverter {
	public ContinentVo toVo(ZoneGeographiqueDto zoneGeographiqueDto) {
		if (zoneGeographiqueDto == null) {
			return null;
		} else {
			ContinentVo continentVo=new ContinentVo();
			if(zoneGeographiqueDto.getLibelleCourt()!=null) {
				continentVo.setLibelle(zoneGeographiqueDto.getLibelleCourt());
			}
			if(zoneGeographiqueDto.getCode()!=null) {
				continentVo.setCode(zoneGeographiqueDto.getCode());
			}
			if(zoneGeographiqueDto.getId()!=null) {
				continentVo.setIdGraph(zoneGeographiqueDto.getId());
			}
			
			return continentVo;
		}
	}
}

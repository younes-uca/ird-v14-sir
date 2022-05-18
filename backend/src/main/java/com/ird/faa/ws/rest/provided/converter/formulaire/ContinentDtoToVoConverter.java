package main.java.com.ird.faa.ws.rest.provided.converter.formulaire;
import org.springframework.stereotype.Component;

import com.ird.faa.ws.rest.provided.dto.ZoneGeographiqueDto;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.ContinentVo;

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

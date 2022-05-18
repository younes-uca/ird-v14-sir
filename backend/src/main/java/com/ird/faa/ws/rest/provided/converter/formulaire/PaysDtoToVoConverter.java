package main.java.com.ird.faa.ws.rest.provided.converter.formulaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ird.faa.ws.rest.provided.dto.PaysDto;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.ContinentVo;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.PaysVo;

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

package main.java.com.ird.faa.ws.rest.provided.converter.formulaire;

import org.springframework.stereotype.Component;

import com.ird.faa.ws.rest.provided.dto.CorpsDto;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.CorpsVo;

@Component
public class CorpsDtoToVoConverter {

	public CorpsVo toVo(CorpsDto CorpsDto) {
		if (CorpsDto == null) {
			return null;
		} else {
			CorpsVo CorpsVo=new CorpsVo();
			if(CorpsDto.getLibelleCourt()!=null) {
				CorpsVo.setLibelle(CorpsDto.getLibelleCourt());
			}
			if(CorpsDto.getCode()!=null) {
				CorpsVo.setCode(CorpsDto.getCode());
			}
			if(CorpsDto.getLibelleLong()!=null) {
				CorpsVo.setDescription(CorpsDto.getLibelleLong());
			}
			if(CorpsDto.getId()!=null) {
				CorpsVo.setIdGraph(CorpsDto.getId());
			}
		
			return CorpsVo;
		}
	}
}

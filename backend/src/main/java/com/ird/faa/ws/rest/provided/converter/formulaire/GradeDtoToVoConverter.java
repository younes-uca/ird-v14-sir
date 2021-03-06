package main.java.com.ird.faa.ws.rest.provided.converter.formulaire;

import org.springframework.stereotype.Component;

import com.ird.faa.ws.rest.provided.dto.GradeDto;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.GradeVo;

@Component
public class GradeDtoToVoConverter {

	public GradeVo toVo(GradeDto gradeDto) {
		if (gradeDto == null) {
			return null;
		} else {
			GradeVo gradeVo=new GradeVo();
			if(gradeDto.getLibelleCourt()!=null) {
				gradeVo.setLibelle(gradeDto.getLibelleCourt());
			}
			if(gradeDto.getCode()!=null) {
				gradeVo.setCode(gradeDto.getCode());
			}
			if(gradeDto.getLibelleLong()!=null) {
				gradeVo.setDescription(gradeDto.getLibelleLong());
			}
			if(gradeDto.getId()!=null) {
				gradeVo.setIdGraph(gradeDto.getId());
			}
		
			return gradeVo;
		}
	}
}

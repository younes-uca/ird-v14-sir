package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo;

@Component
public class DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter extends
		AbstractConverter<DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique, DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo> {

	@Autowired
	private DeveloppementDeSavoirEtInnovationScientifiqueConverter developpementDeSavoirEtInnovationScientifiqueConverter;
	@Autowired
	private DisciplineScientifiqueConverter disciplineScientifiqueConverter;
	private Boolean disciplineScientifique;
	private Boolean developpementDeSavoirEtInnovationScientifique;

	public DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueConverter() {
		init(true);
	}

	@Override
	public DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique toItem(
			DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo vo) {
		if (vo == null) {
			return null;
		} else {
			DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique item = new DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique();
			if (StringUtil.isNotEmpty(vo.getId()))
				item.setId(NumberUtil.toLong(vo.getId()));
			if (vo.getDisciplineScientifiqueVo() != null && this.disciplineScientifique)
				item.setDisciplineScientifique(disciplineScientifiqueConverter.toItem(vo.getDisciplineScientifiqueVo()));
			if (vo.getDeveloppementDeSavoirEtInnovationScientifiqueVo() != null
					&& this.developpementDeSavoirEtInnovationScientifique)
				item.setDeveloppementDeSavoirEtInnovationScientifique(
						developpementDeSavoirEtInnovationScientifiqueConverter
								.toItem(vo.getDeveloppementDeSavoirEtInnovationScientifiqueVo()));

			return item;
		}
	}

	@Override
	public DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo toVo(
			DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifique item) {
		if (item == null) {
			return null;
		} else {
			DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo vo = new DeveloppementDeSavoirEtInnovationScientifiqueDisciplineScientifiqueVo();
			if (item.getId() != null)
				vo.setId(NumberUtil.toString(item.getId()));

			if (item.getDisciplineScientifique() != null && this.disciplineScientifique) {
				vo.setDisciplineScientifiqueVo(disciplineScientifiqueConverter.toVo(item.getDisciplineScientifique()));
			}
			if (item.getDeveloppementDeSavoirEtInnovationScientifique() != null
					&& this.developpementDeSavoirEtInnovationScientifique) {
				vo.setDeveloppementDeSavoirEtInnovationScientifiqueVo(
						developpementDeSavoirEtInnovationScientifiqueConverter
								.toVo(item.getDeveloppementDeSavoirEtInnovationScientifique()));
			}

			return vo;
		}
	}

	public void init(Boolean value) {
		disciplineScientifique = value;
		developpementDeSavoirEtInnovationScientifique = value;
	}

	public DeveloppementDeSavoirEtInnovationScientifiqueConverter getDeveloppementDeSavoirEtInnovationScientifiqueConverter() {
		return this.developpementDeSavoirEtInnovationScientifiqueConverter;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiqueConverter(
			DeveloppementDeSavoirEtInnovationScientifiqueConverter developpementDeSavoirEtInnovationScientifiqueConverter) {
		this.developpementDeSavoirEtInnovationScientifiqueConverter = developpementDeSavoirEtInnovationScientifiqueConverter;
	}

	public DisciplineScientifiqueConverter getDisciplineScientifiqueConverter() {
		return this.disciplineScientifiqueConverter;
	}

	public void setdisciplineScientifiqueConverter(DisciplineScientifiqueConverter disciplineScientifiqueConverter) {
		this.disciplineScientifiqueConverter = disciplineScientifiqueConverter;
	}

	public boolean isdisciplineScientifique() {
		return this.disciplineScientifique;
	}

	public void setdisciplineScientifique(boolean disciplineScientifique) {
		this.disciplineScientifique = disciplineScientifique;
	}

	public boolean isDeveloppementDeSavoirEtInnovationScientifique() {
		return this.developpementDeSavoirEtInnovationScientifique;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifique(
			boolean developpementDeSavoirEtInnovationScientifique) {
		this.developpementDeSavoirEtInnovationScientifique = developpementDeSavoirEtInnovationScientifique;
	}

}

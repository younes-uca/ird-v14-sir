package com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;

import com.ird.faa.bean.referentiel.ModaliteIntervention;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.ModaliteInterventionVo;

@Component
public class ModaliteInterventionConverter extends AbstractConverter<ModaliteIntervention, ModaliteInterventionVo> {

	public ModaliteInterventionConverter() {
		init(true);
	}

	@Override
	public ModaliteIntervention toItem(ModaliteInterventionVo vo) {
		if (vo == null) {
			return null;
		} else {
			ModaliteIntervention item = new ModaliteIntervention();
			if (StringUtil.isNotEmpty(vo.getId()))
				item.setId(NumberUtil.toLong(vo.getId()));
			if (StringUtil.isNotEmpty(vo.getLibelle()))
				item.setLibelle(vo.getLibelle());
			if (StringUtil.isNotEmpty(vo.getCode()))
				item.setCode(vo.getCode());
			if (StringUtil.isNotEmpty(vo.getDescription()))
				item.setDescription(vo.getDescription());
			if (vo.getArchive() != null)
				item.setArchive(vo.getArchive());
			if (StringUtil.isNotEmpty(vo.getDateArchivage()))
				item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));

			return item;
		}
	}

	@Override
	public ModaliteInterventionVo toVo(ModaliteIntervention item) {
		if (item == null) {
			return null;
		} else {
			ModaliteInterventionVo vo = new ModaliteInterventionVo();
			if (item.getId() != null)
				vo.setId(NumberUtil.toString(item.getId()));

			if (StringUtil.isNotEmpty(item.getLibelle()))
				vo.setLibelle(item.getLibelle());

			if (StringUtil.isNotEmpty(item.getCode()))
				vo.setCode(item.getCode());

			if (StringUtil.isNotEmpty(item.getDescription()))
				vo.setDescription(item.getDescription());

			if (item.getArchive() != null)
				vo.setArchive(item.getArchive());
			if (item.getDateArchivage() != null)
				vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));

			return vo;
		}
	}

	public void init(Boolean value) {
	}

}

package com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;

import com.ird.faa.bean.formulaire.StatusCursus;
import com.ird.faa.ws.rest.provided.vo.StatusCursusVo;

@Component
public class StatusCursusConverter extends AbstractConverter<StatusCursus, StatusCursusVo> {

	public StatusCursusConverter() {
		init(true);
	}

	@Override
	public StatusCursus toItem(StatusCursusVo vo) {
		if (vo == null) {
			return null;
		} else {
			StatusCursus item = new StatusCursus();
			if (StringUtil.isNotEmpty(vo.getId()))
				item.setId(NumberUtil.toLong(vo.getId()));
			if (StringUtil.isNotEmpty(vo.getLibelle()))
				item.setLibelle(vo.getLibelle());
			if (StringUtil.isNotEmpty(vo.getCode()))
				item.setCode(vo.getCode());
			if (vo.getArchive() != null)
				item.setArchive(vo.getArchive());
			if (StringUtil.isNotEmpty(vo.getDateArchivage()))
				item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
			if (StringUtil.isNotEmpty(vo.getDateCreation()))
				item.setDateCreation(DateUtil.parse(vo.getDateCreation()));

			return item;
		}
	}

	@Override
	public StatusCursusVo toVo(StatusCursus item) {
		if (item == null) {
			return null;
		} else {
			StatusCursusVo vo = new StatusCursusVo();
			if (item.getId() != null)
				vo.setId(NumberUtil.toString(item.getId()));

			if (StringUtil.isNotEmpty(item.getLibelle()))
				vo.setLibelle(item.getLibelle());

			if (StringUtil.isNotEmpty(item.getCode()))
				vo.setCode(item.getCode());

			if (item.getArchive() != null)
				vo.setArchive(item.getArchive());
			if (item.getDateArchivage() != null)
				vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
			if (item.getDateCreation() != null)
				vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));

			return vo;
		}
	}

	public void init(Boolean value) {
	}
}

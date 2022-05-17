package com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;

import com.ird.faa.bean.referentiel.TypeUtilisateur;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.TypeUtilisateurVo;

@Component
public class TypeUtilisateurConverter extends AbstractConverter<TypeUtilisateur, TypeUtilisateurVo> {

	public TypeUtilisateurConverter() {
		init(true);
	}

	@Override
	public TypeUtilisateur toItem(TypeUtilisateurVo vo) {
		if (vo == null) {
			return null;
		} else {
			TypeUtilisateur item = new TypeUtilisateur();
			if (StringUtil.isNotEmpty(vo.getId()))
				item.setId(NumberUtil.toLong(vo.getId()));
			if (StringUtil.isNotEmpty(vo.getLibelle()))
				item.setLibelle(vo.getLibelle());
			if (StringUtil.isNotEmpty(vo.getCode()))
				item.setCode(vo.getCode());

			return item;
		}
	}

	@Override
	public TypeUtilisateurVo toVo(TypeUtilisateur item) {
		if (item == null) {
			return null;
		} else {
			TypeUtilisateurVo vo = new TypeUtilisateurVo();
			if (item.getId() != null)
				vo.setId(NumberUtil.toString(item.getId()));

			if (StringUtil.isNotEmpty(item.getLibelle()))
				vo.setLibelle(item.getLibelle());

			if (StringUtil.isNotEmpty(item.getCode()))
				vo.setCode(item.getCode());

			return vo;
		}
	}

	public void init(Boolean value) {
	}

}

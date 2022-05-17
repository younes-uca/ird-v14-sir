package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueRole;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.DeveloppementDeSavoirEtInnovationScientifiqueRoleVo;

@Component
public class DeveloppementDeSavoirEtInnovationScientifiqueRoleConverter extends
		AbstractConverter<DeveloppementDeSavoirEtInnovationScientifiqueRole, DeveloppementDeSavoirEtInnovationScientifiqueRoleVo> {

	@Autowired
	private DeveloppementDeSavoirEtInnovationScientifiqueConverter developpementDeSavoirEtInnovationScientifiqueConverter;
	@Autowired
	private RoleDeveloppementDeSavoirConverter roleDeveloppementDeSavoirConverter;
	private Boolean roleDeveloppementDeSavoir;
	private Boolean developpementDeSavoirEtInnovationScientifique;

	public DeveloppementDeSavoirEtInnovationScientifiqueRoleConverter() {
		init(true);
	}

	@Override
	public DeveloppementDeSavoirEtInnovationScientifiqueRole toItem(
			DeveloppementDeSavoirEtInnovationScientifiqueRoleVo vo) {
		if (vo == null) {
			return null;
		} else {
			DeveloppementDeSavoirEtInnovationScientifiqueRole item = new DeveloppementDeSavoirEtInnovationScientifiqueRole();
			if (StringUtil.isNotEmpty(vo.getId()))
				item.setId(NumberUtil.toLong(vo.getId()));
			if (vo.getRoleDeveloppementDeSavoirVo() != null && this.roleDeveloppementDeSavoir)
				item.setRoleDeveloppementDeSavoir(
						roleDeveloppementDeSavoirConverter.toItem(vo.getRoleDeveloppementDeSavoirVo()));
			if (vo.getDeveloppementDeSavoirEtInnovationScientifiqueVo() != null
					&& this.developpementDeSavoirEtInnovationScientifique)
				item.setDeveloppementDeSavoirEtInnovationScientifique(
						developpementDeSavoirEtInnovationScientifiqueConverter
								.toItem(vo.getDeveloppementDeSavoirEtInnovationScientifiqueVo()));

			return item;
		}
	}

	@Override
	public DeveloppementDeSavoirEtInnovationScientifiqueRoleVo toVo(
			DeveloppementDeSavoirEtInnovationScientifiqueRole item) {
		if (item == null) {
			return null;
		} else {
			DeveloppementDeSavoirEtInnovationScientifiqueRoleVo vo = new DeveloppementDeSavoirEtInnovationScientifiqueRoleVo();
			if (item.getId() != null)
				vo.setId(NumberUtil.toString(item.getId()));

			if (item.getRoleDeveloppementDeSavoir() != null && this.roleDeveloppementDeSavoir) {
				vo.setRoleDeveloppementDeSavoirVo(
						roleDeveloppementDeSavoirConverter.toVo(item.getRoleDeveloppementDeSavoir()));
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
		roleDeveloppementDeSavoir = value;
		developpementDeSavoirEtInnovationScientifique = value;
	}

	public DeveloppementDeSavoirEtInnovationScientifiqueConverter getDeveloppementDeSavoirEtInnovationScientifiqueConverter() {
		return this.developpementDeSavoirEtInnovationScientifiqueConverter;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiqueConverter(
			DeveloppementDeSavoirEtInnovationScientifiqueConverter developpementDeSavoirEtInnovationScientifiqueConverter) {
		this.developpementDeSavoirEtInnovationScientifiqueConverter = developpementDeSavoirEtInnovationScientifiqueConverter;
	}

	public RoleDeveloppementDeSavoirConverter getRoleDeveloppementDeSavoirConverter() {
		return this.roleDeveloppementDeSavoirConverter;
	}

	public void setRoleDeveloppementDeSavoirConverter(
			RoleDeveloppementDeSavoirConverter roleDeveloppementDeSavoirConverter) {
		this.roleDeveloppementDeSavoirConverter = roleDeveloppementDeSavoirConverter;
	}

	public boolean isRoleDeveloppementDeSavoir() {
		return this.roleDeveloppementDeSavoir;
	}

	public void setRoleDeveloppementDeSavoir(boolean roleDeveloppementDeSavoir) {
		this.roleDeveloppementDeSavoir = roleDeveloppementDeSavoir;
	}

	public boolean isDeveloppementDeSavoirEtInnovationScientifique() {
		return this.developpementDeSavoirEtInnovationScientifique;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifique(
			boolean developpementDeSavoirEtInnovationScientifique) {
		this.developpementDeSavoirEtInnovationScientifique = developpementDeSavoirEtInnovationScientifique;
	}

}

package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ird.faa.bean.formulaire.DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo;

@Component
public class DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter extends
		AbstractConverter<DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd, DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo> {

	@Autowired
	private DeveloppementDeSavoirEtInnovationScientifiqueConverter developpementDeSavoirEtInnovationScientifiqueConverter;
	@Autowired
	private InstrumentIrdConverter instrumentIrdConverter;
	private Boolean instrumentIrd;
	private Boolean developpementDeSavoirEtInnovationScientifique;

	public DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdConverter() {
		init(true);
	}

	@Override
	public DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd toItem(
			DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo vo) {
		if (vo == null) {
			return null;
		} else {
			DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd item = new DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd();
			if (StringUtil.isNotEmpty(vo.getId()))
				item.setId(NumberUtil.toLong(vo.getId()));
			if (vo.getInstrumentIrdVo() != null && this.instrumentIrd)
				item.setInstrumentIrd(instrumentIrdConverter.toItem(vo.getInstrumentIrdVo()));
			if (vo.getDeveloppementDeSavoirEtInnovationScientifiqueVo() != null
					&& this.developpementDeSavoirEtInnovationScientifique)
				item.setDeveloppementDeSavoirEtInnovationScientifique(
						developpementDeSavoirEtInnovationScientifiqueConverter
								.toItem(vo.getDeveloppementDeSavoirEtInnovationScientifiqueVo()));

			return item;
		}
	}

	@Override
	public DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo toVo(
			DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrd item) {
		if (item == null) {
			return null;
		} else {
			DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo vo = new DeveloppementDeSavoirEtInnovationScientifiqueInstrumentIrdVo();
			if (item.getId() != null)
				vo.setId(NumberUtil.toString(item.getId()));

			if (item.getInstrumentIrd() != null && this.instrumentIrd) {
				vo.setInstrumentIrdVo(instrumentIrdConverter.toVo(item.getInstrumentIrd()));
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
		instrumentIrd = value;
		developpementDeSavoirEtInnovationScientifique = value;
	}

	public DeveloppementDeSavoirEtInnovationScientifiqueConverter getDeveloppementDeSavoirEtInnovationScientifiqueConverter() {
		return this.developpementDeSavoirEtInnovationScientifiqueConverter;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifiqueConverter(
			DeveloppementDeSavoirEtInnovationScientifiqueConverter developpementDeSavoirEtInnovationScientifiqueConverter) {
		this.developpementDeSavoirEtInnovationScientifiqueConverter = developpementDeSavoirEtInnovationScientifiqueConverter;
	}

	public InstrumentIrdConverter getInstrumentIrdConverter() {
		return this.instrumentIrdConverter;
	}

	public void setInstrumentIrdConverter(InstrumentIrdConverter instrumentIrdConverter) {
		this.instrumentIrdConverter = instrumentIrdConverter;
	}

	public boolean isInstrumentIrd() {
		return this.instrumentIrd;
	}

	public void setInstrumentIrd(boolean instrumentIrd) {
		this.instrumentIrd = instrumentIrd;
	}

	public boolean isDeveloppementDeSavoirEtInnovationScientifique() {
		return this.developpementDeSavoirEtInnovationScientifique;
	}

	public void setDeveloppementDeSavoirEtInnovationScientifique(
			boolean developpementDeSavoirEtInnovationScientifique) {
		this.developpementDeSavoirEtInnovationScientifique = developpementDeSavoirEtInnovationScientifique;
	}

}

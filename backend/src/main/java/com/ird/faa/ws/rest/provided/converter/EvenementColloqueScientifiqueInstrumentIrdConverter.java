package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.bean.formulaire.EvenementColloqueScientifiqueInstrumentIrd;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.EvenementColloqueScientifiqueInstrumentIrdVo;

@Component
public class EvenementColloqueScientifiqueInstrumentIrdConverter extends
		AbstractConverter<EvenementColloqueScientifiqueInstrumentIrd, EvenementColloqueScientifiqueInstrumentIrdVo> {

	@Autowired
	private EvenementColloqueScienntifiqueConverter evenementColloqueScienntifiqueConverter;
	@Autowired
	private InstrumentIrdConverter instrumentIrdConverter;
	private Boolean evenementColloqueScienntifique;
	private Boolean instrumentIrd;

	public EvenementColloqueScientifiqueInstrumentIrdConverter() {
		init(true);
	}

	@Override
	public EvenementColloqueScientifiqueInstrumentIrd toItem(EvenementColloqueScientifiqueInstrumentIrdVo vo) {
		if (vo == null) {
			return null;
		} else {
			EvenementColloqueScientifiqueInstrumentIrd item = new EvenementColloqueScientifiqueInstrumentIrd();
			if (StringUtil.isNotEmpty(vo.getId()))
				item.setId(NumberUtil.toLong(vo.getId()));
			if (vo.getEvenementColloqueScienntifiqueVo() != null && this.evenementColloqueScienntifique)
				item.setEvenementColloqueScienntifique(
						evenementColloqueScienntifiqueConverter.toItem(vo.getEvenementColloqueScienntifiqueVo()));
			if (vo.getInstrumentIrdVo() != null && this.instrumentIrd)
				item.setInstrumentIrd(instrumentIrdConverter.toItem(vo.getInstrumentIrdVo()));

			return item;
		}
	}

	@Override
	public EvenementColloqueScientifiqueInstrumentIrdVo toVo(EvenementColloqueScientifiqueInstrumentIrd item) {
		if (item == null) {
			return null;
		} else {
			EvenementColloqueScientifiqueInstrumentIrdVo vo = new EvenementColloqueScientifiqueInstrumentIrdVo();
			if (item.getId() != null)
				vo.setId(NumberUtil.toString(item.getId()));

			if (item.getEvenementColloqueScienntifique() != null && this.evenementColloqueScienntifique) {
				vo.setEvenementColloqueScienntifiqueVo(
						evenementColloqueScienntifiqueConverter.toVo(item.getEvenementColloqueScienntifique()));
			}
			if (item.getInstrumentIrd() != null && this.instrumentIrd) {
				vo.setInstrumentIrdVo(instrumentIrdConverter.toVo(item.getInstrumentIrd()));
			}

			return vo;
		}
	}

	public void init(Boolean value) {
		evenementColloqueScienntifique = value;
		instrumentIrd = value;
	}

	public EvenementColloqueScienntifiqueConverter getEvenementColloqueScienntifiqueConverter() {
		return this.evenementColloqueScienntifiqueConverter;
	}

	public void setEvenementColloqueScienntifiqueConverter(
			EvenementColloqueScienntifiqueConverter evenementColloqueScienntifiqueConverter) {
		this.evenementColloqueScienntifiqueConverter = evenementColloqueScienntifiqueConverter;
	}

	public InstrumentIrdConverter getInstrumentIrdConverter() {
		return this.instrumentIrdConverter;
	}

	public void setInstrumentIrdConverter(InstrumentIrdConverter instrumentIrdConverter) {
		this.instrumentIrdConverter = instrumentIrdConverter;
	}

	public boolean isEvenementColloqueScienntifique() {
		return this.evenementColloqueScienntifique;
	}

	public void setEvenementColloqueScienntifique(boolean evenementColloqueScienntifique) {
		this.evenementColloqueScienntifique = evenementColloqueScienntifique;
	}

	public boolean isInstrumentIrd() {
		return this.instrumentIrd;
	}

	public void setInstrumentIrd(boolean instrumentIrd) {
		this.instrumentIrd = instrumentIrd;
	}

}

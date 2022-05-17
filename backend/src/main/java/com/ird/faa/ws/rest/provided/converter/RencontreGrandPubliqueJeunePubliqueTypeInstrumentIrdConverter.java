package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ird.faa.bean.formulaire.RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo;

@Component
public class RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter extends
		AbstractConverter<RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd, RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo> {

	@Autowired
	private RencontreGrandPubliqueJeunePubliqueConverter rencontreGrandPubliqueJeunePubliqueConverter;
	@Autowired
	private TypeInstrumentIrdConverter TypeInstrumentIrdConverter;
	private Boolean typeInstrumentIrd;
	private Boolean rencontreGrandPubliqueJeunePublique;

	public RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdConverter() {
		init(true);
	}

	@Override
	public RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd toItem(
			RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo vo) {
		if (vo == null) {
			return null;
		} else {
			RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd item = new RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd();
			if (StringUtil.isNotEmpty(vo.getId()))
				item.setId(NumberUtil.toLong(vo.getId()));
			if (vo.getTypeInstrumentIrdVo() != null && this.typeInstrumentIrd)
				item.setTypeInstrumentIrd(TypeInstrumentIrdConverter.toItem(vo.getTypeInstrumentIrdVo()));
			if (vo.getRencontreGrandPubliqueJeunePubliqueVo() != null && this.rencontreGrandPubliqueJeunePublique)
				item.setRencontreGrandPubliqueJeunePublique(rencontreGrandPubliqueJeunePubliqueConverter
						.toItem(vo.getRencontreGrandPubliqueJeunePubliqueVo()));

			return item;
		}
	}

	@Override
	public RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo toVo(
			RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrd item) {
		if (item == null) {
			return null;
		} else {
			RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo vo = new RencontreGrandPubliqueJeunePubliqueTypeInstrumentIrdVo();
			if (item.getId() != null)
				vo.setId(NumberUtil.toString(item.getId()));
			if (item.getTypeInstrumentIrd() != null && this.typeInstrumentIrd) {
				vo.setTypeInstrumentIrdVo(TypeInstrumentIrdConverter.toVo(item.getTypeInstrumentIrd()));
			}
			if (item.getRencontreGrandPubliqueJeunePublique() != null && this.rencontreGrandPubliqueJeunePublique) {
				vo.setRencontreGrandPubliqueJeunePubliqueVo(rencontreGrandPubliqueJeunePubliqueConverter
						.toVo(item.getRencontreGrandPubliqueJeunePublique()));
			}

			return vo;
		}
	}

	public void init(Boolean value) {
		typeInstrumentIrd = value;
		rencontreGrandPubliqueJeunePublique = value;
	}

	public RencontreGrandPubliqueJeunePubliqueConverter getRencontreGrandPubliqueJeunePubliqueConverter() {
		return this.rencontreGrandPubliqueJeunePubliqueConverter;
	}

	public void setRencontreGrandPubliqueJeunePubliqueConverter(
			RencontreGrandPubliqueJeunePubliqueConverter rencontreGrandPubliqueJeunePubliqueConverter) {
		this.rencontreGrandPubliqueJeunePubliqueConverter = rencontreGrandPubliqueJeunePubliqueConverter;
	}

	public TypeInstrumentIrdConverter getTypeInstrumentIrdConverter() {
		return this.TypeInstrumentIrdConverter;
	}

	public void setTypeInstrumentIrdConverter(TypeInstrumentIrdConverter TypeInstrumentIrdConverter) {
		this.TypeInstrumentIrdConverter = TypeInstrumentIrdConverter;
	}

	public boolean isTypeInstrumentIrd() {
		return this.typeInstrumentIrd;
	}

	public void setTypeInstrumentIrd(boolean TypeInstrumentIrd) {
		this.typeInstrumentIrd = TypeInstrumentIrd;
	}

	public boolean isRencontreGrandPubliqueJeunePublique() {
		return this.rencontreGrandPubliqueJeunePublique;
	}

	public void setRencontreGrandPubliqueJeunePublique(boolean rencontreGrandPubliqueJeunePublique) {
		this.rencontreGrandPubliqueJeunePublique = rencontreGrandPubliqueJeunePublique;
	}

}

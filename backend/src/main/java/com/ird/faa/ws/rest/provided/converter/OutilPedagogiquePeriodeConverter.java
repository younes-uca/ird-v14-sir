package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ird.faa.bean.formulaire.OutilPedagogiquePeriode;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.OutilPedagogiquePeriodeVo;

@Component
public class OutilPedagogiquePeriodeConverter
		extends AbstractConverter<OutilPedagogiquePeriode, OutilPedagogiquePeriodeVo> {

        @Autowired
	private OutilPedagogiqueConverter OutilPedagogiqueConverter;
	private Boolean OutilPedagogique;

public  OutilPedagogiquePeriodeConverter(){
init(true);
}

@Override
public OutilPedagogiquePeriode toItem(OutilPedagogiquePeriodeVo vo) {
if (vo == null) {
return null;
} else {
	OutilPedagogiquePeriode item = new OutilPedagogiquePeriode();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
	if (StringUtil.isNotEmpty(vo.getDateDiffusion()))
		item.setDateDiffusion(DateUtil.parse(vo.getDateDiffusion()));
	if (vo.getOutilPedagogiqueVo() != null && this.OutilPedagogique)
		item.setOutilPedagogique(OutilPedagogiqueConverter.toItem(vo.getOutilPedagogiqueVo()));


return item;
}
}

@Override
public OutilPedagogiquePeriodeVo toVo(OutilPedagogiquePeriode item) {
if (item == null) {
return null;
} else {
	OutilPedagogiquePeriodeVo vo = new OutilPedagogiquePeriodeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
	if (item.getDateDiffusion() != null)
		vo.setDateDiffusion(DateUtil.formateDate(item.getDateDiffusion()));
	if (item.getOutilPedagogique() != null && this.OutilPedagogique) {
		vo.setOutilPedagogiqueVo(OutilPedagogiqueConverter.toVo(item.getOutilPedagogique()));
    }

return vo;
}
}

public void init(Boolean value) {
	OutilPedagogique = value;
}


public OutilPedagogiqueConverter getOutilPedagogiqueConverter() {
	return this.OutilPedagogiqueConverter;
        }

public void setOutilPedagogiqueConverter(OutilPedagogiqueConverter OutilPedagogiqueConverter) {
	this.OutilPedagogiqueConverter = OutilPedagogiqueConverter;
        }

public boolean isOutilPedagogique() {
	return this.OutilPedagogique;
    }

public void setOutilPedagogique(boolean OutilPedagogique) {
	this.OutilPedagogique = OutilPedagogique;
    }






}

package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.Nationalite;
import com.ird.faa.ws.rest.provided.vo.NationaliteVo;

@Component
public class NationaliteConverter extends AbstractConverter<Nationalite,NationaliteVo>{


public  NationaliteConverter(){
init(true);
}

@Override
public Nationalite toItem(NationaliteVo vo) {
if (vo == null) {
return null;
} else {
Nationalite item = new Nationalite();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());


return item;
}
}

@Override
public NationaliteVo toVo(Nationalite item) {
if (item == null) {
return null;
} else {
NationaliteVo vo = new NationaliteVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());


return vo;
}
}

public void init(Boolean value) {
}









}

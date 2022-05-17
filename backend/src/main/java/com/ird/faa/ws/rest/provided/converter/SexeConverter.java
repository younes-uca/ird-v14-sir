package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.Sexe;
import com.ird.faa.ws.rest.provided.vo.SexeVo;

@Component
public class SexeConverter extends AbstractConverter<Sexe,SexeVo>{


public  SexeConverter(){
init(true);
}

@Override
public Sexe toItem(SexeVo vo) {
if (vo == null) {
return null;
} else {
Sexe item = new Sexe();
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
public SexeVo toVo(Sexe item) {
if (item == null) {
return null;
} else {
SexeVo vo = new SexeVo();
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

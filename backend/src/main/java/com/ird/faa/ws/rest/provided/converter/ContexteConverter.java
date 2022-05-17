package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.Contexte;
import com.ird.faa.ws.rest.provided.vo.ContexteVo;

@Component
public class ContexteConverter extends AbstractConverter<Contexte,ContexteVo>{


public  ContexteConverter(){
init(true);
}

@Override
public Contexte toItem(ContexteVo vo) {
if (vo == null) {
return null;
} else {
Contexte item = new Contexte();
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
public ContexteVo toVo(Contexte item) {
if (item == null) {
return null;
} else {
ContexteVo vo = new ContexteVo();
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

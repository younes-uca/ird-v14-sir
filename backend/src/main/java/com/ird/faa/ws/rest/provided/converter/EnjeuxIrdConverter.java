package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.EnjeuxIrd;
import com.ird.faa.ws.rest.provided.vo.EnjeuxIrdVo;

@Component
public class EnjeuxIrdConverter extends AbstractConverter<EnjeuxIrd,EnjeuxIrdVo>{


public  EnjeuxIrdConverter(){
init(true);
}

@Override
public EnjeuxIrd toItem(EnjeuxIrdVo vo) {
if (vo == null) {
return null;
} else {
EnjeuxIrd item = new EnjeuxIrd();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());


return item;
}
}

@Override
public EnjeuxIrdVo toVo(EnjeuxIrd item) {
if (item == null) {
return null;
} else {
EnjeuxIrdVo vo = new EnjeuxIrdVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());


return vo;
}
}

public void init(Boolean value) {
}











}

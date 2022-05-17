package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.TypeSavoir;
import com.ird.faa.ws.rest.provided.vo.TypeSavoirVo;

@Component
public class TypeSavoirConverter extends AbstractConverter<TypeSavoir,TypeSavoirVo>{


public  TypeSavoirConverter(){
init(true);
}

@Override
public TypeSavoir toItem(TypeSavoirVo vo) {
if (vo == null) {
return null;
} else {
TypeSavoir item = new TypeSavoir();
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
public TypeSavoirVo toVo(TypeSavoir item) {
if (item == null) {
return null;
} else {
TypeSavoirVo vo = new TypeSavoirVo();
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

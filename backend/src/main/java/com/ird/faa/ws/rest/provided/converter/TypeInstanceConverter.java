package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.TypeInstance;
import com.ird.faa.ws.rest.provided.vo.TypeInstanceVo;

@Component
public class TypeInstanceConverter extends AbstractConverter<TypeInstance,TypeInstanceVo>{


public  TypeInstanceConverter(){
init(true);
}

@Override
public TypeInstance toItem(TypeInstanceVo vo) {
if (vo == null) {
return null;
} else {
TypeInstance item = new TypeInstance();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());


return item;
}
}

@Override
public TypeInstanceVo toVo(TypeInstance item) {
if (item == null) {
return null;
} else {
TypeInstanceVo vo = new TypeInstanceVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());


return vo;
}
}

public void init(Boolean value) {
}









}

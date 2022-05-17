package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.TypeExpert;
import com.ird.faa.ws.rest.provided.vo.TypeExpertVo;

@Component
public class TypeExpertConverter extends AbstractConverter<TypeExpert,TypeExpertVo>{


public  TypeExpertConverter(){
init(true);
}

@Override
public TypeExpert toItem(TypeExpertVo vo) {
if (vo == null) {
return null;
} else {
TypeExpert item = new TypeExpert();
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
public TypeExpertVo toVo(TypeExpert item) {
if (item == null) {
return null;
} else {
TypeExpertVo vo = new TypeExpertVo();
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

package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.TypeExpertise;
import com.ird.faa.ws.rest.provided.vo.TypeExpertiseVo;

@Component
public class TypeExpertiseConverter extends AbstractConverter<TypeExpertise,TypeExpertiseVo>{


public  TypeExpertiseConverter(){
init(true);
}

@Override
public TypeExpertise toItem(TypeExpertiseVo vo) {
if (vo == null) {
return null;
} else {
TypeExpertise item = new TypeExpertise();
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
public TypeExpertiseVo toVo(TypeExpertise item) {
if (item == null) {
return null;
} else {
TypeExpertiseVo vo = new TypeExpertiseVo();
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

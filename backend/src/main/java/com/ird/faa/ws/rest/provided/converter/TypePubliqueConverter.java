package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.config.TypePublique;
import com.ird.faa.ws.rest.provided.vo.TypePubliqueVo;

@Component
public class TypePubliqueConverter extends AbstractConverter<TypePublique,TypePubliqueVo>{


public  TypePubliqueConverter(){
init(true);
}

@Override
public TypePublique toItem(TypePubliqueVo vo) {
if (vo == null) {
return null;
} else {
TypePublique item = new TypePublique();
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
public TypePubliqueVo toVo(TypePublique item) {
if (item == null) {
return null;
} else {
TypePubliqueVo vo = new TypePubliqueVo();
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

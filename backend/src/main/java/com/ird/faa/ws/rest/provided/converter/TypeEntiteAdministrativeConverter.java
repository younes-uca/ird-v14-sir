package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.TypeEntiteAdministrative;
import com.ird.faa.ws.rest.provided.vo.TypeEntiteAdministrativeVo;

@Component
public class TypeEntiteAdministrativeConverter extends AbstractConverter<TypeEntiteAdministrative,TypeEntiteAdministrativeVo>{


public  TypeEntiteAdministrativeConverter(){
init(true);
}

@Override
public TypeEntiteAdministrative toItem(TypeEntiteAdministrativeVo vo) {
if (vo == null) {
return null;
} else {
TypeEntiteAdministrative item = new TypeEntiteAdministrative();
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
public TypeEntiteAdministrativeVo toVo(TypeEntiteAdministrative item) {
if (item == null) {
return null;
} else {
TypeEntiteAdministrativeVo vo = new TypeEntiteAdministrativeVo();
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

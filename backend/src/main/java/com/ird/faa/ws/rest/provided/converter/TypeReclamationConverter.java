package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.TypeReclamation;
import com.ird.faa.ws.rest.provided.vo.TypeReclamationVo;

@Component
public class TypeReclamationConverter extends AbstractConverter<TypeReclamation,TypeReclamationVo>{


public  TypeReclamationConverter(){
init(true);
}

@Override
public TypeReclamation toItem(TypeReclamationVo vo) {
if (vo == null) {
return null;
} else {
TypeReclamation item = new TypeReclamation();
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
public TypeReclamationVo toVo(TypeReclamation item) {
if (item == null) {
return null;
} else {
TypeReclamationVo vo = new TypeReclamationVo();
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

package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.TypeOutil;
import com.ird.faa.ws.rest.provided.vo.TypeOutilVo;

@Component
public class TypeOutilConverter extends AbstractConverter<TypeOutil,TypeOutilVo>{


public  TypeOutilConverter(){
init(true);
}

@Override
public TypeOutil toItem(TypeOutilVo vo) {
if (vo == null) {
return null;
} else {
TypeOutil item = new TypeOutil();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(vo.getNumerique() != null)
        item.setNumerique(vo.getNumerique());


return item;
}
}

@Override
public TypeOutilVo toVo(TypeOutil item) {
if (item == null) {
return null;
} else {
TypeOutilVo vo = new TypeOutilVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());
        if(item.getNumerique()!=null)
         vo.setNumerique(item.getNumerique());

return vo;
}
}

public void init(Boolean value) {
}









}

package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.TypeParticipation;
import com.ird.faa.ws.rest.provided.vo.TypeParticipationVo;

@Component
public class TypeParticipationConverter extends AbstractConverter<TypeParticipation,TypeParticipationVo>{


public  TypeParticipationConverter(){
init(true);
}

@Override
public TypeParticipation toItem(TypeParticipationVo vo) {
if (vo == null) {
return null;
} else {
TypeParticipation item = new TypeParticipation();
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
public TypeParticipationVo toVo(TypeParticipation item) {
if (item == null) {
return null;
} else {
TypeParticipationVo vo = new TypeParticipationVo();
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

package main.java.com.ird.faa.ws.rest.provided.converter.referentiel;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.TypeEnseignementDispense;
import main.java.com.ird.faa.ws.rest.provided.vo.referentiel.TypeEnseignementDispenseVo;

@Component
public class TypeEnseignementDispenseConverter extends AbstractConverter<TypeEnseignementDispense,TypeEnseignementDispenseVo>{


public  TypeEnseignementDispenseConverter(){
init(true);
}

@Override
public TypeEnseignementDispense toItem(TypeEnseignementDispenseVo vo) {
if (vo == null) {
return null;
} else {
TypeEnseignementDispense item = new TypeEnseignementDispense();
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
public TypeEnseignementDispenseVo toVo(TypeEnseignementDispense item) {
if (item == null) {
return null;
} else {
TypeEnseignementDispenseVo vo = new TypeEnseignementDispenseVo();
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

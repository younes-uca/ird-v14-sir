package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.NiveauFormation;
import com.ird.faa.ws.rest.provided.vo.NiveauFormationVo;

@Component
public class NiveauFormationConverter extends AbstractConverter<NiveauFormation,NiveauFormationVo>{


public  NiveauFormationConverter(){
init(true);
}

@Override
public NiveauFormation toItem(NiveauFormationVo vo) {
if (vo == null) {
return null;
} else {
NiveauFormation item = new NiveauFormation();
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
public NiveauFormationVo toVo(NiveauFormation item) {
if (item == null) {
return null;
} else {
NiveauFormationVo vo = new NiveauFormationVo();
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

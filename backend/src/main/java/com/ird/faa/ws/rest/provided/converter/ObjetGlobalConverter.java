package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.ObjetGlobal;
import com.ird.faa.ws.rest.provided.vo.ObjetGlobalVo;

@Component
public class ObjetGlobalConverter extends AbstractConverter<ObjetGlobal,ObjetGlobalVo>{


public  ObjetGlobalConverter(){
init(true);
}

@Override
public ObjetGlobal toItem(ObjetGlobalVo vo) {
if (vo == null) {
return null;
} else {
ObjetGlobal item = new ObjetGlobal();
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
public ObjetGlobalVo toVo(ObjetGlobal item) {
if (item == null) {
return null;
} else {
ObjetGlobalVo vo = new ObjetGlobalVo();
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

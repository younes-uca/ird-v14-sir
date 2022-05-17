package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.NatureEtude;
import com.ird.faa.ws.rest.provided.vo.NatureEtudeVo;

@Component
public class NatureEtudeConverter extends AbstractConverter<NatureEtude,NatureEtudeVo>{


public  NatureEtudeConverter(){
init(true);
}

@Override
public NatureEtude toItem(NatureEtudeVo vo) {
if (vo == null) {
return null;
} else {
NatureEtude item = new NatureEtude();
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
public NatureEtudeVo toVo(NatureEtude item) {
if (item == null) {
return null;
} else {
NatureEtudeVo vo = new NatureEtudeVo();
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

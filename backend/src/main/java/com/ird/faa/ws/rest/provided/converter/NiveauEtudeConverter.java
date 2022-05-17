package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.NiveauEtude;
import com.ird.faa.ws.rest.provided.vo.NiveauEtudeVo;

@Component
public class NiveauEtudeConverter extends AbstractConverter<NiveauEtude,NiveauEtudeVo>{


public  NiveauEtudeConverter(){
init(true);
}

@Override
public NiveauEtude toItem(NiveauEtudeVo vo) {
if (vo == null) {
return null;
} else {
NiveauEtude item = new NiveauEtude();
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
public NiveauEtudeVo toVo(NiveauEtude item) {
if (item == null) {
return null;
} else {
NiveauEtudeVo vo = new NiveauEtudeVo();
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

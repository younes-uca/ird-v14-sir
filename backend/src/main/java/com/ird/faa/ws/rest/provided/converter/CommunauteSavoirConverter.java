package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.CommunauteSavoir;
import com.ird.faa.ws.rest.provided.vo.CommunauteSavoirVo;

@Component
public class CommunauteSavoirConverter extends AbstractConverter<CommunauteSavoir,CommunauteSavoirVo>{


public  CommunauteSavoirConverter(){
init(true);
}

@Override
public CommunauteSavoir toItem(CommunauteSavoirVo vo) {
if (vo == null) {
return null;
} else {
CommunauteSavoir item = new CommunauteSavoir();
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
public CommunauteSavoirVo toVo(CommunauteSavoir item) {
if (item == null) {
return null;
} else {
CommunauteSavoirVo vo = new CommunauteSavoirVo();
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

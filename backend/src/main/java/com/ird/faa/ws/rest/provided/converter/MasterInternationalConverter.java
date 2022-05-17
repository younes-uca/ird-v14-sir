package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.MasterInternational;
import com.ird.faa.ws.rest.provided.vo.MasterInternationalVo;

@Component
public class MasterInternationalConverter extends AbstractConverter<MasterInternational,MasterInternationalVo>{


public  MasterInternationalConverter(){
init(true);
}

@Override
public MasterInternational toItem(MasterInternationalVo vo) {
if (vo == null) {
return null;
} else {
MasterInternational item = new MasterInternational();
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
public MasterInternationalVo toVo(MasterInternational item) {
if (item == null) {
return null;
} else {
MasterInternationalVo vo = new MasterInternationalVo();
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

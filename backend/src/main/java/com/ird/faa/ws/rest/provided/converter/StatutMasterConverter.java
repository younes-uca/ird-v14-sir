package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.StatutMaster;
import com.ird.faa.ws.rest.provided.vo.StatutMasterVo;

@Component
public class StatutMasterConverter extends AbstractConverter<StatutMaster,StatutMasterVo>{


public  StatutMasterConverter(){
init(true);
}

@Override
public StatutMaster toItem(StatutMasterVo vo) {
if (vo == null) {
return null;
} else {
StatutMaster item = new StatutMaster();
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
public StatutMasterVo toVo(StatutMaster item) {
if (item == null) {
return null;
} else {
StatutMasterVo vo = new StatutMasterVo();
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

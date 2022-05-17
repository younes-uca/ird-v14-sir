package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.OutilFormationContinue;
import com.ird.faa.ws.rest.provided.vo.OutilFormationContinueVo;

@Component
public class OutilFormationContinueConverter extends AbstractConverter<OutilFormationContinue,OutilFormationContinueVo>{


public  OutilFormationContinueConverter(){
init(true);
}

@Override
public OutilFormationContinue toItem(OutilFormationContinueVo vo) {
if (vo == null) {
return null;
} else {
OutilFormationContinue item = new OutilFormationContinue();
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
public OutilFormationContinueVo toVo(OutilFormationContinue item) {
if (item == null) {
return null;
} else {
OutilFormationContinueVo vo = new OutilFormationContinueVo();
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

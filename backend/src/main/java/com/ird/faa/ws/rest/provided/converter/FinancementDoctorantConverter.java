package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.FinancementDoctorant;
import com.ird.faa.ws.rest.provided.vo.FinancementDoctorantVo;

@Component
public class FinancementDoctorantConverter extends AbstractConverter<FinancementDoctorant,FinancementDoctorantVo>{


public  FinancementDoctorantConverter(){
init(true);
}

@Override
public FinancementDoctorant toItem(FinancementDoctorantVo vo) {
if (vo == null) {
return null;
} else {
FinancementDoctorant item = new FinancementDoctorant();
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
public FinancementDoctorantVo toVo(FinancementDoctorant item) {
if (item == null) {
return null;
} else {
FinancementDoctorantVo vo = new FinancementDoctorantVo();
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

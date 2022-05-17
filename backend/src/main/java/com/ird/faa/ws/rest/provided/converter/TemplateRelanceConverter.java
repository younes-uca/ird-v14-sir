package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.TemplateRelance;
import com.ird.faa.ws.rest.provided.vo.TemplateRelanceVo;

@Component
public class TemplateRelanceConverter extends AbstractConverter<TemplateRelance,TemplateRelanceVo>{


public  TemplateRelanceConverter(){
init(true);
}

@Override
public TemplateRelance toItem(TemplateRelanceVo vo) {
if (vo == null) {
return null;
} else {
TemplateRelance item = new TemplateRelance();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getObjet()))
        item.setObjet(vo.getObjet());
        if(StringUtil.isNotEmpty(vo.getMessage()))
        item.setMessage(vo.getMessage());


return item;
}
}

@Override
public TemplateRelanceVo toVo(TemplateRelance item) {
if (item == null) {
return null;
} else {
TemplateRelanceVo vo = new TemplateRelanceVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getObjet()))
        vo.setObjet(item.getObjet());

        if(StringUtil.isNotEmpty(item.getMessage()))
        vo.setMessage(item.getMessage());


return vo;
}
}

public void init(Boolean value) {
}











}

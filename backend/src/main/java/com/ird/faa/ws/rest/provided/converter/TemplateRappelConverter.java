package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.TemplateRappel;
import com.ird.faa.ws.rest.provided.vo.TemplateRappelVo;

@Component
public class TemplateRappelConverter extends AbstractConverter<TemplateRappel,TemplateRappelVo>{


public  TemplateRappelConverter(){
init(true);
}

@Override
public TemplateRappel toItem(TemplateRappelVo vo) {
if (vo == null) {
return null;
} else {
TemplateRappel item = new TemplateRappel();
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
public TemplateRappelVo toVo(TemplateRappel item) {
if (item == null) {
return null;
} else {
TemplateRappelVo vo = new TemplateRappelVo();
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

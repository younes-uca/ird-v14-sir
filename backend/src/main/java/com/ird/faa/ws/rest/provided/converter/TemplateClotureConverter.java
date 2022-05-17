package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.TemplateCloture;
import com.ird.faa.ws.rest.provided.vo.TemplateClotureVo;

@Component
public class TemplateClotureConverter extends AbstractConverter<TemplateCloture,TemplateClotureVo>{


public  TemplateClotureConverter(){
init(true);
}

@Override
public TemplateCloture toItem(TemplateClotureVo vo) {
if (vo == null) {
return null;
} else {
TemplateCloture item = new TemplateCloture();
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
public TemplateClotureVo toVo(TemplateCloture item) {
if (item == null) {
return null;
} else {
TemplateClotureVo vo = new TemplateClotureVo();
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

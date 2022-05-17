package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.TemplateOuverture;
import com.ird.faa.ws.rest.provided.vo.TemplateOuvertureVo;

@Component
public class TemplateOuvertureConverter extends AbstractConverter<TemplateOuverture,TemplateOuvertureVo>{


public  TemplateOuvertureConverter(){
init(true);
}

@Override
public TemplateOuverture toItem(TemplateOuvertureVo vo) {
if (vo == null) {
return null;
} else {
TemplateOuverture item = new TemplateOuverture();
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
public TemplateOuvertureVo toVo(TemplateOuverture item) {
if (item == null) {
return null;
} else {
TemplateOuvertureVo vo = new TemplateOuvertureVo();
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

package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.PublicCible;
import com.ird.faa.ws.rest.provided.vo.PublicCibleVo;

@Component
public class PublicCibleConverter extends AbstractConverter<PublicCible,PublicCibleVo>{


public  PublicCibleConverter(){
init(true);
}

@Override
public PublicCible toItem(PublicCibleVo vo) {
if (vo == null) {
return null;
} else {
PublicCible item = new PublicCible();
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
public PublicCibleVo toVo(PublicCible item) {
if (item == null) {
return null;
} else {
PublicCibleVo vo = new PublicCibleVo();
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

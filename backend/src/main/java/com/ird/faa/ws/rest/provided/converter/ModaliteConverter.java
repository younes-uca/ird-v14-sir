package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.Modalite;
import com.ird.faa.ws.rest.provided.vo.ModaliteVo;

@Component
public class ModaliteConverter extends AbstractConverter<Modalite,ModaliteVo>{


public  ModaliteConverter(){
init(true);
}

@Override
public Modalite toItem(ModaliteVo vo) {
if (vo == null) {
return null;
} else {
Modalite item = new Modalite();
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
public ModaliteVo toVo(Modalite item) {
if (item == null) {
return null;
} else {
ModaliteVo vo = new ModaliteVo();
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

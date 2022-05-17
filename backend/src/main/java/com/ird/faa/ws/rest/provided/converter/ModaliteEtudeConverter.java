package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.ModaliteEtude;
import com.ird.faa.ws.rest.provided.vo.ModaliteEtudeVo;

@Component
public class ModaliteEtudeConverter extends AbstractConverter<ModaliteEtude,ModaliteEtudeVo>{


public  ModaliteEtudeConverter(){
init(true);
}

@Override
public ModaliteEtude toItem(ModaliteEtudeVo vo) {
if (vo == null) {
return null;
} else {
ModaliteEtude item = new ModaliteEtude();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());


return item;
}
}

@Override
public ModaliteEtudeVo toVo(ModaliteEtude item) {
if (item == null) {
return null;
} else {
ModaliteEtudeVo vo = new ModaliteEtudeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());


return vo;
}
}

public void init(Boolean value) {
}











}

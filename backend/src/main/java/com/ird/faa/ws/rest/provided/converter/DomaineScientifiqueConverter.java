package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.DomaineScientifique;
import com.ird.faa.ws.rest.provided.vo.DomaineScientifiqueVo;

@Component
public class DomaineScientifiqueConverter extends AbstractConverter<DomaineScientifique,DomaineScientifiqueVo>{


public  DomaineScientifiqueConverter(){
init(true);
}

@Override
public DomaineScientifique toItem(DomaineScientifiqueVo vo) {
if (vo == null) {
return null;
} else {
DomaineScientifique item = new DomaineScientifique();
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
public DomaineScientifiqueVo toVo(DomaineScientifique item) {
if (item == null) {
return null;
} else {
DomaineScientifiqueVo vo = new DomaineScientifiqueVo();
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

package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.Institution;
import com.ird.faa.ws.rest.provided.vo.InstitutionVo;

@Component
public class InstitutionConverter extends AbstractConverter<Institution,InstitutionVo>{


public  InstitutionConverter(){
init(true);
}

@Override
public Institution toItem(InstitutionVo vo) {
if (vo == null) {
return null;
} else {
Institution item = new Institution();
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
public InstitutionVo toVo(Institution item) {
if (item == null) {
return null;
} else {
InstitutionVo vo = new InstitutionVo();
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

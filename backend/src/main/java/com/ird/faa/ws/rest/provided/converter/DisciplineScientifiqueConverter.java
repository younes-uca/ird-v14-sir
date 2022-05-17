package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.DisciplineScientifique;
import com.ird.faa.ws.rest.provided.vo.DisciplineScientifiqueVo;

@Component
public class DisciplineScientifiqueConverter extends AbstractConverter<DisciplineScientifique,DisciplineScientifiqueVo>{


public  DisciplineScientifiqueConverter(){
init(true);
}

@Override
public DisciplineScientifique toItem(DisciplineScientifiqueVo vo) {
if (vo == null) {
return null;
} else {
DisciplineScientifique item = new DisciplineScientifique();
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
public DisciplineScientifiqueVo toVo(DisciplineScientifique item) {
if (item == null) {
return null;
} else {
DisciplineScientifiqueVo vo = new DisciplineScientifiqueVo();
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

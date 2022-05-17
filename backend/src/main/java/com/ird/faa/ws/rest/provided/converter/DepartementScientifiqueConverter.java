package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.DepartementScientifique;
import com.ird.faa.ws.rest.provided.vo.DepartementScientifiqueVo;

@Component
public class DepartementScientifiqueConverter extends AbstractConverter<DepartementScientifique,DepartementScientifiqueVo>{


public  DepartementScientifiqueConverter(){
init(true);
}

@Override
public DepartementScientifique toItem(DepartementScientifiqueVo vo) {
if (vo == null) {
return null;
} else {
DepartementScientifique item = new DepartementScientifique();
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
public DepartementScientifiqueVo toVo(DepartementScientifique item) {
if (item == null) {
return null;
} else {
DepartementScientifiqueVo vo = new DepartementScientifiqueVo();
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

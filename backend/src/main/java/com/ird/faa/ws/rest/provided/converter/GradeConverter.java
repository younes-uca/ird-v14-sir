package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.Grade;
import com.ird.faa.ws.rest.provided.vo.GradeVo;

@Component
public class GradeConverter extends AbstractConverter<Grade,GradeVo>{


public  GradeConverter(){
init(true);
}

@Override
public Grade toItem(GradeVo vo) {
if (vo == null) {
return null;
} else {
Grade item = new Grade();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getIdGraph()))
        item.setIdGraph(vo.getIdGraph());


return item;
}
}

@Override
public GradeVo toVo(Grade item) {
if (item == null) {
return null;
} else {
GradeVo vo = new GradeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());
        if(StringUtil.isNotEmpty(item.getIdGraph()))
        vo.setIdGraph(item.getIdGraph());


return vo;
}
}

public void init(Boolean value) {
}











}

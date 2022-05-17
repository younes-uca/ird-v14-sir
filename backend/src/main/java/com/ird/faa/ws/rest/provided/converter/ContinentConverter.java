package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.referentiel.Continent;
import com.ird.faa.ws.rest.provided.vo.ContinentVo;

@Component
public class ContinentConverter extends AbstractConverter<Continent,ContinentVo>{


public  ContinentConverter(){
init(true);
}

@Override
public Continent toItem(ContinentVo vo) {
if (vo == null) {
return null;
} else {
Continent item = new Continent();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        /*TODO : added fields */
        if(StringUtil.isNotEmpty(vo.getIdGraph()))
        item.setIdGraph(vo.getIdGraph());
        /*TODO :fin added fields */


return item;
}
}

@Override
public ContinentVo toVo(Continent item) {
if (item == null) {
return null;
} else {
ContinentVo vo = new ContinentVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());
        /*TODO : added fields */
        if(StringUtil.isNotEmpty(item.getIdGraph()))
        vo.setIdGraph(item.getIdGraph());
        /*TODO :fin added fields */



return vo;
}
}

public void init(Boolean value) {
}









}
